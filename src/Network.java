import javax.swing.*;
import java.awt.*;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.Scanner;

public class Network {

    static JList deviceQueueJList;
    static ArrayList<Device> deviceQueue;
    static Semaphore semaphore;
    //TODO create input window for semaphore


    public static void main(String[] args) {
//        Scanner input = new Scanner(System.in);
//
//        System.out.println("What is the Maximum number of connections? ");
//        int connections_limits = input.nextInt();
//        Semaphore semaphore = new Semaphore(connections_limits);
//
//        Router router = new Router(semaphore);
//
//        int devices;
//        System.out.println("What is the number of devices you want to connect? ");
//        devices=input.nextInt();
//        for (int i = 0; i < devices; i++){
//            System.out.println("Enter name and type ");
//            Device d = new Device(semaphore,input.next(),input.next());
//            router.setConnectionsList(d);
//
//        }
//        router.connectToRouter();

        tempGUI();
    }

    public static void tempGUI(){
        //Setup Font
        Font f = new Font("serif", Font.PLAIN, 35);

        //Setup main window
        JFrame mainWindow = new JFrame();
        mainWindow.setSize(800, 600);
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
        addtoQueue.addMouseListener(new AddDeviceToQueueListener(f));
        addtoQueue.setFont(f);

        left.add(leftLabel);
        left.add(deviceQueueJList);
        left.add(addtoQueue);
        mainWindow.add(left);


        mainWindow.setVisible(true);
    }
}