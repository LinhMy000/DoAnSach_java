package Controller;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JLabel;
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
	private JPanel jpnView;
    //private JButton btnAdd;
    private JTextField jtfSearch = null;
    private final String[] columns = {"ID", "Tai Khoan", "Mat Khau", "Ho Ten", "Tinh Trang", "Quyen"};
    private TableRowSorter<TableModel> rowSorter = null;

    public ControllerTaiKhoan(JPanel pnDangKy, JTextField tfTaiKhoan, JTextField tfMatKhau, JTextField tfHoTen, JLabel lbThongBao, JButton btDangKy) {
		this.pnDangKy = pnDangKy;
		this.tfTaiKhoan = tfTaiKhoan;
		this.tfMatKhau = tfMatKhau;
		this.tfHoTen = tfHoTen;
		this.btDangKy = btDangKy;
		this.lbThongBao = lbThongBao;
	}

    public void setDataToTable() {
        List<User> listItem = ModelUser.getUsers();
//        DefaultTableModel model = classTableModel.setTableHocVien(listItem, columns);
        DefaultTableModel model = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int rowIndex, int colIndex) {
                return false;
            }

            @Override
            public Class<?> getColumnClass(int columnIndex) {
                return columnIndex == 7 ? Boolean.class : String.class;
            }
        };
        model.setColumnIdentifiers(columns);
        Object[] obj;
        User user = null;
        for (int i = 0; i < listItem.size(); i++) {
        	user = listItem.get(i);
            obj = new Object[columns.length];
            obj[0] = user.getId();
            obj[1] = (i + 1);
            obj[2] = user.getTaiKhoan();
            obj[3] = user.getMatKhau();
            obj[5] = user.getHoTen();
            obj[6] = user.isTinhTrang();
            obj[7] = user.isQuyen();
            model.addRow(obj);
        }

        JTable table = new JTable(model);

        rowSorter = new TableRowSorter<>(table.getModel());
        table.setRowSorter(rowSorter);

        jtfSearch.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                String text = jtfSearch.getText();
                if(text.trim().length() == 0) {
                    rowSorter.setRowFilter(null);
                } 
                else { 
                    rowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + text));
                }
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                String text = jtfSearch.getText();
                if (text.trim().length() == 0) {
                    rowSorter.setRowFilter(null);
                } 
                else {
                    rowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + text));
                }
            }

            @Override
            public void changedUpdate(DocumentEvent e) {}
        });

        // design
        table.getColumnModel().getColumn(1).setMaxWidth(80);
        table.getColumnModel().getColumn(1).setMinWidth(80);
        table.getColumnModel().getColumn(1).setPreferredWidth(80);
        
        table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
            	if (e.getClickCount() == 2 && table.getSelectedRow() != -1) {
            		DefaultTableModel model = (DefaultTableModel) table.getModel();
            		int selectedRowIndex = table.getSelectedRow();
            		selectedRowIndex = table.convertRowIndexToModel(selectedRowIndex);

            		User user = new User();
            		user.setId((int) model.getValueAt(selectedRowIndex, 0));
            		user.setTaiKhoan(model.getValueAt(selectedRowIndex, 1).toString());
            		user.setMatKhau(model.getValueAt(selectedRowIndex, 2).toString());
            		user.setHoTen(model.getValueAt(selectedRowIndex, 3).toString());
            		user.setTinhTrang((boolean) model.getValueAt(selectedRowIndex, 4));
                    user.setQuyen((boolean) model.getValueAt(selectedRowIndex, 5));

                    HocVienFrame frame = new HocVienFrame(user);
                    frame.setLocationRelativeTo(null);
                    frame.setResizable(false);
                    frame.setVisible(true);
            	}
            }
        });
        
        table.getTableHeader().setFont(new Font("Tahoma", Font.BOLD, 14));
        table.getTableHeader().setPreferredSize(new Dimension(100, 50));
        table.setRowHeight(50);
        table.validate();
        table.repaint();
        
        JScrollPane scroll = new JScrollPane();
        scroll.getViewport().add(table);
        scroll.setPreferredSize(new Dimension(1350, 400));
        jpnView.removeAll();
        jpnView.setLayout(new CardLayout());
        jpnView.add(scroll);
        jpnView.validate();
        jpnView.repaint();
    }
    
//    public void setEvent() {
//    	btnAdd.addMouseListener(new MouseAdapter() {
//            @Override
//            public void mouseClicked(MouseEvent e) {
//            	HocVienFrame frame = new HocVienFrame(new HocVien());
//                frame.setLocationRelativeTo(null);
//                frame.setResizable(false);
//                frame.setVisible(true);
//            }
//
//            @Override
//            public void mouseEntered(MouseEvent e) {
//            	btnAdd.setBackground(new Color(192, 192, 192));
//            }
//
//            @Override
//            public void mouseExited(MouseEvent e) {
//            	btnAdd.setBackground(new Color(240, 240, 240));
//            }
//        });
//    }
}