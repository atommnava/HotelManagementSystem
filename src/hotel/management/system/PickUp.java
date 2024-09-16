package hotel.management.system;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import javax.swing.*;
import net.proteanit.sql.*;  // Librería para trabajar con ResultSet y convertirlo en un modelo de tabla

public class PickUp extends JFrame implements ActionListener {  // La clase hereda de JFrame e implementa ActionListener
    JTable table;  // Tabla para mostrar los datos de los conductores
    JButton back, submit;  // Botones para acciones
    Choice typeOfCar;  // Menú desplegable para seleccionar el tipo de carro

    public PickUp() {  // Constructor de la clase
        getContentPane().setBackground(Color.WHITE);  // Establece el fondo de la ventana a color blanco
        setLayout(null);  // Desactiva el layout predeterminado para usar posiciones absolutas

        // Etiqueta de título "Pickup Service"
        JLabel text = new JLabel("Pickup Service");
        text.setFont(new Font("Tahoma", Font.PLAIN, 20));  // Establece la fuente del texto
        text.setBounds(400, 30, 200, 30);  // Posición y tamaño de la etiqueta
        add(text);

        // Etiqueta "Type of Car"
        JLabel lblBed = new JLabel("Type of Car");
        lblBed.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblBed.setBounds(50, 100, 100, 20);
        add(lblBed);

        // Menú desplegable para seleccionar el tipo de carro
        typeOfCar = new Choice();
        typeOfCar.setBounds(150, 100, 200, 25);
        add(typeOfCar);

        // Llenado del menú desplegable con los modelos de autos disponibles en la base de datos
        try {
            Conn conn = new Conn();  // Conexión a la base de datos
            ResultSet rs = conn.s.executeQuery("select * from driver");  // Consulta SQL para obtener los conductores
            while (rs.next()) {  // Recorre los resultados y añade cada modelo al menú desplegable
                typeOfCar.add(rs.getString("model"));
            }
        } catch (Exception e1) {
            e1.printStackTrace();  // Manejo de excepciones
        }

        // Creación de etiquetas para los encabezados de la tabla
        JLabel l1 = new JLabel("Name");
        l1.setBounds(30, 160, 100, 20);
        add(l1);

        JLabel l2 = new JLabel("Age");
        l2.setBounds(200, 160, 100, 20);
        add(l2);

        JLabel l3 = new JLabel("Gender");
        l3.setBounds(330, 160, 100, 20);
        add(l3);

        JLabel l4 = new JLabel("Company");
        l4.setBounds(460, 160, 100, 20);
        add(l4);

        JLabel l5 = new JLabel("Model");
        l5.setBounds(630, 160, 100, 20);
        add(l5);

        JLabel l6 = new JLabel("Availability");
        l6.setBounds(740, 160, 100, 20);
        add(l6);

        JLabel l7 = new JLabel("Location");
        l7.setBounds(890, 160, 100, 20);
        add(l7);

        // Creación de la tabla para mostrar la información de los conductores
        table = new JTable();
        table.setBounds(0, 200, 1000, 300);  // Establece las dimensiones y posición de la tabla
        add(table);

        // Consulta inicial a la base de datos para mostrar todos los conductores
        try {
            Conn conn = new Conn();
            ResultSet rs = conn.s.executeQuery("select * from driver");
            table.setModel(DbUtils.resultSetToTableModel(rs));  // Llena la tabla con los datos obtenidos del ResultSet
        } catch (Exception e1) {
            e1.printStackTrace();
        }

        // Botón "Submit" para filtrar la información según el tipo de carro seleccionado
        submit = new JButton("Submit");
        submit.setBounds(300, 520, 120, 30);
        submit.addActionListener(this);  // Añade un ActionListener para manejar los clics
        add(submit);

        // Botón "Back" para regresar a la pantalla anterior
        back = new JButton("Back");
        back.setBounds(500, 520, 120, 30);
        back.addActionListener(this);
        add(back);

        // Configuración de la ventana principal
        setBounds(300, 200, 1000, 600);
        setVisible(true);  // Hace visible la ventana
    }

    // Método que maneja los eventos de los botones
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == submit) {  // Si se presiona el botón "Submit"
            try {
                Conn conn = new Conn();  // Conexión a la base de datos
                String query = "select * from driver where model = '" + typeOfCar.getSelectedItem() + "'";  // Consulta filtrada por el modelo de auto seleccionado
                ResultSet rs = conn.s.executeQuery(query);
                table.setModel(DbUtils.resultSetToTableModel(rs));  // Actualiza la tabla con los resultados obtenidos
            } catch (Exception e1) {
                e1.printStackTrace();  // Manejo de excepciones
            }
        } else {  // Si se presiona el botón "Back"
            setVisible(false);  // Oculta la ventana actual
            new Reception();  // Abre la pantalla de recepción
        }
    }

    // Método principal para ejecutar la aplicación
    public static void main(String[] args) {
        new PickUp();  // Crea una nueva instancia de 'PickUp'
    }
}
