package pgr112.step13.dto;

import pgr112.step13.shapes.MovablePoint;
import pgr112.step13.shapes.Square;

import javax.xml.transform.Result;
import java.awt.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.Properties;

public class SquareDao extends ShapeDao<Square> {

    public SquareDao(Properties properties){
        super(properties);
    }

    public SquareDao(){
        super();
    }

    @Override
    public void save(Square square) throws SQLException {
        String preparedSave =
                "INSERT INTO Shapes.square " +
                "(r, g, b, filled, sides, topLeft, bottomRight)" +
                "VALUES(?,?,?,?,?,?,?)";
        try(Connection conn = getConnection()){
            conn.setAutoCommit(false);
            PreparedStatement stmt = conn.prepareStatement(preparedSave, Statement.RETURN_GENERATED_KEYS);

            MovablePointDao mpd = new MovablePointDao();
            MovablePoint topLeft = mpd.retrieve(square.getTopLeft().getId());
            MovablePoint bottomRight = mpd.retrieve(square.getBottomRight().getId());

            if(topLeft == null){
                mpd.save(square.getTopLeft());
            }

            if(bottomRight == null){
                mpd.save(square.getBottomRight());
            }

            stmt.setInt(1, square.getColor().getRed());
            stmt.setInt(2, square.getColor().getGreen());
            stmt.setInt(3, square.getColor().getBlue());

            stmt.setBoolean(4, square.isFilled());
            stmt.setDouble(5, square.getSide());

            stmt.setInt(6, square.getTopLeft().getId());
            stmt.setInt(7, square.getBottomRight().getId());

            stmt.executeUpdate();
            conn.commit();

            ResultSet resultSet = stmt.getGeneratedKeys();
            if(resultSet.next()){
                square.setId(resultSet.getInt(1));
            }

        } catch (SQLException error){
            error.printStackTrace();
        }
    }

    @Override
    public ArrayList<Square> listAll() throws SQLException {
        ArrayList<Square> result = new ArrayList<>();
        try(Connection conn = getConnection()){
            Statement stmt = conn.createStatement();
            String getAllSquares = "SELECT * FROM Shapes.square";

            ResultSet resultSet = stmt.executeQuery(getAllSquares);
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

            String deleteSquare = "DELETE FROM Shapes.square WHERE id = " + id;
            stmt.executeUpdate(deleteSquare, Statement.RETURN_GENERATED_KEYS);

        } catch (SQLException error){
            error.printStackTrace();
        }
    }

    @Override
    public Square retrieve(int id) throws SQLException {

        try(Connection conn = getConnection()){
            Statement stmt = conn.createStatement();

            String getSquare = "SELECT * FROM Shapes.square WHERE id = " + id;
            ResultSet resultSet = stmt.executeQuery(getSquare);

            return mapFromResultSet(resultSet);
        } catch(SQLException error){
            error.printStackTrace();
        }

        return null;
    }

    @Override
    public Square mapFromResultSet(ResultSet rs) throws SQLException {
        int topLeftId = rs.getInt("topLeft");
        int bottomRightId = rs.getInt("bottomRight");

        MovablePointDao mpd = new MovablePointDao();
        MovablePoint topLeft = mpd.retrieve(topLeftId);
        MovablePoint bottomRight = mpd.retrieve(bottomRightId);

        Square square = new Square();
        square.setColor( new Color(
                rs.getInt("r"),
                rs.getInt("g"),
                rs.getInt("b")
        ));
        square.setFilled(rs.getBoolean("filled"));
        square.setSide(rs.getDouble("sides"));
        square.setTopLeft(topLeft);

        return square;
    }
}
