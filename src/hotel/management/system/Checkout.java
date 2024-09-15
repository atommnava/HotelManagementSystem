/*
 * @brief La clase Checkout permite gestionar el proceso de "checkout" de los clientes en el sistema de gestión del hotel.
 * Incluye la selección de ID del cliente, muestra información de la habitación, tiempo de check-in y check-out.
 * Permite realizar el proceso de "checkout" actualizando el estado de la habitación en la base de datos.
 * @author Atom
 * @date 25/09/24
 */

package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.Date;

public class Checkout extends JFrame implements ActionListener {
    // Componentes de la interfaz gráfica
    JLabel lblRoomNumber, lblCheckinTime, lblCheckoutTime;
    Choice cCustomerID;
    JButton checkout, back;

    // Constructor para configurar la interfaz gráfica
    Checkout() {
        setLayout(null);
        getContentPane().setBackground(Color.white);

        // Etiqueta de título
        JLabel text = new JLabel("Checkout");
        text.setBounds(100, 20, 100, 30);
        text.setForeground(Color.blue);
        text.setFont(new Font("Tahoma", Font.BOLD, 20));
        add(text);

        // Etiqueta y campo desplegable para el ID del cliente
        JLabel lblId = new JLabel("Customer ID");
        lblId.setBounds(30, 80, 100, 30);
        add(lblId);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons-hotel/tick.png"));
        Image i2 = i1.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(310, 80, 20, 20);
        add(image);

        // Etiqueta para mostrar el número de habitación
        JLabel lblRoom = new JLabel("Room Number");
        lblRoom.setBounds(30, 130, 100, 30);
        add(lblRoom);

        lblRoomNumber = new JLabel();
        lblRoomNumber.setBounds(150, 130, 100, 30);
        add(lblRoomNumber);

        // Etiqueta para mostrar el tiempo de check-in
        JLabel lblCheckin = new JLabel("Checkin Time");
        lblCheckin.setBounds(30, 180, 100, 30);
        add(lblCheckin);

        lblCheckinTime = new JLabel();
        lblCheckinTime.setBounds(150, 180, 100, 30);
        add(lblCheckinTime);

        // Etiqueta para mostrar el tiempo de check-out
        JLabel lblCheckout = new JLabel("Checkout Time");
        lblCheckout.setBounds(30, 230, 100, 30);
        add(lblCheckout);

        Date date = new Date();  // Fecha y hora actuales
        lblCheckoutTime = new JLabel("" + date);
        lblCheckoutTime.setBounds(150, 230, 200, 30);
        add(lblCheckoutTime);

        // Botón para realizar el checkout
        checkout = new JButton("Checkout");
        checkout.setBackground(Color.white);
        checkout.setForeground(Color.black);
        checkout.setBounds(30, 280, 120, 30);
        checkout.addActionListener(this);
        add(checkout);

        // Botón para regresar
        back = new JButton("Back");
        back.setBackground(Color.white);
        back.setForeground(Color.black);
        back.setBounds(170, 280, 120, 30);
        back.addActionListener(this);
        add(back);

        // Campo desplegable para seleccionar el ID del cliente
        cCustomerID = new Choice();
        cCustomerID.setBounds(150, 80, 100, 30);
        add(cCustomerID);

        // Población del campo desplegable con IDs de clientes y actualización de la información de la habitación
        try {
            Conn conn = new Conn();
            ResultSet rs = conn.s.executeQuery("select * from customer");
            while (rs.next()) {
                cCustomerID.add(rs.getString("number"));
                lblRoomNumber.setText(rs.getString("room"));
                lblCheckinTime.setText(rs.getString("checkin_time"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Imagen decorativa
        ImageIcon i4 = new ImageIcon(ClassLoader.getSystemResource("icons-hotel/sixth.jpg"));
        Image i5 = i4.getImage().getScaledInstance(400, 250, Image.SCALE_DEFAULT);
        ImageIcon i6 = new ImageIcon(i5);
        JLabel image2 = new JLabel(i6);
        image2.setBounds(350, 50, 400, 250);
        add(image2);

        // Configuración de la ventana
        setBounds(300, 200, 800, 400);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == checkout) {
            // Obtiene el ID del cliente seleccionado y las consultas SQL para el checkout
            String number = cCustomerID.getSelectedItem();
            String query1 = "delete from customer where number = '" + number + "'";
            String query2 = "update room set availability = 'Available' where room_number = '" + lblRoomNumber.getText() + "'";

            try {
                // Ejecuta las consultas SQL para eliminar el cliente y actualizar la disponibilidad de la habitación
                Conn conn = new Conn();
                conn.s.executeUpdate(query1);
                conn.s.executeUpdate(query2);
                JOptionPane.showMessageDialog(null, "Customer has been checked out");

                // Cierra la ventana actual y regresa a la recepción
                setVisible(false);
                new Reception();
            } catch (Exception e1) {
                e1.printStackTrace();
            }
        } else {
            // Acción para el botón "Back": cierra la ventana actual y regresa a la recepción
            setVisible(false);
            new Reception();
        }
    }

    // Método principal para iniciar la aplicación
    public static void main(String[] args) {
        new Checkout();
    }
}
