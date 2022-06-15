package pg42sg.kai;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ProgramTest {

    Program prog = new Program();

    public ArrayList<Course> createStudents(){
        ArrayList<Course> courses = new ArrayList<>();
        ArrayList<Student> students = new ArrayList<>();

        Teacher teacher1 = new Teacher("röven", 50);
        Teacher teacher2 = new Teacher("arslet", 20);
        Teacher teacher3 = new Teacher("snoppen", 70);

        Course programmering = new Course("Programmering", teacher1);
        Course algdat = new Course("Algoritmer och datastrukturer", teacher2);
        Course matematik = new Course("Matematik", teacher3);
        Course informationssikkerhet = new Course("Informationssikkerhet", teacher3);
        Course databaser = new Course("Databaser", teacher2);
        courses.add(programmering);
        courses.add(algdat);
        courses.add(matematik);
        courses.add(informationssikkerhet);
        courses.add(databaser);

        Student student1 = new Student("Student1", 20, "red");
        student1.addCourse(programmering);
        student1.addCourse(algdat);
        students.add(student1);
        Student student2 = new Student("Student2", 25, "blue");
        student2.addCourse(matematik);
        student2.addCourse(databaser);
        students.add(student2);
        Student student3 = new Student("Student3", 30, "yellow");
        student3.addCourse(matematik);
        student3.addCourse(algdat);
        student3.addCourse(programmering);
        students.add(student3);
        Student student4 = new Student("Student4", 35, "pink");
        student4.addCourse(programmering);
        student4.addCourse(databaser);
        students.add(student4);
        Student student5 = new Student("Student5", 40, "black");
        student5.addCourse(algdat);
        student5.addCourse(databaser);
        student5.addCourse(informationssikkerhet);
        students.add(student5);
        Student student6 = new Student("Student6", 45, "green");
        student6.addCourse(matematik);
        student6.addCourse(informationssikkerhet);
        students.add(student6);
        Student student7 = new Student("Student7", 50, "green");
        student7.addCourse(databaser);
        student7.addCourse(informationssikkerhet);
        student7.addCourse(matematik);
        student7.addCourse(algdat);
        students.add(student7);
        Student student8 = new Student("Student8", 55, "red");
        student8.addCourse(matematik);
        student8.addCourse(informationssikkerhet);
        student8.addCourse(databaser);
        student8.addCourse(programmering);
        student8.addCourse(algdat);
        students.add(student8);

        for(Course course : courses){
            for(Student student : students){
                for(int i = 0; i < student.getCourses().size(); i ++){
                    if (student.getCourses().get(i).equals(course)){
                        course.addStudent(student);
                    }
                }
            }
        }
        return courses;
    }

    @Test
    void testCourses(){
        ArrayList<Course> result = new ArrayList<>(createStudents());
        result.forEach(course -> {
            System.out.println(course.getCourseName());
            System.out.println("students in this course");
            course.getStudents().stream().map(Student::getName).forEach(System.out::println);
        });
    }

    @Test
    void testListAllTeachers(){
        ArrayList<String> teacherNames = new ArrayList<>(prog.listAllUniqueTeachers(createStudents()));

        assertEquals(3, teacherNames.size());
        assertTrue(teacherNames.get(2).equalsIgnoreCase("snoppen"));
    }

    @Test
    void testStudentsWithThreeOrMoreCourses(){
        ArrayList<String> result = new ArrayList<>(prog.listAllStudentsWithThreeOrMoreCourses(createStudents()));

        assertEquals(4, result.size());
    }

    @Test
    void testStudentsWithTeachersOverAge50(){
        ArrayList<Student> result = new ArrayList<>(prog.listAllStudentsWithTeacherAgedOver50(createStudents()));

        assertEquals(6, result.size());
    }

    @Test
    void testReturnStudentsWithTeachersOverAge50AsLong(){
        Long result = prog.listAmountOfStudentsWithTeachersAgedOver50(createStudents());

        assertEquals(6, result);
    }

    @Test
    void testStudentsWithOddAgeAndTheirFavouriteColor(){
        ArrayList<String> result = new ArrayList<>(prog.listStudentsWithUnevenAgeAndTheirFavoriteColor(createStudents()));

        result.forEach(System.out::println);
    }


    /*
    public ArrayList<Course> generateCourses(int n){

        ArrayList<Course> result = new ArrayList<>();
        ArrayList<Student> students = new ArrayList<>();

        Random random = new Random();
        int age = random.nextInt(100);

        Course pg4200 = new Course();
        Teacher teacher = new Teacher("röven", age);
        pg4200.courseName = "AlgDat";
        pg4200.teacher = teacher;

        result.add(pg4200);

        for (int i = 1; i < n; i++){
            Course c = new Course();
            int cid = 4220 + i;
            c.courseName = "Course " + cid;

            result.add(c);
        }
        return result;
    }

    public ArrayList<Student> generateStudents(int n, ArrayList<Course> courses){
        ArrayList<Student> result = new ArrayList<>();
        Random random = new Random();
        // Student is created, a random course is entered into its courses
        //
        for (int i = 0; i < n; i++){
            Student s = new Student();
            s.name = "Student " + i;
            ArrayList<Course> cou = new ArrayList<>();

            for(int j= 0; j< courses.size() - 3; j++){
                int ra = random.nextInt(2);
                int grade = random.nextInt(5);
                cou.put(courses.get(j + ra), grade);
            }

            int pg = random.nextInt(5);
            if(pg > 0){
                cou.put(courses.get(0), pg);
            }

            s.courseList = cou;

            result.add(s);
        }

        return result;
    }

     */

}