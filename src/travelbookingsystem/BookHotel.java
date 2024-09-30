package travelbookingsystem;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class BookHotel extends JFrame {
    private JPanel contentPane;
    JTextField t1, t2;
    Choice c1, c2, c3;

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                BookHotel frame = new BookHotel("");
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public BookHotel(String username) {
        setBounds(420, 220, 1100, 600);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(240, 255, 255));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/book.jpg"));
        Image i3 = i1.getImage().getScaledInstance(500, 300, Image.SCALE_DEFAULT);
        ImageIcon i2 = new ImageIcon(i3);
        JLabel la1 = new JLabel(i2);
        la1.setBounds(450, 100, 700, 300);
        add(la1);

        JLabel lblName = new JLabel("BOOK HOTEL");
        lblName.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 30));
        lblName.setForeground(new Color(70, 130, 180));
        lblName.setBounds(50, 11, 300, 53);
        contentPane.add(lblName);

        JLabel la2 = new JLabel("Username:");
        la2.setFont(new Font("Tahoma", Font.PLAIN, 18));
        la2.setBounds(35, 70, 200, 20);
        contentPane.add(la2);

        JLabel l1 = new JLabel(username);
        l1.setFont(new Font("Tahoma", Font.PLAIN, 18));
        l1.setBounds(271, 70, 200, 20);
        contentPane.add(l1);

        JLabel lblId = new JLabel("Select Hotel:");
        lblId.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lblId.setBounds(35, 110, 200, 20);
        contentPane.add(lblId);

        c1 = new Choice();
        c1.setFont(new Font("Tahoma", Font.PLAIN, 16));
        c1.add("JW Marriott Hotel");
        c1.add("Mandarin Oriental Hotel");
        c1.add("Four Seasons Hotel");
        c1.add("Radisson Hotel");
        c1.add("Classio Hotel");
        c1.add("The Bay Club Hotel");
        c1.add("Breeze Blows Hotel");
        c1.add("Quick Stop Hotel");
        c1.add("Happy Mornings Motel");
        c1.add("Moss View Hotel");
        c1.setBounds(271, 110, 150, 30);
        add(c1);

        JLabel la3 = new JLabel("Total Persons:");
        la3.setFont(new Font("Tahoma", Font.PLAIN, 18));
        la3.setBounds(35, 150, 200, 20);
        contentPane.add(la3);

        t1 = new JTextField("0");
        t1.setFont(new Font("Tahoma", Font.PLAIN, 16));
        t1.setBounds(271, 150, 150, 25);
        contentPane.add(t1);
        t1.setColumns(10);

        JLabel la4 = new JLabel("Number of Days:");
        la4.setFont(new Font("Tahoma", Font.PLAIN, 18));
        la4.setBounds(35, 190, 200, 20);
        contentPane.add(la4);

        t2 = new JTextField("0");
        t2.setFont(new Font("Tahoma", Font.PLAIN, 16));
        t2.setBounds(271, 190, 150, 25);
        contentPane.add(t2);
        t2.setColumns(10);

        JLabel la5 = new JLabel("AC / Non-AC:");
        la5.setFont(new Font("Tahoma", Font.PLAIN, 18));
        la5.setBounds(35, 230, 200, 20);
        contentPane.add(la5);

        c2 = new Choice();
        c2.add("AC");
        c2.add("Non-AC");
        c2.setFont(new Font("Tahoma", Font.PLAIN, 16));
        c2.setBounds(271, 230, 150, 30);
        add(c2);

        JLabel la6 = new JLabel("Food Included:");
        la6.setFont(new Font("Tahoma", Font.PLAIN, 18));
        la6.setBounds(35, 270, 200, 20);
        contentPane.add(la6);

        c3 = new Choice();
        c3.add("Yes");
        c3.add("No");
        c3.setFont(new Font("Tahoma", Font.PLAIN, 16));
        c3.setBounds(271, 270, 150, 30);
        add(c3);

        JLabel lbl1 = new JLabel("ID:");
        lbl1.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lbl1.setBounds(35, 310, 200, 20);
        contentPane.add(lbl1);

        JLabel l2 = new JLabel();
        l2.setFont(new Font("Tahoma", Font.PLAIN, 18));
        l2.setBounds(271, 310, 200, 20);
        contentPane.add(l2);

        JLabel lbl2 = new JLabel("Number:");
        lbl2.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lbl2.setBounds(35, 350, 200, 20);
        contentPane.add(lbl2);

        JLabel l3 = new JLabel();
        l3.setFont(new Font("Tahoma", Font.PLAIN, 18));
        l3.setBounds(271, 350, 200, 20);
        contentPane.add(l3);

        JLabel lbl3 = new JLabel("Phone:");
        lbl3.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lbl3.setBounds(35, 390, 200, 20);
        contentPane.add(lbl3);

        JLabel l4 = new JLabel();
        l4.setFont(new Font("Tahoma", Font.PLAIN, 18));
        l4.setBounds(271, 390, 200, 20);
        contentPane.add(l4);

        JLabel lblDeposite = new JLabel("Total Price:");
        lblDeposite.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lblDeposite.setBounds(35, 430, 200, 20);
        contentPane.add(lblDeposite);

        JLabel l5 = new JLabel();
        l5.setFont(new Font("Tahoma", Font.BOLD, 20));
        l5.setForeground(Color.RED);
        l5.setBounds(271, 430, 200, 20);
        contentPane.add(l5);

        try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from customer where username = '" + username + "'");
            while (rs.next()) {
                l2.setText(rs.getString("id_type"));
                l3.setText(rs.getString("number"));
                l4.setText(rs.getString("phone"));
            }
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        JButton b1 = new JButton("Check Price");
        b1.setFont(new Font("Tahoma", Font.BOLD, 16));
        b1.setBackground(new Color(0, 100, 0));
        b1.setForeground(Color.WHITE);
        b1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    String selectedHotel = c1.getSelectedItem();
                    Conn c = new Conn();
                    String query = "SELECT * FROM hotels WHERE name = '" + selectedHotel + "'";
                    ResultSet rs = c.s.executeQuery(query);
                    if (rs.next()) {
                        int costPerDay = rs.getInt("cost_per_day");
                        int foodCharges = rs.getInt("food_charges");
                        int acCharges = rs.getInt("ac_charges");

                        int persons = Integer.parseInt(t1.getText());
                        int days = Integer.parseInt(t2.getText());
                        String acChoice = c2.getSelectedItem();
                        String foodChoice = c3.getSelectedItem();

                        if (persons > 0 && days > 0) {
                            int totalCost = costPerDay * persons * days;
                            if (acChoice.equals("AC")) totalCost += acCharges * persons * days;
                            if (foodChoice.equals("Yes")) totalCost += foodCharges * persons * days;

                            l5.setText("Rs " + totalCost);
                        } else {
                            JOptionPane.showMessageDialog(null, "Please enter valid number of persons and days.");
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Hotel not found.");
                    }
                    rs.close();
                } catch (NumberFormatException nfe) {
                    JOptionPane.showMessageDialog(null, "Please enter valid numbers for persons and days.");
                } catch (SQLException se) {
                    System.out.println(se.getMessage());
                } catch (Exception ex) {
                    System.out.println(ex.getMessage());
                }
            }
        });
        b1.setBounds(50, 470, 150, 40);
        contentPane.add(b1);

        JButton btnNewButton = new JButton("Book");
        btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 16));
        btnNewButton.setBackground(new Color(70, 130, 180));
        btnNewButton.setForeground(Color.WHITE);
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    String selectedHotel = c1.getSelectedItem();
                    Conn c = new Conn();
                    String query = "insert into bookHotel values('" + l1.getText() + "', '" + selectedHotel + "', '" + t1.getText() + "', '" + t2.getText() + "', '" + c2.getSelectedItem() + "', '" + c3.getSelectedItem() + "', '" + l2.getText() + "', '" + l3.getText() + "', '" + l4.getText() + "', '" + l5.getText() + "')";
                    c.s.executeUpdate(query);

                    JOptionPane.showMessageDialog(null, "Hotel Booked Successfully");
                    setVisible(false);
                } catch (Exception ee) {
                    System.out.println(ee.getMessage());
                }
            }
        });
        btnNewButton.setBounds(220, 470, 150, 40);
        contentPane.add(btnNewButton);

        JButton btnExit = new JButton("Back");
        btnExit.setFont(new Font("Tahoma", Font.BOLD, 16));
        btnExit.setBackground(new Color(139, 0, 0));
        btnExit.setForeground(Color.WHITE);
        btnExit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });
        btnExit.setBounds(390, 470, 150, 40);
        contentPane.add(btnExit);
    }
}
