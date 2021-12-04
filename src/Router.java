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
        for (int i = 0; i < connections.size(); ) {
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

            releaseConnection(d);

        }
    }

    public void setConnectionsList(Device device) {
        this.connections.add(device);
    }

    public void releaseConnection(Device d) {
        connections.remove(d);
    }
}