package pgr112.step6;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class Program {

    protected final String path = "tasks/src/main/resources/step6/books.txt";

    public BookRegister br = new BookRegister();

    public Program(String path) throws FileNotFoundException {
        File file = new File(path);
        readFromFile(file);
    }

    private void readFromFile(File file) {
        try{
            Scanner scan = new Scanner(file);
            while(scan.hasNextLine()){
                String isbn = scan.nextLine();
                String title = scan.nextLine();
                String author = scan.nextLine();
                int numberOfPages = Integer.parseInt(scan.nextLine());
                // br.addBook();
            }
        }catch(FileNotFoundException error){
            error.printStackTrace();
        }
    }


}
