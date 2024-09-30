package travelbookingsystem;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Paytm extends JFrame {
    
    private JButton back; // Declare the back button

    Paytm() {
        // Create a panel for the payment process
        JPanel panel = new JPanel();
        panel.setLayout(null);
        
        // Create a message label to show payment status
        JLabel messageLabel = new JLabel("Processing Payment...");
        messageLabel.setFont(new Font("Arial", Font.BOLD, 24));
        messageLabel.setBounds(250, 50, 300, 30);
        panel.add(messageLabel);

        // Create a "Back" button to return to the previous screen
        back = new JButton("Back");
        back.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                setVisible(false); // Hide current frame
            }
        });
        back.setBounds(350, 400, 100, 40); // Center the button at the bottom
        panel.add(back);
        
        // Simulate payment processing delay
        Timer timer = new Timer(3000, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // After delay, update the message
                messageLabel.setText("Payment Successful!");
                
                // Center the "Back" button at the bottom after payment success
                back.setBounds(350, 400, 100, 40);
            }
        });
        timer.setRepeats(false); // Only run once
        timer.start();

        // Styling for the panel
        panel.setBackground(new Color(255, 239, 204)); // Light background color
        back.setBackground(new Color(100, 149, 237)); // Button color
        back.setFont(new Font("Arial", Font.BOLD, 16)); // Button font
        back.setForeground(Color.WHITE); // Button text color
        back.setFocusPainted(false); // Remove focus border
        back.setBorderPainted(false); // Remove button border
        back.setOpaque(true); // Make button opaque

        // Set the frame properties
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().add(panel);
        setPreferredSize(new Dimension(800, 600));
        setSize(800, 600);
        setLocation(600, 220);
        setVisible(true);
    }

    public static void main(String[] args) {
        new Paytm().setVisible(true);
    }
}
