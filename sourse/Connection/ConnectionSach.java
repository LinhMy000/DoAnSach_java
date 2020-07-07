/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Connection;


import Table.Sach;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Huong_Nho_UIT
 */
public class ConnectionSach {
    public static List<Sach> getList() {
        try {
            Connection cons = ConnectionDB.getConnection();
            String sql = "SELECT * FROM sach";
            List<Sach> list = new ArrayList<>();
            PreparedStatement ps = (PreparedStatement) cons.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Sach sach=new Sach();
                sach.setMaSach(rs.getInt("masach"));
                sach.setTenSach(rs.getString("TenSach"));
                sach.setTacGia(rs.getString("TacGia"));
                sach.setSoLuong(rs.getInt("SoLuong"));
                sach.setGia(rs.getDouble("Gia"));
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
}
