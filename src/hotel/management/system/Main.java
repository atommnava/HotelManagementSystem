package hotel.management.system;

// Bibliotecas
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main extends JFrame implements ActionListener {
    JButton next;
    JLabel text;

    Main() {
        setBounds(100, 100, 1366, 565);
        setLayout(null);

        // Cargar y añadir la imagen de fondo
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons-hotel/first.jpg"));
        JLabel image = new JLabel(i1);
        image.setBounds(0, 0, 1366, 565);
        add(image);

        // Crear y añadir el texto
        text = new JLabel("HOTEL MANAGEMENT SYSTEM");
        text.setBounds(20, 430, 1000, 90);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("Serif", Font.PLAIN, 45));
        image.add(text);

        // Botón "Next"
        next = new JButton("Next");
        next.setBounds(1150, 450, 150, 40);
        next.setFocusable(false);
        next.setBackground(Color.WHITE);
        next.setForeground(Color.BLACK);
        next.addActionListener(this);
        image.add(next);

        setVisible(true);

        // Hilo para hacer parpadear el texto
        new Thread(() -> {
            try {
                while (true) {
                    text.setVisible(false);
                    Thread.sleep(500);
                    text.setVisible(true);
                    Thread.sleep(500);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }).start();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        setVisible(false);
        new Login();
    }

    public static void main(String[] args) {
        new Main();
    }
}
