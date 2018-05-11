package com.fsmvu.inspectionofclass;

import com.fsmvu.inspectionofclass.http.RFIDClient;

/**
 * 
 *
 */
public class RFIDApp {
    public static void main( String[] args )
    {
        RFIDClient.BASE_URL = "http://172.20.16.234:16290/";
        int responseCode = RFIDClient.request("100", "2");
        
        System.out.println("Response is " + responseCode);
        
        
    }
}
