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
        programs.put(2, "ArtificialIntelligence");
        programs.put(3, "FrontendProgramming");
        programs.put(4, "Cybersecurity");
        programs.put(5, "DataScience");
    }

    private int getMonthByDigit(String month){
        int result = 0;

        for (Map.Entry<Integer, String> months : months.entrySet()){
            if(months.getValue().equalsIgnoreCase(month)){
                result = months.getKey();
            }
        }
        return result;
    }

    private String getMonthByDigit(int digit){
        return months.get(digit);
    }

    /**
     I have implemented BitWriter and BitReader for this task.
     For this task I will store the months and the name of the programs in HashMaps and access
     them with a digit that we will use in the compresser, this is similar to how we solved similar tasks.
     How many bits will we use.
     From the explanation it seems that the inputs should contain a grade, which is not present in the examples.
     In the feedback list assessment is after unique-id, and in the described format below assessment comes after
     course-code, so I have added the grade after the unique id with a ":" between them, that is where
     it looks like it should be from the format description.

     <program> is stored as a digit from 1-5, so 3 bits.
     <course-code> both letters are stored with 5 bits each, so 10bits.
     <course-code> the remaining 4 digits are stored with 16 bits.
     <unique-id> is stored with 24 bits.
     <assessment> is stored with 3 bits.
     <date-of-completion> year with 12 bits, month is stored with its key from the hashmap and uses 4 bits, day 5 bits. 21 combined.
     <filename> a combination of course-code and unique-id for a combined 26 bits.

     Each input will use 104 bits.
     */

    public byte[] compress(String data){
        BitWriter writer = new BitWriter();

        for(int i = 0; i < data.length(); i++){
            /*
                After reading each part of information from the String and compressing it,
                we have to increment i manually so that it ends up at the next part of information we want
                to write. The entries are composed of parts that are static that we don't compress.
                Those are skipped by incrementing i, over spaces and special characters.
                The for loop is supposed to only run once (length of the String).
             */

            // Write each character until it hits "-", then we know the course name is stored
            char c = data.charAt(i);
            String program = "";
            while(c != '-'){
                program += c;
                i++;
                c = data.charAt(i);
            }

            // Depending on what course name we get, compress it's corresponding digit from the HashMap.
            switch (program){
                case "Programming" -> writer.write(1, 3);
                case "ArtificialIntelligence" -> writer.write(2, 3);
                case "FrontendProgramming" -> writer.write(3, 3);
                case "Cybersecurity" -> writer.write(4, 3);
                case "DataScience" -> writer.write(5, 3);
            }
            i+= 1;

            // First letters in the course-code
            writer.write(data.charAt(i) - 'A', 5);
            writer.write(data.charAt(i+1) - 'A', 5);
            i+= 2;

            // 4 digits in the course-code
            String fourDigits = "";
            for(int j = 0; j < 4; j++){
                fourDigits += data.charAt(i + j);
            }
            writer.write(Integer.parseInt(fourDigits), 16);
            i+= 5;

            // 6 digits of unique-id
            String uniqueCode = "";
            for(int j = 0; j < 6; j++){
                uniqueCode += data.charAt(i + j);
            }
            writer.write(Integer.parseInt(uniqueCode), 24);
            i+= 7;

            // The overall grade.
            writer.write(data.charAt(i) - 'A', 3);
            i+= 4;

            // Date.
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
            writer.write(getMonthByDigit(month), 4);
            i+= 4;

            String day = "";
            for(int j = 0; j < 2; j++){
                day += data.charAt(i + j);
            }
            writer.write(Integer.parseInt(day), 5);
            i+= 19; // Skip over the part of the string containing ". File: feedback-"

            // Course code and unique ID as seen in the filename.
            writer.write(data.charAt(i) - 'a', 5);
            writer.write(data.charAt(i+1) - 'a', 5);
            i+= 2;

            String fd = "";
            for(int j = 0; j < 4; j++){
                fd += data.charAt(i + j);
            }
            writer.write(Integer.parseInt(fd), 16);
            i+= 5;

            String uq = "";
            for(int j = 0; j < 6; j++){
                uq += data.charAt(i + j);
            }
            writer.write(Integer.parseInt(uq), 24);
            i+= 11; // Last 11 spaces after the unique id is written, the for loop will exit because i = data.length.
        }
        return writer.extract();
    }

    public String decompress(byte[] data){
        BitReader reader = new BitReader(data);
        String result = "";
        int entries = (data.length * 8) / 104; // Amount of bits we used to compress

        for(int i = 0; i < entries; i++){
            /*
                Special characters are added manually, names of the programs are added from the HashMap.

             */
            int prog = reader.readInt(3);
            result += programs.get(prog);
            result += "-";

            // The first 2 letters in the course code.
            result += (char) ('A' + reader.readInt(5));
            result += (char) ('A' + reader.readInt(5));

            // The 4 digits in the course code, 0 that is not decompressed taken into consideration.
            result += String.format("%1$" + 4 + "s", reader.readInt(16)).replace(' ','0');
            result += ":";

            // The unique id.
            result += reader.readInt(24);
            result += ":";
            // The average grade.
            result += (char) ('A' + reader.readInt(3));
            result += " / ";
            // The year.
            result += reader.readInt(12);
            result += "-";

            int month = reader.readInt(4);
            result += months.get(month);
            result += "-";
            // Days.
            result += String.format("%1$" + 2 + "s", reader.readInt(5)).replace(' ','0');
            result += ". File: feedback-";
            // Course code and unique ID
            result += (char) ('A' + reader.readInt(5));
            result += (char) ('A' + reader.readInt(5));

            result += String.format("%1$" + 4 + "s", reader.readInt(16)).replace(' ','0');
            result += "-";

            result += reader.readInt(24);
            result += ".pdf;"; // Ending of document with file format.

        }
        return result;
    }
}
