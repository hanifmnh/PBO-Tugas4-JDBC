package jdbc;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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

        btnLoginL.setBounds(220,125,103,25);
        btnRegisterL.setBounds(74,80,249,25);

        btnLoginL.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                Koneksi con = new Koneksi();
                String user = tfUser.getText();
                if(con.cekUsername(user) && user != "" && con.cekLogin(user ,String.valueOf(tfPass.getPassword()))){
                    JOptionPane.showMessageDialog(null, "Login Success");
                }else if(user.isEmpty() || String.valueOf(tfPass.getPassword()).isEmpty()){
                    JOptionPane.showMessageDialog(null, "Field Tidak Boleh Kosong");
                }
                else if(!con.cekUsername(user)){
                    JOptionPane.showMessageDialog(null, "Username Salah");
                }
                else{
                    JOptionPane.showMessageDialog(null, "Password Salah");
                }
            }
        });

        btnRegisterL.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                try {
                    Register register = new Register();
                    System.out.println("Berhasil Terhubung Form Register!");
                    register.setVisible(true);
                } catch (Exception e){
                    System.out.println(e.getMessage());
                }
            }

        });
    }
}
