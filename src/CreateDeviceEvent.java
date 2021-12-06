import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class CreateDeviceEvent implements MouseListener {
    JTextField deviceNameInput;
    JTextField deviceTypeInput;
    JFrame parent;

    public CreateDeviceEvent(JTextField dni, JTextField dti, JFrame p){
        deviceNameInput = dni;
        deviceTypeInput = dti;
        parent = p;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        Device d = new Device(InterfaceCreator.semaphore, deviceNameInput.getText(), deviceTypeInput.getText());
        InterfaceCreator.deviceQueue.add(d);
        DefaultListModel <Device> model = new DefaultListModel<>();
        for (Device device : InterfaceCreator.deviceQueue){
            model.addElement(device);
        }
        InterfaceCreator.deviceQueueJList.setModel(model);
        parent.dispose();
    }

    @Override
    public void mousePressed(MouseEvent e) { }
    @Override
    public void mouseReleased(MouseEvent e) { }
    @Override
    public void mouseEntered(MouseEvent e) { }
    @Override
    public void mouseExited(MouseEvent e) { }
}
