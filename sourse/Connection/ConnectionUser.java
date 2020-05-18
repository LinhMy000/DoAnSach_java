package Connection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import Table.User;

public class ConnectionUser {
	
	public User login(String taiKhoan, String matKhau) {
        Connection con = ConnectionDB.getConnection();
        String sql = "SELECT * FROM user WHERE taikhoan LIKE ? AND matkhau LIKE ?";
        User user = null;
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
}
