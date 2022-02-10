package pgr112.step13;

import java.awt.*;
import java.sql.*;
import java.util.ArrayList;
import pgr112.step13.Square;

public class JDBCOps {

    public JDBCOps(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        }
        catch(ClassNotFoundException exception){
            exception.printStackTrace();
        }
    }

    public boolean insertShape(Shape shape){

        try(Connection con = DriverManager
                .getConnection("jdbc:mysql://localhost:3306/shapes?useSSL=false", "oopuser", "root")){

            Statement stmt = con.createStatement();

            int isFilled = (shape.isFilled()) ? 1 : 0;

            if (shape instanceof Circle) {
                System.out.println("inserting circle");
                String insertSql = "INSERT INTO circle(radius, area, perimeter, r, g, b, filled, center)"
                        + " VALUES('" +
                        ((Circle)shape).getRadius() + "', '" +
                        shape.getArea() + "', '" +
                        shape.getPerimeter() + "', '" +
                        shape.getColor().getRed() + "', '" +
                        shape.getColor().getGreen() + "', '" +
                        shape.getColor().getBlue() + "', '" +
                        isFilled + "', '" +
                        ((Circle)shape).getCenter() +
                        "')";
                stmt.executeUpdate(insertSql);
                System.out.println("done inserting circle");
            } else if (shape instanceof Square) {
                String insertSql = "INSERT INTO square(sides, area, perimeter, r, g, b, filled, topLeft, bottomRight)"
                        + " VALUES('" +
                        ((Square) shape).getSide() + "', '" +
                        shape.getArea() + "', '" +
                        shape.getPerimeter() + "', '" +
                        shape.getColor().getRed() + "', '" +
                        shape.getColor().getGreen() + "', '" +
                        shape.getColor().getBlue() + "', '" +
                        isFilled + "', '" +
                        ((Square) shape).getTopLeft() + "', '" +
                        ((Square) shape).getBottomRight() +
                        "')";
                stmt.executeUpdate(insertSql);
            } else if (shape instanceof Rectangle) {
                String insertSql = "INSERT INTO rectangle(width, length, area, perimeter, r, g, b, filled, topLeft, bottomRight)"
                        + " VALUES('" +
                        ((Rectangle) shape).getWidth() + "', '" +
                        ((Rectangle) shape).getLength() + "', '" +
                        shape.getArea() + "', '" +
                        shape.getPerimeter() + "', '" +
                        shape.getColor().getRed() + "', '" +
                        shape.getColor().getGreen() + "', '" +
                        shape.getColor().getBlue() + "', '" +
                        isFilled + "', '" +
                        ((Rectangle) shape).getTopLeft() + "', '" +
                        ((Rectangle) shape).getBottomRight() +
                        "')";
                stmt.executeUpdate(insertSql);
            }
        } catch(SQLException sqlException){
            sqlException.printStackTrace();
            return false;
        }
        return true;
    }

    public ArrayList<Shape> getAllShapes(){
        ArrayList<Shape> shapesFromDb = new ArrayList<>();

        try(Connection con = DriverManager
                .getConnection("jdbc:mysql://localhost:3306/shapes?useSSL=false", "oopuser", "root")) {

            Statement stmt = con.createStatement();
            String circleSql = "SELECT * FROM circle";

            ResultSet rc = stmt.executeQuery(circleSql);
            while(rc.next()){
                var c = new Circle();
                c.setRadius(rc.getDouble("radius"));
                c.setColor(new Color(rc.getInt("r"),
                        rc.getInt("g"),
                        rc.getInt("b")));
                c.setFilled(rc.getBoolean("filled"));
                String str = rc.getString("center");
                String[] strArray = str.split(",");
                double x = Double.parseDouble(strArray[0]);
                double y = Double.parseDouble(strArray[1]);
                c.setCenter( new MovablePoint(x, y));
                shapesFromDb.add(c);
            }

            String rectangle = "SELECT * FROM rectangle";
            ResultSet rS = stmt.executeQuery(rectangle);
            while(rS.next()){
                var r = new Rectangle();
                r.setWidth(rS.getDouble("width"));
                r.setLength(rS.getDouble("length"));
                r.setColor(new Color(rS.getInt("r"),
                        rS.getInt("g"),
                        rS.getInt("b")));
                r.setFilled(rS.getBoolean("filled"));
                String str = rS.getString("topLeft");
                String[] strArray = str.split(",");
                double x = Double.parseDouble(strArray[0]);
                double y = Double.parseDouble(strArray[1]);
                r.setTopLeft(new MovablePoint(x, y));
                r.setBottomRight(new MovablePoint(
                        x+rS.getDouble("width"),
                            y-rS.getDouble("length")));
                shapesFromDb.add(r);
            }

        }catch (SQLException sqlE){
            sqlE.printStackTrace();
        }
        return shapesFromDb;
    }

}
