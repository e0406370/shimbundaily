package shimbundaily.backend.models;

import java.util.Arrays;
import java.util.List;

import shimbundaily.backend.utility.Constants;

// related endpoint: GET /available/regions
// 64 supported regions
public enum Region {
  AFGHANISTAN("Afghanistan", "AF"),
  ALGERIA("Algeria", "DZ"),
  ARGENTINA("Argentina", "AR"),
  AUSTRALIA("Australia", "AU"),
  AUSTRIA("Austria", "AT"),
  BANGALADESH("Bangladesh", "BD"),
  BELGIUM("Belgium", "BE"),
  BRAZIL("Brazil", "BR"),
  BULGARIA("Bulgaria", "BG"),
  CANADA("Canada", "CA"),
  CHILE("Chile", "CL"),
  CHINA("China", "CN"),
  COLOMBIA("Colombia", "CO"),
  CZECH_REPUBLIC("Czech Republic", "CZ"),
  DENMARK("Denmark", "DK"),
  EGYPT("Egypt", "EG"),
  FINLAND("Finland", "FI"),
  FRANCE("France", "FR"),
  GERMANY("Germany", "DE"),
  GREECE("Greece", "GR"),
  HONG_KONG("Hong Kong", "HK"),
  HUNGARY("Hungary", "HU"),
  INDIA("India", "IN"),
  INDONESIA("Indonesia", "ID"),
  IRELAND("Ireland", "IE"),
  ISRAEL("Israel", "IL"),
  ITALY("Italy", "IT"),
  IVORY_COAST("Ivory Coast", "CI"),
  JAPAN("Japan", "JP"),
  KENYA("Kenya", "KE"),
  KUWAIT("Kuwait", "KW"),
  LEBANON("Lebanon", "LB"),
  MALAYSIA("Malaysia", "MY"),
  MEXICO("Mexico", "MX"),
  MYANMAR("Myanmar", "MM"),
  NETHERLANDS("Netherlands", "NL"),
  NEW_ZEALAND("New Zealand", "NZ"),
  NIGERIA("Nigeria", "NG"),
  NORWAY("Norway", "NO"),
  PANAMA("Panama", "PA"),
  PERU("Peru", "PE"),
  PHILIPPINES("Philippines", "PH"),
  POLAND("Poland", "PL"),
  PORTUGAL("Portugal", "PT"),
  QATAR("Qatar", "QA"),
  ROMANIA("Romania", "RO"),
  RUSSIA("Russia", "RU"),
  SAUDI_ARABIA("Saudi Arabia", "SA"),
  SERBIA("Serbia", "RS"),
  SINGAPORE("Singapore", "SG"),
  SOUTH_KOREA("South Korea", "KR"),
  SPAIN("Spain", "ES"),
  SWEDEN("Sweden", "SE"),
  SWITZERLAND("Switzerland", "CH"),
  TAIWAN("Taiwan", "TW"),
  THAILAND("Thailand", "TH"),
  TURKEY("Turkey", "TR"),
  UNITED_ARAB_EMIRATES("United Arab Emirates", "AE"),
  UNITED_KINGDOM("United Kingdom", "GB"),
  UNITED_STATES("United States", "US"),
  URUGUAY("Uruguay", "UY"),
  VENEZUELA("Venezuela", "VE"),
  VIETNAM("Vietnam", "VN"),
  ZIMBABWE("Zimbabwe", "ZW");

  private final String name;
  private final String code;

  private Region(String name, String code) {
    this.name = name;
    this.code = code;
  }

  public String getName() {
    return this.name;
  }

  public String getCode() {
    return this.code;
  }

  public static List<String> getAvailableRegions() {
    return Arrays.stream(Region.values())
        .map(Region::getName)
        .toList();
  }

  public static String getRegionCode(String regionName) {
    String regionCode = Constants.STRING_EMPTY;

    for (Region region : Region.values()) {
      if (region.getName().equalsIgnoreCase(regionName)) {
        regionCode = region.getCode();
        break;
      }
    }

    return regionCode;
  }
}