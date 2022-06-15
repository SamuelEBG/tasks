package pg42sg.Eksamen2022;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.stream.Collectors;

public class Ex04 {
    /**
        This solution here is to make a flatmap of the course Array,
        stream the values in the HashMap students, which will be student objects.
        We use distinct so we don't have any duplicates of students.
        Map the student-objects to a String with:
         - The first letter of the first name
         - The first letter of the last name
         - The last 2 digits of the student id.
         - “@hk.no” – to mark it out as an email address.
        Methods where put to static for testing purposes and no encapsulation is used since it is not
        needed for this solution.
     */
    public static ArrayList<String> Ex04(Program program){

        return program.courses.stream()
                .flatMap(course -> course.students.values().stream()
                        .distinct())
                .map(Student ->
                        String.valueOf(Student.firstName.charAt(0) +
                        String.valueOf(Student.lastName.charAt(0)) +
                        String.valueOf(Student.studentId).charAt(2) +
                        String.valueOf(Student.studentId).charAt(3)) + "hk.no")
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
    }
}
