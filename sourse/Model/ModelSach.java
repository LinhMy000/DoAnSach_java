package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.mysql.jdbc.Statement;

import Connection.ConnectionDB;
import Table.KhachHang;
import Table.Sach;
import java.sql.Date;

public class ModelSach {

    private static Connection con = ConnectionDB.getConnection();

    public static Sach getSach(int id) {
        Sach s = new Sach();
        String sql = "select * from sach where masach = " + id;
        try {
            Statement ps = (Statement) con.createStatement();
            ResultSet rs = ps.executeQuery(sql);
            while (rs.next()) {
                s.setMaSach(rs.getInt("masach"));
                s.setTenSach(rs.getString("tensach"));
                s.setTacGia(rs.getString("tacgia"));
                s.setGia(rs.getDouble("gia"));
                s.setSoLuong(rs.getInt("soluong"));
            }
            ps.close();
        } catch (Exception e) {
            System.out.println("Loi tim sach !");
            e.printStackTrace();
        }
        return s;
    }

    public static List<Sach> getSachs() {
        List<Sach> list = new ArrayList<>();
        String sql = "select * from sach";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            Sach sach = null;
            while (rs.next()) {
                sach = new Sach();
                sach.setMaSach(rs.getInt("masach"));
                sach.setTenSach(rs.getString("tensach"));
                sach.setTacGia(rs.getString("tacgia"));
                sach.setGia(rs.getDouble("gia"));
                sach.setSoLuong(rs.getInt("soluong"));
                list.add(sach);
            }
            ps.close();
        } catch (Exception e) {
            System.out.println("Loi lay danh sach sach!");
            e.printStackTrace();
        }
        return list;
    }
    public static int update(Sach sach) {
		int row = 0;
		String sql = "update sach set tensach = ?, tacgia = ?, gia = ?, soluong = ?";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
                        ps.setString(1, sach.getTenSach());
                        ps.setString(2,sach.getTacGia());
                        ps.setDouble(3, sach.getGia());
                        ps.setInt(4, sach.getSoLuong());
                        
			row = ps.executeUpdate();
			ps.close();
		} 
		catch (Exception ex) {
        	System.out.println("Lỗi update sách!");
			ex.printStackTrace();
		}
		return row;
	}

    public static int createOrUpdate(Sach sach) {
        int generatedKey = 0;
        try {
            String sql = "INSERT INTO sach VALUES(null, ?, ?, ?, ?) ON DUPLICATE KEY UPDATE tensach = VALUES(tensach), tacgia = VALUES(tacgia), gia = VALUES(gia), soluong = VALUES(soluong);";
            PreparedStatement ps = con.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            ps.setString(1, sach.getTenSach());
            ps.setString(2, sach.getTacGia());
            ps.setDouble(3, sach.getGia());
            ps.setInt(4, sach.getSoLuong());
            ps.execute();
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                generatedKey = rs.getInt(1);
            }
            ps.close();
        } catch (Exception e) {
            System.out.println("Khong the truy van!");
            e.printStackTrace();
        }
        return generatedKey;
    }

    public static int insert(Sach sach) {
        int row = 0;
        String sql = "insert into sach values(null,?,?,?,?)";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, sach.getTenSach());
            ps.setString(2, sach.getTacGia());
            ps.setDouble(3, sach.getGia());
            ps.setInt(4, sach.getSoLuong());
            row = ps.executeUpdate();
            ps.close();
        } catch (Exception e) {
            System.out.println("Loi them sach!");
            e.printStackTrace();
        }
        return row;
    }

    public static int delete(int id) {
        int row = 0;
        String sql = "delete from sach where masach=" + id;
        try {
            Statement st = (Statement) con.createStatement();
            row = st.executeUpdate(sql);
            st.close();
        } catch (SQLException e) {
            System.out.println("Loi delete sach!");
            e.printStackTrace();
        }
        return row;
    }

}
