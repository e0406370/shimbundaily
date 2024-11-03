package shimbundaily.backend;

import java.time.Instant;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import shimbundaily.backend.models.Category;
import shimbundaily.backend.models.Language;
import shimbundaily.backend.models.Region;
import shimbundaily.backend.models.ShimbunQuery;

@SpringBootApplication
public class BackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(BackendApplication.class, args);

		List<String> availableCategories = Category.getAvailableCategories();
		List<String> availableLanguages = Language.getAvailableLanguages();
		List<String> availableRegions = Region.getAvailableRegions();

		System.out.printf("categories (%d): %s \n", availableCategories.size(), availableCategories);
		System.out.printf("languages (%d): %s \n", availableLanguages.size(), availableLanguages);
		System.out.printf("regions (%d): %s \n", availableRegions.size(), availableRegions);

		System.out.printf("language code for Japanese: %s \n", Language.getLanguageCode("japanese"));
		System.out.printf("region code for Singapore: %s \n", Region.getRegionCode("singapore"));

		System.out.println("Current time in UTC: " + Instant.now().toString());

		String country = "Singapore";
		ShimbunQuery query1 = new ShimbunQuery.Builder()
				.setCountry(Region.getRegionCode(country))
				.build();

		ShimbunQuery query2 = new ShimbunQuery.Builder()
				.build();

		System.out.printf("modified query with country set to Singapore: %s \n", query1.toString());
		System.out.printf("unmodified query: %s \n", query2.toString());
	}
}
