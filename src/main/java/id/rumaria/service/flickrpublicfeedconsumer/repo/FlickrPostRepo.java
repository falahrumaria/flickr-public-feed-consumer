package id.rumaria.service.flickrpublicfeedconsumer.repo;

import id.rumaria.service.flickrpublicfeedconsumer.data.FlickrPostEntity;
import java.util.List;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FlickrPostRepo extends CrudRepository<FlickrPostEntity, Integer> {

  List<FlickrPostEntity> findAllByTagsContains(String tag, Pageable pageable);

  @Query(value = "select * from flickr_post_tbl "
      + "where date_part('year', date_taken) = ?1 "
      + "and date_part('month', date_taken) = ?2 "
      + "and tags like %?3%", nativeQuery = true)
  List<FlickrPostEntity> findAllByMonthAndYear(int year, int month, String tag, Pageable pageable);

  @Query(value = "select * from flickr_post_tbl "
      + "where date_part('month', date_taken) = ?1 "
      + "and tags like %?2%", nativeQuery = true)
  List<FlickrPostEntity> findAllByMonth(int month, String tag, Pageable pageable);

  @Query(value = "select * from flickr_post_tbl "
      + "where date_part('year', date_taken) = ?1 "
      + "and tags like %?2%", nativeQuery = true)
  List<FlickrPostEntity> findAllByYear(int year, String tag, Pageable pageable);
}
