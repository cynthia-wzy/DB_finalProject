import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;

public class HomePage {

    JFrame frame;
    private SQLQuery sqlQuery = new SQLQuery();
    

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
        
        JScrollPane scrollPane = new JScrollPane(panel);
        scrollPane.setBounds(20, 50, screenSize.width - 40, screenSize.height - 120);
        scrollPane.getVerticalScrollBar().setBackground(Color.decode("#FFFFE0"));
        scrollPane.getHorizontalScrollBar().setBackground(Color.decode("#FFFFE0"));
        frame.getContentPane().add(scrollPane);
        
        // Add items
        sqlQuery.allPostInfo();
        List<PostInfo> postInfos = sqlQuery.allPostInfo();

        for (PostInfo postInfo : postInfos) {
            addItem(panel, postInfo.getImage(), postInfo.getFoodName(), postInfo.getFoodLocation(), Integer.toString(postInfo.getFoodAmount()), postInfo.getPickupDDL(), postInfo.getMinPrice());
        }


        frame.setVisible(true);
    }

    private void addItem(JPanel panel, byte[] image, String name, String location, String remaining, String time, int price) {
        JPanel itemPanel = new JPanel();
        itemPanel.setPreferredSize(new Dimension(800, 200));
        itemPanel.setBackground(new Color(255, 255, 204)); // Set background color to yellowish

        // Create and set the labels for item details
        JLabel nameLabel = new JLabel("Name: " + name + "  ");
        nameLabel.setForeground(new Color(0, 0, 102)); // Set text color to dark blue
        
        JLabel locationLabel = new JLabel("Location: " + location + "  ");
        locationLabel.setForeground(new Color(0, 102, 0)); // Set text color to dark green
        
        JLabel remainingLabel = new JLabel("Remaining: " + remaining + "  ");
        remainingLabel.setForeground(Color.decode("#652A01")); // Set text color to brown
        
        JLabel timeLabel = new JLabel("Final pickup time: " + time + "  ");
        timeLabel.setForeground(new Color(102, 0, 102)); // Set text color to dark purple
        
        JLabel priceLabel = new JLabel("Minimum price: " + price+ "  ");
        priceLabel.setForeground(new Color(102, 0, 102));
        
        ImageIcon icon = new ImageIcon(image);
        Image originalImage = icon.getImage();
        int targetWidth = 200;
        int targetHeight = 200;
        // scale the image
        Image scaledImage = originalImage.getScaledInstance(targetWidth, targetHeight, Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(scaledImage);
        JLabel imageLabel = new JLabel(scaledIcon);

        // Add the labels to the item panel
        itemPanel.add(nameLabel);
        itemPanel.add(locationLabel);
        itemPanel.add(remainingLabel);
        itemPanel.add(timeLabel);
        itemPanel.add(priceLabel);
        itemPanel.add(imageLabel);

        // Add the item panel to the main panel
        panel.add(itemPanel);
    }
}
