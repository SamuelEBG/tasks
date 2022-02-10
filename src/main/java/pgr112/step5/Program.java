package pgr112.step5;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.ArrayList;

public class Program {

    String path = "C:\\Users\\Garderobemannen\\IdeaProjects\\step5\\src\\main\\java\\pgr112\\step5\\opg4.txt";
    // This is a method for reading a file, create a new file with the path as
    // a parameter.
    // create a scanner that inputs the file, and read it with input.hasNextLine()
    // which will keep printing lines as long as there are lines in the txt file.
    // when printing is done it exits the program
    public void readFile() throws FileNotFoundException {
        File file = new File(path);
        Scanner input = new Scanner(file);

        while(input.hasNextLine()){  //after while-loop has gone through all lines in txt
            System.out.println(input.nextLine()); // it will exit and end the program.
        }
        System.out.println("Exiting program");
    }

    // instead of handling FileNotFoundExcpetions in the first method,
    // we use a throw and instead run the method from this method
    // that uses a try and catch, if the fileNotFoundException is triggered
    // it will be handled in this method instead.
    public static void fileReaderWithException(){
        Program reader = new Program();  //create obj of class program
        try{
            reader.readFile(); // call on method readFile with expection that throws
        }                       // back here if it isn't found.
        catch (FileNotFoundException skrivVadSomHelstHaer){
            System.out.println("Oh no, an exception!");
            System.out.println(skrivVadSomHelstHaer.getMessage());
        }
    }

    // ---------------------------File Writer

    // Same principal as the reading methods. First method is
    // creating a array, and together with scanner putting inputs
    // from the user into the array. Filename is stored within the method
    // because it is later used as a parameter when sent to the
    // writer. After array is filled.
    public static void fileWritingMethod(){
        Program fileWriter = new Program();
        String fileName = "src/main/java/pgr112/step5/opg5.txt";
        ArrayList<String> contentArray = new ArrayList<>();  // array
        Scanner input = new Scanner(System.in); // use scanner

        while(contentArray.size() <= 4){
            System.out.println("Type a word to add to the array"); //give user instructions
            contentArray.add(input.next()); // fill array with user inputs.
        }
        // try/catch, call the writeToFile method from Program with pre-set
        // parameters, path to filename and array with contents
        try{
            System.out.println("I am writing to file");
            fileWriter.writeToFile(fileName, contentArray);
        }
        // if you get a IO exception, for example try and mess with the file-path.
        // the writeToFile will have a "throw" back to this method, and you will
        // get an error.
        catch (IOException ioex){
            System.out.println("Not another exception..");
            ioex.printStackTrace();
        }
    }
    // Method that writes whatever is input in the array to a .txt file, notice parameters.
    //
    public void writeToFile(String filePath, ArrayList<String> contents) throws IOException{
        FileWriter writer = new FileWriter(filePath); //create a writer to a filepath.
        System.out.println("Writer stared");

        for(String line : contents){ // forloop that runs against contents of array.
            writer.write(line + "\n"); // print each content "line" to the .txt file
        }
        System.out.println("Done writing");
        writer.close(); //close writer when done
    }
}
