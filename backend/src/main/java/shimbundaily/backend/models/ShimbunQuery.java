package shimbundaily.backend.models;

import shimbundaily.backend.utility.Constants;

// related endpoint: GET /search
public class ShimbunQuery {

  private String category;
  private String country;
  private String language;
  private String startDate;
  private String endDate;

  private ShimbunQuery(Builder bdr) {
    this.category = bdr.category;
    this.country = bdr.country;
    this.language = bdr.language;
    this.startDate = bdr.startDate;
    this.endDate = bdr.endDate;
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

    private String category = Constants.STRING_EMPTY;
    private String country = Constants.STRING_EMPTY;
    private String language = Constants.STRING_EMPTY;
    private String startDate = Constants.STRING_EMPTY;
    private String endDate = Constants.STRING_EMPTY;

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