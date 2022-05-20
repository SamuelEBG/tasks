package pgr112.step6;

import org.junit.jupiter.api.BeforeEach;

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
}