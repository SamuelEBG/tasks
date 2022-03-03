package pgr112.step4new;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

public class Program {
    private ArrayList<String> input;
    private Scanner scanner;

    public void runProgram(){
        System.out.println("Scanner starting");
        this.input = new ArrayList<>();
        scanner = new Scanner(System.in);
        System.out.println("Enter 3 words");

        for(int i = 0; i < 3;i++){
            input.add(scanner.next());
        }

        System.out.println("Here are your String");
        for(String s : input){
            System.out.println(s);
        }
    }

    public void addNumbers(){
        ArrayList<Integer> numbers = new ArrayList<>();
        scanner = new Scanner(System.in);
        boolean stop = false;
        System.out.println("Add numbers together, if you add a negative number, ya done goofed");
        while(!stop){
            int a = scanner.nextInt();
            if(a >= 0){
                numbers.add(a);
            } else{
                int result = 0;
                for(Integer i : numbers){
                    result += i;
                }
                stop = true;
                System.out.println(result);
            }
        }
    }
}
