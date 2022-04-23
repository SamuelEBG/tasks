package pgr112.step6;

import java.util.ArrayList;
import java.util.List;

public class BookRegister {

    private final ArrayList<Book> books;
    private int size;
    public BookRegister(){
        this.books = new ArrayList<>();
    }

    public void allRegisteredBooks(){
        books.forEach(System.out::println);
    }

    public void addBook(Book book){
        books.add(book);
        size++;
    }


    public ArrayList<Book> searchBooks(String input){

        return books;
    }

    public int getSize(){
        return this.size;
    }
}
