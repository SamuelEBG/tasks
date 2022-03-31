package pg42sg.task06;

import org.pg4200.ex06.ImmutableAuthor;

public class ImmutableAuthorImp implements ImmutableAuthor {
        /*
            The whole point here is, that when an Author object is created,
            we can set the name and surname, but after that they cannot be changed.
            So in order to change the Immutable objects variables, we have to
            create a copy of that object, hence the withName and withSurname methods.
         */
        // final variables that cannot be changed, immutable
    private final String name;
    private final String surname;
        // Empty instance of object that sets name and surname to null.
        // we create a new Author object by getting a new instance of this object,
        // and then writing .withName and .withSurname after it.
    public ImmutableAuthorImp(){
        this(null, null);
    }
        // The above constructor calls this with its parameters.
    public ImmutableAuthorImp(String name, String surname){
        this.name = name;
        this.surname = surname;
    }
        // These methods return a new copy of the existing object, but with
        // the name that is set in the parameter as the name.
        // so no we have an instance of this object but with the name in the parameter.
    @Override
    public ImmutableAuthor withName(String name) {
        return new ImmutableAuthorImp(name, this.surname);
    }
        // Same thing but for the surname, so if this method is called on an instance
        // of this object, it will create a copy of that object but with the surname in the
        // parameter.
    @Override
    public ImmutableAuthor withSurname(String surname) {
        return new ImmutableAuthorImp(this.name, surname);
    }
        // Since we want this object to be immutable, we only have getters.
    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public String getSurname() {
        return this.surname;
    }
}
