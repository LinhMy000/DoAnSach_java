package View;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.UIManager;

public class ViewMenu1 extends javax.swing.JFrame {
    
    public ViewMenu1() {
        initComponents();
        setVisible(true);
        
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jLayeredPane1 = new javax.swing.JLayeredPane();
        head_panel = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        side_panel = new javax.swing.JPanel();
        pnTrangChu = new javax.swing.JPanel();
        lbTrangChu = new javax.swing.JLabel();
        ind_1 = new javax.swing.JPanel();
        pnKhachHang = new javax.swing.JPanel();
        ind_2 = new javax.swing.JPanel();
        lbKhachHang = new javax.swing.JLabel();
        pnSach = new javax.swing.JPanel();
        ind_3 = new javax.swing.JPanel();
        lbSach = new javax.swing.JLabel();
        pnBanHang = new javax.swing.JPanel();
        ind_4 = new javax.swing.JPanel();
        lbBanHang = new javax.swing.JLabel();
        pnHoaDon = new javax.swing.JPanel();
        ind_5 = new javax.swing.JPanel();
        lbHoaDon = new javax.swing.JLabel();
        pnThongKe = new javax.swing.JPanel();
        ind_6 = new javax.swing.JPanel();
        lbThongKe = new javax.swing.JLabel();
        pnTaiKhoan = new javax.swing.JPanel();
        ind_7 = new javax.swing.JPanel();
        lbTaiKhoan = new javax.swing.JLabel();
        pnView = new javax.swing.JPanel();

        jLabel1.setText("jLabel1");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jButton1.setText("jButton1");

        javax.swing.GroupLayout jLayeredPane1Layout = new javax.swing.GroupLayout(jLayeredPane1);
        jLayeredPane1.setLayout(jLayeredPane1Layout);
        jLayeredPane1Layout.setHorizontalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jLayeredPane1Layout.setVerticalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setAutoRequestFocus(false);
        setBackground(new java.awt.Color(255, 255, 255));
        setLocation(new java.awt.Point(400, 200));
        setSize(new java.awt.Dimension(0, 0));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        head_panel.setBackground(new java.awt.Color(62, 120, 207));

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("CỬA HÀNG SÁCH");

        javax.swing.GroupLayout head_panelLayout = new javax.swing.GroupLayout(head_panel);
        head_panel.setLayout(head_panelLayout);
        head_panelLayout.setHorizontalGroup(
            head_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, head_panelLayout.createSequentialGroup()
                .addContainerGap(374, Short.MAX_VALUE)
                .addComponent(jLabel11)
                .addGap(272, 272, 272))
        );
        head_panelLayout.setVerticalGroup(
            head_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(head_panelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(head_panel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 850, 50));

        side_panel.setBackground(new java.awt.Color(23, 35, 55));

        pnTrangChu.setBackground(new java.awt.Color(23, 35, 55));
        pnTrangChu.setPreferredSize(new java.awt.Dimension(180, 40));
        pnTrangChu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                pnTrangChuMousePressed(evt);
            }
        });

        lbTrangChu.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        lbTrangChu.setForeground(new java.awt.Color(240, 240, 240));
        lbTrangChu.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lbTrangChu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/icons8_home_30px.png"))); // NOI18N
        lbTrangChu.setText("Trang chủ");

        ind_1.setOpaque(false);
        ind_1.setPreferredSize(new java.awt.Dimension(3, 60));

        javax.swing.GroupLayout ind_1Layout = new javax.swing.GroupLayout(ind_1);
        ind_1.setLayout(ind_1Layout);
        ind_1Layout.setHorizontalGroup(
            ind_1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 3, Short.MAX_VALUE)
        );
        ind_1Layout.setVerticalGroup(
            ind_1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 60, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout pnTrangChuLayout = new javax.swing.GroupLayout(pnTrangChu);
        pnTrangChu.setLayout(pnTrangChuLayout);
        pnTrangChuLayout.setHorizontalGroup(
            pnTrangChuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnTrangChuLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(lbTrangChu, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(59, 59, 59)
                .addComponent(ind_1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnTrangChuLayout.setVerticalGroup(
            pnTrangChuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnTrangChuLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(pnTrangChuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ind_1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbTrangChu, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        pnKhachHang.setBackground(new java.awt.Color(23, 35, 55));
        pnKhachHang.setPreferredSize(new java.awt.Dimension(180, 40));
        pnKhachHang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                pnKhachHangMousePressed(evt);
            }
        });

        ind_2.setOpaque(false);
        ind_2.setPreferredSize(new java.awt.Dimension(3, 60));

        javax.swing.GroupLayout ind_2Layout = new javax.swing.GroupLayout(ind_2);
        ind_2.setLayout(ind_2Layout);
        ind_2Layout.setHorizontalGroup(
            ind_2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 3, Short.MAX_VALUE)
        );
        ind_2Layout.setVerticalGroup(
            ind_2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 60, Short.MAX_VALUE)
        );

        lbKhachHang.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        lbKhachHang.setForeground(new java.awt.Color(240, 240, 240));
        lbKhachHang.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbKhachHang.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/icons8_business_group_30px.png"))); // NOI18N
        lbKhachHang.setText("Khách hàng");

        javax.swing.GroupLayout pnKhachHangLayout = new javax.swing.GroupLayout(pnKhachHang);
        pnKhachHang.setLayout(pnKhachHangLayout);
        pnKhachHangLayout.setHorizontalGroup(
            pnKhachHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnKhachHangLayout.createSequentialGroup()
                .addComponent(ind_2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(lbKhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(26, Short.MAX_VALUE))
        );
        pnKhachHangLayout.setVerticalGroup(
            pnKhachHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(ind_2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(pnKhachHangLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbKhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pnSach.setBackground(new java.awt.Color(23, 35, 55));
        pnSach.setPreferredSize(new java.awt.Dimension(180, 40));
        pnSach.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                pnSachMousePressed(evt);
            }
        });

        ind_3.setOpaque(false);
        ind_3.setPreferredSize(new java.awt.Dimension(3, 60));

        javax.swing.GroupLayout ind_3Layout = new javax.swing.GroupLayout(ind_3);
        ind_3.setLayout(ind_3Layout);
        ind_3Layout.setHorizontalGroup(
            ind_3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 3, Short.MAX_VALUE)
        );
        ind_3Layout.setVerticalGroup(
            ind_3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 60, Short.MAX_VALUE)
        );

        lbSach.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        lbSach.setForeground(new java.awt.Color(240, 240, 240));
        lbSach.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/icons8_open_book_30px.png"))); // NOI18N
        lbSach.setText("Sách");

        javax.swing.GroupLayout pnSachLayout = new javax.swing.GroupLayout(pnSach);
        pnSach.setLayout(pnSachLayout);
        pnSachLayout.setHorizontalGroup(
            pnSachLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnSachLayout.createSequentialGroup()
                .addComponent(ind_3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(lbSach, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        pnSachLayout.setVerticalGroup(
            pnSachLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(ind_3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(pnSachLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbSach, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pnBanHang.setBackground(new java.awt.Color(23, 35, 55));
        pnBanHang.setPreferredSize(new java.awt.Dimension(180, 40));
        pnBanHang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                pnBanHangMousePressed(evt);
            }
        });

        ind_4.setOpaque(false);
        ind_4.setPreferredSize(new java.awt.Dimension(3, 60));

        javax.swing.GroupLayout ind_4Layout = new javax.swing.GroupLayout(ind_4);
        ind_4.setLayout(ind_4Layout);
        ind_4Layout.setHorizontalGroup(
            ind_4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 3, Short.MAX_VALUE)
        );
        ind_4Layout.setVerticalGroup(
            ind_4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 60, Short.MAX_VALUE)
        );

        lbBanHang.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        lbBanHang.setForeground(new java.awt.Color(240, 240, 240));
        lbBanHang.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/icons8_shopping_cart_30px.png"))); // NOI18N
        lbBanHang.setText("Bán Hàng");

        javax.swing.GroupLayout pnBanHangLayout = new javax.swing.GroupLayout(pnBanHang);
        pnBanHang.setLayout(pnBanHangLayout);
        pnBanHangLayout.setHorizontalGroup(
            pnBanHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnBanHangLayout.createSequentialGroup()
                .addComponent(ind_4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lbBanHang, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        pnBanHangLayout.setVerticalGroup(
            pnBanHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(ind_4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(pnBanHangLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbBanHang, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pnHoaDon.setBackground(new java.awt.Color(23, 35, 55));
        pnHoaDon.setPreferredSize(new java.awt.Dimension(180, 40));
        pnHoaDon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                pnHoaDonMousePressed(evt);
            }
        });

        ind_5.setOpaque(false);
        ind_5.setPreferredSize(new java.awt.Dimension(3, 60));

        javax.swing.GroupLayout ind_5Layout = new javax.swing.GroupLayout(ind_5);
        ind_5.setLayout(ind_5Layout);
        ind_5Layout.setHorizontalGroup(
            ind_5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 3, Short.MAX_VALUE)
        );
        ind_5Layout.setVerticalGroup(
            ind_5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 60, Short.MAX_VALUE)
        );

        lbHoaDon.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        lbHoaDon.setForeground(new java.awt.Color(240, 240, 240));
        lbHoaDon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/icons8_bill_30px.png"))); // NOI18N
        lbHoaDon.setText("Hóa đơn");

        javax.swing.GroupLayout pnHoaDonLayout = new javax.swing.GroupLayout(pnHoaDon);
        pnHoaDon.setLayout(pnHoaDonLayout);
        pnHoaDonLayout.setHorizontalGroup(
            pnHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnHoaDonLayout.createSequentialGroup()
                .addComponent(ind_5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(lbHoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        pnHoaDonLayout.setVerticalGroup(
            pnHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(ind_5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnHoaDonLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbHoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
        );

        pnThongKe.setBackground(new java.awt.Color(23, 35, 55));
        pnThongKe.setPreferredSize(new java.awt.Dimension(180, 40));
        pnThongKe.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                pnThongKeMousePressed(evt);
            }
        });

        ind_6.setOpaque(false);
        ind_6.setPreferredSize(new java.awt.Dimension(3, 60));

        javax.swing.GroupLayout ind_6Layout = new javax.swing.GroupLayout(ind_6);
        ind_6.setLayout(ind_6Layout);
        ind_6Layout.setHorizontalGroup(
            ind_6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 3, Short.MAX_VALUE)
        );
        ind_6Layout.setVerticalGroup(
            ind_6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 60, Short.MAX_VALUE)
        );

        lbThongKe.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        lbThongKe.setForeground(new java.awt.Color(240, 240, 240));
        lbThongKe.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/icons8_pie_chart_30px.png"))); // NOI18N
        lbThongKe.setText("Thống kê");

        javax.swing.GroupLayout pnThongKeLayout = new javax.swing.GroupLayout(pnThongKe);
        pnThongKe.setLayout(pnThongKeLayout);
        pnThongKeLayout.setHorizontalGroup(
            pnThongKeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnThongKeLayout.createSequentialGroup()
                .addComponent(ind_6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(lbThongKe, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        pnThongKeLayout.setVerticalGroup(
            pnThongKeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(ind_6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnThongKeLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbThongKe, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19))
        );

        pnTaiKhoan.setBackground(new java.awt.Color(23, 35, 55));
        pnTaiKhoan.setPreferredSize(new java.awt.Dimension(180, 40));
        pnTaiKhoan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                pnTaiKhoanMousePressed(evt);
            }
        });

        ind_7.setOpaque(false);
        ind_7.setPreferredSize(new java.awt.Dimension(3, 60));

        javax.swing.GroupLayout ind_7Layout = new javax.swing.GroupLayout(ind_7);
        ind_7.setLayout(ind_7Layout);
        ind_7Layout.setHorizontalGroup(
            ind_7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 3, Short.MAX_VALUE)
        );
        ind_7Layout.setVerticalGroup(
            ind_7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 60, Short.MAX_VALUE)
        );

        lbTaiKhoan.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        lbTaiKhoan.setForeground(new java.awt.Color(240, 240, 240));
        lbTaiKhoan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/icons8_customer_30px.png"))); // NOI18N
        lbTaiKhoan.setText("Tài khoản");

        javax.swing.GroupLayout pnTaiKhoanLayout = new javax.swing.GroupLayout(pnTaiKhoan);
        pnTaiKhoan.setLayout(pnTaiKhoanLayout);
        pnTaiKhoanLayout.setHorizontalGroup(
            pnTaiKhoanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnTaiKhoanLayout.createSequentialGroup()
                .addComponent(ind_7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(lbTaiKhoan, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        pnTaiKhoanLayout.setVerticalGroup(
            pnTaiKhoanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(ind_7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(pnTaiKhoanLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(lbTaiKhoan, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout side_panelLayout = new javax.swing.GroupLayout(side_panel);
        side_panel.setLayout(side_panelLayout);
        side_panelLayout.setHorizontalGroup(
            side_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnSach, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(pnBanHang, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(pnThongKe, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(pnHoaDon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(side_panelLayout.createSequentialGroup()
                .addGroup(side_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(pnTrangChu, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(pnTaiKhoan, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pnKhachHang, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 179, Short.MAX_VALUE))
                .addGap(0, 1, Short.MAX_VALUE))
        );
        side_panelLayout.setVerticalGroup(
            side_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(side_panelLayout.createSequentialGroup()
                .addGap(84, 84, 84)
                .addComponent(pnTrangChu, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnKhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(pnSach, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(pnBanHang, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(pnHoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(pnThongKe, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(pnTaiKhoan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(55, Short.MAX_VALUE))
        );

        getContentPane().add(side_panel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -20, 180, 490));

        javax.swing.GroupLayout pnViewLayout = new javax.swing.GroupLayout(pnView);
        pnView.setLayout(pnViewLayout);
        pnViewLayout.setHorizontalGroup(
            pnViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 670, Short.MAX_VALUE)
        );
        pnViewLayout.setVerticalGroup(
            pnViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 410, Short.MAX_VALUE)
        );

        getContentPane().add(pnView, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 50, 670, 410));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void pnTrangChuMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnTrangChuMousePressed
        // TODO add your handling code here:
        setColor(pnTrangChu);
        ind_1.setOpaque(true);
        resetColor(new JPanel[]{pnKhachHang, pnSach, pnBanHang, pnHoaDon, pnThongKe, pnTaiKhoan}, new JPanel []{ind_2,ind_3,ind_4,ind_5,ind_6,ind_7});
    }//GEN-LAST:event_pnTrangChuMousePressed

    private void pnKhachHangMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnKhachHangMousePressed
        // TODO add your handling code here:
        setColor(pnKhachHang);
        ind_2.setOpaque(true);
        resetColor(new JPanel[]{pnTrangChu, pnSach, pnBanHang, pnHoaDon, pnThongKe, pnTaiKhoan}, new JPanel []{ind_1,ind_3,ind_4,ind_5,ind_6,ind_7});
    }//GEN-LAST:event_pnKhachHangMousePressed

    private void pnSachMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnSachMousePressed
        // TODO add your handling code here:
        setColor(pnSach);
        ind_3.setOpaque(true);
        resetColor(new JPanel[]{pnTrangChu, pnKhachHang, pnBanHang, pnHoaDon, pnThongKe, pnTaiKhoan}, new JPanel []{ind_1,ind_2,ind_4,ind_5,ind_6,ind_7});     
    }//GEN-LAST:event_pnSachMousePressed

    private void pnBanHangMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnBanHangMousePressed
        setColor(pnBanHang);
        ind_4.setOpaque(true);
        resetColor(new JPanel[]{pnTrangChu, pnSach, pnKhachHang, pnHoaDon, pnThongKe, pnTaiKhoan}, new JPanel []{ind_1,ind_3,ind_2,ind_5,ind_6,ind_7});
        // TODO add your handling code here:
    }//GEN-LAST:event_pnBanHangMousePressed

    private void pnHoaDonMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnHoaDonMousePressed
        setColor(pnHoaDon);
        ind_5.setOpaque(true);
        resetColor(new JPanel[]{pnTrangChu, pnSach, pnBanHang, pnKhachHang, pnThongKe, pnTaiKhoan}, new JPanel []{ind_1,ind_3,ind_4,ind_2,ind_6,ind_7});
        // TODO add your handling code here:
    }//GEN-LAST:event_pnHoaDonMousePressed

    private void pnThongKeMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnThongKeMousePressed
        setColor(pnThongKe);
        ind_6.setOpaque(true);
        resetColor(new JPanel[]{pnTrangChu, pnSach, pnBanHang, pnHoaDon, pnKhachHang, pnTaiKhoan}, new JPanel []{ind_1,ind_3,ind_4,ind_5,ind_2,ind_7});
        // TODO add your handling code here:
    }//GEN-LAST:event_pnThongKeMousePressed

    private void pnTaiKhoanMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnTaiKhoanMousePressed
        setColor(pnTaiKhoan);
        ind_7.setOpaque(true);
        resetColor(new JPanel[]{pnTrangChu, pnSach, pnBanHang, pnHoaDon, pnThongKe, pnKhachHang}, new JPanel []{ind_1,ind_3,ind_4,ind_5,ind_6,ind_2});
        // TODO add your handling code here:
    }//GEN-LAST:event_pnTaiKhoanMousePressed

   
    
    private void setColor(JPanel pane) {
        pane.setBackground(new Color(39,57,82));
    }
        
    private void resetColor(JPanel [] pane, JPanel [] indicators) {
        for (int i=0; i < pane.length; i++) {
            pane[i].setBackground(new Color(23,35,55));
        }
        
        for (int i=0; i < indicators.length; i++) {
            indicators[i].setOpaque(false);
        }
    }
    
    private void setColor(JLabel labe) {
        labe.setOpaque(true);
    }
    
    private void resetColor(JLabel labe) {
        labe.setOpaque(false);
    }
    /**
     * @param args the command line arguments
     */
        
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JPanel head_panel;
    private javax.swing.JPanel ind_1;
    private javax.swing.JPanel ind_2;
    private javax.swing.JPanel ind_3;
    private javax.swing.JPanel ind_4;
    private javax.swing.JPanel ind_5;
    private javax.swing.JPanel ind_6;
    private javax.swing.JPanel ind_7;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLayeredPane jLayeredPane1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel lbBanHang;
    private javax.swing.JLabel lbHoaDon;
    private javax.swing.JLabel lbKhachHang;
    private javax.swing.JLabel lbSach;
    private javax.swing.JLabel lbTaiKhoan;
    private javax.swing.JLabel lbThongKe;
    private javax.swing.JLabel lbTrangChu;
    private javax.swing.JPanel pnBanHang;
    private javax.swing.JPanel pnHoaDon;
    private javax.swing.JPanel pnKhachHang;
    private javax.swing.JPanel pnSach;
    private javax.swing.JPanel pnTaiKhoan;
    private javax.swing.JPanel pnThongKe;
    private javax.swing.JPanel pnTrangChu;
    private javax.swing.JPanel pnView;
    private javax.swing.JPanel side_panel;
    // End of variables declaration//GEN-END:variables
}
