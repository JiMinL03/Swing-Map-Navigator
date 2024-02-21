package com.mycompany.journeymate.API;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import javax.swing.ImageIcon;

public class StaticMap {
    public String downloadMap(ArrayList<Double> coordinates, int zoomLevel) {
        //geocoding API로부터 얻어온 위도 경도 좌표를 통해 지도 이미지를 다운로드하여 파일에 업로드한다.
        String location;
        double latitude = coordinates.get(0);
        double longitude = coordinates.get(1);
        location = latitude + "," + longitude;
        try {
            String apiKey = "AIzaSyB7Vp44RWD32nERlbCmrWCB9dfzvzf6OfA";
            String imamgeUrl = "https://maps.googleapis.com/maps/api/staticmap?center=" + URLEncoder.encode(location, "UTF-8") + "&zoom=" + zoomLevel + "&size=400x400&key=" + apiKey;
            URL url = new URL(imamgeUrl);
            InputStream is = url.openStream();
            OutputStream os = new FileOutputStream(location);
            byte[] b = new byte[2048];
            int length;
            while ((length = is.read(b)) != -1) {
                os.write(b, 0, length);
            }
            is.close();
            os.close();
        } catch (Exception e) {
            System.out.println("예외 발생! staticmap 오류");
        }
        return location;
    }
    public ImageIcon getMap(String location) {
        //downloadMap메서드로부터 업로드된 파일이름 (location)을 리턴한다. (GUI에서 쓰인다)
        int width = 485;
        int height = 528;
        return new ImageIcon((new ImageIcon(location)).getImage().getScaledInstance(width, height, java.awt.Image.SCALE_SMOOTH));
    }

    public void fileDelete(String fileName) {
        //downloadMap메서드로부터 업로드된 파일이름 (location)을 삭제한다.
        File f = new File(fileName);
        f.delete();
    }
}
