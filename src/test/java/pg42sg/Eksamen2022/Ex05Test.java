package pg42sg.Eksamen2022;

import org.junit.jupiter.api.Test;
import org.pg4200.ex11.GradeCompressor;

import static org.junit.jupiter.api.Assertions.*;

class Ex05Test {

    protected Ex05 getNewInstance(){
        return new Ex05();
    }

    @Test
    void testLength(){

        Ex05 gc = getNewInstance();

        String data = "Programming-PG4200:456987:A / 2022-JUN-06. File: feedback-PG4200-456987.pdf;";

        byte[] compressed = gc.compress(data);
        String decompressed = gc.decompress(compressed);
        System.out.println(data);
        System.out.println(decompressed);
        assertEquals(data, decompressed);
    }

    @Test
    void testAI(){

        Ex05 gc = getNewInstance();

        String data = "ArtificialIntelligence-AI1701:987456:F / 2021-AUG-13. File: feedback-AI1701-987456.pdf;";

        byte[] compressed = gc.compress(data);
        String decompressed = gc.decompress(compressed);
        System.out.println(data.length());
        System.out.println(compressed.length);
        System.out.println(decompressed.length());
        assertEquals(data, decompressed);
    }

    @Test
    void testfrontEnd(){

        Ex05 gc = getNewInstance();

        String data = "FrontendProgramming-FP1453:963258:B / 2022-OCT-30. File: feedback-FP1453-963258.pdf;";

        byte[] compressed = gc.compress(data);
        String decompressed = gc.decompress(compressed);
        System.out.println(data.length());
        System.out.println(decompressed.length());
        assertEquals(data, decompressed);
    }

    @Test
    void testCybSec(){

        Ex05 gc = getNewInstance();

        String data = "Cybersecurity-SC1007:741654:C / 2022-JAN-05. File: feedback-SC1007-741654.pdf;";

        byte[] compressed = gc.compress(data);
        String decompressed = gc.decompress(compressed);
        System.out.println(data.length());
        System.out.println(decompressed.length());
        assertEquals(data, decompressed);
    }

    @Test
    void testDataScience(){

        Ex05 gc = getNewInstance();

        String data = "DataScience-DS0112:159753:D / 2020-MAR-08. File: feedback-DS0112-159753.pdf;";

        byte[] compressed = gc.compress(data);
        String decompressed = gc.decompress(compressed);
        System.out.println(data.length());
        System.out.println(decompressed.length());
        assertEquals(data, decompressed);
    }
}