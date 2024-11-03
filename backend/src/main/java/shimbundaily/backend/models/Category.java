package shimbundaily.backend.models;

import java.util.Arrays;
import java.util.List;

// related endpoint: GET /available/categories
// 17 supported categories
public enum Category {
  ACADEMIA("academia"),
  BUSINESS("business"),
  ENTERTAINMENT("entertainment"),
  FINANCE("finance"),
  FOOD("food"),
  GAME("game"),
  GENERAL("general"),
  HEALTH("health"),
  LIFESTYLE("lifestyle"),
  OPINION("opinion"),
  POLITICS("politics"),
  PROGRAMMING("programming"),
  REGIONAL("regional"),
  SCIENCE("science"),
  SPORTS("sports"),
  TECHNOLOGY("technology"),
  WORLD("world");

  private final String name;

  private Category(String name) {
    this.name = name;
  }

  public String getName() {
    return this.name;
  }

  public static List<String> getAvailableCategories() {
    return Arrays.stream(Category.values())
        .map(Category::getName)
        .toList();
  }
}