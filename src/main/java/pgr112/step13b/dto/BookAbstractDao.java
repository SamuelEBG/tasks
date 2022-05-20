package pgr112.step13b.dto;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

public abstract class BookAbstractDao<T> {

    protected Properties properties;

    public BookAbstractDao(){
        this.properties = new Properties();
        try(FileReader reader = new FileReader("tasks/src/main/resources/step13b/pgr112step13b.properties")){
            properties.load(reader);
        } catch (IOException error){
            error.printStackTrace();
        }
    }
    /*
    public BookRegisterDao(Properties properties){
        this.properties = properties;
    }
     */

    public abstract void create(T t) throws SQLException;
    public abstract void delete(int id) throws SQLException;
    public abstract T mapFromResultSet(ResultSet rs) throws SQLException;
    public abstract ArrayList<T> listAll() throws SQLException;

    public Connection getConnection() throws SQLException{
        return DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/Books?useSSL=false",
                "samuel",
                "1234"
        );
    }
}
