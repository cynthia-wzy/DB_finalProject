import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollBar;

public class HomePage {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
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

	/**
	 * Create the application.
	 */
	public HomePage() {
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
		
		JButton registerButton = new JButton("註冊");
		registerButton.setBounds(301, 11, 62, 23);
		frame.getContentPane().add(registerButton);
		registerButton.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent e) {
	        	RegisterPage registerPage = new RegisterPage();
	        	registerPage.getFrame().setVisible(true);
	        }
	    });
		
		JButton loginButton = new JButton("登入");
		loginButton.setBounds(366, 11, 62, 23);
		frame.getContentPane().add(loginButton);
		loginButton.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent e) {
	        	LoginPage loginPage = new LoginPage();
	        	loginPage.getFrame().setVisible(true);
	        }
	    });
		
		JScrollBar scrollBar = new JScrollBar();
		scrollBar.setBounds(411, 45, 17, 220);
		frame.getContentPane().add(scrollBar);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 45, 391, 220);
		frame.getContentPane().add(panel);
	}
}
