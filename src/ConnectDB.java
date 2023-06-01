//用來連結資料庫 //統一用這個class連結資料庫
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectDB {
	private static Connection con;
	private static String server = /*"jdbc:mysql://140.119.19.73:3315/"*/; 
	private static String database = /*"studentID"*/;
	private static String url = server + database + "?useSSL=false";
	/*private static String username = "studentID";
	private static String password = "password"; */
	
	public static Connection getCon() {
		/*String server = "jdbc:mysql://140.119.19.73:3315/";
		String database = "studentID";*/
		String url = server + database + "?useSSL=false";
		/*String username = "studentID";
		String password = "password";*/
		
		try {
			con = DriverManager.getConnection(url, username, password);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return con;
	}
}