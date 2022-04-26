package pgr112.step13.dto;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

public abstract class ShapeDao<T> {
        // Properties for each Dao that it will use to connect
        // to the database, these properties are loaded from
        // resources.
    protected Properties properties;
        // Constructor that tries to connect to the database.
    public ShapeDao(){
        this.properties = new Properties();
        try(FileReader reader = new FileReader("tasks/src/main/resources/step13/pgr112.properties")){
            properties.load(reader);
        } catch (IOException error){
            error.printStackTrace();
        }
    }

    public ShapeDao(Properties properties){
        this.properties = properties;
    }

    public abstract void save(T t) throws SQLException;
    public abstract ArrayList<T> listAll() throws SQLException;
    public abstract void delete(int id) throws SQLException;
    public abstract T retrieve(int id) throws SQLException;
    public abstract T mapFromResultSet(ResultSet rs) throws SQLException;

    public Connection getConnection() throws SQLException{
        return DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/Shapes?useSSL=false",
                "samuel",
                "1234"
        );
    }
}
