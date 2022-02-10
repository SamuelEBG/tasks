package pgr112.step10;

import java.util.Optional;

public class Main {
    public static void main(String[] args){
        var prog = new Program();
        var p1 = new Person(5, "hore horeson");
        /*
        Optional<Person> p2 = prog.getSamplePerson("hora");

        if(p2.isPresent()){
            System.out.println(p2.get().getName());
        }

        prog.addPerson(97, "hejsan");
        prog.addPerson(56, "hoppsan");
        prog.addPerson(1, "anders");
        prog.addPerson(9, "johan");
        prog.addPerson(36, "matsa");
        prog.addPerson(234, "fredrik");
        prog.addPerson(37, "wali");
        prog.addPerson(26, "magnus");
        prog.addPerson(2, "petter");
        prog.addPerson(53, "greger");
        prog.getPersonsOverAge(5);
        */
        prog.addPerson(1, "samuel");
    }
}
