import java.util.Scanner;

public class Main {
    RequestQueue queue;
    BooleanSource test;
    public Main() {
        queue = new RequestQueue();
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a probability: ");
        test = new BooleanSource(input.nextDouble());
    }
    public static void main(String[] args) {
        Main elevator = new Main();
        for(int i = 0; i < 10; i++) {
            Request obj = new Request(90);
            System.out.println(obj.toString());
            elevator.getRequestQueue().enqueue(obj);
        }
        System.out.println("------------");
        System.out.println(elevator.queue.dequeue().toString());
        System.out.println(elevator.queue.toString());
        System.out.println(elevator.queue.dequeue().toString());
        System.out.println(elevator.queue.toString());
    }

    public RequestQueue getRequestQueue() {
        return queue;
    }
}
