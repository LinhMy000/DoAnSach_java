/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Connection.ConnectionDB;
import Connection.KhachHangDAO;
import Table.KhachHang;
import com.mysql.jdbc.Statement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Huong_Nho_UIT
 */
public class ModelKhachHang {
    
    private static Connection con = ConnectionDB.getConnection();
        KhachHangDAO khd = null;
    
     public KhachHang login(String maKH, String hoTen) {
        KhachHang khachhang = null;
        String sql = "SELECT * FROM khachhang WHERE makh LIKE ? AND hoten LIKE ?";
        try {
           
            PreparedStatement ps = (PreparedStatement) con.prepareStatement(sql);
            ps.setString(1, maKH);
            ps.setString(2, hoTen);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                khachhang = new KhachHang();
                khachhang.setMaKH(rs.getInt("makh"));
                khachhang.setHoTen(rs.getString("hoten"));
                khachhang.setNgaySinh(rs.getDate("ngaysinh"));
                khachhang.setSdt(rs.getString("sdt"));
                khachhang.setDiaChi(rs.getString("diachi"));
                khachhang.setDiem(rs.getInt("diem"));

            }
            ps.close();
            con.close();
            return khachhang;
        } catch (Exception e) {
            System.out.println("Loi khach hang!");
            e.printStackTrace();
        }
        return null;
    }

 
     public static int register(String hoTen, Date ngaySinh, String sdt, String diaChi) {
        String sql = "insert into khachhang values(null,?,?,?,?,0)";
        try {
           
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, hoTen);
            ps.setDate(2, ngaySinh);
            ps.setString(3, sdt);
            ps.setString(4, diaChi);
            int row = ps.executeUpdate();
            ps.close();
            con.close();
            return row;
        } catch (Exception e) {
            System.out.println("Loi in khach hang!");
            e.printStackTrace();
        }
        return 0;
    }

    public List<KhachHang> getList() {
        return khd.getList();
    }
    
	public static int update(KhachHang khachhang) {
		int row = 0;
		String sql = "update khachhang set hoten = ?, ngaysinh = ?, sdt = ?, diachi = ?, diem = ? where makh = ?";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
                        ps.setString(1, khachhang.getHoTen());
                        ps.setDate(2, (Date) khachhang.getNgaySinh());
                        ps.setString(3, khachhang.getSdt());
                        ps.setString(4, khachhang.getDiaChi());
                        ps.setInt(5,khachhang.getDiem());
			row = ps.executeUpdate();
			ps.close();
		} 
		catch (Exception ex) {
        	System.out.println("Loi update khach hang!");
			ex.printStackTrace();
		}
		return row;
	}
//        
        public static int createOrUpdate(KhachHang khachhang) {
        try {
            String sql = "INSERT INTO khachhang VALUES(null,?, ?, ?, ?, ?)ON DUPLICATE KEY  UPDATE hoten = VALUES(hoten), ngaysinh = VALUES(ngaysinh),sdt = VALUES(sdt),diachi = VALUES(diachi),diem= VALUES(diem);";
            PreparedStatement ps = con.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
           
            ps.setString(1, khachhang.getHoTen());
            ps.setDate(2, new Date(khachhang.getNgaySinh().getTime()));
            ps.setString(3, khachhang.getSdt());
            ps.setString(4, khachhang.getDiaChi());
            ps.setInt(5, khachhang.getDiem());
            ps.execute();
            ResultSet rs = ps.getGeneratedKeys();
            int generatedKey = 0;
            if (rs.next()) {
                generatedKey = rs.getInt(1);
            }
            ps.close();
            con.close();
            return generatedKey;
        } catch (Exception ex) {
            System.out.println("Khong the truy van!");
            ex.printStackTrace();
        }
        return 0;
    }public static int insert(KhachHang khachhang) {
		int row = 0;
        String sql = "insert into khachhang values(null,?,?,?,?,?)";
        try {
        	PreparedStatement ps = con.prepareStatement(sql);
                ps.setString(1, khachhang.getHoTen());
                ps.setDate(2, (Date) khachhang.getNgaySinh());
                ps.setString(3, khachhang.getSdt());
                ps.setString(4, khachhang.getDiaChi());
                ps.setInt(5, khachhang.getDiem());
            row = ps.executeUpdate();
            ps.close();
		} 
        catch (Exception e) {
        	System.out.println("Loi them khach hang!");
        	e.printStackTrace();
		}
		return row;
	}

     public static int delete(int makh) {
		int row = 0;
		String sql = "delete from khachhang where makh = "+makh;
		try {
			Statement st = (Statement) con.createStatement();
			row = st.executeUpdate(sql);
			st.close();
		}
		catch (SQLException e) {
        	System.out.println("Loi delete khach hang!");
			e.printStackTrace();
		}
		return row;
	}
     
}
