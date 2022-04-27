package pgr112.step13.dto;

import pgr112.step13.shapes.MovablePoint;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

public class MovablePointDao extends ShapeDao<MovablePoint> {

    public MovablePointDao(Properties properties){
        super(properties);
    }

    public MovablePointDao(){
        super();
    }

    @Override
    public void save(MovablePoint movablePoint) throws SQLException {
        String preparedInsert = "INSERT INTO Shapes.movablepoints VALUES (?, ?, ?)";
        try(Connection conn = getConnection()){
            conn.setAutoCommit(false);

            PreparedStatement stmt = conn.prepareStatement(preparedInsert);

            stmt.setInt(1, movablePoint.getId());
            stmt.setDouble(2, movablePoint.getX());
            stmt.setDouble(3, movablePoint.getY());

            stmt.executeUpdate();
            conn.commit();

        } catch (SQLException error){
            error.printStackTrace();
        }
    }

    @Override
    public ArrayList<MovablePoint> listAll() throws SQLException {
        ArrayList<MovablePoint> result = new ArrayList<>();
        String preparedListAll = "SELECT * FROM Shapes.movablepoints";
        try(Connection conn = getConnection()){
            PreparedStatement stmt = conn.prepareStatement(preparedListAll);

            ResultSet resultSet = stmt.executeQuery();

            while(resultSet.next()){
                result.add(mapFromResultSet(resultSet));
            }
            return result;

        } catch(SQLException error){
            error.printStackTrace();
        }

        return result;
    }

    @Override
    public void delete(int id) throws SQLException {

    }

    public MovablePoint retrieve(int id) throws SQLException {
        String prepapredSelect = "SELECT * FROM Shapes.movablepoints WHERE id = ?";
        try(Connection conn = getConnection()){
            conn.setAutoCommit(false);

            PreparedStatement stmt = conn.prepareStatement(prepapredSelect);
            // Look for movablepoints with id
            stmt.setInt(1, id);
            // Execute the query.
            ResultSet resultSet = stmt.executeQuery();
            // If there is a movablePoint (resultSet has a next)
            // We return that movablePoint by going to the method that
            // creates a new movablePoint based on the values from the resultSet.
            if(resultSet.next()){
                return mapFromResultSet(resultSet);
            }
            else return null;
            // Else we return null, so that we create a new movablePoint
            // when we return to the DAO that this method was called from first.

        } catch (SQLException error){
            error.printStackTrace();
        }
        return null;
    }

    @Override
    public MovablePoint mapFromResultSet(ResultSet rs) throws SQLException {
        int mId = rs.getInt("id");
        MovablePoint mp = new MovablePoint();
        mp.setX(rs.getInt("x"));
        mp.setY(rs.getInt("y"));
        return mp;
    }
}
