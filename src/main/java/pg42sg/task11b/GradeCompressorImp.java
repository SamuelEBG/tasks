package pg42sg.task11b;

import org.pg4200.ex11.GradeCompressor;
import org.pg4200.les11.BitReader;
import org.pg4200.les11.BitWriter;

public class GradeCompressorImp implements GradeCompressor {

    @Override
    public byte[] compress(String idsAndGrades) {

        BitWriter writer = new BitWriter();
        // Variable that stores each charAt while going through the loop
        String id = "";

        for(int i = 0; i < idsAndGrades.length(); i++){
            // For each loop, store the character at the index
            // of the String(i). So every character in the String
            // are compressed.
            char c = idsAndGrades.charAt(i);
            /*
                While we iterate through the grades, we know that they will appear
                in the order of ID + GRADE e.g.
                Students ID = 129
                Students Grade = D
                will appear as 129D, so first we need to save the ID.
             */
            if(c >= '0' && c <= '9'){
                id += c;
            // When ID is stored in the ID variable, and we have iterated
            // through all the digits, we get to the grade, so no we check for
            // A-F instead of 0-9.
            } else if(c >= 'A' && c <= 'F'){
                // First we store the ID, since we have at most 500 students,
                // we need at most 9 (1024) bits to store the ID,
                writer.write(Integer.parseInt(id), 9);
                writer.write(c - 'A', 3);
                id = "";
            }
        }
        return writer.extract();
    }

    @Override
    public String decompress(byte[] data) {
        // Read the data (the array of bytes that we created in the compress method).
        BitReader reader = new BitReader(data);
        String result = "";
        /*
            How many entries are there in the data array?
            Since we stored each ID with 9 bits, and each grade with 3,
            we divide it by 12. But first we multiply by 8.
         */
        int entries = (data.length * 8) / 12;

        for(int i = 0; i < entries; i++){
            // Read the first input and convert it back, then the second.
            result += reader.readInt(9);
            result += (char) ('A' + reader.readInt(3));
        }
        return result;
    }
}
