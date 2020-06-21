package View;

import javax.swing.JPanel;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JSplitPane;

import java.awt.Dimension;
import java.awt.FlowLayout;
import javax.swing.JComboBox;
import java.awt.Font;

public class ViewThongKe extends JPanel {

	public ViewThongKe() {
		setLayout(new FlowLayout(FlowLayout.LEADING, 5, 5));
		
		JLabel lbThongKe = new JLabel("Thong ke");
		lbThongKe.setFont(new Font("Tahoma", Font.PLAIN, 14));
		add(lbThongKe);
		
		JComboBox cbbThongKe = new JComboBox();
		cbbThongKe.setFont(new Font("Tahoma", Font.PLAIN, 14));
		add(cbbThongKe);
		
		JPanel panel = new JPanel();
		add(panel);
		panel.setPreferredSize(new Dimension(440, 260));

	}

}
