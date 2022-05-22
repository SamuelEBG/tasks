package pgr112.step7;

import java.awt.Color;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Main {
    public static void main(String[] args){
        Program pr = new Program();

        pr.myMap.forEach((key, value) -> System.out.println(key));


        // System.out.println(myMap.get("3"));

        /*
        myMap.forEach((key, value) -> {
           if(value.getArea() > 4){
               System.out.println(value);
           }
        });
        */

        /*
        myMap.forEach((key, value) -> {
            if(value.getPerimeter() > 13){
                System.out.println(value);
            }
        });
        */
    }
}
