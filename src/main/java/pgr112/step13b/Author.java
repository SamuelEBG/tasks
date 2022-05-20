package pgr112.step13b;

import java.time.LocalDate;

public class Author {

    private int id;
    private String name;
    private String surname;
    private LocalDate dateOfBirth;
    private String country;

    public Author(){
        this.name = "";
        this.surname = "";
        this.dateOfBirth = LocalDate.EPOCH;
        this.country = "";
    }

    public Author(String name, String surname){
        this.name = name;
        this.surname = surname;
        this.dateOfBirth = LocalDate.EPOCH;
        this.country = "";
    }

    public Author(String name, String surname, LocalDate dateOfBirth, String country){
        this.name = name;
        this.surname = surname;
        this.dateOfBirth = dateOfBirth;
        this.country = country;
    }

    @Override
    public String toString(){
        return String.format(
            "Name: %s %s - Date of birth: %s - Country of origin: %s",
            this.name, this.surname, this.dateOfBirth, this.country
        );
    }

    public int getId() {return this.id;}
    public void setId(int id) {this.id = id;}
    public String getName() {return this.name;}
    public void setName(String name) {this.name = name;}
    public String getSurname() {return this.surname;}
    public void setSurname(String surname) {this.surname = surname;}
    public LocalDate getDateOfBirth() {return this.dateOfBirth;}
    public void setDateOfBirth(LocalDate dateOfBirth) {this.dateOfBirth = dateOfBirth;}
    public String getCountry() {return this.country;}
    public void setCountry(String country) {this.country = country;}
}
