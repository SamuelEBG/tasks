package pgr112.step3;

import java.util.ArrayList;
import java.util.Scanner;

public class BookRegister {

    private ArrayList<Books> books;
    //private ArrayList<BookSolution> books;
    private int numberOfBooks;

    public void bookMenu(){
        displayMenu();
        BookRegister br = new BookRegister();
        Scanner inputs = new Scanner(System.in);
        Scanner userChoices = new Scanner(System.in);
        int input = inputs.nextInt();

        switch(input){
            case 1:
                br.allRegisteredBooks().stream().forEach(System.out::println);
                System.out.println("Add a book here");
                Books userBook = new Books();
                System.out.println("Set an ISBN");
                userBook.setIsbn(userChoices.next());
                System.out.println("Choose a title");
                userBook.setTitle(userChoices.next());
                System.out.println("Choose an author");
                userBook.setAuthor(userChoices.next());
                System.out.println("Set a number of pages");
                userBook.setNumberOfpages(userChoices.nextInt());
                System.out.println("Set a genre, write with big letters");
                userBook.setGenre(Genre.valueOf(userChoices.next()));
                br.addBook(userBook);
                System.out.println(br.books.get(0).toString());
                break;
        }
    }

    public void displayMenu(){

        ArrayList<String> menu = new ArrayList<>();
        menu.add("Add book");
        menu.add("Print book");
        menu.add("Exit Program");

        for(int i = 0; i < menu.size(); i ++){
            System.out.println("" + i + "->" + menu.get(i));
        }
    }

    public BookRegister(){
        this.books = new ArrayList<>();
        this.numberOfBooks = 0;
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