package travelbookingsystem;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.border.LineBorder;

/**
 *
 * @author Prity
 */
public class Payment extends JFrame {
    
    public Payment() {
        
        setLayout(null);
        setBounds(600, 220, 800, 600);
        
        JLabel label = new JLabel("Pay using Paytm");
        label.setFont(new Font("Raleway", Font.BOLD, 40));
        label.setBounds(50, 20, 350, 45);
        add(label);
        
        ImageIcon i7 = new ImageIcon(ClassLoader.getSystemResource("icons/paytm.jpeg"));
        Image i8 = i7.getImage().getScaledInstance(800, 600, Image.SCALE_DEFAULT);
        ImageIcon i9 = new ImageIcon(i8);
        JLabel l4 = new JLabel(i9);
        l4.setBounds(0, 150, 800, 600);
        add(l4);
        
        JButton pay = new JButton("Pay");
        pay.setBackground(new Color(0, 128, 0)); // Green background
        pay.setForeground(Color.WHITE); // White text
        pay.setFont(new Font("Arial", Font.BOLD, 16)); // Change font style
        pay.setBorder(new LineBorder(Color.BLACK, 2)); // Add border
        pay.setBounds(420, 20, 80, 40);
        pay.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new Paytm().setVisible(true);
            }
        });
        add(pay);
    
        JButton back = new JButton("Back");
        back.setBackground(new Color(255, 69, 0)); // Red background
        back.setForeground(Color.WHITE); // White text
        back.setFont(new Font("Arial", Font.BOLD, 16)); // Change font style
        back.setBorder(new LineBorder(Color.BLACK, 2)); // Add border
        back.setBounds(510, 20, 80, 40);
        back.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });
        add(back);
        
        getContentPane().setBackground(Color.WHITE);
        setVisible(true);
    }

    public static void main(String[] args) {
        new Payment().setVisible(true);
    }
}
