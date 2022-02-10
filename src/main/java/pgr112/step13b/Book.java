package pgr112.step13b;


public class Book {

    @Override
    public String toString(){
        return ("ISBN: " + getIsbn() + '\n' +
                "Author: " + getAuthor() + '\n' +
                "Title: " + getTitle() + '\n' +
                "Number of pages: " + getNumberOfPages() + '\n' +
                "Genre: " +  getGenre() + '\n' +
                "---" + '\n'
        );
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

    public Book(String isbn,String title, String author,int pages, String genre ){
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

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }
}
