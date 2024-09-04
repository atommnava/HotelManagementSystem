package hotel.management.system;

import java.sql.*;

public class Conn {
    //Connection c;
    Statement s;
    Connection c;
    Conn(){
        try {
            // Class.forName("com.mysql.cj.jbdc.Driver");
            c = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotelmanagementsystem","root","12345678");
            s = c.createStatement();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
