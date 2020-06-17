/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Connection.SachDAO;
import Model.ModelSach;
import Table.Sach;

import View.SachJFrame;
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

public class QuanLySachController {

    private JPanel jpnView;
    private JButton btnAdd;
    private JTextField jtfSearch;
//    private ModelSach mkh = null;
    private String[] listColumn = {"Mã sách","Tên sách","Tác giả","Giá","Số lượng"};
    private TableRowSorter<TableModel> rowSorter = null;

    public QuanLySachController(JPanel jpnView, JButton btnAdd, JTextField jtfSearch) {
        this.jpnView = jpnView;
        this.btnAdd = btnAdd;
        this.jtfSearch = jtfSearch;
//        this.mkh = new ModelSach();
    }

    public void setDatetoTable() {
        List<Sach> listItem = SachDAO.getList();
//        DefaultTableModel model = new ClassTableModel().setTableSach(listItem, listColumn);
        DefaultTableModel model = new DefaultTableModel();
        model.setColumnIdentifiers(listColumn);
        Object[] obj = null;

        if (listItem.size() > 0) {
            for (int i = 0; i < listItem.size(); i++) {
                Sach sach = listItem.get(i);
                obj = new Object[listColumn.length];
                obj[0] = sach.getMaSach();
                obj[1] = sach.getTenSach();
                obj[2] = sach.getTacGia();
                obj[3] = sach.getGia();
                obj[4] = sach.getSoLuong();
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

                    Sach sach = new Sach();

                    sach.setMaSach((int) model.getValueAt(selectedRowIndex, 0));
                    sach.setTenSach(model.getValueAt(selectedRowIndex, 1).toString());
                    sach.setTacGia(model.getValueAt(selectedRowIndex, 2).toString());
                    sach.setGia((int) model.getValueAt(selectedRowIndex, 3));
                    sach.setSoLuong((int) model.getValueAt(selectedRowIndex, 4));
                                        
                    SachJFrame frame = new SachJFrame(sach);
                    frame.setTitle("Thông Tin Sach ");
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
                SachJFrame frame = new SachJFrame(new Sach());
                frame.setTitle("Thông tin sách ");
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
