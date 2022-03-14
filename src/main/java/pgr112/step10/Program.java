package pgr112.step10;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Optional;
import java.util.Set;

public class Program {
    private final HashSet<Person> personSet;

    public Program(){
        personSet = new HashSet<>();
        enterPersons();
    }

    /**
     *
     * @param age
     * @param name
     *
     * adds person to the HashSet
     * @throws IllegalArgumentException if either name is null, or age is a negative number.
     */

    public void addPerson(int age, String name){
        if(name==null){
            throw new IllegalArgumentException("Name cannot be null");
        }else if(age < 0){
            throw new IllegalArgumentException("Age cannot be negative");
        }else{
            personSet.add(new Person(age, name));
        }
    }

    public void getPersonsOverAge(int age){
        for(Person a : personSet){
            if(age < a.getAge()){
                System.out.println(a);
            }
        }
    }

    private void enterPersons(){
        personSet.add(new Person(2, "hora"));
        personSet.add(new Person(2, "hora"));
        Set<Person> fewPeople = Set.of(new Person(3, "snorre"), new Person(24, "balle"));
        personSet.addAll(fewPeople);
    }

    public Optional<Person> getSamplePerson(String name){
        for(Person a : personSet){
            if(a.getName().equals(name)){
                return Optional.of(a);
            }
        }
        return Optional.empty();
    }

    public void doMagic(){
        for(Person a : personSet){
         System.out.println(a);
        }
    }
}
