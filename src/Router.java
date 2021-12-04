import java.util.ArrayList;
import java.util.List;

public class Router {
    private List<Device> connections;


    public Router() {
        connections = new ArrayList<>();

    }

    public void connectToRouter() {

        for (int i = 0; i<connections.size();) {
            Device d = connections.get(0);
            Thread thread = new Thread(d);
            System.out.println(d.toString() + " Arrived");

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
