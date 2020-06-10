package Controller;

import Connection.KhachHangDAO;
import Table.KhachHang;
import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Date;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

public class ControllerHoaDon {
    private JPanel pnViewSach;
    private JPanel pnViewCTHD;
    private JTextField jtfMaHD;
    private JComboBox jcbNhanVien;
    private JComboBox jcbKhachHang;
    private JDateChooser jdcNgayLap;
    private JButton jbnThem;
    private JButton jbnLamMoi;
    private JButton jbnThanhToan;

    public ControllerHoaDon(JPanel pnViewSach, JPanel pnViewCTHD, JTextField jtfMaHD, JComboBox jcbNhanVien, JComboBox jcbKhachHang, JDateChooser jdcNgayLap, JButton jbtThem, JButton jbtLamMoi, JButton jbtThanhToan) {
        this.pnViewSach = pnViewSach;
        this.pnViewCTHD = pnViewCTHD;
        this.jtfMaHD = jtfMaHD;
        this.jcbNhanVien = jcbNhanVien;
        this.jcbKhachHang = jcbKhachHang;
        this.jdcNgayLap = jdcNgayLap;
        this.jbnThem = jbtThem;
        this.jbnLamMoi = jbtLamMoi;
        this.jbnThanhToan = jbtThanhToan;
    }
            
    public void setView(){
        List<KhachHang> listItem = KhachHangDAO.getList();
//        DefaultTableModel model = new ClassTableModel().setTableKhachHang(listItem, listColumn);
        DefaultTableModel model = new DefaultTableModel();
        model.setColumnIdentifiers(new String[] {"STT" ,"Mã Sách","Tên Sách" , "Tác Giả" , "Giá" });
        Object[] obj = null;

        if (listItem.size() > 0) {
            for (int i = 0; i < listItem.size(); i++) {
                KhachHang khachhang = listItem.get(i);
                obj = new Object[5];
                obj[0] = khachhang.getMaKH();
                obj[1] = khachhang.getHoTen();
                obj[2] = khachhang.getNgaySinh();
                obj[3] = khachhang.getSdt();
                obj[4] = khachhang.getDiaChi();
                obj[5] = khachhang.getDiem();
                model.addRow(obj);
            }
        }
        
        JTable table = new JTable(model);
        TableRowSorter rowSorter = new TableRowSorter<>(table.getModel());
        table.setRowSorter(rowSorter);
        
    }
    
     public void setEvent(){
        jbnThem.addMouseListener(new MouseAdapter(){
            
            public void mouseClicked(MouseEvent e){
                if(jtfTenKH.getText().isEmpty()){
                    JOptionPane.showMessageDialog(jbnThem, "Vui lòng nhập thông tin khách hàng ");
                        
               
                }else{
                    khachhang.setHoTen(jtfTenKH.getText().trim());
                    khachhang.setNgaySinh((Date) jdcNgaySinh.getDate());
                    khachhang.setSdt(jtfSoDT.getText());
                    khachhang.setDiaChi(jtfDiaChi.getText());
                    khachhang.setDiem(0);
                    
                    int lastID = khd.createOrUpdate(khachhang);
                    if(lastID >0){
                        khachhang.setMaKH(lastID);
                        jtfMaKH.setText( " "+ lastID);
                        int ref  = JOptionPane.showConfirmDialog(jbnThem,"Bạn có muốn lưu ?", "Lưu", JOptionPane.YES_NO_OPTION);
                        if(ref == JOptionPane.YES_OPTION)
                            JOptionPane.showMessageDialog(jbnThem, "Cập nhập thành công  ");
                       
    
                    }
                }
            }
            public void mouseEntered(MouseEvent e){
                 jbnThem.setBackground(new Color(0,200,83));
            }
            
            public void mouseExited(MouseEvent e){
                jbnThem.setBackground(new Color(100,221,23));
            }
        });
        
       
    

}
     public void setEventDE(){
          btnXoa.addMouseListener(new MouseAdapter(){
            
            public void mouseClicked(MouseEvent e){
                if(jtfMaKH.getText().isEmpty()){
                    JOptionPane.showMessageDialog(btnXoa, "Vui lòng nhập mã khách hàng ");
                    
                 }else{
                    int lastID = khd.DeLeTe(khachhang);
                    if(lastID >0){
                        khachhang.setMaKH(lastID);
                        jtfMaKH.setText( " "+ lastID);
                        int ref = JOptionPane.showConfirmDialog(btnXoa, "Bạn có muốn xóa ?", "Xóa", JOptionPane.YES_NO_OPTION);
                        
                        if(ref == JOptionPane.YES_OPTION){
                         JOptionPane.showMessageDialog(btnXoa, "Xóa thành công  ");
                         
                        }
                        if(ref == JOptionPane.NO_OPTION){
                        JOptionPane.showMessageDialog(btnXoa, "No selected");
                        }
                        
                        
                              
                    }
                
                 }
            }
            @Override
             public void mouseEntered(MouseEvent e){
                 btnXoa.setBackground(new Color(0,200,83));
            }
            
            public void mouseExited(MouseEvent e){
                btnXoa.setBackground(new Color(100,221,23));
            }
        });
     }
}
