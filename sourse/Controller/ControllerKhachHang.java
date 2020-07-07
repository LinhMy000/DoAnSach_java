/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Connection.ConnectionUser;
import Connection.ConnectionKhachHang;
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
//import java.sql.Date;
import java.util.Date;
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
        List<KhachHang> list = ConnectionKhachHang.getList();
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
                        jlbThongBao.setText("Vui long dien day du thong tin!");
                    } else {
                        int dia = JOptionPane.showConfirmDialog(null, "Ban co muon them khong?", "Thong bao",
                                JOptionPane.YES_NO_OPTION);
                        if (dia == JOptionPane.YES_OPTION) {

                            KhachHang khachhang = new KhachHang();
                            khachhang.setHoTen(jtfTenKH.getText());
                            khachhang.setNgaySinh(jdcNgaySinh.getDate());
                            khachhang.setDiaChi(jtfDiaChi.getText());
                            khachhang.setSdt(jtfSoDT.getText());
                            khachhang.setDiem(0);
                            list.add(khachhang);
                            
                            int row = ModelKhachHang.insert(khachhang);
                            if (row != 0) {
                                jlbThongBao.setText("Them thanh cong!");
                                jtfTenKH.setText(null);

//                                 Xoa table cu
                                while (model.getRowCount() > 0) {
                                    model.removeRow(0);
                                }
                                // Tai lai table moi

                                List<KhachHang> list = ConnectionKhachHang.getList();
                                Object[] obj;
                                for (int i = 0; i < list.size(); i++) {

                                    khachhang = list.get(i);
                                    obj = new Object[7];
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
                                jlbThongBao.setText("Them khong thanh cong!");
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
                        int id = (int) model.getValueAt(table.getSelectedRow(), -1);
                        int row = ModelKhachHang.delete(id);
                        if (row > 0) {
                            jlbThongBao.setText("Xoa thanh cong " + row + " dong!");

                            // Xoa table cu
                            while (model.getRowCount() > 0) {
                                model.removeRow(0);
                            }
                            // Tai lai table moi
                            List<KhachHang> list = ConnectionKhachHang.getList();
                            KhachHang khachhang = null;
                            Object[] obj;
                            for (int i = 0; i < list.size(); i++) {

                                khachhang = list.get(i);
                                obj = new Object[7];
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
                            jlbThongBao.setText("Them khong thanh cong!");
                        }
                    }
                }
           });
      }
   }
}
//    public void setEvent() {
//        btnThem.addMouseListener(new MouseAdapter() {
//
//            public void mouseClicked(MouseEvent e) {
//                if (jtfTenKH.getText().isEmpty()) {
//                    JOptionPane.showMessageDialog(btnThem, "Vui lòng nhập thông tin khách hàng ");
//
//                } else {
//                    khachhang.setHoTen(jtfTenKH.getText().trim());
//
//                    khachhang.setNgaySinh((Date) jdcNgaySinh.getDate());
//                    khachhang.setSdt(jtfSoDT.getText());
//                    khachhang.setDiaChi(jtfDiaChi.getText());
//                    khachhang.setDiem(0);
//
//                    int lastID = khd.createOrUpdate(khachhang);
//                    if (lastID > 0) {
//                        khachhang.setMaKH(lastID);
//                        jtfMaKH.setText(" " + lastID);
//                        int ref = JOptionPane.showConfirmDialog(btnThem, "Bạn có muốn lưu ?", "Lưu", JOptionPane.YES_NO_OPTION);
//                        if (ref == JOptionPane.YES_OPTION) {
//                            JOptionPane.showMessageDialog(btnThem, "Cập nhập thành công  ");
//                        }
//
//                    }
//                }
//            }
//
//            public void mouseEntered(MouseEvent e) {
//                btnThem.setBackground(new Color(0, 200, 83));
//            }
//
//            public void mouseExited(MouseEvent e) {
//                btnThem.setBackground(new Color(100, 221, 23));
//            }
//        });
//
//    }
//
//    public void setEventDE() {
//        btnXoa.addMouseListener(new MouseAdapter() {
//
//            public void mouseClicked(MouseEvent e) {
//                if (jtfMaKH.getText().isEmpty()) {
//                    JOptionPane.showMessageDialog(btnXoa, "Vui lòng nhập mã khách hàng ");
//
//                } else {
//                    int lastID = khd.DeLeTe(khachhang);
//                    if (lastID > 0) {
//                        khachhang.setMaKH(lastID);
//                        jtfMaKH.setText(" " + lastID);
//                        int ref = JOptionPane.showConfirmDialog(btnXoa, "Bạn có muốn xóa ?", "Xóa", JOptionPane.YES_NO_OPTION);
//
//                        if (ref == JOptionPane.YES_OPTION) {
//                            JOptionPane.showMessageDialog(btnXoa, "Xóa thành công  ");
//
//                        }
//
//                    }
//
//                }
//            }
//
//            @Override
//            public void mouseEntered(MouseEvent e) {
//                btnXoa.setBackground(new Color(0, 200, 83));
//            }
//
//            public void mouseExited(MouseEvent e) {
//                btnXoa.setBackground(new Color(100, 221, 23));
//            }
//        });
//    }

