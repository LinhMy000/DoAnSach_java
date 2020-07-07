
package View;
import Controller.ControllerMenu;
import Model.ModelMenu;
import java.util.ArrayList;
import java.util.List;

public class ViewMain extends javax.swing.JFrame {

    public ViewMain(boolean quyen) {
        initComponents();
        setVisible(true);
        if(!quyen)
            initMenu();
        else
            initMenuAdmin();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        kkk = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        pnTrangChu = new javax.swing.JLabel();
        pnKhachHang = new javax.swing.JLabel();
        pnSach = new javax.swing.JLabel();
        pnHoaDon = new javax.swing.JLabel();
        pnBanHang = new javax.swing.JLabel();
        pnThongKe = new javax.swing.JLabel();
        pnTaiKhoan = new javax.swing.JLabel();
        pnView = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setBackground(new java.awt.Color(23, 35, 55));

        jLabel1.setBackground(new java.awt.Color(23, 35, 55));
        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 0, 0));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("CỬA HÀNG SÁCH");
        jLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 943, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(23, 35, 55));

        pnTrangChu.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        pnTrangChu.setForeground(new java.awt.Color(255, 255, 255));
        pnTrangChu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/icons8_home_30px.png"))); // NOI18N
        pnTrangChu.setText("Trang Chủ");

        pnKhachHang.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        pnKhachHang.setForeground(new java.awt.Color(255, 255, 255));
        pnKhachHang.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/icons8_business_group_30px.png"))); // NOI18N
        pnKhachHang.setText("Khách Hàng");

        pnSach.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        pnSach.setForeground(new java.awt.Color(255, 255, 255));
        pnSach.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        pnSach.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/icons8_open_book_30px.png"))); // NOI18N
        pnSach.setText("Kho Sách");

        pnHoaDon.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        pnHoaDon.setForeground(new java.awt.Color(255, 255, 255));
        pnHoaDon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/icons8_bill_30px.png"))); // NOI18N
        pnHoaDon.setText("Hóa Đơn");

        pnBanHang.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        pnBanHang.setForeground(new java.awt.Color(255, 255, 255));
        pnBanHang.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/icons8_shopping_cart_30px.png"))); // NOI18N
        pnBanHang.setText("Bán Sách");

        pnThongKe.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        pnThongKe.setForeground(new java.awt.Color(255, 255, 255));
        pnThongKe.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/icons8_pie_chart_30px.png"))); // NOI18N
        pnThongKe.setText("Thống Kê");

        pnTaiKhoan.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        pnTaiKhoan.setForeground(new java.awt.Color(255, 255, 255));
        pnTaiKhoan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/icons8_customer_30px.png"))); // NOI18N
        pnTaiKhoan.setText("Tài Khoản");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnKhachHang, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnBanHang, javax.swing.GroupLayout.DEFAULT_SIZE, 210, Short.MAX_VALUE)
                    .addComponent(pnTaiKhoan, javax.swing.GroupLayout.DEFAULT_SIZE, 210, Short.MAX_VALUE)
                    .addComponent(pnThongKe, javax.swing.GroupLayout.DEFAULT_SIZE, 210, Short.MAX_VALUE)
                    .addComponent(pnTrangChu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnSach, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnHoaDon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(pnTrangChu, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(pnKhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(pnSach, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(pnHoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(pnBanHang, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(pnThongKe, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(pnTaiKhoan, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(23, Short.MAX_VALUE))
        );

        pnView.setBackground(new java.awt.Color(102, 102, 102));
        pnView.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/sach3.jpg"))); // NOI18N

        javax.swing.GroupLayout pnViewLayout = new javax.swing.GroupLayout(pnView);
        pnView.setLayout(pnViewLayout);
        pnViewLayout.setHorizontalGroup(
            pnViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
        );
        pnViewLayout.setVerticalGroup(
            pnViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout kkkLayout = new javax.swing.GroupLayout(kkk);
        kkk.setLayout(kkkLayout);
        kkkLayout.setHorizontalGroup(
            kkkLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(kkkLayout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnView, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        kkkLayout.setVerticalGroup(
            kkkLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kkkLayout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(kkkLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnView, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(kkk, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(kkk, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public void initMenu() {
	List<ModelMenu> listDanhMuc = new ArrayList<>();
        listDanhMuc.add(new ModelMenu("Trang chu", pnTrangChu));
        listDanhMuc.add(new ModelMenu("Khach hang", pnKhachHang));
        listDanhMuc.add(new ModelMenu("Sach", pnSach));
        listDanhMuc.add(new ModelMenu("Ban hang", pnBanHang));
        listDanhMuc.add(new ModelMenu("Hoa don", pnHoaDon));
        listDanhMuc.add(new ModelMenu("Thong ke du lieu", pnThongKe));
        ControllerMenu controller = new ControllerMenu(pnView);
        controller.setView(pnTrangChu);
        controller.setEvent(listDanhMuc);
	}
    public void initMenuAdmin() {
            ControllerMenu controller = new ControllerMenu(pnView);
            controller.setView(pnTrangChu);
		
            List<ModelMenu> listDanhMuc = new ArrayList<>();
            listDanhMuc.add(new ModelMenu("Trang chu", pnTrangChu));
            listDanhMuc.add(new ModelMenu("Khach hang", pnKhachHang));
            listDanhMuc.add(new ModelMenu("Sach", pnSach));
            listDanhMuc.add(new ModelMenu("Ban hang", pnBanHang));
            listDanhMuc.add(new ModelMenu("Hoa don", pnHoaDon));
            listDanhMuc.add(new ModelMenu("Thong ke du lieu", pnThongKe));
            listDanhMuc.add(new ModelMenu("User", pnTaiKhoan));
            controller.setEventAdmin(listDanhMuc);
	}

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel kkk;
    private javax.swing.JLabel pnBanHang;
    private javax.swing.JLabel pnHoaDon;
    private javax.swing.JLabel pnKhachHang;
    private javax.swing.JLabel pnSach;
    private javax.swing.JLabel pnTaiKhoan;
    private javax.swing.JLabel pnThongKe;
    private javax.swing.JLabel pnTrangChu;
    private javax.swing.JPanel pnView;
    // End of variables declaration//GEN-END:variables
}
