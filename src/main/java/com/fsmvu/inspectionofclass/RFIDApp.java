package com.fsmvu.inspectionofclass;

import java.io.IOException;

import com.fsmvu.inspectionofclass.http.RFIDClient;
import com.fsmvu.inspectionofclass.pi.RFIDConverter;
import com.fsmvu.inspectionofclass.pi.RaspRC522;

/**
 * 
 *
 */
public class RFIDApp {
    private static final String COURSE_CODE = "D105";
    public static void main( String[] args ) throws InterruptedException{
        RaspRC522 rc522 = new RaspRC522();
        String strUID;
        byte tagid[] = new byte[5];

        /** should set server ip in here */
        RFIDClient.BASE_URL = "http://172.20.16.234:16290/";
        
        while (true) {
            rc522.Select_MirareOne(tagid);
            strUID = RFIDConverter.bytesToHex(tagid);
            if (!strUID.toString().equals("0000000000")) {
                System.out.println("Kart okunuyor...");
                System.out.println("Kart değeri : " + strUID.toString());
                try {
                    int responseCode = RFIDClient.request(COURSE_CODE, strUID.toString());
                    System.out.println("Response code is " + responseCode);    
                } catch(IOException ex) {
                    ex.printStackTrace();
                }
            }
            Thread.sleep(500);
        }        
    }
}
