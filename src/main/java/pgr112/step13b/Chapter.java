package pgr112.step13b;

public class Chapter {

    private String title;
    private int pages;
    private int minutes;

    public Chapter(String title, int pages){
        this.title = title;
        this.pages = pages;
        this.minutes = pages*3;
    }

    @Override
    public String toString(){
        return String.format(
                "%s - Pages: %s - Reading time: %s minutes",
                this.title, this.pages, this.minutes);
    }

    public String getTitle() {return this.title;}
    public void setTitle(String title) {this.title = title;}
    public int getPages() {return this.pages;}
    public void setPages(int pages) {
        this.pages = pages;
        this.minutes = (pages * 3);
    }
    public int getReadingTime() {return minutes;}
}

