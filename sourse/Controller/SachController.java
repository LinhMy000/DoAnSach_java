/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Table.Sach;
import Service.SachService;
import Service.SachServiceImpl;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 *
 * @author Khanh Vo
 */
public class SachController {
    private JButton btnSubmit;
    private JTextField jtfMaSach;
    private JTextField jtfTenSach;
    private JTextField jtfTacGia;
    private JTextField jtfGia;
    private JTextField jtfSoLuong;
    private JLabel  jlbMsg;
    
    private Sach sach = null;
    
    private SachService sachService = null;

    public SachController(JButton btnSubmit, JTextField jtfMaSach,
            JTextField jtfTenSach, JTextField jtfTacGia, JTextField jtfGia,
            JTextField jtfSoLuong, JLabel  jlbMsg) {
        this.btnSubmit = btnSubmit;
        this.jtfMaSach = jtfMaSach;
        this.jtfTenSach = jtfTenSach;
        this.jtfTacGia = jtfTacGia;
        this.jtfGia = jtfGia;
        this.jtfSoLuong = jtfSoLuong;
        this.jlbMsg = jlbMsg;
        
        this.sachService = new SachServiceImpl();
    }
    
    public void setView(Sach sach){
        this.sach = sach;
        
        jtfMaSach.setText("#"+sach.getMaSach());
        jtfTenSach.setText(sach.getTenSach());
        jtfTacGia.setText(sach.getTacGia());
//        jtfGia.setText(sach.getGia());
//        jtfSoLuong.setText(sach.getSoluong());   
    }
//    public void setEvent(){
//        btnSubmit.addMouseListener(new MouseAdapter(){
//            @Override
//            public void mouseClicked(MouseEvent me) {   
//                if(jtfTenSach.getText().length()== 0 ||jtfGia.getText().length() == 0){
//                    jlbMsg.setText("Vui lòng nhập dữ liệu bắt buộc");
//                }else{
//                    sach.setTenSach(jtfTenSach.getText());
//                    sach.setTacSia(jtfTacGia.getText());
//                    sach.setGia(jtfGia.getText());
//                    sach.setSoLuong(jtfSoLuong.getText());
//                    int lastId =   sachService.CreateOrUpdate(sach);
//                    if(lastId > 0){
//                    sach.setMaSach(lastId);
//                    jtfMaSach.setText("#"+lastId);
//                    jlbMsg.setText("Cập nhật dữ liệu thành công!");
//                    }
//                }
//            }
//
//            @Override
//            public void mouseEntered(MouseEvent me) {
//                btnSubmit.setBackground(new Color(0,200,83));
//            }
//
//            @Override
//            public void mouseExited(MouseEvent me) {
//                btnSubmit.setBackground(new Color(100,221,23));
//
//            }
//            
//            
//        });
//        
//    }
}
