import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
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
import java.awt.BorderLayout;
import javax.swing.SpringLayout;
import javax.swing.JTextPane;
import java.awt.Color;
import javax.swing.border.EtchedBorder;

public class PostView extends JFrame{
    JLabel label;
    private JTextField num;
    
    public PostView(){
	    getContentPane().setLayout(null);
	    label = new JLabel();
	    label.setBounds(425, 57, 270, 191);
	    label.setIcon(null);
	    getContentPane().add(label);
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
	    
	    JLabel lblNewLabel = new JLabel("貼文內容");
	    lblNewLabel.setBounds(0, 0, 371, 20);
	    lblNewLabel.setFont(new Font("微軟正黑體", Font.PLAIN, 14));
	    panel.add(lblNewLabel);
	    
	    JLabel text_3 = new JLabel("領取地點：");
	    text_3.setBounds(5, 399, 371, 34);
	    text_3.setFont(new Font("微軟正黑體", Font.PLAIN, 14));
	    panel.add(text_3);
	    
	    JLabel text_location_1 = new JLabel("領取地點：");
	    text_location_1.setFont(new Font("微軟正黑體", Font.PLAIN, 12));
	    text_location_1.setBounds(-133, 197, 371, 34);
	    panel.add(text_location_1);
	    
	    JLabel text_2 = new JLabel("開始發放時間：");
	    text_2.setFont(new Font("微軟正黑體", Font.PLAIN, 14));
	    text_2.setBounds(5, 367, 371, 34);
	    panel.add(text_2);
	    
	    JLabel text_1 = new JLabel("數量：");
	    text_1.setFont(new Font("微軟正黑體", Font.PLAIN, 14));
	    text_1.setBounds(5, 331, 371, 34);
	    panel.add(text_1);
	    
	    JButton waitBtn = new JButton("卡位");
	    waitBtn.setFont(new Font("微軟正黑體", Font.BOLD, 16));
	    waitBtn.setBounds(399, 565, 85, 23);
	    getContentPane().add(waitBtn);
	    
	    JButton postpone_yn = new JButton("延後");
	    postpone_yn.setFont(new Font("微軟正黑體", Font.BOLD, 16));
	    postpone_yn.setBounds(506, 526, 85, 23);
	    getContentPane().add(postpone_yn);
	    
	    JButton finish_pick = new JButton("完成取貨");
	    finish_pick.setFont(new Font("微軟正黑體", Font.BOLD, 16));
	    finish_pick.setBounds(615, 526, 117, 23);
	    getContentPane().add(finish_pick);
	    
	    JLabel lblNewLabel_4 = new JLabel("剩餘數量：");
	    lblNewLabel_4.setBounds(279, 548, 99, 32);
	    lblNewLabel_4.setForeground(new Color(128, 0, 0));
	    lblNewLabel_4.setFont(new Font("微軟正黑體", Font.BOLD, 14));
	    getContentPane().add(lblNewLabel_4);
	    
	    JLabel lblNewLabel_4_1 = new JLabel("尚未延後");
	    lblNewLabel_4_1.setBounds(519, 557, 59, 15);
	    lblNewLabel_4_1.setForeground(new Color(128, 0, 0));
	    lblNewLabel_4_1.setFont(new Font("微軟正黑體", Font.BOLD, 14));
	    getContentPane().add(lblNewLabel_4_1);
	    
	    JLabel lblNewLabel_4_2 = new JLabel("現在時間：");
	    lblNewLabel_4_2.setForeground(new Color(128, 0, 0));
	    lblNewLabel_4_2.setFont(new Font("微軟正黑體", Font.BOLD, 12));
	    lblNewLabel_4_2.setBounds(600, 32, 99, 15);
	    getContentPane().add(lblNewLabel_4_2);
	    
	    JLabel lblNewLabel_4_3 = new JLabel("目前卡位人數：");
	    lblNewLabel_4_3.setForeground(new Color(128, 0, 0));
	    lblNewLabel_4_3.setFont(new Font("微軟正黑體", Font.BOLD, 14));
	    lblNewLabel_4_3.setBounds(251, 527, 99, 23);
	    getContentPane().add(lblNewLabel_4_3);
	    
	    num = new JTextField();
	    num.setFont(new Font("微軟正黑體", Font.PLAIN, 12));
	    num.setText("數量");
	    num.setBounds(400, 528, 85, 27);
	    getContentPane().add(num);
	    num.setColumns(10);
	    
	    JLabel lblNewLabel_1 = new JLabel("請輸入欲領取數量");
	    lblNewLabel_1.setFont(new Font("微軟正黑體", Font.PLAIN, 14));
	    lblNewLabel_1.setBounds(381, 501, 132, 15);
	    getContentPane().add(lblNewLabel_1);
	    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    setLocationRelativeTo(null);
	    setSize(800,800);
	    setVisible(true);
	    }
     
	     // Method to resize imageIcon with the same size of a Jlabel
	    public ImageIcon ResizeImage(String ImagePath)
	    {
	        ImageIcon MyImage = new ImageIcon(ImagePath);
	        Image img = MyImage.getImage();
	        Image newImg = img.getScaledInstance(label.getWidth(), label.getHeight(), Image.SCALE_SMOOTH);
	        ImageIcon image = new ImageIcon(newImg);
	        return image;
	    }
	    
	    public static void main(String[] args){
	        new PostView();
	    }
}
