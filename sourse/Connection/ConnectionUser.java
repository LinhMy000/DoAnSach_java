package Connection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import Table.User;


public class ConnectionUser {
	private static Connection con = ConnectionDB.getConnection();

	public User login(String taiKhoan, String matKhau) {
        User user = null;
        String sql = "SELECT * FROM user WHERE taikhoan LIKE ? AND matkhau LIKE ?";
        try {
            PreparedStatement ps = (PreparedStatement) con.prepareStatement(sql);
            ps.setString(1, taiKhoan);
            ps.setString(2, matKhau);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                user = new User();
                user.setId(rs.getInt("id"));
                user.setTaiKhoan(rs.getString("taikhoan"));
                user.setMatKhau(rs.getString("matkhau"));
                user.setTinhTrang(rs.getBoolean("tinhtrang"));
                user.setQuyen(rs.getBoolean("quyen"));
            }
            ps.close();
            con.close();
            return user;
        } 
        catch (Exception e) {
            System.out.println("Loi tai khoan!");
        	e.printStackTrace();
        }
        return null;
    }
	
	public static int register(String taiKhoan, String matKhau, String hoTen) {
        String sql = "insert into user values(null,?,?,?,1,0)";
        try {
        	PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, taiKhoan);
            ps.setString(2, matKhau);
            ps.setString(3, hoTen);
            int row = ps.executeUpdate();
            ps.close();
            con.close();
            return row;
		} 
        catch (Exception e) {
        	System.out.println("Loi dang ky tai khoan!");
        	e.printStackTrace();
		}
		return 0;
	}
	
	public static List<User> getUsers(){
		List<User> list = new ArrayList<>();
		String sql = "select * from user";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
            	User user = new User();
            	user.setId(rs.getInt("id"));
            	user.setTaiKhoan(rs.getString("taikhoan"));
            	user.setMatKhau(rs.getString("matkhau"));
            	user.setHoTen(rs.getString("hoten"));
            	user.setTinhTrang(rs.getBoolean("tinhtrang"));
            	user.setQuyen(rs.getBoolean("quyen"));
                list.add(user);
            }
            ps.close();
            con.close();
        } 
        catch (Exception e) {
            System.out.println("Loi lay danh sach user!");
        	e.printStackTrace();
        }
        return list;
	}
	
}
