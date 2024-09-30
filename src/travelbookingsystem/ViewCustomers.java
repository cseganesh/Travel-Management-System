package travelbookingsystem;
import java.awt.*;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

import net.proteanit.sql.DbUtils;

import java.sql.*;	
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ViewCustomers extends JFrame {
	Connection conn = null;
	private JPanel contentPane;
	private JTable table;
	private JLabel lblAvailability;
	private JLabel lblCleanStatus;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblRoomNumber;
	private JLabel lblId;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewCustomers frame = new ViewCustomers();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public ViewCustomers() throws SQLException {
		//conn = Javaconnect.getDBConnection();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(580, 220, 900, 680);
		contentPane = new JPanel();
		contentPane.setBorder(new LineBorder(Color.CYAN, 4));  // Add a colorful border to the panel
		setContentPane(contentPane);
		contentPane.setLayout(null);

		// Adding background image
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/viewall.jpg"));
		Image i3 = i1.getImage().getScaledInstance(626, 201, Image.SCALE_DEFAULT);
		ImageIcon i2 = new ImageIcon(i3);
		JLabel l1 = new JLabel(i2);
		l1.setBounds(0, 450, 626, 201);
		add(l1);

		ImageIcon i4 = new ImageIcon(ClassLoader.getSystemResource("icons/viewall.jpg"));
		Image i5 = i4.getImage().getScaledInstance(626, 201, Image.SCALE_DEFAULT);
		ImageIcon i6 = new ImageIcon(i5);
		JLabel l2 = new JLabel(i6);
		l2.setBounds(615, 450, 626, 201);
		add(l2);

		// Table settings
		table = new JTable();
		table.setBounds(0, 40, 900, 350);
		contentPane.add(table);

		try {
			Conn c = new Conn();
			String displayCustomersql = "select * from customer";
			ResultSet rs = c.s.executeQuery(displayCustomersql);
			table.setModel(DbUtils.resultSetToTableModel(rs));
		} catch (Exception e1) {
			e1.printStackTrace();
		}

		// "Back" button with color and style
		JButton btnNewButton = new JButton("Back");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		btnNewButton.setBounds(390, 400, 120, 30);
		btnNewButton.setBackground(new Color(0, 102, 204));  // Custom button color
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 16));  // Change font and style
		btnNewButton.setBorder(new LineBorder(Color.BLUE, 2));  // Add a colorful border to the button
		contentPane.add(btnNewButton);

		// Label settings with colorful borders and custom font
		lblAvailability = new JLabel("Username");
		lblAvailability.setBounds(10, 15, 100, 14);
		lblAvailability.setFont(new Font("Serif", Font.BOLD, 14));  // Custom font
		lblAvailability.setForeground(Color.BLUE);  // Label text color
		contentPane.add(lblAvailability);

		lblCleanStatus = new JLabel("Id Type");
		lblCleanStatus.setBounds(110, 15, 100, 14);
		lblCleanStatus.setFont(new Font("Serif", Font.BOLD, 14));
		lblCleanStatus.setForeground(new Color(153, 0, 153));  // Purple color for label
		contentPane.add(lblCleanStatus);

		lblNewLabel = new JLabel("Number");
		lblNewLabel.setBounds(220, 15, 100, 14);
		lblNewLabel.setFont(new Font("Serif", Font.BOLD, 14));
		lblNewLabel.setForeground(new Color(0, 153, 0));  // Green color for label
		contentPane.add(lblNewLabel);

		lblNewLabel_1 = new JLabel("Name");
		lblNewLabel_1.setBounds(320, 15, 100, 14);
		lblNewLabel_1.setFont(new Font("Serif", Font.BOLD, 14));
		lblNewLabel_1.setForeground(new Color(255, 69, 0));  // Orange-Red color for label
		contentPane.add(lblNewLabel_1);

		lblId = new JLabel("Gender");
		lblId.setBounds(420, 15, 90, 14);
		lblId.setFont(new Font("Serif", Font.BOLD, 14));
		lblId.setForeground(Color.MAGENTA);
		contentPane.add(lblId);

		JLabel l3 = new JLabel("Country");
		l3.setBounds(520, 15, 100, 14);
		l3.setFont(new Font("Serif", Font.BOLD, 14));
		l3.setForeground(new Color(0, 204, 204));  // Cyan color for label
		contentPane.add(l3);

		JLabel l4 = new JLabel("Address");
		l4.setBounds(620, 15, 100, 14);
		l4.setFont(new Font("Serif", Font.BOLD, 14));
		l4.setForeground(new Color(255, 140, 0));  // Dark orange for label
		contentPane.add(l4);

		JLabel l5 = new JLabel("Phone");
		l5.setBounds(720, 15, 100, 14);
		l5.setFont(new Font("Serif", Font.BOLD, 14));
		l5.setForeground(Color.RED);
		contentPane.add(l5);

		JLabel l6 = new JLabel("Email");
		l6.setBounds(820, 15, 100, 14);
		l6.setFont(new Font("Serif", Font.BOLD, 14));
		l6.setForeground(new Color(0, 102, 204));  // Blue for label
		contentPane.add(l6);

		// Set background color for the panel
		contentPane.setBackground(new Color(255, 255, 204));  // Light yellow background
	}
}
