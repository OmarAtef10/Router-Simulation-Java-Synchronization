import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class AddDeviceToQueueEvent implements MouseListener {
    Font font;
    JFrame parent;

    public AddDeviceToQueueEvent(Font f, JFrame p){
        this.font = f;
        this.parent = p;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        //Setup main window
        JFrame inputWindow = new JFrame("Add a Device");
        inputWindow.setFont(this.font);
        inputWindow.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        inputWindow.setSize(400, 300);
        inputWindow.setLayout(new GridLayout(4, 1));


        //Setup First Panel
        JPanel first = new JPanel();
        first.setLayout(new GridLayout(1, 2));

        JLabel lbl = new JLabel("Device Name");
        lbl.setHorizontalAlignment(JLabel.CENTER);
        lbl.setFont(this.font);

        JTextField deviceNameInput = new JTextField();
        deviceNameInput.setFont(this.font);

        first.add(lbl);
        first.add(deviceNameInput);
        inputWindow.add(first);


        //Setup Second Panel
        JPanel second = new JPanel();
        second.setLayout(new GridLayout(1, 2));

        lbl = new JLabel("Device type");
        lbl.setHorizontalAlignment(JLabel.CENTER);
        lbl.setFont(this.font);

        JTextField deviceTypeInput = new JTextField();
        deviceTypeInput.setFont(this.font);

        second.add(lbl);
        second.add(deviceTypeInput);
        inputWindow.add(second);

        //Setup Last Panel
        JPanel last = new JPanel();

        JButton addDeviceButton = new JButton("Add Device");
        addDeviceButton.addMouseListener(new CreateDeviceEvent(deviceNameInput, deviceTypeInput, inputWindow));

        last.add(addDeviceButton);
        inputWindow.add(last);

        //Initialize main window
        inputWindow.setVisible(true);
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
