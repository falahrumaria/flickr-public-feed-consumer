package id.rumaria.service.flickrpublicfeedconsumer.repo;

import id.rumaria.service.flickrpublicfeedconsumer.data.FlickrPostEntity;
import java.util.List;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FlickrPostRepo extends CrudRepository<FlickrPostEntity, Integer> {

  public List<FlickrPostEntity> findAllByTagLike(String tag, Pageable pageable);
}
