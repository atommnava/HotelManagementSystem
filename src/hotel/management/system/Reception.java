package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Reception extends JFrame implements ActionListener {
    JButton add;
    Reception(){
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        add = new JButton("New Customer Form");
        add.setBounds(10,30,200,30);
        add.setForeground(Color.BLACK);
        add.setBackground(Color.WHITE);
        add.addActionListener(this);
        add(add);

        JButton roomNo = new JButton("Department");
        roomNo.setBounds(10,70,200,30);
        roomNo.setForeground(Color.BLACK);
        roomNo.setBackground(Color.WHITE);
        add(roomNo);

        JButton department = new JButton("All Employees");
        department.setBounds(10,110,200,30);
        department.setForeground(Color.BLACK);
        department.setBackground(Color.WHITE);
        add(department);

        JButton allEmployee = new JButton("Customer Info");
        allEmployee.setBounds(10,150,200,30);
        allEmployee.setForeground(Color.BLACK);
        allEmployee.setBackground(Color.WHITE);
        add(allEmployee);

        JButton customers = new JButton("New Customer");
        customers.setBounds(10,190,200,30);
        customers.setForeground(Color.BLACK);
        customers.setBackground(Color.WHITE);
        add(customers);

        JButton managerInfo = new JButton("Manager Info");
        managerInfo.setBounds(10,230,200,30);
        managerInfo.setForeground(Color.BLACK);
        managerInfo.setBackground(Color.WHITE);
        add(managerInfo);

        JButton checkOut = new JButton("Checkout");
        checkOut.setBounds(10,270,200,30);
        checkOut.setForeground(Color.BLACK);
        checkOut.setBackground(Color.WHITE);
        add(checkOut);

        JButton update = new JButton("Update Status");
        update.setBounds(10,310,200,30);
        update.setForeground(Color.BLACK);
        update.setBackground(Color.WHITE);
        add(update);

        JButton updateRoom = new JButton("Update Room Status");
        updateRoom.setBounds(10,350,200,30);
        updateRoom.setForeground(Color.BLACK);
        updateRoom.setBackground(Color.WHITE);
        add(updateRoom);

        JButton pickUp = new JButton("Pickup Service");
        pickUp.setBounds(10,390,200,30);
        pickUp.setForeground(Color.BLACK);
        pickUp.setBackground(Color.WHITE);
        add(pickUp);

        JButton search = new JButton("Search Room");
        search.setBounds(10,430,200,30);
        search.setForeground(Color.BLACK);
        search.setBackground(Color.WHITE);
        add(search);

        JButton logout = new JButton("Search Room");
        logout.setBounds(10,470,200,30);
        logout.setForeground(Color.BLACK);
        logout.setBackground(Color.WHITE);
        add(logout);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons-hotel/fourth.jpg"));
        JLabel image = new JLabel(i1);
        image.setBounds(250,30,500,470);
        add(image);

        setBounds(350,200,800,570);
        setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == add) {
            setVisible(false);
            new AddCustomer();
        }
    }

    public static void main(String[] args) {
        new Reception();
    }
}
