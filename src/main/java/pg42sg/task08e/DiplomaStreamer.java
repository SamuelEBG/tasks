package pg42sg.task08e;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class DiplomaStreamer {

    public ArrayList<String> resultDp(ArrayList<DiplomaProject> projects, Course course){
        /*
         Filter diplomaprojects by authors that have a certain course (parameter)
         in their hashmap of courses, parameter is a course object,
         so do not have to worry about searching for certain courseId.
         Student has to have passed the course with atleast 2 or more in grade.
         the value of the key/value pair is the grade in the hashMap.

         After that we make a map out of only the titles of the diploma projects.
         Now we have a stream of only diplomaproject-titles,
         since students can be a part of several diplomas, we have to use distinct
         to avoid duplicates.
         Collect to a new arraylist.
         */

        return projects.stream()
                .filter(p -> p.authors.stream()
                        .filter(student -> student.courseList.keySet().stream().anyMatch(c -> c.courseId.contains("pg4200")))
                        .filter(student -> student.courseList.get(course) >= 2)
                        .count() > 0
                )
                .map(p -> p.title)
                .distinct()
                .collect(Collectors.toCollection(ArrayList::new));
/*
        return projects.stream()
                .filter(d -> d.authors.stream()
                        .filter(student -> student.courseList.containsKey(course))
                        .anyMatch(student -> student.courseList.get(course) >= 2))
                .map(diplomaProject -> diplomaProject.title)
                .distinct()
                .collect(Collectors.toCollection(ArrayList::new));

 */
    }
}
