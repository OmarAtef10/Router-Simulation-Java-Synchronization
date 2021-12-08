import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Router {
    private List<Device> connections;
    private Semaphore semaphore;


    public Router(Semaphore semaphore) {
        connections = new ArrayList<>();
        this.semaphore = semaphore;
    }

    public void connectToRouter() throws IOException {
        File file = new File("log.txt");
        if(file.exists()){
            file.delete();
        }

        int counter = Semaphore.counter;

        while (connections.size() != 0) {
            Device d = connections.get(0);
            d.setRouter(this);
            if (counter > 0) {
                writeLogs(d.toString() + " Arrived\n");
                System.out.println(d.toString() + " Arrived");
                counter--;
            } else {
                writeLogs(d.toString() + " Arrived and Waiting\n");
                System.out.println(d.toString() + " Arrived and Waiting");
                counter--;
            }
            connect(d);
        }
    }

    public Semaphore getSemaphore(){
        return this.semaphore;
    }

    public void setConnectionsList(Device device) {
        this.connections.add(device);
    }

    public void setConnectionsList(List<Device> devices) {
        this.connections = devices;
    }

    public void connect(Device d) throws IOException {
        Thread thread = new Thread(d);
        semaphore.Wait();
        writeLogs(connections.get(0).toString()+" Performing Activity\n");
        thread.start();

        releaseConnection();
    }

    public void releaseConnection() throws IOException {
        connections.remove(0);
    }

    public void writeLogs(String activity) throws IOException {
        FileWriter file = new FileWriter("log.txt",true);
        file.write(activity);
        file.close();
    }
}