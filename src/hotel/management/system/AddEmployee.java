package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class AddEmployee extends JFrame implements ActionListener {
    JTextField textFieldName, textFieldAge, textFieldSalary, textFieldPhone, textFieldEmail, textFieldCurp;
    JRadioButton radioButtonMale, radioButtonFemale;
    JComboBox comboBoxJob;
    JButton submit;
    AddEmployee() {
        super("Add Employee");
        setLayout(null);

        JLabel labelName = new JLabel("Name:");
        labelName.setBounds(60,30,120,30);
        labelName.setFont(new Font("Tahoma", Font.PLAIN, 17));
        add(labelName);

        textFieldName = new JTextField();
        textFieldName.setBounds(200,30,150,30);
        add(textFieldName);

        JLabel labelAge = new JLabel("Age:");
        labelAge.setBounds(60,80,120,30);
        labelAge.setFont(new Font("Tahoma", Font.PLAIN, 17));
        add(labelAge);

        textFieldAge = new JTextField();
        textFieldAge.setBounds(200,80,150,30);
        add(textFieldAge);

        JLabel labelGender = new JLabel("Gender:");
        labelGender.setBounds(60,130,120,30);
        labelGender.setFont(new Font("Tahoma", Font.PLAIN, 17));
        add(labelGender);

        radioButtonMale = new JRadioButton("Male");
        radioButtonMale.setBounds(200,130,70,30);
        radioButtonMale.setFont(new Font("Tahoma", Font.PLAIN, 14));
        radioButtonMale.setBackground(Color.WHITE);
        add(radioButtonMale);

        radioButtonFemale = new JRadioButton("Female");
        radioButtonFemale.setBounds(280,130,140,30);
        radioButtonFemale.setFont(new Font("Tahoma", Font.PLAIN, 14));
        radioButtonFemale.setBackground(Color.WHITE);
        add(radioButtonFemale);

        ButtonGroup buttonGroup = new ButtonGroup();
        buttonGroup.add(radioButtonMale);
        buttonGroup.add(radioButtonFemale);

        JLabel labelJob = new JLabel("Job:");
        labelJob.setBounds(60,180,120,30);
        labelJob.setFont(new Font("Tahoma", Font.PLAIN, 17));
        add(labelJob);

        String buffer[] = {"Front Desk Clerks", "Porters", "Housekeeping", "" +
                "Kitchen Staff", "Room Service", "Chefs", "Waiter/Waitress", "Manager",
                        "Accountant"};
        comboBoxJob = new JComboBox(buffer);
        comboBoxJob.setBounds(200,180,150,30);
        comboBoxJob.setFont(new Font("Tahoma", Font.PLAIN, 14));
        comboBoxJob.setBackground(Color.WHITE);
        add(comboBoxJob);

        JLabel labelSalary = new JLabel("Salary:");
        labelSalary.setBounds(60,230,120,30);
        labelSalary.setFont(new Font("Tahoma", Font.PLAIN, 17));
        add(labelSalary);

        textFieldSalary = new JTextField();
        textFieldSalary.setBounds(200,230,150,30);
        add(textFieldSalary);

        JLabel labelPhone = new JLabel("Phone:");
        labelPhone.setBounds(60,280,120,30);
        labelPhone.setFont(new Font("Tahoma", Font.PLAIN, 17));
        add(labelPhone);

        textFieldPhone = new JTextField();
        textFieldPhone.setBounds(200,280,150,30);
        add(textFieldPhone);

        JLabel labelEmail = new JLabel("Email:");
        labelEmail.setBounds(60,330,120,30);
        labelEmail.setFont(new Font("Tahoma", Font.PLAIN, 17));
        add(labelEmail);

        textFieldEmail = new JTextField();
        textFieldEmail.setBounds(200,330,150,30);
        add(textFieldEmail);

        JLabel labelCurp = new JLabel("Curp:");
        labelCurp.setBounds(60,380,120,30);
        labelCurp.setFont(new Font("Tahoma", Font.PLAIN, 17));
        add(labelCurp);

        textFieldCurp = new JTextField();
        textFieldCurp.setBounds(200,380,150,30);
        add(textFieldCurp);

        submit = new JButton("Submit");
        submit.setBackground(Color.black);
        submit.setForeground(Color.black);
        submit.setBounds(200,430,150,30);
        submit.addActionListener(this);
        add(submit);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons-hotel/tenth.jpg"));
        Image i2 = i1.getImage().getScaledInstance(450, 370, Image.SCALE_SMOOTH);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(380,60,450,370);
        add(image);

        getContentPane().setBackground(Color.WHITE);
        setBounds(300,200,950,540);
        setVisible(true);

    }
    @Override
    public void actionPerformed(ActionEvent e) {
        String tName = textFieldName.getText();
        String tAge = textFieldAge.getText();
        String tGender = null;
        String tSalary = textFieldSalary.getText();
        String tPhone = textFieldPhone.getText();
        String tEmail = textFieldEmail.getText();
        String tCurp = textFieldCurp.getText();

        // email.equals("") && contains("@) && includes (".com").
        if (tName.equals("")) {
            JOptionPane.showMessageDialog(null, "Please Enter Name");
            return;
        }
        if (radioButtonMale.isSelected()) {
            tGender = "Male";
        } else if (radioButtonFemale.isSelected()) {
            tGender = "Female";
        } else {
            tGender = "Other";
        }
        String tJob = (String)comboBoxJob.getSelectedItem();
        try {
            Conn conn = new Conn();
            String query = "insert into employee values('" + tName + "', '" + tAge + "', '" + tGender + "', " +
                    "'" + tJob + "', '" + tSalary + "', '" + tPhone + "', '" + tEmail + "', '" + tCurp + "')";
            conn.s.executeUpdate(query);
            JOptionPane.showMessageDialog(null, "Employee Added Successfully");
            setVisible(false);

        } catch (Exception e1) {
            e1.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new AddEmployee();
    }
}
