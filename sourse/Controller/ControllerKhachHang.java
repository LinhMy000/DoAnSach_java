/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Connection.ConnectionUser;
import Model.ModelKhachHang;
import Model.ModelUser;
import Table.KhachHang;
import Table.User;
import static com.sun.xml.internal.fastinfoset.alphabet.BuiltInRestrictedAlphabets.table;
import com.toedter.calendar.JDateChooser;
import java.awt.BorderLayout;
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
import java.sql.Date;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.RowFilter;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author Huong_Nho_UIT
 */
public class ControllerKhachHang {

    private JButton btnThem;
    private JButton btnXoa;
    private JTextField jtfMaKH;
    private JTextField jtfTenKH;
    private JDateChooser jdcNgaySinh;
    private JTextField jtfSoDT;
    private JTextField jtfDiaChi;
    private JTextField jtfDiem;
    private JLabel jlbThongBao;
    private JPanel jpnRoot;
    private JTextField jtfSearch;

   
    private ModelKhachHang mkh = null;
  

    public ControllerKhachHang() {
    }
    
    public ControllerKhachHang(JButton btnThem, JButton btnXoa, JTextField jtfMaKH, JTextField jtfTenKH, JDateChooser jdcNgaySinh, JTextField jtfSoDT, JTextField jtfDiaChi, JTextField jtfDiem, JLabel jlbThongBao, JPanel jpnRoot, JTextField jtfSearch) {
        this.btnThem = btnThem;
        this.btnXoa = btnXoa;
        this.jtfMaKH = jtfMaKH;
        this.jtfTenKH = jtfTenKH;
        this.jdcNgaySinh = jdcNgaySinh;
        this.jtfSoDT = jtfSoDT;
        this.jtfDiaChi = jtfDiaChi;
        this.jtfDiem = jtfDiem;
        this.jlbThongBao = jlbThongBao;
        this.jpnRoot = jpnRoot;
        this.jtfSearch = jtfSearch;
        
    }


    public void setViewAndEvent() {
        DefaultTableModel model = new DefaultTableModel(
                new String[] {"STT", "MaKH", "Ho va Ten", "Ngay Sinh", "So Dien Thoai", "Dia Chi", "Diem"},0) {
            @Override
            public boolean isCellEditable(int row, int col) {
                return (col != 0 && col != 1);
            }

            @Override
            public Class<?> getColumnClass(int col) {
                return col == 7 ? Boolean.class : String.class;
            }
        };
        //lay danh sach khach hang
        List<KhachHang> list = ModelKhachHang.getList();
        KhachHang khachhang = null;
        Object[] obj;
        for (int i = 0; i < list.size(); i++) {
            khachhang = list.get(i);
            obj = new Object[7];
            obj[0] = (i + 1);
            obj[1] = khachhang.getMaKH();
            obj[2] = khachhang.getHoTen();
            obj[3] = khachhang.getNgaySinh();
            obj[4] = khachhang.getSdt();
            obj[5] = khachhang.getDiaChi();
            obj[6] = khachhang.getDiem();
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

            jpnRoot.removeAll();
            jpnRoot.setLayout(new CardLayout());
            jpnRoot.add(scrollpane);
            jpnRoot.validate();
            jpnRoot.repaint();

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
                }
            });

            //sua tren table
            table.addKeyListener(new KeyAdapter() {
                @Override
                public void keyReleased(KeyEvent e) {
                    KhachHang khachhang = new KhachHang();
                    int index = table.getSelectedRow();
                    for (int i = 0; i < list.size(); i++) {
                        khachhang.setMaKH((int) model.getValueAt(index, 1));
                        khachhang.setHoTen((String) model.getValueAt(index, 2));
                        khachhang.setNgaySinh((java.sql.Date) model.getValueAt(index, 3));
                        khachhang.setSdt((String) model.getValueAt(index, 4));
                        khachhang.setDiaChi((String) model.getValueAt(index, 5));
                        khachhang.setDiem((int) model.getValueAt(index, 6));
                    }
                    int row = ModelKhachHang.insert(khachhang);
                    if (row > 0) {
                        jlbThongBao.setText("Sua thanh cong!");
                    } else {
                        jlbThongBao.setText("Sua khong thanh cong!");
                    }
                }
            });

            btnThem.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if (jtfTenKH.getText().length() == 0) {
                        jlbThongBao.setText("Vui lòng điền đầy đủ thông tin!");
                    } else {
                        int dia = JOptionPane.showConfirmDialog(null, "Bạn có thông báo không?", "Thông báo",
                                JOptionPane.YES_NO_OPTION);
                        if (dia == JOptionPane.YES_OPTION) {

                            KhachHang khachhang = new KhachHang();
                            khachhang.setHoTen(jtfTenKH.getText());
                            khachhang.setNgaySinh(new java.sql.Date(jdcNgaySinh.getDate().getTime()));
                            khachhang.setDiaChi(jtfDiaChi.getText());
                            khachhang.setSdt(jtfSoDT.getText());
                            khachhang.setDiem(0);
                            list.add(khachhang);
                            
                            int row = ModelKhachHang.insert(khachhang);
                            if (row != 0) {
                                jlbThongBao.setText("Thêm thành công!");
                                jtfTenKH.setText(null);

//                                 Xoa table cu
                                while (model.getRowCount() > 0) {
                                    model.removeRow(0);
                                }
                                // Tai lai table moi

                                List<KhachHang> list = ModelKhachHang.getList();
                                Object[] obj;
                                for (int i = 0; i < list.size(); i++) {

                                    khachhang = list.get(i);
                                    obj = new Object[7];
                                    obj[0] = (i + 1);
                                    obj[1] = khachhang.getMaKH();
                                    obj[2] = khachhang.getHoTen();
                                    obj[3] = khachhang.getNgaySinh();
                                    obj[4] = khachhang.getSdt();
                                    obj[5] = khachhang.getDiaChi();
                                    obj[6] = khachhang.getDiem();
                                    model.addRow(obj);
                                }
                            } else {
                                jlbThongBao.setText("Thêm không thành công!");
                            }
                        }
                    }
                }
            });

            btnXoa.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    int dia = JOptionPane.showConfirmDialog(null, "Bạn có muốn xóa không?", "Thông báo",
                            JOptionPane.YES_NO_OPTION);
                    if (dia == JOptionPane.YES_OPTION) {
                        int id = (int) model.getValueAt(table.getSelectedRow(), -1);
                        int row = ModelKhachHang.delete(id);
                        if (row > 0) {
                            jlbThongBao.setText("Xóa thành công " + row + " dòng!");

                            // Xoa table cu
                            while (model.getRowCount() > 0) {
                                model.removeRow(0);
                            }
                            // Tai lai table moi
                            List<KhachHang> list = ModelKhachHang.getList();
                            KhachHang khachhang = null;
                            Object[] obj;
                            for (int i = 0; i < list.size(); i++) {

                                khachhang = list.get(i);
                                obj = new Object[7];
                                obj[0] = (i + 1);
                                obj[1] = khachhang.getMaKH();
                                obj[2] = khachhang.getHoTen();
                                obj[3] = khachhang.getNgaySinh();
                                obj[4] = khachhang.getSdt();
                                obj[5] = khachhang.getDiaChi();
                                obj[6] = khachhang.getDiem();
                                model.addRow(obj);
                            }
                        } else {
                            jlbThongBao.setText("Thêm không thành công!");
                        }
                    }
                }
           });
      }
   }
}
//   