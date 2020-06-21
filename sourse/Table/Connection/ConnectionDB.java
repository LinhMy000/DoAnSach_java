package Connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionDB {
	private static String url = "jdbc:mysql://localhost:3306/quanlysach";
    private static String user = "root";
    private static String pass = "";
    
	public static Connection getConnection() {
        Connection con = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(url, user, pass);
//            System.out.println("Ket noi thanh cong csdl!");
        } 
        catch (ClassNotFoundException | SQLException e) {
            System.out.println("Khong ket noi duoc csdl!");
            e.printStackTrace();
        }
        return con;
    }
	
//	public static void main(String[] args) throws SQLException{
//		Connection c = getConnection();
//	    c.close();
//    }
	
}
