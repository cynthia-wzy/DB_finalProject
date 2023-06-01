//專門用來寫query
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
			pre.setString(1,"108305091"); //User待修正
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
			return false;
		}
	}
	
	//LoginPage
	public List<ProcessData> findUserWithUserID(){
		try {
			PreparedStatement pre = ConnectDB.getCon()
					.prepareStatement("SELECT * FROM NCCUUser WHERE UserID = '108305091'"); //UserID還要再改
			ResultSet rs = pre.executeQuery();
			while(rs.next()) {
				ProcessData data = new ProcessData();
				data.setAccount(rs.getString("UserID"));
				data.setPassword(rs.getString("Password"));
				this.data.add(data);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return this.data;
	}

}
