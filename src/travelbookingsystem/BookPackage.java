package travelbookingsystem;

import java.awt.BorderLayout;
import java.awt.*;
import java.awt.EventQueue;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.Font;
import java.awt.Image;
import java.sql.*;	
import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class BookPackage extends JFrame {
	private JPanel contentPane;
    JTextField t1,t2;
    Choice c1,c2,c3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BookPackage frame = new BookPackage("");
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public BookPackage(String username) {
		setBounds(420, 220, 1100, 450);
		contentPane = new JPanel();
		setContentPane(contentPane);
		contentPane.setLayout(null);
                
        // Background Color
        contentPane.setBackground(Color.LIGHT_GRAY);
                
        ImageIcon i1  = new ImageIcon(ClassLoader.getSystemResource("icons/bookpackage.jpg"));
        Image i3 = i1.getImage().getScaledInstance(500, 300,Image.SCALE_DEFAULT);
        ImageIcon i2 = new ImageIcon(i3);
        JLabel la1 = new JLabel(i2);
        la1.setBounds(450,50,700,300);
        add(la1);
		
		// Title Label Styling
		JLabel lblName = new JLabel("BOOK PACKAGE");
		lblName.setFont(new Font("Yu Mincho", Font.BOLD, 26)); // Updated font style and size
		lblName.setForeground(new Color(0, 102, 102)); // Custom color
		lblName.setBounds(118, 11, 300, 53);
		contentPane.add(lblName);
                
        JLabel la2 = new JLabel("Username :");
		la2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		la2.setBounds(35, 70, 200, 20);
		contentPane.add(la2);
                
        JLabel l1 = new JLabel(username);
		l1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		l1.setForeground(Color.DARK_GRAY);
		l1.setBounds(271, 70, 200, 20);
		contentPane.add(l1);
                
        JLabel lblId = new JLabel("Select Package :");
		lblId.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblId.setBounds(35, 110, 200, 20);
		contentPane.add(lblId);
                
        c1 = new Choice();
        c1.add("Gold Package");
        c1.add("Silver Package");
        c1.add("Bronze Package");
        c1.setBounds(271, 110, 150, 30);
        add(c1);
        
        // Border for choice component
        c1.setFont(new Font("Tahoma", Font.PLAIN, 14));
        c1.setBackground(Color.WHITE);
        c1.setForeground(Color.DARK_GRAY);
        c1.setFocusable(false);
        c1.setBounds(271, 110, 150, 25);
        contentPane.add(c1);
                
        JLabel la3 = new JLabel("Total Persons");
		la3.setFont(new Font("Tahoma", Font.PLAIN, 16));
		la3.setBounds(35, 150, 200, 20);
		contentPane.add(la3);
                
        t1 = new JTextField();
        t1.setText("0");
		t1.setBounds(271, 150, 150, 25);
		t1.setColumns(10);
		t1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		t1.setForeground(Color.DARK_GRAY);
		t1.setBorder(new LineBorder(Color.GRAY, 1));
		contentPane.add(t1);
		
        JLabel lbl1 = new JLabel("ID :");
		lbl1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lbl1.setBounds(35, 190, 200, 20);
		contentPane.add(lbl1);
                
        JLabel l2 = new JLabel();
		l2.setBounds(271, 190, 200, 20);
		l2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		contentPane.add(l2);
		
		JLabel lbl2 = new JLabel("Number :");
		lbl2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lbl2.setBounds(35, 230, 200, 20);
		contentPane.add(lbl2);
                
        JLabel l3 = new JLabel();
		l3.setBounds(271, 230, 200, 20);
		l3.setFont(new Font("Tahoma", Font.PLAIN, 16));
		contentPane.add(l3);
           	
		JLabel lbl3 = new JLabel("Phone :");
		lbl3.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lbl3.setBounds(35, 270, 200, 20);
		contentPane.add(lbl3);
                
        JLabel l4 = new JLabel();
		l4.setBounds(271, 270, 200, 20);
		l4.setFont(new Font("Tahoma", Font.PLAIN, 16));
		contentPane.add(l4);
		
		JLabel lblDeposite = new JLabel("Total Price :");
		lblDeposite.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblDeposite.setBounds(35, 310, 200, 20);
		contentPane.add(lblDeposite);
		
		JLabel l5 = new JLabel();
		l5.setBounds(271, 310, 200, 20);
        l5.setForeground(Color.RED);
        l5.setFont(new Font("Tahoma", Font.BOLD, 16));
		contentPane.add(l5);
                
        try{
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from customer where username = '"+username+"'");
            while(rs.next()){
                l1.setText(rs.getString("username"));
                l2.setText(rs.getString("id_type"));
                l3.setText(rs.getString("number"));
                l4.setText(rs.getString("phone"));
            }
            rs.close();
        }catch(SQLException e){}
        
        // Check Price Button Styling
        JButton b1 = new JButton("Check Price");
		b1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
                String p = c1.getSelectedItem();
                int cost = 0;
                if(p.equals("Gold Package")) {
                    cost += 12000;
                }if(p.equals("Silver Package")){
                    cost += 25000;
                }else if(p.equals("Bronze Package")){
                    cost += 32000;
                }
                
                cost *= Integer.parseInt(t1.getText());
                l5.setText("Rs "+cost);
            }
		});
		b1.setBounds(50, 350, 120, 30);
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        b1.setFont(new Font("Tahoma", Font.BOLD, 14));
		contentPane.add(b1);
		
		// Book Button Styling
		JButton btnNewButton = new JButton("Book");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
                Conn c = new Conn();
                try{
	    			String s1 = c1.getSelectedItem(); 
                    String q1 = "insert into bookPackage values('"+username+"', '"+c1.getSelectedItem()+"', '"+t1.getText()+"', '"+l2.getText()+"', '"+l3.getText()+"', '"+l4.getText()+"', '"+l5.getText()+"')";
                    c.s.executeUpdate(q1);
	    			JOptionPane.showMessageDialog(null, "Package Booked Successfully");
                    setVisible(false);
                }catch(Exception ee){
	    			System.out.println(ee.getMessage());
                }
			}
		});
		btnNewButton.setBounds(200, 350, 120, 30);
        btnNewButton.setBackground(new Color(0, 153, 51)); // Custom button color
        btnNewButton.setForeground(Color.WHITE);
        btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		contentPane.add(btnNewButton);
		
		// Back Button Styling
		JButton btnExit = new JButton("Back");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
                setVisible(false);
			}
		}); 
		btnExit.setBounds(350, 350, 120, 30);
        btnExit.setBackground(Color.RED);
        btnExit.setForeground(Color.WHITE);
        btnExit.setFont(new Font("Tahoma", Font.BOLD, 14));
		contentPane.add(btnExit);
                
        getContentPane().setBackground(Color.WHITE);
	}
}
