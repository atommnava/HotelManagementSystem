package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddDriver extends JFrame implements ActionListener {
    JButton add, cancel;
    JTextField tName, tAge, tCompany, tModel, tLocation;
    JComboBox genderCombo, typeCombo, availableCombo;
    AddDriver(){
        super("Add Drivers");
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JLabel heading = new JLabel("Add Drivers:");
        heading.setFont(new Font("Tahoma", Font.BOLD, 18));
        heading.setBounds(150,10,200,20);
        add(heading);

        JLabel roomNo = new JLabel("Name:");
        roomNo.setFont(new Font("Tahoma", Font.BOLD, 18));
        roomNo.setBounds(60,70,120,30);
        add(roomNo);

        tName = new JTextField();
        tName.setBounds(200,80,150,30);
        add(tName);

        JLabel labelAge = new JLabel("Age:");
        labelAge.setFont(new Font("Tahoma", Font.BOLD, 18));
        labelAge.setBounds(60,110,120,30);
        add(labelAge);

        tAge = new JTextField();
        tAge.setBounds(200,110,150,30);
        add(tAge);

        JLabel clean = new JLabel("Gender:");
        clean.setFont(new Font("Tahoma", Font.BOLD, 18));
        clean.setBounds(60,150,120,30);
        add(clean);

        String cleanOptions[] = {"Male", "Female"};
        genderCombo = new JComboBox(cleanOptions);
        genderCombo.setBounds(200,150,150,30);
        genderCombo.setBackground(Color.WHITE);
        add(genderCombo);

        JLabel price = new JLabel("Company:");
        price.setFont(new Font("Tahoma", Font.BOLD, 18));
        price.setBounds(60,190,120,30);
        add(price);

        tCompany = new JTextField();
        tCompany.setBounds(200,190,150,30);
        add(tCompany);

        JLabel type = new JLabel("Car Model:");
        type.setFont(new Font("Tahoma", Font.BOLD, 18));
        type.setBounds(60,230,120,30);
        add(type);

        tModel = new JTextField();
        tModel.setBounds(200,230,150,30);
        add(tModel);

        JLabel labelAvailable = new JLabel("Available:");
        labelAvailable.setFont(new Font("Tahoma", Font.BOLD, 18));
        labelAvailable.setBounds(60,270,120,30);
        add(labelAvailable);

        String driverOptions[] = {"Available", "Occupied"};
        availableCombo = new JComboBox(driverOptions);
        availableCombo.setBounds(200,270,150,30);
        availableCombo.setBackground(Color.WHITE);
        add(availableCombo);

        JLabel labelLocation = new JLabel("Location:");
        labelLocation.setFont(new Font("Tahoma", Font.BOLD, 18));
        labelLocation.setBounds(60,310,120,30);
        add(labelLocation);

        tLocation = new JTextField();
        tLocation.setBounds(200,310,150,30);
        add(tLocation);

        add = new JButton("Add Driver");
        add.setForeground(Color.BLACK);
        add.setBackground(Color.WHITE);
        add.setBounds(60,370,130,30);
        add.addActionListener(this);
        add(add);

        cancel = new JButton("Cancel");
        cancel.setForeground(Color.RED);
        cancel.setBackground(Color.WHITE);
        cancel.setBounds(220,370,130,30);
        cancel.addActionListener(this);
        add(cancel);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons-hotel/eleven.jpg"));
        Image i2 = i1.getImage().getScaledInstance(120, 120, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i1);
        image.setBounds(400,30,500,300);
        add(image);

        setBounds(300,200,980,470);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == add) {
            String toName = tName.getText();
            String toAge = tAge.getText();
            String toGender = (String)genderCombo.getSelectedItem();
            String toCompany = tCompany.getText();
            String toModel = tModel.getText();
            String toAvailable = (String)availableCombo.getSelectedItem();
            String toLocation = tLocation.getText();
            try {
                Conn conn = new Conn();
                String query = "insert into driver values('" + toName + "', '" + toAge + "', '" + toGender + "', '" + toCompany + "', '" + toModel + "'" +
                        ", '" + toAvailable + "', '" + toLocation + "')";
                conn.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "New Driver added Successfully");
                setVisible(false);
            } catch (Exception e1) {
                e1.printStackTrace();
            }
        } else {
            setVisible(false);
        }

    }
    public static void main(String[] args) {
        new AddDriver();
    }
}
