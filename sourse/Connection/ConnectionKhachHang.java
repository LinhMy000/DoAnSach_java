/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Connection;

import Table.KhachHang;
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
public class ConnectionKhachHang {

//    public KhachHang login(String maKH, String hoTen) {
//        KhachHang khachhang = null;
//        String sql = "SELECT * FROM khachhang WHERE makh LIKE ? AND hoten LIKE ?";
//        try {
//            Connection cons = ConnectionDB.getConnection();
//            PreparedStatement ps = (PreparedStatement) cons.prepareStatement(sql);
//            ps.setString(1, maKH);
//            ps.setString(2, hoTen);
//            ResultSet rs = ps.executeQuery();
//            if (rs.next()) {
//                khachhang = new KhachHang();
//                khachhang.setMaKH(rs.getInt("makh"));
//                khachhang.setHoTen(rs.getString("hoten"));
//                khachhang.setNgaySinh(rs.getDate("ngaysinh"));
//                khachhang.setSdt(rs.getString("sdt"));
//                khachhang.setDiaChi(rs.getString("diachi"));
//                khachhang.setDiem(rs.getInt("diem"));
//
//            }
//            ps.close();
//            cons.close();
//            return khachhang;
//        } catch (Exception e) {
//            System.out.println("Loi khach hang!");
//            e.printStackTrace();
//        }
//        return null;
//    }

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

    public static int register(String hoTen, Date ngaySinh, String sdt, String diaChi) {
        String sql = "insert into khachhang values(null,?,?,?,?,0)";
        try {
            Connection cons = ConnectionDB.getConnection();
            PreparedStatement ps = cons.prepareStatement(sql);
            ps.setString(1, hoTen);
            ps.setDate(2, ngaySinh);
            ps.setString(3, sdt);
            ps.setString(4, diaChi);
            int row = ps.executeUpdate();
            ps.close();
            cons.close();
            return row;
        } catch (Exception e) {
            System.out.println("Loi in khach hang!");
            e.printStackTrace();
        }
        return 0;
    }
    public static int createOrUpdate(KhachHang khachhang) {
        try {
            Connection cons = ConnectionDB.getConnection();
            String sql = "INSERT INTO khachhang(makh, hoten,ngaysinh, sdt,diachi,diem) VALUES(null,?, ?, ?, ?, ?,?)ON DUPLICATE KEY  UPDATE makh = VALUES(makh),hoten = VALUES(hoten), ngaysinh = VALUES(ngaysinh),sdt = VALUES(sdt),diachi = VALUES(diachi),diem= VALUES(diem);";
            PreparedStatement ps = cons.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            ps.setInt(1, khachhang.getMaKH());
            ps.setString(2, khachhang.getHoTen());
            ps.setDate(3, new Date(khachhang.getNgaySinh().getTime()));
            ps.setString(4, khachhang.getSdt());
            ps.setString(5, khachhang.getDiaChi());
            ps.setInt(6, khachhang.getDiem());
            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            int generatedKey = 0;
            if (rs.next()) {
                generatedKey = rs.getInt(1);
            }
            ps.close();
            cons.close();
            return generatedKey;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return 0;
    }

    public static int DeLeTe(KhachHang khachhang) {
        try {
            Connection cons = ConnectionDB.getConnection();
            String sql = "DELETE from khachhang where MaKH =?";
            PreparedStatement ps = cons.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);

            ps.setInt(1, khachhang.getMaKH());
            int check = ps.executeUpdate();
            if (check > 0) {
                return check;
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return 0;
    }

//    public static void main(String[] args) {
// ConnectionKhachHangHanConnectionKhachHangw KhachHangDAO();
//        System.out.println(kh.getList());
//
//    }
}
