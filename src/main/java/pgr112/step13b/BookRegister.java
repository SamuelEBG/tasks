package pgr112.step13b;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class BookRegister {

    private final ArrayList<Book> books;

    public void scanBooks () throws FileNotFoundException {
        System.out.println("Scanning starting" + "\n");
        String path = "tasks/src/main/java/pgr112/step13b/books.txt";
        File file = new File(path);
        Scanner input = new Scanner(file);

        while(input.hasNextLine()){
            Book book = new Book();
            book.setIsbn((input.nextLine()));
            book.setTitle(input.nextLine());
            book.setAuthor(input.nextLine());
            book.setNumberOfpages(Integer.parseInt(input.nextLine()));
            book.setGenre(input.nextLine());
            input.nextLine();
            this.books.add(book);
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
    public void addBookFromMenu(){
        Scanner input = new Scanner(System.in);
        System.out.println("Add a book here");
        Book userBook = new Book();
        System.out.println("Set an ISBN");
        userBook.setIsbn(input.nextLine());
        System.out.println("Choose a title");
        String title = input.next();
        title += input.nextLine();
        userBook.setTitle(title);
        System.out.println("Choose an author");
        String author = input.next();
        author += input.nextLine();
        userBook.setAuthor(author);
        System.out.println("Set a number of pages");
        userBook.setNumberOfpages(input.nextInt());
        System.out.println("Set a genre, write with big letters");
        userBook.setGenre(input.next());
        books.add(userBook);
        System.out.println(userBook.getTitle() + " Added to the register \n");
    }

    public void modifyByIsbn(String isbn){
        Scanner inputs = new Scanner(System.in);
        for (Book book : books) {
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
                        book.setGenre(inputs.next());
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

        while(!choices.equals("69")) {
            switch (choices) {
                case "1" -> {
                    for (Book book : books) System.out.println(book.toString());
                    System.out.println("Amount of books " + books.size());
                    inputs.nextLine();
                }
                case "2" -> addBookFromMenu();
                case "3" -> {
                    System.out.println("What book do you want to modify? Specify by ISBN.");
                    String isbn = inputs.nextLine();
                    modifyByIsbn(isbn);
                }
                case "4" -> {
                    System.out.println("Enter a genre to search for books with that genre");
                    String choice = inputs.nextLine();
                    for (Book book : books) {
                        if (choice.equalsIgnoreCase(book.getGenre())) {
                            System.out.println(book);
                        }
                    }
                }
                case "5" -> {
                    System.out.println("Enter an author to search for books by that author");
                    String author = inputs.nextLine();
                    for (Book book : books) {
                        if (author.equalsIgnoreCase(book.getAuthor())) {
                            System.out.println(book);
                        }
                    }
                    System.out.println("Press enter to show menu again");
                    inputs.nextLine();
                }
                case "6" -> {
                    System.out.println("Search for a book by entering its ISBN");
                    String isbn = inputs.nextLine();
                    for (Book book : books) {
                        if (book.getIsbn().equalsIgnoreCase(isbn)) {
                            System.out.println(book);
                        }
                    }
                }
                case "7" -> {
                    System.out.println("Enter the ISBN of the book you want to remove");
                    String bookToRemove = inputs.nextLine();
                    String removedBook;
                    for (int i = 0; i < books.size(); i++) {
                        if (books.get(i).getIsbn().equalsIgnoreCase(bookToRemove)) {
                            removedBook = books.get(i).getTitle();
                            books.remove(i);
                            System.out.println(removedBook + " has been removed from the register");
                            break;
                        }
                    }
                }
                case "8" -> {
                    System.out.println("inserting to database");
                    sqlRun.addBook(books);
                    System.out.println(books.size());
                }
                case "9" -> {
                    System.out.println("Enter a maximum amount of pages you want to sort books by.");
                    System.out.println(sqlRun.getBookByPageLength(inputs.nextInt()));
                }
            }
            displayMenu();
            choices = inputs.nextLine();
        }
        String filePath = "tasks/src/main/java/pgr112/step13b/newbooks.txt";
        newWriter(filePath, books);
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

    public BookRegister(){
        this.books = new ArrayList<>();
    }

    public int getNumberOfBooks() {
        int numberOfBooks = 0;
        for(Book ignored : books){
            numberOfBooks++;
        }
        return numberOfBooks;
    }

    public void addBook(Book book){
            books.add(book);
    }

    public ArrayList<Book> allRegisteredBooks(){
        /*
        ArrayList<Book> result = new ArrayList<>();
        for(Book b : this.books){
            result.add(b);
        }
         */
        return new ArrayList<>(this.books);
    }

    public List<Book> booksInGenre(String genre){

        return books.stream()
                .filter(book -> book.getGenre() != genre)
                .collect(Collectors.toList());
        /*
        ArrayList<Book> result = new ArrayList<>();
        for(Book b : this.books){
            if(b.getGenre().equalsIgnoreCase(genre)) {
                result.add(b);
            }
        }
        return result;
         */
    }

    public List<Book> booksByAuthor(String author){

        return books.stream()
                .filter(book -> book.getAuthor() != author)
                .collect(Collectors.toList());
        /*
        ArrayList<Book> result = new ArrayList<>();
        for(Book b : this.books){
            if(b.getAuthor().equalsIgnoreCase(author)) {
                result.add(b);
            }
        }
        return result;
         */
    }

    public void removeBook(Book book){
        // Use the list method .remove if book in parameter exists in books array.
        books.remove(book);
    }

    public void removeBookByISBN(String isbn){
        // Removes a book under conditions if the book has getIsbn that equalsIgnoreCase the isbn in the parameter.
        books.removeIf(book -> book.getIsbn().equalsIgnoreCase(isbn));

        // Old version that explains what above version does.
        /*
        for(Book book : books){
            if(isbn == book.getIsbn()){
                books.remove(book);
            }
        }
         */
    }
}
