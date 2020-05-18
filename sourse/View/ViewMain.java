package View;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import Controller.ControllerMenu;
import Model.ModelMenu;
import java.awt.Component;
import java.awt.Rectangle;

public class ViewMain extends JFrame {
	private JPanel contentPane;
	private JLabel lbTrangChu;
	private JLabel lbKhachHang;
	private JLabel lbSach;
	private JLabel lbHoaDon;
	private JLabel lbThongKe;
	private JLabel lbUser;
	private JPanel pnView;
	
	public ViewMain(boolean quyen) {
		initComponents();
		setVisible(true);
		if(!quyen)
			initMenu();
		else
			initMenuAdmin();
	}

	public void initComponents() {
        setTitle("Quan Ly Cua Hang Sach");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JLabel lbTitle = new JLabel("CỬA HÀNG SÁCH");
		lbTitle.setForeground(Color.RED);
		lbTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lbTitle.setFont(new Font("Tahoma", Font.PLAIN, 24));
		contentPane.add(lbTitle, BorderLayout.NORTH);
		
		JPanel pnMenu = new JPanel();
		pnMenu.setBackground(new Color(0, 0, 0));
		pnMenu.setLayout(new GridLayout(6, 0, 0, 0));
		contentPane.add(pnMenu, BorderLayout.WEST);
		
		lbTrangChu = new JLabel("Trang chu");
		lbTrangChu.setOpaque(true);
		lbTrangChu.setBackground(new Color(0, 191, 255));
		lbTrangChu.setBorder(new LineBorder(Color.DARK_GRAY));
		lbTrangChu.setFont(new Font("Tahoma", Font.PLAIN,13));
		lbTrangChu.setHorizontalAlignment(SwingConstants.CENTER);
		pnMenu.add(lbTrangChu);
		
		lbKhachHang = new JLabel("Khach hang");
		lbKhachHang.setOpaque(true);
		lbKhachHang.setBackground(new Color(0, 191, 255));
		lbKhachHang.setBorder(new LineBorder(Color.DARK_GRAY));
		lbKhachHang.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lbKhachHang.setHorizontalAlignment(SwingConstants.CENTER);
		pnMenu.add(lbKhachHang);
		
		lbSach = new JLabel("Sach");
		lbSach.setOpaque(true);
		lbSach.setBackground(new Color(0, 191, 255));
		lbSach.setBorder(new LineBorder(Color.DARK_GRAY));
		lbSach.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lbSach.setHorizontalAlignment(SwingConstants.CENTER);
		pnMenu.add(lbSach);
		
		lbHoaDon = new JLabel("Hoa don");
		lbHoaDon.setOpaque(true);
		lbHoaDon.setBackground(new Color(0, 191, 255));
		lbHoaDon.setBorder(new LineBorder(Color.DARK_GRAY));
		lbHoaDon.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lbHoaDon.setHorizontalAlignment(SwingConstants.CENTER);
		pnMenu.add(lbHoaDon);
		
		lbThongKe = new JLabel("Thong ke du lieu");
		lbThongKe.setOpaque(true);
		lbThongKe.setBackground(new Color(0, 191, 255));
		lbThongKe.setBorder(new LineBorder(Color.DARK_GRAY));
		lbThongKe.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lbThongKe.setHorizontalAlignment(SwingConstants.CENTER);
		pnMenu.add(lbThongKe);
		
		lbUser = new JLabel("Tai khoan");
		lbUser.setOpaque(true);
		lbUser.setBackground(new Color(0, 191, 255));
		lbUser.setBorder(new LineBorder(Color.DARK_GRAY));
		lbUser.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lbUser.setHorizontalAlignment(SwingConstants.CENTER);
		pnMenu.add(lbUser);
		
		pnView = new JPanel();
		pnView.setBackground(new Color(0, 0, 0));
		contentPane.add(pnView, BorderLayout.CENTER);
	}
	
	public void initMenu() {
		List<ModelMenu> listDanhMuc = new ArrayList<>();
        listDanhMuc.add(new ModelMenu("Trang chu", lbTrangChu));
        listDanhMuc.add(new ModelMenu("Khach hang", lbKhachHang));
        listDanhMuc.add(new ModelMenu("Sach", lbSach));
        listDanhMuc.add(new ModelMenu("Hoa don", lbHoaDon));
        listDanhMuc.add(new ModelMenu("Thong ke du lieu", lbThongKe));
        ControllerMenu controller = new ControllerMenu(pnView);
        controller.setView(lbTrangChu);
        controller.setEvent(listDanhMuc);
	}
	public void initMenuAdmin() {
		ControllerMenu controller = new ControllerMenu(pnView);
        controller.setView(lbTrangChu);
		
		List<ModelMenu> listDanhMuc = new ArrayList<>();
        listDanhMuc.add(new ModelMenu("Trang chu", lbTrangChu));
        listDanhMuc.add(new ModelMenu("Khach hang", lbKhachHang));
        listDanhMuc.add(new ModelMenu("Sach", lbSach));
        listDanhMuc.add(new ModelMenu("Hoa don", lbHoaDon));
        listDanhMuc.add(new ModelMenu("Thong ke du lieu", lbThongKe));
        listDanhMuc.add(new ModelMenu("User", lbUser));
        controller.setEventAdmin(listDanhMuc);
	}

}
