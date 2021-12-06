import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Arrays;

public class StartSimulationEvent implements MouseListener {


    @Override
    public void mouseClicked(MouseEvent e) {
        InterfaceCreator.semaphore.setCounter(Integer.parseInt(InterfaceCreator.numberOfDevicesInput.getText()));
        Router router = new Router(InterfaceCreator.semaphore);
        for (Device d : InterfaceCreator.deviceQueue){
            router.setConnectionsList(d);
        }
        router.connectToRouter();
    }



    @Override
    public void mousePressed(MouseEvent e) {    }
    @Override
    public void mouseReleased(MouseEvent e) {    }
    @Override
    public void mouseEntered(MouseEvent e) {    }
    @Override
    public void mouseExited(MouseEvent e) {    }
}
