import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class transcation_success extends JFrame {

	JButton button;
    
    public transcation_success(){
    	
    	Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	    getContentPane().setBackground(Color.decode("#FFFF9F"));
	    getContentPane().setLayout(null);
	    
	    JLabel lblNewLabel = new JLabel("NCCU HUNGER SAVER");
        lblNewLabel.setBackground(new Color(240, 240, 240));
        
        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel.setBounds(0, 0, screenSize.width, 34);
        getContentPane().add(lblNewLabel);
        Font font = new Font("Arial", Font.BOLD, 32); 
        lblNewLabel.setFont(font);
        
        JButton registerButton = new JButton("Log in");
        registerButton.setBounds(screenSize.width - 170, 11, 75, 23);
        registerButton.setBackground(Color.decode("#FFD300")); 
        getContentPane().add(registerButton);
        registerButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                RegisterPage registerPage = new RegisterPage();
                registerPage.getFrame().setVisible(true);
            }
        });

        JButton loginButton = new JButton("Sign up");
        loginButton.setBounds(screenSize.width - 90, 11, 85, 23);
        loginButton.setBackground(Color.decode("#FFD300")); 
        getContentPane().add(loginButton);
        loginButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                LoginPage loginPage = new LoginPage();
                loginPage.getFrame().setVisible(true);
            }
        });
        
        JPanel panel = new JPanel();
        panel.setBounds(20, 50, screenSize.width - 40, screenSize.height - 120);
        panel.setBackground(Color.decode("#FFFFE0")); 
        getContentPane().add(panel);

        // Set preferred size of panel to fit within scroll pane
        panel.setPreferredSize(new Dimension(screenSize.width - 40, screenSize.height - 120));
	    panel.setLayout(null);
    	
	    button = new JButton("Back");
	    button.setBounds(551,161,100,40);
	    panel.add(button);
	    
	    button.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent e) {
	        	
	        }
	    });
	    getContentPane().setLayout(null);
	    
	    JLabel transferText = new JLabel("Transferred $ ");
	    transferText.setHorizontalAlignment(SwingConstants.CENTER);
	    transferText.setBounds(471, 77, 120, 15);
	    panel.add(transferText);
	    
	    JLabel transferAmt_label = new JLabel(""); // amount
	    transferAmt_label.setBounds(568, 77, 47, 15);
	    panel.add(transferAmt_label);
	    PostView post = new PostView();
	    getTotalAmount();
	    
	    JLabel toUserText = new JLabel("to User");
	    toUserText.setBounds(601, 77, 47, 15);
	    panel.add(toUserText);
	    
	    JLabel User_label = new JLabel(""); // userID
	    User_label.setForeground(new Color(0, 0, 0));
	    User_label.setBounds(658, 77, 47, 15);
	    panel.add(User_label);
	    
	    JLabel successText = new JLabel("Transaction Completed!");
	    successText.setHorizontalAlignment(SwingConstants.CENTER);
	    successText.setBounds(292, 102, 605, 61);
	    panel.add(successText);
	    
	    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    setLocationRelativeTo(null);
        int screenWidth = screenSize.width;
        int screenHeight = screenSize.height;

        // Set frame size
        setSize(screenWidth, screenHeight);
	    setVisible(true);
	    
	}
    
    public void showFrame() {
        setVisible(true);
    }
    
    public static void main(String[] args){
	        new transcation_success();
	}
}
