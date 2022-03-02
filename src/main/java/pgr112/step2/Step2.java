package pgr112.step2;

import java.util.Locale;

public class Step2 {

    public static void main(String[] args){
        var test = new Step2();
        String lol = test.isNumberSmallMediumOrBig(-99999);
        System.out.println(lol);
        String[] arrayOfStrings = {"haj", "på", "daj", "det", "här", "är", "massa", "Strings"};
        test.printAllStrings(arrayOfStrings);
    }

    public int addThreeNumbers(int i, int j, int k){
        return i + j + k;
    }

    public String isNumberSmallMediumOrBig(int number){
        String result;
        if(number < 100){
            result = "Number is small";
        } else if(number < 1000){
            result = "Number is medium";
        }else
        result = "Big ol number";

        return result;
    }

    public void printAllStrings(String[] strings){
        for(String s : strings){
            System.out.println(s);
        }
    }
    public int arraySum(int[] numbers){
        int sum = 0;
        for(Integer i : numbers){
            sum += i;
        }
        return sum;
    }

    public void printFirstSentence(char[] chars){
        for (char aChar : chars) {
            if (aChar == '.') {
                break;
            }
            System.out.println(aChar);
        }
    }
    public void printCourseName(String courseCode){
        switch(courseCode){
            case "PGR103" -> System.out.println("Objektorientert programmering");
            case "DB1102" -> System.out.println("Database");
            case "TK2100" -> System.out.println("Informasjonssikkerhet");
            default -> System.out.println("Unknown");
        }
    }
    public void printAllStringsNotCorona(String[] strings){
        for(String s : strings){
            if(!s.equals("Corona")){
                System.out.println(s);
            }
        }
    }

    public void printUpperCaseStrings(String[] strings){
        for(String s : strings){
            System.out.println(s.toUpperCase(Locale.ROOT));
        }
    }

    public boolean isColorInNorwegianFlag(String color){
        switch(color){
            case "red", "white", "blue" -> {
                return true;
            }
            default -> {
                return false;
            }
        }
    }

    public int firstOccurrence(String string, char c){
        for(int i = 0; i < string.length(); i++){
            if(string.charAt(i) == c){
                return i;
            }
        }
        return -1;
    }

    public int combinedLength(String s1, String s2){
        return s1.length()+s2.length();
    }

    public int addNumbers(int... numbers){
        int sum = 0;
        for(int i : numbers){
            sum += i;
        }
        return sum;

    }
}
