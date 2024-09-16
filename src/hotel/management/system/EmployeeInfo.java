package hotel.management.system;

// Importación de bibliotecas necesarias
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import javax.swing.*;
import net.proteanit.sql.*; // Biblioteca para manejar ResultSet y tablas

public class EmployeeInfo extends JFrame implements ActionListener {
    JTable table; // Tabla para mostrar la información de empleados
    JButton back; // Botón para regresar a la recepción

    public EmployeeInfo() {
        // Configuración básica de la ventana
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        // Etiquetas para los encabezados de la tabla
        JLabel l1 = new JLabel("Name");
        l1.setBounds(40, 10, 100, 20);
        add(l1);

        JLabel l2 = new JLabel("Age");
        l2.setBounds(170, 10, 100, 20);
        add(l2);

        JLabel l3 = new JLabel("Gender");
        l3.setBounds(290, 10, 100, 20);
        add(l3);

        JLabel l4 = new JLabel("Job");
        l4.setBounds(410, 10, 100, 20);
        add(l4);

        JLabel l5 = new JLabel("Salary");
        l5.setBounds(540, 10, 100, 20);
        add(l5);

        JLabel l6 = new JLabel("Phone");
        l6.setBounds(670, 10, 100, 20);
        add(l6);

        JLabel l7 = new JLabel("Email");
        l7.setBounds(790, 10, 100, 20);
        add(l7);

        JLabel l8 = new JLabel("Curp");
        l8.setBounds(910, 10, 100, 20);
        add(l8);

        // Creación de la tabla
        table = new JTable();
        table.setBounds(0, 40, 1000, 400);
        add(table);

        // Consulta SQL para obtener los datos de los empleados
        try {
            Conn conn = new Conn();
            ResultSet rs = conn.s.executeQuery("select * from employee");
            table.setModel(DbUtils.resultSetToTableModel(rs)); // Llenar la tabla con los datos
        } catch (Exception e1) {
            e1.printStackTrace();
        }

        // Botón "Back" para regresar a la recepción
        back = new JButton("Back");
        back.setBounds(420, 500, 120, 30);
        back.addActionListener(this);
        add(back);

        // Configuración de la ventana
        setBounds(300, 200, 1000, 600);
        setVisible(true);
    }

    // Manejo de eventos para el botón "Back"
    @Override
    public void actionPerformed(ActionEvent e) {
        setVisible(false); // Cierra la ventana actual
        new Reception(); // Abre la ventana de recepción
    }

    // Método principal para ejecutar el programa
    public static void main(String[] args) {
        new EmployeeInfo();
    }
}
