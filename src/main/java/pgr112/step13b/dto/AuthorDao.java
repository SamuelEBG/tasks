package pgr112.step13b.dto;

import pgr112.step13b.Author;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;

public class AuthorDao extends Dto<Author> {

    public AuthorDao(){
        super();
    }

    @Override
    public void create(Author author){
        //language=MySQL
        String preparedSave = "INSERT INTO author(name, surname, dateOfBirth, country)" +
                "VALUES(?, ?, ?, ?)";
        try(Connection conn = getConnection()){
            conn.setAutoCommit(false);
            PreparedStatement stmt = conn.prepareStatement(preparedSave, Statement.RETURN_GENERATED_KEYS);

            stmt.setString(1, author.getName());
            stmt.setString(2, author.getSurname());
            stmt.setString(3, String.valueOf(author.getDateOfBirth()));
            stmt.setString(4, author.getCountry());

            stmt.executeUpdate();
            conn.commit();
            // We use the auto generated PK ID in the book table.
            // So we save that ID to this author that is in the parameter in the save-book-method
            // that this has been called from.
            ResultSet getPK = stmt.getGeneratedKeys();
            if(getPK.next()){
                author.setId(getPK.getInt(1));
            }

        } catch(SQLException error){
            error.printStackTrace();
        }
    }

    @Override
    public void delete(int id) throws SQLException {

    }

    public Author retrieveByName(String author){
        // To be able to retrieve an author with our parameter that will be the authors
        // full name, we will have to concat the name and surname from the database, since
        // the authors name is stored with first and last name.
        String preparedSelect = "SELECT * FROM author " +
                "WHERE CONCAT(name, ' ', surname) LIKE ?";
        try(Connection conn = getConnection()){
            conn.setAutoCommit(false);

            PreparedStatement stmt = conn.prepareStatement(preparedSelect);
            // First parameter will be the full name of the author, including the space between first
            // and last name.
            stmt.setString(1, author);

            ResultSet resultSet = stmt.executeQuery();
            // Does the DB contain the author in question?
            // If so, we create an object of that author and return it.
            if(resultSet.next()){
                return mapFromResultSet(resultSet);
            }
            // If not we return null, and decide what to do in the method where this method
            // was originally called from.
            else return null;

        } catch (SQLException error){
            error.printStackTrace();
        }
        return null;
    }

    public Author retrieve(int id) {
        String preparedSelect = "SELECT * FROM author " +
                                "WHERE id = ?";
        try(Connection conn = getConnection()){
            conn.setAutoCommit(false);

            PreparedStatement stmt = conn.prepareStatement(preparedSelect);

            stmt.setInt(1, id);

            ResultSet resultSet = stmt.executeQuery();
            // Does the resultSet contain anything?
            // If so, map a new author from that result, and return that new author object.
            if(resultSet.next()){
                return mapFromResultSet(resultSet);
            }
            else return null;

        } catch (SQLException error){
            error.printStackTrace();
        }
        return null;
    }

    @Override
    public Author mapFromResultSet(ResultSet rs) throws SQLException {
        Author author = new Author();

        int aId = rs.getInt("id");
        String name = rs.getString("name");
        String surname = rs.getString("surname");
        LocalDate dateOfBirth = rs.getDate("dateOfBirth").toLocalDate();
        String country = rs.getString("country");

        author.setId(aId);
        author.setName(name);
        author.setSurname(surname);
        author.setDateOfBirth(dateOfBirth);
        author.setCountry(country);

        return author;
        /*
        return new Author(
                rs.getString("name"),
                rs.getString("surname"),
                rs.getDate("dateOfBirth").toLocalDate(),
                rs.getString("country")
        );
         */
    }

    public ArrayList<Author> listAll() throws SQLException {
        ArrayList<Author> result = new ArrayList<>();
        String psListAll = "SELECT * FROM author";

        try(Connection conn = getConnection()){
            PreparedStatement stmt = conn.prepareStatement(psListAll);

            ResultSet setWithAuthors = stmt.executeQuery();

            while(setWithAuthors.next()){
                result.add(mapFromResultSet(setWithAuthors));
            }
            return result;

        } catch(SQLException error){
            error.printStackTrace();
        }
        return result;
    }
}
