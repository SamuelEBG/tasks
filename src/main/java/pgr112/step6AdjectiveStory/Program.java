package pgr112.step6AdjectiveStory;

import java.util.Scanner;

public class Program {

    private boolean running = true;

    public Program(){
        menu();
    }

    public void menu(){
        Scanner input = new Scanner(System.in);
        ReadWriteFromFile rw = new ReadWriteFromFile();
        String menuChoices = """
                1 - Create adjective story automatically\s
                2 - Create adjective story with your own adjectives\s
                3 - Exit the program\s
                """;
        String choices;
        System.out.println(menuChoices);
        do{
            choices = input.nextLine();
            switch(choices){
                case "0" -> System.out.println(menuChoices);

                case "1" -> {
                    System.out.println("heres your automatic story");
                    rw.randomStory();
                }

                case "2" -> {
                    System.out.println("own story");
                    rw.userCreateStory(input);
                }

                case "3" -> {
                    System.out.println("Exiting program");
                    running = false;
                }
                default -> System.out.println("not valid input, press 0 to get menu");
            }

        } while(running);
    }
}
