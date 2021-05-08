package id.rumaria.service.flickrpublicfeedconsumer.controller;

import id.rumaria.service.flickrpublicfeedconsumer.service.PublicFeedService;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("flickr/feed/")
@RequiredArgsConstructor
public class PublicFeedCtrl {

  private final PublicFeedService publicFeedService;

  @GetMapping("all")
  @Scheduled(cron = "0 0 8,11,14,17,20 * * *")
  public String pullFeeds() {
    // TODO: 5/8/21 pull data from flickr public feed
    publicFeedService.pullData();
    return "pass";
  }
}
