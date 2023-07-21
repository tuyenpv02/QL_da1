/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Views;

import DomainModels.ChucVu;
import DomainModels.NhanVien;
import Services.ChucVuServices;
import Services.NhanVienServices;
import Services.impl.ChucVuServicesImpl;
import Services.impl.NhanVienServicesImpl;
import ViewModels.NhanVienViewModels;
import java.awt.Image;
import java.io.File;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author TBC
 */
public class NhanVienForm extends javax.swing.JPanel {

    DefaultTableModel dtm;
    String duongDan = "";

    NhanVienServices nhanVienServices = new NhanVienServicesImpl();
    ChucVuServices chucVuServices = new ChucVuServicesImpl();

    ArrayList<NhanVienViewModels> lstNhanVien;
    ArrayList<ChucVu> lstChucVu;

    public NhanVienForm() {
        initComponents();

        lstNhanVien = nhanVienServices.getALL();

        loadCBB();
        loadSP(lstNhanVien);

        rdoDangLam.setSelected(true);
        rdoNam.setSelected(true);
    }

    public NhanVien getForm() {
        String ma = txtMa.getText().trim();
        String ten = txtTen.getText().trim();
        String diaChi = txtDiaChi.getText().trim();
        String sdt = txtSdt.getText().trim();
        String matKhau = txtMatKhau.getText().trim();
        String email = txtEmail.getText().trim();

        if (ma.length() == 0 || ten.length() == 0 || matKhau.length() == 0) {
            JOptionPane.showMessageDialog(this, "nhập lại");
            return null;
        }

//        if (date_ngaySinh.isValid()) {
//            JOptionPane.showMessageDialog(this, "sai ngày");
//            return null;
//        }
        int gioiTinh = rdoNam.isSelected() ? 1 : 0;
        int trangThai = rdoDangLam.isSelected() ? 1 : 0;
        String hinh = duongDan;
        ChucVu chucVu = lstChucVu.get(cbbChucVu.getSelectedIndex());

        NhanVien nv = new NhanVien();
        if (date_ngaySinh.getDate() == null) {

        } else {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            String ngaySinh = sdf.format(date_ngaySinh.getDate());
            Date n = Date.valueOf(ngaySinh);
            nv.setNgaySinh(n);
        }

        nv.setMa(ma);
        nv.setTen(ten);
        nv.setGioiTinh(gioiTinh);
        nv.setEmail(email);
        nv.setSdt(sdt);
        nv.setDiaChi(diaChi);
        nv.setMatKhau(matKhau);
        nv.setAnhDaiDien(hinh);
        nv.setIdChucVu(chucVu);
        nv.setTrangThai(trangThai);
        return nv;
    }

    private void loadCBB() {
        lstChucVu = chucVuServices.getALl();
        cbbChucVu.removeAllItems();
        for (ChucVu c : lstChucVu) {
            cbbChucVu.addItem(c.getTen());
        }
    }

    private void loadSP(ArrayList<NhanVienViewModels> ds) {
        dtm = (DefaultTableModel) tblNhanVien.getModel();
        dtm.setRowCount(0);
        for (NhanVienViewModels c : ds) {
            dtm.addRow(new Object[]{
                c.getMa(),
                c.getTen(),
                c.getGioiTinh() == 1 ? "Nam" : "nữ",
                c.getSdt(),
                c.getNgaySinh(),
                c.getDiaChi(),
                c.getEmail(),
                c.getMatKhau(),
                c.getAnhDaiDien(),
                c.getChucVu(),
                c.getTrangThai() == 0 ? "ngưng làm" : "đang làm"
            });
        }
    }

    private void setAnh(String d) {
        lblAnh.setText("");

        ImageIcon image1 = new ImageIcon(d);
        Image im = image1.getImage();
        ImageIcon icon = new ImageIcon(im.getScaledInstance(lblAnh.getWidth(), lblAnh.getHeight(), im.SCALE_SMOOTH));

        lblAnh.setIcon(icon);
    }

    private void showNhanVien(NhanVienViewModels c) {
        txtMa.setText(c.getMa());
        txtTen.setText(c.getTen());
        txtDiaChi.setText(c.getDiaChi());
        txtSdt.setText(c.getSdt());
        txtMatKhau.setText(c.getMatKhau());
        date_ngaySinh.setDate(c.getNgaySinh());
        txtEmail.setText(c.getEmail());

        if (c.getGioiTinh() == 0) {
            rdoNu.setSelected(true);
        } else {
            rdoNam.setSelected(true);
        }

        if (c.getTrangThai() == 0) {
            rdoNgungLam.setSelected(true);
        } else {
            rdoDangLam.setSelected(true);
        }

        cbbChucVu.setSelectedItem(c.getChucVu());

        String hinh = "";
        try {
            hinh = c.getAnhDaiDien();
        } catch (Exception e) {
//            e.printStackTrace();        
        }
        hinh = c.getAnhDaiDien();
        setAnh(hinh);

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblNhanVien = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        lblAnh = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtMa = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtTen = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtDiaChi = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtSdt = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtMatKhau = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        cbbChucVu = new javax.swing.JComboBox<>();
        date_ngaySinh = new com.toedter.calendar.JDateChooser();
        jLabel10 = new javax.swing.JLabel();
        rdoDangLam = new javax.swing.JRadioButton();
        rdoNgungLam = new javax.swing.JRadioButton();
        btnThem = new javax.swing.JButton();
        btnCapNhat = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        rdoNam = new javax.swing.JRadioButton();
        rdoNu = new javax.swing.JRadioButton();
        jLabel11 = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        btnThem1 = new javax.swing.JButton();
        txtTimKiem = new javax.swing.JTextField();
        btnTim = new javax.swing.JButton();

        tblNhanVien.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "mã", "tên", "giới tính", "sdt", "ngày sinh", "địa chỉ", "email", "mật khẩu", "ảnh", "chức vụ", "trạng thái"
            }
        ));
        tblNhanVien.setColumnSelectionAllowed(true);
        tblNhanVien.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblNhanVienMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblNhanVien);
        tblNhanVien.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED), "thông tin nhân viên"));

        jPanel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        lblAnh.setText("anh");
        lblAnh.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblAnhMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblAnh, javax.swing.GroupLayout.DEFAULT_SIZE, 158, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblAnh, javax.swing.GroupLayout.DEFAULT_SIZE, 103, Short.MAX_VALUE)
                .addContainerGap())
        );

        jLabel2.setText("mã");

        jLabel3.setText("tên");

        jLabel4.setText("địa chỉ");

        jLabel5.setText("sdt");

        jLabel6.setText("mật khẩu");

        jLabel7.setText("chức vụ");

        jLabel8.setText("ngày sinh");

        jLabel9.setText("giới tính");

        cbbChucVu.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        date_ngaySinh.setDateFormatString("yyyy-MM-dd");

        jLabel10.setText("trạng thái");

        buttonGroup1.add(rdoDangLam);
        rdoDangLam.setText("đang làm");

        buttonGroup1.add(rdoNgungLam);
        rdoNgungLam.setText("ngưng làm");

        btnThem.setText("Thêm");
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });

        btnCapNhat.setText("cập nhật");
        btnCapNhat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCapNhatActionPerformed(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jButton2.setText("+");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        buttonGroup2.add(rdoNam);
        rdoNam.setText("Nam");

        buttonGroup2.add(rdoNu);
        rdoNu.setText("Nữ");

        jLabel11.setText("email");

        btnThem1.setText("xóa");
        btnThem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThem1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(date_ngaySinh, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(rdoDangLam)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rdoNgungLam))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtMa, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtTen, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(rdoNam)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(rdoNu))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtDiaChi, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtSdt, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtMatKhau, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(cbbChucVu, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton2)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 41, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnThem1)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnThem)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnCapNhat)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(txtMa)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(txtTen, javax.swing.GroupLayout.DEFAULT_SIZE, 24, Short.MAX_VALUE)
                                .addGap(2, 2, 2))
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(txtDiaChi, javax.swing.GroupLayout.DEFAULT_SIZE, 27, Short.MAX_VALUE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtSdt, javax.swing.GroupLayout.Alignment.LEADING))
                        .addGap(6, 6, 6)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(txtMatKhau, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(cbbChucVu, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(txtEmail, javax.swing.GroupLayout.DEFAULT_SIZE, 27, Short.MAX_VALUE)
                                .addComponent(rdoNam, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(rdoNu, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGap(6, 6, 6)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(date_ngaySinh, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(rdoDangLam, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(rdoNgungLam, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnThem)
                            .addComponent(btnCapNhat))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnThem1)
                        .addGap(0, 6, Short.MAX_VALUE))))
        );

        txtTimKiem.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtTimKiemKeyReleased(evt);
            }
        });

        btnTim.setText("tìm");
        btnTim.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTimActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnTim, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnTim))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void lblAnhMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblAnhMouseClicked
        JFileChooser f = new JFileChooser("src\\ImgSV"); // mo hop thoai theo duong dan 
        int i = f.showOpenDialog(this); // mo hop thoai dialog

        if (i != 0) {
            JOptionPane.showMessageDialog(this, "chưa chọn ảnh");
            lblAnh.setIcon(null);
            lblAnh.setText("ảnh");
            return; // k return se ban loi
        }

        File file = f.getSelectedFile(); // tao file bang fchoose da chon o tren

        duongDan = file.getAbsolutePath(); // lay duong dan
        setAnh(duongDan);
    }//GEN-LAST:event_lblAnhMouseClicked

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        NhanVien c = getForm();
        System.out.println(c.toString());
        if (c == null) {
            return;
        }
        if (nhanVienServices.insertNhanVien(c)) {
            JOptionPane.showMessageDialog(this, "them thanh cong");
        } else {
            JOptionPane.showMessageDialog(this, "them that bai");
        }
        lstNhanVien = nhanVienServices.getALL();
        loadSP(lstNhanVien);
    }//GEN-LAST:event_btnThemActionPerformed

    private void btnCapNhatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCapNhatActionPerformed
        NhanVien c = getForm();
//        System.out.println(c.getEmail());
//        System.out.println(c.getEmail());
//        System.out.println(c.getEmail());
        if (c == null) {
            return;
        }
        if (nhanVienServices.updatetNhanVien(c)) {
            JOptionPane.showMessageDialog(this, "cap nhat thanh cong");
        } else {
            JOptionPane.showMessageDialog(this, "cap nhat that bai");
        }
        lstNhanVien = nhanVienServices.getALL();
        loadSP(lstNhanVien);
    }//GEN-LAST:event_btnCapNhatActionPerformed

    private void btnThem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThem1ActionPerformed

        String ma = txtMa.getText().trim();
        if (ma.length() == 0) {
            JOptionPane.showMessageDialog(this, "nhap ma");
        }

        int check = JOptionPane.showConfirmDialog(this, "ban chac xoa ko?", "delete", JOptionPane.OK_CANCEL_OPTION);
        if (check == JOptionPane.CANCEL_OPTION) {
            return;
        }

        if (nhanVienServices.deleteNhanVien(ma)) {
            JOptionPane.showMessageDialog(this, "xoa thanh cong");
        } else {
            JOptionPane.showMessageDialog(this, "xoa that bai");
        }
        lstNhanVien = nhanVienServices.getALL();
        loadSP(lstNhanVien);
    }//GEN-LAST:event_btnThem1ActionPerformed

    private void btnTimActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTimActionPerformed
        String txtTim = txtTimKiem.getText().trim();
        lstNhanVien = nhanVienServices.timKiem(txtTim);

        loadSP(lstNhanVien);
    }//GEN-LAST:event_btnTimActionPerformed

    private void tblNhanVienMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblNhanVienMouseClicked
        int row = tblNhanVien.getSelectedRow();

        NhanVienViewModels nhanVienReponse = lstNhanVien.get(row);
        showNhanVien(nhanVienReponse);
    }//GEN-LAST:event_tblNhanVienMouseClicked

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        ChucVuForm chucVuFrame = new ChucVuForm();
        chucVuFrame.setVisible(true);
        chucVuFrame.setLocationRelativeTo(null);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void txtTimKiemKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTimKiemKeyReleased
        String txtTim = txtTimKiem.getText().trim();
        lstNhanVien = nhanVienServices.timKiem(txtTim);

        loadSP(lstNhanVien);
    }//GEN-LAST:event_txtTimKiemKeyReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCapNhat;
    private javax.swing.JButton btnThem;
    private javax.swing.JButton btnThem1;
    private javax.swing.JButton btnTim;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JComboBox<String> cbbChucVu;
    private com.toedter.calendar.JDateChooser date_ngaySinh;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblAnh;
    private javax.swing.JRadioButton rdoDangLam;
    private javax.swing.JRadioButton rdoNam;
    private javax.swing.JRadioButton rdoNgungLam;
    private javax.swing.JRadioButton rdoNu;
    private javax.swing.JTable tblNhanVien;
    private javax.swing.JTextField txtDiaChi;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtMa;
    private javax.swing.JTextField txtMatKhau;
    private javax.swing.JTextField txtSdt;
    private javax.swing.JTextField txtTen;
    private javax.swing.JTextField txtTimKiem;
    // End of variables declaration//GEN-END:variables
}
