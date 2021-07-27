import java.util.Scanner;

public class Analyzer {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Welcome to the Elevator simulator! \n");
        System.out.print("Please enter the probability of arrival for Requests: ");
        double prob = input.nextDouble();
        System.out.print("Please enter the number of floors: ");
        int numFloors = input.nextInt();
        System.out.print("Please enter the number of elevators: ");
        int numElevators = input.nextInt();
        System.out.print("Please enter the length of the simulation (in time units):");
        int time = input.nextInt();
        Simulator.Simulate(prob, numFloors, numElevators, time);
    }
}
