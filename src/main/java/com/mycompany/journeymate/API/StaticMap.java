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
    public String downloadMap(ArrayList<Double> coordinates) {
        String location;
        double latitude = coordinates.get(0);
        double longitude = coordinates.get(1);
        location = latitude + "," + longitude;
        try {
            String apiKey = "AIzaSyB7Vp44RWD32nERlbCmrWCB9dfzvzf6OfA";
            String imamgeUrl = "https://maps.googleapis.com/maps/api/staticmap?center=" + URLEncoder.encode(location, "UTF-8") + "&zoom=16&size=400x400&key=" + apiKey;
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
            System.out.println(e);
        }
        return location;
    }
    public ImageIcon getMap(String location) {
        int width = 485;
        int height = 528;
        return new ImageIcon((new ImageIcon(location)).getImage().getScaledInstance(width, height, java.awt.Image.SCALE_SMOOTH));
    }

    public void fileDelete(String fileName) {
        File f = new File(fileName);
        f.delete();
    }
}
