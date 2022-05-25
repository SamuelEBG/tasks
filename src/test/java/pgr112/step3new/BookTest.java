package pgr112.step3new;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class BookTest {

    BookStorage br;
    private Book testBook;

    @BeforeEach
    void setup(){
        br = new BookStorage();
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

    // Method that can be used to create a bookStorage object that contains 5 books.

    @Test
    void addChaptersToABook(){
        testBook = new Book("12345", "test book with chapters", "chapter author", 543, Genre.FANTASY);
        Chapter c1 = new Chapter("intro", 20);
        Chapter c2 = new Chapter("middle stuff", 59);
        Chapter c3 = new Chapter("unexpected turnaround", 47);
        Chapter c4 = new Chapter("exciting ending", 80);

        testBook.addChapter(c1);
        testBook.addChapter(c2);
        testBook.addChapter(c3);
        testBook.addChapter(c4);

        assertEquals(4, testBook.getChapters().size());
    }

    @Test
    void testEditChaptersInBook(){

        testBook = new Book("12345", "test book with chapters", "chapter author", 543, Genre.FANTASY);
        ArrayList<Chapter> chapters = new ArrayList<>();

        Chapter c1 = new Chapter("intro", 20);
        Chapter c2 = new Chapter("middle stuff", 59);
        Chapter c3 = new Chapter("unexpected turnaround", 47);
        Chapter c4 = new Chapter("exciting ending", 80);

        chapters.add(c1);
        chapters.add(c2);
        chapters.add(c3);
        chapters.add(c4);

        testBook.addChapter(c1);
        assertEquals(1, testBook.getChapters().size());

        testBook.setChapters(chapters);
        assertEquals(4, testBook.getChapters().size());

    }

    @Test
    void removeChapterInBook(){
        testBook = new Book("12345", "test book with chapters", "chapter author", 543, Genre.FANTASY);
        Chapter c1 = new Chapter("intro", 20);
        Chapter c2 = new Chapter("middle stuff", 59);
        Chapter c3 = new Chapter("unexpected turnaround", 47);
        Chapter c4 = new Chapter("exciting ending", 80);

        testBook.addChapter(c1);
        testBook.addChapter(c2);
        testBook.addChapter(c3);
        testBook.addChapter(c4);

        assertEquals("middle stuff", testBook.getChapters().get(1).getChapterTitle());

        testBook.getChapters().remove(1);

        assertEquals(3, testBook.getChapters().size());

        testBook.addChapter(new Chapter("outro", 59));

        assertEquals(4, testBook.getChapters().size());
        assertEquals("outro", testBook.getChapters().get(3).getChapterTitle());
        assertEquals(47, testBook.getChapters().get(1).getChapterPages());
    }

    @Test
    void updateInfoInChapters(){
        testBook = new Book("12345", "test book with chapters", "chapter author", 543, Genre.FANTASY);
        Chapter c1 = new Chapter("intro", 20);
        Chapter c2 = new Chapter("middle stuff", 59);
        Chapter c3 = new Chapter("unexpected turnaround", 47);
        Chapter c4 = new Chapter("exciting ending", 80);

        testBook.addChapter(c1);
        testBook.addChapter(c2);
        testBook.addChapter(c3);
        testBook.addChapter(c4);

        testBook.getChapters().get(2).setChapterPages(92);

        assertNotEquals(47, testBook.getChapters().get(2).getChapterPages());

        testBook.getChapters().get(0).setChapterTitle("not the intro anymore");

        assertEquals("not the intro anymore", testBook.getChapters().get(0).getChapterTitle());

        testBook.getChapters().remove(0);

        assertEquals(59, testBook.getChapters().get(0).getChapterPages());
    }

    @Test
    void testGetBooksWithReadingTimeLessThan(){

        int readingTimeMinutes = 400;

        ArrayList<Book> res = br.booksWithReadingTimeLessThan(readingTimeMinutes);

        assertTrue(res.get(0).readingTime() < 400);
        assertTrue(res.get(res.size()-1).readingTime() < 400);

        Chapter ch = new Chapter("Very long chapter", 5000);

        int ac = res.get(0).getChapters().size();

        res.get(0).addChapter(ch);

        assertNotEquals(ac, ac+1);

        assertFalse(res.get(0).readingTime() < 400);
    }

    @Test
    void updateReadingTimeInBook(){
        testBook = new Book("12345", "test book with chapters", "chapter author", 543, Genre.FANTASY);
        Chapter c1 = new Chapter("intro", 20);
        Chapter c2 = new Chapter("middle stuff", 59);
        Chapter c3 = new Chapter("unexpected turnaround", 47);
        Chapter c4 = new Chapter("exciting ending", 80);

        int readingTime = (20 + 59 + 47 + 80) * 3;

        testBook.addChapter(c1);
        testBook.addChapter(c2);
        testBook.addChapter(c3);
        testBook.addChapter(c4);

        assertEquals(readingTime, testBook.readingTime());

        testBook.getChapters().forEach(c -> c.setChapterPages(c.getChapterPages()*2));

        assertEquals((readingTime * 2), testBook.readingTime());
    }

    @Test
    void createArrayWithBooksByGenre(){
        // BookStorage br = initializeBookStorage();

        testBook = new Book("73625","stupid title", "dumb ass author", 723, Genre.CRIME);
        ArrayList<Book> crimeBooks = br.booksByGenre(testBook.getGenre());

        assertEquals(crimeBooks.get(0).getGenre(), Genre.CRIME);
        assertEquals(crimeBooks.get(1).getGenre(), Genre.CRIME);

        crimeBooks.get(0).setGenre(Genre.PORN);
        assertNotEquals(crimeBooks.get(0).getGenre(), Genre.CRIME);
    }

    @Test
    void createArrayWithBooksByAuthor(){
        testBook = new Book("81726","im a book", "J.R.R Tolkien", 723, Genre.CRIME);
        ArrayList<Book> booksByTolkien = br.booksByAuthor(testBook.getAuthor());

        String author = "J.R.R Tolkien";

        assertTrue(booksByTolkien.get(0).getAuthor().equalsIgnoreCase("J.R.R Tolkien"));
        assertEquals(author, booksByTolkien.get(1).getAuthor());
        assertEquals(booksByTolkien.get(2).getAuthor(), testBook.getAuthor());

        booksByTolkien.get(1).setAuthor("Dan Brown");

        assertNotEquals(author, booksByTolkien.get(1).getAuthor());
    }

    @Test
    public void getBookByPages() {
        // Now create an arraylist of Book, fill it with all
        // books in storage, which we have a method for.
        ArrayList<Book> all = br.allBooksInStorage();

        assertEquals(67, all.get(2).getNumberOfPages());
    }

    @Test
    public void changePagesInBook(){
        testBook = new Book("74635","stupid title", "dumb ass author", 723, Genre.FICTION);

        assertEquals(723, testBook.getNumberOfPages());

        testBook.setNumberOfPages(500);

        assertEquals(500, testBook.getNumberOfPages());
    }

    @Test
    void changeAuthorInBook(){
        testBook = new Book("12763","50 shades of grey", "J.R.R Tolkien", 723, Genre.FICTION);

        assertEquals("J.R.R Tolkien", testBook.getAuthor());

        testBook.setAuthor("Dan Brown");

        assertEquals("Dan Brown", testBook.getAuthor());
    }

    @Test
    void testChangeTitleInBook(){
        testBook = new Book("12763","50 shades of grey", "J.R.R Tolkien", 723, Genre.FICTION);
        String title = "40 shades of white";
        testBook.setTitle("40 shades of white");

        assertEquals(title, testBook.getTitle());
    }

    @Test
    void changeGenreInBook(){
        testBook = new Book("99873","50 shades of grey", "J.R.R Tolkien", 723, Genre.FICTION);

        assertEquals(Genre.FICTION, testBook.getGenre());

        testBook.setGenre(Genre.FANTASY);

        assertEquals(Genre.FANTASY, testBook.getGenre());
    }

    @Test
    void testNumberOfPagesInBook(){
        testBook = new Book("77334","Annas kockbok", "Koks Anna", 930, Genre.COOKBOOK);
        assertEquals(930, testBook.getNumberOfPages());
        var ch1 = new Chapter("Intro", 50);
        var ch2 = new Chapter("Pre cum", 20);
        var ch3 = new Chapter("Halfway done", 59);
        var ch4 = new Chapter("Almost There", 87);
        var ch5 = new Chapter("Moneys on the table", 12);
        var ch6 = new Chapter("can I get your number before you leave?", 1);
        testBook.addChapter(ch1);

        assertEquals(50, testBook.getNumberOfPages());

        ArrayList<Chapter> restOfChapters = new ArrayList<>();
        restOfChapters.add(ch2);
        restOfChapters.add(ch3);
        restOfChapters.add(ch4);
        restOfChapters.add(ch5);
        restOfChapters.add(ch6);
        testBook.setChapters(restOfChapters);
        int pages = restOfChapters.stream().mapToInt(Chapter::getChapterPages).sum();

        assertEquals(pages, testBook.getNumberOfPages());
    }

    @Test
    void amountOfBooksInStorage(){

        ArrayList<Book> tempArray = br.allBooksInStorage();

        assertEquals(7, tempArray.size());
    }
}