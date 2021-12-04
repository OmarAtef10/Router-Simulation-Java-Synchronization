import java.util.Timer;
import java.util.concurrent.TimeUnit;

public class Device implements Runnable{

    private String deviceName;
    private String type;
    private Semaphore semaphore;

    public Device(Semaphore semaphore, String deviceName, String type){
        this.semaphore=semaphore;
        this.deviceName = deviceName;
        this.type=type;
    }

    @Override
    public String toString() {
        return "(" +deviceName +") " + "(" + type + ") ";

    }

    @Override
    public void run() {
        semaphore.Wait();
        System.out.println( deviceName +" Connected");
        System.out.println(deviceName + " Performing Online Activity");

        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
        }
        System.out.println(this.toString()+" Logged Out");
        semaphore.Signal();
    }
}
