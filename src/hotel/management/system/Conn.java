package hotel.management.system;

import java.sql.*;

public class Conn {
    // Atributos para la conexión y la ejecución de consultas SQL
    Statement s;
    Connection c;

    // Constructor para inicializar la conexión con la base de datos
    Conn() {
        try {
            // Establece la conexión con la base de datos
            c = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotelmanagementsystem", "root", "tu_contrasena");
            
            // Crea un Statement para ejecutar consultas SQL
            s = c.createStatement();
        } catch (Exception e) {
            // Imprime cualquier excepción que ocurra durante la conexión
            e.printStackTrace();
        }
    }
}
