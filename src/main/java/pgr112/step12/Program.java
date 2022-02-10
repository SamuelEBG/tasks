package pgr112.step12;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;

public class Program {

    //This were read ma files

    public HashMap<Integer, Equipment> equipmentHashMap;

    public Program(){
        this.equipmentHashMap = new HashMap<>();
    }

    public HashMap<Integer, Equipment> equipmentReader() throws FileNotFoundException {
        HashMap<Integer, Equipment> scannedEquipment = new HashMap<>();
        String filePath = "src/main/java/pgr112/step12/equipment.txt";
        File file = new File(filePath);
        Scanner scanFile = new Scanner(file);
        String input;
        while(scanFile.hasNextLine()){
            
        }
        return scannedEquipment;
    }
}
