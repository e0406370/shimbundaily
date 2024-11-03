package shimbundaily.backend.models;

import java.time.Instant;

import shimbundaily.backend.utility.Constants;

// related endpoint: GET /search
public class ShimbunQuery {

  private String category = Constants.STRING_EMPTY;
  private String country = "INT";
  private String language = Constants.STRING_EMPTY;
  private String startDate = Instant.now().toString(); // formatted as YYYY-MM-ddTHH:mm:ss.ss±hh:mm - RFC 3339 Date and Time
  private String endDate = Instant.now().toString(); // formatted as YYYY-MM-ddTHH:mm:ss.ss±hh:mm - RFC 3339 Date and Time

  private ShimbunQuery(Builder bdr) {
    this.category = (bdr.category != null) ? bdr.category : this.category;
    this.country = (bdr.country != null) ? bdr.country : this.country;
    this.language = (bdr.language != null) ? bdr.language : this.language;
    this.startDate = (bdr.startDate != null) ? bdr.startDate : this.startDate;
    this.endDate = (bdr.endDate != null) ? bdr.endDate : this.endDate;
  }

  public String getCategory() {
    return this.category;
  }

  public String getCountry() {
    return this.country;
  }

  public String getLanguage() {
    return this.language;
  }

  public String getStartDate() {
    return this.startDate;
  }

  public String getEndDate() {
    return this.endDate;
  }

  @Override
  public String toString() {
    return String.format("[category: %s, country: %s, language: %s, startDate: %s, endDate: %s]", this.category, this.country, this.language, this.startDate, this.endDate);
  }

  public static class Builder {

    private String category;
    private String country;
    private String language;
    private String startDate;
    private String endDate;

    public Builder setCategory(String category) {
      this.category = category;
      return this;
    }

    public Builder setCountry(String country) {
      this.country = country;
      return this;
    }

    public Builder setLanguage(String language) {
      this.language = language;
      return this;
    }

    public Builder setStartDate(String startDate) {
      this.startDate = startDate;
      return this;
    }

    public Builder setEndDate(String endDate) {
      this.endDate = endDate;
      return this;
    }

    public ShimbunQuery build() {
      return new ShimbunQuery(this);
    }
  }
}