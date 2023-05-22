import java.awt.EventQueue;
import java.awt.Color;
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
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("政是食候");
		lblNewLabel.setBackground(new Color(240, 240, 240));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(0, 0, 438, 34);
		frame.getContentPane().add(lblNewLabel);
		
		JPanel panel = new JPanel();
		panel.setBounds(87, 32, 268, 144);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("實名");
		rdbtnNewRadioButton.setBounds(36, 7, 109, 23);
		panel.add(rdbtnNewRadioButton);
		
		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("匿名");
		rdbtnNewRadioButton_1.setBounds(36, 33, 109, 23);
		panel.add(rdbtnNewRadioButton_1);
		
		textField = new JTextField();
		textField.setBounds(95, 60, 96, 20);
		panel.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("姓名：");
		lblNewLabel_1.setBounds(56, 63, 48, 14);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("帳號：");
		lblNewLabel_2.setBounds(36, 88, 48, 14);
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("密碼：");
		lblNewLabel_3.setBounds(36, 113, 48, 14);
		panel.add(lblNewLabel_3);
		
		textField_2 = new JTextField();
		textField_2.setBounds(77, 113, 96, 20);
		panel.add(textField_2);
		textField_2.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(77, 85, 96, 20);
		panel.add(passwordField);
	}
	
	public JFrame getFrame() {
        return frame;
    }
}
