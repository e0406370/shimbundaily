package shimbundaily.backend.utility;

import java.util.List;

import jakarta.json.JsonArray;
import jakarta.json.JsonObject;
import shimbundaily.backend.models.ShimbunArticle;

public class ShimbunUtils {

  public static List<ShimbunArticle> createArticlesFromNews(String newsPayload) {

    JsonObject newsObj = Utils.returnPayloadInJson(newsPayload);
    JsonArray newsArr = newsObj.getJsonArray("news");

    return newsArr.stream()
        .map(jv -> jv.asJsonObject())
        .map(jo -> {

          String id = jo.getString("id");
          String title = jo.getString("title");
          String description = jo.getString("description");
          String url = jo.getString("url");
          String author = jo.getString("author");
          String image = jo.getString("image");
          String language = jo.getString("language");
          String[] category = Utils.parseJsonArray(jo.getJsonArray("category"));
          String published = jo.getString("published");

          return new ShimbunArticle(id, title, description, url, author, image, language, category, published);
        })
        .toList();
  }
}
