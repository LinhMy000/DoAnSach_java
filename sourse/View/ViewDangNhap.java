package View;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Dimension;
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
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import Controller.ControllerDangNhap;

public class ViewDangNhap extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField tfTaiKhoan;
	private JTextField tfMatKhau;
	private JLabel lbThongBao;
	private JButton btDangNhap;
	private JButton btDangKy;
	private JPanel pnView;

	public static void main(String[] args) {
		try {
			ViewDangNhap dialog = new ViewDangNhap();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
	}

	public ViewDangNhap() {
		setTitle("Dang Nhap / Dang Ky");
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
					myPicture = ImageIO.read(new File("C://Users//Huong_Nho_UIT//Downloads//DoAnSach_java-master (1)//DoAnSach_java-master//DoAnSach//source//Image//ImageSachDen.jpg"));
					JLabel picLabel = new JLabel(new ImageIcon(myPicture));
//					picLabel.setSize(panel.getWidth(), panel.getHeight());
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
				JLabel lbTaiKhoan = new JLabel("Tai khoan");
				lbTaiKhoan.setFont(new Font("Tahoma", Font.PLAIN, 13));
				pnView.add(lbTaiKhoan);
			}
			{
				tfTaiKhoan = new JTextField();
				tfTaiKhoan.setFont(new Font("Tahoma", Font.PLAIN, 13));
				pnView.add(tfTaiKhoan);
				tfTaiKhoan.setColumns(10);
			}
			{
				JLabel lbMatKhau = new JLabel("Mat khau");
				lbMatKhau.setFont(new Font("Tahoma", Font.PLAIN, 13));
				pnView.add(lbMatKhau);
			}
			{
				tfMatKhau = new JTextField();
				tfMatKhau.setFont(new Font("Tahoma", Font.PLAIN, 13));
				pnView.add(tfMatKhau);
				tfMatKhau.setColumns(10);
			}
			{
				lbThongBao = new JLabel("Vui long nhap thong tin");
				lbThongBao.setFont(new Font("Tahoma", Font.PLAIN, 12));
				lbThongBao.setHorizontalAlignment(SwingConstants.CENTER);
				pnView.add(lbThongBao);
			}
			{
				JPanel buttonPane = new JPanel();
				pnView.add(buttonPane, BorderLayout.SOUTH);
				{
					btDangNhap = new JButton("DANG NHAP");
					btDangNhap.setActionCommand("OK");
					buttonPane.add(btDangNhap);
					getRootPane().setDefaultButton(btDangNhap);
				}
				{
					btDangKy = new JButton("DANG KY");
					btDangKy.setActionCommand("");
					buttonPane.add(btDangKy);
				}
			}
		}
		
		ControllerDangNhap controller = new ControllerDangNhap(this, tfTaiKhoan, tfMatKhau, lbThongBao, btDangNhap, btDangKy, pnView);
		controller.setEvent();
	}

}
