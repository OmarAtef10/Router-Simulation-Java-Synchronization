import javax.swing.*;
import java.util.Collections;
import java.util.Random;
import java.util.Timer;
import java.util.concurrent.TimeUnit;

public class Device implements Runnable {

    private String deviceName;
    private String type;
    private Semaphore semaphore;

    public Device(Semaphore semaphore, String deviceName, String type) {
        this.semaphore = semaphore;
        this.deviceName = deviceName;
        this.type = type;
    }

    public Device(Device device) {
        deviceName = device.deviceName;
        ;
        type = device.type;
        semaphore = device.semaphore;
    }

    public Semaphore getSemaphore() {
        return semaphore;
    }

    @Override
    public String toString() {
        return "(" + deviceName + ") " + "(" + type + ") ";
    }


    public boolean equals(Device obj) {
        return deviceName.equals(obj.deviceName) && type.equals(obj.type);
    }

    public void Connect() {
        System.out.println(this.deviceName + " Connected");
    }

    public void PerformActivity() {
        System.out.println(this.deviceName + " Performing Online Activity");
    }

    public void Logout() {
        System.out.println(this.toString() + " Logged Out");
    }

    @Override
    public void run() {
       // semaphore.Wait();

        /*for (int i = 0; i < InterfaceCreator.deviceQueue.size(); i++){
            Device d = new Device(InterfaceCreator.deviceQueue.get(i));
            if (equals(d)){
                InterfaceCreator.deviceQueue.remove(i);
                DefaultListModel<Device> model = new DefaultListModel<>();
                for (Device device : InterfaceCreator.deviceQueue){
                    model.addElement(device);
                }
                InterfaceCreator.deviceQueueJList.setModel(model);

                DefaultListModel <Device> connectedModel = new DefaultListModel<>();
                for (int j = 0; j < InterfaceCreator.currentlyConnectedJList.getModel().getSize(); j++){
                    connectedModel.addElement((Device) InterfaceCreator.currentlyConnectedJList.getModel().getElementAt(i));
                }
                connectedModel.addElement(d);
                InterfaceCreator.currentlyConnectedJList.setModel(connectedModel);
                break;
            }
        }*/
        Connect();
        PerformActivity();
        try {
            Random random = new Random();
            int r_num = random.nextInt(4);
            TimeUnit.SECONDS.sleep(r_num);
        } catch (InterruptedException e) {
        }
        Logout();
        semaphore.Signal();

        /*DefaultListModel <Device> connectedModel = new DefaultListModel<>();
        for (int j = 0; j < InterfaceCreator.currentlyConnectedJList.getModel().getSize(); j++){
            if (!equals((Device) InterfaceCreator.currentlyConnectedJList.getModel().getElementAt(j))){
                connectedModel.addElement((Device) InterfaceCreator.currentlyConnectedJList.getModel().getElementAt(j));
            }
            InterfaceCreator.currentlyConnectedJList.setModel(connectedModel);
        }*/

    }
}