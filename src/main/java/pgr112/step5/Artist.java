package pgr112.step5;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class Artist {
    private String artistName;
    private LocalDate dateOfBirth; //First assign a field with LocalDate as datatype
    private String city;
    private String country;
                            // Specify dateOfBirth as String in parameter
    public Artist(String artistName, String dateOfBirth, String city, String country) {
        this.artistName = artistName;
        this.dateOfBirth = LocalDate.parse(dateOfBirth); // Enter date as String in constructor
        this.city = city;                                // And parse the String to a LocalDate.
        this.country = country;
    }
    public Artist(){
        this.artistName = "";
        this.dateOfBirth = LocalDate.ofEpochDay(0);
        this.city = "";
        this.country = "";
    }

    public void printArtist(){
        System.out.println("Name: " + this.artistName);
        System.out.println("Date of birth: " + this.dateOfBirth);
        System.out.println("City: " + this.city);
        System.out.println("Country: " + this.country);
        System.out.println("---");
    }

    private final String path = "src/main/java/pgr112/step5/artists.txt";

    public void scanArtists () throws FileNotFoundException {
        System.out.println("Scanning starting" + "\n");
        File file = new File(path);
        ArrayList<Artist> artistArray = new ArrayList<>();
        Scanner input = new Scanner(file);

        while(input.hasNextLine()){
            Artist artist = new Artist();
            artist.setArtistName(input.nextLine());
            artist.setDateOfBirth(input.nextLine());
            artist.setCity(input.nextLine());
            artist.setCountry(input.nextLine());
            input.nextLine();
            artistArray.add(artist);
        }
        artistArray.get(3).setArtistName("21 Savage is dead");
        artistArray.get(4).setArtistName("Fat ass hoe");
        artistArray.get(3).setCountry("Funeral town");

        for (Artist artist : artistArray) {
            artist.printArtist();
        }

        String filePath = "src/main/java/pgr112/step5/opg8.txt";
        newWriter(filePath, artistArray);
    }

    @Override
    public String toString(){
        return this.artistName + '\n' +
                this.dateOfBirth + '\n' +
                this.city + '\n' +
                this.country + '\n' +
                "---" + '\n';
    }
    public static void newWriter(String filePath, ArrayList<Artist> artistArray){
        try{
            FileWriter writer = new FileWriter(filePath);
            for (Artist artist : artistArray) {
                writer.write(artist.toString());
            }
            writer.close();
        }
        catch(IOException ea){
            ea.getStackTrace();
        }
    }

    public static void scanArtistException(){
        Artist artist = new Artist();
        try{
            artist.scanArtists();
        }
        catch (FileNotFoundException ballefjong){
            System.out.println("oopsiedaise");
            ballefjong.getStackTrace();
        }
    }


    public String getArtistName() {return artistName;}
    public void setArtistName(String artistName) {this.artistName = artistName;}
    public LocalDate getDateOfBirth() {return dateOfBirth;}
    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = LocalDate.parse(dateOfBirth);
    }
    public String getCity() {return city;}
    public void setCity(String city) {this.city = city;}
    public String getCountry() {return country;}
    public void setCountry(String country) {this.country = country;}
}
