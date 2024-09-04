package hotel.management.system;

// Bibliotecas
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Login extends JFrame implements ActionListener {
    JTextField userName;
    JPasswordField password;
    JButton login, cancel;
    Login() {
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JLabel user = new JLabel("Username");
        user.setBounds(40,20,100,20);
        add(user);

        userName = new JTextField();
        userName.setBounds(150,20,150,30);
        add(userName);

        JLabel pass = new JLabel("Password");
        pass.setBounds(40,70,100,20);
        add(pass);

        password = new JPasswordField();
        password.setBounds(150,70,150,30);
        add(password);

        login = new JButton("Login");
        login.setBounds(40,150,120,30);
        login.setBackground(Color.BLACK);
        login.setForeground(Color.BLACK);
        login.addActionListener(this);
        add(login);

        cancel = new JButton("Cancel");
        cancel.setBounds(180,150,120,30);
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.BLACK);
        cancel.addActionListener(this);
        add(cancel);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons-hotel/second.jpg"));
        Image i2 = i1.getImage().getScaledInstance(200,200, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(350,10,200,200);
        add(image);

        setBounds(500,200,600,300);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == login) {
            String tUsername = userName.getText();
            String tPassword = password.getText();
            try {
                Conn conn = new Conn();
                String query = "select * from login where username = '" + tUsername + "' and password = '" + tPassword + "'";
                ResultSet rs = conn.s.executeQuery(query);

                if (rs.next()) {
                    setVisible(false);
                    new Databoard().setVisible(true);
                } else {
                    JOptionPane.showMessageDialog(null, "Invalid Username or Password");
                    setVisible(false);
                }
            } catch (Exception e1) {
                e1.printStackTrace();
            }
        } else if (e.getSource() == cancel) {
            setVisible(false);
        }
    }
    public static void main(String[] args) {
        new Login();
    }

}


