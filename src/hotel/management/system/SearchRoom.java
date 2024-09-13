package hotel.management.system;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import javax.naming.directory.SearchControls;
import javax.swing.*;
import net.proteanit.sql.*;


public class SearchRoom extends JFrame implements ActionListener {
    JTable table;
    JButton back, submit;
    JComboBox bedType;
    JCheckBox available;
    public SearchRoom() {
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JLabel text = new JLabel("Search Room");
        text.setFont(new Font("Tahoma", Font.PLAIN, 20));
        text.setBounds(400,30,200,30);
        add(text);

        JLabel lblBed = new JLabel("Bed Type");
        lblBed.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblBed.setBounds(50,100,100,20);
        add(lblBed);

        bedType = new JComboBox(new String[] {"Single Bed", "Double Bed"});
        bedType.setBounds(150,100,150,25);
        bedType.setBackground(Color.WHITE);
        add(bedType);

        available = new JCheckBox("Only display Available");
        available.setBounds(650,100,150,25);
        available.setBackground(Color.WHITE);
        add(available);

        JLabel l1 = new JLabel("Room Number");
        l1.setBounds(50,160,100,20);
        add(l1);

        JLabel l2 = new JLabel("Availability");
        l2.setBounds(270,160,100,20);
        add(l2);

        JLabel l3 = new JLabel("Status");
        l3.setBounds(450,160,100,20);
        add(l3);

        JLabel l4 = new JLabel("Price");
        l4.setBounds(670,160,100,20);
        add(l4);

        JLabel l5 = new JLabel("Bed Type");
        l5.setBounds(870,160,100,20);
        add(l5);

        table = new JTable();
        table.setBounds(0,200,1000,300);
        add(table);

        try {
            Conn conn = new Conn();
            ResultSet rs = conn.s.executeQuery("select * from room");
            table.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (Exception e1) {
            e1.printStackTrace();
        }
        submit = new JButton("Submit");
        submit.setBounds(300,520,120,30);
        submit.addActionListener(this);
        add(submit);

        back = new JButton("Back");
        back.setBounds(500,520,120,30);
        back.addActionListener(this);
        add(back);

        setBounds(300,200,1000,600);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == submit) {
            try {
                Conn conn = new Conn();
                String query = "select * from room where bed_type = '" + bedType.getSelectedItem() + "'";
                String query2 = "select * from room where availability = 'Available' AND bed_type = '" + bedType.getSelectedItem() + "'";
                ResultSet rs;
                if (available.isSelected()) {
                    rs = conn.s.executeQuery(query);
                } else {
                    rs = conn.s.executeQuery(query2);
                }
                table.setModel(DbUtils.resultSetToTableModel(rs));
            } catch(Exception e1) {
                e1.printStackTrace();
            }
        } else {
            setVisible(false);
            new Reception();
        }
    }
    public static void main(String[] args) {
        new SearchRoom();
    }

}
