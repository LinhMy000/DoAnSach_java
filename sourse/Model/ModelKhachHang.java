/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Connection.ConnectionDB;
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
        
    public static String getTenKH(int makh){
		String name = null;
		String sql = "select hoten from khachhang where makh = " + makh;
        try {
            Statement ps = (Statement) con.createStatement();
            ResultSet rs = ps.executeQuery(sql);
            while (rs.next()) {
            	name = rs.getString(1);
            }
            ps.close();
        } 
        catch (Exception e) {
            System.out.println("Loi tim ten khach hang !");
        	e.printStackTrace();
        }
        return name;
	}


    public static List<KhachHang> getList() {
       List<KhachHang> list = new ArrayList<>();
        String sql = "SELECT * FROM khachhang";
          
        try {
            Connection cons = ConnectionDB.getConnection();
            PreparedStatement ps = (PreparedStatement) cons.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                KhachHang khachhang = new KhachHang();
                khachhang.setMaKH(rs.getInt("MaKH"));
                khachhang.setHoTen(rs.getString("HoTen"));
                khachhang.setNgaySinh(rs.getDate("NgaySinh"));
                khachhang.setSdt(rs.getString("SDT"));
                khachhang.setDiaChi(rs.getString("DiaChi"));
                khachhang.setDiem(rs.getInt("Diem"));

                list.add(khachhang);
            }
            ps.close();
            cons.close();
            
        } catch (SQLException e) {
            System.out.println("Loi lay ra danh sach khach hang!");
            e.printStackTrace();
        }
        return list;
    }
    
	public static int update(KhachHang khachhang) {
		int row = 0;
		String sql = "update khachhang set hoten = ?, ngaysinh = ?, sdt = ?, diachi = ?, diem = ? where makh = ?";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
                        ps.setString(1, khachhang.getHoTen());
                        ps.setDate(2, (java.sql.Date) khachhang.getNgaySinh());
                        ps.setString(3, khachhang.getSdt());
                        ps.setString(4, khachhang.getDiaChi());
                        ps.setInt(5,khachhang.getDiem());
			row = ps.executeUpdate();
			ps.close();
		} 
		catch (Exception ex) {
        	System.out.println("Lỗi update khách hàng!");
			ex.printStackTrace();
		}
		return row;
	}
//        
        public static int createOrUpdate(KhachHang khachhang) {
        try {
            String sql = "INSERT INTO khachhang VALUES(null,?, ?, ?, ?, ?)ON DUPLICATE KEY  UPDATE hoten = VALUES(hoten), ngaysinh = VALUES(ngaysinh),sdt = VALUES(sdt),diachi = VALUES(diachi),diem= VALUES(diem);";
            PreparedStatement ps = con.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
//           new Date
            ps.setString(1, khachhang.getHoTen());
            ps.setDate(2, new java.sql.Date(khachhang.getNgaySinh().getTime()));
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
    }
        public static int insert(KhachHang khachhang) {
		int row = 0;
        String sql = "insert into khachhang values(null,?,?,?,?,?)";
        try {
        	PreparedStatement ps = con.prepareStatement(sql);
                ps.setString(1, khachhang.getHoTen());
                ps.setDate(2, new java.sql.Date (khachhang.getNgaySinh().getTime()));
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
