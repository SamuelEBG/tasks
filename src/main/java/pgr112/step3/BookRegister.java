package pgr112.step3;

import java.util.ArrayList;
import java.util.Scanner;

public class BookRegister {

    private final ArrayList<Books> books;
    private int numberOfBooks;
    private boolean running = true;

    public BookRegister(){
        this.books = new ArrayList<>();
        this.numberOfBooks = 0;
    }

    public void displayMenu(){
        ArrayList<String> menu = new ArrayList<>();

        menu.add("Print all books");
        menu.add("Add book");
        menu.add("Print books by genre");
        menu.add("Print books by author");
        menu.add("Print books by reading time");
        menu.add("Exit Program");

        for(int i = 0; i < menu.size(); i ++){
            System.out.println("" + i + " - " + menu.get(i));
        }
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

    public Books userAddFromScanner(Scanner scan){
        String isbn = scan.nextLine();
        String title = scan.nextLine();
        String author = scan.next();
        author += scan.nextLine();
        int pages = Integer.parseInt(scan.nextLine());
        Genre genre = Genre.valueOf(scan.nextLine());
        return new Books(isbn, title, author, pages, genre);
    }



    public int getNumberOfBooks() {
        return numberOfBooks;
    }

    public void addBook(Books book){
        books.add(book);
        numberOfBooks++;
    }

    public ArrayList<Books> allRegisteredBooks(){
        ArrayList<Books> result = new ArrayList<>();
        for(Books b : this.books){
            result.add(b);
        }
        return result;
    }

    public ArrayList<Books> booksInGenre(Genre genre){
        ArrayList<Books> result = new ArrayList<>();
        for(Books b : this.books){
            if(b.getGenre()==genre) {
                result.add(b);
            }
        }
        return result;
    }

    public ArrayList<Books> booksByAuthor(String author){
        ArrayList<Books> result = new ArrayList<>();
        for(Books b : this.books){
            if(b.getAuthor().equalsIgnoreCase(author)) {
                result.add(b);
            }
        }
        return result;
    }

    public ArrayList<Books> booksWithReadingTimeLessThan(int minutes){
        ArrayList<Books> result = new ArrayList<>();

        for(Books b : this.books){
            if(b.readingTime() <= minutes){
                result.add(b);
            }
        }
        return result;
    }

    public void removeBook(Books book){
        if(books.contains(book)){
            books.remove(book);
        }
    }

    public void removeBookByISBN(String isbn){
        for(Books book : books){
            if(book.getIsbn().equalsIgnoreCase(isbn)){
                books.remove(book);
            }
        }

    }

}