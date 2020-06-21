package View;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import Controller.ControllerDangNhap;
import java.awt.Color;

public class ViewDangNhap extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField tfTaiKhoan;
	private JPasswordField tfMatKhau;
	private JLabel lbThongBao;
	private JButton btDangNhap;
	private JButton btDangKy;
	private JPanel pnView;

	public ViewDangNhap() {
		setTitle("SIGN IN");
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(3, 3, 3, 3));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new GridLayout(0, 2, 0, 0));
		{
			JPanel panel = new JPanel();
			contentPanel.add(panel);
			{
				BufferedImage myPicture;
				try {
					myPicture = ImageIO.read(new File("C://Users//LENOVO//eclipse-workspace//DoAnSach//source//Image//ImageSachDen.jpg"));
					JLabel picLabel = new JLabel(new ImageIcon(myPicture));
					panel.add(picLabel);
				} 
				catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		{
			pnView = new JPanel();
			pnView.setBorder(new EmptyBorder(5, 5, 5, 10));
			contentPanel.add(pnView);
			pnView.setLayout(new GridLayout(6, 0, 0, 0));
			{
				BufferedImage myPicture;
				try {
					myPicture = ImageIO.read(new File("C://Users//LENOVO//eclipse-workspace//DoAnSach//source//Image//user.png"));
					JLabel lbTaiKhoan = new JLabel(new ImageIcon(myPicture));
					lbTaiKhoan.setHorizontalAlignment(SwingConstants.LEADING);
					lbTaiKhoan.setText("Username");
					lbTaiKhoan.setFont(new Font("Tahoma", Font.PLAIN, 14));
					pnView.add(lbTaiKhoan);
				} 
				catch (IOException e) {
					e.printStackTrace();
				}
			}
			{
				tfTaiKhoan = new JTextField();
				tfTaiKhoan.setFont(new Font("Tahoma", Font.PLAIN, 14));
				pnView.add(tfTaiKhoan);
				tfTaiKhoan.setColumns(10);
			}
			{
				BufferedImage myPicture;
				try {
					myPicture = ImageIO.read(new File("C://Users//LENOVO//eclipse-workspace//DoAnSach//source//Image//password.png"));
					JLabel lbMatKhau = new JLabel(new ImageIcon(myPicture));
					lbMatKhau.setHorizontalAlignment(SwingConstants.LEADING);
					lbMatKhau.setText("Password");
					lbMatKhau.setFont(new Font("Tahoma", Font.PLAIN, 14));
					pnView.add(lbMatKhau);
				} 
				catch (IOException e) {
					e.printStackTrace();
				}
//				JLabel lbMatKhau = new JLabel("Password");
//				lbMatKhau.setFont(new Font("Tahoma", Font.PLAIN, 14));
//				pnView.add(lbMatKhau);
			}
			{
				tfMatKhau = new JPasswordField();
				tfMatKhau.setFont(new Font("Tahoma", Font.PLAIN, 14));
				pnView.add(tfMatKhau);
				tfMatKhau.setColumns(10);
			}
			{
				lbThongBao = new JLabel("");
				lbThongBao.setForeground(Color.RED);
				lbThongBao.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
				lbThongBao.setHorizontalAlignment(SwingConstants.CENTER);
				pnView.add(lbThongBao);
			}
			{
				JPanel buttonPane = new JPanel();
				pnView.add(buttonPane, BorderLayout.SOUTH);
				{
					btDangNhap = new JButton("SIGN IN");
					btDangNhap.setFont(new Font("Tahoma", Font.BOLD, 14));
					btDangNhap.setActionCommand("OK");
					buttonPane.add(btDangNhap);
					getRootPane().setDefaultButton(btDangNhap);
				}
				{
					btDangKy = new JButton("SIGN UP");
					btDangKy.setFont(new Font("Tahoma", Font.BOLD, 14));
					btDangKy.setActionCommand("");
					buttonPane.add(btDangKy);
				}
			}
		}
		
		ControllerDangNhap controller = new ControllerDangNhap(this, tfTaiKhoan, tfMatKhau, lbThongBao, btDangNhap, btDangKy, pnView);
		controller.setEvent();
	}

}
