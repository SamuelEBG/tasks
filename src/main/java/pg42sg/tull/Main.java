package pg42sg.tull;

public class Main {
    static long fact(int n){ // Enter a integer
        /*
            The algorithm is n! = { n*(n-1)! if n >= 1
                                 { 1 otherwise (if n=0)
         */
        if(n >= 1){ // If n is greater or equal to one
                    // it returns the value of the method called again but -1
                    // so for example f(4) -> 4 * f(3) and to find the first value
                    // it goes all the way down to f(0), which is 1.
                    // then we go back up again and add them together to figure out the answer.
                    /*
                    n! = n * (n-1)!
                    f(4) -> 4 * f(3) -> 4 * f(3)=24 - so f(4) is 24
                    f(3) -> 3 * f(2) -> 3 * f(2)=6 - so f(3) equals 6
                    f(2) -> 2 * f(1) -> 2 * f(1)=2 - so f(2) equals 2
                    f(1) -> 1 * f(0) -> 1 * f(0)=1 - so f(1) equals 1
                    f(0) -> 1 we reached the end     now we go back up
                     */
            return n * fact(n-1); // Recursive case
        }else{
            return 1; // Base case
        }
    }

    static int fib(int n){
        // assuming that n is a positive number, return the 2 previous ints added together.
        // fib seq 1, 1, 2, 3, 5, 8, 13, 21 etc
        // in case if fib(3) -> fib(2) + fib(1) = 1+1 since fib(n) -> n<3 will only return 1.
        /*
            We go all the way down to base case to figure out fib(2) and fib(1).
            Once we know that, we know what values to add, we add them into the first
            equation that was fib(3), now if we had a higher n value we would have to keep adding
            up until we reached what fib(n-1) + fib(n-2) would be.
            for example fib(4) is 3 in this case, which is the value of the 4th index in the
            fibonacci sequence.
         */
        if(n >= 3){
            return fib(n-1) + fib(n-2); // Recursive case
        }else{
            return 1; // Base case
        }
    }

    public static void main(String[] args){
        System.out.println(fact(10));
        System.out.println(fact(9));
        System.out.println(fact(8));
        System.out.println(fact(7));
        System.out.println(fib(6));
    }
}