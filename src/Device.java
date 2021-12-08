import javax.swing.*;
import java.io.IOException;
import java.util.Collections;
import java.util.Random;
import java.util.Timer;
import java.util.concurrent.TimeUnit;

public class Device implements Runnable {

    private String deviceName;
    private String type;
    private Router router;

    public Device(String deviceName, String type) {
        this.deviceName = deviceName;
        this.type = type;
        this.router = null;
    }

    public void setRouter(Router router){
        this.router = router;
    }

    @Override
    public String toString() {
        return "(" + deviceName + ") " + "(" + type + ") ";
    }


    public boolean equals(Device obj) {
        return deviceName.equals(obj.deviceName) && type.equals(obj.type);
    }

    public void Connect() throws IOException {
        System.out.println(this.deviceName + " Connected");
        router.writeLogs(this.deviceName+" Connected\n");
    }

    public void PerformActivity() {
        System.out.println(this.deviceName + " Performing Online Activity");
        try {
            Random random = new Random();
            int r_num = random.nextInt(4);
            TimeUnit.SECONDS.sleep(r_num);
        } catch (InterruptedException e) { }
    }

    public void Logout() throws IOException {
        router.getSemaphore().Signal();
        System.out.println(this.toString() + " Logged Out");
        router.writeLogs(this.toString()+" Logged out!\n");
    }

    @Override
    public void run() {
        try {
            Connect();
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
        PerformActivity();
        try {
            Logout();
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }

}