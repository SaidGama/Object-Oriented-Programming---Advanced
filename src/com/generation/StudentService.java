package com.generation;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
import com.said.execpciones.CourseNotFoundException;
import com.said.execpciones.StudentNotFoundException;

public class StudentService {

    private HashMap<String, Course> courseList = new HashMap<>();

    private HashMap<String, Student> students = new HashMap<>();

    private HashMap<String, List<Course>> coursesEnrolledByStudents = new HashMap<>();

    public void addStudent(Student student){
        students.put(student.getId(), student);
    }

    public void showAllStudents(){
        students.values().forEach((s) -> System.out.println(s));

    }

    public void showAllCourses() {
        courseList.values().forEach( (course) -> System.out.println(course));
    }

    public StudentService() {
        courseList.put("Math", new Course("Math", 10, "Aurelio Baldor"));
        courseList.put("Physics", new Course("Physics", 10, "Albert Einstein"));
        courseList.put("Art", new Course("Art", 10, "Pablo Picasso"));
        courseList.put("History", new Course("History", 10, "Sima Qian"));
        courseList.put("Biology", new Course("Biology", 10, "Charles Darwin"));
    }

    public void enrollStudents(String courseName, String studentID) throws StudentNotFoundException, CourseNotFoundException {
        Course course = courseList.get(courseName);
        if(course == null){
            throw new CourseNotFoundException();
        }
        Student student = students.get(studentID);
        if (student == null) {
            throw new StudentNotFoundException();
        }
        if (!coursesEnrolledByStudents.containsKey(studentID)) {
            coursesEnrolledByStudents.put(studentID, new ArrayList<>());
        }
        coursesEnrolledByStudents.get(studentID).add(course);
    }

    public void showEnrolledStudents(String courseName) {
        System.out.println(courseName + " enrolled: ");
        Course course = courseList.get(courseName);
        Set<String> allStudents = coursesEnrolledByStudents.keySet();
        for (String key : allStudents) {
            List<Course> allCourses = coursesEnrolledByStudents.get(key);
            if(allCourses.contains(course)){
                System.out.println("Student: "+ key);
            }
        }
        System.out.println();
    }

    public void unEnrollStudents(String courseName, String studentID) {
        Course course = courseList.get(courseName);
        if (coursesEnrolledByStudents.containsKey(studentID)) {
            coursesEnrolledByStudents.get(studentID).remove(course);
        }
    }

    
    public HashMap<String, Student> getStudents() {
        return students;
    }// getter Students

    public HashMap<String, Course> getCourseList() {
        return courseList;
    }

    public void setCourseList(HashMap<String, Course> courseList) {
        this.courseList = courseList;
    }

    public void setStudents(HashMap<String, Student> students) {
        this.students = students;
    }

    public HashMap<String, List<Course>> getCoursesEnrolledByStudents() {
        return coursesEnrolledByStudents;
    }

    public void setCoursesEnrolledByStudents(HashMap<String, List<Course>> coursesEnrolledByStudents) {
        this.coursesEnrolledByStudents = coursesEnrolledByStudents;
    }
}
