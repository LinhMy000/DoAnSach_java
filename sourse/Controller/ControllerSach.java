/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.ModelKhachHang;
import Model.ModelSach;
import Table.KhachHang;
import Table.Sach;
import View.ViewSach;
import com.toedter.calendar.JDateChooser;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
//import java.sql.Date;
import javax.swing.JButton;
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

public class ControllerSach {
    
    private  JButton btnSubmit;
    private  JButton btnXoa;
    private JTextField jtfMaSach;
    private JTextField jtfTenSach;
    private JTextField jtfTacGia;
    private JTextField jtfGia;
    private JTextField jtfSoLuong;
    private JLabel jlbMsg;
    private JPanel jpnHienThi;
    private JTextField jtfTimKiem;
    private Sach sach = null;
    private ModelSach ms = null;


    public ControllerSach(JButton btnSubmit, JButton btnXoa, JTextField jtfMaSach, JTextField jtfTenSach,JTextField jtfTacGia, JTextField jtfGia, JTextField jtfSoLuong, JLabel jlbMsg, JPanel jpnHienThi, JTextField jtfTimKiem) {
        this.btnSubmit = btnSubmit;
        this.btnXoa = btnXoa;
        this.jtfMaSach = jtfMaSach;
        this.jtfTenSach = jtfTenSach;
        this.jtfTacGia = jtfTacGia;
        this.jtfGia = jtfGia;
        this.jtfSoLuong = jtfSoLuong;
        this.jlbMsg = jlbMsg;
        this.jpnHienThi= jpnHienThi;
        this.jtfTimKiem = jtfTimKiem;
    }

 
    public void setViewAndEvent() {
        DefaultTableModel model = new DefaultTableModel(
                new String[] {"STT","MaSach", "TenSach", "TacGia", "Gia", "SoLuong"},0) {
            @Override
            public boolean isCellEditable(int row, int col) {
                return (col != 0 && col != 1);
            }

            @Override
            public Class<?> getColumnClass(int col) {
                return col == 6 ? Boolean.class : String.class;
            }
        };
        //lay danh sach sach
        List<Sach> list = ModelSach.getSachs();
        Sach sach = null;
        Object[] obj;
        for (int i = 0; i < list.size(); i++) {
            sach = list.get(i);
            obj = new Object[6];
            obj[0] = (i + 1);
            obj[1] = sach.getMaSach();
            obj[2] = sach.getTenSach();
            obj[3] = sach.getTacGia();
            obj[4] = sach.getGia();
            obj[5] = sach.getSoLuong();
            model.addRow(obj);

            JTable table = new JTable(model);
            TableRowSorter<TableModel> rowSorter = new TableRowSorter<>(model);
            table.setRowSorter(rowSorter);
            
            table.getTableHeader().setFont(new Font("Tohoma", Font.BOLD, 14));
            table.getTableHeader().setPreferredSize(new Dimension(60, 50));
            table.setRowHeight(40);
            table.validate();
            table.repaint();

            JScrollPane scrollpane = new JScrollPane();
            scrollpane.getViewport().add(table);
            scrollpane.setPreferredSize(new Dimension(1000, 300));

            jpnHienThi.removeAll();
            jpnHienThi.setLayout(new CardLayout());
            jpnHienThi.add(scrollpane);
            jpnHienThi.validate();
            jpnHienThi.repaint();

            jtfTimKiem.getDocument().addDocumentListener(new DocumentListener() {
                @Override
                public void insertUpdate(DocumentEvent e) {
                    String text = jtfTimKiem.getText();
                    if (text.trim().length() == 0) {
                        rowSorter.setRowFilter(null);
                    } else {
                        rowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + text));
                    }
                }

                @Override
                public void removeUpdate(DocumentEvent e) {
                    String text = jtfTimKiem.getText();
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

            //sua tren table
            table.addKeyListener(new KeyAdapter() {
                @Override
                public void keyReleased(KeyEvent e) {
                    Sach sach = new Sach();
                    int index = table.getSelectedRow();
                    for (int i = 0; i < list.size(); i++) {
                        sach.setMaSach((int) model.getValueAt(index, 1));
                        sach.setTenSach((String) model.getValueAt(index, 2));                       
                        sach.setTacGia((String) model.getValueAt(index, 3));
                        sach.setGia(Double.parseDouble(model.getValueAt(index, 4).toString()));
                        sach.setSoLuong(Integer.parseInt(model.getValueAt(index, 5).toString()));
                    }
                    int row = ModelSach.createOrUpdate(sach);
                    if (row > 0) {
                        jlbMsg.setText("Sua thanh cong!");
                    } else {
                        jlbMsg.setText("Sua khong thanh cong!");
                    }
                }
            });

            btnSubmit.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if (jtfTenSach.getText().length() == 0) {
                        jlbMsg.setText("Vui long dien day du thong tin!");
                    } else {
                        int dia = JOptionPane.showConfirmDialog(null, "Ban co muon them khong?", "Thong bao",
                                JOptionPane.YES_NO_OPTION);
                        if (dia == JOptionPane.YES_OPTION) {

                            Sach sach = new Sach();
                            sach.setTenSach(jtfTenSach.getText());
                            sach.setTacGia(jtfTacGia.getText());
                            sach.setGia(Double.parseDouble(jtfGia.getText()));
                            sach.setSoLuong(Integer.parseInt(jtfSoLuong.getText()));                          
                            list.add(sach);
                            
                            int row = ModelSach.insert(sach);
                            if (row != 0) {
                                jlbMsg.setText("Them thanh cong!");
                                jtfTenSach.setText(null);

//                                 Xoa table cu
                                while (model.getRowCount() > 0) {
                                    model.removeRow(0);
                                }
                                // Tai lai table moi

                                List<Sach> list = ModelSach.getSachs();
                                Object[] obj;
                                for (int i = 0; i < list.size(); i++) {

                                    sach = list.get(i);
                                    obj = new Object[6];
                                    obj[0] = (i + 1);
                                    obj[1] = sach.getMaSach();
                                    obj[2] = sach.getTenSach();
                                    obj[3] = sach.getTacGia();
                                    obj[4] = sach.getGia();
                                    obj[5] = sach.getSoLuong();
                                    model.addRow(obj);
                                }
                            } else {
                                jlbMsg.setText("Them khong thanh cong!");
                            }
                        }
                    }
                }
            });

            btnXoa.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    int dia = JOptionPane.showConfirmDialog(null, "Ban co muon xoa khong?", "Thong bao",
                            JOptionPane.YES_NO_OPTION);
                    if (dia == JOptionPane.YES_OPTION) {
                        int id = Integer.parseInt(model.getValueAt(table.getSelectedRow(), 1).toString());
                        int row = ModelSach.delete(id);
                        if (row > 0) {
                            jlbMsg.setText("Xoa thanh cong " + row + " dong!");

                            // Xoa table cu
                            while (model.getRowCount() > 0) {
                                model.removeRow(0);
                            }
                            // Tai lai table moi
                            List<Sach> list = ModelSach.getSachs();
                            Sach sach = null;
                            Object[] obj;
                            for (int i = 0; i < list.size(); i++) {

                                sach = list.get(i);
                                obj = new Object[6];
                                obj[0] = (i + 1);
                                obj[1] = sach.getMaSach();
                                obj[2] = sach.getTenSach();
                                obj[3] = sach.getTacGia();
                                obj[4] = sach.getGia();
                                obj[5] = sach.getSoLuong();
                                model.addRow(obj);
                            }
                        } else {
                            jlbMsg.setText("Xoa khong thanh cong!");
                        }
                    }
                }
           });
      }
   }
}
