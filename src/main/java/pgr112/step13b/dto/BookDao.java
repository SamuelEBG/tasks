package pgr112.step13b.dto;

import pgr112.step13b.Book;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class BookDao extends BookRegisterDao<Book> {

    public BookDao(){
        super();
    }

    @Override
    public void save(Book book) throws SQLException {
        String saveStatement = "INSERT INTO books (isbn, title, author, chapters, genre)" +
                "VALUES(?, ?, ?, ?, ?)";
        try(Connection conn = getConnection()){
            conn.setAutoCommit(false);


        } catch (SQLException error){
            error.printStackTrace();
        }
    }

    @Override
    public void delete(int id) throws SQLException {

    }

    @Override
    public Book retrieve(int id) throws SQLException {
        return null;
    }

    @Override
    public Book mapFromResultSet(ResultSet rs) throws SQLException {
        return null;
    }

    @Override
    public ArrayList<Book> listAll() throws SQLException {
        return null;
    }
}
