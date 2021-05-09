package id.rumaria.service.flickrpublicfeedconsumer.data;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "flickr_post_tbl")
public class FlickrPostEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Integer id;
  @Column
  private String title;
  @Column
  private String link;
  @Column(name = "media_url")
  private String mediaUrl;
  @Column(name = "date_taken")
  private Date dateTaken;
  @Column
  private String description;
  @Column
  private Date published;
  @Column
  private String author;
  @Column(name = "author_id")
  private String authorId;
  @Column
  private String tags;
  @Column
  private Date pulledDate;
}
