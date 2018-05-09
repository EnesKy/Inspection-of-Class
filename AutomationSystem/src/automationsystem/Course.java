/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package automationsystem;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author yigido
 */
public class Course {
    
    String CourseName;
    String time;
    String date;
    String CourseCode;
    
    
     
   public static List<String> classrooms = new ArrayList<>();
   
    public Course(String className ,String coursecode , String time){
   
        CourseName  = className; CourseCode = coursecode; this.time = time; 
   
    }
      
    public void addClassrooms(String code) { 
    
        classrooms.add(code);
    
    }
        
    public String toString(){
   
        return CourseName + " , " + CourseCode + " , " + time + " , " + date;
   
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
