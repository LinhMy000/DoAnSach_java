/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Connection;

import Connection.ConnectionDB;
import Table.Sach;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author dell
 */
public class SachDAOImpl implements SachDAO {
    
    @Override
    public List<Sach> getlist(){
        Connection conn = ConnectionDB.getConnection();
        String sql = "Select * from sach";
        List <Sach> list =  new ArrayList <>();
        try {
            PreparedStatement ps = (PreparedStatement) conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Sach sach = new Sach();
                sach.setMaSach(rs.getInt("masach"));
                sach.setTenSach(rs.getString("tensach"));
                sach.setTacGia(rs.getString("tacgia"));
                sach.setGia (rs.getDouble("gia"));
                sach.setSoLuong (rs.getInt("soluong")); 
                list.add(sach);
            }
            ps.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
}
