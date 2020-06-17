package View;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import com.toedter.calendar.JDateChooser;

import Controller.ControllerHoaDon;

public class ViewHoaDon extends JPanel {
	private JTextField tfSearch;
	private JTextField tfTT;
	private JTextField tfMaHD;
	public ViewHoaDon() {
		setLayout(new GridLayout(0, 2, 0, 0));
		
		JPanel panel = new JPanel();
		add(panel);
		panel.setLayout(new GridLayout(4, 0, 0, 0));
		
		JPanel panel_2 = new JPanel();
		panel.add(panel_2);
		
		tfSearch = new JTextField();
		panel_2.add(tfSearch);
		tfSearch.setColumns(10);
		
		JPanel pnSP = new JPanel();
		panel.add(pnSP);
		
		JPanel panel_3 = new JPanel();
		panel.add(panel_3);
		
		JButton btDelete = new JButton("Xoa");
		panel_3.add(btDelete);
		
		JPanel pnCTHD = new JPanel();
		panel.add(pnCTHD);
		
		JPanel panel_1 = new JPanel();
		add(panel_1);
		panel_1.setLayout(new GridLayout(8, 2, 5, 5));
		
		JLabel lbmahd = new JLabel("Ma HD");
		panel_1.add(lbmahd);
		
		tfMaHD = new JTextField();
		tfMaHD.setEditable(false);
		panel_1.add(tfMaHD);
		tfMaHD.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Khach hang");
		panel_1.add(lblNewLabel);
		
		JComboBox cbbKH = new JComboBox();
		panel_1.add(cbbKH);
		
		JLabel lblNewLabel_1 = new JLabel("Nhan vien");
		panel_1.add(lblNewLabel_1);
		
		JComboBox cbbNV = new JComboBox();
		panel_1.add(cbbNV);
		
		JLabel lblNewLabel_2 = new JLabel("Ngay HD");
		panel_1.add(lblNewLabel_2);
		
		JDateChooser dcNgayHD = new JDateChooser(new java.sql.Date(System.currentTimeMillis()));
		panel_1.add(dcNgayHD);

		JLabel lblNewLabel_3 = new JLabel("Tong tien");
		panel_1.add(lblNewLabel_3);
		
		tfTT = new JTextField();
		tfTT.setEditable(false);
		panel_1.add(tfTT);
		tfTT.setColumns(10);
		
		JButton btAdd = new JButton("Xac nhan");
		panel_1.add(btAdd);
		
		JButton btOut = new JButton("Xuat HD");
		panel_1.add(btOut);
		
		JLabel lbTB = new JLabel("");
		lbTB.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		lbTB.setHorizontalAlignment(SwingConstants.CENTER);
		lbTB.setForeground(Color.RED);
		panel_1.add(lbTB);

		ControllerHoaDon ctl = new ControllerHoaDon(pnSP,tfSearch,pnCTHD,btDelete,cbbNV,cbbKH,dcNgayHD,btAdd,btOut,tfTT,lbTB,tfMaHD);
		ctl.setViewAndEvent();
	}
}
