package travelbookingsystem;

import java.awt.*;
import java.sql.*;    
import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class UpdateCustomer extends JFrame {
    Connection conn = null;
    PreparedStatement pst = null;
    private JPanel contentPane;
    private JTextField t1, t3, t4, t6, t7, t8, t9;
    private JComboBox<String> comboBox;  // ComboBox for ID type
    private JRadioButton r1, r2;         // Radio buttons for Gender
    private ButtonGroup genderGroup;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    UpdateCustomer frame = new UpdateCustomer("");
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public UpdateCustomer(String username) throws SQLException {
        setTitle("Update Customer Details");
        setBounds(580, 220, 850, 550);
        contentPane = new JPanel();
        setContentPane(contentPane);
        contentPane.setLayout(null);
        contentPane.setBackground(new Color(255, 255, 255)); // White background
        
        // Adding an image to the panel
        ImageIcon i1  = new ImageIcon(ClassLoader.getSystemResource("icons/update.png"));
        Image i3 = i1.getImage().getScaledInstance(200, 400, Image.SCALE_DEFAULT);
        ImageIcon i2 = new ImageIcon(i3);
        JLabel l1 = new JLabel(i2);
        l1.setBounds(500, 40, 200, 400);
        contentPane.add(l1);

        JLabel lblTitle = new JLabel("UPDATE CUSTOMER DETAILS");
        lblTitle.setFont(new Font("Yu Mincho", Font.BOLD, 22));
        lblTitle.setBounds(118, 11, 300, 53);
        lblTitle.setForeground(new Color(0, 51, 102));  // Dark blue color
        contentPane.add(lblTitle);

        // Adding input labels and fields
        addLabelAndField("Username :", 70, t1 = new JTextField(), 10);
        addLabelAndComboBox("ID :", 110, comboBox = new JComboBox<>(new String[]{"Passport", "Aadhar Card", "Voter Id", "Driving License"}), 10);
        addLabelAndField("Number :", 150, t3 = new JTextField(), 10);
        addLabelAndField("Name :", 190, t4 = new JTextField(), 10);
        addLabelAndRadioButton("Gender :", 230);
        addLabelAndField("Country :", 270, t6 = new JTextField(), 10);
        addLabelAndField("Permanent Address :", 310, t7 = new JTextField(), 10);
        addLabelAndField("Phone :", 350, t8 = new JTextField(), 10);
        addLabelAndField("Email :", 390, t9 = new JTextField(), 10);

        // Fetching data for the provided username
        try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("SELECT * FROM customer WHERE username = '" + username + "'");
            if (rs.next()) {
                t1.setText(rs.getString("username"));
                comboBox.setSelectedItem(rs.getString("id_type"));
                t3.setText(rs.getString("number"));
                t4.setText(rs.getString("name"));
                String gender = rs.getString("gender");
                if ("Male".equalsIgnoreCase(gender)) {
                    r1.setSelected(true);
                } else {
                    r2.setSelected(true);
                }
                t6.setText(rs.getString("country"));
                t7.setText(rs.getString("address"));
                t8.setText(rs.getString("phone"));
                t9.setText(rs.getString("email"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Update button
        JButton btnUpdate = new JButton("Update");
        btnUpdate.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Conn c = new Conn();
                try {
                    String s1 = t1.getText();
                    String s2 = (String) comboBox.getSelectedItem(); // ID type
                    String s3 = t3.getText();
                    String s4 = t4.getText();
                    String s5 = r1.isSelected() ? "Male" : "Female"; // Gender
                    String s6 = t6.getText();
                    String s7 = t7.getText();
                    String s8 = t8.getText();
                    String s9 = t9.getText();

                    String q1 = "UPDATE customer SET id_type = '" + s2 + "', number = '" + s3 + "', name = '" + s4 + "', gender = '" + s5 + "', country = '" + s6 + "', address = '" + s7 + "', phone = '" + s8 + "', email = '" + s9 + "' WHERE username = '" + s1 + "'";
                    c.s.executeUpdate(q1);

                    JOptionPane.showMessageDialog(null, "Customer Detail Updated Successfully");
                    setVisible(false);
                } catch (SQLException e1) {
                    JOptionPane.showMessageDialog(null, "Error updating details: " + e1.getMessage());
                }
            }
        });
        styleButton(btnUpdate, 100, 430);
        contentPane.add(btnUpdate);

        // Back button
        JButton btnExit = new JButton("Back");
        btnExit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });
        styleButton(btnExit, 260, 430);
        contentPane.add(btnExit);
    }

    // Helper method to add labels and text fields
    private void addLabelAndField(String labelText, int yPosition, JTextField textField, int columns) {
        JLabel label = new JLabel(labelText);
        label.setBounds(35, yPosition, 200, 20);
        label.setFont(new Font("Tahoma", Font.BOLD, 14));
        label.setForeground(new Color(0, 51, 102)); // Dark blue color
        contentPane.add(label);

        textField.setBounds(271, yPosition, 150, 25);
        textField.setColumns(columns);
        textField.setFont(new Font("Arial", Font.PLAIN, 14));
        textField.setBorder(BorderFactory.createLineBorder(new Color(0, 51, 102))); // Border color
        contentPane.add(textField);
    }

    // Helper method to add a JComboBox
    private void addLabelAndComboBox(String labelText, int yPosition, JComboBox<String> comboBox, int columns) {
        JLabel label = new JLabel(labelText);
        label.setBounds(35, yPosition, 200, 20);
        label.setFont(new Font("Tahoma", Font.BOLD, 14));
        label.setForeground(new Color(0, 51, 102)); // Dark blue color
        contentPane.add(label);

        comboBox.setBounds(271, yPosition, 150, 25);
        contentPane.add(comboBox);
    }

    // Helper method to add radio buttons for gender
    private void addLabelAndRadioButton(String labelText, int yPosition) {
        JLabel label = new JLabel(labelText);
        label.setBounds(35, yPosition, 200, 20);
        label.setFont(new Font("Tahoma", Font.BOLD, 14));
        label.setForeground(new Color(0, 51, 102)); // Dark blue color
        contentPane.add(label);

        r1 = new JRadioButton("Male");
        r1.setFont(new Font("Tahoma", Font.BOLD, 12));
        r1.setBackground(Color.WHITE);
        r1.setBounds(271, yPosition, 80, 20);
        contentPane.add(r1);

        r2 = new JRadioButton("Female");
        r2.setFont(new Font("Tahoma", Font.BOLD, 12));
        r2.setBackground(Color.WHITE);
        r2.setBounds(350, yPosition, 100, 20);
        contentPane.add(r2);

        genderGroup = new ButtonGroup();
        genderGroup.add(r1);
        genderGroup.add(r2);
    }

    // Helper method to style buttons
    private void styleButton(JButton button, int x, int y) {
        button.setBounds(x, y, 120, 30);
        button.setBackground(new Color(0, 102, 204)); // Blue color
        button.setForeground(Color.WHITE);
        button.setFont(new Font("Tahoma", Font.BOLD, 14));
        button.setFocusPainted(false);
        button.setBorder(BorderFactory.createLineBorder(new Color(0, 51, 102))); // Button border
    }
}
