import java.util.ArrayList;
import java.util.List;

public class Router {
    private List<Device> connections;
    private Semaphore semaphore;


    public Router(Semaphore semaphore) {
        connections = new ArrayList<>();
        this.semaphore = semaphore;
    }

    public void connectToRouter() {
        int counter = semaphore.getCounter();
        while (connections.size() != 0) {
            Device d = connections.get(0);
            if (counter > 0) {
                System.out.println(d.toString() + " Arrived");
                counter--;
            } else {
                System.out.println(d.toString() + " Arrived and Waiting");
                counter--;
            }

            connect(d);


        }
    }

    public void setConnectionsList(Device device) {
        this.connections.add(device);
    }

    public void setConnectionsList(List<Device> devices) {
        this.connections = devices;
    }

    public void connect(Device d) {
        Thread thread = new Thread(d);
        semaphore.Wait();
        thread.start();

        releaseConnection();
    }

    public void releaseConnection() {
        connections.remove(0);
    }
}