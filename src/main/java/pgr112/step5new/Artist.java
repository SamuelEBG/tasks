package pgr112.step5new;

import java.time.LocalDate;
import java.time.Period;

public class Artist {

    private String id;
    private String artistName;
    private LocalDate dateOfBirth;
    private String city;
    private String country;

    public Artist (){
        this.id = "";
        this.artistName = "";
        this.dateOfBirth = LocalDate.EPOCH;
        this.city = "";
        this.country = "";
    }

    public Artist (String id,String artistName, LocalDate dateOfBirth, String city, String country){
        this.id = id;
        this.artistName = artistName;
        this.dateOfBirth = dateOfBirth;
        this.city = city;
        this.country = country;
    }

    @Override
    public String toString(){
        return  "ID: " + id +
                "\n Name: " + artistName +
                "\n Date of birth: " + dateOfBirth +
                "\n Age: " + getAge() +
                "\n City: " + city +
                "\n Country: " + country;
    }

    public int getAge(){
        return Period.between(this.dateOfBirth, LocalDate.now()).getYears();
    }

    public String getArtistName() {
        return artistName;
    }

    public void setArtistName(String artistName) {
        this.artistName = artistName;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

}
