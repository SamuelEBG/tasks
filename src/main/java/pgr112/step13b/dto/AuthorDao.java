package pgr112.step13b.dto;

import pgr112.step13b.Author;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class AuthorDao extends BookRegisterDao<Author>{

    @Override
    public void save(Author author) throws SQLException {

    }

    @Override
    public void delete(int id) throws SQLException {

    }

    @Override
    public Author retrieve(int id) throws SQLException {
        return null;
    }

    @Override
    public Author mapFromResultSet(ResultSet rs) throws SQLException {
        return null;
    }

    @Override
    public ArrayList<Author> listAll() throws SQLException {
        return null;
    }
}
