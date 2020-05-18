/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Connection.KhachHangDAO;
import Model.ModelKhachHang;
import Table.KhachHang;
import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
//import java.sql.Date;
import java.util.Date;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author Huong_Nho_UIT
 */
public class ControllerKhachHang {
    
    private  JButton btnSubmit;
    private  JButton btnXoa;
    private JTextField jtfMaKH;
    private JTextField jtfTenKH;
    private JDateChooser jdcNgaySinh;
    private JTextField jtfSoDT;
    private JTextField jtfDiaChi;
    private JTextField jtfDiem;
    private JLabel jlbMsg;
    
    private KhachHang khachhang = null;
    private ModelKhachHang mkh = null;
    private KhachHangDAO khd = null;

    public ControllerKhachHang(JButton btnSubmit, JButton btnXoa, JTextField jtfMaKH, JTextField jtfTenKH, JDateChooser jdcNgaySinh, JTextField jtfSoDT, JTextField jtfDiaChi, JTextField jtfDiem, JLabel jlbMsg) {
        this.btnSubmit = btnSubmit;
        this.btnXoa = btnXoa;
        this.jtfMaKH = jtfMaKH;
        this.jtfTenKH = jtfTenKH;
        this.jdcNgaySinh = jdcNgaySinh;
        this.jtfSoDT = jtfSoDT;
        this.jtfDiaChi = jtfDiaChi;
        this.jtfDiem = jtfDiem;
        this.jlbMsg = jlbMsg;
        
     
        this.mkh = new ModelKhachHang();
        this.khd = new KhachHangDAO();
    }
    

  
    public void setView(KhachHang khachhang){
        this.khachhang = khachhang;
        
        jtfMaKH.setText(  " "+khachhang.getMaKH());
        jtfTenKH.setText(khachhang.getHoTen());
        
        jdcNgaySinh.setDate(khachhang.getNgaySinh());
        jtfSoDT.setText(khachhang.getSdt());
        jtfDiaChi.setText(khachhang.getDiaChi());
        jtfDiem.setText(" "+khachhang.getDiem());
        
        
    }
     public void setEvent(){
        btnSubmit.addMouseListener(new MouseAdapter(){
            
            public void mouseClicked(MouseEvent e){
                if(jtfTenKH.getText().isEmpty()){
                    JOptionPane.showMessageDialog(btnSubmit, "Vui lòng nhập thông tin khách hàng ");
                        
               
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
                        int ref  = JOptionPane.showConfirmDialog(btnSubmit,"Bạn có muốn lưu ?", "Lưu", JOptionPane.YES_NO_OPTION);
                        if(ref == JOptionPane.YES_OPTION)
                         JOptionPane.showMessageDialog(btnSubmit, "Cập nhập thành công  ");
                       
    
                    }
                }
            }
            public void mouseEntered(MouseEvent e){
                 btnSubmit.setBackground(new Color(0,200,83));
            }
            
            public void mouseExited(MouseEvent e){
                btnSubmit.setBackground(new Color(100,221,23));
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
        
