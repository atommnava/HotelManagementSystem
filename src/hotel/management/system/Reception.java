package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Reception extends JFrame implements ActionListener {  // La clase hereda de JFrame e implementa ActionListener
    JButton add, roomNo, department, allEmployee, customers, managerInfo, search,
            pickUp, update, updateRoom, checkout, logout;  // Botones para diferentes funcionalidades

    public Reception() {  // Constructor de la clase
        getContentPane().setBackground(Color.WHITE);  // Establece el fondo de la ventana a color blanco
        setLayout(null);  // Desactiva el layout predeterminado para usar posiciones absolutas

        // Botón para "New Customer Form"
        add = new JButton("New Customer Form");
        add.setBounds(10, 30, 200, 30);  // Establece la posición y el tamaño del botón
        add.setForeground(Color.BLACK);  // Color del texto del botón
        add.setBackground(Color.WHITE);  // Color de fondo del botón
        add.addActionListener(this);  // Añade un ActionListener para manejar el clic
        add(add);

        // Botón para "Rooms"
        roomNo = new JButton("Rooms");
        roomNo.setBounds(10, 70, 200, 30);
        roomNo.setForeground(Color.BLACK);
        roomNo.setBackground(Color.WHITE);
        roomNo.addActionListener(this);
        add(roomNo);

        // Botón para "Department"
        department = new JButton("Department");
        department.setBounds(10, 110, 200, 30);
        department.setForeground(Color.BLACK);
        department.setBackground(Color.WHITE);
        department.addActionListener(this);
        add(department);

        // Botón para "Employee Info"
        allEmployee = new JButton("Employee Info");
        allEmployee.setBounds(10, 150, 200, 30);
        allEmployee.setForeground(Color.BLACK);
        allEmployee.setBackground(Color.WHITE);
        allEmployee.addActionListener(this);
        add(allEmployee);

        // Botón para "Customer Info"
        customers = new JButton("Customer Info");
        customers.setBounds(10, 190, 200, 30);
        customers.setForeground(Color.BLACK);
        customers.setBackground(Color.WHITE);
        customers.addActionListener(this);
        add(customers);

        // Botón para "Manager Info"
        managerInfo = new JButton("Manager Info");
        managerInfo.setBounds(10, 230, 200, 30);
        managerInfo.setForeground(Color.BLACK);
        managerInfo.setBackground(Color.WHITE);
        managerInfo.addActionListener(this);
        add(managerInfo);

        // Botón para "Checkout"
        checkout = new JButton("Checkout");
        checkout.setBounds(10, 270, 200, 30);
        checkout.setForeground(Color.BLACK);
        checkout.setBackground(Color.WHITE);
        checkout.addActionListener(this);
        add(checkout);

        // Botón para "Update Status"
        update = new JButton("Update Status");
        update.setBounds(10, 310, 200, 30);
        update.setForeground(Color.BLACK);
        update.setBackground(Color.WHITE);
        update.addActionListener(this);
        add(update);

        // Botón para "Update Room Status"
        updateRoom = new JButton("Update Room Status");
        updateRoom.setBounds(10, 350, 200, 30);
        updateRoom.setForeground(Color.BLACK);
        updateRoom.setBackground(Color.WHITE);
        updateRoom.addActionListener(this);
        add(updateRoom);

        // Botón para "Pickup Service"
        pickUp = new JButton("Pickup Service");
        pickUp.setBounds(10, 390, 200, 30);
        pickUp.setForeground(Color.BLACK);
        pickUp.setBackground(Color.WHITE);
        pickUp.addActionListener(this);
        add(pickUp);

        // Botón para "Search Room"
        search = new JButton("Search Room");
        search.setBounds(10, 430, 200, 30);
        search.setForeground(Color.BLACK);
        search.setBackground(Color.WHITE);
        search.addActionListener(this);
        add(search);

        // Botón para "Logout"
        logout = new JButton("Logout");
        logout.setBounds(10, 470, 200, 30);
        logout.setForeground(Color.BLUE);  // Color del texto en azul para destacar
        logout.setBackground(Color.WHITE);
        logout.addActionListener(this);
        add(logout);

        // Imagen en la ventana
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons-hotel/fourth.jpg"));
        JLabel image = new JLabel(i1);
        image.setBounds(250, 30, 500, 470);  // Establece la posición y tamaño de la imagen
        add(image);

        // Configuración de la ventana principal
        setBounds(350, 200, 800, 570);
        setVisible(true);  // Hace visible la ventana
    }

    // Método para manejar los eventos de los botones
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == add) {  // Si se presiona el botón "New Customer Form"
            setVisible(false);  // Oculta la ventana actual
            new AddCustomer();  // Abre la ventana "AddCustomer"
        } else if (e.getSource() == roomNo) {  // Si se presiona el botón "Rooms"
            setVisible(false);
            new Room();
        } else if (e.getSource() == department) {  // Si se presiona el botón "Department"
            setVisible(false);
            new Department();
        } else if (e.getSource() == allEmployee) {  // Si se presiona el botón "Employee Info"
            setVisible(false);
            new EmployeeInfo();
        } else if (e.getSource() == customers) {  // Si se presiona el botón "Customer Info"
            setVisible(false);
            new CustomerInfo();
        } else if (e.getSource() == managerInfo) {  // Si se presiona el botón "Manager Info"
            setVisible(false);
            new ManagerInfo();
        } else if (e.getSource() == search) {  // Si se presiona el botón "Search Room"
            setVisible(false);
            new SearchRoom();
        } else if (e.getSource() == update) {  // Si se presiona el botón "Update Status"
            setVisible(false);
            new UpdateCheck();
        } else if (e.getSource() == updateRoom) {  // Si se presiona el botón "Update Room Status"
            setVisible(false);
            new UpdateRoom();
        } else if (e.getSource() == pickUp) {  // Si se presiona el botón "Pickup Service"
            setVisible(false);
            new PickUp();
        } else if (e.getSource() == checkout) {  // Si se presiona el botón "Checkout"
            setVisible(false);
            new Checkout();
        } else if (e.getSource() == logout) {  // Si se presiona el botón "Logout"
            setVisible(false);  // Oculta la ventana actual
            System.exit(0);  // Cierra el programa
        }
    }

    // Método principal para ejecutar la aplicación
    public static void main(String[] args) {
        new Reception();  // Crea una nueva instancia de 'Reception'
    }
}
