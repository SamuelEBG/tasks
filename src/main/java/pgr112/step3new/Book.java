package pgr112.step3new;

import java.util.ArrayList;

public class Book {

    private String isbn;
    private String title;
    private String author;
    private int numberOfPages;
    private Genre genre;

    private ArrayList<Chapter> chapters = new ArrayList<>();

    public void addChapter(Chapter chapter){
        this.chapters.add(chapter);
    }

    public ArrayList<Chapter> getChapters() {
        return chapters;
    }

    public void setChapters(ArrayList<Chapter> chapters) {
        this.chapters = chapters;
    }

    public void allChapters(){
        System.out.println("Chapters for " + this.title);
        for(int i = 0; i < chapters.size();i++){
            System.out.println(i+1 + " - " + chapters.get(i));
        }
    }

    public int readingTime(){
        int sum = 0;
        for(Chapter c : chapters){
            sum += c.getReadingTime();
        }
        return sum;
    }

    public Book(String isbn,String title, String author, int pages, Genre genre){
        this.isbn = isbn;
        this.title = title;
        this.author = author;
        if(pages > 0){
            this.numberOfPages = pages;
        }
        this.genre = genre;
    }

    @Override
    public String toString(){
        return String.format(
                "Title: %s - Author: %s - Pages: %s - Genre: %s",
                this.title, this.author, this.numberOfPages, this.genre);
    }

    public Genre getGenre() {return genre;}
    public void setGenre(Genre genre) {this.genre = genre;}
    public String getTitle() {return title;}
    public void setTitle(String title) {this.title = title;}
    public String getAuthor() {return author;}
    public void setAuthor(String author) {this.author = author;}
    public int getNumberOfPages() {return numberOfPages;}
    public void setNumberOfPages(int numberOfPages) {this.numberOfPages = numberOfPages;}
}
