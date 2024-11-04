package shimbundaily.backend.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import shimbundaily.backend.models.ShimbunCategory;
import shimbundaily.backend.models.ShimbunLanguage;
import shimbundaily.backend.models.ShimbunCountry;

@RestController
public class ShimbunController {

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
}
