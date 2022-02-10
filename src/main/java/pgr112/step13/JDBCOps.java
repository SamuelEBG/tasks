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
            ResultSet rr = stmt.executeQuery(rectangle);
            while(rr.next()){
                var r = new Rectangle();
                r.setWidth(rr.getDouble("width"));
                r.setLength(rr.getDouble("length"));
                r.setColor(new Color(rr.getInt("r"),
                        rr.getInt("g"),
                        rr.getInt("b")));
                r.setFilled(rr.getBoolean("filled"));
                String str = rr.getString("topLeft");
                String[] strArray = str.split(",");
                double x = Double.parseDouble(strArray[0]);
                double y = Double.parseDouble(strArray[1]);
                r.setTopLeft(new MovablePoint(x, y));
                r.setBottomRight(new MovablePoint(
                        x+rr.getDouble("width"),
                            y-rr.getDouble("length")));
                shapesFromDb.add(r);
            }

            String square = "SELECT * FROM square";
            ResultSet rs = stmt.executeQuery(square);
            while(rs.next()){
                var s = new Square();
                s.setSide(rs.getDouble("sides"));
                s.setColor(new Color(rs.getInt("r"),
                        rs.getInt("g"),
                        rs.getInt("b")));
                s.setFilled(rs.getBoolean("filled"));
                String str = rs.getString("topLeft");
                String[] strArray = str.split(",");
                double x = Double.parseDouble(strArray[0]);
                double y = Double.parseDouble(strArray[1]);
                s.setTopLeft(new MovablePoint(x, y));
                shapesFromDb.add(s);
            }


        }catch (SQLException sqlE){
            sqlE.printStackTrace();
        }
        return shapesFromDb;
    }

    public ArrayList<Shape> getSquaresByAreaGT(double area){
        ArrayList<Shape> areaShapes= new ArrayList<>();

        try(Connection con = DriverManager
                .getConnection("jdbc:mysql://localhost:3306/shapes?useSSL=false", "oopuser", "root")){

            Statement stmt = con.createStatement();
            String getSquaresByArea = "SELECT * FROM square " +
                    "WHERE area < " + area;
            ResultSet sa = stmt.executeQuery(getSquaresByArea);
            while(sa.next()){
                var c = new Square();
                c.setSide(sa.getDouble("sides"));
                c.setColor(new Color(sa.getInt("r"),
                        sa.getInt("g"),
                        sa.getInt("b")));
                c.setFilled(sa.getBoolean("filled"));
                String str = sa.getString("topLeft");
                String[] strArray = str.split(",");
                double x = Double.parseDouble(strArray[0]);
                double y = Double.parseDouble(strArray[1]);
                c.setTopLeft(new MovablePoint(x, y));
                areaShapes.add(c);
            }
        }catch (SQLException ex){
            ex.printStackTrace();
        }
        return areaShapes;
    }

}
