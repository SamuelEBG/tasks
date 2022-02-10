package pgr112.step4;

import java.util.Scanner;
import java.util.ArrayList;

public class Program {

    static ArrayList<String> inputArray = new ArrayList<>();


    public static void runProgram(){
        System.out.println("Program Starting!");
        Program.userInput();
        Program.printArray();
    }

    public static void userInput(){
        int index = 0;
        Scanner input = new Scanner(System.in);
        while (index <= 2) {
            System.out.println("Type a word to add to the array");
            String choice = input.next();
            inputArray.add(choice);
            index++;
        }
        // System.out.println(inputArray.stream().toList());
    }

    public static void printArray(){
        String result = "";
        for(int i = 0; i < inputArray.size(); i++ ){
            result += inputArray.get(i) + " ";
        }
        System.out.println("These are the words you typed: " + result);
    }

    public static void userNumberInput(){
        Scanner numberInput = new Scanner(System.in);
        int number = numberInput.nextInt();
        int sum = 0;
        while(number >= 0){
            sum += number;
            number = numberInput.nextInt();
        }
        System.out.println("Sum of all inputs is: " + sum);
    }

    String allWords = ""; // string which will be filled with words from array and printed
    ArrayList<String> userInputArray = new ArrayList<>(); // make an array for the words to put in

    public void userStringInputProgram(){
        Scanner input = new Scanner(System.in); // make 2 new scanners for each input
        Scanner userWord = new Scanner(System.in);
        int choice = 0;
        while(choice != 3){  //while loop to check users choice
            System.out.println("Press 1 to enter a word - Press 2 to print words - Press 3 to exit.");
            choice = input.nextInt(); //userchoice is whatever user presses between 1-3
            switch(choice){
                case 1:
                    System.out.println("Type a word you want to add to the array:");
                    userInputArray.add(userWord.next());
                    break;
                case 2:
                    System.out.println("Printing words in array:");
                    for(int i = 0; i < userInputArray.size(); i++){
                        this.allWords += userInputArray.get(i) + " ";
                    }
                    System.out.println(this.allWords);
                    break;
                case 3:
                    System.out.println("Exiting program.");
                    input.close();
                    break;
            }
        }
    }
}
