package com.fsmvu.inspectionofclass.http;

import java.util.Map;
import java.io.IOException;
import java.io.OutputStream;

import com.fsmvu.inspectionofclass.util.QueryParser;
import com.sun.net.httpserver.*;

/**
 * RFIDHandler handles requests from Rasperry Pi. Server checks student
 * card info. After that inspection validation will be done. After all if
 * all validation are pass, student inspected in course at current time.
 */
public class RFIDHandler implements HttpHandler {

	public void handle(HttpExchange response) throws IOException {
        String query = response.getRequestURI().getQuery();
        Map<String, String> parameters = QueryParser.parse(query);
        
        String responsea = "This is the response";
            response.sendResponseHeaders(200, responsea.length());
            OutputStream os = response.getResponseBody();
            os.write(responsea.getBytes());
            os.close();
        // TODO do here
    }
    
}