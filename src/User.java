public class User {
	
	private String userID;
	private String userName;
	private String password;
	
	private boolean named;//確認使用者是否匿名
	
	public User(String userID, String userName, String password, boolean named) {
		
		this.userID = userID;
		this.userName = userName;
		this.password = password;
		this.named = named;
		
	}
	
	public User(String userID) {
		
		this.userID = userID;
		
	}
	
	public String getUserID() {
		
		return userID;
		
	}
	
	public String getUserName() {
		
		return userName;
		
	}
	
	public String getPassword() {
		
		return password;
		
	}
	
	public boolean getNamed() {
		
		return named;
		
	}
	
	public boolean checkLogin(String userID) { //確認使用者是否已經登入
		
		if(this.userID.equals(userID)) { //如果使用者輸入的ID已經被建立 就代表已登入
			
			return true;
			
		}else {
			
			return false;
			
		}
		
	}

}
