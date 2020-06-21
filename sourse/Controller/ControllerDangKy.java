package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

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
    private JDialog dia;

    public ControllerDangKy(JPanel pnDangKy, JTextField tfTaiKhoan, JTextField tfMatKhau, JTextField tfHoTen, JLabel lbThongBao, JButton btDangKy, JDialog dia) {
		this.pnDangKy = pnDangKy;
		this.tfTaiKhoan = tfTaiKhoan;
		this.tfMatKhau = tfMatKhau;
		this.tfHoTen = tfHoTen;
		this.btDangKy = btDangKy;
		this.lbThongBao = lbThongBao;
		this.dia = dia;
	}

    public void setEvent() {
    	tfHoTen.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
                	if(ModelUser.KiemTraTaiKhoan(tfTaiKhoan.getText()) == false) {
                        lbThongBao.setText("Tai khoan da ton tai!");                		
                	}
                	else if (tfTaiKhoan.getText().length() == 0 || tfMatKhau.getText().length() == 0 || tfHoTen.getText().length() == 0) {
                        lbThongBao.setText("Vui long nhap day du thong tin!");
                    } 
                    else {
                    	int row = ModelUser.register(tfTaiKhoan.getText(), tfMatKhau.getText(), tfHoTen.getText());
                    	if(row == 0)
                    		lbThongBao.setText("Dang ky không thành cong!");
                    	else {
                    		dia.dispose();
                    		dia.hide();
                    		ViewDangNhap dialog = new ViewDangNhap(); 
                    		dialog.setResizable(false);
                    		dialog.setLocationRelativeTo(null);
                    		dialog.setVisible(true);
                    	}
                    }
                } 
                catch (Exception ex) {
                	System.out.println("Loi dang ky!");
                    lbThongBao.setText(ex.toString());
                }
			}
    	});
    	
    	btDangKy.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                try {
                	if(ModelUser.KiemTraTaiKhoan(tfTaiKhoan.getText()) == false) {
                        lbThongBao.setText("Tai khoan da ton tai!");                		
                	}
                	else if (tfTaiKhoan.getText().length() == 0 || tfMatKhau.getText().length() == 0 || tfHoTen.getText().length() == 0) {
                        lbThongBao.setText("Vui long nhap day du thong tin!");
                    } 
                    else {
                    	int row = ModelUser.register(tfTaiKhoan.getText(), tfMatKhau.getText(), tfHoTen.getText());
                    	if(row == 0)
                    		lbThongBao.setText("Dang ky không thành cong!");
                    	else {
                    		dia.dispose();
                    		dia.hide();
                    		ViewDangNhap dialog = new ViewDangNhap(); 
                    		dialog.setResizable(false);
                    		dialog.setLocationRelativeTo(null);
                    		dialog.setVisible(true);
//                    		pnDangKy.removeAll();
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
            }
            @Override
            public void mouseExited(MouseEvent e) {
            }
        });
    }
}