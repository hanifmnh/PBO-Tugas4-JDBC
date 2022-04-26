package jdbc;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class Login extends JFrame {
    JLabel lUserL = new JLabel("Username");
    JTextField tfUserL = new JTextField();

    JLabel lPassL = new JLabel("Password");
    JPasswordField tfPassL = new JPasswordField();

    JLabel lLogin = new JLabel("Belum memiliki akun?");
    JButton btnLoginL = new JButton("Login");
    JButton btnRegisterL = new JButton("Register");

    public Login() {
        setTitle("LOGIN FORM");
        setSize(400,200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
        setResizable(false);
        setLayout(null);

        add(lUserL);
        add(tfUserL);
        add(lPassL);
        add(tfPassL);
        add(lLogin);
        add(btnLoginL);
        add(btnRegisterL);

        lUserL.setBounds(80,25,120,25);
        lPassL.setBounds(80,50,120,25);
        lLogin.setBounds(80,125,150,25);

        tfUserL.setBounds(200,25,120,25);
        tfPassL.setBounds(200,50,120,25);

        btnLoginL.setBounds(74,80,249,25);
        btnRegisterL.setBounds(220,125,103,25);

        btnLoginL.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                Connector conn = new Connector();
                try {
                    String query = "SELECT * FROM users WHERE username = '" + getUsername() + "' AND password = '" + getPassword() + "'";
                    conn.statement = conn.connect.createStatement();
                    ResultSet resultSet = conn.statement.executeQuery(query);

                    if (resultSet.next()){
                        JOptionPane.showMessageDialog(null, "Login Berhasil");
                    }
                    else{
                        JOptionPane.showMessageDialog(null, "Login Gagal! Silahkan Coba Lagi");
                        tfPassL.requestFocus();
                    }
                } catch (SQLException e) {
                    System.out.println("Error");
                }
            }
        });

        btnRegisterL.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                Register register = new Register();
            }
        });
    }

    public String getUsername() {
        return tfUserL.getText();
    }

    public String getPassword() {
        return tfPassL.getText();
    }
}
