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

    public ArrayList<Double> geocode(String location) { //검색한 위치의 좌표를 찾아 arraylist로 반환한다. 
        /*arrayList[0] = 위도
        arrayList[1] = 경도
        arrayList[2] = 줌 인 아웃
         */
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
                JSONObject firstResult = resultsArray.getJSONObject(0);
                JSONObject geometry = firstResult.getJSONObject("geometry");
                JSONObject printIocation = geometry.getJSONObject("location");
                
                if(checkBuilding(resultsArray) == 16){
                    double latitude = printIocation.getDouble("lat");
                    double longitude = printIocation.getDouble("lng");
                    coordinates.add(latitude);
                    coordinates.add(longitude);
                    coordinates.add(checkBuilding(resultsArray));
                }
            } else {
                System.out.println("HTTP error: " + responseCode);
            }
        } catch (Exception e) {
            System.out.println("예외 발생! geocode 오류");
        }
        return coordinates;
    }

    private double checkBuilding(JSONArray resultsArray) {
        double zoomLevel = 0;
        for (int i = 0; i < resultsArray.length(); i++) {
            JSONObject result = resultsArray.getJSONObject(i);
            JSONArray addressComponents = result.getJSONArray("address_components");
            for (int j = 0; j < addressComponents.length(); j++) {
                JSONObject addressComponent = addressComponents.getJSONObject(j);
                JSONArray types = addressComponent.getJSONArray("types");

                for (int k = 0; k < types.length(); k++) {
                    String type = types.getString(k);
                    if (type.equals("street_address") || type.equals("premise")) {
                        // 건물인 경우 줌 레벨 16
                        zoomLevel = 16;
                        break;
                    }
                }
            }
        }
        return zoomLevel;
    }
}
