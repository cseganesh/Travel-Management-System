package travelbookingsystem;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class About extends JFrame implements ActionListener {

    private JButton exitButton; // Changed button variable name for clarity
    private JLabel titleLabel; // Changed label variable name for clarity
    private TextArea descriptionArea; // Changed text area variable name for clarity

    public About() {
        // Set up the frame properties
        setTitle("About the Project");
        setBounds(700, 220, 600, 600); // Increased frame width and height
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        getContentPane().setBackground(new Color(255, 255, 255)); // Set background color

        // Create the "Exit" button
        exitButton = new JButton("Exit");
        exitButton.setBounds(240, 520, 120, 30); // Adjusted position to fit new height
        exitButton.setBackground(new Color(100, 149, 237)); // Button color
        exitButton.setForeground(Color.WHITE); // Button text color
        exitButton.setFont(new Font("RALEWAY", Font.BOLD, 16)); // Button font
        exitButton.addActionListener(this);
        exitButton.setFocusPainted(false); // Remove focus border
        exitButton.setBorderPainted(false); // Remove button border
        exitButton.setOpaque(true); // Make button opaque
        add(exitButton);

        // Create the title label
        titleLabel = new JLabel("About Project");
        titleLabel.setBounds(200, 10, 200, 80); // Adjusted title position
        titleLabel.setForeground(Color.RED); // Title color
        titleLabel.setFont(new Font("RALEWAY", Font.BOLD, 24)); // Title font
        add(titleLabel);

        // Create the description text area
        String description = "                                    About Projects          \n  "
                + "\nThe objective of the Travel and Tourism Management System"
                + " project is to develop a system that automates the processes "
                + "and activities of a travel agency. The purpose is to design a "
                + "system using which one can perform all operations related to "
                + "traveling.\n\n"
                + "This application will help in accessing the information related "
                + "to the travel to a particular destination with great ease. "
                + "The users can track the information related to their tours with "
                + "great ease through this application. The travel agency information "
                + "can also be obtained through this application.\n\n"
                + "Advantages of Project:"
                + "\n• Gives accurate information"
                + "\n• Simplifies the manual work"
                + "\n• Minimizes documentation related work"
                + "\n• Provides up-to-date information"
                + "\n• Creates a friendly environment by providing warning messages."
                + "\n• Travelers' details can be provided"
                + "\n• Booking confirmation notification";

        descriptionArea = new TextArea(description, 10, 40, Scrollbar.VERTICAL);
        descriptionArea.setEditable(false);
        descriptionArea.setBounds(20, 100, 550, 400); // Increased width and height
        descriptionArea.setFont(new Font("RALEWAY", Font.PLAIN, 14)); // Set font for description
        descriptionArea.setBackground(new Color(240, 240, 240)); // Background color for text area
        descriptionArea.setForeground(Color.BLACK); // Text color for text area
        add(descriptionArea);

        // Set the frame visibility
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        dispose(); // Close the About window
    }

    public static void main(String args[]) {
        new About().setVisible(true);
    }
}
