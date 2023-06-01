import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.Font;

public class WindowDemo extends JFrame{
	
	private JButton browseButton;
    private JLabel label;
    private JTextArea postTextArea;
    private JComboBox typeComboBox;
    private JTextField text_name;
    private JTextField text_location;
    private JTextField text_startTime;
    private JTextField text_price;
    private JTextField text_endTime;
    private JTextField text_amount;
    private File file_path;
	private byte[] imageBytes;
    
	private SQLQuery sqlQuery = new SQLQuery();
    
    public WindowDemo(){
	    browseButton = new JButton("Browse");
	    browseButton.setFont(new Font("微軟正黑體", Font.PLAIN, 12));
	    browseButton.setBounds(180,241,100,40);
	    getContentPane().setLayout(null);
	    getContentPane().add(browseButton);
	    
	    browseButton.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
				if(e.getSource()==browseButton) {
					JFileChooser file_upload = new JFileChooser();
					FileNameExtensionFilter filter = new FileNameExtensionFilter("Image Files", "jpg", "jpeg", "png", "gif");
				    file_upload.setFileFilter(filter);

					int res=file_upload.showSaveDialog(null);

					if(res==JFileChooser.APPROVE_OPTION) {
						file_path=new File(file_upload.getSelectedFile().getAbsolutePath());
					    try {
					    	imageBytes = Files.readAllBytes(file_path.toPath());
							ImageIcon icon = new ImageIcon(imageBytes);
							Image scaledImage = icon.getImage().getScaledInstance(359,280, Image.SCALE_SMOOTH);
							label = new JLabel(new ImageIcon(scaledImage));
							label.setBounds(323,237,359,280);
							getContentPane().add(label);
							getContentPane().revalidate();
							getContentPane().repaint();
							
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}

					}
				}
			}	
	    });

	    postTextArea = new JTextArea();
	    postTextArea.setFont(new Font("微軟正黑體", Font.PLAIN, 13));
	    postTextArea.setText("請輸入貼文內容");
	    postTextArea.setBounds(29, 97, 670, 130);
	    getContentPane().add(postTextArea);
	    
	    JLabel imageLabel = new JLabel("插入貼文照片");
	    imageLabel.setFont(new Font("微軟正黑體", Font.PLAIN, 12));
	    imageLabel.setBounds(29, 241, 108, 40);
	    getContentPane().add(imageLabel);
	    
	    JLabel locationLabel = new JLabel("領取地點");
	    locationLabel.setFont(new Font("微軟正黑體", Font.PLAIN, 12));
	    locationLabel.setBounds(29, 291, 108, 40);
	    getContentPane().add(locationLabel);
	    
	    text_location = new JTextField();
	    text_location.setFont(new Font("微軟正黑體", Font.PLAIN, 12));
	    text_location.setBounds(180, 301, 100, 21);
	    getContentPane().add(text_location);
	    text_location.setColumns(10);
	    
	    JLabel typeLabel = new JLabel("食物類型");
	    typeLabel.setFont(new Font("微軟正黑體", Font.PLAIN, 12));
	    typeLabel.setBounds(29, 341, 108, 40);
	    getContentPane().add(typeLabel);
	    
	    typeComboBox = new JComboBox();
	    typeComboBox.setFont(new Font("微軟正黑體", Font.PLAIN, 12));
	    typeComboBox.setModel(new DefaultComboBoxModel(new String[] {"便當", "飲料", "零食", "生鮮食材"}));
	    typeComboBox.setBounds(180, 350, 100, 23);
	    getContentPane().add(typeComboBox);
	    
	    JLabel startTimeLabel = new JLabel("開始發放時間 (e.g 13:30)");
	    startTimeLabel.setFont(new Font("微軟正黑體", Font.PLAIN, 12));
	    startTimeLabel.setBounds(29, 407, 141, 40);
	    getContentPane().add(startTimeLabel);
	    
	    text_startTime = new JTextField();
	    text_startTime.setFont(new Font("微軟正黑體", Font.PLAIN, 12));
	    text_startTime.setColumns(10);
	    text_startTime.setBounds(180, 419, 100, 21);
	    getContentPane().add(text_startTime);
	    
	    JLabel priceLabel = new JLabel("每份最低售價 (無可填0)");
	    priceLabel.setFont(new Font("微軟正黑體", Font.PLAIN, 12));
	    priceLabel.setBounds(29, 484, 141, 40);
	    getContentPane().add(priceLabel);
	    
	    text_price = new JTextField();
	    text_price.setFont(new Font("微軟正黑體", Font.PLAIN, 12));
	    text_price.setColumns(10);
	    text_price.setBounds(180, 494, 100, 21);
	    getContentPane().add(text_price);
	    
	    JLabel username = new JLabel("username");
	    username.setFont(new Font("微軟正黑體", Font.PLAIN, 14));
	    username.setBounds(29, 0, 757, 54);
	    getContentPane().add(username);
	    
	    JLabel endTimeLabel = new JLabel("領取截止時間 (e.g. 18:00)");
	    endTimeLabel.setFont(new Font("微軟正黑體", Font.PLAIN, 12));
	    endTimeLabel.setBounds(27, 442, 141, 40);
	    getContentPane().add(endTimeLabel);
	    
	    text_endTime = new JTextField();
	    text_endTime.setFont(new Font("微軟正黑體", Font.PLAIN, 12));
	    text_endTime.setColumns(10);
	    text_endTime.setBounds(180, 450, 100, 21);
	    getContentPane().add(text_endTime);
	    
	    JLabel amountLabel = new JLabel("發放數量");
	    amountLabel.setFont(new Font("微軟正黑體", Font.PLAIN, 12));
	    amountLabel.setBounds(29, 372, 141, 40);
	    getContentPane().add(amountLabel);
	    
	    text_amount = new JTextField();
	    text_amount.setFont(new Font("微軟正黑體", Font.PLAIN, 12));
	    text_amount.setColumns(10);
	    text_amount.setBounds(180, 384, 100, 21);
	    getContentPane().add(text_amount);
	    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    setLocationRelativeTo(null);
	    setSize(800,800);
	    setVisible(true);
	    
	    JButton postButton = new JButton("發佈貼文");
	    postButton.setFont(new Font("微軟正黑體", Font.BOLD, 14));
	    postButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String name = text_name.getText();
				String postContent = postTextArea.getText();
				byte[] image = imageBytes;
				String location = text_location.getText();
				String type = (String)typeComboBox.getSelectedItem();
				int amount = Integer.parseInt(text_amount.getText());
				String startTime = text_startTime.getText();
				String endTime = text_endTime.getText();
				int price = Integer.parseInt(text_price.getText());
				
				ProcessData uploadProduct = new ProcessData(name,postContent,image,location,type,amount,startTime,endTime,price);
				sqlQuery.uploadProduct(uploadProduct);
				
				//檢查上架是否成功
                boolean success = ((SQLQuery) sqlQuery).uploadProduct(uploadProduct);
                if (!success) {
                	JOptionPane.showMessageDialog(null, "Please complete the text.", "Upload Failed", JOptionPane.ERROR_MESSAGE);
                }else {
                	//上架成功後關閉視窗 即可回到首頁
                	JOptionPane.showMessageDialog(null, "Uploaded Successfully！", "Success", JOptionPane.INFORMATION_MESSAGE);
                	WindowDemo.this.dispose();
    		        // 連結到 HomePage
    		        HomePage homePage = new HomePage();
    		        homePage.setVisible(true);
                }
			
			}
		});
	    postButton.setBounds(29, 546, 670, 40);
	    getContentPane().add(postButton);
	    
	    JLabel NameLabel = new JLabel("\u98DF\u7269\u540D\u7A31");
	    NameLabel.setFont(new Font("微軟正黑體", Font.PLAIN, 12));
	    NameLabel.setBounds(29, 47, 108, 40);
	    getContentPane().add(NameLabel);
	    
	    text_name = new JTextField();
	    text_name.setFont(new Font("微軟正黑體", Font.PLAIN, 12));
	    text_name.setColumns(10);
	    text_name.setBounds(180, 57, 100, 21);
	    getContentPane().add(text_name);
	    
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
