/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Connection;

import Table.Sach;
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
public class SachDAO {
    
    public static List<Sach> getList(){
       try {
             Connection cons =  ConnectionDB.getConnection();
            String sql = "SELECT * FROM sach";
            List<Sach> list = new ArrayList<>();
            PreparedStatement ps = (PreparedStatement) cons.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Sach sach = new Sach();
                sach.setMaSach(rs.getInt("MaSach"));
                sach.setTenSach(rs.getString("TenSach"));
                sach.setTacGia(rs.getString("TacGia"));
                sach.setGia(rs.getDouble("Gia"));
                sach.setSoLuong(rs.getInt("SoLuong"));
                
            
                list.add(sach);
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
    
     public int createOrUpdate(Sach sach) {
        try {
            Connection cons = ConnectionDB.getConnection();
            String sql = "INSERT INTO sach(masach, tensach, tacgia, gia, soluong) VALUES(?, ?, ?, ?, ?, ?)ON DUPLICATE KEY  UPDATE masach = VALUES(masach),tensach = VALUES(tensach), tacgia = VALUES(tacgia),gia = VALUES(gia),soluong = VALUES(soluong);";
            PreparedStatement ps = cons.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            
            ps.setInt(1, sach.getMaSach());
            ps.setString(2, sach.getTenSach());
            ps.setString(3, sach.getTacGia());
            ps.setDouble(4, sach.getGia());
            ps.setInt(5, sach.getSoLuong());
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
  
    public int DeLeTe(Sach sach) {
      try{  
        Connection cons = ConnectionDB.getConnection();
        String sql = "DELETE from sach where MaSach =?";
        PreparedStatement ps = cons.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
       
        ps.setInt(1,sach.getMaSach());
        int check = ps.executeUpdate();
        if(check>0)
            return check;
         
        }catch(Exception ex){
                ex.printStackTrace();
        }
        return 0;
    }
        public static void main(String[] args) {
        SachDAO sach = new SachDAO();
        System.out.println(sach.getList());
       
    }
}
