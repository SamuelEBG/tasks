package pg42sg.task02;

public class Main {
    public static void main(String[] args){
        var arq = new MyRingArrayQueue<>();
        arq.enqueue(15);
        arq.enqueue(11);
        arq.enqueue(18);
        arq.enqueue(11);
        arq.enqueue(11);
        arq.enqueue(11);
        arq.enqueue(11);
        arq.enqueue(11);
        arq.enqueue(11);
        arq.enqueue(11);
        System.out.println(arq.size());

        arq.enqueue(11);
        System.out.println(arq.size());

        arq.enqueue(11);
        System.out.println(arq.size());
        System.out.println(arq.data.length);
    }
}
