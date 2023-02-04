package com.learning.parse.json;

import com.google.gson.JsonArray;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.jayway.jsonpath.JsonPath;

public class JSONParsers {

    /*
    * Parse JSON:
    * There are 3 ways:
    * 1.using org.json library
    * 2.using Gson in java
    * 3.using JsonPath
    *
    * Note: Requires deserialization of JSON into Java Object before traversal of actual object.
    * JsonPath approach uses XPath concept.
    *
    * JSON : JAVA Entities::
    * string : java.lang.String
    * number : java.lang.Number
    * true|false : java.lang.Boolean
    * null : null
    * array : java.util.List
    * object : java.util.Map
    * */

    private static String sampleJson = "{\"pageInfo\": {" +
            "\"pageName\": \"Homepage\",\"logo\": \"\"}," +
            "\"posts\": [{" +
            "\"post_id\": \"987456123\"," +
            "\"actor_id\": \"101\"," +
            "\"author_name\": \"Robert\"," +
            "\"post_title\": \"How to parse JSON in Java.\"," +
            "\"comments\": []," +
            "\"time_of_post\": \"5689563245\"" +
            "}]" +
            "}";

    public static void main(String[] args) throws JSONException {

        JSONObject ob = new JSONObject(sampleJson);
        String pageName = ob.getJSONObject("pageInfo").getString("pageName");
        System.out.println("pageName = " + pageName);

        JSONArray array = ob.getJSONArray("posts");
        for (int i = 0; i < array.length(); i++) {
            String postId = array.getJSONObject(i).getString("post_id");
            System.out.println(postId);
        }
    }

    public void parseUsingGson() {
        com.google.gson.JsonObject ob = new com.google.gson.JsonParser().parse(sampleJson).getAsJsonObject();

        String pageName = ob.getAsJsonObject("pageInfo").get("pageName").getAsString();
        System.out.println("pageName = " + pageName);

        JsonArray array = ob.getAsJsonArray("posts");
        for (int i = 0; i < array.size(); i++) {
            String author_name = array.get(i).getAsJsonObject().get("author_name").getAsString();
            System.out.println("author_name = " + author_name);
        }
    }

    public void parseUsingJsonPath() {
        String pageName = JsonPath.read(sampleJson, "$.pageInfo.pageName");
        System.out.println("pageName = " + pageName);

        Integer posts = JsonPath.read(sampleJson, "$.posts.length()");

        for (int i = 0; i < posts; i++) {
            String author_name = JsonPath.read(sampleJson, "$.posts[" + i + "].author_name");
            System.out.println("author_name = " + author_name);
        }
    }
}
