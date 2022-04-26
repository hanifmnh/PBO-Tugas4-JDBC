package jdbc;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Register extends JFrame {
    JLabel lUserR = new JLabel("Username");
    JTextField tfUserR = new JTextField();

    JLabel lPassR = new JLabel("Password");
    JPasswordField tfPassR = new JPasswordField();

    JLabel lRegister = new JLabel("Sudah memiliki akun?");
    JButton btnLoginR = new JButton("Login");
    JButton btnRegisterR = new JButton("Register");

    public Register() {
        setTitle("REGISTER FORM");
        setSize(400,200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
        setResizable(false);
        setLayout(null);

        add(lUserR);
        add(tfUserR);
        add(lPassR);
        add(tfPassR);
        add(lRegister);
        add(btnLoginR);
        add(btnRegisterR);

        lUserR.setBounds(80,25,120,25);
        lPassR.setBounds(80,50,120,25);
        lRegister.setBounds(80,125,150,25);

        tfUserR.setBounds(200,25,120,25);
        tfPassR.setBounds(200,50,120,25);

        btnLoginR.setBounds(220,125,103,25);
        btnRegisterR.setBounds(74,80,249,25);

        btnLoginR.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                try {
                    Login login = new Login();
                    System.out.println("Berhasil Terhubung Form Login!");
                    login.setVisible(true);
                } catch (Exception e){
                    System.out.println(e.getMessage());
                }
            }
        });

        btnRegisterR.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                Koneksi con = new Koneksi();
                String user = tfUserr.getText();
                String pass = String.valueOf(tfPassr.getPassword());
                if(!user.isEmpty() && !pass.isEmpty()){
                    con.insertData(user, pass);
                }
                else if(user.isEmpty() || pass.isEmpty()){
                    JOptionPane.showMessageDialog(null, "Tidak Boleh Kosong");
                }
            }

        });
    }
}
