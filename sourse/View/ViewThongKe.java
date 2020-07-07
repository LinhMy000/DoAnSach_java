package View;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.BoxLayout;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Controller.ControllerThongKe;
import javax.swing.DefaultComboBoxModel;

public class ViewThongKe extends JPanel {

	public ViewThongKe() {
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		JPanel panel_1 = new JPanel();
		add(panel_1);
		
		JLabel lbTK = new JLabel("Thống kê ");
		lbTK.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel_1.add(lbTK);
		
		JComboBox cbbThongKe = new JComboBox();
		cbbThongKe.setModel(new DefaultComboBoxModel(new String[] {"Sách bán chạy nhất", "Tác giả được yêu thích nhất", "Doanh thu theo tháng"}));
		cbbThongKe.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel_1.add(cbbThongKe);
//		cbbThongKe.setPreferredSize(new Dimension(440, 30));
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.CYAN);
		add(panel);
		panel.setPreferredSize(new Dimension(440, 250));

		ControllerThongKe c = new ControllerThongKe();
		c.setChart(cbbThongKe, panel);
	}
}
