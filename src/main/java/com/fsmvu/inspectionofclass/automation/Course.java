package com.fsmvu.inspectionofclass.automation;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 *
 * @author yigido
 */
public class Course {
    
    String name;
    Date time; // sadece course un saatini belirlemek için kullanılıyor
    public String code;

    int offsetBefore = 0;
    int offsetAfter = 0;
    
    Map<Date, List<Student>> inspections; // buradaki date , o course un saatini ve gün/ay/yıl bilgisini içericek
    //verilen saatteki -> dersteOlanOgrenciler

    public List<String> classrooms = new ArrayList<>();
   
    public Course(String className, String coursecode, int hour, int minute, int offsetBefore, int offsetAfter){
        name  = className;
        code = coursecode; 
    
        DateFormat formatter = new SimpleDateFormat("hh mm");
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.HOUR_OF_DAY, hour);
        cal.set(Calendar.MINUTE, minute);
        try {
            time = formatter.parse(hour + " " + minute);    
        } catch (Exception e) {
            time = null;
        }
        
        this.offsetBefore = offsetBefore;
        this.offsetAfter = offsetAfter;
    }

    public boolean inspect(Student student) throws ParseException {
        DateFormat formatter = new SimpleDateFormat("dd-M-yyyy hh");
        
        /** currentTime */
        Date currentTime = new Date();
        
        /** current time needs format on 20-05-2018 16 
         * 16 is hour of day.
         * inspectionDate is needed to access old inspections with related
         * this course.
        */
        
        Date inspectionDate = formatter.parse(formatter.format(currentTime));
        
        // new Date() = 9 mayıs 2018 saat 21.40 
        formatter = new SimpleDateFormat("dd-M-yyyy hh:mm");
        Calendar courseTime = Calendar.getInstance();
        courseTime.setTime(this.time);

        // Şuan ki saate +offset -offset eklenerek kontrol edilecek.
        Calendar c = Calendar.getInstance();
        c.setTime(inspectionDate);
        c.set(Calendar.HOUR_OF_DAY, courseTime.get(Calendar.HOUR_OF_DAY));
        c.set(Calendar.MINUTE, courseTime.get(Calendar.MINUTE));
        
        c.add(Calendar.MINUTE, +offsetAfter);
        long upperBound = c.getTimeInMillis();
        c.add(Calendar.MINUTE, -(offsetBefore+offsetAfter));
        long lowerBound = c.getTimeInMillis();
        long currentMillis = currentTime.getTime();

        if(currentMillis > lowerBound && currentMillis < upperBound) {
            List<Student> i = inspections.get(inspectionDate);
            if(i != null) {
                i = new ArrayList<>();
                inspections.put(inspectionDate, i);
            }
            i.add(student);
            return true;
        }
        return false;
    }
    
    public void addClassrooms(String code) { 
        classrooms.add(code);
    }
        
    public String toString() {
        return name + " , " + code + " , " + time;
    }
   
    public int hashCode() {
        return toString().hashCode();
    }   

    public boolean equals(Object x){
        if(!(x instanceof Course)){
            return false;
        }
        
        Course c = (Course) x;
        return (c.code.equals(this.code));
    }
 
}
