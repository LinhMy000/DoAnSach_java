package Controller;

import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JCheckBox;
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

import Model.ModelUser;
import Table.User;

public class ControllerTaiKhoan {
	private JButton btAdd;
	private JButton btDelete;
	private JTextField tfSearch = null;
	private JTextField tfTaiKhoan;
	private JTextField tfMatKhau;
	private JTextField tfHoTen;
	private JCheckBox cbTinhTrang;
	private JCheckBox cbQuyen;
	private JLabel tfThongBao;
	private JPanel pnTable;

	public ControllerTaiKhoan(JButton btAdd, JButton btDelete, JTextField tfSearch, JTextField tfTaiKhoan,
			JTextField tfMatKhau, JTextField tfHoTen, JCheckBox cbTinhTrang, JCheckBox cbQuyen, JLabel tfThongBao,
			JPanel pnTable) {
		this.btAdd = btAdd;
		this.btDelete = btDelete;
		this.tfSearch = tfSearch;
		this.tfTaiKhoan = tfTaiKhoan;
		this.tfMatKhau = tfMatKhau;
		this.tfHoTen = tfHoTen;
		this.cbTinhTrang = cbTinhTrang;
		this.tfThongBao = tfThongBao;
		this.cbQuyen = cbQuyen;
		this.pnTable = pnTable;
	}

	public void setViewAndEvent() {
		DefaultTableModel model = new DefaultTableModel(
				new String[] { "STT", "ID", "Tài Khoản", "Mật Khẩu", "Họ Tên", "Tình Trạng", "Quyền" }, 0) {
			@Override
			public boolean isCellEditable(int row, int col) {
				return (col != 0 && col != 1);
			}

			@Override
			public Class<?> getColumnClass(int col) {
				return col == 7 ? Boolean.class : String.class;
			}
		};

		// Day du lieu tu csdl len table
		List<User> list = ModelUser.getUsers();
		User user = null;
		Object[] obj;
		for (int i = 0; i < list.size(); i++) {
			user = list.get(i);
			obj = new Object[7];
			obj[0] = (i + 1);
			obj[1] = user.getId();
			obj[2] = user.getTaiKhoan();
			obj[3] = user.getMatKhau();
			obj[4] = user.getHoTen();
			obj[5] = user.isTinhTrang();
			obj[6] = user.isQuyen();
			model.addRow(obj);
		}

		JTable table = new JTable(model);
		TableRowSorter<TableModel> rowSorter = new TableRowSorter<>(model);
		table.setRowSorter(rowSorter);

		// design
		table.getTableHeader().setFont(new Font("Tahoma", Font.BOLD, 14));
		table.getTableHeader().setPreferredSize(new Dimension(100, 50));
		table.setRowHeight(50);
		table.validate();
		table.repaint();

		JScrollPane scroll = new JScrollPane();
		scroll.getViewport().add(table);
		scroll.setPreferredSize(new Dimension(1350, 400));
		pnTable.removeAll();
		pnTable.setLayout(new CardLayout());
		pnTable.add(scroll);
		pnTable.validate();
		pnTable.repaint();

		// Tim kiem
		tfSearch.getDocument().addDocumentListener(new DocumentListener() {
			@Override
			public void insertUpdate(DocumentEvent e) {
				String text = tfSearch.getText();
				if (text.trim().length() == 0) {
					rowSorter.setRowFilter(null);
				} else {
					rowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + text));
				}
			}

			@Override
			public void removeUpdate(DocumentEvent e) {
				String text = tfSearch.getText();
				if (text.trim().length() == 0) {
					rowSorter.setRowFilter(null);
				} else {
					rowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + text));
				}
			}

			@Override
			public void changedUpdate(DocumentEvent e) {
			}
		});

		// Sua tren table
		table.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				User user = new User();
				int index = table.getSelectedRow();
				for (int i = 0; i < list.size(); i++) {
					user.setId((int) model.getValueAt(index, 1));
					user.setTaiKhoan((String) model.getValueAt(index, 2));
					user.setMatKhau((String) model.getValueAt(index, 3));
					user.setHoTen((String) model.getValueAt(index, 4));
					user.setTinhTrang((boolean) model.getValueAt(index, 5));
					user.setQuyen((boolean) model.getValueAt(index, 6));
				}
				int row = ModelUser.update(user);
				if (row > 0) {
					tfThongBao.setText("Sửa thành công!");
				} else {
					tfThongBao.setText("Sửa không thành công!");
				}
			}
		});

		// Them
		btAdd.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (tfTaiKhoan.getText().length() == 0 || tfMatKhau.getText().length() == 0
						|| tfHoTen.getText().length() == 0) {
					tfThongBao.setText("Vui lòng điền đầy đủ thông tin!");
				} 
				else {
					int dia = JOptionPane.showConfirmDialog(null, "Bạn có muốn thêm không?", "Thông báo",
							JOptionPane.YES_NO_OPTION);
					if (dia == JOptionPane.YES_OPTION) {
						User user = new User();
//        					user.setId();
						user.setTaiKhoan(tfTaiKhoan.getText());
						user.setMatKhau(tfMatKhau.getText());
						user.setHoTen(tfHoTen.getText());
						user.setTinhTrang(cbTinhTrang.isSelected());
						user.setQuyen(cbQuyen.isSelected());
//						list.add(user);
						int row = ModelUser.insert(user);
						if (row != 0) {
							tfThongBao.setText("Thêm thành công!");
							tfTaiKhoan.setText(null);
							tfMatKhau.setText(null);
							tfHoTen.setText(null);

							// Xoa table cu
							while (model.getRowCount() > 0) {
								model.removeRow(0);
							}
							// Tai lai table moi
							List<User> list = ModelUser.getUsers();
							Object[] obj;
							for (int i = 0; i < list.size(); i++) {
								user = list.get(i);
								obj = new Object[7];
								obj[0] = (i + 1);
								obj[1] = user.getId();
								obj[2] = user.getTaiKhoan();
								obj[3] = user.getMatKhau();
								obj[4] = user.getHoTen();
								obj[5] = user.isTinhTrang();
								obj[6] = user.isQuyen();
								model.addRow(obj);
							}
						} else {
							tfThongBao.setText("Thêm không thành công!");
						}
					}
				}
                        }
		});

		// Xoa
		btDelete.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int dia = JOptionPane.showConfirmDialog(null, "Bạn có muốn xóa không?", "Thông báo",
						JOptionPane.YES_NO_OPTION);
				if (dia == JOptionPane.YES_OPTION) {
					int id = (int) model.getValueAt(table.getSelectedRow(), 1);
					int row = ModelUser.delete(id);
					if (row > 0) {
						tfThongBao.setText("Xóa thành công " + row + " dòng!");

						// Xoa table cu
						while (model.getRowCount() > 0) {
							model.removeRow(0);
						}
						// Tai lai table moi
						List<User> list = ModelUser.getUsers();
						User user = null;
						Object[] obj;
						for (int i = 0; i < list.size(); i++) {
							user = list.get(i);
							obj = new Object[7];
							obj[0] = (i + 1);
							obj[1] = user.getId();
							obj[2] = user.getTaiKhoan();
							obj[3] = user.getMatKhau();
							obj[4] = user.getHoTen();
							obj[5] = user.isTinhTrang();
							obj[6] = user.isQuyen();
							model.addRow(obj);
						}
					} else {
						tfThongBao.setText("Xóa không thành công!");
					}
				}
			}
		});
	}
}
