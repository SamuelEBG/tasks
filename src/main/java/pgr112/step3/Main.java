package pgr112.step3;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args){
        BookRegister br = new BookRegister();

        Books book1 = new Books("1", "1984", "George Orwell", 529, Genre.CRIME);
        Books book2 = new Books("2", "Harry potter", "GRR Tolkien", 123, Genre.ACTION);
        Books book3 = new Books("3", "Populärmusik från vittoula", "Mikael Niemi,", 234, Genre.CLASSIC);

        br.addBook(book1);
        br.addBook(book2);
        br.addBook(book3);
        //br.allRegisteredBooks().stream().forEach(System.out::println);
        //br.removeBook(book1);
        //System.out.println("Book 1 removed");
        //r.allRegisteredBooks().stream().forEach(System.out::println);
        br.bookMenu();

    }
}
