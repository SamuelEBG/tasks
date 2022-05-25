package pgr112.eksamen2021;

import java.util.ArrayList;

import static pgr112.eksamen2021.ReadAndWriteFromFile.readFromTxtFile;

public class Program {

    ArrayList<Equipment> equipment;
    private final String path = "tasks/src/main/resources/eksamen2021/equipment.txt";

    public Program() {
        this.equipment = new ArrayList<>();
        readFromTxtFile(path, equipment);
    }

    static class Main {
        public static void main(String[] args) {
            Program prod = new Program();
            prod.equipment.forEach(System.out::println);
            prod.printBallsNeedingMoreAir();
            prod.printEquipmentNeedingToBeReplaced();
            prod.printTableTennisRacketsNeedingNewPad();
        }
    }

    public void printBallsNeedingMoreAir(){
        equipment.stream()
                .filter(value -> value instanceof Ball)
                .filter(value -> ((Ball) value).isNeedsAir())
                .forEach(System.out::println);
    }

    public void printEquipmentNeedingToBeReplaced(){
        equipment.stream()
                .filter(Equipment::isNeedsReplacement)
                .forEach(System.out::println);
    }

    public void printTableTennisRacketsNeedingNewPad(){
        equipment.stream()
                .filter(equipment -> equipment instanceof TableTennisRacket)
                .filter(equipment -> ((TableTennisRacket) equipment).isNeedsNewCoating())
                .forEach(System.out::println);
    }
}
