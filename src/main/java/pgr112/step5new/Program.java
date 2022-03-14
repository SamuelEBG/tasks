package pgr112.step5new;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Program {

    public Program(){
        try{
            readFile();
            menu();
        }
        catch(FileNotFoundException parameter){
            System.out.println("oops");
            System.out.println(parameter.getMessage());
        }
    }

    public void readFile() throws FileNotFoundException {
        File file = new File("tasks/src/main/java/pgr112/step5new/opg4.txt");
        Scanner scan = new Scanner(file);
        while(scan.hasNextLine()){
            System.out.println(scan.nextLine());
        }
    }


    public void menu(){
        Scanner input = new Scanner(System.in);
        String menuChoices = """
                1 - Print to text file\s
                2 - bla bla\s
                3 - Exit menu\s
                4 - hello\s
                5 - lol\s
                """;
        String choice;
        do{
            System.out.println(menuChoices);
            choice = input.nextLine();
            switch(choice){
                case "1" -> {
                    System.out.println("Write 5 words to enter into a text file");
                }
                case "2" ->{
                    System.out.println("blabla section");
                }
                case "3" ->{
                    choice = "exit";
                    System.out.println("Closing program");
                }
                default -> {
                    System.out.println("not a menu choice, try again");
                }
            }
        } while(!choice.equals("exit"));
    }
}
