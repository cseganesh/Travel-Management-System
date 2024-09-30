package travelbookingsystem;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;
import java.sql.*;
import java.awt.event.*;

public class ForgotPassword extends JFrame implements ActionListener {

    private JPanel contentPane;
    private JTextField t1, t2, t3, t4, t5;
    private JButton b1, b2, b3;

    public static void main(String[] args) {
        new ForgotPassword().setVisible(true);
    }

    public ForgotPassword() {

        setTitle("Forgot Password");
        setBounds(450, 200, 900, 450); // Adjusted frame size
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setBackground(new Color(250, 250, 250)); // Set a soft background color
        contentPane.setLayout(null);

        JLabel l1 = new JLabel("Username");
        l1.setFont(new Font("Tahoma", Font.BOLD, 14));
        l1.setForeground(new Color(0, 102, 204)); // Set text color
        l1.setBounds(109, 83, 100, 29);
        contentPane.add(l1);

        JLabel l2 = new JLabel("Name");
        l2.setFont(new Font("Tahoma", Font.BOLD, 14));
        l2.setForeground(new Color(0, 102, 204));
        l2.setBounds(109, 122, 100, 21);
        contentPane.add(l2);

        JLabel l3 = new JLabel("Your Security Question");
        l3.setFont(new Font("Tahoma", Font.BOLD, 14));
        l3.setForeground(new Color(0, 102, 204));
        l3.setBounds(109, 154, 180, 27);
        contentPane.add(l3);

        JLabel l4 = new JLabel("Answer");
        l4.setFont(new Font("Tahoma", Font.BOLD, 14));
        l4.setForeground(new Color(0, 102, 204));
        l4.setBounds(109, 192, 100, 21);
        contentPane.add(l4);

        JLabel l5 = new JLabel("Password");
        l5.setFont(new Font("Tahoma", Font.BOLD, 14));
        l5.setForeground(new Color(0, 102, 204));
        l5.setBounds(109, 224, 100, 21);
        contentPane.add(l5);

        t1 = new JTextField();
        t1.setFont(new Font("Tahoma", Font.BOLD, 13));
        t1.setForeground(new Color(0, 0, 102));
        t1.setBounds(277, 88, 180, 25);
        contentPane.add(t1);

        t2 = new JTextField();
        t2.setEditable(false);
        t2.setFont(new Font("Tahoma", Font.BOLD, 13));
        t2.setForeground(new Color(165, 42, 42));
        t2.setBounds(277, 123, 180, 25);
        contentPane.add(t2);

        t3 = new JTextField();
        t3.setEditable(false);
        t3.setFont(new Font("Tahoma", Font.BOLD, 12));
        t3.setForeground(new Color(72, 61, 139));
        t3.setBounds(277, 161, 250, 25);
        contentPane.add(t3);

        t4 = new JTextField();
        t4.setFont(new Font("Tahoma", Font.BOLD, 13));
        t4.setForeground(new Color(205, 92, 92));
        t4.setBounds(277, 193, 180, 25);
        contentPane.add(t4);

        t5 = new JTextField();
        t5.setEditable(false);
        t5.setFont(new Font("Tahoma", Font.BOLD, 13));
        t5.setForeground(new Color(50, 205, 50));
        t5.setBounds(277, 225, 180, 25);
        contentPane.add(t5);

        // Adding the image
        ImageIcon c1 = new ImageIcon(ClassLoader.getSystemResource("icons/forgotpassword.jpg"));
        Image i1 = c1.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
        ImageIcon i2 = new ImageIcon(i1);

        JLabel l6 = new JLabel(i2);
        l6.setBounds(600, 70, 200, 200);
        contentPane.add(l6);

        // Buttons
        b1 = new JButton("Search");
        b1.addActionListener(this);
        b1.setFont(new Font("Tahoma", Font.BOLD, 12));
        b1.setBounds(470, 88, 100, 30); // Increased button length for better visibility
        b1.setBackground(new Color(0, 51, 102)); // Set a different button color
        b1.setForeground(Color.WHITE);
        b1.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        contentPane.add(b1);

        b2 = new JButton("Retrieve");
        b2.addActionListener(this);
        b2.setFont(new Font("Tahoma", Font.BOLD, 12));
        b2.setBounds(470, 193, 120, 30); // Increased button length for visibility
        b2.setBackground(new Color(0, 51, 102));
        b2.setForeground(Color.WHITE);
        b2.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        contentPane.add(b2);

        b3 = new JButton("Back");
        b3.addActionListener(this);
        b3.setFont(new Font("Tahoma", Font.BOLD, 13));
        b3.setBounds(277, 280, 120, 30); // Adjusted position and size
        b3.setBackground(new Color(0, 51, 102));
        b3.setForeground(Color.WHITE);
        b3.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        contentPane.add(b3);

        JPanel panel = new JPanel();
        panel.setBounds(30, 30, 820, 340); // Adjusted panel size
        panel.setBackground(new Color(255, 228, 225)); // Light pink background
        panel.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        contentPane.add(panel);
    }

    public void actionPerformed(ActionEvent ae) {
        try {
            Conn con = new Conn();
            if (ae.getSource() == b1) {
                String sql = "select * from account where username=?";
                PreparedStatement st = con.c.prepareStatement(sql);

                String username = t1.getText().trim();
                if (username.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Username field cannot be empty");
                    return;
                }

                st.setString(1, username);
                ResultSet rs = st.executeQuery();

                if (rs.next()) {
                    t2.setText(rs.getString("name"));
                    t3.setText(rs.getString("question"));
                } else {
                    JOptionPane.showMessageDialog(null, "No record found for the given username");
                }
                rs.close();
                st.close();
            }

            if (ae.getSource() == b2) {
                String sql = "select * from account where answer=?";
                PreparedStatement st = con.c.prepareStatement(sql);

                String answer = t4.getText().trim();
                if (answer.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Answer field cannot be empty");
                    return;
                }

                st.setString(1, answer);
                ResultSet rs = st.executeQuery();

                if (rs.next()) {
                    t5.setText(rs.getString("password"));
                } else {
                    JOptionPane.showMessageDialog(null, "Incorrect answer");
                }
                rs.close();
                st.close();
            }

            if (ae.getSource() == b3) {
                this.setVisible(false);
                new Login().setVisible(true);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
        }
    }
}
