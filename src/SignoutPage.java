import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;
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

public class SignoutPage {

    private JFrame frame;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    SignoutPage window = new SignoutPage();
                    window.frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public SignoutPage() {
        initialize();
    }

    private void initialize() {
        frame = new JFrame();
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

        JButton registerButton = new JButton("Post");
        registerButton.setBounds(screenSize.width - 165, 11, 75, 23);
        frame.getContentPane().add(registerButton);
        registerButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                RegisterPage registerPage = new RegisterPage();
                registerPage.getFrame().setVisible(true);
            }
        });

        JButton loginButton = new JButton("Sign out");
        loginButton.setBounds(screenSize.width - 90, 11, 85, 23);
        frame.getContentPane().add(loginButton);
        loginButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                LoginPage loginPage = new LoginPage();
                loginPage.getFrame().setVisible(true);
            }
        });

        JPanel panel = new JPanel();
        panel.setBounds(20, 50, screenSize.width - 40, screenSize.height - 120);
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
        frame.getContentPane().add(scrollPane);

        frame.setVisible(true);
    }

    private void addItem(JPanel panel, String imagePath, String name, String location, String remaining, String quantity) {
        JPanel itemPanel = new JPanel();
        itemPanel.setPreferredSize(new Dimension(800, 200));
        itemPanel.setBackground(Color.white);
        itemPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 10));

        //
        // Create and set the image icon
        ImageIcon imageIcon = new ImageIcon(imagePath);
        Image image = imageIcon.getImage().getScaledInstance(150, 150, Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(image);
        JLabel imageLabel = new JLabel(scaledIcon);
        itemPanel.add(imageLabel);

        // Create and set the labels for item details
        JLabel nameLabel = new JLabel("Name: " + name);
        JLabel locationLabel = new JLabel("Location: " + location);
        JLabel remainingLabel = new JLabel("Remaining: " + remaining);
        JLabel quantityLabel = new JLabel("Quantity: " + quantity);

        // Add the labels to the item panel
        itemPanel.add(nameLabel);
        itemPanel.add(locationLabel);
        itemPanel.add(remainingLabel);
        itemPanel.add(quantityLabel);

        // Add the item panel to the main panel
        panel.add(itemPanel);
    }
}
