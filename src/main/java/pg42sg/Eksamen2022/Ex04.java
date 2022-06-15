package pg42sg.Eksamen2022;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class Ex04 {

    public static void main(String[] args) {
        Student student = new Student("Harald", "Hadrada", 1066);
        Student student1 = new Student("Nicolas", "Davout", 1823);

        Program prog = new Program();
        Course course = new Course();
        course.students.put(student.studentId, student);
        System.out.println(course.students.get(student.studentId));
        course.students.put(student1.studentId, student1);
        System.out.println(course.students.get(student1.studentId));
        prog.courses.add(course);

        Ex04(prog).forEach(System.out::println);

    }

    /*
    Student -> Student.firstName.substring(0) +
                        Student.lastName.substring(0) +
                        Student.studentId.toString().substring(2,3) + "@hk.no"
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
