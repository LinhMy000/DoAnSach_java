package View;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import Controller.ControllerDangKy;

public class ViewDangKy extends JPanel {
	private JTextField tftk;
	private JPasswordField tfmk;
	private JTextField tfHoTen;
	private JLabel lbTB;

	public ViewDangKy(JDialog dia) {
//		setPreferredSize(new Dimension(1350, 400));
		setLayout(new GridLayout(2, 1, 1, 1));
		
		JPanel panel = new JPanel();
		add(panel);
		panel.setLayout(new GridLayout(3, 1, 0, 15));
		
		JLabel lbtk = new JLabel("Username");
		lbtk.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel.add(lbtk);
		
		tftk = new JTextField();
		tftk.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel.add(tftk);
		tftk.setColumns(10);
		
		JLabel lbmk = new JLabel("Password");
		lbmk.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel.add(lbmk);
		
		tfmk = new JPasswordField();
		tfmk.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel.add(tfmk);
		
		JLabel lbName = new JLabel("Name");
		lbName.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel.add(lbName);
		
		tfHoTen = new JTextField();
		tfHoTen.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel.add(tfHoTen);
		tfHoTen.setColumns(10);
		
		JPanel panel_1 = new JPanel();
		add(panel_1);
		panel_1.setLayout(new GridLayout(2, 0, 0, 0));
		
		lbTB = new JLabel("");
		lbTB.setForeground(Color.RED);
		lbTB.setHorizontalAlignment(SwingConstants.CENTER);
		lbTB.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		panel_1.add(lbTB);
		
		JPanel panel_2 = new JPanel();
		panel_1.add(panel_2);
		
		JButton btDK = new JButton("SIGN UP");
		btDK.setFont(new Font("Tahoma", Font.BOLD, 14));
		panel_2.add(btDK);

		ControllerDangKy controller = new ControllerDangKy(this, tftk, tfmk, tfHoTen, lbTB, btDK, dia);
		controller.setEvent();
	}
}
