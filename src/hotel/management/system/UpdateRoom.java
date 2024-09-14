package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class UpdateRoom extends JFrame implements ActionListener {
    JTextField tfRoom, tfAvailability, tfStatus, tfDeposit, tfPending;
    Choice cCustomer;
    JButton check, update, back;
    public UpdateRoom() {
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JLabel text = new JLabel("Update Room Status");
        text.setFont(new Font("Tahoma", Font.PLAIN, 20));
        text.setBounds(30,20,250,30);
        text.setForeground(Color.BLUE);
        add(text);

        JLabel lblId = new JLabel("Customer ID");
        lblId.setBounds(30,80,100,20);
        add(lblId);

        cCustomer = new Choice();
        cCustomer.setBounds(200,80,150,25);
        add(cCustomer);

        try {
            Conn conn = new Conn();
            ResultSet rs = conn.s.executeQuery("select * from customer");
            while (rs.next()) {
                cCustomer.add(rs.getString("number"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        JLabel lblRoom = new JLabel("Room Number");
        lblRoom.setBounds(30,130,100,20);
        add(lblRoom);

        tfRoom = new JTextField();
        tfRoom.setBounds(200,130,150,25);
        add(tfRoom);

        JLabel lblName = new JLabel("Availability");
        lblName.setBounds(30,180,100,20);
        add(lblName);

        tfAvailability = new JTextField();
        tfAvailability.setBounds(200,180,150,25);
        add(tfAvailability);

        JLabel lblCheckin = new JLabel("Cleaning Status");
        lblCheckin.setBounds(30,230,100,20);
        add(lblCheckin);

        tfStatus = new JTextField();
        tfStatus.setBounds(200,230,150,25);
        add(tfStatus);

        check = new JButton("Check");
        check.setBackground(Color.white);
        check.setForeground(Color.black);
        check.setBounds(30,300,100,30);
        check.addActionListener(this);
        add(check);

        update = new JButton("Update");
        update.setBackground(Color.white);
        update.setForeground(Color.black);
        update.setBounds(150,300,100,30);
        update.addActionListener(this);
        add(update);

        back = new JButton("Back");
        back.setBackground(Color.white);
        back.setForeground(Color.red);
        back.setBounds(270,300,100,30);
        back.addActionListener(this);
        add(back);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons-hotel/seventh.jpg"));
        Image i2 = i1.getImage().getScaledInstance(500, 300, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i1);
        image.setBounds(400,50,500,300);
        add(image);

        setBounds(300,200,980,450);
        setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == check) {
            String toId = cCustomer.getSelectedItem();
            String query = "select * from customer where number = '" + toId + "'";
            try {
                Conn conn = new Conn();
                ResultSet rs = conn.s.executeQuery(query);
                while (rs.next()) {
                    tfRoom.setText(rs.getString("room"));
                }
                ResultSet rs2 = conn.s.executeQuery("select * from room where room_number = '" + tfRoom.getText() + "'");
                while (rs2.next()) {
                    tfAvailability.setText(rs2.getString("availability"));
                    tfStatus.setText(rs2.getString("clean_status"));
                }
            } catch (Exception e1) {
                e1.printStackTrace();
            }
        } else if (e.getSource() == update) {
            String number = cCustomer.getSelectedItem();
            String toRoom = tfRoom.getText();
            String toAvailability = tfAvailability.getText();
            String toStatus = tfStatus.getText();
            try {
                Conn conn = new Conn();
                conn.s.executeUpdate("update room set availability = '" + toAvailability + "', clean_status = '" + toStatus + "' where room_number = '" + toRoom + "'");
                JOptionPane.showMessageDialog(null, "Room has been updated");

                setVisible(false);
                new Reception();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        } else {
            setVisible(false);
            new Reception();
        }
    }

    public static void main(String[] args) {
        new UpdateRoom();
    }
}
