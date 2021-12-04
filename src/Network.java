import java.util.Scanner;

public class Network {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("What is the number of connections: ");
        int connections_limits = input.nextInt();
        Semaphore semaphore = new Semaphore(connections_limits);

        System.out.println();



        Device device1 = new Device(semaphore," ");
        Thread t1 = new Thread(device1);

        t1.start();

    }
}
