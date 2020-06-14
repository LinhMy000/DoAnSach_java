package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.mysql.jdbc.Statement;

import Connection.ConnectionDB;
import Table.User;

public class ModelUser {
	private static Connection con = ConnectionDB.getConnection();

	public static User login(String taiKhoan, String matKhau) {
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
        } 
        catch (Exception e) {
            System.out.println("Loi tai khoan!");
        	e.printStackTrace();
        }
        return user;
    }
	
	public static int register(String taiKhoan, String matKhau, String hoTen) {
		int row = 0;
        String sql = "insert into user values(null,?,?,?,1,0)";
        try {
        	PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, taiKhoan);
            ps.setString(2, matKhau);
            ps.setString(3, hoTen);
            row = ps.executeUpdate();
            ps.close();
		} 
        catch (Exception e) {
        	System.out.println("Loi dang ky tai khoan!");
        	e.printStackTrace();
		}
		return row;
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
        } 
        catch (Exception e) {
            System.out.println("Loi lay danh sach user!");
        	e.printStackTrace();
        }
        return list;
	}
	
	public static int update(User user) {
		int row = 0;
		String sql = "update user set taikhoan = ?, matkhau = ?, hoten = ?, tinhtrang = ?, quyen = ? where id = ?";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, user.getTaiKhoan());
			ps.setString(2, user.getMatKhau());
			ps.setString(3, user.getHoTen());
			ps.setBoolean(4, user.isTinhTrang());
			ps.setBoolean(5, user.isQuyen());
			ps.setInt(6, user.getId());
			row = ps.executeUpdate();
			ps.close();
		} 
		catch (Exception ex) {
        	System.out.println("Loi update tai khoan!");
			ex.printStackTrace();
		}
		return row;
	}
	
	public static int createOrUpdate(User user) {
        try {
            String sql = "INSERT INTO user VALUES(null, ?, ?, ?, ?, ?, ?) ON DUPLICATE KEY UPDATE taikhoan = VALUES(taikhoan), matkhau = VALUES(matkhau), hoten = VALUES(hoten), tinhtrang = VALUES(tinhtrang), quyen = VALUES(quyen);";
            PreparedStatement ps = con.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
//            ps.setInt(1, null);
            ps.setString(1, user.getTaiKhoan());
			ps.setString(2, user.getMatKhau());
			ps.setString(3, user.getHoTen());
			ps.setBoolean(4, user.isTinhTrang());
			ps.setBoolean(5, user.isQuyen());
//			ps.setInt(6, user.getId());
            ps.execute();
            ResultSet rs = ps.getGeneratedKeys();
            int generatedKey = 0;
            if (rs.next()) {
                generatedKey = rs.getInt(1);
            }
            ps.close();
            return generatedKey;
        } 
        catch (Exception e) {
            System.out.println("Khong the truy van!");
            e.printStackTrace();
        }
        return 0;
    }

	public static int delete(int id) {
		int row = 0;
		String sql = "delete from user where id=" + id;
		try {
			Statement st = (Statement) con.createStatement();
			row = st.executeUpdate(sql);
			st.close();
		}
		catch (SQLException e) {
        	System.out.println("Loi delete tai khoan!");
			e.printStackTrace();
		}
		return row;
	}
	
	public static int insert(User user) {
		int row = 0;
        String sql = "insert into user values(null,?,?,?,?,?)";
        try {
        	PreparedStatement ps = con.prepareStatement(sql);
        	ps.setString(1, user.getTaiKhoan());
        	ps.setString(2, user.getMatKhau());
            ps.setString(3, user.getHoTen());
            ps.setBoolean(4, user.isTinhTrang());
            ps.setBoolean(5, user.isQuyen());
            row = ps.executeUpdate();
            ps.close();
		} 
        catch (Exception e) {
        	System.out.println("Loi them tai khoan!");
        	e.printStackTrace();
		}
		return row;
	}
}
