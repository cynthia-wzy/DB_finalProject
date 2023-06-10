//用來連結資料庫 //統一用這個class連結資料庫
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectDB {
	private static Connection con;
	private static String server = "jdbc:mysql://140.119.19.73:3315/"; 
	private static String database = "108305091";
	private static String url = server + database + "?useSSL=false";
	private static String username = "108305091";
	private static String password = "o8fzq"; 
	
	public static Connection getCon() {
		/*String server = "jdbc:mysql://140.119.19.73:3315/";
		String database = "108305091";
		String url = server + database + "?useSSL=false";
		String username = "108305091";
		String password = "password";*/
		
		try {
			con = DriverManager.getConnection(url, username, password);
			System.out.print("DB Connected");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return con;
	}
}
