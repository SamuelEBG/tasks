package pgr112.step13.dto;

import pgr112.step13.shapes.Circle;
import pgr112.step13.shapes.MovablePoint;

import java.awt.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

// Implement the abstract class ShapeDao that takes generics
    // as a parameter, and specify that the object we are going
    // to be working with is the shape Circles.
public class CircleDao extends ShapeDao<Circle>{

    public CircleDao(Properties properties){
        super(properties);
    }

    public CircleDao() {
        super();
    }

    @Override
    public void save(Circle circle) throws SQLException {
        String preparedSave = "INSERT INTO Shapes.circle(r, g, b, filled, radius, center) VALUES(?, ?, ?, ?, ?, ?)";
        try(Connection conn = getConnection()){
            conn.setAutoCommit(false);

                // Find the center point.
            MovablePoint centerPoint;
                // Create a new point dao,
            MovablePointDao mpd = new MovablePointDao();
                // If the point exists, we retrieve it and
                // our centerPoint gets its values.
            centerPoint = mpd.retrieve(circle.getCenter().getId());

                // If it does not exist, we save whatever values the circle
                // that we want to add has.
                // And then add those center values to our newly created centerPoint.
            if(centerPoint == null){
                mpd.save(circle.getCenter());
                centerPoint = circle.getCenter();
            }
            // Execute prepared statement that will set all the values from the circle
            // into the database.
            PreparedStatement stmt = conn.prepareStatement(preparedSave, PreparedStatement.RETURN_GENERATED_KEYS);
            stmt.setInt(1, circle.getColor().getRed());
            stmt.setInt(2, circle.getColor().getGreen());
            stmt.setInt(3, circle.getColor().getBlue());
            stmt.setBoolean(4, circle.isFilled());
            stmt.setDouble(5, circle.getRadius());
            stmt.setInt(6, centerPoint.getId());
            // execute the update.
            stmt.executeUpdate();

            conn.commit();
            // Now let's get the id that also is the primary key,
            // then we can set the id of the shape to the primary key.
            ResultSet rs = stmt.getGeneratedKeys();
            if(rs.next()){
                circle.setId(rs.getInt(1));
            }

        } catch (SQLException error){
            error.printStackTrace();
        }
    }

    @Override
    public ArrayList<Circle> listAll() throws SQLException {
        ArrayList<Circle> result = new ArrayList<>();
        String getListOfAllCirclesDb = "SELECT * FROM Shapes.circle";

        try(Connection conn = getConnection()){
            conn.setAutoCommit(false);
            PreparedStatement stmt = conn.prepareStatement(getListOfAllCirclesDb);

            ResultSet resultSet = stmt.executeQuery();
            while(resultSet.next()){
                result.add(mapFromResultSet(resultSet));
            }

        } catch (SQLException error){
            error.printStackTrace();
        }
        return result;
    }

    @Override
    public void delete(int id) throws SQLException {
        String preparedDelete = "DELETE FROM Shapes.circle WHERE id = ?";

        try(Connection conn = getConnection()){
            conn.setAutoCommit(false);
            PreparedStatement stmt = conn.prepareStatement(preparedDelete);
            stmt.setInt(1, id);
            stmt.executeUpdate();

        } catch (SQLException error){
            error.printStackTrace();
        }
    }

    public Circle retrieve(int id) throws SQLException {
        String preparedSelect = "SELECT * FROM Shapes.movablepoints WHERE id = ?";
        try(Connection conn = getConnection()){
            PreparedStatement stmt = conn.prepareStatement(preparedSelect);
            stmt.setInt(1, id);

            ResultSet resultSet = stmt.executeQuery();

            return mapFromResultSet(resultSet);

        } catch (SQLException error){
            error.printStackTrace();
        }
        return null;
    }

    @Override
    public Circle mapFromResultSet(ResultSet rs) throws SQLException {
        int centerId = rs.getInt("center");
        MovablePointDao mp = new MovablePointDao();
        MovablePoint center = mp.retrieve(centerId);

        // We have to create a new object of circle first, since we cannot
        // set id from parameter, because we don't set id when we create the object.
        // the id is set when the object is entered into the database.
        // therefor the id is only present when we retrieve a circle from the db.
        Circle circle = new Circle();
        circle.setId(rs.getInt("id"));
        circle.setColor(new Color(
                rs.getInt("r"),
                rs.getInt("g"),
                rs.getInt("b")));
        circle.setFilled(rs.getBoolean("filled"));
        circle.setRadius(rs.getDouble("radius"));
        circle.setCenter(center);
        return new Circle();
    }
}
