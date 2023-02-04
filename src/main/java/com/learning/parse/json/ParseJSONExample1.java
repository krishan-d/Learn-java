package com.learning.parse.json;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.*;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

public class ParseJSONExample1 {
    /*
    JSONObject is a java.util.Map
    JSONArray is a java.util.List

    Note: JSONArray or JSONObject supports standard operations of List or Map.
    */

    public static void main(String[] args) throws IOException, ParseException {

        //writeToJson();

        //String fileName = "data_directory/JsonExample.json";
        //readJsonFromFile(fileName);

        decodingJson();
    }

    static void writeToJson() throws IOException {
        JSONObject jsonObject = new JSONObject();

        jsonObject.put("first_name", "Eve");
        jsonObject.put("last_name", "Black");
        jsonObject.put("age", 23);

        Map m = new LinkedHashMap(4);
        m.put("address_line1", "21 2nd Street");
        m.put("city", "New York");
        m.put("state", "NY");
        m.put("postal_code", 10021);

        jsonObject.put("address", m);

        JSONArray array = new JSONArray();
        m = new LinkedHashMap(2);
        m.put("type", "Home");
        m.put("number", "212 444-1234");
        array.add(m);

        m = new LinkedHashMap(2);
        m.put("type", "Fax");
        m.put("number", "212 555-1234");

        array.add(m);

        jsonObject.put("phone_numbers", array);

        //JSON Object streaming:
        Writer w = new StringWriter();
        jsonObject.writeJSONString(w);

        String jsonText = w.toString();
        System.out.println("jsonText = " + jsonText);

        PrintWriter pw = new PrintWriter("data_directory/JsonExample.json");
        pw.write(jsonObject.toJSONString());

        pw.flush();
        pw.close();
    }

    static void readJsonFromFile(String fileName) throws IOException, ParseException {
        Object ob = new JSONParser().parse(new FileReader(fileName));

        JSONObject jsonObject = (JSONObject) ob;

        String firstName = (String) jsonObject.get("first_name");
        String lastName = (String) jsonObject.get("last_name");
        System.out.println("Name: " + firstName + " " + lastName);

        long age = (long) jsonObject.get("age");
        System.out.println("age = " + age);

        Map map = (Map) jsonObject.get("address");

        for (Object value : map.entrySet()) {
            Map.Entry pair = (Map.Entry) value;
            System.out.println(pair.getKey() + " : " + pair.getValue());
        }

        JSONArray jsonArray = (JSONArray) jsonObject.get("phone_numbers");
        Iterator itr2 = jsonArray.iterator();
        while (itr2.hasNext()) {
            for (Object o : ((Map) itr2.next()).entrySet()) {
                Map.Entry pair = (Map.Entry) o;
                System.out.println(pair.getKey() + " : " + pair.getValue());
            }
        }
    }

    static void decodingJson() {
        JSONParser parser = new JSONParser();
        String s = "[0,{\"1\":{\"2\":{\"3\":{\"4\":[5,{\"6\":7}]}}}}]";

        try {
            Object ob = parser.parse(s);
            JSONArray array = ((JSONArray) ob);

            System.out.println(array.get(1));

            JSONObject jsonObject = ((JSONObject) array.get(1));
            System.out.println(jsonObject.get("1"));

            s = "{}";
            ob = parser.parse(s);
            System.out.println(ob);

            s = "[5, ]";
            ob = parser.parse(s);
            System.out.println(ob);

            s = "[5,,2]";
            ob = parser.parse(s);
            System.out.println(ob);

        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}
