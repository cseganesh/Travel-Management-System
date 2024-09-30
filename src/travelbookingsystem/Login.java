package travelbookingsystem;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public class Login extends JFrame implements ActionListener {

    private JPanel panel;
    private JTextField textField;
    private JPasswordField passwordField;
    private JButton b1, b2, b3;

    public Login() {

        setTitle("Login - Travel Booking System");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(450, 200, 750, 450);

        panel = new JPanel();
        panel.setBackground(new Color(240, 248, 255)); // Light blue background
        setContentPane(panel);
        panel.setLayout(null);

        // Username Label
        JLabel l1 = new JLabel("Username:");
        l1.setFont(new Font("Tahoma", Font.BOLD, 16)); // Increased font size
        l1.setBounds(150, 100, 120, 30);
        panel.add(l1);

        // Password Label
        JLabel l2 = new JLabel("Password:");
        l2.setFont(new Font("Tahoma", Font.BOLD, 16)); // Increased font size
        l2.setBounds(150, 150, 120, 30);
        panel.add(l2);

        // Username TextField
        textField = new JTextField();
        textField.setBounds(300, 100, 250, 30); // Increased width and height
        textField.setFont(new Font("Tahoma", Font.PLAIN, 14)); // Set font size
        textField.setBorder(BorderFactory.createLineBorder(new Color(173, 216, 230), 2));
        panel.add(textField);

        // Password Field
        passwordField = new JPasswordField();
        passwordField.setBounds(300, 150, 250, 30); // Increased width and height
        passwordField.setFont(new Font("Tahoma", Font.PLAIN, 14)); // Set font size
        passwordField.setBorder(BorderFactory.createLineBorder(new Color(173, 216, 230), 2));
        panel.add(passwordField);

        // Image icon
        ImageIcon c1 = new ImageIcon(ClassLoader.getSystemResource("icons/login.png"));
        Image i1 = c1.getImage().getScaledInstance(150, 150, Image.SCALE_DEFAULT);
        ImageIcon i2 = new ImageIcon(i1);

        JLabel l6 = new JLabel(i2);
        l6.setBounds(580, 70, 150, 150);
        panel.add(l6);

        // Login Button
        b1 = new JButton("Login");
        b1.setFont(new Font("Tahoma", Font.BOLD, 14));
        b1.setForeground(Color.WHITE);
        b1.setBackground(new Color(34, 139, 34)); // Dark green color
        b1.setBounds(150, 220, 130, 35); // Adjusted size
        b1.addActionListener(this);
        b1.setFocusPainted(false);
        panel.add(b1);

        // SignUp Button
        b2 = new JButton("Sign Up");
        b2.setFont(new Font("Tahoma", Font.BOLD, 14));
        b2.setForeground(Color.WHITE);
        b2.setBackground(new Color(255, 140, 0)); // Dark orange color
        b2.setBounds(320, 220, 130, 35); // Adjusted size
        b2.addActionListener(this);
        b2.setFocusPainted(false);
        panel.add(b2);

        // Forgot Password Button
        b3 = new JButton("Forgot Password");
        b3.setFont(new Font("Tahoma", Font.BOLD, 14));
        b3.setForeground(Color.WHITE);
        b3.setBackground(new Color(178, 34, 34)); // Firebrick color
        b3.setBounds(230, 280, 180, 35); // Adjusted size
        b3.addActionListener(this);
        b3.setFocusPainted(false);
        panel.add(b3);

        // Trouble in Login Label
        JLabel l5 = new JLabel("Trouble logging in?");
        l5.setFont(new Font("Tahoma", Font.PLAIN, 14));
        l5.setForeground(new Color(255, 0, 0)); // Red color
        l5.setBounds(50, 290, 150, 20);
        panel.add(l5);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == b1) {
            // Get the username and password
            String username = textField.getText().trim();
            String password = new String(passwordField.getPassword()).trim();

            // Check if fields are empty
            if (username.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Please enter your username.", "Input Error", JOptionPane.ERROR_MESSAGE);
                textField.requestFocus(); // Set focus back to username field
                return;
            }

            if (password.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Please enter your password.", "Input Error", JOptionPane.ERROR_MESSAGE);
                passwordField.requestFocus(); // Set focus back to password field
                return;
            }

            // Proceed to check credentials
            try {
                Conn con = new Conn();
                String sql = "select * from account where username=? and password=?";
                PreparedStatement st = con.c.prepareStatement(sql);

                st.setString(1, username);
                st.setString(2, password);

                ResultSet rs = st.executeQuery();
                if (rs.next()) {
                    this.setVisible(false);
                    new Loading(username).setVisible(true);
                } else {
                    JOptionPane.showMessageDialog(null, "Invalid Username or Password!", "Login Error", JOptionPane.ERROR_MESSAGE);
                }

            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        if (ae.getSource() == b2) {
            setVisible(false);
            Signup su = new Signup();
            su.setVisible(true);
        }
        if (ae.getSource() == b3) {
            setVisible(false);
            ForgotPassword forgot = new ForgotPassword();
            forgot.setVisible(true);
        }
    }

    public static void main(String[] args) {
        new Login().setVisible(true);
    }
}
