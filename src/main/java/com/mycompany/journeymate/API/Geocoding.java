package com.mycompany.journeymate.API;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;

public class Geocoding {
    public ArrayList<Double> geocode(String location) {
         ArrayList<Double> coordinates = new ArrayList<>();
        try {
            String apiKey = "AIzaSyB7Vp44RWD32nERlbCmrWCB9dfzvzf6OfA";
            String url = "https://maps.googleapis.com/maps/api/geocode/json?address=" + URLEncoder.encode(location, "UTF-8") + "&key=" + apiKey;
            HttpURLConnection connection = (HttpURLConnection) new URL(url).openConnection();
            connection.setRequestMethod("GET");

            // 응답 받기
            int responseCode = connection.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK) {
                // 응답을 읽기
                BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                StringBuilder response = new StringBuilder();
                String line;
                while ((line = reader.readLine()) != null) {
                    response.append(line);
                }
                reader.close();
                JSONTokener tokener = new JSONTokener(response.toString());
                JSONObject object = new JSONObject(tokener);
                //System.out.println(object.toString());
                JSONArray resultsArray = object.getJSONArray("results");
                JSONObject firstResult = resultsArray.getJSONObject(0); // Assuming there's at least one result
                JSONObject geometry = firstResult.getJSONObject("geometry");
                JSONObject printIocation = geometry.getJSONObject("location");

                double latitude = printIocation.getDouble("lat");
                double longitude = printIocation.getDouble("lng");

                System.out.println("Latitude: " + latitude);
                System.out.println("Longitude: " + longitude);
                
                coordinates.add(latitude);
                coordinates.add(longitude);
                
            } else {
                System.out.println("HTTP error: " + responseCode);
            }
        } catch (Exception e) {
            System.out.println("예외 발생! geocode 오류");
        }
        return coordinates;
    }
}
