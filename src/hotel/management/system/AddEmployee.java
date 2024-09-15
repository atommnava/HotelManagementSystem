/*
 * @brief La clase AddEmployee permite al usuario agregar información de empleados a la base de datos del sistema de gestión del hotel. 
 * Proporciona una interfaz gráfica para capturar detalles como nombre, edad, género, puesto de trabajo, salario, teléfono, correo electrónico y CURP.
 * @author Atom Alexander M. Nava
 * @date 25/09/24
 */

package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddEmployee extends JFrame implements ActionListener {
    // Componentes de la interfaz gráfica
    JTextField textFieldName, textFieldAge, textFieldSalary, textFieldPhone, textFieldEmail, textFieldCurp;
    JRadioButton radioButtonMale, radioButtonFemale;
    JComboBox comboBoxJob;
    JButton submit, cancel;

    // Constructor de la clase AddEmployee para configurar la interfaz gráfica
    AddEmployee() {
        super("Add Employee");
        setLayout(null);

        // Etiqueta y campo de texto para el nombre
        JLabel labelName = new JLabel("Name:");
        labelName.setBounds(60, 30, 120, 30);
        labelName.setFont(new Font("Tahoma", Font.PLAIN, 17));
        add(labelName);

        textFieldName = new JTextField();
        textFieldName.setBounds(200, 30, 150, 30);
        add(textFieldName);

        // Etiqueta y campo de texto para la edad
        JLabel labelAge = new JLabel("Age:");
        labelAge.setBounds(60, 80, 120, 30);
        labelAge.setFont(new Font("Tahoma", Font.PLAIN, 17));
        add(labelAge);

        textFieldAge = new JTextField();
        textFieldAge.setBounds(200, 80, 150, 30);
        add(textFieldAge);

        // Etiqueta y selección de género (RadioButtons)
        JLabel labelGender = new JLabel("Gender:");
        labelGender.setBounds(60, 130, 120, 30);
        labelGender.setFont(new Font("Tahoma", Font.PLAIN, 17));
        add(labelGender);

        radioButtonMale = new JRadioButton("Male");
        radioButtonMale.setBounds(200, 130, 70, 30);
        radioButtonMale.setFont(new Font("Tahoma", Font.PLAIN, 14));
        radioButtonMale.setBackground(Color.WHITE);
        add(radioButtonMale);

        radioButtonFemale = new JRadioButton("Female");
        radioButtonFemale.setBounds(280, 130, 140, 30);
        radioButtonFemale.setFont(new Font("Tahoma", Font.PLAIN, 14));
        radioButtonFemale.setBackground(Color.WHITE);
        add(radioButtonFemale);

        ButtonGroup buttonGroup = new ButtonGroup();
        buttonGroup.add(radioButtonMale);
        buttonGroup.add(radioButtonFemale);

        // Etiqueta y campo de selección para el trabajo
        JLabel labelJob = new JLabel("Job:");
        labelJob.setBounds(60, 180, 120, 30);
        labelJob.setFont(new Font("Tahoma", Font.PLAIN, 17));
        add(labelJob);

        String buffer[] = {"Front Desk Clerks", "Porters", "Housekeeping", "Kitchen Staff", "Room Service", "Chefs", "Waiter/Waitress", "Manager", "Accountant"};
        comboBoxJob = new JComboBox(buffer);
        comboBoxJob.setBounds(200, 180, 150, 30);
        comboBoxJob.setFont(new Font("Tahoma", Font.PLAIN, 14));
        comboBoxJob.setBackground(Color.WHITE);
        add(comboBoxJob);

        // Etiqueta y campo de texto para el salario
        JLabel labelSalary = new JLabel("Salary:");
        labelSalary.setBounds(60, 230, 120, 30);
        labelSalary.setFont(new Font("Tahoma", Font.PLAIN, 17));
        add(labelSalary);

        textFieldSalary = new JTextField();
        textFieldSalary.setBounds(200, 230, 150, 30);
        add(textFieldSalary);

        // Etiqueta y campo de texto para el teléfono
        JLabel labelPhone = new JLabel("Phone:");
        labelPhone.setBounds(60, 280, 120, 30);
        labelPhone.setFont(new Font("Tahoma", Font.PLAIN, 17));
        add(labelPhone);

        textFieldPhone = new JTextField();
        textFieldPhone.setBounds(200, 280, 150, 30);
        add(textFieldPhone);

        // Etiqueta y campo de texto para el correo electrónico
        JLabel labelEmail = new JLabel("Email:");
        labelEmail.setBounds(60, 330, 120, 30);
        labelEmail.setFont(new Font("Tahoma", Font.PLAIN, 17));
        add(labelEmail);

        textFieldEmail = new JTextField();
        textFieldEmail.setBounds(200, 330, 150, 30);
        add(textFieldEmail);

        // Etiqueta y campo de texto para el CURP
        JLabel labelCurp = new JLabel("Curp:");
        labelCurp.setBounds(60, 380, 120, 30);
        labelCurp.setFont(new Font("Tahoma", Font.PLAIN, 17));
        add(labelCurp);

        textFieldCurp = new JTextField();
        textFieldCurp.setBounds(200, 380, 150, 30);
        add(textFieldCurp);

        // Botón para enviar los datos
        submit = new JButton("Submit");
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.BLACK);
        submit.setBounds(200, 430, 150, 30);
        submit.addActionListener(this);
        add(submit);

        // Imagen decorativa
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons-hotel/tenth.jpg"));
        Image i2 = i1.getImage().getScaledInstance(450, 370, Image.SCALE_SMOOTH);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(380, 60, 450, 370);
        add(image);

        // Configuración de la ventana
        getContentPane().setBackground(Color.WHITE);
        setBounds(300, 200, 950, 540);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // Recopilación de datos ingresados por el usuario
        String tName = textFieldName.getText();
        String tAge = textFieldAge.getText();
        String tGender = null;
        String tSalary = textFieldSalary.getText();
        String tPhone = textFieldPhone.getText();
        String tEmail = textFieldEmail.getText();
        String tCurp = textFieldCurp.getText();

        // Validación básica de los campos
        if (tName.equals("")) {
            JOptionPane.showMessageDialog(null, "Fail to add employee");
            return;
        }

        // Determinar el género seleccionado
        if (radioButtonMale.isSelected()) {
            tGender = "Male";
        } else if (radioButtonFemale.isSelected()) {
            tGender = "Female";
        } else {
            tGender = "Other";
        }

        // Obtener el trabajo seleccionado
        String tJob = (String) comboBoxJob.getSelectedItem();

        try {
            // Insertar los datos del empleado en la base de datos
            Conn conn = new Conn();
            String query = "insert into employee values('" + tName + "', '" + tAge + "', '" + tGender + "', '" + tJob + "', '" + tSalary + "', '" + tPhone + "', '" + tEmail + "', '" + tCurp + "')";
            conn.s.executeUpdate(query);
            JOptionPane.showMessageDialog(null, "Employee Added Successfully");
            setVisible(false);
        } catch (Exception e1) {
            e1.printStackTrace();
        }
    }

    // Método principal para iniciar la aplicación
    public static void main(String[] args) {
        new AddEmployee();
    }
}
