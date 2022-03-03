package pgr112.step3new;

public class Main {
    public static void main(String[] args){
        System.out.println("Starting program");
        var storage = new BookStorage();
        var book1 = new Book("Harry Potter and the idiots stone", "J.R.R Tolkien", 550, Genre.PORN);
        var book2 = new Book("1984", "TMZ", 1337, Genre.LEVELINGGUIDE);
        var book3 = new Book("Star Wars 12", "J.K Rollings", 67 , Genre.CRIME);
        var book4 = new Book("Star Wars 5", "J.K Rollings", 676 , Genre.CRIME);
        var book5 = new Book("Da Vincis Code", "Dan Black", 99, Genre.AUTOBIOGRAPHY);
        var book6 = new Book("Fredrik och redbullen", "Omund fra bergen", 6594, Genre.LEVELINGGUIDE);
        var book7 = new Book("Game of Thrones the Tmp and the Dragonbitch", "J.R.R Tolkien", 128, Genre.REALITY);
        var book8 = new Book("Hitchhikers guide to the galaxy", "Donald J Trump", 734, Genre.AUTOBIOGRAPHY);
        var book9 = new Book("The Bible", "Allah", 96, Genre.CLASSIC);
        var book10 = new Book("Holy Couran", "God", 870, Genre.CLASSIC);
        var book11 = new Book("Satan and the way of life", "Beelzebub", 666, Genre.AUTOBIOGRAPHY);
        var book12 = new Book("Harry Potter a lovestory", "Dan Brown", 740, Genre.PORN);
        var book13 = new Book("Annas kockbok", "Koks Anna", 930, Genre.COOKBOOK);
        storage.addBook(book1);
        storage.addBook(book2);
        storage.addBook(book3);
        storage.addBook(book4);
        storage.addBook(book5);
        storage.addBook(book6);
        storage.addBook(book7);
        storage.addBook(book8);
        storage.addBook(book9);
        storage.addBook(book10);
        storage.addBook(book11);
        storage.addBook(book12);
        storage.addBook(book13);
        storage.allBooksInStorage();
        var ch1 = new Chapter("Intro", 50);
        var ch2 = new Chapter("Pre cum", 20);
        var ch3 = new Chapter("Halfway done", 59);
        var ch4 = new Chapter("Almost There", 87);
        var ch5 = new Chapter("Moneys on the table", 12);
        var ch6 = new Chapter("Did you also cum?", 1);
        book1.addChapter(ch1);
        book1.addChapter(ch2);
        book1.addChapter(ch3);
        book1.addChapter(ch4);
        book1.addChapter(ch5);
        book1.addChapter(ch6);
        System.out.println(book1.readingTime());
        System.out.println(storage.booksWithReadingTimeLessThan(500));
    }
}
