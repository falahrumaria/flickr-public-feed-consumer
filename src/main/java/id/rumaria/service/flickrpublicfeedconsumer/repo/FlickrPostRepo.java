package id.rumaria.service.flickrpublicfeedconsumer.repo;

import id.rumaria.service.flickrpublicfeedconsumer.data.FlickrPostEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FlickrPostRepo extends CrudRepository<FlickrPostEntity, Integer> {

}
