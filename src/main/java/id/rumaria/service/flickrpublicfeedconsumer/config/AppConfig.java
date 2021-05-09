package id.rumaria.service.flickrpublicfeedconsumer.config;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

@Configuration
public class AppConfig {

  @Value("${service.request.timeout.ms}")
  private int requestTimeout;

  @Value("${service.connect.timeout.ms}")
  private int connectTimeout;

  @Bean
  public RestTemplate restTemplate() {
    SimpleClientHttpRequestFactory simpleClientHttpRequestFactory = new SimpleClientHttpRequestFactory();
    simpleClientHttpRequestFactory.setConnectTimeout(connectTimeout);
    simpleClientHttpRequestFactory.setReadTimeout(requestTimeout);
    return new RestTemplate(simpleClientHttpRequestFactory);
  }

}
