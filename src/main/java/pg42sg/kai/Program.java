package pg42sg.kai;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Program {

    public List<String> listAllUniqueTeachers(List<Course> courses){

        return courses.stream()
                .map(cours -> cours.getTeacher().getName())
                .distinct()
                .collect(Collectors.toList());
    }

    public List<String> listAllStudentsWithThreeOrMoreCourses(List<Course> courses) {

        return courses.stream()
                .flatMap(course -> course.getStudents().stream()
                        .filter(Student -> Student.getCourses().size() >= 3))
                .map(Student::getName)
                .distinct()
                .collect(Collectors.toList());
    }

    public List<Student> listAllStudentsWithTeacherAgedOver50(List<Course> courses){

        return courses.stream()
                .flatMap(course -> course.getStudents().stream()
                        .filter(Course -> course.getTeacher().getAge() > 50))
                .distinct()
                .collect(Collectors.toList());
    }

    public Long listAmountOfStudentsWithTeachersAgedOver50(List<Course> courses){

        return courses.stream()
                .flatMap(course -> course.getStudents().stream()
                        .filter(Course -> course.getTeacher().getAge() > 50))
                .distinct()
                .count();
    }

    public List<String> listStudentsWithUnevenAgeAndTheirFavoriteColor(List<Course> courses){

        return courses.stream()
                .flatMap(course -> course.getStudents().stream()
                        .filter(Student -> Student.getAge() % 2 == 1))
                .map(Student -> String.format(
                        Student.getName() + ", age: " +
                        Student.getAge() + ", " + "favourite color: " +
                        Student.getFavoriteColor()))
                .distinct()
                .collect(Collectors.toList());
    }
}
