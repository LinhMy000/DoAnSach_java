package Controller;

import java.awt.BorderLayout;
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
import View.ViewDangKy;
import View.ViewMain;

public class ControllerDangNhap {
    private JDialog dialog;
    private JTextField tfTaiKhoan;
    private JTextField tfMatKhau;
    private JButton btDangNhap;
    private JButton btDangKy;
    private JLabel lbThongBao;
    private JPanel pnView;
    private ModelUser modelUser = null;

    public ControllerDangNhap(JDialog dialog, JTextField tfTaiKhoan, JTextField tfMatKhau, JLabel lbThongBao, JButton btDangNhap, JButton btDangKy, JPanel pnView) {
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
    	tfMatKhau.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
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
                            	lbThongBao.setText("Tai khoan dang bi khoa!");
                            } 
                            else {
                            	if(!user.isQuyen()) {
                            		dialog.hide();
	                                dialog.dispose();
	                                ViewMain frame = new ViewMain(false);
	                                frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
	                                frame.setVisible(true);
                            	}
                            	else {
                            		dialog.hide();
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
                	System.out.println("Loi enter dang nhap!");
                    lbThongBao.setText(ex.toString());
                }
			}
    	});
    	
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
                            	lbThongBao.setText("Tai khoan dang bi khoa!");
                            } 
                            else {
                            	if(!user.isQuyen()) {
                            		dialog.hide();
	                                dialog.dispose();
	                                ViewMain frame = new ViewMain(false);
	                                frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
	                                frame.setVisible(true);
                            	}
                            	else {
                            		dialog.hide();
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
            }
            @Override
            public void mouseExited(MouseEvent e) {
            }
        });

        btDangKy.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                try {
                	dialog.setTitle("SIGN UP");
                	pnView.removeAll();
	       	    	pnView.setLayout(new BorderLayout());
//	       	    	pnView.add(new ViewDangKy(dialog));
	       	    	pnView.validate();
	       	    	pnView.repaint();
				} 
                catch (Exception e2) {
                	System.out.println("Loi submit dang ky!");
                    lbThongBao.setText(e2.toString());
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