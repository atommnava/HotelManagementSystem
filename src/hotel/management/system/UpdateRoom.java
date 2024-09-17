package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;

public class UpdateRoom extends JFrame implements ActionListener {  // Hereda de JFrame e implementa ActionListener
    JTextField tfRoom, tfAvailability, tfStatus;  // Campos de texto para detalles de la habitación
    Choice cCustomer;  // Desplegable para seleccionar el ID del cliente
    JButton check, update, back;  // Botones para interactuar con la interfaz

    public UpdateRoom() {  // Constructor de la clase
        getContentPane().setBackground(Color.WHITE);  // Fondo de la ventana
        setLayout(null);  // Usando un layout nulo para posiciones absolutas

        // Título de la ventana
        JLabel text = new JLabel("Update Room Status");
        text.setFont(new Font("Tahoma", Font.PLAIN, 20));
        text.setBounds(30, 20, 250, 30);
        text.setForeground(Color.BLUE);
        add(text);

        // Etiqueta y Choice para el ID del cliente
        JLabel lblId = new JLabel("Customer ID");
        lblId.setBounds(30, 80, 100, 20);
        add(lblId);

        cCustomer = new Choice();
        cCustomer.setBounds(200, 80, 150, 25);
        add(cCustomer);

        // Consulta a la base de datos para llenar el Choice con los IDs de clientes
        try {
            Conn conn = new Conn();
            ResultSet rs = conn.s.executeQuery("select * from customer");
            while (rs.next()) {
                cCustomer.add(rs.getString("number"));  // Añade el número de cliente al desplegable
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Etiqueta y campo de texto para el número de habitación
        JLabel lblRoom = new JLabel("Room Number");
        lblRoom.setBounds(30, 130, 100, 20);
        add(lblRoom);

        tfRoom = new JTextField();
        tfRoom.setBounds(200, 130, 150, 25);
        add(tfRoom);

        // Etiqueta y campo de texto para la disponibilidad de la habitación
        JLabel lblName = new JLabel("Availability");
        lblName.setBounds(30, 180, 100, 20);
        add(lblName);

        tfAvailability = new JTextField();
        tfAvailability.setBounds(200, 180, 150, 25);
        add(tfAvailability);

        // Etiqueta y campo de texto para el estado de limpieza de la habitación
        JLabel lblCheckin = new JLabel("Cleaning Status");
        lblCheckin.setBounds(30, 230, 100, 20);
        add(lblCheckin);

        tfStatus = new JTextField();
        tfStatus.setBounds(200, 230, 150, 25);
        add(tfStatus);

        // Botón "Check" para obtener detalles de la habitación
        check = new JButton("Check");
        check.setBackground(Color.white);
        check.setForeground(Color.black);
        check.setBounds(30, 300, 100, 30);
        check.addActionListener(this);
        add(check);

        // Botón "Update" para actualizar el estado de la habitación
        update = new JButton("Update");
        update.setBackground(Color.white);
        update.setForeground(Color.black);
        update.setBounds(150, 300, 100, 30);
        update.addActionListener(this);
        add(update);

        // Botón "Back" para regresar a la ventana anterior
        back = new JButton("Back");
        back.setBackground(Color.white);
        back.setForeground(Color.red);
        back.setBounds(270, 300, 100, 30);
        back.addActionListener(this);
        add(back);

        // Imagen decorativa
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons-hotel/seventh.jpg"));
        Image i2 = i1.getImage().getScaledInstance(500, 300, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(400, 50, 500, 300);
        add(image);

        // Configuración de la ventana
        setBounds(300, 200, 980, 450);
        setVisible(true);
    }

    // Método para manejar acciones de los botones
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == check) {  // Acción para el botón "Check"
            String toId = cCustomer.getSelectedItem();  // Obtiene el ID del cliente seleccionado
            String query = "select * from customer where number = '" + toId + "'";
            try {
                Conn conn = new Conn();
                ResultSet rs = conn.s.executeQuery(query);  // Ejecuta consulta para obtener detalles del cliente
                while (rs.next()) {
                    tfRoom.setText(rs.getString("room"));  // Rellena el campo con el número de habitación
                }

                // Consulta para obtener la disponibilidad y el estado de limpieza de la habitación
                ResultSet rs2 = conn.s.executeQuery("select * from room where room_number = '" + tfRoom.getText() + "'");
                while (rs2.next()) {
                    tfAvailability.setText(rs2.getString("availability"));  // Rellena el campo de disponibilidad
                    tfStatus.setText(rs2.getString("clean_status"));  // Rellena el campo de estado de limpieza
                }
            } catch (Exception e1) {
                e1.printStackTrace();
            }
        } else if (e.getSource() == update) {  // Acción para el botón "Update"
            String toRoom = tfRoom.getText();
            String toAvailability = tfAvailability.getText();
            String toStatus = tfStatus.getText();
            try {
                Conn conn = new Conn();
                // Actualiza los detalles de la habitación en la base de datos
                conn.s.executeUpdate("update room set availability = '" + toAvailability + "', clean_status = '" + toStatus + "' where room_number = '" + toRoom + "'");
                JOptionPane.showMessageDialog(null, "Room has been updated");

                setVisible(false);  // Cierra la ventana actual
                new Reception();  // Abre la ventana de recepción
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        } else {  // Acción para el botón "Back"
            setVisible(false);
            new Reception();
        }
    }

    // Método principal para ejecutar la aplicación
    public static void main(String[] args) {
        new UpdateRoom();
    }
}
