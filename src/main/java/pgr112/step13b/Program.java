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

    public ArrayList<Book> getBookByPageLength(int pages) throws SQLException{
            // Method for getting pages less than the number in the parameter.
        if(pages <= 0) {
            System.out.println("a book can't have negative pages, don't be silly.");
        }
        ArrayList<Book> tempBooks = new ArrayList<>();
        ResultSet rs = null; // This is the result of the query
        String pagesQuery = "SELECT * FROM books " +
                "WHERE pages < ?";
        try (Connection con = DriverManager
                .getConnection("jdbc:mysql://localhost:3306/books?useSSL=false", "oopuser", "root");
             //
             PreparedStatement getBooksByPage = con.prepareStatement(pagesQuery, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY)) {
            // Savepoint save1 = con.setSavepoint();
            getBooksByPage.setInt(1, pages); // Setter method in the query is set to the value from the parameter.
            if (!getBooksByPage.execute()) {
                System.out.println("No books with that amount of pages");
            } else {
                rs = getBooksByPage.getResultSet();
                while(rs.next()){
                    var b = new Book();
                    b.setIsbn(rs.getString("isbn"));
                    b.setAuthor(rs.getString("author"));
                    b.setTitle(rs.getString("title"));
                    b.setNumberOfpages(rs.getInt("pages"));
                    b.setGenre(rs.getString("genre"));
                    tempBooks.add(b);
                }
            }
        }
        return tempBooks;
    }

    public void addBook(ArrayList<Book> books) throws SQLException{

        // Here we create a prepared statement for the database.
        // This is a statement that we want to execute many times,
        // This prepared statement is sent to the database right away, and is therefor compiled.
        // Not only does it contain a SQL statement, but a SQL statement that has been compiled already.
        // So the DBMS can just run the prepared statement without having to compile it first.
        // Prepared statements always treat client-supplied data as content of a parameter and never as a part of an SQL statement.
        // So this is a way of protecting against SQL injections.
        String addBookStatement = "INSERT INTO books VALUES(default, ?, ?, ?, ?, ?)";
        // These question marks will be called upon later down in the code, that is where we will enter
        // the information to be passed into the DBMS.
        try(Connection con = DriverManager
                .getConnection("jdbc:mysql://localhost:3306/books?useSSL=false", "oopuser", "root");
        PreparedStatement insertBook = con.prepareStatement(addBookStatement)
        ){
            con.setAutoCommit(false);
            Savepoint save1 = con.setSavepoint();
            // We use a for loop to go through the book array and entering all the books in the DBMS
            // with their information.
            for(int i = 0; i < books.size(); i++){
                // The first parameter is the setter method for the SQL prepared statement.
                insertBook.setString(1, books.get(i).getIsbn());
                insertBook.setString(2, books.get(i).getTitle());
                insertBook.setString(3, books.get(i).getAuthor());
                insertBook.setInt(4, books.get(i).getNumberOfPages());
                insertBook.setString(5, books.get(i).getGenre());
                insertBook.execute();
                if(books.get(i).getGenre().equalsIgnoreCase(";drop tables")){
                    System.out.println("Not allowed to drop tables, shame on you!");
                    con.rollback(save1);
                }else {
                    con.commit();
                }
            }

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
