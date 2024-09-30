package travelbookingsystem;

import java.awt.*;
import java.sql.*;
import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DeleteCustomer extends JFrame {
    private JPanel contentPane;
    private Choice c1;
    private JTextField tfId, tfNumber, tfName, tfGender, tfCountry, tfAddress, tfPhone, tfEmail;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    DeleteCustomer frame = new DeleteCustomer();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public DeleteCustomer() throws SQLException {
        setBounds(580, 220, 850, 550);
        contentPane = new JPanel();
        setContentPane(contentPane);
        contentPane.setLayout(null);
        contentPane.setBackground(new Color(240, 248, 255)); // Light Alice Blue background

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/delete.png"));
        Image i3 = i1.getImage().getScaledInstance(300, 300, Image.SCALE_DEFAULT);
        ImageIcon i2 = new ImageIcon(i3);
        JLabel l1 = new JLabel(i2);
        l1.setBounds(500, 100, 300, 300);
        add(l1);

        JLabel lblName = new JLabel("DELETE CUSTOMER DETAILS");
        lblName.setFont(new Font("Yu Mincho", Font.BOLD, 24));
        lblName.setBounds(118, 11, 300, 53);
        lblName.setForeground(new Color(70, 130, 180)); // Steel Blue color
        contentPane.add(lblName);

        JLabel lb3 = new JLabel("Username :");
        lb3.setBounds(35, 70, 200, 14);
        contentPane.add(lb3);

        c1 = new Choice();
        Conn c = new Conn();
        try {
            ResultSet rs = c.s.executeQuery("select * from customer");
            while (rs.next()) {
                c1.add(rs.getString("username"));
            }
            rs.close();
        } catch (SQLException e) {}

        c1.setBounds(271, 70, 150, 30);
        add(c1);

        // Labels and text fields for each detail
        JLabel lblId = new JLabel("ID :");
        lblId.setBounds(35, 110, 200, 14);
        contentPane.add(lblId);

        tfId = new JTextField();
        tfId.setBounds(271, 110, 200, 20);
        tfId.setBorder(BorderFactory.createLineBorder(new Color(70, 130, 180), 2)); // Steel Blue border
        contentPane.add(tfId);

        JLabel lb2 = new JLabel("Number :");
        lb2.setBounds(35, 150, 200, 14);
        contentPane.add(lb2);

        tfNumber = new JTextField();
        tfNumber.setBounds(271, 150, 200, 20);
        tfNumber.setBorder(BorderFactory.createLineBorder(new Color(70, 130, 180), 2)); // Steel Blue border
        contentPane.add(tfNumber);

        JLabel lblName_1 = new JLabel("Name :");
        lblName_1.setBounds(35, 190, 200, 14);
        contentPane.add(lblName_1);

        tfName = new JTextField();
        tfName.setBounds(271, 190, 200, 20);
        tfName.setBorder(BorderFactory.createLineBorder(new Color(70, 130, 180), 2)); // Steel Blue border
        contentPane.add(tfName);

        JLabel lblGender = new JLabel("Gender :");
        lblGender.setBounds(35, 230, 200, 14);
        contentPane.add(lblGender);

        tfGender = new JTextField();
        tfGender.setBounds(271, 230, 200, 20);
        tfGender.setBorder(BorderFactory.createLineBorder(new Color(70, 130, 180), 2)); // Steel Blue border
        contentPane.add(tfGender);

        JLabel lblCountry = new JLabel("Country :");
        lblCountry.setBounds(35, 270, 200, 14);
        contentPane.add(lblCountry);

        tfCountry = new JTextField();
        tfCountry.setBounds(271, 270, 200, 20);
        tfCountry.setBorder(BorderFactory.createLineBorder(new Color(70, 130, 180), 2)); // Steel Blue border
        contentPane.add(tfCountry);

        JLabel lblReserveRoomNumber = new JLabel("Permanent Address :");
        lblReserveRoomNumber.setBounds(35, 310, 200, 14);
        contentPane.add(lblReserveRoomNumber);

        tfAddress = new JTextField();
        tfAddress.setBounds(271, 310, 200, 20);
        tfAddress.setBorder(BorderFactory.createLineBorder(new Color(70, 130, 180), 2)); // Steel Blue border
        contentPane.add(tfAddress);

        JLabel lblCheckInStatus = new JLabel("Phone :");
        lblCheckInStatus.setBounds(35, 350, 200, 14);
        contentPane.add(lblCheckInStatus);

        tfPhone = new JTextField();
        tfPhone.setBounds(271, 350, 200, 20);
        tfPhone.setBorder(BorderFactory.createLineBorder(new Color(70, 130, 180), 2)); // Steel Blue border
        contentPane.add(tfPhone);

        JLabel lblDeposite = new JLabel("Email :");
        lblDeposite.setBounds(35, 390, 200, 14);
        contentPane.add(lblDeposite);

        tfEmail = new JTextField();
        tfEmail.setBounds(271, 390, 200, 20);
        tfEmail.setBorder(BorderFactory.createLineBorder(new Color(70, 130, 180), 2)); // Steel Blue border
        contentPane.add(tfEmail);

        // Check button action listener
        JButton b1 = new JButton("Check");
        b1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Conn c = new Conn();

                try {
                    ResultSet rs = c.s.executeQuery("select * from customer where username = '" + c1.getSelectedItem() + "'");
                    if (rs.next()) {
                        tfId.setText(rs.getString(2));
                        tfNumber.setText(rs.getString(3));
                        tfName.setText(rs.getString(4));
                        tfGender.setText(rs.getString(5));
                        tfCountry.setText(rs.getString(6));
                        tfAddress.setText(rs.getString(7));
                        tfPhone.setText(rs.getString(8));
                        tfEmail.setText(rs.getString(9));
                    }
                } catch (Exception ee) {}
            }
        });
        b1.setBounds(425, 70, 80, 22);
        b1.setBackground(new Color(70, 130, 180)); // Steel Blue color
        b1.setForeground(Color.WHITE);
        b1.setFont(new Font("Arial", Font.BOLD, 12));
        contentPane.add(b1);

        // Delete button action listener
        JButton btnNewButton = new JButton("Delete");
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Conn c = new Conn();

                try {
                    String s1 = c1.getSelectedItem();

                    String q1 = "delete from customer where username = '" + s1 + "'";
                    c.s.executeUpdate(q1);

                    JOptionPane.showMessageDialog(null, "Customer Detail Deleted Successfully");
                    setVisible(false);
                } catch (SQLException e1) {
                    System.out.println(e1.getMessage());
                } catch (NumberFormatException s) {
                    JOptionPane.showMessageDialog(null, "Please enter a valid Number");
                }
            }
        });
        btnNewButton.setBounds(100, 430, 120, 30);
        btnNewButton.setBackground(new Color(220, 20, 60)); // Crimson color
        btnNewButton.setForeground(Color.WHITE);
        btnNewButton.setFont(new Font("Arial", Font.BOLD, 12));
        contentPane.add(btnNewButton);

        // Back button
        JButton btnExit = new JButton("Back");
        btnExit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });
        btnExit.setBounds(260, 430, 120, 30);
        btnExit.setBackground(new Color(255, 140, 0)); // Dark Orange color
        btnExit.setForeground(Color.WHITE);
        btnExit.setFont(new Font("Arial", Font.BOLD, 12));
        contentPane.add(btnExit);

        getContentPane().setBackground(Color.WHITE);
    }
}
