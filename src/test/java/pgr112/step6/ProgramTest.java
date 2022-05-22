package pgr112.step6;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class ProgramTest {

    BookRegister br;

    @BeforeEach
    void setup(){
        br = new BookRegister();
        initializeBookStorageAutomatically();
    }

    private void initializeBookStorageAutomatically(){
        br.addBook(new Book("12345","Harry Potter and the idiots stone", "J.R.R Tolkien", 550, Genre.PORN));
        br.addBook(new Book("23456","1984", "TMZ", 1337, Genre.LEVELINGGUIDE));
        br.addBook(new Book("73483","Star Wars 12", "J.K Rollings", 67 , Genre.CRIME));
        br.addBook(new Book("91823","Star Wars 5", "J.K Rollings", 676 , Genre.CRIME));
        br.addBook(new Book("93876","Da Vincis Code", "Dan Black", 99, Genre.AUTOBIOGRAPHY));
        br.addBook(new Book("93872","Book by J.R.R Tolkien", "J.R.R Tolkien", 993, Genre.AUTOBIOGRAPHY));
        br.addBook(new Book("19283","Hello ich bin book", "J.R.R Tolkien", 5, Genre.AUTOBIOGRAPHY));
    }

    @Test
    void createArrayWithBooksByGenre(){
        // BookStorage br = initializeBookStorage();

        Book testBook = new Book("73625","stupid title", "dumb ass author", 723, Genre.CRIME);
        ArrayList<Book> crimeBooks = br.findBooksByGenre(String.valueOf(testBook.getGenre()));

        assertEquals(crimeBooks.get(0).getGenre(), Genre.CRIME);
        assertEquals(crimeBooks.get(1).getGenre(), Genre.CRIME);

        crimeBooks.get(0).setGenre(Genre.PORN);
        assertNotEquals(crimeBooks.get(0).getGenre(), Genre.CRIME);
    }

    @Test
    void createArrayWithBooksByAuthor(){
        Book testBook = new Book("81726","im a book", "J.R.R Tolkien", 723, Genre.CRIME);
        ArrayList<Book> booksByTolkien = br.findBooksByAuthor(testBook.getAuthor());

        String author = "J.R.R Tolkien";

        assertTrue(booksByTolkien.get(0).getAuthor().equalsIgnoreCase("J.R.R Tolkien"));
        assertEquals(author, booksByTolkien.get(1).getAuthor());
        assertEquals(booksByTolkien.get(2).getAuthor(), testBook.getAuthor());

        booksByTolkien.get(1).setAuthor("Dan Brown");

        assertNotEquals(author, booksByTolkien.get(1).getAuthor());
    }

    @Test
    void testIsbnInBookClass(){

        String testIsbn = "00000";

        Book b1 = new Book("81726","im a book", "J.R.R Tolkien", 723, Genre.CRIME);

        assertEquals("81726", b1.getIsbn());

        b1.setIsbn(testIsbn);

        assertEquals("00000", b1.getIsbn());
    }

    @Test
    void testPagesInBooks(){

        int newPages = 99999;

        Book b1 = new Book("81726","im a book", "J.R.R Tolkien", 723, Genre.CRIME);

        int supposedReadingTime = b1.getNumberOfPages() * 3;

        assertEquals(supposedReadingTime, b1.readingTime());
        assertEquals(723, b1.getNumberOfPages());

        b1.setNumberOfPages(newPages);

        assertEquals(99999, b1.getNumberOfPages());
        assertEquals((99999 * 3), b1.readingTime());
    }

    @Test
    public void getBookByPages() {
        // Now create an arraylist of Book, fill it with all
        // books in storage, which we have a method for.
        ArrayList<Book> all = br.allRegisteredBooks();

        assertEquals(67, all.get(2).getNumberOfPages());
    }

    @Test
    public void changePagesInBook(){
        Book testBook = new Book("74635","stupid title", "dumb ass author", 723, Genre.FICTION);

        assertEquals(723, testBook.getNumberOfPages());

        testBook.setNumberOfPages(500);

        assertEquals(500, testBook.getNumberOfPages());

        testBook.setNumberOfPages(-509);

        assertEquals(2, testBook.getNumberOfPages());

        testBook.setNumberOfPages(0);

        assertEquals(2, testBook.getNumberOfPages());
    }

    @Test
    public void changeAuthorInBook(){
        Book testBook = new Book("12763","50 shades of grey", "J.R.R Tolkien", 723, Genre.FICTION);

        assertEquals("J.R.R Tolkien", testBook.getAuthor());

        testBook.setAuthor("Dan Brown");

        assertEquals("Dan Brown", testBook.getAuthor());
    }

    @Test
    void changeGenreInBook(){
        Book testBook = new Book("99873","50 shades of grey", "J.R.R Tolkien", 723, Genre.FICTION);

        assertEquals(Genre.FICTION, testBook.getGenre());

        testBook.setGenre(Genre.FANTASY);

        assertEquals(Genre.FANTASY, testBook.getGenre());
    }

    @Test
    void editTitleInBook(){
        Book testBook = new Book("99873","50 shades of grey", "J.R.R Tolkien", 723, Genre.FICTION);

        testBook.setAuthor(" ");

        assertEquals(" ", testBook.getAuthor());


    }

    @Test
    public void amountOfBooksInStorage(){

        ArrayList<Book> tempArray = br.allRegisteredBooks();

        assertEquals(7, tempArray.size());
    }
}