package shimbundaily.backend;

import java.time.Instant;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import shimbundaily.backend.models.ShimbunCategory;
import shimbundaily.backend.models.ShimbunLanguage;
import shimbundaily.backend.models.ShimbunQuery;
import shimbundaily.backend.models.ShimbunCountry;
import shimbundaily.backend.services.ShimbunService;

@SpringBootApplication
public class BackendApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(BackendApplication.class, args);
	}

	@Autowired
	private ShimbunService shimbunSvc;

	@Override
	public void run(String... args) throws Exception {

		//#region testing methods in ShimbunCategory, ShimbunCountry, ShimbunLanguage
		List<String> availableCategories = ShimbunCategory.getAvailableCategories();
		List<String> availableCountries = ShimbunCountry.getAvailableCountries();
		List<String> availableLanguages = ShimbunLanguage.getAvailableLanguages();

		System.out.printf("categories (%d): %s \n", availableCategories.size(), availableCategories);
		System.out.printf("countries (%d): %s \n", availableCountries.size(), availableCountries);
		System.out.printf("languages (%d): %s \n", availableLanguages.size(), availableLanguages);

		System.out.printf("country code for Singapore: %s \n", ShimbunCountry.getCountryCode("singapore"));
		System.out.printf("language code for Japanese: %s \n", ShimbunLanguage.getLanguageCode("japanese"));
		//#endregion

		//#region testing methods in ShimbunQuery
		System.out.println("Current time in UTC: " + Instant.now().toString());

		String country = "Singapore";
		ShimbunQuery modifiedQuery = new ShimbunQuery.Builder()
				.setCountry(ShimbunCountry.getCountryCode(country))
				.build();

		ShimbunQuery unmodifiedQuery = new ShimbunQuery.Builder()
				.build();

		System.out.printf("modified query with country set to Singapore: %s \n", modifiedQuery.toString());
		System.out.printf("unmodified query: %s \n", unmodifiedQuery.toString());
		//#endregion

		// //#region testing /latest-news endpoint with query parameters
		// String testLanguage = "Japanese";
		
		// System.out.println(shimbunSvc.getLatestNews(testLanguage));
		// //#endregion

		// //#region testing /search endpoint with query parameters
		// ShimbunQuery testQuery = new ShimbunQuery.Builder()
		// 		.setCategory("general")
		// 		.setCountry("Japan")
		// 		.setLanguage("Japanese")
		// 		.setStartDate("2024-10-01T00:00:00.760254700Z")
		// 		.setEndDate("2024-11-03T10:59:59.760254700Z")
		// 		.build();

		// System.out.println(shimbunSvc.getNewsBySearch(testQuery));
		// //#endregion
	}
}
