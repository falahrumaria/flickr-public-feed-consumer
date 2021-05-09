package id.rumaria.service.flickrpublicfeedconsumer.model;

import java.util.Date;
import java.util.Map;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class FlickrPostModel {

  private String title;
  private String link;

  @Getter(AccessLevel.NONE)
  @Setter(AccessLevel.NONE)
  private Map<String, String> media;

  @Getter(AccessLevel.NONE)
  @Setter(AccessLevel.NONE)
  private Date date_taken;

  private String description;
  private Date published;
  private String author;

  @Getter(AccessLevel.NONE)
  @Setter(AccessLevel.NONE)
  private String author_id;

  private String tags;

  public String getMediaUrl() {
    return media.get("m");
  }

  public Date getDateTaken() {
    return date_taken;
  }

  public String getAuthorId() {
    return author_id;
  }
}
