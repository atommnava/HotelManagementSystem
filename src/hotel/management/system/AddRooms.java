package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddRooms extends JFrame implements ActionListener {
    JButton add, cancel;
    JTextField tRoom, tPrice;
    JComboBox cleanCombo, typeCombo, availableCombo;
    AddRooms(){
        super("Add Rooms");
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JLabel heading = new JLabel("Add Rooms:");
        heading.setFont(new Font("Tahoma", Font.BOLD, 18));
        heading.setBounds(150,20,200,20);
        add(heading);

        JLabel roomNo = new JLabel("Room No:");
        roomNo.setFont(new Font("Tahoma", Font.BOLD, 18));
        roomNo.setBounds(60,80,120,30);
        add(roomNo);

        tRoom = new JTextField();
        tRoom.setBounds(200,80,150,30);
        add(tRoom);

        JLabel available = new JLabel("Available:");
        available.setFont(new Font("Tahoma", Font.BOLD, 18));
        available.setBounds(60,130,120,30);
        add(available);

        String availableOptions[] = {"Available", "Occupied"};
        availableCombo = new JComboBox(availableOptions);
        availableCombo.setBounds(200,130,150,30);
        availableCombo.setBackground(Color.WHITE);
        add(availableCombo);

        JLabel clean = new JLabel("Cleaning Status:");
        clean.setFont(new Font("Tahoma", Font.BOLD, 18));
        clean.setBounds(60,180,120,30);
        add(clean);

        String cleanOptions[] = {"Cleaned", "Dirty"};
        cleanCombo = new JComboBox(cleanOptions);
        cleanCombo.setBounds(200,180,150,30);
        cleanCombo.setBackground(Color.WHITE);
        add(cleanCombo);

        JLabel price = new JLabel("Price:");
        price.setFont(new Font("Tahoma", Font.BOLD, 18));
        price.setBounds(60,230,120,30);
        add(price);

        tPrice = new JTextField();
        tPrice.setBounds(200,230,150,30);
        add(tPrice);

        JLabel type = new JLabel("Bed Type:");
        type.setFont(new Font("Tahoma", Font.BOLD, 18));
        type.setBounds(60,280,120,30);
        add(type);

        String typeOptions[] = {"Single Bed", "Double Bed"};
        typeCombo = new JComboBox(typeOptions);
        typeCombo.setBounds(200,280,150,30);
        typeCombo.setBackground(Color.WHITE);
        add(typeCombo);

        add = new JButton("Add Room");
        add.setForeground(Color.BLACK);
        add.setBackground(Color.WHITE);
        add.setBounds(60,350,130,30);
        add.addActionListener(this);
        add(add);

        cancel = new JButton("Cancel");
        cancel.setForeground(Color.RED);
        cancel.setBackground(Color.WHITE);
        cancel.setBounds(220,350,130,30);
        cancel.addActionListener(this);
        add(cancel);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons-hotel/twelve.jpg"));
        JLabel image = new JLabel(i1);
        image.setBounds(400,30,500,300);
        add(image);

        setBounds(330,200,940,470);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == add) {
            String tfRoom = tRoom.getText();
            String tfAvailability = (String)availableCombo.getSelectedItem();
            String tfCleaned = (String)cleanCombo.getSelectedItem();
            String tfPrice = tPrice.getText();
            String tfType = (String)typeCombo.getSelectedItem();
            try {
                Conn conn = new Conn();
                String query = "insert into room values('" + tfRoom + "', '" + tfAvailability + "', '" + tfCleaned + "', '" + tfPrice + "', '" + tfType + "')";
                conn.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Room Added Successfully");
                setVisible(false);
            } catch (Exception e1) {
                e1.printStackTrace();
            }
        } else {
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new AddRooms();
    }
}
