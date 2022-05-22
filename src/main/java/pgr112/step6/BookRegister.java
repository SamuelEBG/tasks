package pgr112.step6;

import org.apache.commons.lang3.EnumUtils;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class BookRegister {

    private final ArrayList<Book> books;
    public BookRegister(){
        this.books = new ArrayList<>();
    }

    public void addBook(Book book){
        books.add(book);
    }

    public ArrayList<Book> allRegisteredBooks(){
        return books;
    }

    public ArrayList<Book> findBooksByAuthor(String author){
        return books.stream()
                .filter(book -> book.getAuthor().equalsIgnoreCase(author))
                .collect(Collectors.toCollection(ArrayList::new));
    }

    public ArrayList<Book> findBooksByGenre(String genre){
        if(!EnumUtils.isValidEnum(Genre.class, genre)){
            return null;
        } else {
            return books.stream()
                    .filter(b -> b.getGenre().equals(Genre.valueOf(genre)))
                    .collect(Collectors.toCollection(ArrayList::new));
        }
    }

    public ArrayList<Book> findBooksByIsbn(String isbn){
        return books.stream()
                .filter(b -> b.getIsbn().equals(isbn))
                .collect(Collectors.toCollection(ArrayList::new));
    }

    public int getSize(){
        return books.size();
    }
}
