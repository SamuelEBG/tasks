package pgr112.step3new;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class BookTest {

    BookStorage br;

    @BeforeEach
        void setup(){
        br = new BookStorage();
    }

    private BookStorage initializeBookStorage(){

        br.addBook(new Book("Harry Potter and the idiots stone", "J.R.R Tolkien", 550, Genre.PORN));
        br.addBook(new Book("1984", "TMZ", 1337, Genre.LEVELINGGUIDE));
        br.addBook(new Book("Star Wars 12", "J.K Rollings", 67 , Genre.CRIME));
        br.addBook(new Book("Star Wars 5", "J.K Rollings", 676 , Genre.CRIME));
        br.addBook(new Book("Da Vincis Code", "Dan Black", 99, Genre.AUTOBIOGRAPHY));

        return br;
    }


    // Method that can be used to create a bookStorage object that contains 5 books.

    @Test
    public void getBookByPages() {
        // Create a bookStorage object which contains the 5 books
        // and then create an array with those books
        BookStorage pages = initializeBookStorage();
        // Now create an arraylist of Book, fill it with all
        // books in storage, which we have a method for.
        ArrayList<Book> all = pages.allBooksInStorage();

        assertEquals(67, all.get(2).getNumberOfPages());
    }

    @Test
    public void changePagesInBook(){
        Book testBook = new Book("stupid title", "dumb ass author", 723, Genre.FICTION);

        assertEquals(723, testBook.getNumberOfPages());

        testBook.setNumberOfPages(500);

        assertEquals(500, testBook.getNumberOfPages());
    }

    @Test
    public void changeAuthorInBook(){
        Book testBook = new Book("50 shades of grey", "J.R.R Tolkien", 723, Genre.FICTION);

        assertEquals("J.R.R Tolkien", testBook.getAuthor());

        testBook.setAuthor("Dan Brown");

        assertEquals("Dan Brown", testBook.getAuthor());
    }

    @Test
    public void amountOfBooksInStorage(){

        BookStorage storage = initializeBookStorage();

        ArrayList<Book> tempArray = storage.allBooksInStorage();

        assertEquals(5, storage.amountOfBooksInStorage());

    }
}