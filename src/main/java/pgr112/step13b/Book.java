package pgr112.step13b;

import pgr112.step3new.Chapter;

import java.util.ArrayList;

public class Book {

    private final ArrayList<Chapter> chapters = new ArrayList<>();
    private String isbn;
    private String title;
    private Author author;
    private int numberOfPages;
    private Genre genre;

    // Method for creating a book, will put pages as 1 if
    // amount of pages is not specified, and title to OTHER.
    // use this. because attributes
    // are set to private.
    // Seccond method including parameter for user to specify genre.

    public Book(){
        this.isbn = "";
        this.title = "";
        this.author = new Author();
        this.numberOfPages = 3;
        this.genre = Genre.OTHER;
    }

    public Book(String title, Author author, int pages){
        this.title = title;
        this.author = author;
        this.numberOfPages = Math.max(pages, 3);
        this.genre = Genre.OTHER;
    }

    public Book(String isbn, String title, Author author, int pages, Genre genre ){
        this.isbn = isbn;
        this.title = title;
        this.author = author;
        this.numberOfPages = Math.max(pages, 3);
        this.genre = genre;
    }

    public int readingTime(){
        return chapters.stream().mapToInt(Chapter::getReadingTime).sum();
        /*
        int sum = 0;
        for(Chapter c : chapters){
            sum += c.getReadingTime();
        }
        return sum;

         */
    }

    public void addChapter(Chapter chapter){
        this.chapters.add(chapter);
    }

    public void allChapters(){
        System.out.println("Chapters for " + this.title);
        for(int i = 0; i < chapters.size();i++){
            System.out.println(i+1 + " - " + chapters.get(i));
        }
    }

    public String getTitle() {return this.title;}
    public void setTitle(String title) {this.title = title;}
    public Author getAuthor() {return this.author;}
    public void setAuthor(Author author) {this.author = author;}
    public int getNumberOfPages() {return this.numberOfPages;}
    public void setNumberOfpages(int numberOfpages) {
        if(numberOfpages > 0) this.numberOfPages = numberOfpages;
    }
    public Genre getGenre() {return this.genre;}
    public void setGenre(Genre genre) {this.genre = genre;}
    public String getIsbn() {return this.isbn;}
    public void setIsbn(String isbn) {this.isbn = isbn;}

    @Override
    public String toString(){
        return String.format(
                "Title: %s - Author: %s - Pages: %s - Genre: %s",
                this.title,
                author.getName() + " " + author.getSurname(),
                this.numberOfPages,
                this.genre);
    }
}
