package com.fsmvu.inspectionofclass.http;

import java.util.Map;
import java.io.IOException;
import java.io.OutputStream;

import com.fsmvu.inspectionofclass.automation.Course;
import com.fsmvu.inspectionofclass.automation.School;
import com.fsmvu.inspectionofclass.automation.Student;
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

        String paramCourse = parameters.get("course");
        String paramCard = parameters.get("card");

        if(paramCourse == null || paramCard == null) throw new RuntimeException("Bad request");

        School school = RFIDServer.getInstance().school;
        Student student = school.getStudentByCard(paramCard);
        System.out.println("Student request -" + student.cardNumber);
        int responseCode = 400;
        if(student != null){
            for (Course course : student.courses) {
                if(course.code.equals(paramCourse)) {
                    try {
                        boolean result = course.inspect(student);
                        if(result) responseCode = 200;    
                    } catch (Exception e) {
                        //responseCode = 400;
                    }
                }
            }
        }        
        System.out.println("Class - " + paramCourse + " ----- Card - " + paramCard);
        System.out.println("Response code - " + responseCode);
        String responseText = "Responded";
        response.sendResponseHeaders(responseCode, responseText.length());
        OutputStream os = response.getResponseBody();
        os.write(responseText.getBytes());
        os.close();
    }
    
}