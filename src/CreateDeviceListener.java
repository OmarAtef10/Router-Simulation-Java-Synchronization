import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class CreateDeviceListener implements MouseListener {
    JTextField deviceNameInput;
    JTextField deviceTypeInput;

    public CreateDeviceListener(JTextField dni, JTextField dti){
        deviceNameInput = dni;
        deviceTypeInput = dti;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        Device d = new Device(Network.semaphore, deviceNameInput.getText(), deviceTypeInput.getText());
        Network.deviceQueue.add(d);
        DefaultListModel <Device> model = new DefaultListModel();
        for (Device device : Network.deviceQueue){
            model.addElement(device);
        }
        Network.deviceQueueJList.setModel(model);
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
