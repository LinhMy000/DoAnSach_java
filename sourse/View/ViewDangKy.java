package View;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.GridLayout;
import java.awt.Font;
import javax.swing.JButton;

public class ViewDangKy extends JPanel {
	
	public ViewDangKy() {
		JPanel panel = new JPanel();
		add(panel);
		panel.setLayout(new GridLayout(4, 0, 1, 1));
		{
			JLabel lbTaiKhoan = new JLabel("Tai khoan");
			lbTaiKhoan.setFont(new Font("Tahoma", Font.PLAIN, 13));
			panel.add(lbTaiKhoan);
			
			JTextField tfTaiKhoan = new JTextField();
			tfTaiKhoan.setFont(new Font("Tahoma", Font.PLAIN, 13));
			panel.add(tfTaiKhoan);
			tfTaiKhoan.setColumns(10);
		}
		{
			JLabel lbMatKhau = new JLabel("Mat khau");
			lbMatKhau.setFont(new Font("Tahoma", Font.PLAIN, 13));
			panel.add(lbMatKhau);
			
			JTextField tfMatKhau = new JTextField();
			tfMatKhau.setFont(new Font("Tahoma", Font.PLAIN, 13));
			panel.add(tfMatKhau);
			tfMatKhau.setColumns(10);
		}
		{
			JLabel lbHoTen = new JLabel("Ho ten");
			lbHoTen.setFont(new Font("Tahoma", Font.PLAIN, 13));
			panel.add(lbHoTen);
			
			JTextField tfHoTen = new JTextField();
			tfHoTen.setFont(new Font("Tahoma", Font.PLAIN, 13));
			panel.add(tfHoTen);
			tfHoTen.setColumns(10);
		}
		
		JPanel panel_1 = new JPanel();
		add(panel_1);
		panel_1.setLayout(new GridLayout(2, 0, 0, 30));
		{
			JLabel lbThongBao = new JLabel("Vui long dien day du thong tin !");
			panel_1.add(lbThongBao);
			lbThongBao.setFont(new Font("Tahoma", Font.PLAIN, 12));
				
			JButton btDangKy = new JButton("DANG KY");
			panel_1.add(btDangKy);
		}
	}
	
	

}
