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

    public ArrayList<Book> books;

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

    public List<Book> booksInGenre(Genre genre){

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
