package pgr112.step10new;

import java.util.*;
import java.util.stream.Collectors;

public class Program {

    public HashSet<Person> personHashSet;

    public Program(){
        this.personHashSet = new HashSet<>();
        addPersons();
    }

    public List<Person> getPeopleOlderThan(int age){
        return personHashSet.stream().
                filter(person -> person.getAge() > age).
                collect(Collectors.toList());
    }

    public Optional<Person> youngestPerson(){
        return personHashSet.stream().
                min(Comparator.comparing(Person::getAge));
    }

    public Optional<String> oldestPersonName(){
        return personHashSet.stream().
                max(Comparator.comparing(Person::getAge)).
                map(Person::getName);
    }

    public void addPerson(String name, int age){
        if(name == null){
            throw new IllegalArgumentException("Name cannot be null");
        } else if(age < 0){
            throw new IllegalArgumentException("A person cannot have negative age");
        } else{
            personHashSet.add(new Person(age, name));
        }
    }

    public Optional<Person> getSamplePerson(String name){

        return personHashSet.stream().
                filter(person -> person.getName().equals(name)).
                findFirst();
    }

    private void addPersons(){

        Set<Person> peepel = Set.of(
            new Person(20, "Stig-Joel af Gudrunsdottir"),
            new Person(123, "Igor Snigelfitta"),
            new Person(56, "Anders andersson"),
            new Person(20, "Reidar Ulrichzen"),
            new Person(24, "Fjodor Felkullad"),
            new Person(87, "Anders Gregorsson"),
            new Person(65, "Wali gustav Björk"),
            new Person(28, "Magnus Sedin"),
            new Person(98, "Thomas Gustaffson"),
            new Person(56, "Petter Lundgren"),
            new Person(45, "Philip Nilsson"),
            new Person(71, "Christoffer Liljedahl")
        );

        personHashSet.addAll(peepel);
    }
}
