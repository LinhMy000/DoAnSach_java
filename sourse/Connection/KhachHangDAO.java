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
public class KhachHangDAO {
    
    public List<KhachHang> getList(){
       try {
             Connection cons =  ConnectionDB.getConnection();
            String sql = "SELECT * FROM khachhang";
            List<KhachHang> list = new ArrayList<>();
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
            rs.close();
            cons.close();
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
}
    
     public int createOrUpdate(KhachHang khachhang) {
        try {
            Connection cons = ConnectionDB.getConnection();
            String sql = "INSERT INTO khachhang(makh, hoten,ngaysinh, sdt,diachi,diem) VALUES(?, ?, ?, ?, ?, ?)ON DUPLICATE KEY  UPDATE makh = VALUES(makh),hoten = VALUES(hoten), ngaysinh = VALUES(ngaysinh),sdt = VALUES(sdt),diachi = VALUES(diachi),diem= VALUES(diem);";
            PreparedStatement ps = cons.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            
            ps.setInt(1, khachhang.getMaKH());
            ps.setString(2, khachhang.getHoTen());
            ps.setDate(3,new Date(khachhang.getNgaySinh().getTime()));
            ps.setString(4, khachhang.getSdt());
            ps.setString(5, khachhang.getDiaChi());
            ps.setInt(6, khachhang.getDiem());
            ps.execute();
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
  
    public int DeLeTe(KhachHang khachhang) {
      try{  
        Connection cons = ConnectionDB.getConnection();
        String sql = "DELETE from khachhang where MaKH =?";
        PreparedStatement ps = cons.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
       
        ps.setInt(1,khachhang.getMaKH());
        int check = ps.executeUpdate();
        if(check>0)
            return check;
         
        }catch(Exception ex){
                ex.printStackTrace();
        }
        return 0;
    }
        public static void main(String[] args) {
        KhachHangDAO kh = new KhachHangDAO();
        System.out.println(kh.getList());
       
    }
}
