package pgr112.step13b;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Program {

    public Program(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        }
        catch(ClassNotFoundException exception){
            exception.printStackTrace();
        }
    }

    public boolean addBook(Book book){

        try(Connection con = DriverManager
                .getConnection("jdbc:mysql://localhost:3306/books?useSSL=false", "oopuser", "root")){

            Statement stmt = con.createStatement();

            String insert = "INSERT INTO books(isbn, authorId, )";

        } catch(SQLException exception){
            exception.printStackTrace();
            return false;
        }
        return true;
    }

}
