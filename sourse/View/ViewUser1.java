/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

/**
 *
 * @author AD
 */
public class ViewUser1 extends javax.swing.JPanel {

    /**
     * Creates new form ViewUser1
     */
    public ViewUser1() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnTable = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        cbTT = new javax.swing.JCheckBox();
        cbQ = new javax.swing.JCheckBox();
        txtHT = new javax.swing.JTextField();
        txtMK = new javax.swing.JTextField();
        txtTK = new javax.swing.JTextField();
        lbQ = new javax.swing.JLabel();
        lbTT = new javax.swing.JLabel();
        lbHT = new javax.swing.JLabel();
        lbMK = new javax.swing.JLabel();
        lbTK = new javax.swing.JLabel();
        txtSearch = new javax.swing.JTextField();
        lbIconSearch = new javax.swing.JLabel();
        lbTB = new javax.swing.JLabel();
        btDelete = new javax.swing.JButton();
        btAdd = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));
        setMinimumSize(new java.awt.Dimension(670, 420));
        setPreferredSize(new java.awt.Dimension(670, 420));

        javax.swing.GroupLayout pnTableLayout = new javax.swing.GroupLayout(pnTable);
        pnTable.setLayout(pnTableLayout);
        pnTableLayout.setHorizontalGroup(
            pnTableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        pnTableLayout.setVerticalGroup(
            pnTableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 156, Short.MAX_VALUE)
        );

        jPanel1.setBackground(new java.awt.Color(245, 247, 253));

        cbTT.setBackground(new java.awt.Color(245, 247, 253));
        cbTT.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cbTT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbTTActionPerformed(evt);
            }
        });

        cbQ.setBackground(new java.awt.Color(245, 247, 253));
        cbQ.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cbQ.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbQActionPerformed(evt);
            }
        });

        txtHT.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtHT.setMaximumSize(new java.awt.Dimension(50, 20));
        txtHT.setMinimumSize(new java.awt.Dimension(50, 20));
        txtHT.setPreferredSize(new java.awt.Dimension(50, 23));

        txtMK.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtMK.setMaximumSize(new java.awt.Dimension(50, 20));
        txtMK.setMinimumSize(new java.awt.Dimension(50, 20));
        txtMK.setPreferredSize(new java.awt.Dimension(50, 23));

        txtTK.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtTK.setMaximumSize(new java.awt.Dimension(50, 20));
        txtTK.setMinimumSize(new java.awt.Dimension(50, 20));
        txtTK.setPreferredSize(new java.awt.Dimension(50, 23));

        lbQ.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbQ.setText("Quyền");
        lbQ.setMinimumSize(new java.awt.Dimension(43, 20));
        lbQ.setPreferredSize(new java.awt.Dimension(43, 20));

        lbTT.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbTT.setText("Tình Trạng");
        lbTT.setMinimumSize(new java.awt.Dimension(43, 20));
        lbTT.setPreferredSize(new java.awt.Dimension(43, 20));

        lbHT.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbHT.setText("Họ tên");
        lbHT.setMinimumSize(new java.awt.Dimension(43, 20));
        lbHT.setPreferredSize(new java.awt.Dimension(43, 20));

        lbMK.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbMK.setText("Mật Khẩu");
        lbMK.setMinimumSize(new java.awt.Dimension(43, 20));
        lbMK.setPreferredSize(new java.awt.Dimension(43, 20));

        lbTK.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbTK.setText("Tài Khoản");
        lbTK.setMinimumSize(new java.awt.Dimension(43, 20));
        lbTK.setPreferredSize(new java.awt.Dimension(43, 20));

        txtSearch.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        lbIconSearch.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/icons8_search_20px_2.png"))); // NOI18N

        lbTB.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N
        lbTB.setForeground(new java.awt.Color(255, 0, 0));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lbTK, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lbMK, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lbTT, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lbHT, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(10, 10, 10)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(txtTK, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtMK, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtHT, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lbQ, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(cbTT, javax.swing.GroupLayout.DEFAULT_SIZE, 197, Short.MAX_VALUE)
                            .addComponent(cbQ, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lbIconSearch)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(lbTB, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(103, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbTK, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtTK, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lbIconSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(15, 15, 15)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbMK, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtMK, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbHT, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtHT, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lbTT, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbTT, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lbTB, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lbQ, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbQ, javax.swing.GroupLayout.DEFAULT_SIZE, 23, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btDelete.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btDelete.setText("Xóa");
        btDelete.setMaximumSize(new java.awt.Dimension(67, 25));
        btDelete.setMinimumSize(new java.awt.Dimension(67, 25));
        btDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btDeleteActionPerformed(evt);
            }
        });

        btAdd.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btAdd.setText("Thêm");
        btAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAddActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btAdd)
                .addGap(249, 249, 249))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnTable, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btDelete, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btAdd))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(pnTable, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void cbQActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbQActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbQActionPerformed

    private void cbTTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbTTActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbTTActionPerformed

    private void btDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btDeleteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btDeleteActionPerformed

    private void btAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAddActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btAddActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btAdd;
    private javax.swing.JButton btDelete;
    private javax.swing.JCheckBox cbQ;
    private javax.swing.JCheckBox cbTT;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lbHT;
    private javax.swing.JLabel lbIconSearch;
    private javax.swing.JLabel lbMK;
    private javax.swing.JLabel lbQ;
    private javax.swing.JLabel lbTB;
    private javax.swing.JLabel lbTK;
    private javax.swing.JLabel lbTT;
    private javax.swing.JPanel pnTable;
    private javax.swing.JTextField txtHT;
    private javax.swing.JTextField txtMK;
    private javax.swing.JTextField txtSearch;
    private javax.swing.JTextField txtTK;
    // End of variables declaration//GEN-END:variables
}
