package pg42sg.Eksamen2022;

public class Ex01 {

    /*
        I have presumed that the path consists of folders with the name of the course, project, packages etc.
        Therefor the path would not start with "/test", nor would the test file be in a folder called
        "/test/programTest.java", but the test-folder would be somewhere within the folder-structure.

        (\\/[a-zA-Z0-9]+)+ = path begins with "/path/path/path..."
        \/[tT][eE][sS][tT]+ = the folder structure must contain a string with "/test"
        (\/[a-zA-Z0-9]+)+ = followed by more "/path/path/path..."
        (\/[a-zA-Z0-9]+)Test = this will match a file name that ends with "Test"
        \.((java)|(cpp)|(kt)) = this will match the file types ".java | .cpp | .kt"

     */

    public String regexPartA(){
        return "(\\/[a-zA-Z0-9]+)+\\/[tT][eE][sS][tT]+(\\/[a-zA-Z0-9]+)+(\\/[a-zA-Z0-9]+)Test\\.((java)|(cpp)|(kt))";
    }

    /*
        I have assumed that if a course starts with PG, it contains 4 digits, and if a course starts with
        3 letters, PG and a unique letter for that course, that course contains 3 digits.
        @[a-zA-Z0-9]+:  = is @ followed by a username followed by : and a white space
        .*(()*([pP][gG][0-9]{4})|([pP][gG][a-zA-Z][0-9]{3}) = takes into consideration that there might be a dot or a space before the course name
        "([pP][rR][oO][gG][rR][aA][mM][mM][eE][rR][iI][nN][gG])|([pP][rR][oO][gG][rR][aA][mM][mM][iI][nN][gG]))+.*[?]+ = takes into consideration
        that a course name might end with a dot, and that the line must end with a question mark.

     */

    public String regexPartB(){
        return "@[a-zA-Z0-9]+: .*(()*([pP][gG][0-9]{4})|([pP][gG][a-zA-Z][0-9]{3})|" +
                "([pP][rR][oO][gG][rR][aA][mM][mM][eE][rR][iI][nN][gG])|([pP][rR][oO][gG][rR][aA][mM][mM][iI][nN][gG]))+.*[?]+";
    }
}
