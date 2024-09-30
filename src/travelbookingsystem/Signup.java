package travelbookingsystem;

import java.awt.*;
import javax.swing.*;
import java.sql.*;
import java.awt.event.*;
import javax.swing.border.*;

public class Signup extends JFrame implements ActionListener {

    private JPanel contentPane;
    private JTextField textField;
    private JTextField textField_1;
    private JPasswordField textField_2; // Password field
    private JTextField textField_3; // Security answer field
    private JButton b1, b2;
    private JComboBox<String> comboBox;

    public static void main(String[] args) {
        new Signup().setVisible(true);
    }

    public Signup() {
        setTitle("Sign Up - Travel Booking System");
        setBounds(600, 250, 700, 406);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setBackground(new Color(240, 248, 255)); // Light blue background
        contentPane.setLayout(null);

        // Username Label
        JLabel lblUsername = new JLabel("Username :");
        lblUsername.setForeground(Color.DARK_GRAY);
        lblUsername.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblUsername.setBounds(99, 86, 92, 26);
        contentPane.add(lblUsername);

        // Name Label
        JLabel lblName = new JLabel("Name :");
        lblName.setForeground(Color.DARK_GRAY);
        lblName.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblName.setBounds(99, 123, 92, 26);
        contentPane.add(lblName);

        // Password Label
        JLabel lblPassword = new JLabel("Password :");
        lblPassword.setForeground(Color.DARK_GRAY);
        lblPassword.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblPassword.setBounds(99, 160, 92, 26);
        contentPane.add(lblPassword);

        // Security Question Label
        JLabel lblSecurityQuestion = new JLabel("Security Question :");
        lblSecurityQuestion.setForeground(Color.DARK_GRAY);
        lblSecurityQuestion.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblSecurityQuestion.setBounds(99, 197, 140, 26);
        contentPane.add(lblSecurityQuestion);

        // Security Answer Label
        JLabel lblAnswer = new JLabel("Answer :");
        lblAnswer.setForeground(Color.DARK_GRAY);
        lblAnswer.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblAnswer.setBounds(99, 234, 92, 26);
        contentPane.add(lblAnswer);

        // Security Question ComboBox
        comboBox = new JComboBox<>();
        comboBox.setModel(new DefaultComboBoxModel<>(new String[]{"Your NickName?", "Your Lucky Number?",
                "Your Child SuperHero?", "Your Childhood Name ?"}));
        comboBox.setBounds(265, 202, 148, 20);
        contentPane.add(comboBox);

        // Sign Up Image
        ImageIcon c1 = new ImageIcon(ClassLoader.getSystemResource("icons/signup.png"));
        Image i1 = c1.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
        ImageIcon i2 = new ImageIcon(i1);
        JLabel l6 = new JLabel(i2);
        l6.setBounds(460, 70, 200, 200);
        contentPane.add(l6);

        // Username TextField
        textField = new JTextField();
        textField.setBounds(265, 91, 148, 20);
        textField.setBorder(BorderFactory.createLineBorder(new Color(173, 216, 230), 2));
        contentPane.add(textField);

        // Name TextField
        textField_1 = new JTextField();
        textField_1.setBounds(265, 128, 148, 20);
        textField_1.setBorder(BorderFactory.createLineBorder(new Color(173, 216, 230), 2));
        contentPane.add(textField_1);

        // Password Field
        textField_2 = new JPasswordField(); // Change this to JPasswordField
        textField_2.setBounds(265, 165, 148, 20);
        textField_2.setBorder(BorderFactory.createLineBorder(new Color(173, 216, 230), 2));
        contentPane.add(textField_2);

        // Security Answer TextField
        textField_3 = new JTextField();
        textField_3.setBounds(265, 239, 148, 20);
        textField_3.setBorder(BorderFactory.createLineBorder(new Color(173, 216, 230), 2));
        contentPane.add(textField_3);

        // Create Button
        b1 = new JButton("Create");
        b1.addActionListener(this);
        b1.setFont(new Font("Tahoma", Font.BOLD, 13));
        b1.setBounds(140, 289, 100, 30);
        b1.setBackground(new Color(34, 139, 34)); // Dark green color
        b1.setForeground(Color.WHITE);
        b1.setFocusPainted(false);
        contentPane.add(b1);

        // Back Button
        b2 = new JButton("Back");
        b2.addActionListener(this);
        b2.setFont(new Font("Tahoma", Font.BOLD, 13));
        b2.setBounds(300, 289, 100, 30);
        b2.setBackground(new Color(255, 140, 0)); // Dark orange color
        b2.setForeground(Color.WHITE);
        b2.setFocusPainted(false);
        contentPane.add(b2);

        // Panel for Account Creation
        JPanel panel = new JPanel();
        panel.setForeground(new Color(34, 139, 34));
        panel.setBorder(new TitledBorder(new LineBorder(new Color(128, 128, 0), 2), "Create Account",
                TitledBorder.LEADING, TitledBorder.TOP, null, new Color(34, 139, 34)));
        panel.setBounds(31, 30, 640, 310);
        panel.setBackground(Color.WHITE);
        contentPane.add(panel);
    }

    public void actionPerformed(ActionEvent ae) {
        try {
            Conn con = new Conn();

            if (ae.getSource() == b1) {
                String sql = "insert into account(username, name, password, question, answer) values(?, ?, ?, ?, ?)";
                PreparedStatement st = con.c.prepareStatement(sql);

                st.setString(1, textField.getText());
                st.setString(2, textField_1.getText());
                st.setString(3, new String(textField_2.getPassword())); // Get the actual password
                st.setString(4, (String) comboBox.getSelectedItem());
                st.setString(5, textField_3.getText());

                int i = st.executeUpdate();
                if (i > 0) {
                    JOptionPane.showMessageDialog(null, "Account Created Successfully ");
                }

                // Clear text fields after successful signup
                textField.setText("");
                textField_1.setText("");
                textField_2.setText("");
                textField_3.setText("");
            }
            if (ae.getSource() == b2) {
                this.setVisible(false);
                new Login().setVisible(true);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
