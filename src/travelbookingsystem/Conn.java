
package travelbookingsystem;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Conn implements AutoCloseable {
    Connection c;
    Statement s;

    public Conn() {
        try {
            c = DriverManager.getConnection("jdbc:mysql:///travel_management_sytem", "root", "Your_password");
            s = c.createStatement();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    @Override
    public void close() {
        try {
            if (s != null) s.close();
            if (c != null) c.close();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
}
