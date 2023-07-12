/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Views;

import DomainModels.NhanVien;
import Utilities.JDBC_helper;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author TBC
 */
public class QuanLyFrame extends javax.swing.JFrame {

    private NhanVien nhanVien;

    public QuanLyFrame() {
        initComponents();
        this.setLocationRelativeTo(null);

        nhanVien = new NhanVien();
        if (JDBC_helper.nhanVienDN != null) {
            nhanVien = JDBC_helper.nhanVienDN;
        }
        
        loadNguoiDung(nhanVien);
        
        pnlCards.removeAll();
        pnlCards.add(new BanHangForm());
        pnlCards.repaint();
        pnlCards.revalidate();
    }
    
    private void loadNguoiDung(NhanVien nv){
        lblTenNhanVien.setText(nv.getTen());
        setAnh(nv.getAnhDaiDien());
    }
    
    private void setAnh(String d) {
        lblAnhNhanVien.setText("");

        ImageIcon image1 = new ImageIcon(d);
        Image im = image1.getImage();
        ImageIcon icon = new ImageIcon(im.getScaledInstance(
                lblAnhNhanVien.getWidth(), lblAnhNhanVien.getHeight(), im.SCALE_SMOOTH));

        lblAnhNhanVien.setIcon(icon);
    }

//    public QuanLyFrame(NhanVien nv) {
////        initComponents();
////        this.setLocationRelativeTo(null);
////
////        nhanVien = nv;
////
////        pnlCards.removeAll();
////        pnlCards.add(new BanHangForm());
////        pnlCards.repaint();
////        pnlCards.revalidate();
//    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        lblAnhNhanVien = new javax.swing.JLabel();
        lblTenNhanVien = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jButton2 = new javax.swing.JButton();
        btnHoaDon = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        btnThongKe = new javax.swing.JButton();
        btnQLSanPham = new javax.swing.JButton();
        btnQLNhanVien = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jButton5 = new javax.swing.JButton();
        pnlCards = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setBackground(new java.awt.Color(255, 204, 255));

        lblAnhNhanVien.setText("ảnh");

        lblTenNhanVien.setText(": ");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblAnhNhanVien, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTenNhanVien, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(lblAnhNhanVien, javax.swing.GroupLayout.DEFAULT_SIZE, 76, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblTenNhanVien)
                .addContainerGap())
        );

        jPanel3.setLayout(new java.awt.GridLayout(7, 1, 1, 1));

        jButton2.setText("Bán Hàng");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton2);

        btnHoaDon.setText("Hóa Đơn");
        btnHoaDon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHoaDonActionPerformed(evt);
            }
        });
        jPanel3.add(btnHoaDon);

        jButton4.setText("Khách Hàng");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton4);

        btnThongKe.setText("Thống kê");
        btnThongKe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThongKeActionPerformed(evt);
            }
        });
        jPanel3.add(btnThongKe);

        btnQLSanPham.setText("San Pham");
        btnQLSanPham.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnQLSanPhamActionPerformed(evt);
            }
        });
        jPanel3.add(btnQLSanPham);

        btnQLNhanVien.setText("NhanVien");
        btnQLNhanVien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnQLNhanVienActionPerformed(evt);
            }
        });
        jPanel3.add(btnQLNhanVien);

        jButton5.setText("Đăng xuất");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButton5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 349, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(25, Short.MAX_VALUE))
        );

        pnlCards.setBackground(new java.awt.Color(0, 153, 0));
        pnlCards.setLayout(new java.awt.CardLayout());

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(pnlCards, javax.swing.GroupLayout.DEFAULT_SIZE, 934, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(pnlCards, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnThongKeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThongKeActionPerformed

        if (nhanVien.getMa() != null) {
            if (nhanVien.getIdChucVu().getVaiTro() != 1) {
                JOptionPane.showMessageDialog(this, "Đăng nhập với quyền quản lý để truy cập");
                return;
            }
        }
        pnlCards.removeAll();
        pnlCards.add(new ThongKe());
//        pnlCards.repaint();
        pnlCards.revalidate();
    }//GEN-LAST:event_btnThongKeActionPerformed

    private void btnQLNhanVienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnQLNhanVienActionPerformed

        if (nhanVien.getMa() != null) {
            if (nhanVien.getIdChucVu().getVaiTro() != 1) {
                JOptionPane.showMessageDialog(this, "Đăng nhập với quyền quản lý để truy cập");
                return;
            }
        }
        pnlCards.removeAll();
        pnlCards.add(new NhanVienForm());
        pnlCards.repaint();
        pnlCards.revalidate();
    }//GEN-LAST:event_btnQLNhanVienActionPerformed

    private void btnQLSanPhamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnQLSanPhamActionPerformed
        pnlCards.removeAll();
        pnlCards.add(new ChiTietSanPhamForm());
        pnlCards.repaint();
        pnlCards.revalidate();
    }//GEN-LAST:event_btnQLSanPhamActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        pnlCards.removeAll();
        pnlCards.add(new BanHangForm());
        pnlCards.repaint();
        pnlCards.revalidate();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        pnlCards.removeAll();
        pnlCards.add(new KhachHangForm());
        pnlCards.repaint();
        pnlCards.revalidate();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void btnHoaDonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHoaDonActionPerformed
        // TODO add your handling code here:
        if (nhanVien.getMa() != null) {
//            System.out.println(nhanVien.getMa());
//            System.out.println(nhanVien.getIdChucVu().getMa());
//            System.out.println(nhanVien.getIdChucVu().getTen());
//            System.out.println(nhanVien.getIdChucVu().getVaiTro());
//            System.out.println(nhanVien.getTen());
            if (nhanVien.getIdChucVu().getVaiTro() != 1) {
                JOptionPane.showMessageDialog(this, "Đăng nhập với quyền quản lý để truy cập");
                return;
            }
        }

        pnlCards.removeAll();
        pnlCards.add(new HoaDonFrame());
        pnlCards.repaint();
        pnlCards.revalidate();
    }//GEN-LAST:event_btnHoaDonActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_jButton5ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(QuanLyFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(QuanLyFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(QuanLyFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(QuanLyFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new QuanLyFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnHoaDon;
    private javax.swing.JButton btnQLNhanVien;
    private javax.swing.JButton btnQLSanPham;
    private javax.swing.JButton btnThongKe;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lblAnhNhanVien;
    private javax.swing.JLabel lblTenNhanVien;
    private javax.swing.JPanel pnlCards;
    // End of variables declaration//GEN-END:variables
}
