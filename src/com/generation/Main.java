package com.generation;

import com.said.execpciones.CourseNotFoundException;
import com.said.execpciones.StudentNotFoundException;

public class Main {

    public static void main(String[] args) {
	    StudentService studentService = new StudentService();

        studentService.addStudent(new Student( "Santiago", "1020", 33 ));
        studentService.addStudent(new Student( "Carlos", "1030", 31 ));
        studentService.addStudent(new Student( "Ian", "1040", 28 ));
        studentService.addStudent(new Student( "Elise", "1050", 26 ));
        try {
            studentService.enrollStudents( "Math", "1030" );
            studentService.enrollStudents( "Art", "1030" );
            studentService.enrollStudents( "Math", "1040" );
            studentService.enrollStudents( "Art", "1021" );
        } catch (StudentNotFoundException | CourseNotFoundException e) {
            System.out.println(e.getMessage());
        } 
        studentService.showEnrolledStudents("Art");
        studentService.showEnrolledStudents("Math");
        studentService.showAllStudents();
        
   
    }
}
