import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
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
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;

import 期末報告_11102Programming_v2.SalesData;

import java.awt.BorderLayout;
import javax.swing.SpringLayout;
import javax.swing.JTextPane;
import java.awt.Color;
import javax.swing.border.EtchedBorder;

public class PostView extends JFrame{
	private JLabel imageLabel;
    private JTextField num;
    
    //Query
    private List<ProcessData> infoDataList;
    private SQLQuery sqlQuery = new SQLQuery();
    
    private int postID; //每篇貼文都有自己的postID constructor應該也要有
    private int remaining;
    private int peopleWaiting;
    private int totalAmount;
    
    private boolean finishPick = false;
    
    public PostView(int postID){
    	
    	this.postID = postID;
    	
	    getContentPane().setLayout(null);
	    
	    imageLabel = new JLabel();
	    imageLabel.setBounds(425, 57, 270, 191);
	    imageLabel.setIcon(null);
	    getContentPane().add(imageLabel);
	    getContentPane().setSize(800,400);
	    
	    JLabel username = new JLabel("username");
	    username.setBounds(32, 26, 91, 15);
	    username.setFont(new Font("微軟正黑體", Font.PLAIN, 14));
	    getContentPane().add(username);
	    
	    JPanel panel = new JPanel();
	    panel.setBounds(32, 57, 700, 434);
	    panel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
	    getContentPane().add(panel);
	    panel.setLayout(null);
	    
	    JLabel foodNameLabel = new JLabel("貼文內容");
	    foodNameLabel.setBounds(0, 0, 371, 20);
	    foodNameLabel.setFont(new Font("微軟正黑體", Font.PLAIN, 14));
	    panel.add(foodNameLabel);
	    
	    JLabel text_3 = new JLabel();
	    text_3.setBounds(5, 399, 371, 34);
	    text_3.setFont(new Font("微軟正黑體", Font.PLAIN, 14));
	    panel.add(text_3);
	    
	    JLabel text_2 = new JLabel();
	    text_2.setFont(new Font("微軟正黑體", Font.PLAIN, 14));
	    text_2.setBounds(5, 367, 371, 34);
	    panel.add(text_2);
	    
	    JLabel text_1 = new JLabel();
	    text_1.setFont(new Font("微軟正黑體", Font.PLAIN, 14));
	    text_1.setBounds(5, 331, 371, 34);
	    panel.add(text_1);
	    
	    JLabel postContentLabel = new JLabel();
	    postContentLabel.setFont(new Font("微軟正黑體", Font.PLAIN, 14));
	    postContentLabel.setBounds(0, 34, 371, 20);
	    panel.add(postContentLabel);
	    
	    JLabel remainingLabel = new JLabel("剩餘數量："); //SQL count
	    remainingLabel.setBounds(209, 548, 169, 32);
	    remainingLabel.setForeground(new Color(128, 0, 0));
	    remainingLabel.setFont(new Font("微軟正黑體", Font.BOLD, 14));
	    getContentPane().add(remainingLabel);
	    
	    JButton postpone_yn = new JButton("延後");
	    postpone_yn.setFont(new Font("微軟正黑體", Font.BOLD, 16));
	    postpone_yn.setBounds(506, 526, 85, 23);
	    getContentPane().add(postpone_yn);
	    postpone_yn.setEnabled(false);
	    
	    JButton waitBtn = new JButton("卡位");
	    waitBtn.setFont(new Font("微軟正黑體", Font.BOLD, 16));
	    waitBtn.setBounds(399, 565, 85, 23);
	    getContentPane().add(waitBtn);
	    
	    JButton finish_pick = new JButton("完成取貨");
	    finish_pick.setFont(new Font("微軟正黑體", Font.BOLD, 16));
	    finish_pick.setBounds(615, 526, 117, 23);
	    getContentPane().add(finish_pick);
	    finish_pick.setEnabled(false);
	    
	    JLabel postponeReminderLabel = new JLabel("尚未延後");
	    postponeReminderLabel.setBounds(519, 557, 59, 15);
	    postponeReminderLabel.setForeground(new Color(128, 0, 0));
	    postponeReminderLabel.setFont(new Font("微軟正黑體", Font.BOLD, 14));
	    getContentPane().add(postponeReminderLabel);

	    JLabel reminderLabel = new JLabel("請輸入欲領取數量");
	    reminderLabel.setFont(new Font("微軟正黑體", Font.PLAIN, 14));
	    reminderLabel.setBounds(381, 501, 132, 15);
	    getContentPane().add(reminderLabel);
	    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    setLocationRelativeTo(null);
	    setSize(800,800);
	    setVisible(true);

	    JLabel peopleWaitingLabel = new JLabel("目前卡位人數："); //SQL count
	    peopleWaitingLabel.setForeground(new Color(128, 0, 0));
	    peopleWaitingLabel.setFont(new Font("微軟正黑體", Font.BOLD, 14));
	    peopleWaitingLabel.setBounds(209, 527, 169, 23);
	    getContentPane().add(peopleWaitingLabel);
	    
	    infoDataList = sqlQuery.findPost(this.postID);
	    for(ProcessData data : infoDataList) {
	    	//userName unrivised
	    	
	    	//resize imageIcon with the same size of a Jlabel
	    	ImageIcon MyImage = new ImageIcon(data.getGraph());
		    Image img = MyImage.getImage();
		    Image newImg = img.getScaledInstance(imageLabel.getWidth(), imageLabel.getHeight(), Image.SCALE_SMOOTH);
		    ImageIcon image = new ImageIcon(newImg);
	    	
	    	imageLabel.setIcon(image);
	    	foodNameLabel.setText(data.getName());
	    	postContentLabel.setText(data.getPostContent());
	    	text_3.setText("領取地點："+data.getLocation());
	    	text_2.setText("開始發放時間：" + data.getStartTime());
	    	text_1.setText("數量：" + data.getAmount());
	    	remaining = data.getAmount();
	    	
        }
	    peopleWaiting = sqlQuery.countPeopleWaiting(this.postID);
	    peopleWaitingLabel.setText("目前卡位人數：" + peopleWaiting); 
	    
	    totalAmount = sqlQuery.countTotalFoodAmount(this.postID);
	    remainingLabel.setText("剩餘數量：" + totalAmount); 
	    
	    //延後動作
	    postpone_yn.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		sqlQuery.delayPickup("aaa111", postID);//random user
	    		postponeReminderLabel.setText("已延後");
	    		postpone_yn.setEnabled(false);
            	JOptionPane.showMessageDialog(null, "Your product has been reserved for 10 minutes, please come and pick it up, otherwise you will be disqualified", "Postponed Successfully", JOptionPane.INFORMATION_MESSAGE);
	    	}
	    });
	    
	    //卡位動作
	    waitBtn.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		if(num.getText().isEmpty()) {
                	JOptionPane.showMessageDialog(null, "Please enter the quantity you want", "Waiting Failed", JOptionPane.ERROR_MESSAGE);
	    		}else {
	    			sqlQuery.placeHolder("aaa111", postID, Integer.parseInt(num.getText()));//random user
	            	JOptionPane.showMessageDialog(null, "Please be sure to pick up the food!", "Waiting Successfully", JOptionPane.INFORMATION_MESSAGE);
	            	num.setText("");
	            	num.setEditable(false);
	            	reminderLabel.setText("");
	            	remainingLabel.setText("剩餘數量：" + (remaining-Integer.parseInt(num.getText())));
	            	peopleWaitingLabel.setText("目前卡位人數：" + peopleWaiting); 
	            	postpone_yn.setEnabled(true);
	            	waitBtn.setEnabled(false);
	            	finish_pick.setEnabled(true);
	    		}
	    	}
	    });
	   
	    //完成取貨動作
	    finish_pick.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		finish_pick.setEnabled(false);
	    		num.setEditable(false);
	    		waitBtn.setEnabled(false);
	    		postpone_yn.setEnabled(false);
	    		finishPick = true;
	    		finish_pick.setText("已完成取貨");
            	JOptionPane.showMessageDialog(null, "This transction has been finished", "Transaction Finished", JOptionPane.INFORMATION_MESSAGE);
            	//dispose this frame and enter homepage after pickup
            	HomePage homePage = new HomePage();
				homePage.setVisible(true);
				dispose();
	    	}
	    });
	    
	    JLabel timeNowLabel = new JLabel("現在時間：");
	    timeNowLabel.setForeground(new Color(128, 0, 0));
	    timeNowLabel.setFont(new Font("微軟正黑體", Font.BOLD, 12));
	    Calendar calendar = Calendar.getInstance();
        int hour = calendar.get(Calendar.HOUR_OF_DAY);
        int minute = calendar.get(Calendar.MINUTE);
        int second = calendar.get(Calendar.SECOND);
        timeNowLabel.setText("現在時間："+ hour + "：" + minute+ "：" + second);
	    timeNowLabel.setBounds(600, 32, 132, 15);
	    getContentPane().add(timeNowLabel);
	    
	    num = new JTextField();
	    num.setFont(new Font("微軟正黑體", Font.PLAIN, 12));
	    num.setText("數量");
	    num.setBounds(400, 528, 85, 27);
	    getContentPane().add(num);
	    num.setColumns(10);
	    
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
	        new PostView(1); //Take postID 1 for example
	    }
}
