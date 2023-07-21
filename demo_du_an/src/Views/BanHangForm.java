/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Views;

import DomainModels.ChiTietSP;
import DomainModels.ChucVu;
import DomainModels.DanhMuc;
import DomainModels.HoaDon;
import DomainModels.HoaDonChiTiet;
import DomainModels.KhachHang;
import DomainModels.NhanVien;
import Services.CTSPServices;
import Services.DanhMucServices;
import Services.HoaDonChiTietServices;
import Services.HoaDonServices;
import Services.KhachHangServices;
import Services.impl.CTSPServicesImpl;
import Services.impl.DanhMucServicesImpl;
import Services.impl.HoaDonChiTietServicseImpl;
import Services.impl.HoaDonServicesImpl;
import Services.impl.KhachHangServicesImpl;
import Utilities.JDBC_helper;
import ViewModels.CTSPViewModels;
import ViewModels.HoaDonChiTietViewModels;
import ViewModels.HoaDonBanViewModels;
import java.io.File;
import java.io.FileOutputStream;
import java.math.BigInteger;
import java.util.ArrayList;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import org.apache.poi.xwpf.usermodel.ParagraphAlignment;
import org.apache.poi.xwpf.usermodel.TableRowAlign;
import org.apache.poi.xwpf.usermodel.TableWidthType;
import org.apache.poi.xwpf.usermodel.UnderlinePatterns;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.apache.poi.xwpf.usermodel.XWPFTable;
import org.apache.poi.xwpf.usermodel.XWPFTableCell;
import org.apache.poi.xwpf.usermodel.XWPFTableRow;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblWidth;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STTblWidth;

/**
 *
 * @author TBC
 */
public class BanHangForm extends javax.swing.JPanel {

    private NhanVien nguoiDung;

    DefaultTableModel dtm;
    CTSPServices cTSPServices = new CTSPServicesImpl();
    HoaDonServices hoaDonServices = new HoaDonServicesImpl();
    HoaDonChiTietServices hoaDonChiTietServices = new HoaDonChiTietServicseImpl();

    DanhMucServices danhMucServices = new DanhMucServicesImpl();
    KhachHangServices khachHangServices = new KhachHangServicesImpl();

    ArrayList<HoaDonBanViewModels> lstHoaDon;
    ArrayList<HoaDonChiTietViewModels> lstHoaDonChiTiet;
    ArrayList<CTSPViewModels> lstSanPham;

    ArrayList<DanhMuc> lstDanhMuc;
    ArrayList<KhachHang> lstKhachHang;

    public BanHangForm() {
        initComponents();

        nguoiDung = new NhanVien();
        if (JDBC_helper.nhanVienDN != null) {
            nguoiDung = JDBC_helper.nhanVienDN;
        }

        lstSanPham = cTSPServices.getALL();
        loadSPHD(lstSanPham); // load table sanpham
        loadCBB(); // load cbb loc san pham
        loadHoaDonByTinhTrang(0); // load table hoa don
    }

    private void taoHoaDon(String maHD, KhachHang kh,
            ArrayList<HoaDonChiTietViewModels> ds,
            String tongTien, String tienKhachDua, String tienGiam) {

        HoaDon hoaDon = hoaDonServices.getHDByMa(maHD);

        JFileChooser file = new JFileChooser("C:"); // mo hop thoai theo duong dan
        int x = file.showOpenDialog(this); // mo hop thoai dialog

        if (x != 0) {
            return; // k return se ban loi
        }

        File file1 = file.getSelectedFile(); // tao file bang fchoose da chon o tren

        if (file1.toString().lastIndexOf(".") == -1) {
            file1 = new File(file1.toString() + ".doc"); // thêm đuôi
        }

        try {
            XWPFDocument document = new XWPFDocument();
//            FileOutputStream out = new FileOutputStream(new File("c:\\Downloads\\chillyfacts.docx"));
            XWPFParagraph paragraph0 = document.createParagraph();
            XWPFRun run0 = paragraph0.createRun();
            run0.setFontSize(30);
            paragraph0.setAlignment(ParagraphAlignment.CENTER);
            run0.setText("Hóa Đơn Bán Hàng");
            run0.setBold(true);
//            run0.addBreak();

            XWPFParagraph paragraph2 = document.createParagraph();
            XWPFRun run = paragraph2.createRun();
            paragraph2.setSpacingAfter(60);

            run.setText("Khách hàng: ");
            run.setText(kh.getTen());
            run.addBreak();

            XWPFParagraph paragraph3 = document.createParagraph();
            XWPFRun run3 = paragraph3.createRun();
            paragraph3.setSpacingAfter(60);
            run3.setText("Địa chỉ: ");
            run3.setText(hoaDon.getDiaChi() + "");
            run3.setUnderline(UnderlinePatterns.WAVE);
            run3.addBreak();

            XWPFParagraph paragraph4 = document.createParagraph();
            XWPFRun run4 = paragraph4.createRun();
            paragraph4.setSpacingAfter(60);
            run4.setText("Sdt: ");
            run4.setText(hoaDon.getSdt() + "");
            run4.addBreak();

            XWPFParagraph paragraph5 = document.createParagraph();
            XWPFRun run5 = paragraph5.createRun();
            paragraph5.setSpacingAfter(60);
            run5.setText("Ngày tạo: ");
            run5.setText(hoaDon.getNgayTao() + "");
            run5.addBreak();

//            paragraph4.setBorderBottom(Borders.BIRDS_FLIGHT);
            //create table
            XWPFTable table = document.createTable();
            table.setCellMargins(200, 200, 200, 200);
            table.setTableAlignment(TableRowAlign.CENTER);

            // chieu rong cua bang
            CTTblWidth width = table.getCTTbl().addNewTblPr().addNewTblW();
            width.setType(STTblWidth.DXA);
            width.setW(BigInteger.valueOf(9000));

            //create first row
            XWPFTableRow row0 = table.getRow(0);
            row0.setHeight(500);
            XWPFTableCell cell0 = row0.getCell(0);
            cell0.setText("STT");
            cell0.setVerticalAlignment(XWPFTableCell.XWPFVertAlign.CENTER);

            XWPFTableCell cell1 = row0.createCell();
//            cell1.setWidth("1000");
            cell1.setWidthType(TableWidthType.AUTO);
            cell1.setText("mã sản phẩm");
            cell1.setVerticalAlignment(XWPFTableCell.XWPFVertAlign.CENTER);

            XWPFTableCell cell2 = row0.createCell();
//            cell1.setWidthType(TableWidthType.AUTO);
            cell2.setText("tên sản phẩm");
            cell2.setVerticalAlignment(XWPFTableCell.XWPFVertAlign.CENTER);

            XWPFTableCell cell3 = row0.createCell();
//            cell1.setWidthType(TableWidthType.AUTO);
            cell3.setText("số lượng");
            cell3.setVerticalAlignment(XWPFTableCell.XWPFVertAlign.CENTER);

            XWPFTableCell cell4 = row0.createCell();
//            cell1.setWidthType(TableWidthType.AUTO);
            cell4.setText("đơn giá");
            cell4.setVerticalAlignment(XWPFTableCell.XWPFVertAlign.CENTER);

            XWPFTableCell cell5 = row0.createCell();
//            cell5.setWidthType(TableWidthType.AUTO);
            cell5.setText("thành tiền");
            cell5.setVerticalAlignment(XWPFTableCell.XWPFVertAlign.CENTER);

            int i = 1;
            for (HoaDonChiTietViewModels d : ds) {
//                table.setCellMargins(100, 100, 100, 100);
                XWPFTableRow tableRowTwo = table.createRow();
                tableRowTwo.getCell(0).setText(i++ + "");
                tableRowTwo.getCell(1).setText(d.getMaSanPham());
                tableRowTwo.getCell(2).setText(d.getTenSanPham());
                tableRowTwo.getCell(3).setText(d.getSoLuong() + "");
                tableRowTwo.getCell(4).setText(d.getDonGia() + "");
                tableRowTwo.getCell(5).setText((d.getSoLuong() * d.getDonGia()) + "");

            }

            XWPFParagraph paragraph8 = document.createParagraph();
            XWPFRun run8 = paragraph8.createRun();
            paragraph8.setSpacingAfter(60);
            run8.setFontSize(13);
//            paragraph0.setAlignment(ParagraphAlignment.LEFT);
            run8.setText("Tổng tiền: ");
            run8.setText(tongTien);
            run8.setBold(true);
            run8.addBreak();

            XWPFRun run9 = paragraph8.createRun();
            run9.setFontSize(13);
            run9.setText("Tiền khách đưa: ");
            run9.setText(tienKhachDua);
            run9.addBreak();

            double tong = Double.parseDouble(tongTien);
            double tienKhach = Double.parseDouble(tienKhachDua);
            double tienGiam1 = Double.parseDouble(tienGiam);
            double tienThua = tong - tienKhach;
            double tongThanhToan = tong - tienKhach - tienGiam1;

            XWPFRun run10 = paragraph8.createRun();
            run10.setFontSize(13);
            run10.setText("Tiền thừa: ");
            run10.setText(tienThua + "");
            run10.addBreak();

            XWPFRun run11 = paragraph8.createRun();
            run11.setFontSize(13);
            run11.setText("Tổng thanh toán: ");
            run11.setText(tongThanhToan + "");
            run11.addBreak();

            try {
                FileOutputStream fos = new FileOutputStream(file1.toString());
                document.write(fos);
                fos.close();
                JOptionPane.showMessageDialog(this, "xuất thành công");
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "xuất thất bại, vui thử nơi lưu trữ khác");
                e.printStackTrace();
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "xuất thất bại");
        }

    }

    private void loadHDCT(ArrayList<HoaDonChiTietViewModels> ds) {
        dtm = (DefaultTableModel) tblHDCT.getModel();
        dtm.setRowCount(0);
        int i = 1;

        for (HoaDonChiTietViewModels c : ds) {
            dtm.addRow(new Object[]{
                i++,
                c.getMaSanPham(),
                c.getTenSanPham(),
                c.getSoLuong(),
                c.getDonGia(),
                (c.getSoLuong()
                * c.getDonGia())
            });
        }

    }

    // load hoa don theo tinh trang
    private void loadHoaDonByTinhTrang(int tinhTrang) {
        dtm = (DefaultTableModel) tblHoaDon.getModel();
        dtm.setRowCount(0);
        lstHoaDon = hoaDonServices.getALLByTrangThai(tinhTrang);
        int i = 1;
        for (HoaDonBanViewModels ct : lstHoaDon) {
            dtm.addRow(new Object[]{
                i++,
                ct.getMa(),
                ct.getNgayTao(),
                ct.getNhanVien(),
                ct.getKhachHang(),
                setTinhTrang(ct.getTinhTrang())
            });
        }
    }

    private void loadCBB() {
        lstDanhMuc = danhMucServices.getAll();
        cbbLocDanhMuc.removeAllItems();
        cbbLocDanhMuc.addItem("");
        for (DanhMuc c : lstDanhMuc) {
            cbbLocDanhMuc.addItem(c.getTen());
        }

        lstKhachHang = khachHangServices.getALL();
        cbbKhachHang.removeAllItems();
        cbbKhachHang.addItem("");
        for (KhachHang k : lstKhachHang) {
            cbbKhachHang.addItem(k.getMa());
        }
    }

    private void loadSPHD(ArrayList<CTSPViewModels> ds) {
        dtm = (DefaultTableModel) tblSPHD.getModel();
        dtm.setRowCount(0);

        for (CTSPViewModels c : ds) {
            dtm.addRow(new Object[]{
                c.getMa(),
                c.getTenSP(),
                c.getTheLoai(),
                c.getGiaBan(),
                c.getSoLuong(),
                c.getMoTa()
            });
        }
    }

    // set tinh trang vao bang hoa don
    public String setTinhTrang(int i) {
        if (i == 0) {
            return "chưa thanh toán";
        } else if (i == 1) {
            return "đã thanh toán";
        } else if (i == 2) {
            return "hủy";
        }
        return "lỗi";
    }

    private void lamMoi() {
        txtMaHD.setText("");
        txtNgayTao.setText("");
        txtTongTien.setText("");
        txtTienKhachDua.setText("");
        txtTienThua.setText("");
        txtThanhToan.setText("");
        txtGhiChu.setText("");
    }

    private void loadTongTien(ArrayList<HoaDonChiTietViewModels> ds) {
        double tongTien = 0;
        for (HoaDonChiTietViewModels c : lstHoaDonChiTiet) {
            tongTien += (c.getDonGia() * c.getSoLuong());
        }
        if (lstHoaDonChiTiet.size() == 0) {
            txtTongTien.setText("0");

            txtTienKhachDua.setText("0");
            txtTienThua.setText("0");
        } else {
            txtTongTien.setText(tongTien + "");
            txtThanhToan.setText(tongTien + "");
        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel7 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblHoaDon = new javax.swing.JTable();
        btnTaoHoaDon = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblHDCT = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        btnXoaSanPham = new javax.swing.JButton();
        btnXoaHetSanPham = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane7 = new javax.swing.JScrollPane();
        tblSPHD = new javax.swing.JTable();
        txtTimKiem = new javax.swing.JTextField();
        cbbLocDanhMuc = new javax.swing.JComboBox<>();
        btnThemSanPham = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        txtMaHD = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtNgayTao = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtTongTien = new javax.swing.JTextField();
        txtTienThua = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txtTienKhachDua = new javax.swing.JTextField();
        btnThanhToan = new javax.swing.JButton();
        btnHuy = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        lblTenKhachHang = new javax.swing.JLabel();
        cbbKhachHang = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        lblDiemTichLuy = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        txtSuDungDiem = new javax.swing.JTextField();
        btnThemKhachHang = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        txtGiam = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        txtThanhToan = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        btnHuy1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtGhiChu = new javax.swing.JTextArea();
        jLabel2 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();

        jPanel7.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED), "Hóa đơn", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 16))); // NOI18N

        tblHoaDon.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "STT", "Mã HĐ", "Ngày Tạo", "Nhân viên", "Khách hàng", "Tình trạng"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblHoaDon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblHoaDonMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tblHoaDon);

        btnTaoHoaDon.setText("Tạo hóa đơn");
        btnTaoHoaDon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTaoHoaDonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnTaoHoaDon)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnTaoHoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("giỏ hàng"));

        tblHDCT.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null}
            },
            new String [] {
                "STT", "Mã SP", "Tên", "Số lượng", "Đơn giá", "Thành tiền"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblHDCT.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblHDCTMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                tblHDCTMouseExited(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                tblHDCTMouseReleased(evt);
            }
        });
        jScrollPane2.setViewportView(tblHDCT);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 104, Short.MAX_VALUE)
        );

        btnXoaSanPham.setText("Xóa");
        btnXoaSanPham.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaSanPhamActionPerformed(evt);
            }
        });

        btnXoaHetSanPham.setText("Xóa hết");
        btnXoaHetSanPham.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaHetSanPhamActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnXoaHetSanPham, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnXoaSanPham, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnXoaSanPham)
                .addGap(18, 18, 18)
                .addComponent(btnXoaHetSanPham)
                .addContainerGap(15, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Danh sách sản Phẩm"));

        tblSPHD.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null}
            },
            new String [] {
                "Mã SP", "Tên SP", "Danh mục", "Đơn giá", "Số lương", "Mô tả"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblSPHD.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblSPHDMouseClicked(evt);
            }
        });
        jScrollPane7.setViewportView(tblSPHD);

        txtTimKiem.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtTimKiemKeyReleased(evt);
            }
        });

        cbbLocDanhMuc.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbbLocDanhMuc.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbbLocDanhMucItemStateChanged(evt);
            }
        });

        btnThemSanPham.setText("Thêm sản phẩm");
        btnThemSanPham.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemSanPhamActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane7)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(cbbLocDanhMuc, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnThemSanPham)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbbLocDanhMuc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnThemSanPham))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
        );

        jPanel6.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel5.setText("Mã HĐ:");

        txtMaHD.setEditable(false);

        jLabel6.setText("Ngày tạo:");

        txtNgayTao.setEnabled(false);

        jLabel7.setText("Tổng tiền:");

        txtTongTien.setEnabled(false);

        txtTienThua.setEnabled(false);

        jLabel9.setText("Tiền thừa:");

        jLabel10.setText("Tiền khách đưa:");

        txtTienKhachDua.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtTienKhachDuaKeyReleased(evt);
            }
        });

        btnThanhToan.setText("Thanh toán");
        btnThanhToan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThanhToanActionPerformed(evt);
            }
        });

        btnHuy.setText("Hủy");
        btnHuy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHuyActionPerformed(evt);
            }
        });

        jPanel5.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel1.setText("Khách hàng:");

        lblTenKhachHang.setText(" : ");

        cbbKhachHang.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbbKhachHang.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbbKhachHangItemStateChanged(evt);
            }
        });

        jLabel3.setText("Tên khách hàng:");

        jLabel4.setText("Điểm tích lũy:");

        jLabel11.setText("Dùng điểm");

        txtSuDungDiem.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSuDungDiemKeyReleased(evt);
            }
        });

        btnThemKhachHang.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnThemKhachHang.setText("+");
        btnThemKhachHang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemKhachHangActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtSuDungDiem, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 96, Short.MAX_VALUE))
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(cbbKhachHang, 0, 112, Short.MAX_VALUE)
                                    .addComponent(lblTenKhachHang, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addComponent(lblDiemTichLuy, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnThemKhachHang)))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(cbbKhachHang)
                        .addComponent(btnThemKhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTenKhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblDiemTichLuy, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(8, 8, 8)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtSuDungDiem, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jLabel12.setText("Giảm:");

        txtGiam.setEnabled(false);

        jLabel13.setText("Thanh toán:");

        txtThanhToan.setEnabled(false);

        jLabel14.setText("Ghi chú:");

        btnHuy1.setText("Làm mới");
        btnHuy1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHuy1ActionPerformed(evt);
            }
        });

        txtGhiChu.setColumns(20);
        txtGhiChu.setRows(5);
        jScrollPane1.setViewportView(txtGhiChu);

        jLabel2.setText("VNĐ");

        jLabel8.setText("VNĐ");

        jLabel15.setText("VNĐ");

        jLabel16.setText("VNĐ");

        jLabel17.setText("VNĐ");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 270, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel12, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, 94, Short.MAX_VALUE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(12, 12, 12)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtTienKhachDua)
                            .addComponent(txtTongTien, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtGiam)
                            .addComponent(txtTienThua)
                            .addComponent(txtNgayTao)
                            .addComponent(txtMaHD)
                            .addComponent(txtThanhToan))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel8)
                            .addComponent(jLabel15)
                            .addComponent(jLabel16)
                            .addComponent(jLabel17))
                        .addGap(12, 12, 12)))
                .addGap(12, 12, 12))
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(57, 57, 57)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(btnThanhToan, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(btnHuy, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnHuy1, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtMaHD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtNgayTao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTongTien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTienKhachDua)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtTienThua)
                        .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtGiam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtThanhToan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnHuy1)
                    .addComponent(btnHuy))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnThanhToan, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel7, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 6, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void tblHoaDonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblHoaDonMouseClicked
        int row = tblHoaDon.getSelectedRow();
        txtMaHD.setText(tblHoaDon.getValueAt(row, 1).toString());
        txtNgayTao.setText(tblHoaDon.getValueAt(row, 2).toString());
        txtTienKhachDua.setText("");
        txtTienThua.setText("");
        txtGiam.setText("");

        txtGhiChu.setText("");
        txtSuDungDiem.setText("");

//        HoaDonReponse x = lstHoaDon.get(row);
        HoaDon hd = hoaDonServices.getHDByMa(tblHoaDon.getValueAt(row, 1).toString());
        if (hd.getTenKhachHang() == null) {
            cbbKhachHang.setSelectedItem("");
        } else {
            KhachHang kh = khachHangServices.getKhachHangId(hd.getIdKhachHang().getId());
            cbbKhachHang.setSelectedItem(kh.getMa());
        }

        lstHoaDonChiTiet = hoaDonChiTietServices.getHDCTByMa(tblHoaDon.getValueAt(row, 1).toString());
        loadTongTien(lstHoaDonChiTiet);

        loadHDCT(lstHoaDonChiTiet);
    }//GEN-LAST:event_tblHoaDonMouseClicked

    private void btnTaoHoaDonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTaoHoaDonActionPerformed
//        -- tinh trang :
//--				0 - cho thanh toan
//--				1 - da thanh toan
//--				2 - huy
//--				3 - tat ca

        lstHoaDon = hoaDonServices.getALLBanHang();
        int max = JDBC_helper.getMaxHD(lstHoaDon);

        HoaDonBanViewModels h = new HoaDonBanViewModels();
        h.setMa("HD" + (max));
        h.setTinhTrang(0);
        h.setNhanVien(nguoiDung.getMa());
//        System.out.println(h.toString());

        if (hoaDonServices.insertHoaDonNull(h)) {
            JOptionPane.showMessageDialog(this, "them thanh cong");
        } else {
            JOptionPane.showMessageDialog(this, "them that bai");
        }
        loadCBB();
        loadHoaDonByTinhTrang(0);
    }//GEN-LAST:event_btnTaoHoaDonActionPerformed

    private void tblHDCTMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblHDCTMouseClicked

    }//GEN-LAST:event_tblHDCTMouseClicked

    private void tblHDCTMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblHDCTMouseExited

    }//GEN-LAST:event_tblHDCTMouseExited

    private void tblHDCTMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblHDCTMouseReleased

    }//GEN-LAST:event_tblHDCTMouseReleased

    private void tblSPHDMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblSPHDMouseClicked

    }//GEN-LAST:event_tblSPHDMouseClicked

    private void btnThanhToanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThanhToanActionPerformed

        String maHD = txtMaHD.getText().trim();
        if (maHD.length() == 0) {
            JOptionPane.showMessageDialog(this, "Chọn hóa đơn");
            return;
        }

        String tienKhachDua = txtTienKhachDua.getText().trim();
        if (tienKhachDua.length() == 0) {
            JOptionPane.showMessageDialog(this, "Chưa đủ tiền");
            return;
        }
        double tienKhach;
        double tongThanhToan;
        try {
            Double.parseDouble(tienKhachDua);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Nhập lại tiền");
            return;
        }
        tienKhach = Double.parseDouble(tienKhachDua);
        tongThanhToan = Double.parseDouble(txtThanhToan.getText());
        if (tienKhach < tongThanhToan) {
            JOptionPane.showMessageDialog(this, "Chưa đủ tiền");
            return;
        }
//        System.out.println(tienKhach);
//        System.out.println(tongThanhToan);

        String maKhach = cbbKhachHang.getSelectedItem().toString();
        KhachHang kh = new KhachHang();
        if (maKhach.length() == 0) {

        } else {
            kh = khachHangServices.getKhachHangMa(maKhach);
        }

        String ghiChu = txtGhiChu.getText().trim();

        HoaDon hoaDon = hoaDonServices.getHDByMa(maHD);
        hoaDon.setIdKhachHang(kh);
        hoaDon.setDiaChi(kh.getDiaChi());
        hoaDon.setSdt(kh.getSdt());
        hoaDon.setGhiChu(ghiChu);
        hoaDon.setTrangThai(1);

        if (hoaDonServices.updateHoaDonTinhTrang(hoaDon)) {
            String diemGiam = txtGiam.getText().trim();
            if (diemGiam.length() != 0) {
                int diem = Integer.parseInt(diemGiam);
                kh.setDiemTichLuy(kh.getDiemTichLuy() - diem);
            }
            khachHangServices.updatetKhachHang(kh);
            JOptionPane.showMessageDialog(this, "thanh cong");
            taoHoaDon(maHD, kh, lstHoaDonChiTiet, txtTienKhachDua.getText(), tienKhachDua, diemGiam);
        } else {
            JOptionPane.showMessageDialog(this, "that bai");
        }
////        loadCBB();
        lamMoi();
        cbbKhachHang.setSelectedIndex(0);
        loadHoaDonByTinhTrang(0);
    }//GEN-LAST:event_btnThanhToanActionPerformed

    private void btnHuyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHuyActionPerformed
        String maHD = txtMaHD.getText().trim();
        if (maHD.length() == 0) {
            JOptionPane.showMessageDialog(this, "Chọn hóa đơn");
            return;
        }

        String maKhach = cbbKhachHang.getSelectedItem().toString();
        KhachHang kh = new KhachHang();
        if (maKhach.length() == 0) {

        } else {
            kh = khachHangServices.getKhachHangMa(maKhach);
        }

        String ghiChu = txtGhiChu.getText().trim();

        HoaDon hoaDon = hoaDonServices.getHDByMa(maHD);
//        hoaDon.setIdKhachHang(kh);
//        hoaDon.setDiaChi(kh.getDiaChi());
//        hoaDon.setSdt(kh.getSdt());
        hoaDon.setGhiChu(ghiChu);
        hoaDon.setTrangThai(2);

        if (hoaDonServices.updateHoaDonTinhTrang(hoaDon)) {
            JOptionPane.showMessageDialog(this, "thanh cong");
        } else {
            JOptionPane.showMessageDialog(this, "that bai");
        }
//        loadCBB();
        lamMoi();
        cbbKhachHang.setSelectedIndex(0);
        loadHoaDonByTinhTrang(0);
    }//GEN-LAST:event_btnHuyActionPerformed


    private void btnHuy1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHuy1ActionPerformed
        // TODO add your handling code here:
        lamMoi();
    }//GEN-LAST:event_btnHuy1ActionPerformed

    private void txtTimKiemKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTimKiemKeyReleased
        cbbLocDanhMuc.setSelectedIndex(0);

        String txtTim = txtTimKiem.getText().trim();
        lstSanPham = cTSPServices.timKiem(txtTim);
        loadSPHD(lstSanPham);
    }//GEN-LAST:event_txtTimKiemKeyReleased

    private void cbbLocDanhMucItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbbLocDanhMucItemStateChanged
        txtTimKiem.setText("");
        if (cbbLocDanhMuc.getItemCount() > 0) {
            if (cbbLocDanhMuc.getSelectedItem().toString().trim().length() == 0) {
                lstSanPham = cTSPServices.getALL();
                loadSPHD(lstSanPham);
            } else {
                DanhMuc d = lstDanhMuc.get(cbbLocDanhMuc.getSelectedIndex() - 1);
                System.out.println(cbbLocDanhMuc.getSelectedIndex());
                lstSanPham = cTSPServices.locDanhMuc(d.getMa());
                loadSPHD(lstSanPham);
            }
        }
    }//GEN-LAST:event_cbbLocDanhMucItemStateChanged

    private void btnThemSanPhamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemSanPhamActionPerformed
        String maHD = txtMaHD.getText().trim();
        if (maHD.length() == 0) {
            return;
        }

        int row = tblSPHD.getSelectedRow();
        if (row < 0) {
            JOptionPane.showMessageDialog(this, "Chọn sản phẩm");
            return;
        }
        String soLuong = JOptionPane.showInputDialog("nhập số lượng");
        int sl;
        try {
            sl = Integer.parseInt(soLuong);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "nhập số");
            return;
        }
        sl = Integer.parseInt(soLuong);

        CTSPViewModels sp = lstSanPham.get(row);
        if (sp.getSoLuong() <= 0 || sp.getSoLuong() < sl) {
            JOptionPane.showMessageDialog(this, "không đủ hàng");
            return;
        }

        HoaDonChiTiet hoaDonChiTiet = new HoaDonChiTiet();
        hoaDonChiTiet.setSoLuong(sl);
        hoaDonChiTiet.setDonGia(sp.getGiaBan());

        HoaDon hoaDon = hoaDonServices.getHDByMa(maHD);
        hoaDonChiTiet.setIdHoaDon(hoaDon);

        ChiTietSP chiTietSP = cTSPServices.getIdCTSP(sp.getMa());
        hoaDonChiTiet.setIdCHiTietSP(chiTietSP);
//        System.out.println(chiTietSP.getSoLuongTon());
//        System.out.println(soLuong);

        if (hoaDonChiTietServices.insertHoaDonCT(hoaDonChiTiet)) {
            JOptionPane.showMessageDialog(this, "thành công");

            chiTietSP.setSoLuongTon(chiTietSP.getSoLuongTon() - sl);
            cTSPServices.updateSoLuong(chiTietSP);
        } else {
            JOptionPane.showMessageDialog(this, "thất bại");
        }
        lstHoaDonChiTiet = hoaDonChiTietServices.getHDCTByMa(maHD);
        loadHDCT(lstHoaDonChiTiet);
        loadTongTien(lstHoaDonChiTiet);

        lstSanPham = cTSPServices.getALL();
        loadSPHD(lstSanPham);

    }//GEN-LAST:event_btnThemSanPhamActionPerformed

    private void txtTienKhachDuaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTienKhachDuaKeyReleased
        // TODO add your handling code here:
        if (txtMaHD.getText().trim().length() == 0) {
            return;
        }

        try {
            double tienKhach = Double.parseDouble(txtTienKhachDua.getText().trim());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "nhập lại tiền");
            return;
        }
        double tienKhach = Double.parseDouble(txtTienKhachDua.getText().trim());
        double tongTien = Double.parseDouble(txtTongTien.getText().trim());
        double tienThua = tienKhach - tongTien;
        txtTienThua.setText(tienThua + "");

        double tienGiam = 0;
        if (txtGiam.getText().trim().length() == 0) {

        } else {
            tienGiam = Double.parseDouble(txtGiam.getText().trim());
        }
        double tongThanhToan = tongTien - tienGiam;
        txtThanhToan.setText(tongThanhToan + "");
    }//GEN-LAST:event_txtTienKhachDuaKeyReleased

    private void btnXoaSanPhamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaSanPhamActionPerformed
        int row = tblHDCT.getSelectedRow();
        if (row < 0) {
            JOptionPane.showMessageDialog(this, "chưa chọn sản phẩm");
            return;
        }

        HoaDonChiTietViewModels hoaDonChiTietReponse = lstHoaDonChiTiet.get(row);

        String maHD = txtMaHD.getText();
        HoaDon hoaDon = hoaDonServices.getHDByMa(maHD);

        ChiTietSP chiTietSP = cTSPServices.getIdCTSP(hoaDonChiTietReponse.getMaSanPham());

        if (hoaDonChiTietServices.deleteHoaDonCT(hoaDon.getId(), chiTietSP.getId())) {
            JOptionPane.showMessageDialog(this, "thành công");
            chiTietSP.setSoLuongTon(chiTietSP.getSoLuongTon() + hoaDonChiTietReponse.getSoLuong());
            cTSPServices.updateSoLuong(chiTietSP);
        } else {
            JOptionPane.showMessageDialog(this, "thất bại");
        }

        lstHoaDonChiTiet = hoaDonChiTietServices.getHDCTByMa(maHD);
        loadHDCT(lstHoaDonChiTiet);
        loadTongTien(lstHoaDonChiTiet);

        lstSanPham = cTSPServices.getALL();
        loadSPHD(lstSanPham);
    }//GEN-LAST:event_btnXoaSanPhamActionPerformed

    private void btnXoaHetSanPhamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaHetSanPhamActionPerformed
        String maHD = txtMaHD.getText();
        lstHoaDonChiTiet = hoaDonChiTietServices.getHDCTByMa(maHD);
        if (lstHoaDonChiTiet.size() <= 0) {
            JOptionPane.showMessageDialog(this, "chọn hóa đơn");
            return;
        }
        for (HoaDonChiTietViewModels g : lstHoaDonChiTiet) {
            HoaDon hoaDon = hoaDonServices.getHDByMa(maHD);

            ChiTietSP chiTietSP = cTSPServices.getIdCTSP(g.getMaSanPham());

            if (hoaDonChiTietServices.deleteHoaDonCT(hoaDon.getId(), chiTietSP.getId())) {
                chiTietSP.setSoLuongTon(chiTietSP.getSoLuongTon() + g.getSoLuong());
                cTSPServices.updateSoLuong(chiTietSP);
            } else {
                JOptionPane.showMessageDialog(this, "thất bại");
            }
        }

        lstHoaDonChiTiet = hoaDonChiTietServices.getHDCTByMa(maHD);
        loadHDCT(lstHoaDonChiTiet);
        loadTongTien(lstHoaDonChiTiet);

        lstSanPham = cTSPServices.getALL();
        loadSPHD(lstSanPham);
    }//GEN-LAST:event_btnXoaHetSanPhamActionPerformed

    private void cbbKhachHangItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbbKhachHangItemStateChanged
        String maHD = txtMaHD.getText();
        if (maHD.length() == 0) {
            return;
        }

        if (cbbKhachHang.getItemCount() > 0) {
            if (cbbKhachHang.getSelectedItem().toString().trim().length() == 0) {

                lblTenKhachHang.setText("");
                lblDiemTichLuy.setText("");
                txtSuDungDiem.setText("");
                txtSuDungDiem.setEnabled(false);

                HoaDon hoaDon = hoaDonServices.getHDByMa(maHD);
                if (hoaDon.getTrangThai() != 0) {
//                    return;
                } else {
                    hoaDon.setIdKhachHang(null);

                    hoaDonServices.updateHDKhach(hoaDon);
                }

            } else {
                KhachHang kh = lstKhachHang.get(cbbKhachHang.getSelectedIndex() - 1);

                if (kh.getDiemTichLuy() <= 0) {
                    txtSuDungDiem.setEnabled(false);
                } else {
                    txtSuDungDiem.setEnabled(true);
                }

                lblTenKhachHang.setText(kh.getTen());
                lblDiemTichLuy.setText(kh.getDiemTichLuy() + "");

                HoaDon hoaDon = hoaDonServices.getHDByMa(maHD);
                hoaDon.setIdKhachHang(kh);
                hoaDonServices.updateHDKhach(hoaDon);
            }
        }

        loadHoaDonByTinhTrang(0);
    }//GEN-LAST:event_cbbKhachHangItemStateChanged

    private void btnThemKhachHangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemKhachHangActionPerformed
        // TODO add your handling code here:
        KhachHangFrame khachHangFrame = new KhachHangFrame();
        khachHangFrame.setVisible(true);
        khachHangFrame.setLocationRelativeTo(null);
    }//GEN-LAST:event_btnThemKhachHangActionPerformed

    private void txtSuDungDiemKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSuDungDiemKeyReleased
        // TODO add your handling code here:
        if (txtMaHD.getText().trim().length() == 0) {
            return;
        }
        if (lblDiemTichLuy.getText().trim().length() == 0) {
            return;
        }

        double tongTien = Double.parseDouble(txtTongTien.getText());
        String diemNhap = txtSuDungDiem.getText().trim();
        try {
            if (diemNhap.equals("")) {
                txtGiam.setText("");
                txtThanhToan.setText(tongTien + "");
                return;
            }
            Integer.parseInt(diemNhap);

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "nhập điểm là số");
            return;
        }
        int diemGiam = Integer.parseInt(diemNhap);

        int diemTichLuy = Integer.parseInt(lblDiemTichLuy.getText());
        if (diemTichLuy <= 0 || diemTichLuy < diemGiam) {
            JOptionPane.showMessageDialog(this, "không đủ điểm");
            return;
        }

        txtGiam.setText(diemGiam + "");

        double tongThanhToan = tongTien - diemGiam;
        txtThanhToan.setText(tongThanhToan + "");
    }//GEN-LAST:event_txtSuDungDiemKeyReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnHuy;
    private javax.swing.JButton btnHuy1;
    private javax.swing.JButton btnTaoHoaDon;
    private javax.swing.JButton btnThanhToan;
    private javax.swing.JButton btnThemKhachHang;
    private javax.swing.JButton btnThemSanPham;
    private javax.swing.JButton btnXoaHetSanPham;
    private javax.swing.JButton btnXoaSanPham;
    private javax.swing.JComboBox<String> cbbKhachHang;
    private javax.swing.JComboBox<String> cbbLocDanhMuc;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
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
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JLabel lblDiemTichLuy;
    private javax.swing.JLabel lblTenKhachHang;
    private javax.swing.JTable tblHDCT;
    private javax.swing.JTable tblHoaDon;
    private javax.swing.JTable tblSPHD;
    private javax.swing.JTextArea txtGhiChu;
    private javax.swing.JTextField txtGiam;
    private javax.swing.JTextField txtMaHD;
    private javax.swing.JTextField txtNgayTao;
    private javax.swing.JTextField txtSuDungDiem;
    private javax.swing.JTextField txtThanhToan;
    private javax.swing.JTextField txtTienKhachDua;
    private javax.swing.JTextField txtTienThua;
    private javax.swing.JTextField txtTimKiem;
    private javax.swing.JTextField txtTongTien;
    // End of variables declaration//GEN-END:variables
}
