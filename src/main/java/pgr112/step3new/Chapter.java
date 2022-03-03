package pgr112.step3new;

public class Chapter {

    private String chapterTitle;
    private int chapterPages;
    private int minutes;

    public Chapter(String title, int pages){
        this.chapterTitle = title;
        this.chapterPages = pages;
        this.minutes = pages*3;
    }

    public String getChapterTitle() {return chapterTitle;}
    public void setChapterTitle(String chapterTitle) {this.chapterTitle = chapterTitle;}
    public int getChapterPages() {return chapterPages;}
    public void setChapterPages(int chapterPages) {this.chapterPages = chapterPages;}
    public int getReadingTime() {return minutes;}
    public void setMinutes(int minutes) {this.minutes = minutes;}

}

