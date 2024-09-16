package hotel.management.system;

// Importación de bibliotecas necesarias para crear la interfaz gráfica, manejar eventos y trabajar con bases de datos
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import javax.swing.*;
import net.proteanit.sql.*;  // Biblioteca para manejar ResultSet y convertirlo en un modelo de tabla

public class ManagerInfo extends JFrame implements ActionListener {  // La clase hereda de JFrame y maneja eventos con ActionListener
    JTable table;  // Declaración de una tabla para mostrar información
    JButton back;  // Botón para regresar a la pantalla anterior

    public ManagerInfo() {  // Constructor de la clase
        getContentPane().setBackground(Color.WHITE);  // Establece el fondo de la ventana a color blanco
        setLayout(null);  // Desactiva el layout predeterminado para usar posiciones absolutas de los elementos

        // Creación de etiquetas para los encabezados de la tabla con su posición y tamaño
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

        // Creación de la tabla que mostrará los datos de los managers
        table = new JTable();
        table.setBounds(0, 40, 1000, 400);  // Establece las dimensiones y posición de la tabla
        add(table);  // Añade la tabla al JFrame

        // Consulta a la base de datos para obtener información de empleados cuyo trabajo es 'Manager'
        try {
            Conn conn = new Conn();  // Instancia la clase Conn para conectar con la base de datos
            ResultSet rs = conn.s.executeQuery("select * from employee where job = 'Manager'");  // Ejecuta la consulta SQL
            table.setModel(DbUtils.resultSetToTableModel(rs));  // Llena la tabla con los datos obtenidos del ResultSet
        } catch (Exception e1) {  // Manejo de excepciones
            e1.printStackTrace();
        }

        // Creación del botón 'Back' para regresar a la pantalla anterior
        back = new JButton("Back");
        back.setBounds(420, 500, 120, 30);  // Establece su posición y tamaño
        back.addActionListener(this);  // Añade el listener para manejar la acción del clic
        add(back);  // Añade el botón al JFrame

        // Establece las dimensiones y posición de la ventana principal
        setBounds(300, 200, 1000, 600);
        setVisible(true);  // Hace visible la ventana
    }

    // Método que maneja los eventos de los botones
    @Override
    public void actionPerformed(ActionEvent e) {
        setVisible(false);  // Oculta la ventana actual
        new Reception();  // Crea una nueva instancia de la clase 'Reception' para mostrar la pantalla de recepción
    }

    // Método principal para ejecutar la aplicación
    public static void main(String[] args) {
        new ManagerInfo();  // Crea una nueva instancia de 'ManagerInfo'
    }
}
