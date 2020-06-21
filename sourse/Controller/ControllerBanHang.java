package Controller;

import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import com.toedter.calendar.JDateChooser;

import Model.ModelHoaDon;
import Model.ModelKhachHang;
import Model.ModelSach;
import Model.ModelUser;
import Table.CTHD;
import Table.HoaDon;
import Table.KhachHang;
import Table.Sach;
import Table.User;

public class ControllerBanHang {
	private JPanel pnTableSP;
	private JTextField tfSearchSP;
	private JPanel pnTableCTHD;
	private JButton btDeleteCTHD;
	private JTextField tfMaHD;
	private JComboBox cbNV;
	private JComboBox cbKH;
	private JDateChooser dcNgayHD;
	private JButton btnAddHD;
	private JButton btnThanhToan;
	private JTextField tfTongTien;
	private JLabel tfThongBao;

	public ControllerBanHang(JPanel pnTableSP, JTextField tfSearchSP, JPanel pnTableCTHD, JButton btDeleteCTHD,
			JComboBox cbNV, JComboBox cbKH, JDateChooser dcNgayHD, JButton btnAddHD, JButton btnThanhToan,
			JTextField tfTongTien, JLabel tfThongBao, JTextField tfMahd) {
		this.pnTableSP = pnTableSP;
		this.tfSearchSP = tfSearchSP;
		this.pnTableCTHD = pnTableCTHD;
		this.btDeleteCTHD = btDeleteCTHD;
		this.cbNV = cbNV;
		this.cbKH = cbKH;
		this.dcNgayHD = dcNgayHD;
		this.btnAddHD = btnAddHD;
		this.btnThanhToan = btnThanhToan;
		this.tfTongTien = tfTongTien;
		this.tfThongBao = tfThongBao;
		this.tfMaHD = tfMahd;
	}

	public void setViewAndEvent() {
		//Hien thi combobox
		List<KhachHang> listKH = ModelKhachHang.getList();
		for (int i = 0; i < listKH.size(); i++) {
			cbKH.addItem(listKH.get(i));
		}
		
		List<User> listNV = ModelUser.getUsers();
		for (int i = 0; i < listNV.size(); i++) {
			cbNV.addItem(listNV.get(i));
		}
		
		/* Hien thi danh sach san pham len table sach */
		
		// cai dat model sach
		DefaultTableModel modelSP = new DefaultTableModel( new String[] { "Ma Sach", "Ten Sach", "Tac Gia", "Gia", "So Luong" }, 0) {
			@Override
			public boolean isCellEditable(int row, int col) {
				return false;
			}

			@Override
			public Class<?> getColumnClass(int col) {
				return col == 5 ? Boolean.class : String.class;
			}
		};

		// them danh sach tu csdl vao table sach
		List<Sach> list = ModelSach.getSachs();
		Sach user = null;
		Object[] obj;
		for (int i = 0; i < list.size(); i++) {
			user = list.get(i);
			obj = new Object[5];
			obj[0] = user.getMaSach();
			obj[1] = user.getTenSach();
			obj[2] = user.getTacGia();
			obj[3] = user.getGia();
			obj[4] = user.getSoLuong();
			modelSP.addRow(obj);
		}

		JTable tableSP = new JTable(modelSP);
		TableRowSorter<TableModel> rowSorterSP = new TableRowSorter<>(modelSP);
		tableSP.setRowSorter(rowSorterSP);

		// design table
		tableSP.getTableHeader().setFont(new Font("Tahoma", Font.BOLD, 14));
		tableSP.getTableHeader().setPreferredSize(new Dimension(100, 50));
		tableSP.setRowHeight(50);
		tableSP.validate();
		tableSP.repaint();

		JScrollPane scrollSP = new JScrollPane();
		scrollSP.getViewport().add(tableSP);
		scrollSP.setPreferredSize(new Dimension(1350, 400));
		pnTableSP.removeAll();
		pnTableSP.setLayout(new CardLayout());
		pnTableSP.add(scrollSP);
		pnTableSP.validate();
		pnTableSP.repaint();

		/* Xu ly su kien*/
		
		//Tim kiem sach
		tfSearchSP.getDocument().addDocumentListener(new DocumentListener() {
			@Override
			public void insertUpdate(DocumentEvent e) {
				String text = tfSearchSP.getText();
				if (text.trim().length() == 0) {
					rowSorterSP.setRowFilter(null);
				} else {
					rowSorterSP.setRowFilter(RowFilter.regexFilter("(?i)" + text));
				}
			}

			@Override
			public void removeUpdate(DocumentEvent e) {
				String text = tfSearchSP.getText();
				if (text.trim().length() == 0) {
					rowSorterSP.setRowFilter(null);
				} else {
					rowSorterSP.setRowFilter(RowFilter.regexFilter("(?i)" + text));
				}
			}

			@Override
			public void changedUpdate(DocumentEvent e) {
			}
		});

		/* Hien thi CTHD khi chon tren table sach */
		// cai dat model
		DefaultTableModel modelCTHD = new DefaultTableModel(new String[] { "Ma Sach", "Ten Sach", "Gia", "So Luong", "Thanh tien" },0) {
			@Override
			public boolean isCellEditable(int row, int col) {
				return (col == 3);
			}

			@Override
			public Class<?> getColumnClass(int col) {
				return col == 5 ? Boolean.class : String.class;
			}
		};

		JTable tableCTHD = new JTable(modelCTHD);
		TableRowSorter<TableModel> rowSorterCTHD = new TableRowSorter<>(modelCTHD);
		tableCTHD.setRowSorter(rowSorterCTHD);

		//Su kien khi chon sach
		tableSP.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (e.getClickCount() == 2 && tableSP.getSelectedRow() != -1) {
					int i = tableSP.getSelectedRow();
					// them vao table cthd
					Object[] ob = new Object[5];
					ob[0] = modelSP.getValueAt(i, 0);
					ob[1] = modelSP.getValueAt(i, 1);
					ob[2] = modelSP.getValueAt(i, 3);
					ob[3] = 1;
					ob[4] = 0;
					modelCTHD.addRow(ob);
					modelSP.removeRow(i);
					int countRow = modelCTHD.getRowCount() - 1;
					modelCTHD.setValueAt(Double.parseDouble(modelCTHD.getValueAt(countRow, 2).toString()) * Integer.parseInt(modelCTHD.getValueAt(countRow, 3).toString()), countRow, 4);
				}
				
				// Tinh tong tien
				double tien = 0;
				for (int j = 0; j < modelCTHD.getRowCount(); ++j) {
					tien += Double.parseDouble(modelCTHD.getValueAt(j, 4).toString());
				}
				tfTongTien.setText(Double.toString(tien));
			}
		});

		//Su kien sua so luong
		tableCTHD.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				double tien = 0;
				for (int j = 0; j < modelCTHD.getRowCount(); ++j) {
					modelCTHD.setValueAt(Double.parseDouble(modelCTHD.getValueAt(j, 2).toString()) * Double.parseDouble(modelCTHD.getValueAt(j, 3).toString()), j, 4);
					tien += Double.parseDouble(modelCTHD.getValueAt(j, 4).toString());
				}
				tfTongTien.setText(Double.toString(tien));
			}
		});

		// design table
		tableCTHD.getTableHeader().setFont(new Font("Tahoma", Font.BOLD, 14));
		tableCTHD.getTableHeader().setPreferredSize(new Dimension(100, 50));
		tableCTHD.setRowHeight(50);
		tableCTHD.validate();
		tableCTHD.repaint();

		JScrollPane scrollCTHD = new JScrollPane(tableCTHD);
//		tableCTHD.getViewport().add(tableCTHD);
		tableCTHD.setPreferredSize(new Dimension(1350, 400));
		pnTableCTHD.removeAll();
		pnTableCTHD.setLayout(new CardLayout());
		pnTableCTHD.add(scrollCTHD);
		pnTableCTHD.validate();
		pnTableCTHD.repaint();

		// Xoa cthd
		btDeleteCTHD.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int dia = JOptionPane.showConfirmDialog(null, "Ban co muon xoa khong?", "Thong bao",
						JOptionPane.YES_NO_OPTION);
				if (dia == JOptionPane.YES_OPTION) {
					Sach s = ModelSach.getSach(Integer.parseInt(modelCTHD.getValueAt(tableCTHD.getSelectedRow(), 0).toString()));
					Object[] o = new Object[5];
					o[0] = s.getMaSach();
					o[1] = s.getTenSach();
					o[2] = s.getTacGia();
					o[3] = s.getGia();
					o[4] = s.getSoLuong();
					modelSP.addRow(o);
					modelCTHD.removeRow(tableCTHD.getSelectedRow());
					tfThongBao.setText("Xoa thanh cong !");
				} 
				else {
					tfThongBao.setText("Xoa khong thanh cong!");
				}
				
				// Tinh tong tien
				double tien = 0;
				for (int j = 0; j < modelCTHD.getRowCount(); ++j) {
					tien += (double) modelCTHD.getValueAt(j, 4);
				}
				tfTongTien.setText(Double.toString(tien));
			}
		});
		
		//Luu HD
		btnAddHD.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int dia = JOptionPane.showConfirmDialog(null, "Ban co muon luu khong?", "Thong bao",
						JOptionPane.YES_NO_OPTION);
				if (dia == JOptionPane.YES_OPTION) {
					HoaDon hd = new HoaDon();
					KhachHang kh = (KhachHang) cbKH.getSelectedItem();
					hd.setMakh(kh.getMaKH());
					User nv = (User) cbNV.getSelectedItem();
					hd.setManv(nv.getId());
					hd.setNgayhd(new java.sql.Date(dcNgayHD.getDate().getTime()));
					hd.setTongTien(Double.parseDouble(tfTongTien.getText().toString()));
					
					List<CTHD> cthds = new ArrayList<>();
					CTHD cthd = null;
					for (int i = 0; i < modelCTHD.getRowCount(); i++) {
						cthd = new CTHD();
						cthd.setMaSach(Integer.parseInt(modelCTHD.getValueAt(i, 0).toString()));
						cthd.setSoLuong(Integer.parseInt(modelCTHD.getValueAt(i, 3).toString()));
						cthd.setThanhTien(Double.parseDouble(modelCTHD.getValueAt(i, 4).toString()));
						cthds.add(cthd);
					}
					hd.setCthd(cthds);
					int id = ModelHoaDon.insert(hd);
					if(id == 0) {
			        	tfThongBao.setText("Luu hoa don khong thanh cong !");
					}
					else {
			        	tfThongBao.setText("Luu hoa don thanh cong !");
						tfMaHD.setText(Integer.toString(id));
					}
				}
			}
		});
		
		//Xuat HD
		btnThanhToan.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ModelHoaDon.xuatHD(Integer.parseInt(tfMaHD.getText().toString()));
				
				while (modelCTHD.getRowCount() > 0) {
					modelCTHD.removeRow(0);
				}
				
				while (modelSP.getRowCount() > 0) {
					modelSP.removeRow(0);
				}
				
				List<Sach> list = ModelSach.getSachs();
				Sach user = null;
				Object[] obj;
				for (int i = 0; i < list.size(); i++) {
					user = list.get(i);
					obj = new Object[5];
					obj[0] = user.getMaSach();
					obj[1] = user.getTenSach();
					obj[2] = user.getTacGia();
					obj[3] = user.getGia();
					obj[4] = user.getSoLuong();
					modelSP.addRow(obj);
				}
				
				tfMaHD.setText(null);
				tfTongTien.setText(null);
			}
		});

	}
}