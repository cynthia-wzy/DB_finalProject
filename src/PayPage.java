import java.awt.Color;
import java.awt.EventQueue;
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
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        JLabel lblNewLabel = new JLabel("NCCU HUNGER SAVER");
        lblNewLabel.setBackground(new Color(240, 240, 240));
        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel.setBounds(0, 0, 438, 34);
        frame.getContentPane().add(lblNewLabel);

        JLabel lblNewLabel_1 = new JLabel("transfer information");
        lblNewLabel_1.setBounds(27, 72, 150, 14);
        frame.getContentPane().add(lblNewLabel_1);

        JLabel lblNewLabel_2 = new JLabel("transaction record");
        lblNewLabel_2.setBounds(27, 150, 150, 14);
        frame.getContentPane().add(lblNewLabel_2);

        JButton btnNewButton = new JButton("up load");
        btnNewButton.setBounds(184, 200, 89, 23);
        frame.getContentPane().add(btnNewButton);

        JLabel lblNewLabel_3 = new JLabel("New label");
        lblNewLabel_3.setBounds(170, 47, 180, 64);
        frame.getContentPane().add(lblNewLabel_3);

        JButton browseButton = new JButton("Browse");
        browseButton.setBounds(170, 150, 180, 23);
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
