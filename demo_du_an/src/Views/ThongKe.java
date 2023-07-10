/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Views;

import Services.ThongKeServices;
import Services.impl.ThongKeServicesImpl;
import ViewModels.SachViewModels;
import ViewModels.ThongKeThangViewModels;
import ViewModels.ThongKeNamViewModels;
import ViewModels.ThongKeSPBanChayViewModels;
import java.io.File;
import java.io.FileOutputStream;
import java.time.LocalDate;
import java.util.ArrayList;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author TBC
 */
public class ThongKe extends javax.swing.JPanel {
DefaultTableModel dtm;
    private ThongKeServices thongKeServices = new ThongKeServicesImpl();
    
    private ArrayList<ThongKeNamViewModels> lstThongKeCacNam;
    
    private ArrayList<SachViewModels> chiTietSach;
    private ArrayList<ThongKeSPBanChayViewModels> lstSPBanChay;
    
    public ThongKe() {
        initComponents();
        
        // man bao cao
        loadThongKeNgayThangNam();
        loadThongKeNam();
        
        // man san pham
        // load tinh trang
        loadTongSach();
        // load table sach
        chiTietSach = thongKeServices.getAllSach();
        loadThongKeSach(chiTietSach);
        // sp ban chay
        loadCBBThongKeSach();
        lstSPBanChay = thongKeServices.getSPBanChay("desc");
        loadSPBanChay(lstSPBanChay);
    }
    
    private void loadCBBThongKeSach(){
        cbbSPBanChay.removeAllItems();
        cbbSPBanChay.addItem("top sản phẩm bán ít nhất");
        cbbSPBanChay.addItem("top sản phẩm bán nhiều nhất");
        cbbSPBanChay.addItem("top sản phẩm bán nhiều tiền nhất");
        cbbSPBanChay.addItem("top sản phẩm bán ít tiền nhất");
    }
    
    void loadSPBanChay(ArrayList<ThongKeSPBanChayViewModels> ds) {
        dtm = (DefaultTableModel) tblSPBanChay.getModel();
//        lstSPBanChay = thongKeServices.getSPBanChay();
        dtm.setRowCount(0);
        for (ThongKeSPBanChayViewModels s : ds) {
            dtm.addRow(new Object[]{
                s.getMa(),
                s.getTen(),
                s.getSoLuong(),
                s.getTongTien()
            });
        }
    }
    
    private void loadTongSach() {
        int tongBan = thongKeServices.getTongSachTheoTinhTrang(1);
        lblDangBan.setText(tongBan + "");

        int tongNgung = thongKeServices.getTongSachTheoTinhTrang(0);
        lblNgungBan.setText(tongNgung + "");

        int tongSapHet = thongKeServices.getTongSachSapHet();
        lblSapHet.setText(tongSapHet + "");

        int tongHet = thongKeServices.getTongSachDaHet();
        lblHetHang.setText(tongHet + "");

    }
    
   private void loadThongKeSach(ArrayList<SachViewModels> ds) {
        dtm = (DefaultTableModel) tblThongKeCTSach.getModel();
//        CTSach = thongKeServices.getAllSach();
        dtm.setRowCount(0);
        for (SachViewModels s : ds) {
            dtm.addRow(new Object[]{
                s.getMa(),
                s.getTen(),
                s.getSoLuong(),
                s.getGiaNhap(),
                s.getTrangThai() == 1 ? "đang bán" : "ngưng bán"
            });
        }
    }

    private LocalDate getDate() {
        LocalDate d = LocalDate.now();
        return d;
    }
     
     private void loadThongKeNam(){
         pnlThongKeNam.removeAll();
         lstThongKeCacNam = thongKeServices.getDoanhThuCacNam();
        pnlBartChartThongKeNam d = new pnlBartChartThongKeNam(lstThongKeCacNam);
        //       d.setSize(500, 300);
        pnlThongKeNam.add(d);
        pnlThongKeNam.revalidate();
     }
     private void loadThongKeNgayThangNam() {
//        LocalDate d = LocalDate.now();

        int month = getDate().getMonthValue();
        int year = getDate().getYear();
        int day = getDate().getDayOfMonth();

         ThongKeThangViewModels thang = thongKeServices.getHDTheoThang(year, month, day);
        lblDoanhThuThang.setText(thang.getDoanhThu() + " VNĐ");
        lblTongHoaDon.setText("" + thang.getTongHD());
        lblHoaDonHuy.setText("" + thang.getHoaDonHuy());
    }
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        btnBaoCao = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        lblDoanhThuThang = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        lblTongHoaDon = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        lblHoaDonHuy = new javax.swing.JLabel();
        pnlDoanhThuNam = new javax.swing.JPanel();
        pnlThongKeNam = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jSeparator1 = new javax.swing.JSeparator();
        pnlDangBan = new javax.swing.JPanel();
        lblDangBan = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        pnlHetSach = new javax.swing.JPanel();
        lblHetHang = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        pnlNgungBan = new javax.swing.JPanel();
        lblNgungBan = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        pnlSapHet = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        lblSapHet = new javax.swing.JLabel();
        blnLoadSach = new javax.swing.JButton();
        btnXuatSLSach = new javax.swing.JButton();
        jScrollPane6 = new javax.swing.JScrollPane();
        tblThongKeCTSach = new javax.swing.JTable();
        jPanel12 = new javax.swing.JPanel();
        jPanel13 = new javax.swing.JPanel();
        cbbSPBanChay = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblSPBanChay = new javax.swing.JTable();
        btnXuatSPBanTheo = new javax.swing.JButton();

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED), "Doanh thu tháng"));

        btnBaoCao.setText("Báo cáo");
        btnBaoCao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBaoCaoActionPerformed(evt);
            }
        });

        jPanel4.setBackground(new java.awt.Color(255, 204, 255));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Doanh thu");

        jLabel4.setText("VNĐ");

        lblDoanhThuThang.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lblDoanhThuThang.setForeground(new java.awt.Color(255, 51, 51));
        lblDoanhThuThang.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblDoanhThuThang.setText("jLabel4");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addComponent(lblDoanhThuThang, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel4)))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblDoanhThuThang, javax.swing.GroupLayout.DEFAULT_SIZE, 44, Short.MAX_VALUE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel5.setBackground(new java.awt.Color(153, 255, 153));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Hóa Đơn");

        lblTongHoaDon.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lblTongHoaDon.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTongHoaDon.setText("jLabel4");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(lblTongHoaDon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblTongHoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(22, Short.MAX_VALUE))
        );

        jPanel6.setBackground(new java.awt.Color(255, 204, 204));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Hóa Đơn Hủy");

        lblHoaDonHuy.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lblHoaDonHuy.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblHoaDonHuy.setText("jLabel4");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblHoaDonHuy, javax.swing.GroupLayout.DEFAULT_SIZE, 195, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lblHoaDonHuy, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap(62, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(btnBaoCao, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(47, 47, 47)
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 70, Short.MAX_VALUE)
                        .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28))))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnBaoCao)
                .addContainerGap())
        );

        pnlDoanhThuNam.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED), "Doanh thu năm"));

        pnlThongKeNam.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        pnlThongKeNam.setLayout(new java.awt.BorderLayout());

        jButton1.setBackground(new java.awt.Color(0, 153, 0));
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/icons8-microsoft-excel-24.png"))); // NOI18N
        jButton1.setText("Xuất");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlDoanhThuNamLayout = new javax.swing.GroupLayout(pnlDoanhThuNam);
        pnlDoanhThuNam.setLayout(pnlDoanhThuNamLayout);
        pnlDoanhThuNamLayout.setHorizontalGroup(
            pnlDoanhThuNamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDoanhThuNamLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlDoanhThuNamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnlThongKeNam, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(pnlDoanhThuNamLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        pnlDoanhThuNamLayout.setVerticalGroup(
            pnlDoanhThuNamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDoanhThuNamLayout.createSequentialGroup()
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlThongKeNam, javax.swing.GroupLayout.DEFAULT_SIZE, 246, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnlDoanhThuNam, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlDoanhThuNam, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Báo cáo", jPanel1);

        jPanel7.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        pnlDangBan.setBackground(new java.awt.Color(153, 153, 255));
        pnlDangBan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pnlDangBanMouseClicked(evt);
            }
        });

        lblDangBan.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lblDangBan.setForeground(new java.awt.Color(255, 51, 51));
        lblDangBan.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblDangBan.setText("jLabel5");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Sách đang bán");

        javax.swing.GroupLayout pnlDangBanLayout = new javax.swing.GroupLayout(pnlDangBan);
        pnlDangBan.setLayout(pnlDangBanLayout);
        pnlDangBanLayout.setHorizontalGroup(
            pnlDangBanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDangBanLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(pnlDangBanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblDangBan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, 148, Short.MAX_VALUE))
                .addContainerGap(30, Short.MAX_VALUE))
        );
        pnlDangBanLayout.setVerticalGroup(
            pnlDangBanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDangBanLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(lblDangBan, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(17, Short.MAX_VALUE))
        );

        pnlHetSach.setBackground(new java.awt.Color(0, 204, 51));
        pnlHetSach.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pnlHetSachMouseClicked(evt);
            }
        });

        lblHetHang.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lblHetHang.setForeground(new java.awt.Color(255, 51, 51));
        lblHetHang.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblHetHang.setText("jLabel5");

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("Sách hết hàng");

        javax.swing.GroupLayout pnlHetSachLayout = new javax.swing.GroupLayout(pnlHetSach);
        pnlHetSach.setLayout(pnlHetSachLayout);
        pnlHetSachLayout.setHorizontalGroup(
            pnlHetSachLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlHetSachLayout.createSequentialGroup()
                .addContainerGap(22, Short.MAX_VALUE)
                .addGroup(pnlHetSachLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblHetHang, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20))
        );
        pnlHetSachLayout.setVerticalGroup(
            pnlHetSachLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlHetSachLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(lblHetHang, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pnlNgungBan.setBackground(new java.awt.Color(0, 204, 255));
        pnlNgungBan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pnlNgungBanMouseClicked(evt);
            }
        });

        lblNgungBan.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lblNgungBan.setForeground(new java.awt.Color(255, 51, 51));
        lblNgungBan.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblNgungBan.setText("jLabel5");

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setText("Sách ngưng bán");

        javax.swing.GroupLayout pnlNgungBanLayout = new javax.swing.GroupLayout(pnlNgungBan);
        pnlNgungBan.setLayout(pnlNgungBanLayout);
        pnlNgungBanLayout.setHorizontalGroup(
            pnlNgungBanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlNgungBanLayout.createSequentialGroup()
                .addContainerGap(24, Short.MAX_VALUE)
                .addGroup(pnlNgungBanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblNgungBan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18))
        );
        pnlNgungBanLayout.setVerticalGroup(
            pnlNgungBanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlNgungBanLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(lblNgungBan, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pnlSapHet.setBackground(new java.awt.Color(255, 153, 153));
        pnlSapHet.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pnlSapHetMouseClicked(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Sách sắp hết");

        lblSapHet.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lblSapHet.setForeground(new java.awt.Color(255, 51, 0));
        lblSapHet.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblSapHet.setText("jLabel5");

        javax.swing.GroupLayout pnlSapHetLayout = new javax.swing.GroupLayout(pnlSapHet);
        pnlSapHet.setLayout(pnlSapHetLayout);
        pnlSapHetLayout.setHorizontalGroup(
            pnlSapHetLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlSapHetLayout.createSequentialGroup()
                .addContainerGap(26, Short.MAX_VALUE)
                .addGroup(pnlSapHetLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblSapHet, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(16, 16, 16))
        );
        pnlSapHetLayout.setVerticalGroup(
            pnlSapHetLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlSapHetLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(lblSapHet, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        blnLoadSach.setText("Làm mới");
        blnLoadSach.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                blnLoadSachActionPerformed(evt);
            }
        });

        btnXuatSLSach.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/icons8-microsoft-excel-2019-48.png"))); // NOI18N
        btnXuatSLSach.setText("Xuất");
        btnXuatSLSach.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXuatSLSachActionPerformed(evt);
            }
        });

        tblThongKeCTSach.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "mã sản phẩm", "tên sản phẩm", "số lượng tồn", "Giá Nhập", "trạng thái"
            }
        ));
        jScrollPane6.setViewportView(tblThongKeCTSach);

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane6)
                    .addComponent(jSeparator1)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(pnlDangBan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 8, Short.MAX_VALUE)
                        .addComponent(pnlSapHet, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(pnlHetSach, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(pnlNgungBan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(blnLoadSach, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnXuatSLSach)))
                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(pnlDangBan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnlHetSach, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnlNgungBan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnlSapHet, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnXuatSLSach, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(blnLoadSach, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel13.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        cbbSPBanChay.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbbSPBanChayItemStateChanged(evt);
            }
        });

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(cbbSPBanChay, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel13Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(cbbSPBanChay, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18))
        );

        tblSPBanChay.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Mã", "Tên Sách", "Số lượng bán", "tổng tiền"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblSPBanChay);

        btnXuatSPBanTheo.setBackground(new java.awt.Color(51, 153, 0));
        btnXuatSPBanTheo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/icons8-microsoft-excel-2019-48.png"))); // NOI18N
        btnXuatSPBanTheo.setText("Xuất");
        btnXuatSPBanTheo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXuatSPBanTheoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnXuatSPBanTheo, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnXuatSPBanTheo, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 112, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Sản phẩm", jPanel2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 844, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 544, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnBaoCaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBaoCaoActionPerformed
         int month = getDate().getMonthValue();
        int year = getDate().getYear();
        int day = getDate().getDayOfMonth();
        
        ThongKeThangViewModels ngay = thongKeServices.getHDTheoThang(year, month, day);
        
        SendGmail send = new SendGmail(ngay);
        send.setVisible(true);
    }//GEN-LAST:event_btnBaoCaoActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if (lstThongKeCacNam.size() < 1) {
            JOptionPane.showMessageDialog(this, "chưa có thông kê");
            return;
        }

        JFileChooser file = new JFileChooser("C:"); // mo hop thoai theo duong dan
        int x = file.showOpenDialog(this); // mo hop thoai dialog

        if (x != 0) {
            return; // k return se ban loi
        }

        File file1 = file.getSelectedFile(); // tao file bang fchoose da chon o tren

        if (file1.toString().lastIndexOf(".") == -1) {
            file1 = new File(file1.toString() + ".xlsx"); // thêm đuôi
        }
        if (file1.toString().endsWith(".xlsx") || file1.toString().endsWith(".xls")
                || file1.toString().endsWith(".xlsm")) {
        } else {
            JOptionPane.showMessageDialog(this, ".xlsx, .xls, .xlsm ?");
            return;
        }

        try {
            XSSFWorkbook workBan = new XSSFWorkbook(); //
            XSSFSheet sheet = workBan.createSheet("danh sách ngày " + getDate()); // tạo 1 sheet

            XSSFRow row = null;
            Cell cell = null;

            row = sheet.createRow(1); // tạo row cách 2 dòng // 3 dòng đầu trống
            cell = row.createCell(2);
            cell.setCellValue("thống kê doanh thu " + getDate());

            row = sheet.createRow(3); // tạo row cách 2 dòng // 3 dòng đầu trống
            // tạo cột
            cell = row.createCell(0, CellType.STRING); // cột 0 kiểu string
            cell.setCellValue("Năm");                   // sét giá trị cho tên cột

            cell = row.createCell(1, CellType.STRING);
            cell.setCellValue("Số lượng sản phẩm bán");

            cell = row.createCell(2, CellType.STRING);
            cell.setCellValue("Doanh thu");

            for (int i = 0; i < lstThongKeCacNam.size(); i++) {
                row = sheet.createRow(4 + i); // thêm từ dòng 4 vì dòng 3 là tên cột

                cell = row.createCell(0, CellType.NUMERIC);
                cell.setCellValue(lstThongKeCacNam.get(i).getNam());

                cell = row.createCell(1, CellType.NUMERIC);
                cell.setCellValue(lstThongKeCacNam.get(i).getSoLuongSPBan());

                cell = row.createCell(2);
                cell.setCellValue(lstThongKeCacNam.get(i).getDoanhThu());

            }

            //            File f = new File("C:\\Users\\Thinkpad T480s\\Desktop\\PRO1041\\thống kê excel\\Tksach1.xlsx");
            try {
                FileOutputStream fos = new FileOutputStream(file1.toString());
                workBan.write(fos);
                fos.close();
                JOptionPane.showMessageDialog(this, "xuất thành công");
            } catch (Exception e) {
                e.printStackTrace();
            }
        } catch (Exception e) {
            e.printStackTrace();

        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void blnLoadSachActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_blnLoadSachActionPerformed
        chiTietSach = thongKeServices.getAllSach();
        loadThongKeSach(chiTietSach);
    }//GEN-LAST:event_blnLoadSachActionPerformed

    private void btnXuatSLSachActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXuatSLSachActionPerformed

        JFileChooser file = new JFileChooser("C:"); // mo hop thoai theo duong dan
        int x = file.showOpenDialog(this); // mo hop thoai dialog

        if (x != 0) {
            return; // k return se ban loi
        }

        File file1 = file.getSelectedFile(); // tao file bang fchoose da chon o tren

        // kiểm tra xem có đuôi chưa thì thêm
        if (file1.toString().lastIndexOf(".") == -1) {
            file1 = new File(file1.toString() + ".xlsx"); // thêm đuôi
        }
        if (file1.toString().endsWith(".xlsx") || file1.toString().endsWith(".xls")
            || file1.toString().endsWith(".xlsm")) {
        } else {
            JOptionPane.showMessageDialog(this, ".xlsx, .xls, .xlsm ?");
            return;
        }

        try {
            XSSFWorkbook workBan = new XSSFWorkbook(); //
            XSSFSheet sheet = workBan.createSheet("danh sách"); // tạo 1 sheet

            XSSFRow row = null;
            Cell cell = null;

            //
            row = sheet.createRow(1); // tạo row cách 2 dòng // 3 dòng đầu trống
            cell = row.createCell(2);
            cell.setCellValue("Ngày thống kê :" + getDate());

            row = sheet.createRow(3); // tạo row cách 2 dòng // 3 dòng đầu trống
            // tạo cột
            cell = row.createCell(0, CellType.STRING); // cột 0 kiểu string
            cell.setCellValue("Mã");                   // sét giá trị cho tên cột

            cell = row.createCell(1, CellType.STRING);
            cell.setCellValue("Tên");

            cell = row.createCell(2, CellType.STRING);
            cell.setCellValue("Số lượng tồn");

            cell = row.createCell(3, CellType.STRING);
            cell.setCellValue("Trạng thái");
            //            System.out.println(CTSach.size() + "123");
            for (int i = 0; i < chiTietSach.size(); i++) {
                row = sheet.createRow(4 + i); // thêm từ dòng 4 vì dòng 3 là tên cột

                cell = row.createCell(0, CellType.STRING);
                cell.setCellValue(chiTietSach.get(i).getMa());

                cell = row.createCell(1, CellType.STRING);
                cell.setCellValue(chiTietSach.get(i).getTen());

                cell = row.createCell(2, CellType.NUMERIC);
                cell.setCellValue(chiTietSach.get(i).getSoLuong());

                cell = row.createCell(3, CellType.STRING);
                cell.setCellValue(chiTietSach.get(i).getTrangThai() == 1 ? "đang bán" : "ngưng bán");

            }

            //            File f = new File("C:\\Users\\Thinkpad T480s\\Desktop\\PRO1041\\thống kê excel\\Tksach1.xlsx");
            try {
                FileOutputStream fos = new FileOutputStream(file1.toString());
                workBan.write(fos);
                fos.close();
                JOptionPane.showMessageDialog(this, "xuất thành công");
            } catch (Exception e) {
                e.printStackTrace();
            }
        } catch (Exception e) {
            e.printStackTrace();

        }
    }//GEN-LAST:event_btnXuatSLSachActionPerformed

    private void cbbSPBanChayItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbbSPBanChayItemStateChanged
        if (cbbSPBanChay.getItemCount() == 0) {
            return;
        }
        if (cbbSPBanChay.getSelectedItem().toString().equalsIgnoreCase("top sản phẩm bán ít nhất")) {
            lstSPBanChay = thongKeServices.getSPBanChay("");
            //            loadSPBanChay(lstSPBanChay);
        } else if (cbbSPBanChay.getSelectedItem().toString().equalsIgnoreCase("top sản phẩm bán nhiều nhất")) {
            lstSPBanChay = thongKeServices.getSPBanChay("desc");
            //            loadSPBanChay(lstSPBanChay);

        } else if (cbbSPBanChay.getSelectedItem().toString().equalsIgnoreCase("top sản phẩm bán nhiều tiền nhất")) {
            lstSPBanChay = thongKeServices.getSPBanNhieuTien("desc");
            System.out.println("nhieu tien");
            //            loadSPBanChay(lstSPBanChay);

        } else if (cbbSPBanChay.getSelectedItem().toString().equalsIgnoreCase("top sản phẩm bán ít tiền nhất")) {
            lstSPBanChay = thongKeServices.getSPBanNhieuTien("");
                        System.out.println("it tien");

        }
        loadSPBanChay(lstSPBanChay);
    }//GEN-LAST:event_cbbSPBanChayItemStateChanged

    private void btnXuatSPBanTheoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXuatSPBanTheoActionPerformed
        JFileChooser file = new JFileChooser("C:"); // mo hop thoai theo duong dan
        int x = file.showOpenDialog(this); // mo hop thoai dialog

        if (x != 0) {
            return; // k return se ban loi
        }

        File file1 = file.getSelectedFile(); // tao file bang fchoose da chon o tren
        //        System.out.println(file1.getAbsolutePath());
        if (file1.toString().lastIndexOf(".") == -1) {
            file1 = new File(file1.toString() + ".xlsx"); // thêm đuôi
        }
        if (file1.toString().endsWith(".xlsx") || file1.toString().endsWith(".xls")
            || file1.toString().endsWith(".xlsm")) {
        } else {
            JOptionPane.showMessageDialog(this, ".xlsx, .xls, .xlsm ?");
            return;
        }

        try {
            XSSFWorkbook workBan = new XSSFWorkbook(); //
            XSSFSheet sheet = workBan.createSheet("danh sách"); // tạo 1 sheet

            XSSFRow row = null;
            Cell cell = null;

            //
            row = sheet.createRow(1); // tạo row cách 2 dòng // 3 dòng đầu trống
            cell = row.createCell(2);
            cell.setCellValue("Thống kê " + cbbSPBanChay.getSelectedItem() + " " + getDate());

            row = sheet.createRow(3); // tạo row cách 2 dòng // 3 dòng đầu trống
            // tạo cột
            cell = row.createCell(0, CellType.STRING); // cột 0 kiểu string
            cell.setCellValue("Mã");                   // sét giá trị cho tên cột

            cell = row.createCell(1, CellType.STRING);
            cell.setCellValue("Tên");

            cell = row.createCell(2, CellType.STRING);
            cell.setCellValue("Số lượng bán");

            cell = row.createCell(3, CellType.STRING);
            cell.setCellValue("Tổng tiền");

            for (int i = 0; i < lstSPBanChay.size(); i++) {
                row = sheet.createRow(4 + i); // thêm từ dòng 4 vì dòng 3 là tên cột

                cell = row.createCell(0, CellType.STRING);
                cell.setCellValue(lstSPBanChay.get(i).getMa());

                cell = row.createCell(1, CellType.STRING);
                cell.setCellValue(lstSPBanChay.get(i).getTen());

                cell = row.createCell(2, CellType.NUMERIC);
                cell.setCellValue(lstSPBanChay.get(i).getSoLuong());

                cell = row.createCell(3, CellType.STRING);
                cell.setCellValue(lstSPBanChay.get(i).getTongTien());

            }

            //            File f = new File("C:\\Users\\Thinkpad T480s\\Desktop\\PRO1041\\thống kê excel\\Tksach1.xlsx");
            try {
                FileOutputStream fos = new FileOutputStream(file1.toString());
                workBan.write(fos);
                fos.close();
                JOptionPane.showMessageDialog(this, "xuất thành công");
            } catch (Exception e) {
                e.printStackTrace();
            }
        } catch (Exception e) {
            e.printStackTrace();

        }
    }//GEN-LAST:event_btnXuatSPBanTheoActionPerformed

    private void pnlDangBanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlDangBanMouseClicked
        chiTietSach = thongKeServices.getAllSachByTrangThai(1);
        loadThongKeSach(chiTietSach);
    }//GEN-LAST:event_pnlDangBanMouseClicked

    private void pnlSapHetMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlSapHetMouseClicked
        // TODO add your handling code here:
        chiTietSach = thongKeServices.getAllSachSapHet();
        loadThongKeSach(chiTietSach);
    }//GEN-LAST:event_pnlSapHetMouseClicked

    private void pnlHetSachMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlHetSachMouseClicked
        // TODO add your handling code here:
        chiTietSach = thongKeServices.getAllSachHetHang();
        loadThongKeSach(chiTietSach);
    }//GEN-LAST:event_pnlHetSachMouseClicked

    private void pnlNgungBanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlNgungBanMouseClicked
        // TODO add your handling code here:
        chiTietSach = thongKeServices.getAllSachByTrangThai(0);
        loadThongKeSach(chiTietSach);
    }//GEN-LAST:event_pnlNgungBanMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton blnLoadSach;
    private javax.swing.JButton btnBaoCao;
    private javax.swing.JButton btnXuatSLSach;
    private javax.swing.JButton btnXuatSPBanTheo;
    private javax.swing.JComboBox<String> cbbSPBanChay;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JLabel lblDangBan;
    private javax.swing.JLabel lblDoanhThuThang;
    private javax.swing.JLabel lblHetHang;
    private javax.swing.JLabel lblHoaDonHuy;
    private javax.swing.JLabel lblNgungBan;
    private javax.swing.JLabel lblSapHet;
    private javax.swing.JLabel lblTongHoaDon;
    private javax.swing.JPanel pnlDangBan;
    private javax.swing.JPanel pnlDoanhThuNam;
    private javax.swing.JPanel pnlHetSach;
    private javax.swing.JPanel pnlNgungBan;
    private javax.swing.JPanel pnlSapHet;
    private javax.swing.JPanel pnlThongKeNam;
    private javax.swing.JTable tblSPBanChay;
    private javax.swing.JTable tblThongKeCTSach;
    // End of variables declaration//GEN-END:variables
}
