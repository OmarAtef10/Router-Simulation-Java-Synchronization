import java.io.IOException;
import java.util.Scanner;

public class Network {
    public static void main(String[] args) throws IOException {
        Scanner input = new Scanner(System.in);

        System.out.println("What is the Maximum number of connections? ");
        int connections_limits = input.nextInt();
        Semaphore semaphore = new Semaphore(connections_limits);

        Router router = new Router(semaphore);

        int devices;
        System.out.println("What is the number of devices you want to connect? ");
        devices=input.nextInt();
        for (int i = 0; i < devices; i++){
            System.out.println("Enter name and type ");
            Device d = new Device(input.next(),input.next());
            router.setConnectionsList(d);

        }
        router.connectToRouter();
    }
}