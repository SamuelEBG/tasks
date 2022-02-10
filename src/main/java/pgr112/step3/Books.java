package pgr112.step3;

import java.util.ArrayList;

public class Books {

    @Override
    public String toString(){
        return ("ISBN: " + getIsbn() +
                " Author: " + getAuthor() +
                " Title: " + getTitle() +
                " Number of pages: " + getNumberOfPages()
                );
    }

    private String title;
    private String author;
    private int numberOfPages = 1;
    private Genre genre;
    private String isbn;

    private ArrayList<Chapter> chapters = new ArrayList<>();

    // Method for creating a book, will put pages as 1 if
    // amount of pages is not specified, and title to OTHER.
    // use this. because attributes
    // are set to private.
    // Seccond method including parameter for user to specify genre.

    public Books(){
        this.isbn = "";
        this.title = "";
        this.author = "";
        this.numberOfPages = 1;
        this.genre = Genre.OTHER;
    }

    public Books(String title, String author,int pages){
        this.title = title;
        this.author = author;
        if(pages > 0){
            this.numberOfPages = pages;
        }
        this.genre = Genre.OTHER;
    }

    public Books(String isbn,String title, String author,int pages, Genre genre ){
        this.isbn = isbn;
        this.title = title;
        this.author = author;
        if(pages > 0){
            this.numberOfPages = pages;
        }
        this.genre = genre;
    }



    public String printBook(){
        return this.title + " - " + this.author;
    }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getAuthor() {return this.author;}

        public void setAuthor(String author) {
            this.author = author;
        }

        public int getNumberOfPages() {
            return numberOfPages;
        }

        public void setNumberOfpages(int numberOfpages) {
            if(numberOfpages > 0) this.numberOfPages = numberOfpages;
        }

        public Genre getGenre() {
            return genre;
        }

        public void setGenre(Genre genre) {
            this.genre = genre;
        }

        public void addChapter(Chapter ch){
            this.chapters.add(ch);
        }

        public int readingTime(){
            int sum = 0;
            for(Chapter ch : chapters){
                sum+= ch.getReadingTime();
            }
            return sum;
        }

        public String getIsbn() {
            return isbn;
        }

        public void setIsbn(String isbn) {
            this.isbn = isbn;
        }
}
