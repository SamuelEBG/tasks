package pgr112.step6AdjectiveStory;

import java.io.*;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class ReadWriteFromFile {

    private final ArrayList<String> adjectives;
    private ArrayList<String> userAdjectives;
    private String adj = "";

    public ReadWriteFromFile(){
        adjectives = new ArrayList<>();
        adjectivesToArray();
        readFromAdjFile();
    }

    public void writeStoryToFile(String path, String story){

        try(FileWriter writer = new FileWriter(path)){
        BufferedWriter save = new BufferedWriter(writer);

        writer.write(story + "\n");

        } catch (IOException e){
            e.printStackTrace();
        }
    }

    public void randomStory(){
        String randomStory = adj;

        for(int i = 0; i < 23; i++){
            randomStory = randomStory.replaceFirst("__", getRandomAdjective(adjectives));
        }

        String path = "tasks/src/main/resources/step6adjectives/newstory.txt";
        writeStoryToFile(path, randomStory);

        System.out.println(randomStory);
    }

    public void userCreateStory(Scanner scan){
        userAdjectives = new ArrayList<>();
        String userStory = adj;
        System.out.println("Add 23 adjectives to use in your story");

        for(int i = 0; i < 23; i++){
            userAdjectives.add(scan.nextLine());
            System.out.println(23-(i+1) + " Adjectives remaining");
        }

        for(int i = 0; i < 23; i++){
            userStory = userStory.replaceFirst("__", getRandomAdjective(userAdjectives));
        }

        String path = "tasks/src/main/resources/step6adjectives/newuserstory.txt";
        writeStoryToFile(path, userStory);

        System.out.println("Here's your user story");
        System.out.println(userStory);
    }

    public void readFromAdjFile(){
        String path = "tasks/src/main/resources/step6adjectives/story.txt";

        try(Scanner scan = new Scanner( new File(path))){
            // StringBuilder sb = new StringBuilder();
            while(scan.hasNextLine()){
                adj += scan.nextLine() + "\n";
                // sb.append("\n" + input);
            }
            // String contents = sb.toString();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void adjectivesToArray(){
        String filePath = "tasks/src/main/resources/step6adjectives/adjectives.txt";

        try(Scanner scan = new Scanner(new File(filePath))){

            while(scan.hasNextLine()){
                adjectives.add(scan.nextLine());
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public String getRandomAdjective(ArrayList<String> arrayList){
        Random random = new Random();
        return arrayList.get(random.nextInt(arrayList.size()));
    }
}
