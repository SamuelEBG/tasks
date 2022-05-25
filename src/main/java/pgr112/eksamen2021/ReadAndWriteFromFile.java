package pgr112.eksamen2021;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class ReadAndWriteFromFile {

    public static void readFromTxtFile(String path, ArrayList<Equipment> arrayList){
        File equipment = new File(path);
        try(Scanner fileReader = new Scanner(equipment)){

            while(fileReader.hasNextLine()){
                String EquipmentSort = fileReader.nextLine();
                switch (EquipmentSort){
                    case "Ball" -> arrayList.add(ballFromFile(fileReader));
                    case "TableTennisRacket" -> arrayList.add(tableTennisRacketFromFile(fileReader));
                    default -> System.out.println("Not a recognized sort of equipment, done scanning");
                }
            }
        } catch (FileNotFoundException error){
            error.printStackTrace();
        }
    }

    private static TableTennisRacket tableTennisRacketFromFile(Scanner fileReader){

        int id = Integer.parseInt(fileReader.nextLine());
        String str = fileReader.nextLine();
        int lockerNumber = Integer.parseInt(String.valueOf(str.charAt(str.length()-1)));
        boolean needsReplacement = Boolean.parseBoolean(fileReader.nextLine());
        boolean needsNewCoating = Boolean.parseBoolean(fileReader.nextLine());

        return new TableTennisRacket(id, lockerNumber, needsReplacement, needsNewCoating);
    }

    private static Ball ballFromFile(Scanner fileReader){

        int id = Integer.parseInt(fileReader.nextLine());
        String str = fileReader.nextLine();
        int lockerNumber = Integer.parseInt(String.valueOf(str.charAt(str.length()-1)));
        boolean needsReplacement = Boolean.parseBoolean(fileReader.nextLine());
        BallType ballType = BallType.valueOf(fileReader.nextLine());
        boolean needsAir = Boolean.parseBoolean(fileReader.nextLine());

        return new Ball(id, lockerNumber, needsReplacement, ballType, needsAir);
    }
}
