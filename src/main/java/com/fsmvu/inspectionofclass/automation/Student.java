package com.fsmvu.inspectionofclass.automation;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

/**
 *
 * @author yigido
 */
public class Student {

    String StudentName;
    public ArrayList<Course> courses = new ArrayList<>();
    int StudentNumber;
    public String CardNumber; // enesten gelen değer

    public Student(String sn, int snu, String cn) {
        StudentName = sn;
        StudentNumber = snu;
        CardNumber = cn;

    }
    
  
   

    public void addCourse(Course code) {

        courses.add(code);

    }

    public String toString() {

        return StudentName;

    }

    public int hashCode() {

        return StudentNumber;

       
    }

    public boolean equals(Object x) {
        if (!(x instanceof Student)) {
            return false;
        }
        Student s = (Student) x;
        return (s.StudentNumber == StudentNumber);
    }

}
