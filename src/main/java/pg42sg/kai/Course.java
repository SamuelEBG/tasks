package pg42sg.kai;

import java.util.ArrayList;

public class Course {

    String courseName;
    Teacher teacher;
    ArrayList<Student> students;

    public Course() {
        this.students = new ArrayList<>();
    }

    public Course(String courseName, Teacher teacher) {
        this.courseName = courseName;
        this.teacher = teacher;
        this.students = new ArrayList<>();
    }

    public Course(String courseName, Teacher teacher, ArrayList<Student> students) {
        this.courseName = courseName;
        this.teacher = teacher;
        this.students = students;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public ArrayList<Student> getStudents() {
        return students;
    }

    public void setStudents(ArrayList<Student> students) {
        this.students = students;
    }

    public void addStudent(Student student){
        students.add(student);
    }
}
