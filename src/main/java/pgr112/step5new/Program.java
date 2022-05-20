package pgr112.step5new;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class Program {

    ArrayList<Artist> artists = new ArrayList<>();

    public Program(){
        readFile();
        menu();
    }

    public void readFile() {
        File file = new File("tasks/src/main/java/pgr112/step5new/artists.txt");

        try(Scanner scan = new Scanner(file)){
            addArtistFromFile(scan);
        } catch(IOException error){
            error.printStackTrace();
        }
    }

    public void writeArtistsToFile(){
        String fileName = "tasks/src/main/java/pgr112/step5new/newArtists.txt";
        try(FileWriter writer = new FileWriter(fileName)){
            for(Artist artist : artists){
                writer.write(artist.getId() + "\n");
                writer.write(artist.getArtistName() + "\n");
                writer.write(String.valueOf(artist.getDateOfBirth()) + "\n");
                writer.write(artist.getCity() + "\n");
                writer.write(artist.getCountry() + "\n");
                writer.write("---" + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void addArtistFromFile(Scanner scan){
        while(scan.hasNextLine()){
            String id = scan.nextLine();
            String name = scan.nextLine();
            LocalDate date = LocalDate.parse(scan.nextLine());
            String city = scan.nextLine();
            String country = scan.nextLine();
            scan.nextLine();
            artists.add(new Artist(id, name, date, city, country));
        }
    }

    public Artist getArtistById(Scanner scan){
        String id = scan.nextLine();
        return artists.stream().filter(artist -> artist.getId().equals(id)).findFirst().orElse(null);
    }

    public Artist addArtistFromScanner(Scanner scan){
        System.out.println("Enter a 3 digit id");
        String id = scan.nextLine();
        System.out.println("Enter the artists name");
        String name = scan.next();
        name += scan.nextLine();
        System.out.println("Enter artists birthday in YYYY-MM-DD format");
        LocalDate date = LocalDate.parse(scan.nextLine());
        System.out.println("Enter what city the artist is from");
        String city = scan.nextLine();
        System.out.println("Enter what country the artis is from");
        String country = scan.nextLine();
        return new Artist(id, name, date, city, country);
    }

    public void editArtistBasedOnId(Scanner scan){
        System.out.println("Enter the ID of the artist you want to edit");
        String id = scan.nextLine();
        String choice;
        for(Artist artist : artists){
            if(artist.getId().equals(id)){
                System.out.println("What information about " + artist.getArtistName() + " do you want to edit?");
                choice = scan.nextLine();
                switch (choice){
                    case "id" -> {
                        System.out.println("Enter the artists new 3 digit ID");
                        artist.setId(scan.nextLine());
                    }

                    case "name" -> {
                        System.out.println("Enter the artists new name");
                        artist.setArtistName(scan.nextLine());
                    }

                    case "date of birth" ->{
                        System.out.println("Enter the artists new date of birth in YYYY-MM-DD format");
                        artist.setDateOfBirth(LocalDate.parse(scan.nextLine()));
                    }

                    case "city" -> {
                        System.out.println("Enter the new city where the artist is from");
                        artist.setCity(scan.nextLine());
                    }

                    case "country" -> {
                        System.out.println("Enter the new country where the artist is from");
                        artist.setCountry(scan.nextLine());
                    }

                    default -> System.out.println("Not a recognized value, exiting edit");
                }
                break;
            }
        }
    }

    public void menu(){
        Scanner input = new Scanner(System.in);
        String menuChoices = """
                1 - Get information about all artists\s
                2 - Retrieve artist based on id\s
                3 - Add artist\s
                4 - Edit artist based on id\s
                5 - Exit the program\s
                """;
        String choice;
        System.out.println(menuChoices);
        do{
            choice = input.nextLine();
            switch(choice){
                case "0" -> System.out.println(menuChoices);

                case "1" -> {
                        System.out.println("Here are all the artists");
                        artists.forEach(System.out::println);
                }

                case "2" -> {
                    System.out.println("Retrieve artist based on id");
                    Artist result = getArtistById(input);
                    if(result == null){
                        System.out.println("No artist with that id");
                    } else {
                        System.out.println(result);
                    }
                }

                case "3" -> {
                    System.out.println("Add artist");
                    artists.add(addArtistFromScanner(input));
                    System.out.println(artists.get(artists.size()-1) + "\nWas added to the database");
                }

                case "4" -> {
                    System.out.println("Edit artist based on id");
                    editArtistBasedOnId(input);
                }

                case "5" -> {
                    System.out.println("Exiting program");
                    writeArtistsToFile();
                }
                default -> System.out.println("not a menu choice, try again or press 0 to show menu.");
            }
        } while(!choice.equals("5"));
    }
}
