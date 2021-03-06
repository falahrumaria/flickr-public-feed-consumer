package id.rumaria.service.flickrpublicfeedconsumer.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import id.rumaria.service.flickrpublicfeedconsumer.data.FlickrPostEntity;
import id.rumaria.service.flickrpublicfeedconsumer.model.FlickrFeedResponse;
import id.rumaria.service.flickrpublicfeedconsumer.model.FlickrPostModel;
import id.rumaria.service.flickrpublicfeedconsumer.model.FlickrPostResponse;
import id.rumaria.service.flickrpublicfeedconsumer.repo.FlickrPostRepo;
import java.net.URI;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@Service
@RequiredArgsConstructor
public class PublicFeedService {

  private final Logger log = LoggerFactory.getLogger(this.getClass());
  private final RestTemplate restTemplate;
  private final ObjectMapper objectMapper;
  private final FlickrPostRepo flickrPostRepo;
  private final Gson gson;

  public void pullFeedsAndPersist() {
    log.info("start pull data");
    String url = "https://api.flickr.com/services/feeds/photos_public.gne";
    final URI uri = UriComponentsBuilder
        .fromUriString(url)
        .queryParam("format", "json").build().toUri();
    final String response = restTemplate.getForObject(uri, String.class);
    String validJsonResponse = response.substring(15, response.length() - 1);
    FlickrFeedResponse feedResponse = gson.fromJson(validJsonResponse, FlickrFeedResponse.class);
    final List<FlickrPostModel> flickrPostModelList = feedResponse.getItems();
    Date today = new Date();
    final Set<FlickrPostEntity> flickrPostEntities = flickrPostModelList.stream()
        .map(model -> FlickrPostEntity.builder()
            .title(model.getTitle())
            .link(model.getLink())
            .mediaUrl(model.getMediaUrl())
            .dateTaken(model.getDateTaken())
            .description(model.getDescription())
            .published(model.getPublished())
            .author(model.getAuthor())
            .authorId(model.getAuthorId())
            .tags(model.getTags())
            .pulledDate(today)
            .build())
        .collect(Collectors.toSet());
    log.info("persist pulled data");
    flickrPostRepo.saveAll(flickrPostEntities);
    log.info("success persisting data, total {}", flickrPostEntities.size());
  }

  public Set<FlickrPostResponse> get(Integer month, Integer year, String tag, int page, int limit) {
    final PageRequest pageRequest = PageRequest.of(page, limit);
    List<FlickrPostEntity> resultList;
    if (month != null && year != null) {
      resultList = flickrPostRepo.findAllByMonthAndYear(year, month, tag, pageRequest);
    } else if (month != null) {
      resultList = flickrPostRepo.findAllByMonth(month, tag, pageRequest);
    } else if (year != null) {
      resultList = flickrPostRepo.findAllByYear(year, tag, pageRequest);
    } else {
      resultList = flickrPostRepo
          .findAllByTagsContains(tag, pageRequest);
    }
    return resultList.stream().map(e -> FlickrPostResponse.builder()
        .title(e.getTitle())
        .link(e.getLink())
        .mediaUrl(e.getMediaUrl())
        .dateTaken(e.getDateTaken())
        .description(e.getDescription())
        .published(e.getPublished())
        .author(e.getAuthor())
        .authorId(e.getAuthorId())
        .tags(e.getTags())
        .build())
        .collect(Collectors.toSet());
  }
}
