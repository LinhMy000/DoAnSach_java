package View;

import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Controller.ControllerDangKy;

public class ViewDangKy extends JPanel {
	private JTextField tfTaiKhoan;
	private JTextField tfMatKhau;
	private JTextField tfHoTen;
	private JLabel lbThongBao;
	private JButton btDangKy;
	
	public ViewDangKy() {
		JPanel panel = new JPanel();
		add(panel);
		panel.setLayout(new GridLayout(4, 0, 1, 1));
		{
			JLabel lbTaiKhoan = new JLabel("Tai khoan");
			lbTaiKhoan.setFont(new Font("Tahoma", Font.PLAIN, 13));
			panel.add(lbTaiKhoan);
			
			tfTaiKhoan = new JTextField();
			tfTaiKhoan.setFont(new Font("Tahoma", Font.PLAIN, 13));
			panel.add(tfTaiKhoan);
			tfTaiKhoan.setColumns(10);
		}
		{
			JLabel lbMatKhau = new JLabel("Mat khau");
			lbMatKhau.setFont(new Font("Tahoma", Font.PLAIN, 13));
			panel.add(lbMatKhau);
			
			tfMatKhau = new JTextField();
			tfMatKhau.setFont(new Font("Tahoma", Font.PLAIN, 13));
			panel.add(tfMatKhau);
			tfMatKhau.setColumns(10);
		}
		{
			JLabel lbHoTen = new JLabel("Ho ten");
			lbHoTen.setFont(new Font("Tahoma", Font.PLAIN, 13));
			panel.add(lbHoTen);
			
			tfHoTen = new JTextField();
			tfHoTen.setFont(new Font("Tahoma", Font.PLAIN, 13));
			panel.add(tfHoTen);
			tfHoTen.setColumns(10);
		}
		
		JPanel panel_1 = new JPanel();
		add(panel_1);
		panel_1.setLayout(new GridLayout(2, 0, 0, 30));
		{
			lbThongBao = new JLabel("Vui long dien day du thong tin !");
			panel_1.add(lbThongBao);
			lbThongBao.setFont(new Font("Tahoma", Font.PLAIN, 12));
				
			btDangKy = new JButton("DANG KY");
			panel_1.add(btDangKy);
		}
		
		ControllerDangKy controller = new ControllerDangKy(this, tfTaiKhoan, tfMatKhau, tfHoTen, lbThongBao, btDangKy);
		controller.setEvent();
	}
}
