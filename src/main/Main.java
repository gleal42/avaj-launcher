package main;
import simulator.Simulator;

public class Main {
    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Wrong number of arguments");
            System.exit(1);
        }
        Simulator simulator = new Simulator(args[0]);
        simulator.run();
    }
}
