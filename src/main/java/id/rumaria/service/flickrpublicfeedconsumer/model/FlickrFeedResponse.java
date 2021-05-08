package id.rumaria.service.flickrpublicfeedconsumer.model;

import java.util.Date;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class FlickrFeedResponse {

  private String title;
  private String link;
  private String description;
  private Date modified;
  private String generator;
  private List<FlickrPostModel> items;
}
