import java.util.List;

public class Semaphore {
    private int counter;
    private List<Device> deviceList;

    public Semaphore(){
        counter = 0;
    }

    public Semaphore(int counter){
        this.counter = counter;
    }

    public void Wait(){}
    public void Signal(){ }
    public void Block(){}
    public void Wakeup(){}

}
