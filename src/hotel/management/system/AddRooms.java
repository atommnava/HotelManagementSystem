/*
 * @brief La clase AddRooms permite al usuario agregar información de habitaciones al sistema de gestión del hotel.
 * Proporciona una interfaz gráfica para capturar detalles como número de habitación, disponibilidad, estado de limpieza, precio y tipo de cama.
 * @author Atom Alexander
 * @date 25/09/24
 */

package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddRooms extends JFrame implements ActionListener {
    // Componentes de la interfaz gráfica
    JButton add, cancel;
    JTextField tRoom, tPrice;
    JComboBox cleanCombo, typeCombo, availableCombo;

    // Constructor de la clase AddRooms para configurar la interfaz gráfica
    AddRooms() {
        super("Add Rooms");
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        // Etiqueta para el encabezado
        JLabel heading = new JLabel("Add Rooms:");
        heading.setFont(new Font("Tahoma", Font.BOLD, 18));
        heading.setBounds(150, 20, 200, 20);
        add(heading);

        // Etiqueta y campo de texto para el número de habitación
        JLabel roomNo = new JLabel("Room No:");
        roomNo.setFont(new Font("Tahoma", Font.BOLD, 18));
        roomNo.setBounds(60, 80, 120, 30);
        add(roomNo);

        tRoom = new JTextField();
        tRoom.setBounds(200, 80, 150, 30);
        add(tRoom);

        // Etiqueta y ComboBox para la disponibilidad de la habitación
        JLabel available = new JLabel("Available:");
        available.setFont(new Font("Tahoma", Font.BOLD, 18));
        available.setBounds(60, 130, 120, 30);
        add(available);

        String availableOptions[] = {"Available", "Occupied"};
        availableCombo = new JComboBox(availableOptions);
        availableCombo.setBounds(200, 130, 150, 30);
        availableCombo.setBackground(Color.WHITE);
        add(availableCombo);

        // Etiqueta y ComboBox para el estado de limpieza
        JLabel clean = new JLabel("Cleaning Status:");
        clean.setFont(new Font("Tahoma", Font.BOLD, 18));
        clean.setBounds(60, 180, 120, 30);
        add(clean);

        String cleanOptions[] = {"Cleaned", "Dirty"};
        cleanCombo = new JComboBox(cleanOptions);
        cleanCombo.setBounds(200, 180, 150, 30);
        cleanCombo.setBackground(Color.WHITE);
        add(cleanCombo);

        // Etiqueta y campo de texto para el precio
        JLabel price = new JLabel("Price:");
        price.setFont(new Font("Tahoma", Font.BOLD, 18));
        price.setBounds(60, 230, 120, 30);
        add(price);

        tPrice = new JTextField();
        tPrice.setBounds(200, 230, 150, 30);
        add(tPrice);

        // Etiqueta y ComboBox para el tipo de cama
        JLabel type = new JLabel("Bed Type:");
        type.setFont(new Font("Tahoma", Font.BOLD, 18));
        type.setBounds(60, 280, 120, 30);
        add(type);

        String typeOptions[] = {"Single Bed", "Double Bed"};
        typeCombo = new JComboBox(typeOptions);
        typeCombo.setBounds(200, 280, 150, 30);
        typeCombo.setBackground(Color.WHITE);
        add(typeCombo);

        // Botón para agregar la habitación
        add = new JButton("Add Room");
        add.setForeground(Color.BLACK);
        add.setBackground(Color.WHITE);
        add.setBounds(60, 350, 130, 30);
        add.addActionListener(this);
        add(add);

        // Botón para cancelar la operación
        cancel = new JButton("Cancel");
        cancel.setForeground(Color.RED);
        cancel.setBackground(Color.WHITE);
        cancel.setBounds(220, 350, 130, 30);
        cancel.addActionListener(this);
        add(cancel);

        // Imagen decorativa
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons-hotel/twelve.jpg"));
        JLabel image = new JLabel(i1);
        image.setBounds(400, 30, 500, 300);
        add(image);

        // Configuración de la ventana
        setBounds(330, 200, 940, 470);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == add) {
            // Recopilación de datos ingresados por el usuario
            String tfRoom = tRoom.getText();
            String tfAvailability = (String) availableCombo.getSelectedItem();
            String tfCleaned = (String) cleanCombo.getSelectedItem();
            String tfPrice = tPrice.getText();
            String tfType = (String) typeCombo.getSelectedItem();

            try {
                // Inserta los datos de la habitación en la base de datos
                Conn conn = new Conn();
                String query = "insert into room values('" + tfRoom + "', '" + tfAvailability + "', '" + tfCleaned + "', '" + tfPrice + "', '" + tfType + "')";
                conn.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Room Added Successfully");
                setVisible(false);
            } catch (Exception e1) {
                e1.printStackTrace();
            }
        } else {
            // Cierra la ventana si se presiona "Cancel"
            setVisible(false);
        }
    }

    // Método principal para iniciar la aplicación
    public static void main(String[] args) {
        new AddRooms();
    }
}
