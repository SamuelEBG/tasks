package pgr112.step13b;

import pgr112.step13b.dto.BookDao;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

import static pgr112.step13b.ReadWriteToFile.readAuthorsFromFile;
import static pgr112.step13b.ReadWriteToFile.readFromFile;

public class Program {

    private final BookRegister register;
    private Boolean running = true;
    private final String booksPath = "tasks/src/main/resources/step13b/textfiles/books.txt";
    private final String authorsPath = "tasks/src/main/resources/step13b/textfiles/authors.txt";

    public Program(){
        register = new BookRegister();
        readFromFile(booksPath, register.books);
        readAuthorsFromFile(authorsPath, register.books);
        // addBooksToDb(register.books);
    }

    public int amountOfColumnsInBooksDb(){
        String amountOfColumns = "SELECT * FROM books";
        try{
            DriverManager.registerDriver(new com.mysql.jdbc.Driver());
            String mysqlUrl = "jdbc:mysql://localhost:3306/Books?useSSL=false";
            Connection conn = DriverManager.getConnection(mysqlUrl, "samuel", "1234");
            PreparedStatement stmt = conn.prepareStatement(amountOfColumns);

            ResultSet rs = stmt.executeQuery();

            ResultSetMetaData rsmd = rs.getMetaData();

            int columns = rsmd.getColumnCount();

            if(columns < 1){
                return 0;
            }
            return columns;
        } catch (SQLException er){
            er.printStackTrace();
        }
        return -1;
    }

    public void printAllBooksFromDb(){
        BookDao bd = new BookDao();
        try{
            bd.listAll().forEach(System.out::println);
        } catch (SQLException er){
            er.printStackTrace();
        }
    }

    public void addBooksToDb(ArrayList<Book> array){
        try{
            BookDao bd = new BookDao();
            for(Book book : array) {
                bd.create(book);
            }
        } catch (SQLException er){
            er.printStackTrace();
        }
    }

    String menuChoices = """
                1 - Print all books in storage\s
                2 - Add new book\s
                3 - Modify a book\s
                4 - Modify a author\s
                5 - Find book by ISBN\s
                6 - Print all authors\s
                7 - Print all books by genre\s
                8 - Print books with amount of pages\s
                9 - Print books by reading time\s
                exit - to exit the program.
                """;

    public void bookMenu() {
        System.out.println(menuChoices);
        // displayMenu();
        // Program sqlRun = new Program();
        Scanner inputs = new Scanner(System.in);
        String choices;

        do{
            choices = inputs.nextLine();
            switch (choices) {
                case "0" -> System.out.println(menuChoices);
                case "1" -> printAllBooksFromDb();
                case "2" -> {
                    Book newBook = createBookFromUser(inputs);
                }

                case "3" -> {
                    System.out.println("What book do you want to modify? Specify by ISBN.");
                    register.books.stream()
                            .map(Book::getAuthor)
                            .distinct()
                            .forEach(System.out::println);
                }

                case "4" -> {
                    System.out.println("Enter a genre to search for books with that genre");
                }

                case "5" -> {
                    System.out.println("Enter an author to search for books by that author");
                }

                case "6" -> {
                    System.out.println("Search for a book by entering its ISBN");
                    String isbn = inputs.nextLine();
                    for (Book book : register.books) {
                        if (book.getIsbn().equalsIgnoreCase(isbn)) {
                            System.out.println(book);
                        }
                    }
                }

                case "7" -> {
                    System.out.println("Enter the ISBN of the book you want to remove");
                }

                case "8" -> {
                    System.out.println("inserting to database");

                }

                case "9" -> {
                    System.out.println("Enter a maximum amount of pages you want to sort books by.");
                }

                default -> {
                    System.out.println("That's not a valid choice");
                    System.out.println("Try something else, or press 0 for menu");
                }

                case "exit" -> {
                    System.out.println("Exiting program");
                    running = false;
                }
            }
        } while (running);
    }

    public Book createBookFromUser(Scanner scan){
        System.out.println("First we need an author, start with authors first name.");
        Author author = createAuthorFromScanner(scan);
        System.out.println("Set an ISBN");
        String isbn = scan.nextLine();
        System.out.println("Enter the title of the book");
        String title = scan.next();
        title += scan.nextLine();
        System.out.println("Enter the amount of pages");
        int numberOfPages = Integer.parseInt(scan.nextLine());
        System.out.println("Set a genre, write with big letters");
        Genre genre = Genre.valueOf(scan.next());
        return new Book (isbn, title, author, numberOfPages, genre);
    }

    public Author createAuthorFromScanner(Scanner scan){
        System.out.println("First we need an author, start with authors first name.");
        String name = scan.nextLine();
        System.out.println("Enter authors last name");
        String surname = scan.nextLine();
        System.out.println("Enter authors date of birth (yyy-mm-dd)");
        LocalDate birthDate = LocalDate.parse(scan.nextLine());
        System.out.println("Enter authors place of birth");
        String birthplace = scan.nextLine();
        return new Author(name, surname, birthDate, birthplace);
    }
}
