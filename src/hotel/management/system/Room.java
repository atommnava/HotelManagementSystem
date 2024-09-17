package hotel.management.system;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import javax.swing.*;
import net.proteanit.sql.*;  // Librería para manejar tablas de bases de datos en la interfaz

public class Room extends JFrame implements ActionListener {  // La clase hereda de JFrame e implementa ActionListener
    JTable table;  // Tabla para mostrar los datos de las habitaciones
    JButton back;  // Botón para regresar al menú anterior

    public Room() {  // Constructor de la clase
        getContentPane().setBackground(Color.WHITE);  // Establece el fondo de la ventana a color blanco
        setLayout(null);  // Desactiva el layout predeterminado para usar posiciones absolutas

        // Añade una imagen a la ventana
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons-hotel/eight.jpg"));  // Carga la imagen
        Image i2 = i1.getImage().getScaledInstance(600, 600, Image.SCALE_DEFAULT);  // Escala la imagen
        ImageIcon i3 = new ImageIcon(i2);  // Crea un nuevo ImageIcon con la imagen escalada
        JLabel image = new JLabel(i3);  // Añade la imagen a un JLabel
        image.setBounds(500, 0, 600, 600);  // Establece la posición y tamaño de la imagen
        add(image);

        // Etiquetas para las columnas de la tabla
        JLabel l1 = new JLabel("Room Number");
        l1.setBounds(10, 10, 100, 20);
        add(l1);

        JLabel l2 = new JLabel("Availability");
        l2.setBounds(120, 10, 100, 20);
        add(l2);

        JLabel l3 = new JLabel("Status");
        l3.setBounds(230, 10, 100, 20);
        add(l3);

        JLabel l4 = new JLabel("Price");
        l4.setBounds(340, 10, 100, 20);
        add(l4);

        JLabel l5 = new JLabel("Bed Type");
        l5.setBounds(430, 10, 100, 20);
        add(l5);

        // Tabla para mostrar los datos de las habitaciones
        table = new JTable();
        table.setBounds(0, 40, 500, 400);  // Establece la posición y el tamaño de la tabla
        add(table);

        // Consulta a la base de datos para obtener los datos de las habitaciones
        try {
            Conn conn = new Conn();  // Crea una instancia de la clase de conexión a la base de datos
            ResultSet rs = conn.s.executeQuery("select * from room");  // Ejecuta la consulta SQL
            table.setModel(DbUtils.resultSetToTableModel(rs));  // Establece el modelo de la tabla con los resultados de la consulta
        } catch (Exception e1) {
            e1.printStackTrace();
        }

        // Botón para regresar a la ventana de recepción
        back = new JButton("Back");
        back.setBounds(200, 500, 120, 30);  // Establece la posición y tamaño del botón
        back.addActionListener(this);  // Añade un ActionListener para manejar el clic
        add(back);

        // Configuración de la ventana principal
        setBounds(300, 200, 1050, 600);  // Establece la posición y tamaño de la ventana
        setVisible(true);  // Hace visible la ventana
    }

    // Método para manejar los eventos del botón "Back"
    @Override
    public void actionPerformed(ActionEvent e) {
        setVisible(false);  // Oculta la ventana actual
        new Reception();  // Crea una nueva instancia de la ventana "Reception"
    }

    // Método principal para ejecutar la aplicación
    public static void main(String[] args) {
        new Room();  // Crea una nueva instancia de 'Room'
    }
}
