package pgr112.step3new;

import pgr112.step3.Books;

import java.util.ArrayList;
import java.util.Scanner;

public class BookStorage {

    private final ArrayList<Book> books;
    private boolean running = true;

    public BookStorage(){
        this.books = new ArrayList<>();
    }

    public void addBook(Book book){
        this.books.add(book);
    }

    String menuChoices = """
                1 - Print all shapes\s
                2 - Add a book\s
                3 - Print books by Genre\s
                4 - Print books by Author\s
                5 - Print books by reading time\s
                6 - Remove book\s
                0 - Show menu\s
                exit - to exit the program.
                """;

    public void bookMenu(){
        System.out.println(menuChoices);
        Scanner scan = new Scanner(System.in);
        String input;
        do{
            input = scan.nextLine();
            switch(input){
                case "0" -> System.out.println(menuChoices);
                case "1" ->
                        books.forEach(System.out::println);
                case "2" -> {
                    System.out.println("Add a book here");
                    addBook(userAddFromScanner(scan));
                }
                case "exit" -> {
                    running = false;
                    System.out.println("Exiting program, au revoir.");
                }
                default -> System.out.println("That's not a valid input, press 0 to show menu or try again.");
            }
        } while(running);
    }

    public Book userAddFromScanner(Scanner scan){
        String isbn = scan.nextLine();
        String title = scan.nextLine();
        String author = scan.next();
        author += scan.nextLine();
        int pages = Integer.parseInt(scan.nextLine());
        Genre genre = Genre.valueOf(scan.nextLine());
        return new Book(isbn, title, author, pages, genre);
    }

    public ArrayList<Book> allBooksInStorage(){
        ArrayList<Book> result = new ArrayList<>();
        for(Book b : books){
            result.add(b);
        }
        return result;
    }

    public ArrayList<Book> booksByGenre(Genre genre){
        ArrayList<Book> temp = new ArrayList<>();
        for(Book b : books){
            if(b.getGenre().equals(genre)){
                temp.add(b);
            }
        }
        return temp;
    }

    public ArrayList<Book> booksByAuthor(String author){
        ArrayList<Book> temp = new ArrayList<>();
        for(Book b : books){
            if(b.getAuthor().equalsIgnoreCase(author)){
                temp.add(b);
            }
        }
        return temp;
    }

    public ArrayList<Book> booksWithReadingTimeLessThan(int minutes){
        ArrayList<Book> temp = new ArrayList<>();
        for(Book b : books){
            if(b.readingTime() < minutes){
                temp.add(b);
            }
        }
        return temp;
    }
}
