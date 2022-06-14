package pg42sg.kai;

import java.util.ArrayList;

public class Student {

    String name;
    int age;
    String favoriteColor;
    ArrayList<Course> courses;

    public Student() {
        this.courses = new ArrayList<>();
    }

    public Student(String name, int age, String favoriteColor) {
        this.name = name;
        this.age = age;
        this.favoriteColor = favoriteColor;
        this.courses = new ArrayList<>();
    }

    public Student(String name, int age, String favoriteColor, ArrayList<Course> courses) {
        this.name = name;
        this.age = age;
        this.favoriteColor = favoriteColor;
        this.courses = courses;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getFavoriteColor() {
        return favoriteColor;
    }

    public void setFavoriteColor(String favoriteColor) {
        this.favoriteColor = favoriteColor;
    }

    public ArrayList<Course> getCourses() {
        return courses;
    }

    public void setCourses(ArrayList<Course> courses) {
        this.courses = courses;
    }

    public void addCourse(Course course){
        this.courses.add(course);
    }
}
