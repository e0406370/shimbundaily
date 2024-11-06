package shimbundaily.backend.utility;

import java.io.StringReader;

import jakarta.json.Json;
import jakarta.json.JsonArray;
import jakarta.json.JsonObject;
import jakarta.json.JsonValue;

public class Utils {

  public static JsonObject returnPayloadInJson(String payload) {

    return Json.createReader(new StringReader(payload)).readObject();
  }

  public static String[] parseJsonArray(JsonArray arr) {

    return arr.stream()
        .map(JsonValue::toString)
        .map(s -> s.replaceAll("^\"|\"$", Constants.STRING_EMPTY)) // removes leading and trailing backslashes
        .toArray(String[]::new);
  }
}
