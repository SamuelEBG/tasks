package pgr112.step13.dto;

import pgr112.step13.shapes.MovablePoint;
import pgr112.step13.shapes.Rectangle;

import javax.xml.transform.Result;
import java.awt.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.Properties;

public class RectangleDao extends ShapeDao<Rectangle>{

    public RectangleDao(Properties properties){
        super(properties);
    }

    public RectangleDao(){
        super();
    }

    @Override
    public void save(Rectangle rectangle) throws SQLException {
        String preparedSave =
                "INSERT INTO Shapes.rectangle " +
                "(r, g ,b, filled, width, length, topLeft, bottomRight)" +
                "VALUES(?,?,?,?,?,?,?,?)";
        try(Connection conn = getConnection()){
            conn.setAutoCommit(false);
            PreparedStatement stmt = conn.prepareStatement(preparedSave, Statement.RETURN_GENERATED_KEYS);

            stmt.setInt(1, rectangle.getColor().getRed());
            stmt.setInt(2, rectangle.getColor().getGreen());
            stmt.setInt(3, rectangle.getColor().getBlue());

            stmt.setBoolean(4, rectangle.isFilled());
            stmt.setDouble(5, rectangle.getWidth());
            stmt.setDouble(6, rectangle.getLength());

            MovablePoint topLeft;
            MovablePoint bottomRight;
            MovablePointDao mpd = new MovablePointDao();
            // Either get the topLeft/bottomRight movablePoint from the
            // db, or if there is none, will return null.
            topLeft = mpd.retrieve(rectangle.getTopLeft().getId());
            bottomRight = mpd.retrieve(rectangle.getBottomRight().getId());
            // If there was no mp in the db, we use the movablePoint
            // that the rectangle has, and then we set the earlier
            // movablePoint we declared to be that movablePoint.
            if(topLeft == null){
                mpd.save(rectangle.getTopLeft());
            }
            if(bottomRight == null){
                mpd.save(rectangle.getBottomRight());
            }
            // Get id from both movablePoint, those will be foreign keys
            // to the movablePoints in the rectangle table.
            stmt.setInt(7, rectangle.getTopLeft().getId());
            stmt.setInt(8, rectangle.getBottomRight().getId());

            stmt.executeUpdate();
            conn.commit();

            ResultSet rs = stmt.getGeneratedKeys();
            if(rs.next()){
                rectangle.setId(rs.getInt(1));
            }

        } catch (SQLException error){
            error.printStackTrace();
        }
    }

    @Override
    public ArrayList<Rectangle> listAll() throws SQLException {
        ArrayList<Rectangle> result = new ArrayList<>();
        try(Connection conn = getConnection()){
            Statement stmt = conn.createStatement();
            String preparedSelect = "SELECT * FROM Shapes.rectangle";

            ResultSet resultSet = stmt.executeQuery(preparedSelect);
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
        try(Connection conn = getConnection()){
            Statement stmt = conn.createStatement();

            String deleteRectangle = "DELETE FROM Shapes.rectangle WHERE id = "+id;
            stmt.executeUpdate(deleteRectangle, Statement.RETURN_GENERATED_KEYS);

        } catch (SQLException error){
            error.printStackTrace();
        }
    }

    @Override
    public Rectangle retrieve(int id) throws SQLException {

        try(Connection conn = getConnection()){
            Statement stmt = conn.createStatement();

            String getRectangle = "SELECT * FROM Shapes.rectangle WHERE id = " + id;
            ResultSet resultSet = stmt.executeQuery(getRectangle);

            return mapFromResultSet(resultSet);

        } catch (SQLException error){
            error.printStackTrace();
        }

        return null;
    }

    @Override
    public Rectangle mapFromResultSet(ResultSet rs) throws SQLException {
        int topLeftId = rs.getInt("topLeft");
        int bottomRightId = rs.getInt("bottomRight");

        MovablePointDao mpd = new MovablePointDao();
        MovablePoint topLeft = mpd.retrieve(topLeftId);
        MovablePoint bottomRight = mpd.retrieve(bottomRightId);

        Rectangle rectanal = new Rectangle();
        rectanal.setId(rs.getInt("id"));
        rectanal.setColor( new Color(
                rs.getInt("r"),
                rs.getInt("g"),
                rs.getInt("b")
        ));
        rectanal.setFilled(rs.getBoolean("filled"));
        rectanal.setWidth(rs.getDouble("width"));
        rectanal.setLength(rs.getDouble("length"));
        rectanal.setTopLeft(topLeft);
        rectanal.setBottomRight(bottomRight);

        return rectanal;
    }
}
