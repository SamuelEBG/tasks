package pgr112.step13b;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class ReadWriteToFile {

    public static void readFromFile(String filePath, ArrayList<Book> booksArray){
        System.out.println("Scanning starting" + "\n");
        File file = new File(filePath);
        try(Scanner input = new Scanner(file)){
            while(input.hasNextLine()){
                String isbn = input.nextLine();
                String title = input.nextLine();
                Author author = new Author(input.next(), input.nextLine());
                int numberOfPages = Integer.parseInt(input.nextLine());
                Genre genre = Genre.valueOf(input.nextLine().toUpperCase());
                input.nextLine();
                booksArray.add(new Book(isbn, title, author, numberOfPages, genre));
            }
            System.out.println("Scanning done.");
        } catch (FileNotFoundException error){
            error.printStackTrace();
        }
    }

    public static void readAuthorsFromFile(String filePath, ArrayList<Book> books){
        System.out.println("scanning authors");
        File file = new File(filePath);
        try(Scanner input = new Scanner(file)){
            while(input.hasNextLine()){
                String name = input.nextLine();
                String surname = input.nextLine();
                LocalDate dateOfBirth = LocalDate.parse(input.nextLine());
                String country = input.nextLine();
                input.nextLine();
                Author author = new Author(name, surname, dateOfBirth, country);
                books.stream()
                        .filter(book -> (
                                book.getAuthor().getName() + book.getAuthor().getSurname()).equals(name + " " + surname))
                        .forEach(book -> book.setAuthor(author));
            }
        } catch (FileNotFoundException error){
            error.printStackTrace();
        }
    }

    public void newWriter(String filePath, ArrayList<Book> books){
        try{
            FileWriter writer = new FileWriter(filePath);
            for (Book book : books) {
                writer.write(book.toString() + "\n");
            }
            writer.close();
        }
        catch(IOException ea){
            ea.getStackTrace();
        }
    }
}
