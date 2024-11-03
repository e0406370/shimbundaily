package shimbundaily.backend.models;

import java.util.Arrays;
import java.util.List;

import shimbundaily.backend.utility.Constants;

// related endpoint: GET /available/languages
// 23 supported languages
public enum Language {
  ARABIC("Arabic", "ar"),
  CHINESE("Chinese", "zh"),
  CZECH("Czech", "cs"),
  DANISH("Danish", "da"),
  DUTCH("Dutch", "nl"),
  ENGLISH("English", "en"),
  FINNISH("Finnish", "fi"),
  FRENCH("French", "fr"),
  GERMAN("German", "de"),
  GREEK("Greek", "el"),
  HINDI("Hindi", "hi"),
  HUNGARIAN("Hungarian", "hu"),
  ITALIAN("Italian", "it"),
  JAPANESE("Japanese", "ja"),
  KOREAN("Korean", "ko"),
  MALAY("Malay", "msa"),
  PORTUGUESE("Portuguese", "pt"),
  RUSSIAN("Russian", "ru"),
  SERBIAN("Serbian", "sr"),
  SPANISH("Spanish", "es"),
  THAI("Thai", "th"),
  TURKISH("Turkish", "tr"),
  VIETNAMESE("Vietnamese", "vi");

  private final String name;
  private final String code;

  private Language(String name, String code) {
    this.name = name;
    this.code = code;
  }

  public String getName() {
    return this.name;
  }

  public String getCode() {
    return this.code;
  }

  public static List<String> getAvailableLanguages() {
    return Arrays.stream(Language.values())
        .map(Language::getName)
        .toList();
  }

  public static String getLanguageCode(String languageName) {
    String languageCode = Constants.STRING_EMPTY;

    for (Language language : Language.values()) {
      if (language.getName().equalsIgnoreCase(languageName)) {
        languageCode = language.getCode();
        break;
      }
    }

    return languageCode;
  }
}
