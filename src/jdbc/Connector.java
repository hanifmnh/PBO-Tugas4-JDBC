package jdbc;
import java.sql.*;

public class Connector {
    String url      = "jdbc:mysql://localhost/tugasjdbc?serverTimezone=UTC";
    String username = "root";
    String password = "";
    Connection connect;
    Statement statement;

    public Connector() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connect = DriverManager.getConnection(url,username,password);
            System.out.println("Koneksi Berhasil");
        } catch(Exception e) {
            System.out.println("Koneksi gagal, " + e.getMessage());
        }
    }
}
