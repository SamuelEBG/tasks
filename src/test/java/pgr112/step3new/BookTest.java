package pgr112.step3new;

import org.junit.jupiter.api.Test;
import pgr112.step3new.*;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class BookTest {

    @Test
    void addChapter() {
    }

    @Test
    void allChapters() {
    }

    // Method that can be used to create a bookStorage object that contains 5 books.
    private BookStorage initializeBookStorage(){
        BookStorage br = new BookStorage();

        br.addBook(new Book("Harry Potter and the idiots stone", "J.R.R Tolkien", 550, Genre.PORN));
        br.addBook(new Book("1984", "TMZ", 1337, Genre.LEVELINGGUIDE));
        br.addBook(new Book("Star Wars 12", "J.K Rollings", 67 , Genre.CRIME));
        br.addBook(new Book("Star Wars 5", "J.K Rollings", 676 , Genre.CRIME));
        br.addBook(new Book("Da Vincis Code", "Dan Black", 99, Genre.AUTOBIOGRAPHY));

        return br;
    }

    @Test
    void readingTime() {
        // Create a bookStorage object which contains the 5 books
        // and then create an array with those books
        BookStorage readingTime = initializeBookStorage();
        // Now create an arraylist of Book, fill it with all
        // books in storage, which we have a method for.
        ArrayList<Book> all = readingTime.allBooksInStorage();

        assertEquals(67, all.get(2).getNumberOfPages());

    }

    @Test
    void testToString() {
    }

    @Test
    void getGenre() {
    }

    @Test
    void setGenre() {
    }

    @Test
    void getTitle() {
    }

    @Test
    void setTitle() {
    }

    @Test
    void getAuthor() {
    }

    @Test
    void setAuthor() {
    }

    @Test
    void getNumberOfPages() {
    }

    @Test
    void setNumberOfPages() {
    }
}