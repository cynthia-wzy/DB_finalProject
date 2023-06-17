import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;

public class HomePage {

	private JFrame frame;
    private SQLQuery sqlQuery = new SQLQuery();
    private LoginPage loginPage;

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
        addWindowListener();
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
        registerButton.setBounds(screenSize.width - 170, 11, 75, 33);
        registerButton.setBackground(Color.decode("#FFD300")); 
        frame.getContentPane().add(registerButton);
        registerButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	frame.dispose();
            	LoginPage loginPage = new LoginPage();
                loginPage.getFrame().setVisible(true);
            }
        });

        JButton loginButton = new JButton("Sign up");
        loginButton.setBounds(screenSize.width - 90, 11, 85, 33);
        loginButton.setBackground(Color.decode("#FFD300")); 
        frame.getContentPane().add(loginButton);
        loginButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	frame.dispose();
            	RegisterPage registerPage = new RegisterPage();
                registerPage.getFrame().setVisible(true);
            }
        });

        JPanel panel = new JPanel();
        panel.setBackground(Color.decode("#FFFFE0"));
        panel.setLayout(new GridLayout(0, 2, 10, 10)); // Use GridLayout with 2 columns

        JScrollPane scrollPane = new JScrollPane(panel);
        scrollPane.setBounds(20, 50, screenSize.width - 40, screenSize.height - 120);
        scrollPane.getVerticalScrollBar().setBackground(Color.decode("#FFFFE0"));
        scrollPane.getHorizontalScrollBar().setBackground(Color.decode("#FFFFE0"));
        frame.getContentPane().add(scrollPane);

        // Add items
        sqlQuery.allPostInfo();
        List<PostInfo> postInfos = sqlQuery.allPostInfo();

        for (PostInfo postInfo : postInfos) {
            addItem(panel, postInfo.getPostID(), postInfo.getImage(), postInfo.getFoodName(), postInfo.getFoodLocation(),
                    Integer.toString(postInfo.getFoodAmount()), postInfo.getPickupDDL(), postInfo.getMinPrice());
        }

        frame.setVisible(true);
    }
    
    private void addItem(JPanel panel, int postID, byte[] image, String name, String location, String remaining, String time,
            int price) {
        JPanel itemPanel = new JPanel();
        itemPanel.setPreferredSize(new Dimension(600, 300));
        itemPanel.setBackground(new Color(255, 255, 204));
        itemPanel.setLayout(new BorderLayout());

        ImageIcon icon = new ImageIcon(image);
        Image originalImage = icon.getImage();
        int targetWidth = 300;
        int targetHeight = 300;
        // scale the image
        Image scaledImage = originalImage.getScaledInstance(targetWidth, targetHeight, Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(scaledImage);
        JLabel imageLabel = new JLabel(scaledIcon);

        itemPanel.add(imageLabel, BorderLayout.WEST);

        JPanel detailsPanel = new JPanel();
        detailsPanel.setLayout(new GridLayout(0, 1));
        detailsPanel.setBackground(new Color(255, 255, 204));
        
        Font infoFont = new Font("Microsoft JhengHei UI", Font.BOLD, 16);
        JLabel nameLabel = new JLabel("   Name: " + name + "  ");
        nameLabel.setFont(infoFont);
        JLabel locationLabel = new JLabel("   Location: " + location + "  ");
        locationLabel.setFont(infoFont);

        JLabel remainingLabel = new JLabel("   Remaining: " + remaining + "  ");
        remainingLabel.setFont(infoFont);

        JLabel timeLabel = new JLabel("   Final pickup time: " + time + "  ");
        timeLabel.setFont(infoFont);
        timeLabel.setForeground(Color.BLUE);

        JLabel priceLabel = new JLabel("   Minimum price: " + price + "  ");
        priceLabel.setFont(infoFont);
        priceLabel.setForeground(Color.RED);

        detailsPanel.add(nameLabel);
        detailsPanel.add(locationLabel);
        detailsPanel.add(remainingLabel);
        detailsPanel.add(priceLabel);
        detailsPanel.add(timeLabel);

        JButton moreDetailsButton = new JButton("More Details");
        moreDetailsButton.setBackground(Color.decode("#FFD300"));
        moreDetailsButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	frame.dispose();
				loginPage = new LoginPage();//switch to loginPage
				loginPage.getFrame().setVisible(true);
            }
        });

        JPanel buttonPanel = new JPanel();
        buttonPanel.setBackground(new Color(255, 255, 204));
        buttonPanel.add(moreDetailsButton);

        detailsPanel.add(buttonPanel);

        itemPanel.add(detailsPanel, BorderLayout.CENTER);

        panel.add(itemPanel);
    }
    
    private void addWindowListener() {
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                frame.setVisible(false);
            }
        });
    }
    
    public JFrame getFrame() {
        return frame;
    }
}
