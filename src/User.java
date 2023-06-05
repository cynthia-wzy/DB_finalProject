public class User {
	
	private String userID;
	private String userName;
	private String password;
	
	private boolean named;//unnamed or not
	
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
	
	public boolean checkLogin(String userID) { //login or not
		
		if(this.userID.equals(userID)) { //user has logined
			
			return true;
			
		}else {
			
			return false;
			
		}
		
	}

}
