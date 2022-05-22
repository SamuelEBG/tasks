package pgr112.step6;

public class Book {

    private String isbn;
    private String title;
    private String author;
    private Genre genre;
    private int numberOfPages;

    public Book (String isbn, String title, String author, int pages, Genre genre){
        this.isbn = isbn;
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.numberOfPages = Math.max(pages, 3);
    }

    public int readingTime(){
        return this.numberOfPages * 3;
    }

    @Override
    public String toString(){
        return String.format(
                "Title: %s - Author: %s - Pages: %s - Genre: %s",
                this.title, this.author, this.numberOfPages, this.genre);
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getNumberOfPages() {
        return numberOfPages;
    }

    public void setNumberOfPages(int numberOfPages) {
        if(numberOfPages < 1){
            this.numberOfPages = 2;
        } else{
            this.numberOfPages = numberOfPages;
        }
    }

    public Genre getGenre(){
        return genre;
    }
    public void setGenre(Genre genre){
        this.genre = genre;
    }
}
