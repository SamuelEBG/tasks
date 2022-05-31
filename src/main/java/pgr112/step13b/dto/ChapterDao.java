package pgr112.step13b.dto;

import pgr112.step13b.Chapter;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ChapterDao extends Dto<Chapter> {

    public ChapterDao(){
        super();
    }

    @Override
    public void create(Chapter chapter) throws SQLException {
        //language=MySQL
        String preparedSave = "INSERT INTO chapters(isbn, chapterNumber, title, pages, readingTime)" +
                "VALUES(?, ?, ?, ?, ?)";
        try(Connection conn = getConnection()){



        } catch (SQLException error){
            error.printStackTrace();
        }
    }

    @Override
    public void delete(int id) throws SQLException {

    }

    public Chapter retrieve(int id) throws SQLException {
        return null;
    }

    @Override
    public Chapter mapFromResultSet(ResultSet rs) throws SQLException {
        return null;
    }
}
