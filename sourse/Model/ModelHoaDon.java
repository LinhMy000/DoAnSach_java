package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.Statement;

import Connection.ConnectionDB;
import Table.CTHD;
import Table.HoaDon;
import Table.User;

public class ModelHoaDon {
	private static Connection con = ConnectionDB.getConnection();

	public static List<HoaDon> getHoaDons(){
		List<HoaDon> list = new ArrayList<>();
		String sql = "select * from hoadon";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
            	HoaDon user = new HoaDon();
            	user.setMahd(rs.getInt("mahd"));
            	user.setNgayhd(rs.getDate("ngay"));
            	user.setMakh(rs.getInt("makh"));
            	user.setManv(rs.getInt("id"));
            	user.setTongTien(rs.getDouble("tongtien"));
            	user.setCthd(getCTHDs(rs.getInt("mahd")));
                list.add(user);
            }
            ps.close();
        } 
        catch (Exception e) {
            System.out.println("Loi lay danh sach hoa don!");
        	e.printStackTrace();
        }
        return list;
	}
	
	public static List<CTHD> getCTHDs(int ma){
		List<CTHD> list = new ArrayList<>();
    	CTHD user = null;
		String sql = "select * from CTHD where mahd = " + ma;
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
            	user = new CTHD();
            	user.setMaHD(rs.getInt("mahd"));
            	user.setMaSach(rs.getInt("masach"));
            	user.setSoLuong(rs.getInt("soluong"));
            	user.setThanhTien(rs.getDouble("thanhtien"));
                list.add(user);
            }
            ps.close();
        } 
        catch (Exception e) {
            System.out.println("Loi lay danh sach hoa don!");
        	e.printStackTrace();
        }
        return list;
	}
	
	public static int insert(HoaDon user) {
		int mahd = (Integer) null;
        String sql = "insert into hoadon values(null,?,?,?,?)";
        try {
        	PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        	ps.setDate(1, user.getNgayhd());
        	ps.setInt(2, user.getMakh());
            ps.setInt(3, user.getManv());
            ps.setDouble(4, user.getTongTien());
            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                mahd = rs.getInt("mahd");	//Gia tri cua mahd moi duoc tu dong tao
            }     
            ps.close();
            
            //Them cthd
            con.setAutoCommit(false);
            for (int i = 0; i < user.getCthd().size(); i++) {
				sql = "insert into cthd values(?,?,?,?)";
				PreparedStatement psi = con.prepareStatement(sql);
	        	psi.setInt(1, mahd);
	        	psi.setInt(2, user.getCthd().get(i).getMaSach());
	        	psi.setInt(3, user.getCthd().get(i).getSoLuong());
	        	psi.setDouble(4, user.getCthd().get(i).getThanhTien());
	            psi.executeUpdate();
	            psi.close();
			}
            con.commit();
		} 
        catch (Exception e) {
        	System.out.println("Loi them hoa don!");
        	e.printStackTrace();
		}
		return mahd;
	}
	
	public static int update(CTHD user) {
		int row = 0;
		try {
			//Lay gia tu bang sach
			String sqlGia = "select gia from sach where masach = " + user.getMaSach();
			Statement st = (Statement) con.createStatement();
			ResultSet res = st.executeQuery(sqlGia);
			double gia = 0;
			if (res.next()) {
                gia = res.getDouble(1);
            }  
			st.close();
			
			//Cap nhat so luong va tien khi sua so luong
			String sql = "update cthd set soluong = ?, thanhtien = ? where mahd = ? and masach = ?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, user.getSoLuong());
			ps.setDouble(2, user.getSoLuong() * gia);
			ps.setInt(3, user.getMaHD());
			ps.setInt(4, user.getMaSach());
			row = ps.executeUpdate();
			ps.close();
		} 
		catch (Exception ex) {
        	System.out.println("Loi update cthd !");
			ex.printStackTrace();
		}
		return row;
	}

	public static int delete(int mahd, int masach) {
		int row = 0;
		String sql = "delete from cthd where mahd = " + mahd + " and masach = " + masach;
		try {
			Statement st = (Statement) con.createStatement();
			row = st.executeUpdate(sql);
			st.close();
		}
		catch (SQLException e) {
        	System.out.println("Loi delete cthd !");
			e.printStackTrace();
		}
		return row;
	}

}
