package pg42sg.task11;

import org.junit.jupiter.api.Test;
import org.pg4200.les11.Huffman;
import org.pg4200.les11.TextCompressionTestTemplate;

import static org.junit.jupiter.api.Assertions.*;

class HuffmanIsoTest extends TextCompressionTestTemplate {

    protected double checkCompressAndDecompress(String text, String charset){
        return checkCompressAndDecompress(new HuffmanIso(), text, charset);
    }

    protected double checkCompressAndDecompressHuffman(String text, String charset){
        return checkCompressAndDecompress(new Huffman(), text, charset);
    }

    @Test
    void testCompareOnShortNorwegianSentence(){
        double ratio = checkCompressAndDecompress(
                "Jeg önsker å få en god karakter i denne eksamenen", "utf-8");
        assertTrue(ratio < 1);
    }

    @Test
    void testCompareOnShortNorwegianSentenceHuffman(){
        double ratio = checkCompressAndDecompressHuffman(
                "Jeg önsker å få en god karakter i denne eksamenen", "utf-8");
        assertTrue(ratio < 1);
    }

    @Test
    public void testSingleChar(){
        double ratio = checkCompressAndDecompress("a","utf-16");
        assertTrue(ratio > 1);
    }

    @Test
    public void testSingleWord(){
        double ratio = checkCompressAndDecompress("foo","utf-16");
        assertTrue(ratio > 1);
    }

    @Test
    public void testSentence(){
        double ratio = checkCompressAndDecompress(
                "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. ",
                "utf-16");

        assertTrue(ratio > 0.4);
        assertTrue(ratio < 0.5);
    }

    @Test
    public void testBook(){


        String text = getOdysseyText();

        /*
            Note: as the text in that file does not have special characters,
            its utf-16 representation is twice as long as the utf-8 one.
         */

        double ratio16 = checkCompressAndDecompress(text, "utf-16");

        assertTrue(ratio16 > 0.25);
        assertTrue(ratio16 < 0.3);

        double ratio8 = checkCompressAndDecompress(text, "utf-8");
        assertTrue(ratio8 < 0.6);
    }
}
