package hotel.management.system;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import javax.swing.*;
import net.proteanit.sql.*;  // Librería para manejar tablas de bases de datos en la interfaz

public class SearchRoom extends JFrame implements ActionListener {  // La clase hereda de JFrame e implementa ActionListener
    JTable table;  // Tabla para mostrar los datos de las habitaciones
    JButton back, submit;  // Botones para la interfaz
    JComboBox bedType;  // ComboBox para seleccionar el tipo de cama
    JCheckBox available;  // CheckBox para filtrar solo habitaciones disponibles

    public SearchRoom() {  // Constructor de la clase
        getContentPane().setBackground(Color.WHITE);  // Establece el fondo de la ventana a color blanco
        setLayout(null);  // Desactiva el layout predeterminado para usar posiciones absolutas

        // Etiqueta de título
        JLabel text = new JLabel("Search Room");
        text.setFont(new Font("Tahoma", Font.PLAIN, 20));
        text.setBounds(400, 30, 200, 30);
        add(text);

        // Etiqueta y JComboBox para seleccionar el tipo de cama
        JLabel lblBed = new JLabel("Bed Type");
        lblBed.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblBed.setBounds(50, 100, 100, 20);
        add(lblBed);

        bedType = new JComboBox(new String[] {"Single Bed", "Double Bed"});  // Opciones para el tipo de cama
        bedType.setBounds(150, 100, 150, 25);
        bedType.setBackground(Color.WHITE);
        add(bedType);

        // CheckBox para filtrar habitaciones disponibles
        available = new JCheckBox("Only display Available");
        available.setBounds(650, 100, 150, 25);
        available.setBackground(Color.WHITE);
        add(available);

        // Etiquetas para los encabezados de la tabla
        JLabel l1 = new JLabel("Room Number");
        l1.setBounds(50, 160, 100, 20);
        add(l1);

        JLabel l2 = new JLabel("Availability");
        l2.setBounds(270, 160, 100, 20);
        add(l2);

        JLabel l3 = new JLabel("Status");
        l3.setBounds(450, 160, 100, 20);
        add(l3);

        JLabel l4 = new JLabel("Price");
        l4.setBounds(670, 160, 100, 20);
        add(l4);

        JLabel l5 = new JLabel("Bed Type");
        l5.setBounds(870, 160, 100, 20);
        add(l5);

        // Tabla para mostrar los datos de las habitaciones
        table = new JTable();
        table.setBounds(0, 200, 1000, 300);
        add(table);

        // Consulta a la base de datos para mostrar todos los datos de las habitaciones
        try {
            Conn conn = new Conn();  // Crea una instancia de la clase de conexión a la base de datos
            ResultSet rs = conn.s.executeQuery("select * from room");  // Ejecuta la consulta SQL
            table.setModel(DbUtils.resultSetToTableModel(rs));  // Establece el modelo de la tabla con los resultados de la consulta
        } catch (Exception e1) {
            e1.printStackTrace();
        }

        // Botón "Submit" para realizar la búsqueda
        submit = new JButton("Submit");
        submit.setBounds(300, 520, 120, 30);
        submit.addActionListener(this);  // Añade un ActionListener para manejar el clic
        add(submit);

        // Botón "Back" para regresar a la ventana anterior
        back = new JButton("Back");
        back.setBounds(500, 520, 120, 30);
        back.addActionListener(this);  // Añade un ActionListener para manejar el clic
        add(back);

        // Configuración de la ventana principal
        setBounds(300, 200, 1000, 600);  // Establece la posición y tamaño de la ventana
        setVisible(true);  // Hace visible la ventana
    }

    // Método para manejar los eventos de los botones
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == submit) {  // Si se presiona el botón "Submit"
            try {
                Conn conn = new Conn();  // Crea una instancia de la clase de conexión a la base de datos
                String query = "select * from room where bed_type = '" + bedType.getSelectedItem() + "'";
                String query2 = "select * from room where availability = 'Available' AND bed_type = '" + bedType.getSelectedItem() + "'";
                ResultSet rs;

                if (available.isSelected()) {  // Si la casilla "Only display Available" está seleccionada
                    rs = conn.s.executeQuery(query2);  // Ejecuta la consulta que incluye la disponibilidad
                } else {
                    rs = conn.s.executeQuery(query);  // Ejecuta la consulta que no filtra por disponibilidad
                }

                table.setModel(DbUtils.resultSetToTableModel(rs));  // Actualiza la tabla con los resultados de la consulta
            } catch (Exception e1) {
                e1.printStackTrace();
            }
        } else {  // Si se presiona el botón "Back"
            setVisible(false);  // Oculta la ventana actual
            new Reception();  // Crea una nueva instancia de la ventana "Reception"
        }
    }

    // Método principal para ejecutar la aplicación
    public static void main(String[] args) {
        new SearchRoom();  // Crea una nueva instancia de 'SearchRoom'
    }
}
