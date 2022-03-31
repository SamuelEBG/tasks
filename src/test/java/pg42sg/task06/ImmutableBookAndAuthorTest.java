package pg42sg.task06;

import org.junit.jupiter.api.Test;
import org.pg4200.ex06.ImmutableAuthor;
import org.pg4200.ex06.ImmutableBook;
import org.pg4200.ex06.ImmutableBookAndAuthorTestTemplate;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ImmutableBookAndAuthorTest extends ImmutableBookAndAuthorTestTemplate {

    @Override
    protected ImmutableBook getNewEmptyInstanceOfBook() {
        return new ImmutableBookImp();
    }

    @Override
    protected ImmutableAuthor getNewEmptyInstanceOfAuthor() {
        return new ImmutableAuthorImp();
    }

    @Test
    public void testTheImmutableAuthorClass(){

        String immutableName = "igor";
        String immutableLastName = "snigelfitta";

        ImmutableAuthor author = getNewEmptyInstanceOfAuthor()
                .withName(immutableName)
                .withSurname(immutableLastName);

        assertEquals(immutableName, author.getName());
        assertEquals(immutableLastName, author.getSurname());

        String newName = "igge pigge";

        ImmutableAuthor anotherOne = author.withName(newName);

        assertEquals(newName, anotherOne.getName());
        assertEquals(immutableLastName, anotherOne.getSurname());
    }
}
