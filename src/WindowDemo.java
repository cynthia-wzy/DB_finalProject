import java.awt.EventQueue;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.BorderLayout;
import javax.swing.JTextArea;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.JRadioButton;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.Font;

public class WindowDemo extends JFrame{
	
    JButton button;
    JLabel label;
    private JTextField text_location;
    private JTextField text_startTime;
    private JTextField item_num;
    private JTextField textField;
    private JTextField textField_1;
    
    public WindowDemo(){
	    button = new JButton("Browse");
	    button.setFont(new Font("微軟正黑體", Font.PLAIN, 12));
	    button.setBounds(180,241,100,40);
	    label = new JLabel();
	    label.setBounds(323,237,359,280);
	    getContentPane().setLayout(null);
	    getContentPane().add(button);
	    getContentPane().add(label);
	    
	    button.addActionListener(new ActionListener() {
	
	        public void actionPerformed(ActionEvent e) {
	        
	          JFileChooser file = new JFileChooser();
	          file.setCurrentDirectory(new File(System.getProperty("user.home")));
	          //filter the files
	          FileNameExtensionFilter filter = new FileNameExtensionFilter("*.Images", "jpg","gif","png");
	          file.addChoosableFileFilter(filter);
	          int result = file.showSaveDialog(null);
	           //if the user click on save in Jfilechooser
	          if(result == JFileChooser.APPROVE_OPTION){
	              File selectedFile = file.getSelectedFile();
	              String path = selectedFile.getAbsolutePath();
	              label.setIcon(ResizeImage(path));
	          }

	          else if(result == JFileChooser.CANCEL_OPTION){
	              System.out.println("No File Select");
	          }
	        }
	    });

	    JTextArea postTextArea = new JTextArea();
	    postTextArea.setFont(new Font("微軟正黑體", Font.PLAIN, 13));
	    postTextArea.setText("請輸入貼文內容");
	    postTextArea.setBounds(29, 51, 670, 176);
	    getContentPane().add(postTextArea);
	    
	    JLabel text_1 = new JLabel("插入貼文照片");
	    text_1.setFont(new Font("微軟正黑體", Font.PLAIN, 12));
	    text_1.setBounds(29, 241, 108, 40);
	    getContentPane().add(text_1);
	    
	    JLabel text_2 = new JLabel("領取地點");
	    text_2.setFont(new Font("微軟正黑體", Font.PLAIN, 12));
	    text_2.setBounds(29, 291, 108, 40);
	    getContentPane().add(text_2);
	    
	    text_location = new JTextField();
	    text_location.setFont(new Font("微軟正黑體", Font.PLAIN, 12));
	    text_location.setBounds(180, 301, 100, 21);
	    getContentPane().add(text_location);
	    text_location.setColumns(10);
	    
	    JLabel text_3 = new JLabel("食物類型");
	    text_3.setFont(new Font("微軟正黑體", Font.PLAIN, 12));
	    text_3.setBounds(29, 341, 108, 40);
	    getContentPane().add(text_3);
	    
	    JComboBox comboBox = new JComboBox();
	    comboBox.setFont(new Font("微軟正黑體", Font.PLAIN, 12));
	    comboBox.setModel(new DefaultComboBoxModel(new String[] {"便當", "飲料", "零食", "生鮮食材"}));
	    comboBox.setBounds(180, 350, 100, 23);
	    getContentPane().add(comboBox);
	    
	    JLabel text_5 = new JLabel("開始發放時間 (e.g 13:30)");
	    text_5.setFont(new Font("微軟正黑體", Font.PLAIN, 12));
	    text_5.setBounds(29, 407, 141, 40);
	    getContentPane().add(text_5);
	    
	    text_startTime = new JTextField();
	    text_startTime.setFont(new Font("微軟正黑體", Font.PLAIN, 12));
	    text_startTime.setColumns(10);
	    text_startTime.setBounds(180, 419, 100, 21);
	    getContentPane().add(text_startTime);
	    
	    JLabel text_6 = new JLabel("每份最低售價 (無可填0)");
	    text_6.setFont(new Font("微軟正黑體", Font.PLAIN, 12));
	    text_6.setBounds(29, 484, 141, 40);
	    getContentPane().add(text_6);
	    
	    item_num = new JTextField();
	    item_num.setFont(new Font("微軟正黑體", Font.PLAIN, 12));
	    item_num.setColumns(10);
	    item_num.setBounds(180, 494, 100, 21);
	    getContentPane().add(item_num);
	    
	    JButton postButton = new JButton("發佈貼文");
	    postButton.setFont(new Font("微軟正黑體", Font.BOLD, 14));
	    postButton.setBounds(29, 546, 670, 40);
	    getContentPane().add(postButton);
	    
	    JLabel username = new JLabel("username");
	    username.setFont(new Font("微軟正黑體", Font.PLAIN, 14));
	    username.setBounds(29, 0, 757, 54);
	    getContentPane().add(username);
	    
	    JLabel text_5_1 = new JLabel("領取截止時間 (e.g. 18:00)");
	    text_5_1.setFont(new Font("微軟正黑體", Font.PLAIN, 12));
	    text_5_1.setBounds(27, 442, 141, 40);
	    getContentPane().add(text_5_1);
	    
	    textField = new JTextField();
	    textField.setFont(new Font("微軟正黑體", Font.PLAIN, 12));
	    textField.setColumns(10);
	    textField.setBounds(180, 450, 100, 21);
	    getContentPane().add(textField);
	    
	    JLabel text_6_1 = new JLabel("發放數量");
	    text_6_1.setFont(new Font("微軟正黑體", Font.PLAIN, 12));
	    text_6_1.setBounds(29, 372, 141, 40);
	    getContentPane().add(text_6_1);
	    
	    textField_1 = new JTextField();
	    textField_1.setFont(new Font("微軟正黑體", Font.PLAIN, 12));
	    textField_1.setColumns(10);
	    textField_1.setBounds(180, 384, 100, 21);
	    getContentPane().add(textField_1);
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
	        new WindowDemo();
	    }
   }