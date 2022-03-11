package pg42sg.task04e;

// Import Classification.* to import
import static pg42sg.task04e.TriangleClassification.Classification.*;


public class TriangleClassification {
    // Consider imports when creating test, enum has to be imported
    // As static in the test class, so when we return a constant
    // from the enum we just type the constant without the enum first.
    public enum Classification {NOT_A_TRIANGLE, ISOSCELES, SCALENE, EQUILATERAL}

    // This method also has to be imported as static, since static
    // methods cannot be instantiated, they can be called from outside the class.
    public static Classification classify(int a, int b, int c) {

        // Any triangle cannot have negative or 0 length of size.
        if(a <= 0 || b <= 0 || c <= 0){
            return NOT_A_TRIANGLE;
        }
        // Triangle with equal sides.
        if(a==b && b==c){
            return EQUILATERAL;
        }
        // Here we check if one of the sides is too long, for example greater or
        // equal to both the other sides.
        // Returns the greatest value of parameters a, b
        // and in this case it will also check against parameters b, c
        int max = Math.max(a, Math.max(b, c));
        // In the case of 1,2,3 => max (1, (3)) max=3 (c)
        if ((max == a && max - b - c >= 0) ||
                (max == b && max - a - c >= 0) ||
                (max == c && max - a - b >= 0)) {   // check if max is greater or
            return NOT_A_TRIANGLE;                  // equal to the other 2 numbers.
        }

        /*
        if((a==b && c==a-1) || (a==c && b==a-1) || (b==c && a==b-1)){
            return ISOSCELES;
        }
         */

        // (a==b && c==a-1) || (a== c && b==a-1) || (b==c && a==b-1)

        // Lastly we have equal long sides with 1 smaller side
        // which will return false in the previous statement because the largest
        // side minus the 2 other sides will return a negative result
        // resulting in moving forward to this method.
        if(a==b || a==c || b==c){
            return ISOSCELES;
        } else{
            // none of the sides are equally long, but neither
            // of the sides are longer than the other to create a
            // false triangle.
            return SCALENE;
        }
    }
}

/*

public class TriangleClassification {

    public enum Classification {NOT_A_TRIANGLE, ISOSCELES, SCALENE, EQUILATERAL}


    public static Classification classify(int a, int b, int c) {

        if(a <= 0 || b <= 0 || c <= 0){
            return NOT_A_TRIANGLE;
        }

        if(a==b && b==c){
            return EQUILATERAL;
        }

        int max = Math.max(a, Math.max(b, c));

        if ((max == a && max - b - c >= 0) ||
                (max == b && max - a - c >= 0) ||
                (max == c && max - a - b >= 0)) {
            return NOT_A_TRIANGLE;
        }

        if(a==b || a==c || b==c){
            return ISOSCELES;
        } else {
            return SCALENE;
        }
    }
}

 */

