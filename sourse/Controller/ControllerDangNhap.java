package Controller;

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
import View.ViewMain;

public class ControllerDangNhap {
    private Dialog dialog;
    private JTextField tfTaiKhoan;
    private JTextField tfMatKhau;
    private JButton btDangNhap;
    private JButton btDangKy;
    private JLabel lbThongBao;
    private JPanel pnView;
    private ModelUser modelUser = null;

    public ControllerDangNhap(Dialog dialog, JTextField tfTaiKhoan, JTextField tfMatKhau, JLabel lbThongBao, JButton btDangNhap, JButton btDangKy, JPanel pnView) {
		this.dialog = dialog;
		this.tfTaiKhoan = tfTaiKhoan;
		this.tfMatKhau = tfMatKhau;
		this.btDangNhap = btDangNhap;
		this.btDangKy = btDangKy;
		this.lbThongBao = lbThongBao;
		this.pnView = pnView;
		modelUser = new ModelUser();
	}

    public void setEvent() {
        btDangNhap.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                try {
                    if (tfTaiKhoan.getText().length() == 0 || tfMatKhau.getText().length() == 0) {
                        lbThongBao.setText("Vui long nhap day du thong tin!");
                    } 
                    else {
                        User user = modelUser.login(tfTaiKhoan.getText(), tfMatKhau.getText());
                        if (user == null) {
                            lbThongBao.setText("Tai khoan khong hop le!");
                        } 
                        else {
                            if (!user.isTinhTrang()) {
                            	lbThongBao.setText("Tài khoản của bạn đang bị tạm khóa!");
                            } 
                            else {
                            	if(!user.isQuyen()) {
	                                dialog.dispose();
	                                ViewMain frame = new ViewMain(false);
	                                frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
	                                frame.setVisible(true);
                            	}
                            	else {
                            		dialog.dispose();
	                                ViewMain frame = new ViewMain(true);
	                                frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
	                                frame.setVisible(true);
                            	}
                            }
                        }
                    }
                } 
                catch (Exception ex) {
                	System.out.println("Loi submit dang nhap!");
                    lbThongBao.setText(ex.toString());
                }
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                btDangNhap.setBackground(new Color(204, 255, 255));
            }

            @Override
            public void mouseExited(MouseEvent e) {
            	btDangNhap.setBackground(new Color(240, 240, 240));
            }
        });

        
        
    }

}