/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Connection.KhachHangDAO;
import Model.ModelKhachHang;
import Table.KhachHang;
import Utility.ClassTableModel;
import View.KhachHangJFrame;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Date;
import java.util.List;
import javax.swing.JButton;
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

public class QuanLyKHController {

    private JPanel jpnView;
    private JButton btnAdd;
    private JTextField jtfSearch;
//    private ModelKhachHang mkh = null;
    private String[] listColumn = {" Mã khách hàng", "Họ và tên", "Ngày Sinh ", " Số Điện Thoại ", "Địa Chỉ", "Điểm"};
    private TableRowSorter<TableModel> rowSorter = null;

    public QuanLyKHController(JPanel jpnView, JButton btnAdd, JTextField jtfSearch) {
        this.jpnView = jpnView;
        this.btnAdd = btnAdd;
        this.jtfSearch = jtfSearch;
//        this.mkh = new ModelKhachHang();
    }

    public void setDatetoTable() {
        List<KhachHang> listItem = KhachHangDAO.getList();
//        DefaultTableModel model = new ClassTableModel().setTableKhachHang(listItem, listColumn);
        DefaultTableModel model = new DefaultTableModel();
        model.setColumnIdentifiers(listColumn);
        Object[] obj = null;

        if (listItem.size() > 0) {
            for (int i = 0; i < listItem.size(); i++) {
                KhachHang khachhang = listItem.get(i);
                obj = new Object[listColumn.length];
                obj[0] = khachhang.getMaKH();
                obj[1] = khachhang.getHoTen();
                obj[2] = khachhang.getNgaySinh();
                obj[3] = khachhang.getSdt();
                obj[4] = khachhang.getDiaChi();
                obj[5] = khachhang.getDiem();
                model.addRow(obj);
            }
        }
        
        JTable table = new JTable(model);
        rowSorter = new TableRowSorter<>(table.getModel());
        table.setRowSorter(rowSorter);

        jtfSearch.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                String text = jtfSearch.getText();
                if (text.trim().length() == 0) {
                    rowSorter.setRowFilter(null);
                } else {
                    rowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + text));
                }

            }
            @Override
            public void removeUpdate(DocumentEvent e) {
                String text = jtfSearch.getText();
                if (text.trim().length() == 0) {
                    rowSorter.setRowFilter(null);
                } else {
                    rowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + text));
                }
            }
            @Override
            public void changedUpdate(DocumentEvent e) {
                String text = jtfSearch.getText();
                if (text.trim().length() == 0) {
                    rowSorter.setRowFilter(null);
                } else {
                    rowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + text));
                }
            }
        });

        table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 1 && table.getSelectedRow() != -1) {
                    DefaultTableModel model = (DefaultTableModel) table.getModel();
                    int selectedRowIndex = table.getSelectedRow();
                    selectedRowIndex = table.convertRowIndexToModel(selectedRowIndex);
                    System.out.println(selectedRowIndex);

                    KhachHang khachhang = new KhachHang();

                    khachhang.setMaKH((int) model.getValueAt(selectedRowIndex, 0));
                    khachhang.setHoTen(model.getValueAt(selectedRowIndex, 1).toString());
                    khachhang.setNgaySinh((Date) model.getValueAt(selectedRowIndex, 2));
                    khachhang.setSdt(model.getValueAt(selectedRowIndex, 3) != null
                            ? model.getValueAt(selectedRowIndex, 3).toString() : "");
                    khachhang.setDiaChi(model.getValueAt(selectedRowIndex, 4) != null
                            ? model.getValueAt(selectedRowIndex, 4).toString() : "");
                    khachhang.setDiem((int) model.getValueAt(selectedRowIndex, 5));

                    KhachHangJFrame frame = new KhachHangJFrame(khachhang);
                    frame.setTitle("Thông Tin Khách Hàng ");
                    frame.setResizable(false);
                    frame.setLocationRelativeTo(null);
                    frame.setVisible(true);
                }

            }

        });

        table.getTableHeader().setFont(new Font("Arrial", Font.BOLD, 14));
        table.getTableHeader().setPreferredSize(new Dimension(60, 50));
        table.setRowHeight(40);
        table.validate();
        table.repaint();

        JScrollPane scrollpane = new JScrollPane();
        scrollpane.getViewport().add(table);
        scrollpane.setPreferredSize(new Dimension(1000, 300));

        jpnView.removeAll();
        jpnView.setLayout(new BorderLayout());
        jpnView.add(scrollpane);
        jpnView.validate();
        jpnView.repaint();

    }

    public void setEvent() {
        btnAdd.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                KhachHangJFrame frame = new KhachHangJFrame(new KhachHang());
                frame.setTitle("Thông tin khách hàng ");
                frame.setLocationRelativeTo(null);
                frame.setResizable(false);
                frame.setVisible(true);
            }

            public void mouseEntered(MouseEvent e) {
                btnAdd.setBackground(new Color(0, 200, 83));
            }

            public void mouseExited(MouseEvent e) {
                btnAdd.setBackground(new Color(100, 221, 23));
            }
        }
        );

    }

}
