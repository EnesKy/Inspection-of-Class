/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package automationsystem;

import java.util.ArrayList;
import java.util.Date;
import java.util.Map;
import java.util.TreeMap;

/**
 *
 * @author yigido
 */
public class School{
    
   public static Map<String, Student> allStudent = new TreeMap<>();
   
   
    public ArrayList<Student> getStudentByCourse(Course c , Date studentArrive ,Date studentArriveErken, Date studentArriveGec){
        
        ArrayList<Student> temp = new ArrayList<Student>();
        ArrayList<Student> dersteVarOlanOgrenciler = new ArrayList<Student>();
        for (Student s:School.allStudent.values()) {
            
            if (s.courses.contains(c)) {
                temp.add(s);
            }
        }
            for (int i = 0; i < temp.size(); i++) { 
                                       // rfid den gelen deger
                if(temp.get(i).CardNumber == "D50AB80E69"){
                     if ((c.time.compareTo(studentArrive) > 0 && studentArrive.compareTo(studentArriveErken) >=0) || 
                             (c.time.compareTo(studentArrive) <= 0 && studentArriveGec.compareTo(studentArrive) >= 0) ) {
      
                    System.out.println("Öğrenci ders saatinde geldi. Derste var");
                    
                     dersteVarOlanOgrenciler.add(temp.get(i));
      
                    } else{
                         System.out.println("Ogrencı derste yok");
                     }
                   
                    
                }  
            }
        
        return dersteVarOlanOgrenciler;
 
    }
    
    
      // map'e   
     void addStudent(Student stu){
        School.allStudent.put(stu.CardNumber , stu);
    }
    
    
    
    
}
