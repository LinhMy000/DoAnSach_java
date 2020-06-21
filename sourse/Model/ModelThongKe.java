package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import Connection.ConnectionDB;
import Table.ThongKeDoanhThu;
import Table.ThongKeSach;

public class ModelThongKe {
	private static Connection con = ConnectionDB.getConnection();
	
	public static List<ThongKeSach> getThongKeSach() {
        String sql = "SELECT cthd.masach, tensach, SUM(cthd.soluong) as soluong FROM sach, cthd WHERE sach.masach = cthd.masach GROUP BY masach, tensach ORDER BY soluong DESC LIMIT 5;";
        List<ThongKeSach> list = new ArrayList<>();
        try {
            PreparedStatement ps = (PreparedStatement) con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
            	ThongKeSach tks = new ThongKeSach();
            	tks.setMa(rs.getInt("masach"));
            	tks.setTen(rs.getString("tensach"));
                tks.setSl(rs.getInt("soluong"));
                list.add(tks);
            }
            ps.close();
            return list;
        } 
        catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
	
	public static List<ThongKeSach> getThongKeTacGia() {
        String sql = "SELECT cthd.masach, tacgia, SUM(cthd.soluong) as soluong FROM sach, cthd WHERE sach.masach = cthd.masach GROUP BY masach, tacgia ORDER BY soluong DESC LIMIT 3;";
        List<ThongKeSach> list = new ArrayList<>();
        try {
            PreparedStatement ps = (PreparedStatement) con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
            	ThongKeSach tks = new ThongKeSach();
            	tks.setMa(rs.getInt("masach"));
            	tks.setTen(rs.getString("tacgia"));
                tks.setSl(rs.getInt("soluong"));
                list.add(tks);
            }
            ps.close();
            return list;
        } 
        catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
	
	public static List<ThongKeDoanhThu> getThongKeDoanhThuThang() {
        String sql = "SELECT month(ngay) as thang, SUM(tongtien) as doanhthu FROM hoadon GROUP BY thang;";
        List<ThongKeDoanhThu> list = new ArrayList<>();
        try {
            PreparedStatement ps = (PreparedStatement) con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
            	ThongKeDoanhThu tks = new ThongKeDoanhThu();
            	tks.setTien(rs.getDouble("doanhthu"));
                tks.setTime(rs.getInt("thang"));
                list.add(tks);
            }
            ps.close();
            return list;
        } 
        catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
