package pg42sg.task04e;

public class TriangleClassification {

    public enum Classification {NOT_A_TRIANGLE, ISOSCELES, SCALENE, EQUILATERAL}

    public static Classification classify(int a, int b, int c) {

        if(a < 0 || b < 0 || c < 0){
            return Classification.NOT_A_TRIANGLE;
        }


        return null;
    }
}
