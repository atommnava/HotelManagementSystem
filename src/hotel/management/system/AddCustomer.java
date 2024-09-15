/*
 * @brief La clase AddCustomer representa la interfaz gráfica para agregar un nuevo cliente al sistema de gestión del hotel. 
 * Esta clase permite capturar detalles como nombre, género, país, número de habitación, y depósito, entre otros. 
 * Incluye funcionalidades para agregar el cliente a la base de datos y actualizar la disponibilidad de las habitaciones.
 * @author Atom Alexander M. Nava
 * @date 25/09/24
 */

package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.Date;

public class AddCustomer extends JFrame implements ActionListener {
    // Declaración de componentes de la interfaz gráfica
    JTextField tfNumber, tfName, tfCountry, tfDeposit;
    JComboBox comboId;
    JRadioButton rbMale, rbFemale;
    Choice cRoom;
    JLabel lblCheckInTime;
    JButton add, back;

    // Constructor de la clase AddCustomer para inicializar la interfaz gráfica
    AddCustomer() {
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        // Configuración y adición de la etiqueta de título
        JLabel text = new JLabel("NEW CUSTOMER");
        text.setBounds(100, 20, 300, 30);
        text.setFont(new Font("Raleway", Font.PLAIN, 20));
        add(text);

        // Configuración y adición del campo de selección de ID
        JLabel id = new JLabel("ID");
        id.setBounds(35, 80, 300, 30);
        id.setFont(new Font("Raleway", Font.PLAIN, 20));
        add(id);

        String options[] = {"ID", "Passport", "Driver License", "Voter-ID Card", "Ration Card"};
        comboId = new JComboBox(options);
        comboId.setBounds(200, 80, 150, 20);
        comboId.setBackground(Color.WHITE);
        add(comboId);

        // Configuración y adición del campo para número de ID
        JLabel lblNumber = new JLabel("Number");
        lblNumber.setBounds(35, 120, 300, 30);
        lblNumber.setFont(new Font("Raleway", Font.PLAIN, 20));
        add(lblNumber);

        tfNumber = new JTextField();
        tfNumber.setBounds(200, 120, 150, 25);
        add(tfNumber);

        // Configuración y adición del campo para el nombre
        JLabel lblName = new JLabel("Name");
        lblName.setBounds(35, 160, 300, 30);
        lblName.setFont(new Font("Raleway", Font.PLAIN, 20));
        add(lblName);

        tfName = new JTextField();
        tfName.setBounds(200, 160, 150, 25);
        add(tfName);

        // Configuración y adición de la selección de género
        JLabel lblGender = new JLabel("Gender");
        lblGender.setBounds(35, 200, 300, 30);
        lblGender.setFont(new Font("Raleway", Font.PLAIN, 20));
        add(lblGender);

        rbMale = new JRadioButton("Male");
        rbMale.setBackground(Color.WHITE);
        rbMale.setBounds(200, 200, 80, 25);
        add(rbMale);

        rbFemale = new JRadioButton("Female");
        rbFemale.setBackground(Color.WHITE);
        rbFemale.setBounds(270, 200, 100, 25);
        add(rbFemale);

        ButtonGroup bg = new ButtonGroup();
        bg.add(rbMale);
        bg.add(rbFemale);

        // Configuración y adición del campo para el país
        JLabel lblCountry = new JLabel("Country");
        lblCountry.setBounds(35, 240, 300, 30);
        lblCountry.setFont(new Font("Raleway", Font.PLAIN, 20));
        add(lblCountry);

        tfCountry = new JTextField();
        tfCountry.setBounds(200, 240, 150, 25);
        add(tfCountry);

        // Configuración y adición de la selección de número de habitación
        JLabel lblRoom = new JLabel("Room Number");
        lblRoom.setBounds(35, 280, 150, 30);
        lblRoom.setFont(new Font("Raleway", Font.PLAIN, 20));
        add(lblRoom);

        cRoom = new Choice();
        try {
            // Consulta para obtener las habitaciones disponibles de la base de datos
            Conn conn = new Conn();
            String query = "select * from room where availability = 'Available'";
            ResultSet rs = conn.s.executeQuery(query);
            while (rs.next()) {
                cRoom.add(rs.getString("room_number"));
            }
        } catch (Exception e1) {
            e1.printStackTrace();
        }
        cRoom.setBounds(200, 280, 150, 25);
        add(cRoom);

        // Configuración y adición de la etiqueta para el tiempo de check-in
        JLabel lblTime = new JLabel("Check in time");
        lblTime.setBounds(35, 320, 150, 30);
        lblTime.setFont(new Font("Raleway", Font.PLAIN, 20));
        add(lblTime);

        Date date = new Date();
        lblCheckInTime = new JLabel("" + date);
        lblCheckInTime.setBounds(200, 325, 160, 25);
        lblCheckInTime.setFont(new Font("Raleway", Font.PLAIN, 16));
        add(lblCheckInTime);

        // Configuración y adición del campo para el depósito
        JLabel lblDeposit = new JLabel("Deposit");
        lblDeposit.setBounds(35, 360, 300, 30);
        lblDeposit.setFont(new Font("Raleway", Font.PLAIN, 20));
        add(lblDeposit);

        tfDeposit = new JTextField();
        tfDeposit.setBounds(200, 360, 150, 25);
        add(tfDeposit);

        // Configuración y adición de los botones
        add = new JButton("Add");
        add.setForeground(Color.black);
        add.setBounds(50, 410, 120, 25);
        add.addActionListener(this);
        add(add);

        back = new JButton("Back");
        back.setForeground(Color.black);
        back.setBounds(200, 410, 120, 25);
        back.addActionListener(this);
        add(back);

        // Adición de imagen de fondo
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons-hotel/fifth.png"));
        Image i2 = i1.getImage().getScaledInstance(300, 400, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(400, 50, 300, 400);
        add(image);

        // Configuración de la ventana
        setBounds(350, 200, 800, 550);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // Lógica para el botón "Add"
        if (e.getSource() == add) {
            String toComboId = (String) comboId.getSelectedItem();
            String toNumber = tfNumber.getText();
            String toName = tfName.getText();
            String toGender = null;

            if (rbMale.isSelected()) {
                toGender = "Male";
            } else if (rbFemale.isSelected()) {
                toGender = "Female";
            }

            String toCountry = tfCountry.getText();
            String toRoomNumber = cRoom.getSelectedItem();
            String toTime = lblCheckInTime.getText();
            String toDeposit = tfDeposit.getText();

            try {
                // Inserción de datos del cliente en la base de datos y actualización de la disponibilidad de la habitación
                String query = "insert into customer values('" + toComboId + "', '" + toNumber + "', '" + toName + "', '" + toGender + "'," +
                        " '" + toCountry + "', '" + toRoomNumber + "', '" + toTime + "', '" + toDeposit + "')";
                String query2 = "update room set availability = 'Occupied' where room_number = '" + toRoomNumber + "'";

                Conn conn = new Conn();
                conn.s.executeUpdate(query);
                conn.s.executeUpdate(query2);

                JOptionPane.showMessageDialog(null, "New Customer added Successfully!");

                setVisible(false);
                new Reception();

            } catch (Exception e1) {
                e1.printStackTrace();
            }
        } else if (e.getSource() == back) {
            // Lógica para el botón "Back"
            setVisible(false);
            new Reception();
        }
    }

    // Método principal para iniciar la aplicación
    public static void main(String[] args) {
        new AddCustomer();
    }
}
