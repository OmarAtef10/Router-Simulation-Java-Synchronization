import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class InterfaceCreator {
    static JList deviceQueueJList;
    static ArrayList<Device> deviceQueue;
    static Semaphore semaphore;
    static JList currentlyConnectedJList;
    static JTextField numberOfDevicesInput;

    public static void create(){
        //Setup Font
        Font f = new Font("serif", Font.PLAIN, 35);

        //Setup main window
        JFrame mainWindow = new JFrame();
        mainWindow.setSize(1365, 720);
        mainWindow.setTitle("Network Simulation app");
        mainWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainWindow.setLayout(new GridLayout(1, 3));
        mainWindow.setFont(f);

        //Left most panel
        JPanel left = new JPanel();
        left.setLayout(new GridLayout(3, 1));

        JLabel leftLabel = new JLabel("Device Queue");
        leftLabel.setHorizontalAlignment(JLabel.CENTER);
        leftLabel.setFont(f);

        deviceQueueJList = new JList();
        deviceQueue = new ArrayList<>();


        JButton addtoQueue = new JButton("Add device to Queue");
        addtoQueue.addMouseListener(new AddDeviceToQueueEvent(f, mainWindow));
        addtoQueue.setFont(f);

        left.add(leftLabel);
        left.add(deviceQueueJList);
        left.add(addtoQueue);
        mainWindow.add(left);


        // Center Panel
        JPanel center = new JPanel();
        center.setLayout(new GridLayout(2, 1));


        JLabel centerLabel = new JLabel("Connected Devices");
        centerLabel.setHorizontalAlignment(JLabel.CENTER);
        centerLabel.setFont(f);

        currentlyConnectedJList = new JList();

        center.add(centerLabel);
        center.add(currentlyConnectedJList);
        mainWindow.add(center);


        //Right Panel
        JPanel right = new JPanel();
        right.setLayout(new GridLayout(3, 1));

        JLabel rightLabel = new JLabel("Number of devices to connect at a time");
        rightLabel.setHorizontalAlignment(JLabel.CENTER);
        rightLabel.setFont(f);

        numberOfDevicesInput = new JTextField();
        numberOfDevicesInput.setFont(f);

        JButton startSimulation = new JButton("Start Simulation");
        startSimulation.setFont(f);
        startSimulation.addMouseListener(new StartSimulationEvent());


        right.add(rightLabel);
        right.add(numberOfDevicesInput);
        right.add(startSimulation);
        mainWindow.add(right);

        mainWindow.setVisible(true);
    }
}
