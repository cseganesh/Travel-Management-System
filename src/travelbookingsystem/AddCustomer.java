package travelbookingsystem;

import java.awt.BorderLayout;
import java.awt.*;
import java.awt.EventQueue;

import javax.swing.border.EmptyBorder;

import java.awt.Font;
import java.awt.Image;
import java.sql.*;	
import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AddCustomer extends JFrame {
	Connection conn = null;
	PreparedStatement pst = null;
	private JPanel contentPane;
	private JTextField t1, t2, t3, t4, t5, t6, t7, t8;
    JComboBox<String> comboBox;
    JRadioButton r1, r2;
    ButtonGroup genderGroup;
    Choice c1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddCustomer frame = new AddCustomer("");
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public AddCustomer(String username) throws SQLException {
		System.out.println(username);
        setBounds(580, 220, 850, 550);
		contentPane = new JPanel();
		setContentPane(contentPane);
		contentPane.setLayout(null);

		// Set background color
		contentPane.setBackground(new Color(245, 245, 245));

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/newcustomer.jpg"));
        Image i3 = i1.getImage().getScaledInstance(450, 500, Image.SCALE_DEFAULT);
        ImageIcon i2 = new ImageIcon(i3);
        JLabel l1 = new JLabel(i2);
        l1.setBounds(450, 40, 450, 420);
        add(l1);
		
		JLabel lblName = new JLabel("NEW CUSTOMER FORM");
		lblName.setFont(new Font("Yu Mincho", Font.BOLD, 24));
		lblName.setForeground(new Color(60, 90, 180));
		lblName.setBounds(118, 11, 300, 53);
		contentPane.add(lblName);
                
		addLabelAndTextField("Username:", t7 = new JTextField(), 70);
		addLabelAndComboBox("ID:", comboBox = new JComboBox<>(new String[]{"Passport", "Aadhar Card", "Voter Id", "Driving license"}), 110);
		addLabelAndTextField("Number:", t1 = new JTextField(), 150);
		addLabelAndTextField("Name:", t2 = new JTextField(), 190);
		addLabelAndRadioButton("Gender:", 230);
		addLabelAndTextField("Country:", t3 = new JTextField(), 270);
		addLabelAndTextField("Permanent Address:", t5 = new JTextField(), 310);
		addLabelAndTextField("Phone:", t6 = new JTextField(), 350);
		addLabelAndTextField("Email:", t8 = new JTextField(), 390);
		
		try {
			Conn c = new Conn();
			ResultSet rs = c.s.executeQuery("select * from account where username = '" + username + "'");
			while (rs.next()) {
				t7.setText(rs.getString("username"));
				t2.setText(rs.getString("name"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		addButton("Add", 100, e -> addCustomer(), Color.GREEN.darker(), Color.WHITE);
		addButton("Back", 260, e -> setVisible(false), Color.RED.darker(), Color.WHITE);
	}

	private void addLabelAndTextField(String labelText, JTextField textField, int y) {
		JLabel label = new JLabel(labelText);
		label.setFont(new Font("Tahoma", Font.BOLD, 14));
		label.setBounds(35, y, 200, 20);
		contentPane.add(label);

		textField.setBounds(271, y, 150, 25);
		contentPane.add(textField);
	}

	private void addLabelAndComboBox(String labelText, JComboBox<String> comboBox, int y) {
		JLabel label = new JLabel(labelText);
		label.setFont(new Font("Tahoma", Font.BOLD, 14));
		label.setBounds(35, y, 200, 20);
		contentPane.add(label);

		comboBox.setBounds(271, y, 150, 25);
		contentPane.add(comboBox);
	}

	private void addLabelAndRadioButton(String labelText, int y) {
		JLabel label = new JLabel(labelText);
		label.setFont(new Font("Tahoma", Font.BOLD, 14));
		label.setBounds(35, y, 200, 20);
		contentPane.add(label);

		r1 = new JRadioButton("Male");
		r1.setFont(new Font("Tahoma", Font.BOLD, 12));
		r1.setBackground(new Color(245, 245, 245));
		r1.setBounds(271, y, 80, 20);
		contentPane.add(r1);

		r2 = new JRadioButton("Female");
		r2.setFont(new Font("Tahoma", Font.BOLD, 12));
		r2.setBackground(new Color(245, 245, 245));
		r2.setBounds(350, y, 100, 20);
		contentPane.add(r2);

		genderGroup = new ButtonGroup();
		genderGroup.add(r1);
		genderGroup.add(r2);
	}

	private void addButton(String text, int x, ActionListener action, Color bgColor, Color fgColor) {
		JButton button = new JButton(text);
		button.addActionListener(action);
		button.setBounds(x, 430, 120, 30);
		button.setBackground(bgColor);
		button.setForeground(fgColor);
		button.setFont(new Font("Tahoma", Font.BOLD, 14));
		contentPane.add(button);
	}

	private void addCustomer() {
		// Retrieve all field values
		String s9 = t7.getText().trim();   // Username
		String s1 = (String) comboBox.getSelectedItem(); // ID type
		String s2 = t1.getText().trim();   // Number
		String s3 = t2.getText().trim();   // Name
		String radio = r1.isSelected() ? "Male" : r2.isSelected() ? "Female" : null; // Gender
		String s5 = t3.getText().trim();   // Country
		String s7 = t5.getText().trim();   // Address
		String s8 = t6.getText().trim();   // Phone
		String s10 = t8.getText().trim();  // Email

		// Validation to check if any required field is empty
		if (s9.isEmpty() || s2.isEmpty() || s3.isEmpty() || radio == null || s5.isEmpty() || s7.isEmpty() || s8.isEmpty() || s10.isEmpty()) {
			JOptionPane.showMessageDialog(null, "Please fill in all the details before submitting.", "Error", JOptionPane.ERROR_MESSAGE);
			return;
		}

		// Proceed to insert into the database if all fields are filled
		try {
			Conn c = new Conn();
			String q1 = "INSERT INTO customer (username, id_type, number, name, gender, country, address, phone, email) " +
						"VALUES ('" + s9 + "','" + s1 + "','" + s2 + "','" + s3 + "','" + radio + "','" + s5 + "','" + s7 + "','" + s8 + "','" + s10 + "')";
			c.s.executeUpdate(q1);

			JOptionPane.showMessageDialog(null, "Customer Added Successfully");
			setVisible(false);
		} catch (SQLException e1) {
			JOptionPane.showMessageDialog(null, "Error adding customer: " + e1.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
		}
	}
}
