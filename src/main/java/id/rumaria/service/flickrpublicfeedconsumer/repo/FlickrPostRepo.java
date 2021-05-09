package id.rumaria.service.flickrpublicfeedconsumer.repo;

import id.rumaria.service.flickrpublicfeedconsumer.data.FlickrPostEntity;
import java.util.Date;
import java.util.List;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FlickrPostRepo extends CrudRepository<FlickrPostEntity, Integer> {

  List<FlickrPostEntity> findAllByTagsContains(String tag, Pageable pageable);

  @Query(value = "select * from flickr_post_tbl "
      + "where date_trunc('month', date_taken) = ?1 "
      + "and tags like '%?2%'", nativeQuery = true)
  List<FlickrPostEntity> findAllByDate(Date date, String tag, Pageable pageable);
}
