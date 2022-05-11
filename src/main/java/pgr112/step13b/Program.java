package pgr112.step13b;

import java.time.LocalDate;
import java.util.Scanner;

import static pgr112.step13b.ReadWriteToFile.readFromFile;

public class Program {

    private final BookRegister register;
    private Boolean running = true;
    private final String path = "tasks/src/main/resources/step6/books.txt";

    public Program(){
        register = new BookRegister();
        readFromFile(path, register.books);
    }

    String menuChoices = """
                1 - Print all books in storage\s
                2 - Add new book\s
                3 - Modify book\s
                4 - Modify a shape\s
                5 - Print all circles\s
                6 - Print all rectangles\s
                7 - Print all squares\s
                8 - Remove a shape\s
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
                case "1" -> {
                    register.books.forEach(System.out :: println);
                    System.out.println("Amount of books " + register.books.size());
                }
                case "2" -> {
                    Book newBook = createBookFromUser(inputs);

                }
                case "3" -> {
                    System.out.println("What book do you want to modify? Specify by ISBN.");

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
        String filePath = "tasks/src/main/java/pgr112/step13b/newbooks.txt";
        System.out.println("Exiting and printing to file");
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
