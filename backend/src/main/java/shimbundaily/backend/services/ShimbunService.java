package shimbundaily.backend.services;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import shimbundaily.backend.models.ShimbunLanguage;
import shimbundaily.backend.models.ShimbunQuery;
import shimbundaily.backend.models.ShimbunRegion;
import shimbundaily.backend.utility.Constants;

@Service
public class ShimbunService {

  @Value("${shimbun.api.url}")
  private String SHIMBUN_API_URL;

  @Value("${shimbun.api.token}")
  private String SHIMBUN_API_TOKEN;

  private RestTemplate restTemplate = new RestTemplate();

  // related endpoint: GET /latest-news
  public String retrieveLatestNews(String languageName) {

    String requestUrl = UriComponentsBuilder
        .fromUriString(SHIMBUN_API_URL)
        .path(Constants.SHIMBUN_API_ENDPOINT_LATEST_NEWS)
        .queryParam(Constants.SHIMBUN_API_QUERYPARAM_LANGUAGE, ShimbunLanguage.getLanguageCode(languageName))
        .toUriString();

    RequestEntity<Void> request = RequestEntity
        .get(requestUrl)
        .header(Constants.SHIMBUN_API_HEADER_AUTHORIZATION, SHIMBUN_API_TOKEN)
        .build();

    ResponseEntity<String> response = restTemplate.exchange(request, String.class);

    return response.getBody();
  }

  // related endpoint: GET /search
  public String retrieveNewsBySearch(ShimbunQuery query) {

    String requestUrl = UriComponentsBuilder
        .fromUriString(SHIMBUN_API_URL)
        .path(Constants.SHIMBUN_API_ENDPOINT_SEARCH)
        .queryParam(Constants.SHIMBUN_API_QUERYPARAM_CATEGORY, query.getCategory())
        .queryParam(Constants.SHIMBUN_API_QUERYPARAM_COUNTRY, ShimbunRegion.getRegionCode(query.getCountry()))
        .queryParam(Constants.SHIMBUN_API_QUERYPARAM_LANGUAGE, ShimbunLanguage.getLanguageCode(query.getLanguage()))
        .queryParam(Constants.SHIMBUN_API_QUERYPARAM_STARTDATE, query.getStartDate())
        .queryParam(Constants.SHIMBUN_API_QUERYPARAM_ENDDATE, query.getEndDate())
        .toUriString();

    RequestEntity<Void> request = RequestEntity
        .get(requestUrl)
        .header(Constants.SHIMBUN_API_HEADER_AUTHORIZATION, SHIMBUN_API_TOKEN)
        .build();

    ResponseEntity<String> response = restTemplate.exchange(request, String.class);

    return response.getBody();
  }
}
