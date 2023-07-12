/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repositories;

import DomainModels.HoaDon;
import DomainModels.KhachHang;
import DomainModels.NhanVien;
import Utilities.DBConnection;
import Utilities.JDBC_helper;
import ViewModels.HoaDonBanViewModels;
import ViewModels.HoaDonHDCTViewModels;
import ViewModels.HoaDonViewModels;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author TBC
 */
public class HoaDonRepository {

    // view bán hàng
    // lấy danh sách hóa đơn view
    public ArrayList<HoaDonBanViewModels> getALLHoaDonBan() {
        String sql = "select hd.Ma as ma, hd.NgayTao as ngaytao, nv.Ma as maNV\n"
                + "                , hd.TrangThai as tinhTrang\n"
                + "               from HoaDon hd left join NhanVien nv on nv.id=hd.IdNV";
        ArrayList<HoaDonBanViewModels> ds = new ArrayList<>();
        try (Connection con = DBConnection.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                HoaDonBanViewModels h = new HoaDonBanViewModels();
                h.setMa(rs.getString("ma"));
                h.setNgayTao(rs.getDate("ngayTao"));
                h.setNhanVien(rs.getString("maNV"));
                h.setTinhTrang(rs.getInt("tinhtrang"));
                ds.add(h);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ds;
    }

    public ArrayList<HoaDonBanViewModels> getHoaDonBanByTrangThai(int tinhTrang) {

        String sql = "select hd.Ma as ma, hd.NgayTao as ngaytao, nv.Ma as maNV\n"
                + ", hd.tenKhachHang , hd.TrangThai as tinhTrang\n"
                + "               from HoaDon hd left join NhanVien nv on nv.id=hd.IdNV "
                + "where hd.trangThai=?";
        ArrayList<HoaDonBanViewModels> ds = new ArrayList<>();
        try (Connection con = DBConnection.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setObject(1, tinhTrang);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                HoaDonBanViewModels h = new HoaDonBanViewModels();
                h.setMa(rs.getString("ma"));
                h.setNgayTao(rs.getDate("ngayTao"));
                h.setNhanVien(rs.getString("maNV"));
                h.setKhachHang(rs.getString("tenKhachHang"));
                h.setTinhTrang(rs.getInt("tinhtrang"));
                ds.add(h);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ds;
    }

    public HoaDon getHDByMa(String maHD) {
        String sql = "SELECT TOP (1000) [Id]\n"
                + "      ,[IdKH]\n"
                + "      ,[IdNV]\n"
                + "      ,[Ma]\n"
                + "      ,[NgayTao]\n"
                + "      ,[NgayThanhToan]\n"
                + "      ,[TenKhachHang]\n"
                + "      ,[DiaChi]\n"
                + "      ,[Sdt]\n"
                + "      ,[GhiChu]\n"
                + "      ,[TrangThai]\n"
                + "  FROM [db_duanmau1].[dbo].[HoaDon] h \n"
                + "where ma= ?";
        HoaDon h = new HoaDon();
        ResultSet rs = JDBC_helper.selectTong(sql, maHD);
        try {
            while (rs.next()) {
                KhachHang kh = new KhachHang();
                kh.setId(rs.getString("IdKH"));
                h.setIdKhachHang(kh);

                h.setId(rs.getString("id"));
                h.setMa(rs.getString("ma"));
                h.setTenKhachHang(rs.getString("TenKhachHang"));
                h.setGhiChu(rs.getString("NgayThanhToan"));
                h.setNgayThanhToan(rs.getString("GhiChu"));
                h.setDiaChi(rs.getString("GhiChu"));
                h.setSdt(rs.getString("Sdt"));

                h.setTrangThai(rs.getInt("TrangThai"));
            }
            return h;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public boolean insertHD(HoaDonBanViewModels h) {
        int check = 0;
//        String sql = "insert into HoaDon(Ma,TinhTrang,NgayTao) values(?,?,getdate())";
        String sql = "   INSERT INTO [dbo].[HoaDon]\n"
                + "           ([IdNV]\n"
                + "           ,[Ma]\n"
                + "           ,[TrangThai]\n"
                + "           ,[NgayTao] )\n"
                + "     VALUES(?,?,?,getdate())";
        try (Connection con = DBConnection.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
            NhanVienRepository nhanVienRepository = new NhanVienRepository();
            NhanVien nv = nhanVienRepository.getNhanVienByMa(h.getNhanVien());
            ps.setObject(1, nv.getId());
            ps.setObject(2, h.getMa());
            ps.setObject(3, 0);
            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return check > 0;
    }

    public boolean updateHoaDon(HoaDon n) {
        String sql = "UPDATE [dbo].[HoaDon]\n"
                + "   SET[NgayThanhToan] = getDate()\n"
                + "      ,[DiaChi] = ?\n"
                + "      ,[Sdt] = ?\n"
                + "      ,[GhiChu] = ?\n"
                + "      ,[TrangThai] = ?\n"
                + " WHERE Ma = ?";
        return JDBC_helper.updateTong(sql,
                n.getDiaChi(), n.getSdt(),
                n.getGhiChu(), n.getTrangThai(),
                n.getMa()) > 0;
    }

    // update tinh trang hd
    public boolean updateHoaDonTinhTrang(HoaDon d) {
        String sql = "update HoaDon set TrangThai = ? where ma = ? ";
        int i = JDBC_helper.updateTong(sql, d.getTrangThai(), d.getMa());
        return true;
    }

    // update tinh trang hd
    public boolean updateHDKhach(HoaDon d) {
        if (d.getIdKhachHang() == null) {
//            JOptionPane.showMessageDialog(null, "null hóa dơn");
            String sql = "update HoaDon set [IdKH] = ?"
                    + "      ,[TenKhachHang] = ?\n"
                    + " where ma = ? ";
            int i = JDBC_helper.updateTong(sql, null, null, d.getMa());
        } else {
            String sql = "update HoaDon set [IdKH] = ? "
                    + "      ,[TenKhachHang] = ?\n"
                    + "where ma = ? ";
            int i = JDBC_helper.updateTong(sql, d.getIdKhachHang().getId(),
                    d.getIdKhachHang().getTen(), d.getMa());
        }
        return true;
    }

    // view hóa đơn
    public ArrayList<HoaDonViewModels> getALLHoaDon() {
        String sql = "select hd.Ma as ma, hd.NgayTao as ngaytao,\n"
                + "hd.NgayThanhToan as NgayThanhToan, nv.Ma as maNV, kh.Ma as makh,\n"
                + "sum(hdct.SoLuong * hdct.DonGia) as 'TongTien'\n"
                + "  , hd.TrangThai as TrangThai, hd.GhiChu as ghiChu\n"
                + "    from HoaDon hd left join NhanVien nv on nv.id=hd.IdNV\n"
                + " left join KhachHang kh on hd.IdKH=kh.Id\n"
                + "   left join HoaDonChiTiet hdct on hd.id=hdct.IdHoaDon\n"
                + "   left join ChiTietSP ctsp on hdct.IdChiTietSP=ctsp.id\n"
                + " left join SanPham sp on ctsp.IdSP=sp.id\n"
                + "group by hd.Ma, hd.NgayTao, hd.NgayThanhToan, nv.Ma, kh.Ma, hd.TrangThai, hd.GhiChu";
        ArrayList<HoaDonViewModels> ds = new ArrayList<>();
        try (Connection con = DBConnection.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                HoaDonViewModels h = new HoaDonViewModels();
                h.setMa(rs.getString("ma"));
                h.setNgayTao(rs.getString("ngayTao"));
                h.setNgayThanhToan(rs.getString("NgayThanhToan"));
                h.setMaNhanVien(rs.getString("maNV"));
                h.setMaKhachHang(rs.getString("makh"));
                h.setTongTien(rs.getDouble("TongTien"));
                h.setTrangThai(rs.getInt("TrangThai"));
                h.setGhiChu(rs.getString("ghiChu"));
                ds.add(h);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ds;
    }
    public ArrayList<HoaDonViewModels> timKiemHoaDon(String txt) {
        String sql = "select hd.Ma as mahd, hd.NgayTao as ngaytao,\n" +
"hd.NgayThanhToan as NgayThanhToan, nv.Ma as maNV, kh.Ma as makh,\n" +
"sum(hdct.SoLuong * hdct.DonGia) as 'TongTien'\n" +
", hd.TrangThai as TrangThai, hd.GhiChu as ghiChu\n" +
"from HoaDon hd left join NhanVien nv on nv.id=hd.IdNV\n" +
"left join KhachHang kh on hd.IdKH=kh.Id\n" +
"left join HoaDonChiTiet hdct on hd.id=hdct.IdHoaDon\n" +
"left join ChiTietSP ctsp on hdct.IdChiTietSP=ctsp.id\n" +
"left join SanPham sp on ctsp.IdSP=sp.id\n" +
"  where hd.Ma like ? or nv.ma like ? or kh.Ma like ? \n" +
"group by hd.Ma, hd.NgayTao, hd.NgayThanhToan, nv.Ma, kh.Ma, hd.TrangThai, hd.GhiChu";
        ArrayList<HoaDonViewModels> ds = new ArrayList<>();
        try (Connection con = DBConnection.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
             ps.setObject(1, "%"+txt+"%");
             ps.setObject(2, "%"+txt+"%");
             ps.setObject(3, "%"+txt+"%");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                HoaDonViewModels h = new HoaDonViewModels();
                h.setMa(rs.getString("mahd"));
                h.setNgayTao(rs.getString("ngayTao"));
                h.setNgayThanhToan(rs.getString("NgayThanhToan"));
                h.setMaNhanVien(rs.getString("maNV"));
                h.setMaKhachHang(rs.getString("makh"));
                h.setTongTien(rs.getDouble("TongTien"));
                h.setTrangThai(rs.getInt("TrangThai"));
                h.setGhiChu(rs.getString("ghiChu"));
                ds.add(h);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ds;
    }

    public ArrayList<HoaDonHDCTViewModels> getHoaDonCTByMaHD(String ma) {
        String sql = "select hd.Ma as ma, sp.ma as 'masp', sp.ten as 'tensp'"
                + ", hdct.SoLuong as 'soluong'\n"
                + ", hdct.DonGia as 'dongia',sum(hdct.SoLuong * hdct.DonGia) as 'thanhTien'                            \n"
                + "from HoaDon hd \n"
                + "left join HoaDonChiTiet hdct on hd.id=hdct.IdHoaDon\n"
                + "left join ChiTietSP ctsp on hdct.IdChiTietSP=ctsp.id\n"
                + "left join SanPham sp on ctsp.IdSP=sp.id\n"
                + "where hd.ma= ? \n"
                + "group by hd.Ma, sp.ma, sp.ten, hdct.SoLuong, hdct.DonGia\n"
                + "";
        ArrayList<HoaDonHDCTViewModels> ds = new ArrayList<>();
        try (Connection con = DBConnection.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setObject(1, ma);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                HoaDonHDCTViewModels h = new HoaDonHDCTViewModels();
                h.setMa(rs.getString("ma"));
                h.setMaSanPham(rs.getString("masp"));
                h.setTenSanPham(rs.getString("tensp"));
                h.setSoLuong(rs.getInt("soluong"));
                h.setDonGia(rs.getInt("dongia"));
                h.setThanhTien(rs.getDouble("thanhTien"));
                ds.add(h);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ds;
    }

}
