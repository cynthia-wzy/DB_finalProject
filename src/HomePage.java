import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;

public class HomePage {

    JFrame frame;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    HomePage window = new HomePage();
                    window.frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public HomePage() {
        initialize();
    }

    private void initialize() {
        frame = new JFrame();
		frame.getContentPane().setBackground(Color.decode("#FFFF9F")); 
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Get screen size
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

        // Set frame size to fit the screen
        frame.setSize(screenSize);

        frame.getContentPane().setLayout(null);

        JLabel lblNewLabel = new JLabel("NCCU HUNGER SAVER");
        lblNewLabel.setBackground(new Color(240, 240, 240));
        
        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel.setBounds(0, 0, screenSize.width, 34);
        frame.getContentPane().add(lblNewLabel);
        Font font = new Font("Arial", Font.BOLD, 32); 
        lblNewLabel.setFont(font);
        
        JButton registerButton = new JButton("Log in");
        registerButton.setBounds(screenSize.width - 170, 11, 75, 23);
        registerButton.setBackground(Color.decode("#FFD300")); 
        frame.getContentPane().add(registerButton);
        registerButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                RegisterPage registerPage = new RegisterPage();
                registerPage.getFrame().setVisible(true);
            }
        });

        JButton loginButton = new JButton("Sign up");
        loginButton.setBounds(screenSize.width - 90, 11, 85, 23);
        loginButton.setBackground(Color.decode("#FFD300")); 
        frame.getContentPane().add(loginButton);
        loginButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                LoginPage loginPage = new LoginPage();
                loginPage.getFrame().setVisible(true);
            }
        });

        JPanel panel = new JPanel();
        panel.setBounds(20, 50, screenSize.width - 40, screenSize.height - 120);
        panel.setBackground(Color.decode("#FFFFE0")); 
        frame.getContentPane().add(panel);

        // Set preferred size of panel to fit within scroll pane
        panel.setPreferredSize(new Dimension(screenSize.width - 40, screenSize.height - 120));
        panel.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));

        // Add sample items
        addItem(panel, "image1.jpg", "Item 1", "Location 1", "10", "5");
        addItem(panel, "image2.jpg", "Item 2", "Location 2", "8", "3");
        addItem(panel, "image3.jpg", "Item 3", "Location 3", "12", "7");
        addItem(panel, "image4.jpg", "Item 4", "Location 4", "6", "2");

        JScrollPane scrollPane = new JScrollPane(panel);
        scrollPane.setBounds(20, 50, screenSize.width - 40, screenSize.height - 120);
        scrollPane.getVerticalScrollBar().setBackground(Color.decode("#FFFFE0"));
        scrollPane.getHorizontalScrollBar().setBackground(Color.decode("#FFFFE0"));
        frame.getContentPane().add(scrollPane);

        frame.setVisible(true);
    }

    private void addItem(JPanel panel, String imagePath, String name, String location, String remaining, String quantity) {
        JPanel itemPanel = new JPanel();
        itemPanel.setPreferredSize(new Dimension(800, 200));
        itemPanel.setBackground(new Color(255, 255, 204)); // Set background color to yellowish

        // ...

        // Create and set the labels for item details
        JLabel nameLabel = new JLabel("Name: " + name + "  ");
        nameLabel.setForeground(new Color(0, 0, 102)); // Set text color to dark blue
        JLabel locationLabel = new JLabel("Location: " + location + "  ");
        locationLabel.setForeground(new Color(0, 102, 0)); // Set text color to dark green
        JLabel remainingLabel = new JLabel("Remaining: " + remaining + "  ");
        remainingLabel.setForeground(Color.decode("#652A01")); // Set text color to brown
        JLabel quantityLabel = new JLabel("Quantity: " + quantity + "  ");
        quantityLabel.setForeground(new Color(102, 0, 102)); // Set text color to dark purple

        // ...

        // Add the labels to the item panel
        itemPanel.add(nameLabel);
        itemPanel.add(locationLabel);
        itemPanel.add(remainingLabel);
        itemPanel.add(quantityLabel);

        // ...

        // Add the item panel to the main panel
        panel.add(itemPanel);
    }
}
