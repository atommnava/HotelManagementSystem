package hotel.management.system;

// Importando las bibliotecas necesarias
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import javax.swing.*;
import net.proteanit.sql.*; // Biblioteca para manejar ResultSet con tablas

public class Department extends JFrame implements ActionListener {
    JTable table; // Tabla para mostrar los departamentos y sus presupuestos
    JButton back; // Botón para volver a la recepción

    public Department() {
        // Configuración básica de la ventana
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        // Etiqueta para el encabezado "Department"
        JLabel l1 = new JLabel("Department");
        l1.setBounds(180, 10, 100, 20);
        add(l1);

        // Etiqueta para el encabezado "Budget"
        JLabel l2 = new JLabel("Budget");
        l2.setBounds(420, 10, 100, 20);
        add(l2);

        // Creación de la tabla
        table = new JTable();
        table.setBounds(0, 50, 700, 350);
        add(table);

        // Consulta SQL para obtener los datos de los departamentos
        try {
            Conn conn = new Conn();
            ResultSet rs = conn.s.executeQuery("select * from department");
            table.setModel(DbUtils.resultSetToTableModel(rs)); // Llenar la tabla con los datos
        } catch (Exception e1) {
            e1.printStackTrace();
        }

        // Botón "Back" para volver a la interfaz de recepción
        back = new JButton("Back");
        back.setBounds(280, 400, 120, 30);
        back.addActionListener(this);
        add(back);

        // Configurando la ventana
        setBounds(400, 200, 700, 480);
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
        new Department();
    }
}
