/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Connection.SachDAO;
import Model.ModelSach;
import Table.Sach;
import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
//import java.sql.Date;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author Huong_Nho_UIT
 */
public class ControllerSach {
    
    private  JButton btnSubmit;
    private  JButton btnXoa;
    private JTextField jtfMaSach;
    private JTextField jtfTenSach;
    private JTextField jtfTacGia;
    private JTextField jtfGia;
    private JTextField jtfSoLuong;
    private JLabel jlbMsg;
    
    private Sach sach = null;
    private ModelSach ms = null;
    private SachDAO sd = null;

    public ControllerSach(JButton btnSubmit, JButton btnXoa, JTextField jtfMaSach, JTextField jtfTenSach, JDateChooser jdcNgaySinh, JTextField jtfTacGia, JTextField jtfGia, JTextField jtfSoLuong, JLabel jlbMsg) {
        this.btnSubmit = btnSubmit;
        this.btnXoa = btnXoa;
        this.jtfMaSach = jtfMaSach;
        this.jtfTenSach = jtfTenSach;
        this.jtfTacGia = jtfTacGia;
        this.jtfGia = jtfGia;
        this.jtfSoLuong = jtfSoLuong;
        this.jlbMsg = jlbMsg;
        
     
        this.ms = new ModelSach();
        this.sd = new SachDAO();
    }
    

  
    public void setView(Sach sach){
        this.sach = sach;
        
        jtfMaSach.setText(  " "+sach.getMaSach());
        jtfTenSach.setText(sach.getTenSach());
        jtfTacGia.setText(sach.getTacGia());
        jtfGia.setText (" "+sach.getGia());
        jtfSoLuong.setText(" "+sach.getSoLuong());
      
        
    }
     public void setEvent(){
        btnSubmit.addMouseListener(new MouseAdapter(){
            
            public void mouseClicked(MouseEvent e){
                if(jtfTenSach.getText().isEmpty()){
                    JOptionPane.showMessageDialog(btnSubmit, "Vui lòng nhập thông tin sách ");
                        
               
                }else{
                    sach.setTenSach(jtfTenSach.getText().trim());
                    sach.setTacGia(jtfTacGia.getText());
                    sach.setGia(0);
                    sach.setSoLuong(0);
                    
                    int lastID = sd.createOrUpdate(sach);
                    if(lastID >0){
                        sach.setMaSach(lastID);
                        jtfMaSach.setText( " "+ lastID);
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
                if(jtfMaSach.getText().isEmpty()){
                    JOptionPane.showMessageDialog(btnXoa, "Vui lòng nhập mã sách ");
                    
                 }else{
                    int lastID = sd.DeLeTe(sach);
                    if(lastID >0){
                        sach.setMaSach(lastID);
                        jtfMaSach.setText( " "+ lastID);
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
        
