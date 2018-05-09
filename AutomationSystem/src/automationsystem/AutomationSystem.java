/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package automationsystem;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
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
    
    public static void main(String[] args) {
        // TODO code application logic here

            Student s1 = new Student("Mert", 1 ,"D50AB80E69");
            Student s2 = new Student("Bilal", 2,"asdas5");
            Student s3 = new Student("Salim", 3, "asdas4");
            Student s4 = new Student("Enes", 4, "asd4");
            
            
            Student.addStudent(s1);  // Map'e ekleme
            Student.addStudent(s2);  
            Student.addStudent(s3);
            Student.addStudent(s4);
            
            Course course1 = new Course("Matematik" , "BLM101" , "09.05.2018 15:50" );
            Course course2 = new Course("Fizik", "FZ101" , "17:00-18:00" );
           
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
            
            School sc = new School();
           List<Student> t = sc.getStudentByCourse(course1);
           for (Student s:t) {
               System.out.println(s.StudentName +" "+ course1.time);
               
        }
           
           
           
        Date simdi = new Date() ; 
        System.out.println(simdi.toString());
        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy HH:mm");
        String s = sdf.format(simdi);
        System.out.println(s);
                    
            
                 if(course1.time.equals(s)){
                     System.out.println("ebennn");
                 }
                            
    }
    
}
