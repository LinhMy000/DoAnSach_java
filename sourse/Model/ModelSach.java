package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.mysql.jdbc.Statement;

import Connection.ConnectionDB;
import Table.Sach;

public class ModelSach {
	private static Connection con = ConnectionDB.getConnection();

	public static List<Sach> getSachs(){
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
        } 
        catch (Exception e) {
            System.out.println("Loi lay danh sach sach!");
        	e.printStackTrace();
        }
        return list;
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
        } 
        catch (Exception e) {
            System.out.println("Khong the truy van!");
            e.printStackTrace();
        }
        return generatedKey;
    }

	public static int delete(int id) {
		int row = 0;
		String sql = "delete from sach where id=" + id;
		try {
			Statement st = (Statement) con.createStatement();
			row = st.executeUpdate(sql);
			st.close();
		}
		catch (SQLException e) {
        	System.out.println("Loi delete sach!");
			e.printStackTrace();
		}
		return row;
	}
	
}
