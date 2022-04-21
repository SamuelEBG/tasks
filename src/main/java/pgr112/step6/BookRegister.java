package pgr112.step6;

import java.util.ArrayList;

public class BookRegister {

    private final ArrayList<Book> books;

    public BookRegister(){
        this.books = new ArrayList<>();
    }

    public void addBook(Book book){
        books.add(book);
    }

    public ArrayList<Book> searchBooks(String input){

        return books;
    }
}
