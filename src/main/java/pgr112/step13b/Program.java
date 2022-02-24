package pgr112.step13b;

import java.sql.*;
import java.util.ArrayList;

public class Program {

    public Program(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

        }
        catch(ClassNotFoundException exception){
            exception.printStackTrace();
        }
    }

    public void addBook(ArrayList<Book> books) throws SQLException{

        // Here we create a prepared statement for the database.
        // This is a statement that we want to execute many times,
        // This prepared statement is sent to the database right away, and is therefor compiled.
        // Not only does it contain a SQL statement, but a SQL statement that has been compiled already.
        // So the DBMS can just run the prepared statement without having to compile it first.
        // Prepared statements always treat client-supplied data as content of a parameter and never as a part of an SQL statement.
        // So this is a way of protecting against SQL injections.
        String addBookStatement = "INSERT INTO books VALUES(?, ?, ?, ?, ?)";
        // These question marks will be called upon later down in the code, that is where we will enter
        // the information to be passed into the DBMS.
        try(Connection con = DriverManager
                .getConnection("jdbc:mysql://localhost:3306/books?useSSL=false", "oopuser", "root");
        PreparedStatement insertBook = con.prepareStatement(addBookStatement);
        ){
            con.setAutoCommit(false);
            Savepoint save1 = con.setSavepoint();
            // We use a for loop to go through the book array and entering all the books in the DBMS
            // with their information.
            for(int i = 0; i < books.size(); i++){
                // The first parameter is the setter method for the SQL prepared statement.
                insertBook.setInt(1, books.get(i).getIsbn());
                insertBook.setString(2, books.get(i).getTitle());
                insertBook.setString(3, books.get(i).getAuthor());
                insertBook.setInt(4, books.get(i).getNumberOfPages());
                insertBook.setString(5, books.get(i).getGenre());
                insertBook.execute();
                if(books.get(i).getGenre().equalsIgnoreCase("horror")){
                    System.out.println("Not allowed to read horror books, shame on you!");
                    con.rollback(save1);
                }
            }
            con.commit();

            /*
            String insertSql = "INSERT INTO books(isbn, title, author, pages, genre)"
                    + "VALUES('" +
                    book.getIsbn() + "', '" +
                    book.getTitle() + "', '" +
                    book.getAuthor() + "', '" +
                    book.getNumberOfPages() + "', '" +
                    book.getGenre() +
                    "')";
            stmt.executeUpdate(insertSql);
            System.out.println("inserting" + book.getTitle());

             */

        } catch(SQLException exception){
            exception.printStackTrace();
        }
    }

}
