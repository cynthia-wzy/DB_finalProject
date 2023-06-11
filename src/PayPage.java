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
import javax.swing.JProgressBar;

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
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setBackground(Color.decode("#FFFF9F"));
        frame.getContentPane().setLayout(null);
        frame.setResizable(false);

        // Get screen size
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int screenWidth = screenSize.width;
        int screenHeight = screenSize.height;

        // Set frame size
        frame.setSize(screenWidth, screenHeight);

        // Center the frame on the screen
        int x = (screenWidth - frame.getWidth()) / 2;
        int y = (screenHeight - frame.getHeight()) / 2;
        frame.setLocation(x, y);

        // Rest of your code...
    

        
        JLabel lblNewLabel = new JLabel("NCCU HUNGER SAVER");
        lblNewLabel.setBackground(new Color(240, 240, 240));
        
        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel.setBounds(0, 0, screenSize.width, 34);
        frame.getContentPane().add(lblNewLabel);
        Font font = new Font("Arial", Font.BOLD, 32); 
        lblNewLabel.setFont(font);

        JLabel lblNewLabel_1 = new JLabel("Please transfer this account (post office):");
        lblNewLabel_1.setBounds(508, 74, 239, 14);
        frame.getContentPane().add(lblNewLabel_1);
        JLabel lblNewLabel_11 = new JLabel("Please transfer this account (LINE Pay QR Code):");
        lblNewLabel_11.setBounds(508, 111, 315, 14);
        frame.getContentPane().add(lblNewLabel_11);

        JLabel lblNewLabel_2 = new JLabel("Transaction record:");
        lblNewLabel_2.setBounds(508, 349, 150, 14);
        frame.getContentPane().add(lblNewLabel_2);

        JButton uploadButton = new JButton("Upload");
        uploadButton.setBounds(651, 426, 89, 23);
        uploadButton.setBackground(Color.decode("#FFD300")); 
        frame.getContentPane().add(uploadButton);
        uploadButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                transcation_success successPage = new transcation_success();
                successPage.setVisible(true);
            }
        });

        JLabel lblNewLabel_3 = new JLabel("(700)00011230123123");
        lblNewLabel_3.setBounds(768, 74, 240, 14);
        lblNewLabel_3.setBackground(Color.decode("#FFD300")); 
        frame.getContentPane().add(lblNewLabel_3);
        
        JLabel lblNewLabel_4 = new JLabel("");//QR Code
        lblNewLabel_4.setBounds(833, 111, 294, 228);
        lblNewLabel_4.setBackground(Color.decode("#FFD300")); 
        frame.getContentPane().add(lblNewLabel_4);
        
        JButton browseButton = new JButton("Browse");
        browseButton.setBounds(692, 349, 89, 23);
        browseButton.setBackground(Color.decode("#FFD300")); 
        frame.getContentPane().add(browseButton);
        
        JLabel fileName = new JLabel("");
        fileName.setBounds(692, 395, 209, 15);
        frame.getContentPane().add(fileName);
        
        JProgressBar progressBar = new JProgressBar();
        progressBar.setBounds(623, 460, 146, 7);
        frame.getContentPane().add(progressBar);
        
        browseButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileChooser = new JFileChooser();             
                int result = fileChooser.showOpenDialog(null);
                if (result == JFileChooser.APPROVE_OPTION) {
                    File selectedFile = fileChooser.getSelectedFile();
                    String file = selectedFile.getName(); 
                    fileName.setText("File name: " + file);
                }
            }
        });
    }
    public JFrame getFrame() {
        return frame;
    }
}
