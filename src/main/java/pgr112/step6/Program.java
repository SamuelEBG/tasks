package pgr112.step6;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Program {

    protected final String path = "tasks/src/main/resources/step6/books.txt";

    public BookRegister register;

    public Program(){
        this.register = new BookRegister();
        try{
            readFromFile();
        }catch (FileNotFoundException error){
            error.printStackTrace();
        }
        menu();
    }

    private void readFromFile() throws FileNotFoundException {

        File file = new File(path);
        Scanner scan = new Scanner(file);

        while(scan.hasNextLine()){
            String isbn = scan.nextLine();
            String title = scan.nextLine();
            String author = scan.nextLine();
            int numberOfPages = Integer.parseInt(scan.nextLine());
            Genre genre = Genre.valueOf(scan.nextLine());
            scan.nextLine();
            register.addBook(new Book(isbn, title, author, numberOfPages, genre));
        }
        System.out.println("Scanning done");
    }

    Boolean running = true;

    public void addBookFromScanner(Scanner input){
        System.out.println("Enter the ISBN for the new book");
        String isbn = input.nextLine();
        System.out.println("Enter a title");
        String title = input.next();
        title += input.nextLine();
        System.out.println("Add a author");
        String author = input.next();
        author += input.nextLine();
        System.out.println("Specify amount of pages");
        int numberOfPages = Integer.parseInt(input.nextLine());
        System.out.println("Add a genre and dont be retarded");
        Genre genre = Genre.valueOf(input.nextLine().toUpperCase());
        input.nextLine();
        register.addBook( new Book(isbn, title, author, numberOfPages, genre));
    }

    public void editBookFromScanner(Scanner scan){
        String isbn = scan.nextLine();

    }

    public void menu(){
        Scanner input = new Scanner(System.in);
        String menuChoices = """
                1 - Show all books in the book register\s
                2 - Add a book\s
                3 - Modify a book\s
                4 - Find a book based on author\s
                5 - Find a book based on genre\s
                6 - Find a book based on ISBN\s
                exit - to exit the program.
                """;
        String choice;

        System.out.println(menuChoices);
        do{
            choice = input.nextLine();
            switch(choice){
                case "0" -> System.out.println(menuChoices);
                case "1" -> {
                    register.allRegisteredBooks();
                    System.out.println(
                            "Here are all the " + register.getSize() + " books in the register.");
                    System.out.println("press 0 to show menu again");
                }
                case "2" -> addBookFromScanner(input);

                case "3" -> {
                    System.out.println("Which book do you want to edit? Specify by ISBN");
                    editBookFromScanner(input);
                }

                case "4" -> {
                    System.out.println("Enter an authors name to find their books");
                    ArrayList<Book> res = (register.findBooksByAuthor(input.nextLine()));
                    if(res.isEmpty()){
                        System.out.println("No books by that author");
                    } else{
                        System.out.println(res);
                    }
                }

                case "5" -> {
                    System.out.println("Enter a specific genre and find all books by that genre");
                    register.findBooksByGenre(input.nextLine());
                }

                case "6" -> {
                    System.out.println("Enter the ISBN of the book you want to show");
                    System.out.println(register.findBooksByIsbn(input.nextLine()));
                }

                case "404" -> {
                    System.out.println("Exiting program and writing books to file");
                    running = false;
                }
                default -> {
                    System.out.println("thats not a valid choice");
                    System.out.println("press \"0\" to show menu");
                }

            }
        }while(running);
    }
}
