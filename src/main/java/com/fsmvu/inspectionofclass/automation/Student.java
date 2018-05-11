package com.fsmvu.inspectionofclass.automation;

import java.util.List;
import java.util.ArrayList;

/**
 *
 * @author yigido
 */
public class Student {

    int studentNumber;
    String studentName;
    public String cardNumber; // enesten gelen değer, RFID cardNumber
    public List<Course> courses = new ArrayList<>();

    public Student(String sn, int snu, String cn) {
        studentName = sn;
        studentNumber = snu;
        cardNumber = cn;
    }
    
    public void addCourse(Course code) {
        courses.add(code);
    }

    public String toString() {
        return studentName;
    }

    public int hashCode() {
        return studentNumber;
    }

    public boolean equals(Object x) {
        if (!(x instanceof Student)) {
            return false;
        }
        Student s = (Student) x;
        return (s.studentNumber == studentNumber);
    }

}