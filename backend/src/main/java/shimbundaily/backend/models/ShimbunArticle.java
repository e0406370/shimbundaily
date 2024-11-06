package shimbundaily.backend.models;

public record ShimbunArticle
  (
    String id,
    String title,
    String description,
    String url,
    String author,
    String image,
    String language,
    String[] category,
    String published
  ) {
}