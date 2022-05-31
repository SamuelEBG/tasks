package pgr112.step13b.dto;

import pgr112.step13b.Author;
import pgr112.step13b.Book;
import pgr112.step13b.Genre;

import java.sql.*;
import java.util.ArrayList;

public class BookDao extends Dto<Book> {

    public BookDao(){
        super();
    }

    @Override
    public void create(Book book) throws SQLException{
        String saveStatement = "INSERT INTO books (isbn, title, author, pages, genre)" +
                "VALUES(?, ?, ?, ?, ?)";
        try(Connection conn = getConnection()){
            conn.setAutoCommit(false);
            /*
             Since author is a FK in the book table, first check if the author
             exists in the database, if it doesn't, we save the author-object that exists
             in the book-object.
             */
            String authorName = book.getAuthor().getName() + " " + book.getAuthor().getSurname();
            AuthorDao ad = new AuthorDao();

            Author author = ad.retrieveByName(authorName);
            // Author doesn't exist? We save it to the DB, and set its unique ID
            // to this books author object, so that we know what our author FK column is.
            if(author == null){
                ad.create(book.getAuthor());
            }
            // Now we can start adding the values.
            PreparedStatement stmt = conn.prepareStatement(saveStatement);

            stmt.setString(1, book.getIsbn());
            stmt.setString(2, book.getTitle());
            // This book now has an ID from the previous save method call.
            stmt.setInt(3, book.getAuthor().getId());
            stmt.setInt(4, book.getNumberOfPages());
            stmt.setString(5, String.valueOf(book.getGenre()));

            stmt.executeUpdate();
            conn.commit();

        } catch (SQLException error){
            error.printStackTrace();
        }
    }

    @Override
    public void delete(int id) throws SQLException {

    }

    public Book retrieve(String isbn) throws SQLException {
        return null;
    }

    @Override
    public Book mapFromResultSet(ResultSet rs) throws SQLException {
        int authorId = rs.getInt("author");
        AuthorDao ad = new AuthorDao();
        Author author = ad.retrieve(authorId);

        return new Book(
                rs.getString("isbn"),
                rs.getString("title"),
                author,
                rs.getInt("pages"),
                Genre.valueOf(rs.getString("genre"))
        );
    }

    public ArrayList<Book> listAll() throws SQLException {
        ArrayList<Book> result = new ArrayList<>();
        String preparedListAll = "SELECT * FROM books";
        try (Connection conn = getConnection()) {
            PreparedStatement stmt = conn.prepareStatement(preparedListAll);
            ResultSet resultSet = stmt.executeQuery();

            while(resultSet.next()){
                result.add(mapFromResultSet(resultSet));
            }

        } catch (SQLException error){
            error.printStackTrace();
        }
        return result;
    }
}
