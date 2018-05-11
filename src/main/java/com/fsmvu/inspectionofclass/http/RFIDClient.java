package com.fsmvu.inspectionofclass.http;

import java.net.URL;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.io.IOException;
import java.io.InputStream;

public class RFIDClient {
    public static String BASE_URL = "";

    private RFIDClient () {
    
    }

    /** returns  */
    public static int request(String courseCode, String cardNo) {
        HttpURLConnection connection = null;
        
        try{
            String params = String.format("inspect?course=%s&card=%s", courseCode, cardNo);

            URL url = new URL(BASE_URL + params);
            connection = (HttpURLConnection) url.openConnection();  
            connection.setRequestMethod("GET");

            InputStream in = connection.getInputStream();
            byte[] rawData = new byte[in.available()];
            in.read(rawData);
            /** if responds needs */
            //String respond = new String(rawData);
            
            return connection.getResponseCode();
        } catch(MalformedURLException ex) {
            ex.printStackTrace();
            return 400;
        } catch(IOException ex) {
            ex.printStackTrace();
            return 400;
        } finally {
            if(connection!=null) connection.disconnect();
        }
    }

}