package pgr112.largeTask;

import pgr112.step5.Artist;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class BookRegister {

    private ArrayList<Book> books;
    //private ArrayList<BookSolution> books;
    private int numberOfBooks;

    private final String path = "src/main/java/pgr112/largeTask/books.txt";

    public void scanBooks () throws FileNotFoundException {
        this.books = new ArrayList<>();
        System.out.println("Scanning starting" + "\n");
        File file = new File(path);
        // ArrayList<Book> booksArray = new ArrayList<>();
        Scanner input = new Scanner(file);

        while(input.hasNextLine()){
            Book book = new Book();
            book.setIsbn(input.nextLine());
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
            System.out.println("oopsiedaise");
            ballefjong.getStackTrace();
        }
    }

    // br.allRegisteredBooks().stream().forEach(System.out::println);

    public void bookMenu(){
        scanBooksException();
        displayMenu();
        BookRegister br = new BookRegister();
        Scanner inputs = new Scanner(System.in);
        Scanner userChoices = new Scanner(System.in);
        int input = inputs.nextInt();

        while(input != 8) {
            if(input == 1){
                System.out.println(books.size());
                for(int i = 0; i < books.size(); i++){
                    System.out.println(books.get(i).toString());
                }
                System.out.println("Going back to meny");

            }else if(input == 2) {
                System.out.println("Add a book here");
                Book userBook = new Book();
                System.out.println("Set an ISBN");
                userBook.setIsbn(userChoices.next());
                System.out.println("Choose a title");
                userBook.setTitle(userChoices.next());
                System.out.println("Choose an author");
                userBook.setAuthor(userChoices.next());
                System.out.println("Set a number of pages");
                userBook.setNumberOfpages(userChoices.nextInt());
                System.out.println("Set a genre, write with big letters");
                userBook.setGenre(userChoices.next());
                books.add(userBook);
                System.out.println(userBook.getTitle() + " Added to the register \n" );
            }else if(input == 3){
                System.out.println("What book do you want to modify? Specify by ISBN.");
                String userInput = userChoices.next();
                for(int i = 0; i < books.size(); i++){
                    if(userInput.equalsIgnoreCase(books.get(i).getIsbn())){
                        System.out.println("What information do you want to modify?");
                        System.out.println("ISBN - Author - Title - Pages - Genre");
                        String modify = userChoices.next().toLowerCase();
                        switch(modify){
                            case "isbn":
                                System.out.println("Enter a new ISBN");
                                books.get(i).setIsbn(userChoices.next());
                                System.out.println("The ISBN for " + books.get(i).getTitle() + " has been set to " + books.get(i).getIsbn());
                                break;
                            case "author":
                                System.out.println("Enter a new author");
                                String author = userChoices.next();
                                author+=userChoices.nextLine();
                                books.get(i).setAuthor(author);
                                System.out.println("The author for the book " + books.get(i).getTitle() + "has been set to " + books.get(i).getAuthor());
                                break;
                            case "title":
                                System.out.println("Type a new title");
                                String oldtitle = books.get(i).getTitle();
                                String title = userChoices.next();
                                title+=userChoices.nextLine();
                                books.get(i).setTitle(title);
                                System.out.println("The title for the book " + oldtitle + "has been set to " + books.get(i).getTitle());
                                break;
                            case "pages":
                                System.out.println("Enter a new amount of pages");
                                int pages = userChoices.nextInt();
                                books.get(i).setNumberOfpages(pages);
                                System.out.println("The number of pages for " + books.get(i).getTitle() + "has been set to " + pages);
                                break;
                            case "genre":
                                System.out.println("Enter a new genre");
                                books.get(i).setGenre(userChoices.next());
                                System.out.println("The genre for " + books.get(i).getTitle() + " has been changed to " + books.get(i).getGenre());
                                break;
                        }
                    }
                }

            }else if(input == 4){
                System.out.println("Enter a genre to search for books with that genre");
                String choice = userChoices.next();
                for(int i = 0; i < books.size(); i++){
                    if(choice.equalsIgnoreCase(books.get(i).getGenre())){
                        System.out.println(books.get(i).toString());
                    }
                }

            }else if(input == 5){
                System.out.println("Enter an author to search for books by that author");
                String author = userChoices.next();
                for(int i = 0; i < books.size(); i++){
                    if(author.equalsIgnoreCase(books.get(i).getAuthor())){
                        System.out.println(books.get(i).toString());
                    }
                }

            }else if(input == 6){
                System.out.println("Search for a book by entering its ISBN");
                String isbn = userChoices.next();
                for(int i = 0; i < books.size(); i++){
                    if(isbn.equalsIgnoreCase(books.get(i).getIsbn())){
                        System.out.println(books.get(i).toString());
                    }
                }

            }else if(input == 7){
                System.out.println("Enter the ISBN of the book you want to remove");
                String remover = userChoices.next();
                String removed = "";
                for(int i = 0; i < books.size(); i++){
                    if(remover.equalsIgnoreCase(books.get(i).getIsbn())){
                        removed = books.get(i).getTitle();
                        books.remove(i);
                        System.out.println(removed + " has been removed from the register");
                    }
                }
            }
            displayMenu();
            input = inputs.nextInt();
        }
        String filePath = "src/main/java/pgr112/largeTask/newbooks.txt";
        newWriter(filePath, books);
        System.out.println("Exiting and printing to file");
    }

    public void newWriter(String filePath, ArrayList<Book> books){
        try{
            FileWriter writer = new FileWriter(filePath);
            for (Book book : books) {
                writer.write(book.toString());
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
        menu.add("Exit the program");

        for(int i = 1; i < 9; i ++){
            System.out.println("" + i + "->" + menu.get(i - 1));
        }
    }

    public BookRegister(){
        this.books = new ArrayList<>();
        this.numberOfBooks = 0;
    }

    public int getNumberOfBooks() {
        return numberOfBooks;
    }

    public boolean addBook(Book book){
        if(numberOfBooks <= 19){
            books.add(book);
            numberOfBooks++;
            return true;
        }
        return false;
    }

    public ArrayList<Book> allRegisteredBooks(){
        ArrayList<Book> result = new ArrayList<>();
        for(Book b : this.books){
            result.add(b);
        }
        return result;
    }

    public ArrayList<Book> booksInGenre(String genre){
        ArrayList<Book> result = new ArrayList<>();
        for(Book b : this.books){
            if(b.getGenre().equalsIgnoreCase(genre)) {
                result.add(b);
            }
        }
        return result;
    }

    public ArrayList<Book> booksByAuthor(String author){
        ArrayList<Book> result = new ArrayList<>();
        for(Book b : this.books){
            if(b.getAuthor().equalsIgnoreCase(author)) {
                result.add(b);
            }
        }
        return result;
    }

    public void removeBook(Book book){
        if(books.contains(book)){
            books.remove(book);
        }
    }

    public void removeBookByISBN(String isbn){
        for(Book book : books){
            if(book.getIsbn().equalsIgnoreCase(isbn)){
                books.remove(book);
            }
        }
    }
}
