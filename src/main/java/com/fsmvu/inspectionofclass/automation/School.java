package com.fsmvu.inspectionofclass.automation;

import java.util.Map;
import java.util.TreeMap;

/**
 *
 * @author yigido
 */
public class School{
    
    public Map<String, Student> students = new TreeMap<>();
    public Map<String, Course> courses = new TreeMap<>();    

    public Student getStudentById(String id) {
        return students.get(id);
    }

    public Student getStudentByCard(String card) {
        for (Student student : students.values()) {
            if(student.cardNumber.equals(card)) return student;
        }
        return null;
    }

    public void addStudent(Student s) {
        students.put(s.cardNumber, s);
    }

    public void addCourse(Course c) {
        courses.put(c.code, c);
    }
    
}
