import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
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
import javax.swing.JPanel;
import javax.swing.ImageIcon;

public class PayPage {

    private JFrame frame;
    private JButton uploadButton; // Declare uploadButton as a class field
    private JProgressBar progressBar; // Declare progressBar as a class field

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

        JLabel lblNewLabel = new JLabel("NCCU HUNGER SAVER");
        lblNewLabel.setBackground(new Color(240, 240, 240));
        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel.setBounds(0, 0, screenSize.width, 34);
        frame.getContentPane().add(lblNewLabel);
        Font font = new Font("Arial", Font.BOLD, 32);
        lblNewLabel.setFont(font);

        JLabel lblNewLabel_1 = new JLabel("Please transfer to this account (post office):");
        lblNewLabel_1.setBounds(508, 74, 239, 14);
        frame.getContentPane().add(lblNewLabel_1);
        JLabel lblNewLabel_11 = new JLabel("Please transfer to this account (LINE Pay QR Code):");
        lblNewLabel_11.setBounds(508, 111, 315, 14);
        frame.getContentPane().add(lblNewLabel_11);

        ImageIcon originalIcon = new ImageIcon(PayPage.class.getResource("/image/qrcode.png")); 
        Image originalImage = originalIcon.getImage();
        int labelWidth = 200; 
        int labelHeight = 200; 
        Image scaledImage = originalImage.getScaledInstance(labelWidth, labelHeight, Image.SCALE_SMOOTH);

        // deal with the scaled image
        ImageIcon scaledIcon = new ImageIcon(scaledImage);
        JLabel qrcode = new JLabel(scaledIcon);
        qrcode.setBounds(501, 131, 227, 208);
        frame.getContentPane().add(qrcode);
        
        JLabel recordLabel = new JLabel("Transaction record:");
        recordLabel.setBounds(508, 349, 150, 14);
        frame.getContentPane().add(recordLabel);

        uploadButton = new JButton("Upload");
        uploadButton.setBounds(651, 426, 89, 23);
        uploadButton.setBackground(Color.decode("#FFD300"));
        frame.getContentPane().add(uploadButton);
        uploadButton.setEnabled(false); // Disable the button initially

        JLabel lblNewLabel_3 = new JLabel("(700)00011230123123");
        lblNewLabel_3.setBounds(768, 74, 240, 14);
        lblNewLabel_3.setBackground(Color.decode("#FFD300"));
        frame.getContentPane().add(lblNewLabel_3);

        JButton browseButton = new JButton("Browse");
        browseButton.setBounds(692, 349, 89, 23);
        browseButton.setBackground(Color.decode("#FFD300"));
        frame.getContentPane().add(browseButton);

        JLabel fileName = new JLabel("");
        fileName.setBounds(692, 395, 209, 15);
        frame.getContentPane().add(fileName);

        progressBar = new JProgressBar();
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

                    // Enable the uploadButton
                    uploadButton.setEnabled(true);
                }
            }
        });

        uploadButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Disable the uploadButton
                uploadButton.setEnabled(false);
                // Perform upload operation

                // Simulating upload progress for demonstration
                new Thread(new Runnable() {
                    public void run() {
                        for (int i = 0; i <= 100; i++) {
                            progressBar.setValue(i);
                            try {
                                Thread.sleep(10);
                            } catch (InterruptedException ex) {
                                ex.printStackTrace();
                            }
                        }

                        // Upload completed, enable the uploadButton
//                        uploadButton.setEnabled(true);
                        
                        transcation_success successFrame = new transcation_success();
                        successFrame.showFrame();
                    }
                }).start();
            }
        });
    }
    
    public JFrame getFrame() {
        return frame;
    }
}