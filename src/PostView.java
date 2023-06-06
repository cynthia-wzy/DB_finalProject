import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.Calendar;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.JScrollPane;
import java.awt.GridLayout;

import java.awt.BorderLayout;
import javax.swing.SpringLayout;
import javax.swing.JTextPane;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.border.EtchedBorder;

public class PostView extends JFrame{
	private JLabel imageLabel;
    private JTextField num;
    private JLabel lblNewLabel_2;
    
    //資料庫用
    private List<ProcessData> infoDataList;
    private SQLQuery sqlQuery = new SQLQuery();
    
    private int postID; 
    private int remaining;
    private int peopleWaiting;
    private int totalAmount;
    
    //紀錄是否已完成取貨
    private boolean finishPick = false;
    
    public PostView(int postID){
    	
    	this.postID = postID;
    	Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	    getContentPane().setBackground(Color.decode("#FFFF9F"));
	    getContentPane().setLayout(null);
	    
	    JLabel lblNewLabel = new JLabel("NCCU HUNGER SAVER");
        lblNewLabel.setBackground(new Color(240, 240, 240));
        
        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel.setBounds(0, 0, screenSize.width, 34);
        getContentPane().add(lblNewLabel);
        Font font = new Font("Arial", Font.BOLD, 32); 
        lblNewLabel.setFont(font);
        
        JButton registerButton = new JButton("Log in");
        registerButton.setBounds(screenSize.width - 170, 11, 75, 23);
        registerButton.setBackground(Color.decode("#FFD300")); 
        getContentPane().add(registerButton);
        registerButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                RegisterPage registerPage = new RegisterPage();
                registerPage.getFrame().setVisible(true);
            }
        });

        JButton loginButton = new JButton("Sign up");
        loginButton.setBounds(screenSize.width - 90, 11, 85, 23);
        loginButton.setBackground(Color.decode("#FFD300")); 
        getContentPane().add(loginButton);
        loginButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                LoginPage loginPage = new LoginPage();
                loginPage.getFrame().setVisible(true);
            }
        });
        
        JPanel panel = new JPanel();
        panel.setBounds(20, 50, screenSize.width - 40, screenSize.height - 120);
        panel.setBackground(Color.decode("#FFFFE0")); 
        getContentPane().add(panel);

        // Set preferred size of panel to fit within scroll pane
        panel.setPreferredSize(new Dimension(screenSize.width - 40, screenSize.height - 120));
	    panel.setLayout(null);
	    
	    imageLabel = new JLabel();
	    imageLabel.setBounds(425, 57, 270, 191);
	    imageLabel.setIcon(null);
	    panel.add(imageLabel);
	    
	    JLabel username = new JLabel("username");
	    username.setBounds(32, 26, 91, 15);
	    panel.add(username);
	    
	    JPanel panel1 = new JPanel();
	    panel1.setBounds(32, 57, 1075, 434);
	    panel1.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
	    panel.add(panel1);
	    
	    JLabel foodNameLabel = new JLabel("post content");
	    foodNameLabel.setBounds(0, 0, 371, 20);
	    panel1.add(foodNameLabel);
	    
	    JLabel text_3 = new JLabel();
	    text_3.setBounds(5, 399, 371, 34);
	    panel1.add(text_3);
	    
	    JLabel text_2 = new JLabel();
	    text_2.setBounds(5, 367, 371, 34);
	    panel1.add(text_2);
	    
	    JLabel text_1 = new JLabel();
	    text_1.setBounds(5, 331, 371, 34);
	    panel1.add(text_1);
	    
	    JLabel postContentLabel = new JLabel();
	    postContentLabel.setBounds(0, 34, 371, 20);
	    panel1.add(postContentLabel);
	    
	    JLabel remainingLabel = new JLabel("remaining amount"); //要用SQL count
	    remainingLabel.setBounds(209, 548, 169, 32);
	    remainingLabel.setForeground(new Color(128, 0, 0));
	    panel.add(remainingLabel);
	    
	    JButton postpone_yn = new JButton("postpone");
	    postpone_yn.setBounds(621, 526, 98, 23);
	    panel.add(postpone_yn);
	    postpone_yn.setEnabled(false);
	    
	    JButton waitBtn = new JButton("wait");
	    waitBtn.setBounds(399, 565, 127, 23);
	    panel.add(waitBtn);
	    
	    JButton finish_pick = new JButton("finish pickup");
	    finish_pick.setBounds(772, 526, 117, 23);
	    panel.add(finish_pick);
	    finish_pick.setEnabled(false);
	    
	    JLabel postponeReminderLabel = new JLabel("not postponed");
	    postponeReminderLabel.setBounds(631, 557, 117, 15);
	    postponeReminderLabel.setForeground(new Color(128, 0, 0));
	    panel.add(postponeReminderLabel);

	    JLabel reminderLabel = new JLabel("Please enter pickup amount:");
	    reminderLabel.setBounds(381, 501, 178, 15);
	    panel.add(reminderLabel);
	    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    setLocationRelativeTo(null);
	    setSize(screenSize);
	    setVisible(true);

	    JLabel peopleWaitingLabel = new JLabel("current waiting people"); //SQL count
	    peopleWaitingLabel.setForeground(new Color(128, 0, 0));
	    peopleWaitingLabel.setBounds(209, 527, 169, 23);
	    panel.add(peopleWaitingLabel);
	    
	    JLabel lblNewLabel_2 = new JLabel("Please enter pickup amount");
	    lblNewLabel_2.setBounds(381, 501, 132, 15);
	    panel.add(lblNewLabel_2);
	    
	    JTextField num = new JTextField();
	    num.setText("amount");
	    num.setBounds(400, 528, 126, 27);
	    panel.add(num);
	    
	    JLabel timeNowLabel = new JLabel("current time:");
	    timeNowLabel.setForeground(new Color(128, 0, 0));
	    Calendar calendar = Calendar.getInstance();
        int hour = calendar.get(Calendar.HOUR_OF_DAY);
        int minute = calendar.get(Calendar.MINUTE);
        int second = calendar.get(Calendar.SECOND);
        timeNowLabel.setText("current time:"+ hour + ":" + minute+ ":" + second);
	    timeNowLabel.setBounds(1098, 26, 132, 15);
	    panel.add(timeNowLabel);
	    
	    infoDataList = sqlQuery.findPost(this.postID);
	    for(ProcessData data : infoDataList) {
	    	//userName
	    	
	    	//resize imageIcon with the same size of a Jlabel
	    	ImageIcon MyImage = new ImageIcon(data.getGraph());
		    Image img = MyImage.getImage();
		    Image newImg = img.getScaledInstance(imageLabel.getWidth(), imageLabel.getHeight(), Image.SCALE_SMOOTH);
		    ImageIcon image = new ImageIcon(newImg);
	    	
	    	imageLabel.setIcon(image);
	    	foodNameLabel.setText(data.getName());
	    	postContentLabel.setText(data.getPostContent());
	    	text_3.setText("location:"+data.getLocation());
	    	text_2.setText("pickup start time:" + data.getStartTime());
	    	text_1.setText("amount:" + data.getAmount());
	    	remaining = data.getAmount();
	    	
        }
	    //peopleWaiting = sqlQuery.upadatePeopleWaiting(this.postID);
	    peopleWaitingLabel.setText("current waiting people:" + peopleWaiting); 
	    
	    totalAmount = sqlQuery.countTotalFoodAmount(this.postID);
	    remainingLabel.setText("left amount" + totalAmount); 
	    
	    
	    postpone_yn.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		sqlQuery.delayPickup("aaa111", postID);
	    		postponeReminderLabel.setText("postponed");
	    		postpone_yn.setEnabled(false);
            	JOptionPane.showMessageDialog(null, "Your product has been reserved for 10 minutes, please come and pick it up, otherwise you will be disqualified", "Postponed Successfully", JOptionPane.INFORMATION_MESSAGE);
	    	}
	    });
	    
	    
	    waitBtn.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent e) {
	            if (num.getText().isEmpty()) {
	                JOptionPane.showMessageDialog(null, "Please enter the quantity you want", "Waiting Failed", JOptionPane.ERROR_MESSAGE);
	            } else {
	                try {
	                    int quantity = Integer.parseInt(num.getText());
	                    sqlQuery.placeHolder("aaa111", postID, quantity); 
	                    JOptionPane.showMessageDialog(null, "Please be sure to pick up the food!", "Waiting Successfully", JOptionPane.INFORMATION_MESSAGE);
	                    num.setText("");
	                    num.setEditable(false);
	                    reminderLabel.setText("");
	                    totalAmount = sqlQuery.countTotalFoodAmount(postID);
	                    //peopleWaiting = sqlQuery.upadatePeopleWaiting(postID);
	                    remaining -= totalAmount;
	                 
	                    remainingLabel.setText("remaining amount" + remaining);
	                    peopleWaitingLabel.setText("current waiting people" + peopleWaiting);
	                    postpone_yn.setEnabled(true);
	                    waitBtn.setEnabled(false);
	                    finish_pick.setEnabled(true);
	                } catch (NumberFormatException ex) {
	                    JOptionPane.showMessageDialog(null, "Please enter a valid quantity", "Waiting Failed", JOptionPane.ERROR_MESSAGE);
	                }
	            }
	        }
	    });
	   
	    
	    finish_pick.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		finish_pick.setEnabled(false);
	    		num.setEditable(false);
	    		waitBtn.setEnabled(false);
	    		postpone_yn.setEnabled(false);
	    		finishPick = true;
	    		finish_pick.setText("finish pickup!");
            	JOptionPane.showMessageDialog(null, "This transction has been finished, please upload the payment detail", "Transaction Finished", JOptionPane.INFORMATION_MESSAGE);
            	
            	PayPage payPage = new PayPage();
	    	}
	    });
	    
	    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    setLocationRelativeTo(null);
	    setVisible(true);
	    }
     
	     // Method to resize imageIcon with the same size of a Jlabel
	    /*public ImageIcon ResizeImage(String ImagePath)
	    {
	        ImageIcon MyImage = new ImageIcon(ImagePath);
	        Image img = MyImage.getImage();
	        Image newImg = img.getScaledInstance(imageLabel.getWidth(), imageLabel.getHeight(), Image.SCALE_SMOOTH);
	        ImageIcon image = new ImageIcon(newImg);
	        return image;
	    }*/
	    
	    public static void main(String[] args){
	        new PostView(1); 
	    }
}