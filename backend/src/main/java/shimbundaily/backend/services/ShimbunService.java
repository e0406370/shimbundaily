package shimbundaily.backend.services;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import shimbundaily.backend.models.ShimbunLanguage;
import shimbundaily.backend.models.ShimbunQuery;
import shimbundaily.backend.models.ShimbunCountry;
import shimbundaily.backend.utility.Constants;

@Service
public class ShimbunService {

  @Value("${shimbun.api.url}")
  private String SHIMBUN_API_URL;

  @Value("${shimbun.api.token}")
  private String SHIMBUN_API_TOKEN;

  private RestTemplate restTemplate = new RestTemplate();

  // related endpoint: GET /latest-news
  public String getLatestNews(String languageName) {

    UriComponentsBuilder builder = UriComponentsBuilder
        .fromUriString(SHIMBUN_API_URL)
        .path(Constants.SHIMBUN_API_ENDPOINT_LATESTNEWS);

    if (!languageName.isEmpty()) {
      builder.queryParam(Constants.SHIMBUN_API_QUERYPARAM_LANGUAGE, ShimbunLanguage.getLanguageCode(languageName));
    }

    RequestEntity<Void> request = RequestEntity
        .get(builder.toUriString())
        .header(Constants.SHIMBUN_API_HEADER_AUTHORIZATION, SHIMBUN_API_TOKEN)
        .build();

    ResponseEntity<String> response = restTemplate.exchange(request, String.class);

    return response.getBody();
  }

  // related endpoint: GET /search
  public String getNewsBySearch(ShimbunQuery query) {

    UriComponentsBuilder builder = UriComponentsBuilder
        .fromUriString(SHIMBUN_API_URL)
        .path(Constants.SHIMBUN_API_ENDPOINT_SEARCH);

    if (query.getCategory() != null && !query.getCategory().isEmpty()) {
      builder.queryParam(Constants.SHIMBUN_API_QUERYPARAM_CATEGORY, query.getCategory());
    }
    if (query.getCountry() != null && !query.getCountry().isEmpty()) {
      builder.queryParam(Constants.SHIMBUN_API_QUERYPARAM_COUNTRY, ShimbunCountry.getCountryCode(query.getCountry()));
    }
    if (query.getLanguage() != null && !query.getLanguage().isEmpty()) {
      builder.queryParam(Constants.SHIMBUN_API_QUERYPARAM_LANGUAGE, ShimbunLanguage.getLanguageCode(query.getLanguage()));
    }
    if (query.getStartDate() != null && !query.getStartDate().isEmpty()) {
      builder.queryParam(Constants.SHIMBUN_API_QUERYPARAM_STARTDATE, query.getStartDate());
    }
    if (query.getEndDate() != null && !query.getEndDate().isEmpty()) {
      builder.queryParam(Constants.SHIMBUN_API_QUERYPARAM_ENDDATE, query.getEndDate());
    }

    RequestEntity<Void> request = RequestEntity
        .get(builder.toUriString())
        .header(Constants.SHIMBUN_API_HEADER_AUTHORIZATION, SHIMBUN_API_TOKEN)
        .build();

    ResponseEntity<String> response = restTemplate.exchange(request, String.class);

    return response.getBody();
  }
}
