package id.rumaria.service.flickrpublicfeedconsumer.model;

import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FlickrPostResponse {

  private String title;
  private String link;
  private String mediaUrl;
  private Date dateTaken;
  private String description;
  private Date published;
  private String author;
  private String authorId;
  private String tags;
}
