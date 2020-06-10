package Controller;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dialog;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Connection.ConnectionUser;
import Model.ModelUser;
import Table.User;
import View.ViewDangNhap;
import View.ViewMain;

public class ControllerDangKy {
    private JPanel pnDangKy;
    private JTextField tfTaiKhoan;
    private JTextField tfMatKhau;
    private JTextField tfHoTen;
    private JButton btDangKy;
    private JLabel lbThongBao;

    public ControllerDangKy(JPanel pnDangKy, JTextField tfTaiKhoan, JTextField tfMatKhau, JTextField tfHoTen, JLabel lbThongBao, JButton btDangKy) {
		this.pnDangKy = pnDangKy;
		this.tfTaiKhoan = tfTaiKhoan;
		this.tfMatKhau = tfMatKhau;
		this.tfHoTen = tfHoTen;
		this.btDangKy = btDangKy;
		this.lbThongBao = lbThongBao;
	}

    public void setEvent() {
    	btDangKy.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                try {
                    if (tfTaiKhoan.getText().length() == 0 || tfMatKhau.getText().length() == 0 || tfHoTen.getText().length() == 0) {
                        lbThongBao.setText("Vui long nhap day du thong tin!");
                    } 
                    else {
                    	int row = ConnectionUser.register(tfTaiKhoan.getText(), tfMatKhau.getText(), tfHoTen.getText());
                    	if(row == 0)
                    		lbThongBao.setText("Dang ky không thành cong! Vui long thu lai!");
                    	else {
                    		ViewDangNhap dia = new ViewDangNhap(); 
                    		dia.setResizable(false);
                    		dia.setLocationRelativeTo(null);
                    		dia.setVisible(true);
                    		pnDangKy.removeAll();
                    	}
                    }
                } 
                catch (Exception ex) {
                	System.out.println("Loi dang ky!");
                    lbThongBao.setText(ex.toString());
                }
            }

            @Override
            public void mouseEntered(MouseEvent e) {
            	btDangKy.setBackground(new Color(204, 255, 255));
            }

            @Override
            public void mouseExited(MouseEvent e) {
            	btDangKy.setBackground(new Color(240, 240, 240));
            }
        });

        
        
    }

}