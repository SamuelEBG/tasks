package pgr112.step13b;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Task2 {

    public void program(){
        menuArray();
        Scanner input = new Scanner(System.in);
        String choice = "0";

        while(!choice.equalsIgnoreCase("3")) {
            choice = input.nextLine();
            switch (choice) {
                case "1" -> {
                    storyCreator(1);
                    menuArray();
                }
                case "2" ->{
                    storyCreator(2);
                    menuArray();
                }
                case "3" ->{
                    System.out.println("Exiting program, fuck you");
                }
                default -> {
                    System.out.println("not a valid input");
                    menuArray();
                }
            }
        }
    }

    public void storyCreator(int choice){
        try {
            System.out.println("Scanning starting" + "\n");
            String readPath = "src/main/java/pgr112/largeTask/story.txt";
            String writePath = "src/main/java/pgr112/largeTask/newstory.txt";
            File file = new File(readPath);
            FileWriter writer = new FileWriter(writePath);
            Scanner reader = new Scanner(file);
            Scanner input = new Scanner(System.in);


            if (choice == 1) {
                while (reader.hasNextLine()) {
                    String line = reader.nextLine();
                    if (line.contains("__")) {
                        line = line.replace("__", adjectiveArray());
                        writer.write(line + "\n");
                        System.out.println(line);
                    } else {
                        writer.write(line);
                    }
                }
                writer.close();
            } else{
                /*
                String story = "";
                System.out.println("Här bärjar historian");
                System.out.println(reader.nextLine());
                System.out.println("skriv in ett adjektiv för mellanrummet __");
                 */
                while (reader.hasNextLine()) {
                    String inputs = input.next();
                    String line = reader.nextLine();
                    if (line.contains("__")) {
                        System.out.println("enter an adjective for spaces with __");
                        line = line.replace("__", inputs);
                        writer.write(line + "\n");
                    } else {
                        writer.write(line);
                    }
                }
                writer.close();
            }
        }
        catch(FileNotFoundException a){
            System.out.println("File not found");
            a.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void menuArray(){
        ArrayList<String> menu = new ArrayList<>();
        menu.add("Create adjective history automatically");
        menu.add("Create adjective history manually");
        menu.add("Exit");

        for(int i = 0; i < 3; i++){
            System.out.println(i+1 + " -> " + menu.get(i));
        }
    }

    public String adjectiveArray() {
        String rndStr = "";
        try {
            String adjectives = "src/main/java/pgr112/largeTask/adjectiv.txt";
            File file = new File(adjectives);
            ArrayList<String> adjectivesArray = new ArrayList<>();
            Scanner scanner = new Scanner(file);

            while (scanner.hasNextLine()) {
                adjectivesArray.add(scanner.nextLine());
            }
            scanner.close();
            rndStr = adjectivesArray.get(new Random().nextInt(adjectivesArray.size()));
        } catch (FileNotFoundException a) {
            System.out.println("File not found");
            a.printStackTrace();
        }
        return rndStr;
    }

}
