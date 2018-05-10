/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package automationsystem;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 *
 * @author yigido
 */
public class Course {
    
    String CourseName;
    
    Date time; // sadece course un saatini belirlemek için kullanılıyor
    
    String CourseCode;
    
    Map<Date, List<Student>> inspections; // buradaki date , o course un saatini ve gün/ay/yıl bilgisini içericek
    //verilen saatteki -> dersteOlanOgrenciler
    void yoklama(Student student) throws ParseException {
       DateFormat formatter = new SimpleDateFormat("dd-M-yyyy");
      // DateFormat formatter = new SimpleDateFormat("dd-M-yyyy hh:mm"); 
        
        //saat sorgusu burda olacak
        Date today = new Date(); // şuan ki saati kontrol için. Bu da yoklamanın alınıp alınamayacağının kontrolü için gerekli
        today = formatter.parse(formatter.format(today));
      
        // new Date() = 9 mayıs 2018 saat 21.40 
        Date todayWithZeroTime = formatter.parse(formatter.format(new Date()));
        // todayWithZeroTime = 9 mayıs 2018
        
        List<Student> i = inspections.get(todayWithZeroTime);
        if(i != null) {
            i = new ArrayList<>();
            inspections.put(todayWithZeroTime, i);
        }
        i.add(student);
    }
    
    
    
     
   public static List<String> classrooms = new ArrayList<>();
   
    public Course(String className ,String coursecode , Date time){
     
        CourseName  = className; CourseCode = coursecode; this.time = time; 
       
    }
      
    public void addClassrooms(String code) { 
    
        classrooms.add(code);
    
    }
        
    public String toString(){
   
        return CourseName + " , " + CourseCode + " , " + time;
   
    }
   
    public int hashCode()
    {
        return toString().hashCode();
    }   

   
    public boolean equals(Object x){
    if(!(x instanceof Course)){
     return false;
    }
     Course c = (Course) x;
        return (c.CourseCode.equals(this.CourseCode));
    }

            
}
