package pgr112.step13b.dto;

import pgr112.step13b.Chapter;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ChapterDao extends BookRegisterDao<Chapter>{

    @Override
    public void save(Chapter chapter) throws SQLException {

    }

    @Override
    public void delete(int id) throws SQLException {

    }

    @Override
    public Chapter retrieve(int id) throws SQLException {
        return null;
    }

    @Override
    public Chapter mapFromResultSet(ResultSet rs) throws SQLException {
        return null;
    }

    @Override
    public ArrayList<Chapter> listAll() throws SQLException {
        return null;
    }
}
