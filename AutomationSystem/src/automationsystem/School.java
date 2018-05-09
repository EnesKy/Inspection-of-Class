/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package automationsystem;

import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

/**
 *
 * @author yigido
 */
public class School{
    
   public static Map<String, Student> allStudent = new TreeMap<>();
   
   
   
    public ArrayList<Student> getStudentByCourse(Course c){
        ArrayList<Student> temp = new ArrayList<Student>();
        for (Student s:School.allStudent.values()) {
            if (s.courses.contains(c)) {
                temp.add(s);
            }
        }
        
        return temp;
 
    }
}
