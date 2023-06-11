import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class SQLQuery {
	
	List<ProcessData> data = new ArrayList<ProcessData>();
	
	//WindowDemo模板
	public boolean uploadProduct(ProcessData uploadProduct){
		try {
			PreparedStatement pre = ConnectDB.getCon()
					.prepareStatement("INSERT INTO Post (UserID,Memo,Image,FoodName,FoodType,FoodLocation,FoodAmount,PickupTime,PickupDDL,MinPrice) VALUES (?,?, ?, ?, ?, ?,?,?,?,?)");
			
			//資料庫還沒有建Account//已建立UserID
			pre.setString(1,"aaa123"); //User要等整合
			pre.setString(2,uploadProduct.getPostContent());
			pre.setBytes(3,uploadProduct.getGraph());
			//GUI沒有食物名稱//GUI新增食物名稱
			pre.setString(4,uploadProduct.getName());
			pre.setString(5,uploadProduct.getType());
			pre.setString(6,uploadProduct.getLocation());
			//購買時間應從資料庫刪除//已刪除
			pre.setInt(7,uploadProduct.getAmount());
			pre.setString(8,uploadProduct.getStartTime());
			pre.setString(9,uploadProduct.getEndTime());
			pre.setInt(10,uploadProduct.getPrice());
			return pre.executeUpdate() > 0;
		} catch (SQLException e) {
			return false;
		}
	}
	
	//RegisterPage
	public boolean registration(ProcessData registration){
		try {
			PreparedStatement pre = ConnectDB.getCon()
					.prepareStatement("INSERT INTO NCCUUser (UserID,Password) VALUES (?,?)");
			//資料庫還沒有建Account//已建立UserID
			pre.setString(1,registration.getAccount());
			pre.setString(2,registration.getPassword());
			return pre.executeUpdate() > 0;
		} catch (SQLException e) {
			e.printStackTrace(); 
			return false;
		}
	}
	
	//LoginPage
	public String checkUserWithUserID(String userID, String password, String userName){//修改中
		String result = "";
		try {
			PreparedStatement pre = ConnectDB.getCon()
					.prepareStatement("SELECT * FROM NCCUUser WHERE UserID = ?"); 
			pre.setString(1, userID);
			ResultSet rs = pre.executeQuery();
			while(rs.next()) {//有找到這個使用者
				String DBPassword = rs.getString("Password");
				if(DBPassword.equals(password)) {//使用者輸入的密碼與資料庫裡的相同
					updateUserWithUserID(userID,userName);
					result = "Login Successfully";
				}else {//使用者輸入的密碼與資料庫裡的不同
					result = "Wrong Password";
				}
			}
		} catch (SQLException e) {//沒有找到這個使用者
			result = "No such user";
			e.printStackTrace();
		}
		return result;
	}
	
	//LoginPage
	public void updateUserWithUserID(String userID, String userName){//確定有這個使用者才會用這個方法
		try {
			PreparedStatement pre = ConnectDB.getCon()
					.prepareStatement("UPDATE NCCUUser SET UserName = ? WHERE UserID = ?"); 
			pre.setString(1, userName);
			pre.setString(2, userID);
			pre.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	//PostView
	public List<ProcessData> findPost(int postID){//修改中
		try {
			PreparedStatement pre = ConnectDB.getCon()
					.prepareStatement("SELECT * FROM Post WHERE PostID = ?");  //預設用PostID來找
			pre.setInt(1, postID);
			ResultSet rs = pre.executeQuery();
			while(rs.next()) {
				ProcessData data = new ProcessData();
				data.setAccount(rs.getString("UserID"));
				data.setPostID(rs.getInt("PostID"));
				data.setGraph(rs.getBytes("Image"));
				data.setName(rs.getString("FoodName"));
				data.setType(rs.getString("FoodType"));
				data.setLocation(rs.getString("FoodLocation"));
				data.setPostContent(rs.getString("Memo"));
				data.setAmount(rs.getInt("FoodAmount"));
				data.setPeopleWaiting(rs.getInt("PeopleWaiting"));
				data.setStartTime(rs.getString("PickupTime"));
				data.setEndTime(rs.getString("PickupDDL"));
				data.setPrice(rs.getInt("MinPrice"));
				this.data.add(data);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return this.data;	
		
	}
	
	//PostView //卡位
	public boolean placeHolder(String userID, int postID, int amount){//要怎麼拿到UserID咧:)
		try {
			PreparedStatement pre = ConnectDB.getCon()
					.prepareStatement("INSERT INTO Placeholder (UserID,PostID,Amount) VALUES (?,?,?)");
			pre.setString(1,userID);
			pre.setInt(2,postID);
			pre.setInt(3,amount);
			return pre.executeUpdate() > 0;
		} catch (SQLException e) {
			e.printStackTrace(); 
			return false;
		}
	}
	
	//PostView //延後
	public void delayPickup(String userID, int postID){//要怎麼拿到UserID咧:)
		try {
			PreparedStatement pre = ConnectDB.getCon()
					.prepareStatement("UPDATE Placeholder SET Delay = ? WHERE UserID = ? AND PostID = ?"); 
			pre.setInt(1, 1);
			pre.setString(2, userID);
			pre.setInt(3, postID);
			pre.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	//PostView //計算等待人數
	public int countPeopleWaiting(int postID){
		int count = 0;
		try {
			PreparedStatement pre = ConnectDB.getCon()
					.prepareStatement("SELECT COUNT(*) FROM Placeholder WHERE PostID = ?");
			pre.setInt(1, postID);
			ResultSet rs = pre.executeQuery();
			if (rs.next()) {
				count = rs.getInt(1); // 獲取結果集中的第一列的值，即 SUM
		    }
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return count;
	}
	
	//PostView //更新等待人數
	public int upadatePeopleWaiting(int postID){
		int peopleWaiting = countPeopleWaiting(postID);
		try {
			PreparedStatement pre = ConnectDB.getCon()
						.prepareStatement("UPDATE Post SET PeopleWaiting = ? WHERE PostID = ?");
			pre.setInt(1, peopleWaiting);
			pre.setInt(2, postID);
			pre.executeUpdate();//更新資料庫
		} catch (SQLException e) {
				e.printStackTrace();
		}
		return peopleWaiting;
	}
	
	//PostView //計算商品剩餘數量
	public int countTotalFoodAmount(int postID){
		int sum = 0;
		try {
			PreparedStatement pre = ConnectDB.getCon()
					.prepareStatement("SELECT SUM(Amount) FROM Placeholder WHERE PostID = ?");
			pre.setInt(1, postID);
			ResultSet rs = pre.executeQuery();
			
			if (rs.next()) {
				sum = rs.getInt(1); // 獲取結果集中的第一列的值，即 SUM
		    }
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return sum;
	}
	
	//PostView //更新商品剩餘數量 //更改中
	public int updateTotalFoodAmount(int postID, int remaining){
		int sum = 0;
		try {
			PreparedStatement pre = ConnectDB.getCon()
					.prepareStatement("UPDATE Post SET FoodAmount = ? WHERE PostID = ?");
			pre.setInt(1, remaining);//待更正
			pre.setInt(2, postID);
			pre.executeUpdate();//更新資料庫
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return sum;
	}
	
	// HomePage // get posts info
	public List<PostInfo> allPostInfo(){
		List<PostInfo> postInfos = new ArrayList<>();
	    
		try {
	        Connection con = ConnectDB.getCon();
	        String query = "SELECT Image, FoodName, FoodLocation, FoodAmount, PickupDDL, MinPrice"
	                + " FROM Post";
	        Statement stat = con.createStatement();
	        ResultSet rs = stat.executeQuery(query);
	        
	        while (rs.next()) {
	        	
	            String foodName = rs.getString("FoodName");
	            String foodLocation = rs.getString("FoodLocation");
	            int foodAmount = rs.getInt("FoodAmount");
	            String pickupDDL = rs.getTime("PickupDDL").toString();
	            int minPrice = rs.getInt("MinPrice");
	            byte[] imageData = rs.getBytes("Image");

	            PostInfo postInfo = new PostInfo(imageData, foodName, foodLocation, foodAmount, pickupDDL, minPrice);
	            postInfos.add(postInfo);
	        }

	        con.close(); 
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    
	    return postInfos;
	}

}
