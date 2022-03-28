package pg42sg.task06;

import org.pg4200.ex06.ImmutableAuthor;
import org.pg4200.ex06.ImmutableBook;

import java.util.List;

public class ImmutableBookImp implements ImmutableBook {

    @Override
    public ImmutableBook withTitle(String title) {
        return null;
    }

    @Override
    public ImmutableBook withYear(int year) {
        return null;
    }

    @Override
    public ImmutableBook withAuthors(List<ImmutableAuthor> authors) {
        return null;
    }

    @Override
    public ImmutableBook withAuthors(ImmutableAuthor... authors) {
        return null;
    }

    @Override
    public String getTitle() {
        return null;
    }

    @Override
    public int getYear() {
        return 0;
    }

    @Override
    public List<ImmutableAuthor> getAuthors() {
        return null;
    }
}
