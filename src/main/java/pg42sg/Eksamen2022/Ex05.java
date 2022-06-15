package pg42sg.Eksamen2022;
import org.pg4200.les11.BitReader;
import org.pg4200.les11.BitWriter;

import java.util.HashMap;
import java.util.Map;

public class Ex05 {

    private HashMap<Integer, String> programs = new HashMap<>();
    private HashMap<Integer, String> months = new HashMap<>();

    public Ex05(){
        addPrograms();
        addMonths();
    }

    public void addMonths(){
        months.put(1, "JAN");
        months.put(2, "FEB");
        months.put(3, "MAR");
        months.put(4, "APR");
        months.put(5, "MAY");
        months.put(6, "JUN");
        months.put(7, "JUL");
        months.put(8, "AUG");
        months.put(9, "SEP");
        months.put(10, "OCT");
        months.put(11, "NOV");
        months.put(12, "DEC");
    }

    public void addPrograms(){
        programs.put(1, "Programming");
        programs.put(2, "Artificial Intelligence");
        programs.put(3, "Front-end Programming");
        programs.put(4, "Cyber Security");
        programs.put(5, "Data Science");
    }

    private int getMonthDigit(String month){
        int result = 0;

        for (Map.Entry<Integer, String> months : months.entrySet()){
            if(months.getValue().equalsIgnoreCase(month)){
                result = months.getKey();
            }
        }
        return result;
    }

    /**

     */



    public byte[] compress(String data){
        BitWriter writer = new BitWriter();

        for(int i = 0; i < data.length(); i++){

            char c = data.charAt(i);
            String program = "";
            while(c != '-'){
                program += c;
                i++;
                c = data.charAt(i);
            }

            switch (program){
                case "Programming" -> writer.write(1, 3);
                case "ArtificialIntelligence" -> writer.write(2, 3);
                case "FrontendProgramming" -> writer.write(3, 3);
                case "Cybersecurity" -> writer.write(4, 3);
                case "DataScience" -> writer.write(5, 3);
            }

            i+= 1;

            writer.write(data.charAt(i) - 'a', 5);
            writer.write(data.charAt(i+1) - 'a', 5);

            i+= 2;

            String fourDigits = "";
            for(int j = 0; j < 4; j++){
                fourDigits += data.charAt(i + j);
            }

            writer.write(Integer.parseInt(fourDigits), 12);
            i+= 5;

            String uniqueCode = "";
            for(int j = 0; j < 6; j++){
                uniqueCode += data.charAt(i + j);
            }

            writer.write(Integer.parseInt(uniqueCode), 18);

            i+= 2;

            writer.write(data.charAt(i) - 'A', 3);

            i+= 4;

            String year = "";
            for(int j = 0; j < 4; j++){
                year += data.charAt(i + j);
            }

            writer.write(Integer.parseInt(year), 12);
            i+= 5;

            String month = "";
            for(int j = 0; j < 3; j++){
                month += data.charAt(i + j);
            }

            writer.write(getMonthDigit(month), 4);
            i+= 4;

            String day = "";
            for(int j = 0; j < 2; j++){
                day += data.charAt(i + j);
            }

            writer.write(Integer.parseInt(day), 5);
            // Skip over the part of the string containing ". File: feedback-"
            i+= 18;

            writer.write(data.charAt(i) - 'a', 5);
            writer.write(data.charAt(i+1) - 'a', 5);

            i+= 2;

            fourDigits = "";
            for(int j = 0; j < 4; j++){
                fourDigits += data.charAt(i + j);
            }

            writer.write(Integer.parseInt(fourDigits), 12);
            i+= 5;

            uniqueCode = "";
            for(int j = 0; j < 6; j++){
                uniqueCode += data.charAt(i + j);
            }

        }
        return writer.extract();
    }

    public String decompress(byte[] archive){
        return "haj";
    }
}
