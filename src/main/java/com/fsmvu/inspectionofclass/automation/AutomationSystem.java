package com.fsmvu.inspectionofclass.automation;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 *
 * @author yigido
 */
public class AutomationSystem {

    /**
     * @param args the command line arguments
     */
    
    public static void main(String[] args) throws ParseException {
        // TODO code application logic here

            Student s1 = new Student("Mert", 1 ,"D50AB80E69");
            Student s2 = new Student("Bilal", 2,"asdas5");
            Student s3 = new Student("Salim", 3, "asdas4");
            Student s4 = new Student("Enes", 4, "asd4");
            
            School sc = new School();   
            sc.addStudent(s1);  // Map'e ekleme
            sc.addStudent(s2);  
            sc.addStudent(s3);
            sc.addStudent(s4);
             
           
            SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy HH:mm");
            // ders1 baslama saati
            Date course1Start = sdf.parse("25.05.2018 12:00");
            // öğrencinin ders 1 e geldiği saat
            Date studentArriveCourse1 = sdf.parse("25.05.2018 12:10");
            // ders1 e gec girebilme saati
            Date derseGecGirebilmeSaatiCourse1 = sdf.parse("25.05.2018 12:15");
            // ders1 e ne kadar erken girebilir saati
            Date derseErkenGirebilmeSaatiCourse1 = sdf.parse("25.05.2018 11:30");
            
	    Date course2Start = sdf.parse("26.05.2018 12:00");
            
            
            Course course1 = new Course("Matematik" , "BLM101" , course1Start);
            Course course2 = new Course("Fizik", "FZ101" ,course2Start);
           
            //09.05.2018 15:44
            
            course1.addClassrooms("A103");
            course2.addClassrooms("C107");
           
            s1.addCourse(course1);
            s2.addCourse(course1);
            s3.addCourse(course1);
            s4.addCourse(course1);
            s2.addCourse(course2);
            s1.addCourse(course2);
            s3.addCourse(course2);
            
         
            
           List<Student> t = sc.getStudentByCourse(course1 , studentArriveCourse1 ,derseErkenGirebilmeSaatiCourse1, derseGecGirebilmeSaatiCourse1);
           for (Student s:t){
               System.out.println(s.StudentName +"   " + course1.CourseName +  " derse varış " + studentArriveCourse1);
           }
           
         
           
//           for (Student s:t) {int year, int month, int date, int hourOfDay, int minute)
//
//        Calendar c = Calendar.getInstance();
//        c.set(2018, 5, 9, 14, 30);
//        
//        c.add(Calendar.MINUTE, +10);
//        long ustLimit = c.getTimeInMillis();
//        c.add(Calendar.MINUTE, -20);
//        long altLimit = c.getTimeInMillis();
//        
//               System.out.println(s.StudentName);
//               
//        }
           
           
//        Date simdiDate = new Date();
//        //set(int year, int month, int date, int hourOfDay, int minute)
//
//        Calendar c = Calendar.getInstance();
//        c.set(2018, 5, 9, 14, 30);
//        c.add(Calendar.MINUTE, +10);
//        long ustLimit = c.getTimeInMillis();
//        c.add(Calendar.MINUTE, -20);
//        long altLimit = c.getTimeInMillis();
//        
//        long simdi = simdiDate.getTime();
//        
//        if(simdi > altLimit && simdi < ustLimit) {
//            //kod burada çalışabilir
//        }

//                            
                 
                 
    }
    
    
}
