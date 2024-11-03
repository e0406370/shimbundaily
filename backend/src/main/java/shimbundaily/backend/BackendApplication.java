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
import shimbundaily.backend.models.ShimbunRegion;
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

		//#region testing methods in ShimbunCategory, ShimbunLanguage, ShimbunRegion
		List<String> availableCategories = ShimbunCategory.getAvailableCategories();
		List<String> availableLanguages = ShimbunLanguage.getAvailableLanguages();
		List<String> availableRegions = ShimbunRegion.getAvailableRegions();

		System.out.printf("categories (%d): %s \n", availableCategories.size(), availableCategories);
		System.out.printf("languages (%d): %s \n", availableLanguages.size(), availableLanguages);
		System.out.printf("regions (%d): %s \n", availableRegions.size(), availableRegions);

		System.out.printf("language code for Japanese: %s \n", ShimbunLanguage.getLanguageCode("japanese"));
		System.out.printf("region code for Singapore: %s \n", ShimbunRegion.getRegionCode("singapore"));
		//#endregion

		//#region testing methods in ShimbunQuery
		System.out.println("Current time in UTC: " + Instant.now().toString());

		String country = "Singapore";
		ShimbunQuery modifiedQuery = new ShimbunQuery.Builder()
				.setCountry(ShimbunRegion.getRegionCode(country))
				.build();

		ShimbunQuery unmodifiedQuery = new ShimbunQuery.Builder()
				.build();

		System.out.printf("modified query with country set to Singapore: %s \n", modifiedQuery.toString());
		System.out.printf("unmodified query: %s \n", unmodifiedQuery.toString());
		//#endregion

		//#region testing /latest-news endpoint with query parameters
		String testLanguage = "Japanese";
		
		System.out.println(shimbunSvc.retrieveLatestNews(testLanguage));
		//#endregion

		//#region testing /search endpoint with query parameters
		ShimbunQuery testQuery = new ShimbunQuery.Builder()
				.setCategory("general")
				.setCountry("Japan")
				.setLanguage("Japanese")
				.setStartDate("2024-10-01T00:00:00.760254700Z")
				.setEndDate("2024-11-03T10:59:59.760254700Z")
				.build();

		System.out.println(shimbunSvc.retrieveNewsBySearch(testQuery));
		//#endregion
	}
}
