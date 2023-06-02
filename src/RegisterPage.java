import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;

public class RegisterPage {

	private JFrame frame;
	private JTextField text_account;
	private JPasswordField passwordField;
	
	private SQLQuery sqlQuery = new SQLQuery();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RegisterPage window = new RegisterPage();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public RegisterPage() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.getContentPane().setBackground(Color.decode("#FFFF9F")); 
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		 // Center the frame on the screen
	    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	    int screenWidth = screenSize.width;
	    int screenHeight = screenSize.height;
	    int frameWidth = frame.getWidth();
	    int frameHeight = frame.getHeight();
	    int x = (screenWidth - frameWidth) / 2;
	    int y = (screenHeight - frameHeight) / 2;
	    frame.setLocation(x, y);
		frame.getContentPane().setLayout(null);
		
		JLabel nccuHungerSaverLabel = new JLabel("NCCU HUNGER SAVER");
		nccuHungerSaverLabel.setHorizontalAlignment(SwingConstants.CENTER);
		nccuHungerSaverLabel.setBounds(0, 0, 438, 34);
		frame.getContentPane().add(nccuHungerSaverLabel);
		
		JPanel panel = new JPanel();
		panel.setBounds(87, 32, 268, 140);
        panel.setBackground(new Color(255, 255, 204)); // Set background color to yellowish
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel accountLabel = new JLabel("Account:");
		accountLabel.setBounds(61, 21, 60, 14);
		panel.add(accountLabel);
		
		JLabel passwordLabel = new JLabel("Password:");
		passwordLabel.setBounds(61, 58, 60, 14);
		panel.add(passwordLabel);
		
		text_account = new JTextField();
		text_account.setBounds(125, 18, 96, 20);
		panel.add(text_account);
		text_account.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(125, 55, 96, 20);
		panel.add(passwordField);
		
		JButton registerButton = new JButton("Register");
        registerButton.setBackground(Color.decode("#FFD300")); 
		registerButton.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		    	
		    	String account = text_account.getText();//���身撣唾�String
		    	char[] password = passwordField.getPassword();
		        String passwordString = new String(password);
		    	
				ProcessData registration = new ProcessData(account,passwordString);
				sqlQuery.registration(registration);
				
				//check whether registered successfully
                boolean success = ((SQLQuery) sqlQuery).registration(registration);
                if (!success) {
                	JOptionPane.showMessageDialog(null, "Please complete the text.", "Registration Failed", JOptionPane.ERROR_MESSAGE);
                }else {
                	//After uploading successfully, closing the JOptionPane and return to the home page
    		        JOptionPane.showMessageDialog(null, "Congrats! Welcome to NCCU Hunger Saver", "Registration Success", JOptionPane.INFORMATION_MESSAGE);
                	frame.dispose();
    		        // connect to HomePage
    		        HomePage homePage = new HomePage();
    		        homePage.setVisible(true);
                }
		    }
		});
		registerButton.setBounds(95, 100, 89, 23);
        registerButton.setBackground(Color.decode("#FFD300")); 
		panel.add(registerButton);
		
	}
	
	public JFrame getFrame() {
        return frame;
    }
}