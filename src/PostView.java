import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.Calendar;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EtchedBorder;


public class PostView extends JFrame{
	private JLabel imageLabel;
    private JTextField num;
    private JLabel lblNewLabel_2;
    private JLabel timeNowLabel;
    private JButton updateTimeBtn;
    private JFrame frame;
    private Calendar calendar;
    private int month;
    private int date;
    private int hour;
    private int minute;
    private int second;
    
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
    	frame = initialize();
    	
    	Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
  	   int screenWidth = screenSize.width;
  	   int screenHeight = screenSize.height;
  	   int frameWidth = frame.getWidth();
  	   int frameHeight = frame.getHeight();
  	   int x = (screenWidth - frameWidth) / 2;
  	   int y = (screenHeight - frameHeight) / 2;
  	   frame.setLocation(0, 0);
	   frame.setSize(screenSize);

	    JLabel lblNewLabel = new JLabel("NCCU HUNGER SAVER");
        lblNewLabel.setBackground(new Color(240, 240, 240));
        
        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel.setBounds(0, 0, screenSize.width, 34);
        frame.getContentPane().add(lblNewLabel);
        Font font = new Font("Arial", Font.BOLD, 32); 
        lblNewLabel.setFont(font);
        
        JButton registerButton = new JButton("Sign up");
        registerButton.setBounds(screenSize.width - 170, 11, 75, 23);
        registerButton.setBackground(Color.decode("#FFD300")); 
        frame.getContentPane().add(registerButton);
        registerButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                RegisterPage registerPage = new RegisterPage();
                registerPage.getFrame().setVisible(true);
            }
        });

        JButton loginButton = new JButton("Log in");
        loginButton.setBounds(screenSize.width - 90, 11, 85, 23);
        loginButton.setBackground(Color.decode("#FFD300")); 
        frame.getContentPane().add(loginButton);
        loginButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                LoginPage loginPage = new LoginPage();
                loginPage.getFrame().setVisible(true);
            }
        });
        
        JPanel panel = new JPanel();
        panel.setBounds(20, 50, screenSize.width - 40, screenSize.height - 120);
        panel.setBackground(Color.decode("#FFFFE0")); 
        frame.getContentPane().add(panel);

        // Set preferred size of panel to fit within scroll pane
        panel.setPreferredSize(new Dimension(screenSize.width - 40, screenSize.height - 120));
	    panel.setLayout(null);
	    
	    imageLabel = new JLabel();
	    imageLabel.setBounds(848, 58, 369, 296);
	    imageLabel.setIcon(null);
	    panel.add(imageLabel);
	    
	    JLabel username = new JLabel("username");
	    username.setBounds(32, 26, 91, 15);
	    panel.add(username);
	    
	    JPanel panel1 = new JPanel();
	    panel1.setBounds(32, 57, 800, 434);
	    panel1.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
	    panel.add(panel1);
	    panel1.setLayout(new GridLayout(5,1));
	    
	    JLabel foodNameLabel = new JLabel("post content");
	    foodNameLabel.setBounds(0, 0, 371, 20);
	    panel1.add(foodNameLabel);
	    
	    JLabel locationLabel = new JLabel();
	    locationLabel.setBounds(5, 399, 371, 34);
	    panel1.add(locationLabel);
	    
	    JLabel pickupStartLabel = new JLabel();
	    pickupStartLabel.setBounds(5, 367, 371, 34);
	    panel1.add(pickupStartLabel);
	    
	    JLabel totalAmountLabel = new JLabel();
	    totalAmountLabel.setBounds(5, 331, 371, 34);
	    panel1.add(totalAmountLabel);
	    
	    JLabel postContentLabel = new JLabel();
	    postContentLabel.setBounds(0, 34, 371, 20);
	    panel1.add(postContentLabel);
	    
	    JLabel remainingLabel = new JLabel(); //要用SQL count
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
	    reminderLabel.setBounds(394, 501, 184, 15);
	    panel.add(reminderLabel);

	   
	    JLabel peopleWaitingLabel = new JLabel("current waiting people"); //SQL count
	    peopleWaitingLabel.setForeground(new Color(128, 0, 0));
	    peopleWaitingLabel.setBounds(209, 527, 169, 23);
	    panel.add(peopleWaitingLabel);
	    
	    JTextField num = new JTextField();
	    num.setText("amount");
	    num.setBounds(400, 528, 126, 27);
	    panel.add(num);
	    
	    
	    
	    timeNowLabel = new JLabel();
	    timeNowLabel.setFont(new Font("新細明體", Font.PLAIN, 20));
	    timeNowLabel.setForeground(new Color(128, 0, 0));
	    calendar = Calendar.getInstance();
	    month = calendar.get(Calendar.MONTH)+1;
	    date = calendar.get(Calendar.DATE);
	    hour = calendar.get(Calendar.HOUR_OF_DAY);
        minute = calendar.get(Calendar.MINUTE);
        second = calendar.get(Calendar.SECOND);
        timeNowLabel.setText("current time: "+ month + "/" +date+ " " + hour + ":" + minute+ ":" + second);
	    timeNowLabel.setBounds(875, 26, 221, 21);
	    panel.add(timeNowLabel);
	    frame.setVisible(true);
	    peopleWaiting = sqlQuery.upadatePeopleWaiting(this.postID);
	    peopleWaitingLabel.setText("current waiting people:" + peopleWaiting); 
	    
	    totalAmount = sqlQuery.countTotalFoodAmount(this.postID);//count the total number of food sold
	    
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
	    	locationLabel.setText("location: "+data.getLocation());
	    	pickupStartLabel.setText("pick up time: " + data.getStartTime()+" ~ "+data.getEndTime());
	    	totalAmountLabel.setText("amount: " + data.getAmount());//directly show the amount stored in the database
	    	remaining = data.getAmount()-totalAmount;
	    	remainingLabel.setText("left amount: " + remaining); 
	    	
	    	
        }

	    
	    updateTimeBtn = new JButton("Update Time");
	    updateTimeBtn.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		calendar = Calendar.getInstance();
	    		month = calendar.get(Calendar.MONTH)+1;
	    	    date = calendar.get(Calendar.DATE);
	    	    hour = calendar.get(Calendar.HOUR_OF_DAY);
	            minute = calendar.get(Calendar.MINUTE);
	            second = calendar.get(Calendar.SECOND);
	            timeNowLabel.setText("current time: "+ month + "/" +date+ " " + hour + ":" + minute+ ":" + second);
	            timeNowLabel.repaint();
	    	}
	    });
	    updateTimeBtn.setFont(new Font("新細明體", Font.PLAIN, 18));
	    updateTimeBtn.setBounds(893, 0, 127, 23);
	    panel.add(updateTimeBtn);
	    
	    
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
	                    //make sure there has enough product
	                    if(remaining<quantity) {
	                    	JOptionPane.showMessageDialog(null, "Please change the quantity you want", "Insufficient Quantity", JOptionPane.ERROR_MESSAGE);
	                    	num.setText("");//clear field
	                    }else {
	                    	sqlQuery.placeHolder("aaa111", postID, quantity); 
		                    JOptionPane.showMessageDialog(null, "Please be sure to pick up the food!", "Waiting Successfully", JOptionPane.INFORMATION_MESSAGE);
		                    num.setText("");//clear field
		                    num.setEditable(false);//user cannot edit again
		                    reminderLabel.setText("");
		                    totalAmount = sqlQuery.countTotalFoodAmount(postID);
		                    peopleWaiting = sqlQuery.upadatePeopleWaiting(postID);
		                    remaining -= totalAmount;
		                    sqlQuery.updateTotalFoodAmount(postID,remaining);//update the FoodAmount in the database
		                    remainingLabel.setText("remaining amount: " + remaining);
		                    peopleWaitingLabel.setText("current waiting people: " + peopleWaiting);
		                    postpone_yn.setEnabled(true);//user can postpone from now on 
		                    waitBtn.setEnabled(false); //user cannot press the wait btn from now on 
		                    finish_pick.setEnabled(true);//user can finish the transaction from now on 
	                    }
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
            	payPage.getFrame().setVisible(true);
	    	}
	    });
	    
	    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    setLocationRelativeTo(null);
	    setVisible(true);
	   }
    
    private JFrame initialize() {
    	frame = new JFrame();
    	frame.getContentPane().setBackground(Color.decode("#FFFF9F")); 
    	return frame;
    }
	
    public void openPostView() {
    	PostView frame = new PostView(postID);
    }

	public int getTotalAmount() {
		return totalAmount;
	}
    
    public static void main(String[] args){
        new PostView(1); 
    }
}
