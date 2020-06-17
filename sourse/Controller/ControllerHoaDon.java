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

import Model.ModelSach;
import Model.ModelUser;
import Table.Sach;
import Table.User;

public class ControllerHoaDon {
	private JPanel pnTableSP;
	private JTextField tfSearchSP;
	private JPanel pnTableCTHD;
	private JButton btDeleteCTHD;
//	private JTextField tfMaHD;
	private JComboBox cbNV;
	private JComboBox cbKH;
	private JDateChooser dcNgayHD;
	private JButton btnAddHD;
	private JButton btnThanhToan;
	private JTextField tfTongTien;
	private JTextField tfMahd;
	private JLabel tfThongBao;

	public ControllerHoaDon(JPanel pnTableSP, JTextField tfSearchSP, JPanel pnTableCTHD, JButton btDeleteCTHD,
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
		this.tfMahd = tfMahd;
	}

	public void setViewAndEvent() {
		/* Hien thi danh sach san pham len table sach */
		// cai dat model
		DefaultTableModel modelSP = new DefaultTableModel(
				new String[] { "STT", "Ma Sach", "Ten Sach", "Tac Gia", "Gia", "So Luong" }, 0) {
			@Override
			public boolean isCellEditable(int row, int col) {
				return false;
			}

			@Override
			public Class<?> getColumnClass(int col) {
				return col == 6 ? Boolean.class : String.class;
			}
		};

		// them danh sach tu csdl vao model (table sach)
		List<Sach> list = ModelSach.getSachs();
		Sach user = null;
		Object[] obj;
		for (int i = 0; i < list.size(); i++) {
			user = list.get(i);
			obj = new Object[6];
			obj[0] = (i + 1);
			obj[1] = user.getMaSach();
			obj[2] = user.getTenSach();
			obj[3] = user.getTacGia();
			obj[4] = user.getGia();
			obj[5] = user.getSoLuong();
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

		// Tim kiem san pham
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

		/* Hien thi CTHD khi chon tren table san pham */
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

		// su kien khi chon san pham
		tableSP.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (e.getClickCount() == 2 && tableSP.getSelectedRow() != -1) {
					int i = tableSP.getSelectedRow();
					// them vao table cthd
					Object[] ob = new Object[5];
					ob[0] = modelSP.getValueAt(i, 1);
					ob[1] = modelSP.getValueAt(i, 2);
					ob[2] = modelSP.getValueAt(i, 4);
					ob[3] = 1;
					ob[4] = 0;
					modelCTHD.addRow(ob);
					modelSP.removeRow(i);
					int countRow = modelCTHD.getRowCount() - 1;
					modelCTHD.setValueAt(((double) modelCTHD.getValueAt(countRow, 2)) * ((int) modelCTHD.getValueAt(countRow, 3)), countRow, 4);
				}
				
				// Tinh tong tien
				double tien = 0;
				for (int j = 0; j < modelCTHD.getRowCount(); ++j) {
					tien += ((double) modelCTHD.getValueAt(j, 2)) * ((int) modelCTHD.getValueAt(j, 3));
				}
				tfTongTien.setText(Double.toString(tien));
			}
		});

		// su kien sua so luong
		tableCTHD.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
//				Tinh(tableCTHD, modelCTHD);				
			}
		});
		Tinh(tableCTHD, modelCTHD);				

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
					modelCTHD.removeRow(tableCTHD.getSelectedRow());
					tfThongBao.setText("Xoa thanh cong !");
				} else {
					tfThongBao.setText("Xoa khong thanh cong!");
				}
				
				// Tinh tong tien
				double tien = 0;
				for (int j = 0; j < modelCTHD.getRowCount(); ++j) {
					tien += (double) modelCTHD.getValueAt(j, 4);
//					tien += ((double) modelCTHD.getValueAt(j, 2)) * ((int) modelCTHD.getValueAt(j, 3));
				}
				tfTongTien.setText(Double.toString(tien));
			}
		});

	}
	
	protected void Tinh(JTable tableCTHD, DefaultTableModel modelCTHD) {
		double tien = 0;
		for (int j = 0; j < tableCTHD.getRowCount(); ++j) {
//			tien += (double) modelCTHD.getValueAt(j, 4);
			tien += ((double) modelCTHD.getValueAt(j, 2)) * ((double) modelCTHD.getValueAt(j, 3));
		}
		tfTongTien.setText(Double.toString(tien));
	}

}