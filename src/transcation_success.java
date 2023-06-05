import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class transcation_success extends JFrame {

	JButton button;
    
    public transcation_success(){
	    button = new JButton("Back");
	    button.setFont(new Font("微軟正黑體", Font.PLAIN, 12));
	    button.setBounds(256,157,100,40);
	    getContentPane().add(button);
	    
	    button.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent e) {
	        }
	    });
	    getContentPane().setSize(800,400);
	    getContentPane().setLayout(null);
	    
	    JLabel lblNewLabel = new JLabel("Transaction Completed!");
	    lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
	    lblNewLabel.setFont(new Font("微軟正黑體", Font.BOLD, 14));
	    lblNewLabel.setBounds(10, 103, 605, 61);
	    getContentPane().add(lblNewLabel);
	    
	    JLabel lblNewLabel_1 = new JLabel("已將 $ XX 轉至 username");
	    lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
	    lblNewLabel_1.setFont(new Font("微軟正黑體", Font.PLAIN, 14));
	    lblNewLabel_1.setBounds(196, 84, 219, 15);
	    getContentPane().add(lblNewLabel_1);
	    
	    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    setLocationRelativeTo(null);
	    setSize(800,800);
	    setVisible(true);
	    
	    }
     
	    
	    public static void main(String[] args){
	        new transcation_success();
	    }

}
