package pgr112.step3new;

import java.util.ArrayList;

public class BookStorage {
    private ArrayList<Book> books;

    public BookStorage(){
        this.books = new ArrayList<>();
    }

    public void addBook(Book addedBook){
        this.books.add(addedBook);
    }

    public int amountOfBooksInStorage(){
        return this.books.size();
    }

    public void allBooksInStorage(){
        for(Book b : books){
            System.out.println(b);
        }
    }

    public ArrayList<Book> booksByGenre(Genre genre){
        ArrayList<Book> temp = new ArrayList<>();
        for(Book b : books){
            if(b.getGenre().equals(genre)){
                temp.add(b);
            }
        }
        return temp;
    }

    public ArrayList<Book> booksByAuthor(String author){
        ArrayList<Book> temp = new ArrayList<>();
        for(Book b : books){
            if(b.getAuthor().equalsIgnoreCase(author)){
                temp.add(b);
            }
        }
        return temp;
    }

    public ArrayList<Book> booksWithReadingTimeLessThan(int minutes){
        ArrayList<Book> temp = new ArrayList<>();
        for(Book b : books){
            if(b.readingTime() < minutes){
                temp.add(b);
            }
        }
        return temp;
    }
}
