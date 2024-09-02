package hotel.management.system;

import javax.swing.*;
import java.awt.*;

public class Databoard extends JFrame {

    Databoard()
    {
        setBounds(0,0,1550,1000);
        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons-hotel/third.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1550,1000, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,1550,1000);
        add(image);

        JLabel text = new JLabel("THE TAJ GRUOP WELCOMES YOU");
        text.setBounds(400,80,1000,50);
        text.setFont(new Font("Tahoma", Font.PLAIN, 46));
        text.setForeground(Color.WHITE);
        image.add(text);

        JMenuBar menuBar = new JMenuBar();
        menuBar.setBounds(0,0,1550,30);
        image.add(menuBar);

        JMenu hotel = new JMenu("HOTEL MANAGEMENT");
        hotel.setForeground(Color.RED);
        menuBar.add(hotel);

        JMenuItem reception = new JMenuItem("RECEPTION");
        hotel.add(reception);

        JMenu admin = new JMenu("ADMIN");
        admin.setForeground(Color.BLUE);
        menuBar.add(admin);

        JMenuItem addEmployee = new JMenuItem("ADD EMPLOYEE");
        admin.add(addEmployee);

        JMenuItem addRoom = new JMenuItem("ADD ROOM");
        admin.add(addRoom);

        JMenuItem addDriver = new JMenuItem("ADD DRIVER");
        admin.add(addDriver);

        setVisible(true);
    }
    public static void main(String[] args) {
        new Databoard();
    }
}
