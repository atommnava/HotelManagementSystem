package hotel.management.system;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import javax.swing.*;
import net.proteanit.sql.DbUtils; // Asegúrate de tener la librería rs2xml.jar en el classpath

public class CustomerInfo extends JFrame implements ActionListener {
    JTable table;
    JButton back;

    public CustomerInfo() {
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        // Añadiendo etiquetas para los encabezados de la tabla
        JLabel l1 = new JLabel("Document Type");
        l1.setBounds(10, 10, 100, 20);
        add(l1);

        JLabel l2 = new JLabel("Number");
        l2.setBounds(160, 10, 100, 20);
        add(l2);

        JLabel l3 = new JLabel("Name");
        l3.setBounds(290, 10, 100, 20);
        add(l3);

        JLabel l4 = new JLabel("Gender");
        l4.setBounds(410, 10, 100, 20);
        add(l4);

        JLabel l5 = new JLabel("Country");
        l5.setBounds(540, 10, 100, 20);
        add(l5);

        JLabel l6 = new JLabel("Room Number");
        l6.setBounds(640, 10, 100, 20);
        add(l6);

        JLabel l7 = new JLabel("Checkin");
        l7.setBounds(790, 10, 100, 20);
        add(l7);

        JLabel l8 = new JLabel("Deposit");
        l8.setBounds(900, 10, 100, 20);
        add(l8);

        // Creando la tabla para mostrar la información de los clientes
        table = new JTable();
        table.setBounds(0, 40, 1000, 400);
        add(table);

        try {
            // Conectando a la base de datos y ejecutando la consulta
            Conn conn = new Conn();
            ResultSet rs = conn.s.executeQuery("select * from customer");
            
            // Usando DbUtils para llenar la tabla con los datos obtenidos
            table.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (Exception e1) {
            e1.printStackTrace();
        }

        // Botón "Back" para regresar a la pantalla anterior
        back = new JButton("Back");
        back.setBounds(420, 500, 120, 30);
        back.addActionListener(this);
        add(back);

        // Configurando la ventana
        setBounds(300, 200, 1000, 600);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        setVisible(false);
        new Reception(); // Volviendo a la pantalla de recepción
    }

    public static void main(String[] args) {
        new CustomerInfo(); // Ejecuta la aplicación
    }
}
