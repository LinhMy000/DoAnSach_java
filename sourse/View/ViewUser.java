package View;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Controller.ControllerTaiKhoan;
import java.awt.Component;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.Font;

public class ViewUser extends JPanel {
	private JTextField tfSearch;
	private JTextField tfTK;
	private JTextField tfMK;
	private JTextField tfHT;

	public ViewUser() {
		setLayout(new GridLayout(2, 1, 0, 0));
		
		JPanel panel = new JPanel();
		add(panel);
		panel.setLayout(new GridLayout(7, 2, 0, 0));
		
		JLabel lblNewLabel = new JLabel("Tai khoan");
		panel.add(lblNewLabel);
		
		tfTK = new JTextField();
		panel.add(tfTK);
		tfTK.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Mat khau");
		panel.add(lblNewLabel_1);
		
		tfMK = new JTextField();
		panel.add(tfMK);
		tfMK.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Ho ten");
		panel.add(lblNewLabel_2);
		
		tfHT = new JTextField();
		panel.add(tfHT);
		tfHT.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Tinh trang");
		panel.add(lblNewLabel_3);
		
		JCheckBox cbTT = new JCheckBox("");
		panel.add(cbTT);
		
		JLabel lblNewLabel_4 = new JLabel("Quyen");
		panel.add(lblNewLabel_4);
		
		JCheckBox cbQ = new JCheckBox("");
		panel.add(cbQ);
		
		JButton btAdd = new JButton("Them");
		panel.add(btAdd);
		
		JButton btDelete = new JButton("Xoa");
		panel.add(btDelete);
		
		tfSearch = new JTextField();
		panel.add(tfSearch);
		tfSearch.setColumns(10);
		
		JLabel lbTB = new JLabel("");
		lbTB.setFont(new Font("Tahoma", Font.ITALIC, 11));
		lbTB.setForeground(Color.RED);
		lbTB.setHorizontalTextPosition(SwingConstants.CENTER);
		lbTB.setHorizontalAlignment(SwingConstants.CENTER);
		lbTB.setAlignmentX(Component.CENTER_ALIGNMENT);
		panel.add(lbTB);
		
		JPanel pnTable = new JPanel();
		add(pnTable);
		
		ControllerTaiKhoan ct = new ControllerTaiKhoan(btAdd,btDelete,tfSearch,tfTK,tfMK,tfHT,cbTT,cbQ,lbTB,pnTable); 
		ct.setViewAndEvent();

	}

}
