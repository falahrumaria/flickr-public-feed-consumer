package id.rumaria.service.flickrpublicfeedconsumer.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import id.rumaria.service.flickrpublicfeedconsumer.model.FlickrFeedResponse;
import java.net.URI;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@Service
@RequiredArgsConstructor
public class PublicFeedService {

  private final Logger log = LoggerFactory.getLogger(this.getClass());
  private final RestTemplate restTemplate;
  private final ObjectMapper objectMapper;
  private final Gson gson;

  public void pullData() {
    String url = "https://api.flickr.com/services/feeds/photos_public.gne";
    final URI uri = UriComponentsBuilder
        .fromUriString(url)
        .queryParam("format", "json").build().toUri();
    final String response = restTemplate.getForObject(uri, String.class);
    String validJsonResponse = response.substring(15, response.length() - 1);
    FlickrFeedResponse feedResponse = gson.fromJson(validJsonResponse, FlickrFeedResponse.class);
    log.info("cek value : {}", feedResponse.getTitle());
    log.info("cek value : {}", feedResponse.getLink());
    log.info("cek value : {}", feedResponse.getItems().get(0).getMediaUrl());
    log.info("sukses");
  }
}
