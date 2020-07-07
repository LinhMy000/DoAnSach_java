package Controller;

import Model.ModelHoaDon;
import Table.CTHD;
import Table.HoaDon;
import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
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

public class ControllerHoaDon {

    private JPanel viewHoaDon;
    private JPanel viewCTHD;
    private JTextField jtfSearch;

    public ControllerHoaDon(JPanel viewHoaDon, JPanel viewCTHD, JTextField jtfSearch) {
        this.viewHoaDon = viewHoaDon;
        this.viewCTHD = viewCTHD;
        this.jtfSearch = jtfSearch;
    }

    public void setViewAndEvent() {
        //tạo table hoa don
        DefaultTableModel modelSP = new DefaultTableModel(new String[]{"STT", "Ma HD", "Ngay HD", "Ma KH", "Ma NV", "Tong Tien"}, 0) {
            @Override
            public boolean isCellEditable(int row, int col) {
                return false;
            }

            @Override
            public Class<?> getColumnClass(int col) {
                return col == 6 ? Boolean.class : String.class;
            }
        };
        //lay danh sach cua hoa don
        List<HoaDon> list = ModelHoaDon.getHoaDons();
        HoaDon hd = null;
        Object[] obj;
        for (int i = 0; i < list.size(); i++) {
            hd = list.get(i);
            obj = new Object[6];
            obj[0] = i + 1;
            obj[1] = hd.getMahd();
            obj[2] = hd.getNgayhd();
            obj[3] = hd.getMakh();
            obj[4] = hd.getManv();
            obj[5] = hd.getTongTien();
            modelSP.addRow(obj);
        }

        JTable tableSP = new JTable(modelSP);
        TableRowSorter<TableModel> rowSorterSP = new TableRowSorter<>(modelSP);
        tableSP.setRowSorter(rowSorterSP);

        // design table
        tableSP.getTableHeader().setFont(new Font("Tahoma", Font.BOLD, 14));
        tableSP.getTableHeader().setPreferredSize(new Dimension(50, 50));
        tableSP.setRowHeight(40);
        tableSP.validate();
        tableSP.repaint();

        JScrollPane scrollSP = new JScrollPane();
        scrollSP.getViewport().add(tableSP);
        scrollSP.setPreferredSize(new Dimension(1250, 300));
        viewHoaDon.removeAll();
        viewHoaDon.setLayout(new CardLayout());
        viewHoaDon.add(scrollSP);
        viewHoaDon.validate();
        viewHoaDon.repaint();

        jtfSearch.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                String text = jtfSearch.getText();
                if (text.trim().length() == 0) {
                    rowSorterSP.setRowFilter(null);
                } else {
                    rowSorterSP.setRowFilter(RowFilter.regexFilter("(?i)" + text));
                }
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                String text = jtfSearch.getText();
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

        //hien thi chi tiet hoa don khi chon model hoa don
        DefaultTableModel modelCTHD = new DefaultTableModel(new String[]{"Ma HD", "Ma Sach", "So Luong", "Thanh Tien"}, 0);
        tableSP.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 2 && tableSP.getSelectedRow() != -1) {
                    while (modelCTHD.getRowCount() > 0) {
                        modelCTHD.removeRow(0);
                    }
                    
                    int id = Integer.parseInt(modelSP.getValueAt(tableSP.getSelectedRow(), 1).toString());

                    // them vao table cthd
                    List<CTHD> list = ModelHoaDon.getCTHDs(id);
                    CTHD cthd = null;
                    Object[] obj;
                    for (int i = 0; i < list.size(); i++) {
                        cthd = list.get(i);
                        obj = new Object[4];
//                        obj[0] = modelCTHD.getValueAt(i, 0);
//                        obj[1] = modelCTHD.getValueAt(i, 1);
//                        obj[2] = modelCTHD.getValueAt(i, 2);
//                        obj[3] = modelCTHD.getValueAt(i, 3);
                        obj[0] = cthd.getMaHD();
                        obj[1] = cthd.getMaSach();
                        obj[2] = cthd.getSoLuong();
                        obj[3] = cthd.getThanhTien();

                        modelCTHD.addRow(obj);
//                        modelSP.removeRow(id);
                    }
                }
            }
        });
        JTable tableCTHD = new JTable(modelCTHD);
        TableRowSorter<TableModel> rowSorterCTHD = new TableRowSorter<>(modelCTHD);
        tableCTHD.setRowSorter(rowSorterCTHD);

        tableCTHD.getTableHeader().setFont(new Font("Tahoma", Font.BOLD, 14));
        tableCTHD.getTableHeader().setPreferredSize(new Dimension(50, 50));
        tableCTHD.setRowHeight(40);
        tableCTHD.validate();
        tableCTHD.repaint();

        JScrollPane scrollCTHD = new JScrollPane(tableCTHD);
//		tableCTHD.getViewport().add(tableCTHD);
        tableCTHD.setPreferredSize(new Dimension(700, 200));
        viewCTHD.removeAll();
        viewCTHD.setLayout(new CardLayout());
        viewCTHD.add(scrollCTHD);
        viewCTHD.validate();
        viewCTHD.repaint();

    }
}
