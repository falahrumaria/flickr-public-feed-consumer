package id.rumaria.service.flickrpublicfeedconsumer.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Date;
import java.util.Map;
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
  private String mediaUrl;
  @JsonProperty("date_taken")
  private Date dateTaken;
  private String description;
  private Date published;
  private String author;
  @JsonProperty("author_id")
  private String authorId;
  private String tags;

  @JsonProperty("media")
  private void unpackNameFromNestedObject(Map<String, String> media) {
    mediaUrl = media.get("m");
  }
}
