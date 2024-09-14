package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Reception extends JFrame implements ActionListener {
    JButton add, roomNo, department, allEmployee, customers, managerInfo, search, pickUp, update, updateRoom;
    public Reception(){
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        add = new JButton("New Customer Form");
        add.setBounds(10,30,200,30);
        add.setForeground(Color.BLACK);
        add.setBackground(Color.WHITE);
        add.addActionListener(this);
        add(add);

        roomNo = new JButton("Rooms");
        roomNo.setBounds(10,70,200,30);
        roomNo.setForeground(Color.BLACK);
        roomNo.setBackground(Color.WHITE);
        roomNo.addActionListener(this);
        add(roomNo);

        department = new JButton("Department");
        department.setBounds(10,110,200,30);
        department.setForeground(Color.BLACK);
        department.setBackground(Color.WHITE);
        department.addActionListener(this);
        add(department);

        allEmployee = new JButton("Employee Info");
        allEmployee.setBounds(10,150,200,30);
        allEmployee.setForeground(Color.BLACK);
        allEmployee.setBackground(Color.WHITE);
        allEmployee.addActionListener(this);
        add(allEmployee);

        customers = new JButton("Customer Info");
        customers.setBounds(10,190,200,30);
        customers.setForeground(Color.BLACK);
        customers.setBackground(Color.WHITE);
        customers.addActionListener(this);
        add(customers);

        managerInfo = new JButton("Manager Info");
        managerInfo.setBounds(10,230,200,30);
        managerInfo.setForeground(Color.BLACK);
        managerInfo.setBackground(Color.WHITE);
        managerInfo.addActionListener(this);
        add(managerInfo);

        JButton checkOut = new JButton("Checkout");
        checkOut.setBounds(10,270,200,30);
        checkOut.setForeground(Color.BLACK);
        checkOut.setBackground(Color.WHITE);
        checkOut.addActionListener(this);
        add(checkOut);

        update = new JButton("Update Status");
        update.setBounds(10,310,200,30);
        update.setForeground(Color.BLACK);
        update.setBackground(Color.WHITE);
        update.addActionListener(this);
        add(update);

        updateRoom = new JButton("Update Room Status");
        updateRoom.setBounds(10,350,200,30);
        updateRoom.setForeground(Color.BLACK);
        updateRoom.setBackground(Color.WHITE);
        updateRoom.addActionListener(this);
        add(updateRoom);

        pickUp = new JButton("Pickup Service");
        pickUp.setBounds(10,390,200,30);
        pickUp.setForeground(Color.BLACK);
        pickUp.setBackground(Color.WHITE);
        pickUp.addActionListener(this);
        add(pickUp);

        search = new JButton("Search Room");
        search.setBounds(10,430,200,30);
        search.setForeground(Color.BLACK);
        search.setBackground(Color.WHITE);
        search.addActionListener(this);
        add(search);

        JButton logout = new JButton("Logout");
        logout.setBounds(10,470,200,30);
        logout.setForeground(Color.BLUE);
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
        } else if (e.getSource() == roomNo) {
            setVisible(false);
            new Room();
        } else if (e.getSource() == department) {
            setVisible(false);
            new Department();
        } else if (e.getSource() == allEmployee) {
            setVisible(false);
            new EmployeeInfo();
        } else if (e.getSource() == customers) {
            setVisible(false);
            new CustomerInfo();
        } else if (e.getSource() == managerInfo) {
            setVisible(false);
            new ManagerInfo();
        } else if (e.getSource() == search) {
            setVisible(false);
            new SearchRoom();
        } else if (e.getSource() == update) {
            setVisible(false);
            new UpdateCheck();
        } else if (e.getSource() == updateRoom) {
            setVisible(false);
            new UpdateRoom();
        } else if (e.getSource() == pickUp) {
            setVisible(false);
            new PickUp();
        }
    }
    public static void main(String[] args) {
        new Reception();
    }
}
