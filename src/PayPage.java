import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.io.File;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JTextPane;
import javax.swing.JFileChooser;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PayPage {

    private JFrame frame;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    PayPage window = new PayPage();
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
    public PayPage() {
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
        Font font = new Font("Arial", Font.BOLD, 20); 
        lblNewLabel.setFont(font);

        JLabel lblNewLabel_1 = new JLabel("Transfer information");
        lblNewLabel_1.setBounds(57, 72, 150, 14);
        frame.getContentPane().add(lblNewLabel_1);

        JLabel lblNewLabel_2 = new JLabel("Transaction record");
        lblNewLabel_2.setBounds(57, 150, 150, 14);
        frame.getContentPane().add(lblNewLabel_2);

        JButton btnNewButton = new JButton("Up load");
        btnNewButton.setBounds(184, 200, 89, 23);
        btnNewButton.setBackground(Color.decode("#FFD300")); 
        frame.getContentPane().add(btnNewButton);

        JLabel lblNewLabel_3 = new JLabel("New label");
        lblNewLabel_3.setBounds(200, 47, 180, 64);
        lblNewLabel_3.setBackground(Color.decode("#FFD300")); 
        frame.getContentPane().add(lblNewLabel_3);

        JButton browseButton = new JButton("Browse");
        browseButton.setBounds(200, 150, 89, 23);
        browseButton.setBackground(Color.decode("#FFD300")); 
        frame.getContentPane().add(browseButton);

        browseButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileChooser = new JFileChooser();
                int result = fileChooser.showOpenDialog(null);
                if (result == JFileChooser.APPROVE_OPTION) {
                    File selectedFile = fileChooser.getSelectedFile();
                    // Do something with the selected file
                }
            }
        });
    }
}
