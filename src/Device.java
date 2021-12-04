public class Device implements Runnable{
    private Semaphore s;
    private String deviceName;
    public Device(Semaphore s,String deviceName){
        this.s = s;
        this.deviceName = deviceName;
    }
    @Override
    public void run() {

    }
}
