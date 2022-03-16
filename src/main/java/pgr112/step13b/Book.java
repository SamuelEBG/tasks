package pgr112.step13b;


public class Book {

    @Override
    public String toString(){
        return String.format(
                "Title: %s - Author: %s - Pages: %s - Genre: %s",
                this.title, this.author, this.numberOfPages, this.genre);
    }

    private String isbn;
    private String title;
    private String author;
    private int numberOfPages = 1;
    private String genre;

    // Method for creating a book, will put pages as 1 if
    // amount of pages is not specified, and title to OTHER.
    // use this. because attributes
    // are set to private.
    // Seccond method including parameter for user to specify genre.

    public Book(){
        this.isbn = "";
        this.title = "";
        this.author = "";
        this.numberOfPages = 0;
        this.genre = "";
    }

    public Book(String title, String author,int pages){
        this.title = title;
        this.author = author;
        if(pages > 0){
            this.numberOfPages = pages;
        }
        this.genre = "";
    }

    public Book(String isbn, String title, String author, int pages, String genre ){
        this.isbn = isbn;
        this.title = title;
        this.author = author;
        if(pages > 0){
            this.numberOfPages = pages;
        }
        this.genre = genre;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {return this.author;}

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getNumberOfPages() {
        return this.numberOfPages;
    }

    public void setNumberOfpages(int numberOfpages) {
        if(numberOfpages > 0) this.numberOfPages = numberOfpages;
    }

    public String getGenre() {
        return this.genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getIsbn() {
        return this.isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }
}
