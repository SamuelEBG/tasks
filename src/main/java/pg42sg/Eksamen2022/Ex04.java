package pg42sg.Eksamen2022;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.stream.Collectors;

public class Ex04 {
    /**
        This solution here is to make a flatmap of the course Array,
        stream the values in the HashMap students, which will be student objects.
        We use distinct so we don't have any duplicate instances of students.
        Map the student-objects to a String with:
         - The first letter of the first name
         - The first letter of the last name
         - The last 2 digits of the student id.
         - “@hk.no” – to mark it out as an email address.
        For this task I have assumed that an ID consists of 4 digits, therefor retrieving charAt indexes 2 and 3.
        I have used getters for the name, last name and id fields.
     */

    public ArrayList<String> Ex04(Program program){

        return program.courses.stream()
                .flatMap(course -> course.students.values().stream()
                        .distinct())
                .map(Student ->
                        String.valueOf(Student.getFirstName().charAt(0) +
                        String.valueOf(Student.getLastName().charAt(0)) +
                        String.valueOf(Student.getStudentId()).charAt(2) +
                        String.valueOf(Student.getStudentId()).charAt(3)) + "hk.no")
                .collect(Collectors.toCollection(ArrayList::new));
    }

    public static class Program {
        public String programName;
        public ArrayList<Course> courses = new ArrayList<>();

        public ArrayList<Course> getCourses() {
            return courses;
        }
    }

    public static class Course {
        public String courseName;
        public String courseCode;

        public HashMap<Integer, Student> students = new HashMap<>();
    }

    public static class Student {
        public String firstName;
        public String lastName;
        public Integer studentId;

        public Student(String firstName, String lastName, Integer studentId) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.studentId = studentId;
        }

        public String getFirstName() {
            return firstName;
        }

        public String getLastName() {
            return lastName;
        }

        public Integer getStudentId() {
            return studentId;
        }
    }
}
