package pg42sg.task06;

import org.pg4200.ex06.Author;
import org.pg4200.ex06.ImmutableAuthor;
import org.pg4200.ex06.ImmutableBook;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ImmutableBookImp implements ImmutableBook {
        /*
            Same shit here, private fields for Immutable object.
            If we copy an object we call the methods for changing the different fields.
            A copy of the object with edited preferences is created.
         */
    private final String title;

    private final int year;

    private final List<ImmutableAuthor> authors;

    public ImmutableBookImp(){
        this(null, -1, null);
    }
        // List with ImmutableAuthor, because otherwise we would have to upcast
        // author, because author class is an immutable author.
    public ImmutableBookImp(String title, int year, List<ImmutableAuthor> authors){
        this.title = title;
        this.year = year;
        // this.authors = authors == null ? null : Collections.unmodifiableList(authors);

        if(authors != null){
            this.authors = Collections.unmodifiableList(authors);
        } else {
            this.authors = null;
        }

    }
        // Next two methods are just for changing title and year, keep same array of authors.
    @Override
    public ImmutableBook withTitle(String title) {
        return new ImmutableBookImp(title, this.year, this.authors );
    }

    @Override
    public ImmutableBook withYear(int year) {
        return new ImmutableBookImp(this.title, year, this.authors);
    }
        // Here we copy a book, but we change the array of authors.
        // so with adding an array of ImmutableAuthor authors, we make it into
        // an Immutable list with Collections unmodifiableList.
    @Override
    public ImmutableBook withAuthors(List<ImmutableAuthor> authors) {
        return new ImmutableBookImp(
                this.title,
                this.year,
                Collections.unmodifiableList(authors));
    }
        // Now if instead the user would like to just add several authors,
        // we can take those and compile them into an array asList, and then call
        // the above method that enters an array into the object and turns it into
        // an Immutable array.
    @Override
    public ImmutableBook withAuthors(ImmutableAuthor... authors) {
        return withAuthors(Arrays.asList(authors));
    }

    @Override
    public String getTitle() {
        return this.title;
    }

    @Override
    public int getYear() {
        return this.year;
    }

    @Override
    public List<ImmutableAuthor> getAuthors() {
        return this.authors;
    }
}
