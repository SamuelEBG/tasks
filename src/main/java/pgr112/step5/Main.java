package pgr112.step5;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args){
        System.out.println("Start of program");
        Program program = new Program();
        Artist artist = new Artist();
        // program.fileReaderWithException();
        // Program.fileWritingMethod();
        // .stream().forEach(System.out::println);
        artist.scanArtistException();
    }
}
