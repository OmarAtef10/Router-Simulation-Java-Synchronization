import java.util.ArrayList;
import java.util.List;

public class Router {
    private List<Device> connections;
    Semaphore semaphore;


    public Router(Semaphore semaphore) {
        connections = new ArrayList<>();
        this.semaphore = semaphore;
    }

    public void connectToRouter() {
        int counter = semaphore.counter;
        while (connections.size()!=0) {
            Device d = connections.get(0);
            Thread thread = new Thread(d);

            if (counter > 0) {
                System.out.println(d.toString() + " Arrived");
                counter--;
            } else {
                System.out.println(d.toString() + " Arrived and Waiting");
                counter--;
            }

            thread.start();

            releaseConnection();

        }
    }

    public void setConnectionsList(Device device) {
        this.connections.add(device);
    }

    public void releaseConnection() {
        if(connections.size()!=0) {
            connections.remove(0);
        }
    }

}