package pg42sg.Eks2021;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.*;

class StudentMapTest {

    Faker faker = new Faker();

    private final StudentMap studmap = new StudentMap();
    private final ArrayList<String> names = new ArrayList<>();

    @Test
    void testAddHundredRandomStudents(){

        List<Integer> list= IntStream.range(0, 1000)
                .boxed()
                .collect(Collectors.toList());
        Collections.shuffle(list);

        int studentLimit = 1000;

        for(int i = 0; i < studentLimit; i++){
            StudentMap.Student student = new StudentMap.Student();

            student.setId(list.get(i));
            student.setName(faker.name().firstName() + " " + faker.name().lastName());

            studmap.put(student.getId(), student);
            System.out.println(student.getId() + " " + student.getName() + " added");
        }
        System.out.println("aa");
    }
}