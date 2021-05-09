package id.rumaria.service.flickrpublicfeedconsumer.controller;

import id.rumaria.service.flickrpublicfeedconsumer.model.FlickrPostResponse;
import id.rumaria.service.flickrpublicfeedconsumer.service.PublicFeedService;
import java.util.Set;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("flickr/public-feeds/users-post")
@RequiredArgsConstructor
public class PublicFeedCtrl {

  private final PublicFeedService publicFeedService;

  @PostMapping
  @Scheduled(cron = "0 0 8,11,14,17,20 * * *")
  public String pullFeedsAndPersist() {
    publicFeedService.pullFeedsAndPersist();
    return "pass";
  }

  @GetMapping
  public Set<FlickrPostResponse> get(@RequestParam(required = false) int month,
      @RequestParam(required = false) int year, @RequestParam(required = false) String tag,
      @RequestParam int page, @RequestParam int limit) {
    return publicFeedService.get(month, year, tag, page, limit);
  }
}
