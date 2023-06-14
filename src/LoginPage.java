import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.JPasswordField;


public class LoginPage {

	private JFrame frame;
	private JTextField text_name;
	private JTextField text_account;
	private JPasswordField passwordField;
	private RegisterPage registerPage;
	
	private SQLQuery sqlQuery = new SQLQuery();
	
	private User user;
	private boolean named; //unnamed or not

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginPage window = new LoginPage();
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
	public LoginPage() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("Login");
		frame.setBounds(100, 100, 450, 300);
		frame.getContentPane().setBackground(Color.decode("#FFFF9F")); 
		/*frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);*/
		frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		 // Center the frame on the screen
	    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	    int screenWidth = screenSize.width;
	    int screenHeight = screenSize.height;
	    int frameWidth = frame.getWidth();
	    int frameHeight = frame.getHeight();
	    int x = (screenWidth - frameWidth) / 2;
	    int y = (screenHeight - frameHeight) / 2;
	    frame.setLocation(x, y);
		
		JLabel systemNameLabel = new JLabel("NCCU HUNGER SAVER");
		systemNameLabel.setBackground(new Color(240, 240, 240));
		systemNameLabel.setHorizontalAlignment(SwingConstants.CENTER);
		systemNameLabel.setBounds(0, 0, 438, 34);
		frame.getContentPane().add(systemNameLabel);
		Font font = new Font("Arial", Font.BOLD, 20); 
		systemNameLabel.setFont(font);
		JPanel panel = new JPanel();
		panel.setBounds(87, 32, 268, 221);
        panel.setBackground(new Color(255, 255, 204)); // Set background color to yellowish
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JRadioButton unamedRbtn = new JRadioButton("Unamed");
		unamedRbtn.setBounds(36, 63, 109, 23);
		unamedRbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				named = false;
			}	
		});
		unamedRbtn.setBackground(new Color(255, 255, 204)); 
		panel.add(unamedRbtn);
		
		JRadioButton namedRbtn = new JRadioButton("Named");
		namedRbtn.setBounds(36, 85, 109, 23);
		unamedRbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				named = true;
			}	
		});
		namedRbtn.setBackground(new Color(255, 255, 204)); 
		panel.add(namedRbtn);
		
		ButtonGroup buttonGroup = new ButtonGroup();
		buttonGroup.add(unamedRbtn);
		buttonGroup.add(namedRbtn);
		
		text_name = new JTextField();
		text_name.setBounds(100, 113, 96, 20);
		panel.add(text_name);
		text_name.setColumns(10);
		
		JLabel nameLabel = new JLabel("Name:");
		nameLabel.setBounds(56, 113, 48, 14);
		panel.add(nameLabel);
		
		JLabel passwordLabel = new JLabel("Password:");
		passwordLabel.setBounds(36, 33, 80, 14);
		panel.add(passwordLabel);
		
		JLabel accountLabel = new JLabel("Account:");
		accountLabel.setBounds(36, 7, 80, 14);
		panel.add(accountLabel);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(100, 33, 96, 20);
		panel.add(passwordField);
		
		text_account = new JTextField();
		text_account.setBounds(100, 7, 96, 20);
		panel.add(text_account);
		text_account.setColumns(10);
		
		JButton loginButton = new JButton("Login");
		loginButton.setBackground(Color.decode("#FFD300")); 
		loginButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String username = text_name.getText();
				String userID = text_account.getText();
				String password = new String(passwordField.getPassword());
				
				if(username.equals("")||userID.equals("")||password.equals("")) {
                	JOptionPane.showMessageDialog(null, "Please fill ALL empty field", "Login Failed", JOptionPane.ERROR_MESSAGE);
				}else {
					
					String checkLogin = sqlQuery.checkUserWithUserID(userID, password, username);

					if (checkLogin.equals("Wrong Password")) {
	                	JOptionPane.showMessageDialog(null, "Please enter the correct user ID and password.", "Login Failed", JOptionPane.ERROR_MESSAGE);
					    text_name.setText("");
					    text_account.setText("");
					    passwordField.setText("");
					    return;
					}else if(checkLogin.equals("Login Successfully")){
				        JOptionPane.showMessageDialog(null, "Welcome to NCCU Food Hunter", "Login Success", JOptionPane.INFORMATION_MESSAGE);
				        
				        user = new User(userID, password, username, named);//how to share user info?
						HomePage homePage = new HomePage();
						homePage.getFrame().setVisible(true);
						frame.dispose();
					}else {
				        JOptionPane.showMessageDialog(null, "This user does not exist", "Login Failed", JOptionPane.INFORMATION_MESSAGE);
				        text_name.setText("");
					    text_account.setText("");
					    passwordField.setText("");
					}
				}	
			}
		});
		loginButton.setBounds(94, 143, 89, 23);
		panel.add(loginButton);
		
		JButton registerButton = new JButton("Register");
		registerButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				registerPage = new RegisterPage();
				registerPage.getFrame().setVisible(true);
			}
		});
		registerButton.setBackground(new Color(255, 211, 0));
		registerButton.setBounds(94, 188, 89, 23);
		panel.add(registerButton);
		
		JLabel lblNewLabel = new JLabel("I don't have an account yet:");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Arial", Font.ITALIC, 10));
		lblNewLabel.setBounds(36, 172, 193, 15);
		panel.add(lblNewLabel);
	}
	
	public JFrame getFrame() {
        return frame;
    }
}
