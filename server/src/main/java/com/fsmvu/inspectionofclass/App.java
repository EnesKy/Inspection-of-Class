package com.fsmvu.inspectionofclass;

import java.io.IOException;

import com.fsmvu.inspectionofclass.http.RFIDHandler;
import com.fsmvu.inspectionofclass.http.Server;;

/**
 * 
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        try{
            Server.getInstance()
            .build(16290)
            .map("/test", new RFIDHandler())
            .start();
        }catch(IOException ex) {
            System.err.println("Error occured " + ex.getMessage());
        }
        
        
        
    }
}
