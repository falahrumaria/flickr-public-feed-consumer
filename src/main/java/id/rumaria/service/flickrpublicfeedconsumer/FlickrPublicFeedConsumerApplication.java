package id.rumaria.service.flickrpublicfeedconsumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class FlickrPublicFeedConsumerApplication {

	public static void main(String[] args) {
		SpringApplication.run(FlickrPublicFeedConsumerApplication.class, args);
	}

}
