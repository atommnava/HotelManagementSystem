package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class UpdateCheck extends JFrame implements ActionListener {
    JTextField tfRoom, tfName, tfCheckin, tfDeposit, tfPending;
    Choice cCustomer;
    JButton check, update, back;
    public UpdateCheck() {
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JLabel text = new JLabel("Update Status");
        text.setFont(new Font("Tahoma", Font.PLAIN, 20));
        text.setBounds(90,20,200,30);
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
        lblRoom.setBounds(30,120,100,20);
        add(lblRoom);

        tfRoom = new JTextField();
        tfRoom.setBounds(200,120,150,25);
        add(tfRoom);

        JLabel lblName = new JLabel("Name");
        lblName.setBounds(30,160,100,20);
        add(lblName);

        tfName = new JTextField();
        tfName.setBounds(200,160,150,25);
        add(tfName);

        JLabel lblCheckin = new JLabel("Checkin Time");
        lblCheckin.setBounds(30,200,100,20);
        add(lblCheckin);

        tfCheckin = new JTextField();
        tfCheckin.setBounds(200,200,150,25);
        add(tfCheckin);

        JLabel lblPaid = new JLabel("Amount Paid");
        lblPaid.setBounds(30,240,100,20);
        add(lblPaid);

        tfDeposit = new JTextField();
        tfDeposit.setBounds(200,240,150,25);
        add(tfDeposit);

        JLabel lblPending = new JLabel("Pending Amount");
        lblPending.setBounds(30,280,150,20);
        add(lblPending);

        tfPending = new JTextField();
        tfPending.setBounds(200,280,150,25);
        add(tfPending);

        check = new JButton("Check");
        check.setBackground(Color.white);
        check.setForeground(Color.black);
        check.setBounds(30,340,100,30);
        check.addActionListener(this);
        add(check);

        update = new JButton("Update");
        update.setBackground(Color.white);
        update.setForeground(Color.black);
        update.setBounds(150,340,100,30);
        update.addActionListener(this);
        add(update);

        back = new JButton("Back");
        back.setBackground(Color.white);
        back.setForeground(Color.red);
        back.setBounds(270,340,100,30);
        back.addActionListener(this);
        add(back);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons-hotel/nine.jpg"));
        JLabel image = new JLabel(i1);
        image.setBounds(400,50,500,300);
        add(image);

        setBounds(300,200,980,500);
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
                    tfName.setText(rs.getString("name"));
                    tfCheckin.setText(rs.getString("checkin_time"));
                    tfDeposit.setText(rs.getString("deposit"));
                }
                ResultSet rs2 = conn.s.executeQuery("select * from room where room_number = '" + tfRoom.getText() + "'");
                while (rs2.next()) {
                    String price = rs2.getString("price");
                    int amountPaid = Integer.parseInt(price) - Integer.parseInt(tfDeposit.getText());
                    tfPending.setText("" + amountPaid);
                }
            } catch (Exception e1) {
                e1.printStackTrace();
            }
        } else if (e.getSource() == update) {
            String number = cCustomer.getSelectedItem();
            String toRoom = tfRoom.getText();
            String toName = tfName.getText();
            String toCheckin = tfCheckin.getText();
            String toDeposit = tfDeposit.getText();

            try {
                Conn conn = new Conn();
                conn.s.executeUpdate("update customer set room = '" + toRoom + "', name = '" + toName + "', checkin_time = '" + toCheckin + "', deposit = '" + toDeposit + "' where number = '" + number +"'");
                JOptionPane.showMessageDialog(null, "Customer has been updated");

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
        new UpdateCheck();
    }
}
