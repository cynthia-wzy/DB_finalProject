import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.JPasswordField;


public class LoginPage {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_2;
	private JPasswordField passwordField;

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
		frame.setBounds(100, 100, 450, 300);
		frame.getContentPane().setBackground(Color.decode("#FFFF9F")); 
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
		
		JLabel lblNewLabel = new JLabel("NCCU HUNGER SAVER");
		lblNewLabel.setBackground(new Color(240, 240, 240));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(0, 0, 438, 34);
		frame.getContentPane().add(lblNewLabel);
		
		JPanel panel = new JPanel();
		panel.setBounds(87, 32, 268, 168);
        panel.setBackground(new Color(255, 255, 204)); // Set background color to yellowish
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("Unamed");
		rdbtnNewRadioButton.setBounds(36, 63, 109, 23);
		rdbtnNewRadioButton.setBackground(Color.decode("#FFD300")); 
		panel.add(rdbtnNewRadioButton);
		
		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("Named");
		rdbtnNewRadioButton_1.setBounds(36, 85, 109, 23);
		rdbtnNewRadioButton_1.setBackground(Color.decode("#FFD300")); 
		panel.add(rdbtnNewRadioButton_1);
		
		textField = new JTextField();
		textField.setBounds(100, 113, 96, 20);
		panel.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Name:");
		lblNewLabel_1.setBounds(56, 113, 48, 14);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Password:");
		lblNewLabel_2.setBounds(36, 33, 80, 14);
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Account:");
		lblNewLabel_3.setBounds(36, 7, 80, 14);
		panel.add(lblNewLabel_3);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(100, 33, 96, 20);
		panel.add(passwordField);
		
		textField_2 = new JTextField();
		textField_2.setBounds(100, 7, 96, 20);
		panel.add(textField_2);
		textField_2.setColumns(10);
		
		JButton loginButton = new JButton("Login");
		loginButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String username = textField.getText();
				String password = new String(passwordField.getPassword());
				
				boolean loginSuccessful = false;

				if (!loginSuccessful) {
                	JOptionPane.showMessageDialog(null, "Please enter the correct username and password.", "Login Failed", JOptionPane.ERROR_MESSAGE);
				    textField.setText("");
				    textField_2.setText("");
				    passwordField.setText("");
				    return;
				}else {
			        JOptionPane.showMessageDialog(null, "Welcome to NCCU Food Hunter", "Login Success", JOptionPane.INFORMATION_MESSAGE);
					HomePage homePage = new HomePage();
					homePage.setVisible(true);
					
					frame.dispose();
					
				}
			}
		});
		loginButton.setBounds(95, 140, 89, 23);
		panel.add(loginButton);
	}
	
	public JFrame getFrame() {
        return frame;
    }
}
