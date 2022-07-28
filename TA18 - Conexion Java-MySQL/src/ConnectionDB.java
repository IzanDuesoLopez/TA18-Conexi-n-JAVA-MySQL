import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionDB {
	public static Connection connection() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306?useTimezone=true&serverTimezone=UTC", "remote", "Admin1234");
			System.out.println("Server connected");
			return connection;
		} catch(SQLException | ClassNotFoundException e) {
			System.out.println("Could not connect to server");
			System.out.println(e);
		} 
		return null;
	}
}
