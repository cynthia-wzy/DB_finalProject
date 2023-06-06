import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JTextArea;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;

public class WindowDemo extends JFrame{
	
	private JButton browseButton;
	private JFrame frame;
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
	    
	    postTextArea = new JTextArea();
	    postTextArea.setText("post content");
	    postTextArea.setBounds(28, 100, 1053, 118);
	    panel.add(postTextArea);
	    
	    JLabel NameLabel = new JLabel("food name");
	    NameLabel.setBounds(36, 72, 96, 18);
	    panel.add(NameLabel);
	    
	    text_name = new JTextField();
	    text_name.setColumns(10);
	    text_name.setBounds(148, 69, 96, 21);
	    panel.add(text_name);
	    
	    JLabel imageLabel = new JLabel("upload image");
	    imageLabel.setBounds(28, 241, 106, 15);
	    panel.add(imageLabel);
	    
	    browseButton = new JButton("Browse");
	    browseButton.setFont(new Font("微軟正黑體", Font.PLAIN, 12));
	    browseButton.setBounds(148,228,100,40);
	    panel.add(browseButton);
	    
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
	    
	    JLabel locationLabel = new JLabel("give out location");
	    locationLabel.setBounds(28, 297, 106, 18);
	    panel.add(locationLabel);
	    
	    text_location = new JTextField();
	    text_location.setBounds(148, 294, 96, 21);
	    panel.add(text_location);
	    text_location.setColumns(10);
	    
	    JLabel typeLabel = new JLabel("food type");
	    typeLabel.setBounds(28, 337, 106, 15);
	    panel.add(typeLabel);
	    
	    typeComboBox = new JComboBox();
	    typeComboBox.setModel(new DefaultComboBoxModel(new String[] {"lunch box", "drinks", "fresh green", "others"}));
	    typeComboBox.setBounds(148, 334, 96, 21);
	    panel.add(typeComboBox);
	    
	    JLabel startTimeLabel = new JLabel("give-out start time");
	    startTimeLabel.setBounds(28, 379, 106, 15);
	    panel.add(startTimeLabel);
	    
	    text_startTime = new JTextField();
	    text_startTime.setColumns(10);
	    text_startTime.setBounds(148, 379, 96, 21);
	    panel.add(text_startTime);
	    
	    JLabel priceLabel = new JLabel("lowest price per unit");
	    priceLabel.setBounds(28, 453, 106, 18);
	    panel.add(priceLabel);
	    
	    text_price = new JTextField();
	    text_price.setColumns(10);
	    text_price.setBounds(148, 450, 96, 21);
	    panel.add(text_price);
	    
	    JLabel username = new JLabel("username");
	    username.setBounds(28, 35, 104, 15);
	    panel.add(username);
	    
	    JLabel endTimeLabel = new JLabel("give-out end time");
	    endTimeLabel.setBounds(28, 413, 106, 18);
	    panel.add(endTimeLabel);
	    
	    text_endTime = new JTextField();
	    text_endTime.setColumns(10);
	    text_endTime.setBounds(148, 410, 96, 21);
	    panel.add(text_endTime);
	    
	    JLabel amountLabel = new JLabel("food amount");
	    amountLabel.setBounds(28, 494, 106, 18);
	    panel.add(amountLabel);
	    
	    text_amount = new JTextField();
	    text_amount.setColumns(10);
	    text_amount.setBounds(148, 491, 96, 21);
	    panel.add(text_amount);
	    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    setLocationRelativeTo(null);
	    
	    setSize(screenSize);
	    setVisible(true);
	    
	    JButton postButton = new JButton("post");
	    postButton.setBackground(Color.decode("#FFD300")); 
	    postButton.setFont(new Font("Ariel", Font.BOLD, 14));
	    postButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if (text_name.getText().isEmpty()
		                || postTextArea.getText().isEmpty()
		                || text_location.getText().isEmpty()
		                || text_amount.getText().isEmpty()
		                || text_startTime.getText().isEmpty()
		                || text_endTime.getText().isEmpty()
		                || text_price.getText().isEmpty()) {
					text_name.setText("");
					postTextArea.setText("");
					text_location.setText("");
					text_amount.setText("");
					text_startTime.setText("");
					text_endTime.setText("");
					text_price.setText("");
		            JOptionPane.showMessageDialog(null, "Please complete the text.", "Upload Failed", JOptionPane.ERROR_MESSAGE);
		        }else {
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
					/*sqlQuery.uploadProduct(uploadProduct);*/
					
					
	                boolean success = ((SQLQuery) sqlQuery).uploadProduct(uploadProduct);
	                if (!success) {
	                	JOptionPane.showMessageDialog(null, "Please complete the text.", "Upload Failed", JOptionPane.ERROR_MESSAGE);
	                }else {
	                	
	                	JOptionPane.showMessageDialog(null, "Uploaded Successfully", "Success", JOptionPane.INFORMATION_MESSAGE);
	                	WindowDemo.this.dispose();
	    		        
	    		        HomePage homePage = new HomePage();
	    		        setVisible(true);
	                }
		        }
			}
		});
	    postButton.setBounds(29, 546, 670, 40);
	    panel.add(postButton);
	    
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
