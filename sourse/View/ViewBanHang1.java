package View;


import com.toedter.calendar.JDateChooser;
import Table.KhachHang;
import Table.User;
public class ViewBanHang1 extends javax.swing.JPanel {

    
    public ViewBanHang1() {
        initComponents();
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnUp = new javax.swing.JPanel();
        pnSP = new javax.swing.JPanel();
        tfSearch = new javax.swing.JTextField();
        pnDown = new javax.swing.JPanel();
        pnHD = new javax.swing.JPanel();
        btDelete = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        lbMaHD = new javax.swing.JLabel();
        lbKH = new javax.swing.JLabel();
        lbNV = new javax.swing.JLabel();
        lbNgayHD = new javax.swing.JLabel();
        lbTT = new javax.swing.JLabel();
        tfMaHD = new javax.swing.JTextField();
        tfTT = new javax.swing.JTextField();
        cbKH = new javax.swing.JComboBox<KhachHang>();
        cbNV = new javax.swing.JComboBox<User>();
        btSaved = new javax.swing.JButton();
        btOutput = new javax.swing.JButton();
        lbTB = new javax.swing.JLabel();
        jdcNgayHD = new com.toedter.calendar.JDateChooser();

        setPreferredSize(new java.awt.Dimension(710, 410));

        pnUp.setBackground(new java.awt.Color(255, 255, 255));
        pnUp.setPreferredSize(new java.awt.Dimension(360, 200));

        javax.swing.GroupLayout pnSPLayout = new javax.swing.GroupLayout(pnSP);
        pnSP.setLayout(pnSPLayout);
        pnSPLayout.setHorizontalGroup(
            pnSPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        pnSPLayout.setVerticalGroup(
            pnSPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 139, Short.MAX_VALUE)
        );

        tfSearch.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        javax.swing.GroupLayout pnUpLayout = new javax.swing.GroupLayout(pnUp);
        pnUp.setLayout(pnUpLayout);
        pnUpLayout.setHorizontalGroup(
            pnUpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnUpLayout.createSequentialGroup()
                .addGroup(pnUpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnUpLayout.createSequentialGroup()
                        .addContainerGap(200, Short.MAX_VALUE)
                        .addComponent(tfSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnUpLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(pnSP, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        pnUpLayout.setVerticalGroup(
            pnUpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnUpLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tfSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15)
                .addComponent(pnSP, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(15, 15, 15))
        );

        pnDown.setBackground(new java.awt.Color(255, 255, 255));
        pnDown.setPreferredSize(new java.awt.Dimension(360, 200));

        javax.swing.GroupLayout pnHDLayout = new javax.swing.GroupLayout(pnHD);
        pnHD.setLayout(pnHDLayout);
        pnHDLayout.setHorizontalGroup(
            pnHDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        pnHDLayout.setVerticalGroup(
            pnHDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        btDelete.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btDelete.setText("Xóa");

        javax.swing.GroupLayout pnDownLayout = new javax.swing.GroupLayout(pnDown);
        pnDown.setLayout(pnDownLayout);
        pnDownLayout.setHorizontalGroup(
            pnDownLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnDownLayout.createSequentialGroup()
                .addGroup(pnDownLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnDownLayout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btDelete))
                    .addGroup(pnDownLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(pnHD, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        pnDownLayout.setVerticalGroup(
            pnDownLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnDownLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(pnHD, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(15, 15, 15)
                .addComponent(btDelete)
                .addContainerGap())
        );

        jPanel3.setBackground(new java.awt.Color(245, 247, 253));

        lbMaHD.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbMaHD.setText("Mã Hóa Đơn");

        lbKH.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbKH.setText("Khách Hàng");

        lbNV.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbNV.setText("Nhân Viên");

        lbNgayHD.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbNgayHD.setText("Ngày Lập");

        lbTT.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbTT.setText("Tổng Tiền");

        tfMaHD.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tfMaHD.setEnabled(false);

        tfTT.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tfTT.setEnabled(false);

        cbKH.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cbKH.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "null" }));

        cbNV.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cbNV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbNVActionPerformed(evt);
            }
        });

        btSaved.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btSaved.setText("Lưu");

        btOutput.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btOutput.setText("Xuất Hóa Đơn");

        lbTB.setFont(new java.awt.Font("Tahoma", 3, 12)); // NOI18N
        lbTB.setForeground(new java.awt.Color(255, 0, 0));
        lbTB.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        jdcNgayHD.setDateFormatString("yyyy MM dd\n");
        jdcNgayHD.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap(20, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbMaHD, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbNV, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbNgayHD, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbTT, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbKH, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(25, 25, 25)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(tfMaHD)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(1, 1, 1)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(tfTT)
                                    .addComponent(cbKH, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(cbNV, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jdcNgayHD, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addComponent(lbTB, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(btSaved, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(99, 99, 99)
                        .addComponent(btOutput)))
                .addGap(20, 20, 20))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbMaHD, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tfMaHD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(20, 20, 20)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbKH, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbKH, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(20, 20, 20)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbNV, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbNV, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(20, 20, 20)
                        .addComponent(lbNgayHD, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jdcNgayHD, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbTT, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfTT, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(lbTB, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btSaved, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btOutput, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(80, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(pnDown, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnUp, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, 0)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pnUp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnDown, javax.swing.GroupLayout.DEFAULT_SIZE, 204, Short.MAX_VALUE))
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void cbNVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbNVActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbNVActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btDelete;
    private javax.swing.JButton btOutput;
    private javax.swing.JButton btSaved;
    private javax.swing.JComboBox<String> cbKH;
    private javax.swing.JComboBox<String> cbNV;
    private javax.swing.JPanel jPanel3;
    private com.toedter.calendar.JDateChooser jdcNgayHD;
    private javax.swing.JLabel lbKH;
    private javax.swing.JLabel lbMaHD;
    private javax.swing.JLabel lbNV;
    private javax.swing.JLabel lbNgayHD;
    private javax.swing.JLabel lbTB;
    private javax.swing.JLabel lbTT;
    private javax.swing.JPanel pnDown;
    private javax.swing.JPanel pnHD;
    private javax.swing.JPanel pnSP;
    private javax.swing.JPanel pnUp;
    private javax.swing.JTextField tfMaHD;
    private javax.swing.JTextField tfSearch;
    private javax.swing.JTextField tfTT;
    // End of variables declaration//GEN-END:variables
}
