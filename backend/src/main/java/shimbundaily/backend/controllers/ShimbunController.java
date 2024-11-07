package shimbundaily.backend.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import shimbundaily.backend.models.ShimbunArticle;
import shimbundaily.backend.models.ShimbunCategory;
import shimbundaily.backend.models.ShimbunCountry;
import shimbundaily.backend.models.ShimbunLanguage;
import shimbundaily.backend.models.ShimbunQuery;
import shimbundaily.backend.services.ShimbunService;
import shimbundaily.backend.utility.ShimbunUtils;

@RestController
@RequestMapping(path = "/api", produces = MediaType.APPLICATION_JSON_VALUE)
public class ShimbunController {

  @Autowired
  private ShimbunService shimbunSvc;

  @GetMapping(path = "/available/categories")
  public ResponseEntity<List<String>> retrieveAvailableCategories() {

    return ResponseEntity
        .status(HttpStatus.OK)
        .body(ShimbunCategory.getAvailableCategories());
  }

  @GetMapping(path = "/available/countries")
  public ResponseEntity<List<String>> retrieveAvailableCountries() {

    return ResponseEntity
        .status(HttpStatus.OK)
        .body(ShimbunCountry.getAvailableCountries());
  }

  @GetMapping(path = "/available/languages")
  public ResponseEntity<List<String>> retrieveAvailableLanguages() {

    return ResponseEntity
        .status(HttpStatus.OK)
        .body(ShimbunLanguage.getAvailableLanguages());
  }

  @GetMapping(path = "/news/latest")
  public ResponseEntity<List<ShimbunArticle>> retrieveLatestNews(@RequestParam String language) {

    String newsPayload = shimbunSvc.getLatestNews(language);

    return ResponseEntity
        .status(HttpStatus.OK)
        .body(ShimbunUtils.createArticlesFromNews(newsPayload));
  }

  @GetMapping(path = "/news/search")
  public ResponseEntity<List<ShimbunArticle>> retrieveNewsBySearch(@RequestParam MultiValueMap<String, String> queryMap) {

    ShimbunQuery query = new ShimbunQuery.Builder()
        .setCategory(queryMap.getFirst("category"))
        .setCountry(queryMap.getFirst("country"))
        .setLanguage(queryMap.getFirst("language"))
        .setStartDate(queryMap.getFirst("startDate"))
        .setEndDate(queryMap.getFirst("endDate"))
        .build();

    String newsPayload = shimbunSvc.getNewsBySearch(query);    

    return ResponseEntity
        .status(HttpStatus.OK)
        .body(ShimbunUtils.createArticlesFromNews(newsPayload));
  }
}
  