package pgr112.step13b;

import java.util.Date;

public class Author {


    private int id;
    private String name;
    private String surName;
    private Date dateOfBirth;

    public Author(){
    }

    public Author(int id, String name, String surName, Date dateOfBirth){
        this.id = id;
        this.name = name;
        this.surName = surName;
        this.dateOfBirth = dateOfBirth;
    }

    public int getId() {return id;}
    public void setId(int id) {this.id = id;}
    public String getName() {return name;}
    public void setName(String name) {this.name = name;}
    public String getSurName() {return surName;}
    public void setSurName(String surName) {this.surName = surName;}
    public Date getDateOfBirth() {return dateOfBirth;}
    public void setDateOfBirth(Date dateOfBirth) {this.dateOfBirth = dateOfBirth;}
}
