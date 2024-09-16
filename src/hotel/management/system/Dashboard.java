package hotel.management.system;

// Importando las bibliotecas necesarias
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Dashboard extends JFrame implements ActionListener {

    // Constructor para la ventana Dashboard
    Dashboard() {
        // Estableciendo tamaño y diseño de la ventana
        setBounds(0, 0, 1550, 1000);
        setLayout(null);

        // Añadiendo una imagen de fondo
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons-hotel/third.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1550, 1000, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 1550, 1000);
        add(image);

        // Añadiendo texto de bienvenida sobre la imagen de fondo
        JLabel text = new JLabel("THE TAJ GROUP WELCOMES YOU");
        text.setBounds(400, 80, 1000, 50);
        text.setFont(new Font("Times New Roman", Font.PLAIN, 46));
        text.setForeground(Color.WHITE);
        image.add(text);

        // Creando la barra de menú
        JMenuBar menuBar = new JMenuBar();
        menuBar.setBounds(0, 0, 1550, 30);
        image.add(menuBar);

        // Menú "HOTEL MANAGEMENT"
        JMenu hotel = new JMenu("HOTEL MANAGEMENT");
        hotel.setForeground(Color.RED);
        menuBar.add(hotel);

        // Opción "RECEPTION" en el menú "HOTEL MANAGEMENT"
        JMenuItem reception = new JMenuItem("RECEPTION");
        reception.addActionListener(this);
        hotel.add(reception);

        // Menú "ADMIN"
        JMenu admin = new JMenu("ADMIN");
        admin.setForeground(Color.BLUE);
        menuBar.add(admin);

        // Opción "ADD EMPLOYEE" en el menú "ADMIN"
        JMenuItem addEmployee = new JMenuItem("ADD EMPLOYEE");
        addEmployee.addActionListener(this);
        admin.add(addEmployee);

        // Opción "ADD ROOM" en el menú "ADMIN"
        JMenuItem addRoom = new JMenuItem("ADD ROOM");
        addRoom.addActionListener(this);
        admin.add(addRoom);

        // Opción "ADD DRIVER" en el menú "ADMIN"
        JMenuItem addDrives = new JMenuItem("ADD DRIVER");
        addDrives.addActionListener(this);
        admin.add(addDrives);

        // Hacer visible la ventana
        setVisible(true);
    }

    // Método para manejar las acciones de los elementos del menú
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("ADD EMPLOYEE")) {
            new AddEmployee();
        } else if (e.getActionCommand().equals("ADD ROOM")) {
            new AddRooms();
        } else if (e.getActionCommand().equals("ADD DRIVER")) {
            new AddDriver();
        } else if (e.getActionCommand().equals("RECEPTION")) {
            new Reception();
        }
    }

    // Método principal
    public static void main(String[] args) {
        new Dashboard(); // Creando la instancia de Dashboard
    }
}
