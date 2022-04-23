package pgr112.step13b;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Program {

    private BookRegister register;
    private Boolean running = true;

    public Program(){
        register = new BookRegister();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        }
        catch(ClassNotFoundException exception){
            exception.printStackTrace();
        }
    }

    private final String path = "tasks/src/main/resources/step6/books.txt";

    public void scanBooks () throws FileNotFoundException {
        System.out.println("Scanning starting" + "\n");
        File file = new File(path);
        Scanner input = new Scanner(file);

        while(input.hasNextLine()){
            String isbn = input.nextLine();
            String title = input.nextLine();
            String author = input.nextLine();
            int numberOfPages = Integer.parseInt(input.nextLine());
            Genre genre = Genre.valueOf(input.nextLine().toUpperCase());
            input.nextLine();
            register.addBook(new Book(isbn, title, author, numberOfPages, genre));
        }
        System.out.println("Scanning done.");

        //for (Book book : booksArray) {
        //    booksArray.toString();
        //}

        // String filePath = "src/main/java/pgr112/step5/opg8.txt";
        // newWriter(filePath, artistArray);
    }

    public void scanBooksException(){
        try{
            scanBooks();
        }
        catch (FileNotFoundException ballefjong){
            System.out.println("File path wrong, book file not found");
            ballefjong.getStackTrace();
        }
    }

    public void addBookFromMenu(Scanner scan){
        System.out.println("Set an ISBN");
        String isbn = scan.nextLine();
        System.out.println("Write the title of the book");
        String title = scan.next();
        title += scan.nextLine();
        System.out.println("Enter the name of the author");
        String author = scan.next();
        author += scan.nextLine();
        System.out.println("Enter the amount of pages");
        int numberOfPages = Integer.parseInt(scan.nextLine());
        System.out.println("Set a genre, write with big letters");
        Genre genre = Genre.valueOf(scan.next());
        register.addBook(new Book(isbn, title, author, numberOfPages, genre));
        System.out.println(title + " Added to the register \n");
    }

    public void modifyByIsbn(String isbn){
        Scanner inputs = new Scanner(System.in);
        for (Book book : register.books) {
            if (book.getIsbn().equalsIgnoreCase(isbn)) {
                System.out.println("What information do you want to modify?");
                System.out.println("ISBN - Author - Title - Pages - Genre");
                String modify = inputs.next().toLowerCase();
                switch (modify) {
                    case "isbn" -> {
                        System.out.println("Enter a new ISBN");
                        book.setIsbn(inputs.nextLine());
                        System.out.println("The ISBN for " + book.getTitle() + " has been set to " + book.getIsbn());
                    }
                    case "author" -> {
                        System.out.println("Enter a new author");
                        String author = inputs.next();
                        author += inputs.nextLine();
                        book.setAuthor(author);
                        System.out.println("The author for the book " + book.getTitle() + "has been set to " + book.getAuthor());
                    }
                    case "title" -> {
                        System.out.println("Type a new title");
                        String oldTitle = book.getTitle();
                        String title = inputs.next();
                        title += inputs.nextLine();
                        book.setTitle(title);
                        System.out.println("The title for the book " + oldTitle + "has been set to " + book.getTitle());
                    }
                    case "pages" -> {
                        System.out.println("Enter a new amount of pages");
                        int pages = inputs.nextInt();
                        book.setNumberOfpages(pages);
                        System.out.println("The number of pages for " + book.getTitle() + "has been set to " + pages);
                    }
                    case "genre" -> {
                        System.out.println("Enter a new genre");
                        book.setGenre(Genre.valueOf(inputs.next().toUpperCase()));
                        System.out.println("The genre for " + book.getTitle() + " has been changed to " + book.getGenre());
                    }
                }
            }
        }
    }

    // br.allRegisteredBooks().stream().forEach(System.out::println);

    public void bookMenu() throws SQLException {

        scanBooksException();
        displayMenu();
        Program sqlRun = new Program();
        Scanner inputs = new Scanner(System.in);
        String choices = inputs.nextLine();

        while(running){
            switch (choices) {
                case "0" -> displayMenu();
                case "1" -> {
                    // for (Book book : register.books) System.out.println(book.toString());
                    register.books.forEach(System.out :: println);
                    System.out.println("Amount of books " + register.books.size());
                }
                case "2" -> addBookFromMenu(inputs);
                case "3" -> {
                    System.out.println("What book do you want to modify? Specify by ISBN.");
                    String isbn = inputs.nextLine();
                    modifyByIsbn(isbn);
                }
                case "4" -> {
                    System.out.println("Enter a genre to search for books with that genre");
                    String choice = inputs.nextLine();
                    for (Book book : register.books) {
                        if (choice.equalsIgnoreCase(book.getGenre().toString())) {
                            System.out.println(book);
                        }
                    }
                }

                case "5" -> {
                    System.out.println("Enter an author to search for books by that author");
                    String author = inputs.nextLine();
                    for (Book book : register.books) {
                        if (author.equalsIgnoreCase(book.getAuthor())) {
                            System.out.println(book);
                        }
                    }
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
                    String bookToRemove = inputs.nextLine();
                    String removedBook;
                    for (int i = 0; i < register.books.size(); i++) {
                        if (register.books.get(i).getIsbn().equalsIgnoreCase(bookToRemove)) {
                            removedBook = register.books.get(i).getTitle();
                            register.books.remove(i);
                            System.out.println(removedBook + " has been removed from the register");
                            break;
                        }
                    }
                }

                case "8" -> {
                    System.out.println("inserting to database");
                    sqlRun.addBook(register.books);
                    System.out.println(register.books.size());
                }

                case "9" -> {
                    System.out.println("Enter a maximum amount of pages you want to sort books by.");
                    System.out.println(sqlRun.getBookByPageLength(inputs.nextInt()));
                }

                default -> {
                    System.out.println("That's not a valid choice");
                    System.out.println("Try something else, or press 0 for menu");
                }

                case "404" -> {
                    System.out.println("Exiting program");
                    running = false;
                }
            }
            choices = inputs.nextLine();
        }
        String filePath = "tasks/src/main/java/pgr112/step13b/newbooks.txt";
        newWriter(filePath, register.books);
        System.out.println("Exiting and printing to file");
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

    public void displayMenu(){

        ArrayList<String> menu = new ArrayList<>();
        menu.add("Show all books");
        menu.add("Add book");
        menu.add("Modify book");
        menu.add("Search for book by genre");
        menu.add("Search for book by author");
        menu.add("Search for book by ISBN");
        menu.add("Remove a book");
        menu.add("Add all books to Database");
        menu.add("Get books by pages from database");
        menu.add("Exit the program");

        for(int i = 1; i < 10; i ++){
            System.out.println("" + i + "->" + menu.get(i - 1));
        }
    }

    public ArrayList<Book> getBookByPageLength(int pages) throws SQLException{
            // Method for getting pages less than the number in the parameter.
        if(pages <= 0) {
            System.out.println("a book can't have negative pages, don't be silly.");
        }
        ArrayList<Book> tempBooks = new ArrayList<>();
        ResultSet rs = null; // This is the result of the query
        String pagesQuery = "SELECT * FROM books " +
                "WHERE pages < ?";
        try (Connection con = DriverManager
                .getConnection("jdbc:mysql://localhost:3306/books?useSSL=false", "oopuser", "root");
             //
             PreparedStatement getBooksByPage = con.prepareStatement(pagesQuery, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY)) {
            // Savepoint save1 = con.setSavepoint();
            getBooksByPage.setInt(1, pages); // Setter method in the query is set to the value from the parameter.
            if (!getBooksByPage.execute()) {
                System.out.println("No books with that amount of pages");
            } else {
                rs = getBooksByPage.getResultSet();
                while(rs.next()){
                    var b = new Book();
                    b.setIsbn(rs.getString("isbn"));
                    b.setAuthor(rs.getString("author"));
                    b.setTitle(rs.getString("title"));
                    b.setNumberOfpages(rs.getInt("pages"));
                    b.setGenre(Genre.valueOf(rs.getString("genre")));
                    tempBooks.add(b);
                }
            }
        }
        return tempBooks;
    }

    public void addBook(ArrayList<Book> books) throws SQLException{

        // Here we create a prepared statement for the database.
        // This is a statement that we want to execute many times,
        // This prepared statement is sent to the database right away, and is therefor compiled.
        // Not only does it contain a SQL statement, but a SQL statement that has been compiled already.
        // So the DBMS can just run the prepared statement without having to compile it first.
        // Prepared statements always treat client-supplied data as content of a parameter and never as a part of an SQL statement.
        // So this is a way of protecting against SQL injections.
        String addBookStatement = "INSERT INTO books VALUES(default, ?, ?, ?, ?, ?)";
        // These question marks will be called upon later down in the code, that is where we will enter
        // the information to be passed into the DBMS.
        try(Connection con = DriverManager
                .getConnection("jdbc:mysql://localhost:3306/books?useSSL=false", "oopuser", "root");
        PreparedStatement insertBook = con.prepareStatement(addBookStatement)
        ){
            con.setAutoCommit(false);
            Savepoint save1 = con.setSavepoint();
            // We use a for loop to go through the book array and entering all the books in the DBMS
            // with their information.
            for (Book book : books) {
                // The first parameter is the setter method for the SQL prepared statement.
                insertBook.setString(1, book.getIsbn());
                insertBook.setString(2, book.getTitle());
                insertBook.setString(3, book.getAuthor());
                insertBook.setInt(4, book.getNumberOfPages());
                insertBook.setString(5, book.getGenre().toString());
                insertBook.execute();
                if (book.getGenre().toString().equalsIgnoreCase(";drop tables")) {
                    System.out.println("Not allowed to drop tables, shame on you!");
                    con.rollback(save1);
                } else {
                    con.commit();
                }
            }

            /*
            String insertSql = "INSERT INTO books(isbn, title, author, pages, genre)"
                    + "VALUES('" +
                    book.getIsbn() + "', '" +
                    book.getTitle() + "', '" +
                    book.getAuthor() + "', '" +
                    book.getNumberOfPages() + "', '" +
                    book.getGenre() +
                    "')";
            stmt.executeUpdate(insertSql);
            System.out.println("inserting" + book.getTitle());

             */

        } catch(SQLException exception){
            exception.printStackTrace();
        }
    }
}
