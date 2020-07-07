package Model;

import java.io.FileWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.Statement;

import Connection.ConnectionDB;
import Table.CTHD;
import Table.HoaDon;
import Table.Sach;

public class ModelHoaDon {

    private static Connection con = ConnectionDB.getConnection();

    public static HoaDon getHD(int ma) {
        HoaDon user = new HoaDon();
        String sql = "select * from hoadon where mahd = " + ma;
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                user.setMahd(rs.getInt("mahd"));
                user.setNgayhd(rs.getDate("ngay"));
                user.setMakh(rs.getInt("makh"));
                user.setManv(rs.getInt("id"));
                user.setTongTien(rs.getDouble("tongtien"));
                user.setCthd(getCTHDs(rs.getInt("mahd")));
            }
            ps.close();
        } catch (Exception e) {
            System.out.println("Loi lay danh sach hoa don!");
            e.printStackTrace();
        }
        return user;
    }

    public static List<HoaDon> getHoaDons() {
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
        } catch (Exception e) {
            System.out.println("Loi lay danh sach hoa don!");
            e.printStackTrace();
        }
        return list;
    }

    public static List<CTHD> getCTHDs(int ma) {
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
        } catch (Exception e) {
            System.out.println("Loi lay danh sach hoa don!");
            e.printStackTrace();
        }
        return list;
    }

    public static int insert(HoaDon user) {
        int mahd = 0;
        String sql = "insert into hoadon(mahd,ngay,makh,id,tongtien) values(null,?,?,?,?)";
        try {
            PreparedStatement ps = con.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            ps.setDate(1, user.getNgayhd());
            ps.setInt(2, user.getMakh());
            ps.setInt(3, user.getManv());
            ps.setDouble(4, user.getTongTien());
            ps.execute();
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                mahd = rs.getInt(1);	//Gia tri cua mahd moi duoc tu dong tao
            }
            ps.close();

            //Them cthd
            if (mahd != 0) {
                for (int i = 0; i < user.getCthd().size(); i++) {
                    CTHD ct = new CTHD();
                    ct.setMaHD(mahd);
                    ct.setMaSach(user.getCthd().get(i).getMaSach());
                    ct.setSoLuong(user.getCthd().get(i).getSoLuong());
                    ct.setThanhTien(user.getCthd().get(i).getThanhTien());
                    insertCTHD(ct);
                }
            } else {
                System.out.println("Loi them hoa don!");
            }
        } catch (Exception e) {
            System.out.println("Loi them hoa don va cthd!");
            e.printStackTrace();
        }
        return mahd;
    }

    public static int insertCTHD(CTHD ct) {
        int row = 0;
        String sql = "insert into cthd values(?,?,?,?)";
        try {
            PreparedStatement psi = con.prepareStatement(sql);
            psi.setInt(1, ct.getMaHD());
            psi.setInt(2, ct.getMaSach());
            psi.setInt(3, ct.getSoLuong());
            psi.setDouble(4, ct.getThanhTien());
            row = psi.executeUpdate();
            psi.close();
//	        if(row != 0) {
//				System.out.println("Them CTHD thanh cong !");
//	        }
        } catch (Exception e) {
            System.out.println("Loi them cthd!");
            e.printStackTrace();
        }
        return row;
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
        } catch (Exception ex) {
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
        } catch (SQLException e) {
            System.out.println("Loi delete cthd !");
            e.printStackTrace();
        }
        return row;
    }

    public static void xuatHD(int mahd) {
        try {
            FileWriter fw = new FileWriter("C:\\Users\\Huong_Nho_UIT\\Desktop\\TestXuatHD.txt");
            fw.write("Welcome to BookStore! \n\n");

            HoaDon h = getHD(mahd);
            SimpleDateFormat fm = new SimpleDateFormat("dd-MM-yyyy");
            fw.write("Ngay: " + fm.format(h.getNgayhd()) + "\n");
            fw.write("Khach hang: " + ModelKhachHang.getTenKH(h.getMakh()) + "\n");
            fw.write("Nhan vien: " + ModelUser.getTenUser(h.getManv()) + "\n\n");

            fw.write("Ten sach \t\tSo luong \tThanh tien \n");
            for (int i = 0; i < h.getCthd().size(); i++) {
                fw.write(ModelSach.getSach(h.getCthd().get(i).getMaSach()).getTenSach() + "\t\t");
                fw.write(h.getCthd().get(i).getSoLuong() + "\t\t");
                fw.write(h.getCthd().get(i).getThanhTien() + "00 vnd \n");
            }
            fw.write("\t\t\tTong cong: \t" + h.getTongTien() + "00 vnd");
            fw.close();
        } catch (Exception e) {
            System.out.println("Loi xuat hd" + e);
        }
        System.out.println("Success...");
    }
}
