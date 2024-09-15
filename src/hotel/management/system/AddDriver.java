/*
 * @brief La clase AddDriver representa la interfaz gráfica para agregar un nuevo conductor al sistema de gestión del hotel. 
 * Esta clase permite capturar detalles como nombre, edad, género, compañía, modelo de auto, disponibilidad y ubicación del conductor. 
 * Incluye la funcionalidad para agregar el conductor a la base de datos.
 * @author Atom Alexander M. Nava
 * @date 25/09/24
 */

package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddDriver extends JFrame implements ActionListener {
    // Declaración de componentes de la interfaz gráfica
    JButton add, cancel;
    JTextField tName, tAge, tCompany, tModel, tLocation;
    JComboBox genderCombo, typeCombo, availableCombo;

    // Constructor de la clase AddDriver para inicializar la interfaz gráfica
    AddDriver() {
        super("Add Drivers");
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        // Configuración y adición del título
        JLabel heading = new JLabel("Add Drivers:");
        heading.setFont(new Font("Tahoma", Font.BOLD, 18));
        heading.setBounds(150, 10, 200, 20);
        add(heading);

        // Configuración y adición del campo para el nombre
        JLabel roomNo = new JLabel("Name:");
        roomNo.setFont(new Font("Tahoma", Font.BOLD, 18));
        roomNo.setBounds(60, 70, 120, 30);
        add(roomNo);

        tName = new JTextField();
        tName.setBounds(200, 80, 150, 30);
        add(tName);

        // Configuración y adición del campo para la edad
        JLabel labelAge = new JLabel("Age:");
        labelAge.setFont(new Font("Tahoma", Font.BOLD, 18));
        labelAge.setBounds(60, 110, 120, 30);
        add(labelAge);

        tAge = new JTextField();
        tAge.setBounds(200, 110, 150, 30);
        add(tAge);

        // Configuración y adición de la selección de género
        JLabel clean = new JLabel("Gender:");
        clean.setFont(new Font("Tahoma", Font.BOLD, 18));
        clean.setBounds(60, 150, 120, 30);
        add(clean);

        String cleanOptions[] = {"Male", "Female"};
        genderCombo = new JComboBox(cleanOptions);
        genderCombo.setBounds(200, 150, 150, 30);
        genderCombo.setBackground(Color.WHITE);
        add(genderCombo);

        // Configuración y adición del campo para la compañía
        JLabel price = new JLabel("Company:");
        price.setFont(new Font("Tahoma", Font.BOLD, 18));
        price.setBounds(60, 190, 120, 30);
        add(price);

        tCompany = new JTextField();
        tCompany.setBounds(200, 190, 150, 30);
        add(tCompany);

        // Configuración y adición del campo para el modelo de coche
        JLabel type = new JLabel("Car Model:");
        type.setFont(new Font("Tahoma", Font.BOLD, 18));
        type.setBounds(60, 230, 120, 30);
        add(type);

        tModel = new JTextField();
        tModel.setBounds(200, 230, 150, 30);
        add(tModel);

        // Configuración y adición de la selección de disponibilidad
        JLabel labelAvailable = new JLabel("Available:");
        labelAvailable.setFont(new Font("Tahoma", Font.BOLD, 18));
        labelAvailable.setBounds(60, 270, 120, 30);
        add(labelAvailable);

        String driverOptions[] = {"Available", "Occupied"};
        availableCombo = new JComboBox(driverOptions);
        availableCombo.setBounds(200, 270, 150, 30);
        availableCombo.setBackground(Color.WHITE);
        add(availableCombo);

        // Configuración y adición del campo para la ubicación
        JLabel labelLocation = new JLabel("Location:");
        labelLocation.setFont(new Font("Tahoma", Font.BOLD, 18));
        labelLocation.setBounds(60, 310, 120, 30);
        add(labelLocation);

        tLocation = new JTextField();
        tLocation.setBounds(200, 310, 150, 30);
        add(tLocation);

        // Configuración y adición de los botones "Add Driver" y "Cancel"
        add = new JButton("Add Driver");
        add.setForeground(Color.BLACK);
        add.setBackground(Color.WHITE);
        add.setBounds(60, 370, 130, 30);
        add.addActionListener(this);
        add(add);

        cancel = new JButton("Cancel");
        cancel.setForeground(Color.RED);
        cancel.setBackground(Color.WHITE);
        cancel.setBounds(220, 370, 130, 30);
        cancel.addActionListener(this);
        add(cancel);

        // Adición de imagen de fondo
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons-hotel/eleven.jpg"));
        Image i2 = i1.getImage().getScaledInstance(120, 120, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i1);
        image.setBounds(400, 30, 500, 300);
        add(image);

        // Configuración de la ventana
        setBounds(300, 200, 980, 470);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // Lógica para el botón "Add Driver"
        if (e.getSource() == add) {
            String toName = tName.getText();
            String toAge = tAge.getText();
            String toGender = (String) genderCombo.getSelectedItem();
            String toCompany = tCompany.getText();
            String toModel = tModel.getText();
            String toAvailable = (String) availableCombo.getSelectedItem();
            String toLocation = tLocation.getText();
            try {
                // Inserción de datos del conductor en la base de datos
                Conn conn = new Conn();
                String query = "insert into driver values('" + toName + "', '" + toAge + "', '" + toGender + "', '" + toCompany + "', '" + toModel + "'" +
                        ", '" + toAvailable + "', '" + toLocation + "')";
                conn.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "New Driver added Successfully");
                setVisible(false);
            } catch (Exception e1) {
                e1.printStackTrace();
            }
        } else {
            // Lógica para el botón "Cancel"
            setVisible(false);
        }
    }

    // Método principal para iniciar la aplicación
    public static void main(String[] args) {
        new AddDriver();
    }
}
