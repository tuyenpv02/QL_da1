/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repositories;

import Utilities.DBConnection;
import ViewModels.SachViewModels;
import ViewModels.ThongKeNamViewModels;
import ViewModels.ThongKeSPBanChayViewModels;
import ViewModels.ThongKeThangViewModels;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author TBC
 */
public class ThongKeRepository {

    public static void main(String[] args) {
        ArrayList<ThongKeNamViewModels> ds = new ThongKeRepository().getDoanhThuCacNam();
        ds.forEach(c -> {
            System.out.println(c.getNam());
            System.out.println(c.getTongHD());
            System.out.println(c.getDoanhThu());
        });
    }

    // man bao cao
    // doanh so ngay, thang nam
    public ThongKeThangViewModels getHDTheoThang(int nam, int thang, int ngay) {
        String sql = "select (select count(d.ma) from  HoaDon d  \n"
                + "                where year(ngaytao) = ? and month(ngaytao) = ? \n"
                + "                ) as 'tổng HD',\n"
                + "				( select count( ma)  from HoaDon d   where trangthai = 1\n"
                + "                and year(ngaytao) = ? and month(ngaytao) = ? ) as 'thanh cong',\n"
                + "                (select count(trangthai) from  HoaDon d  where trangthai = 2 "
                + "and year(ngaytao) = ? \n"
                + "                and month(ngaytao) =? ) as 'huy',sum(hd.soluong*hd.dongia)  as [doanh thu]\n"
                + "                from HoaDonChiTiet HD  inner join HoaDon d on d.id=hd.IdHoaDon \n"
                + "                 inner join ChiTietSP ct on ct.Id=hd.IdChiTietSP\n"
                + "                where  year(ngaytao) = ? and month(ngaytao) = ? and d.trangthai= 1";

        ThongKeThangViewModels d = new ThongKeThangViewModels();
        try (Connection con = DBConnection.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setObject(1, nam);
            ps.setObject(2, thang);
            ps.setObject(3, nam);
            ps.setObject(4, thang);
            ps.setObject(5, nam);
            ps.setObject(6, thang);
            ps.setObject(7, nam);
            ps.setObject(8, thang);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                double tongTien = rs.getDouble("doanh thu");
                int tongHD = rs.getInt("tổng HD");
                int tongHDHuy = rs.getInt("huy");
                int tongHDThanhCong = rs.getInt("thanh cong");
                d.setTongHD(tongHD);
                d.setHoaDonHuy(tongHDHuy);
                d.setHoaDonThanhCong(tongHDThanhCong);
                d.setDoanhThu(tongTien);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return d;
    }

    public ThongKeThangViewModels getHDTheoNam(int nam, int thang, int ngay) {
        String sql = "select (select count(d.ma) from  HoaDon d   where year(ngaytao) = ? \n"
                + ") as 'tổng HD'\n"
                + ",( select  count( ma)  from HoaDon d    where trangthai = 2\n"
                + "and year(ngaytao) = ? ) as 'thanh cong',\n"
                + "(select count(trangthai) from  HoaDon d  where trangthai = 1 and year(ngaytao) = ? ) as 'huy'\n"
                + ",sum(hd.soluong*hd.dongia) as [doanh thu]\n"
                + "from HoaDonChiTiet HD  inner join HoaDon d on d.id=hd.IdHoaDon \n"
                + " inner join sach ct on ct.Id=hd.Idsach\n"
                + "where  year(d.ngaytao) = ? and d.trangthai= 2";

        ThongKeThangViewModels d = new ThongKeThangViewModels();
        try (Connection con = DBConnection.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setObject(1, nam);
            ps.setObject(2, nam);
            ps.setObject(3, nam);
            ps.setObject(4, nam);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                double tongTien = rs.getDouble("doanh thu");
                int tongHD = rs.getInt("tổng HD");
                int tongHDHuy = rs.getInt("huy");
                int tongHDThanhCong = rs.getInt("thanh cong");
                d.setTongHD(tongHD);
                d.setHoaDonHuy(tongHDHuy);
                d.setHoaDonThanhCong(tongHDThanhCong);
                d.setDoanhThu(tongTien);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return d;
    }

    public ThongKeThangViewModels getHDTheoNgay(int nam, int thang, int ngay) {
        String sql = "select (select count(d.ma) from  HoaDon d  \n"
                + "                where year(ngaytao) = ? and month(ngaytao) = ? and day(ngaytao) = ? \n"
                + "                ) as 'tổng HD',\n"
                + "				( select count( ma)  from HoaDon d   where trangthai = 1\n"
                + "                and year(ngaytao) = ? and month(ngaytao) = ? and day(ngaytao) = ? ) as 'thanh cong',\n"
                + "                (select count(trangthai) from  HoaDon d  where trangthai = 2 and year(ngaytao) = ? \n"
                + "                and month(ngaytao) = ? and day(ngaytao) = ? ) as 'huy'\n"
                + "				,sum(hd.soluong*hd.dongia)  as [doanh thu]\n"
                + "                from HoaDonChiTiet HD  inner join HoaDon d on d.id=hd.IdHoaDon \n"
                + "                 inner join ChiTietSP ct on ct.Id=hd.IdChiTietSP\n"
                + "                where  year(ngaytao) = ? and month(ngaytao) = ? and day(ngaythanhtoan) = ? and d.trangthai= 1";

        ThongKeThangViewModels d = new ThongKeThangViewModels();
        try (Connection con = DBConnection.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setObject(1, nam);
            ps.setObject(2, thang);
            ps.setObject(3, ngay);
            ps.setObject(4, nam);
            ps.setObject(5, thang);
            ps.setObject(6, ngay);
            ps.setObject(7, nam);
            ps.setObject(8, thang);
            ps.setObject(9, ngay);
            ps.setObject(10, nam);
            ps.setObject(11, thang);
            ps.setObject(12, ngay);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                double tongTien = rs.getDouble("doanh thu");
                int tongHD = rs.getInt("tổng HD");
                int tongHDHuy = rs.getInt("huy");
                int tongHDThanhCong = rs.getInt("thanh cong");
                d.setTongHD(tongHD);
                d.setHoaDonHuy(tongHDHuy);
                d.setHoaDonThanhCong(tongHDThanhCong);
                d.setDoanhThu(tongTien);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(d);
        return d;
    }

    //
    public ArrayList<ThongKeNamViewModels> getDoanhThuCacNam() {
        String sql = " SELECT  hd.năm, hd.TongHD, dThu.[SL bán], dThu.[doanh thu]\n"
                + "FROM (select count(id) as [TongHD],year(ngaytao) [năm]   from  HoaDon  group by year(ngaytao)) Hd \n"
                + "inner join \n"
                + "(SELECT  year(hd.ngaytao) as 'năm' , sum(hdct.SOLUONG) as 'SL bán'\n"
                + ",SUM(hdct.SOLUONG * hdct.DONGIA) AS 'doanh thu'\n"
                + "FROM HoaDon hd \n"
                + "left join HoaDonChiTiet hdct on hd.id=hdct.IdHoaDon\n"
                + "left join ChiTietSP ctsp on hdct.IdChiTietSP=ctsp.id\n"
                + "left join SanPham sp on ctsp.IdSP=sp.id\n"
                + "where hd.TrangThai = 1 GROUP BY year(hd.ngaytao) \n"
                + ") dThu on dThu.năm=hd.năm\n"
                + "order by hd.năm";
        ArrayList<ThongKeNamViewModels> ds = new ArrayList<>();
        try (Connection con = DBConnection.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {

                int nam = rs.getInt("năm");
                int tongHD = rs.getInt("tongHD");
                int soLuongSP = rs.getInt("SL bán");
                double doanhThu = rs.getDouble("doanh thu");
                ThongKeNamViewModels d = new ThongKeNamViewModels();
                d.setNam(nam);
                d.setTongHD(tongHD);
                d.setSoLuongSPBan(soLuongSP);
                d.setDoanhThu(doanhThu);
                ds.add(d);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ds;
    }

    // tong so luong sach
    public int getTongSachSapHet() {
        String sql = "SELECT count(SP.Ma) AS 'tong'\n"
                + "FROM ChiTietSP CTSP INNER JOIN SanPham SP ON CTSP.IdSP=SP.Id\n"
                + "WHERE TRANGTHAI= 1 AND SOLUONGTON < 10 and SOLUONGTON > 0";

        int tong = 0;
        try (Connection con = DBConnection.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String x = rs.getString("tong");
                tong = Integer.parseInt(x);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return tong;
    }

    public int getTongSachHetHang() {
        String sql = "SELECT count(SP.Ma) AS 'tong'\n"
                + "FROM ChiTietSP CTSP INNER JOIN SanPham SP ON CTSP.IdSP=SP.Id \n"
                + "WHERE TRANGTHAI= 1 AND SOLUONGTON = 0";

        int tong = 0;
        try (Connection con = DBConnection.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String x = rs.getString("tong");
                tong = Integer.parseInt(x);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return tong;
    }

    public int getTongSachTheoTinhTrang(int trangthai) {
        String sql = "SELECT count(SP.Ma) AS 'tong' \n"
                + "FROM ChiTietSP CTSP INNER JOIN SanPham SP ON CTSP.IdSP=SP.Id \n"
                + "WHERE TRANGTHAI=?";

        int tong = 0;
        try (Connection con = DBConnection.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setObject(1, trangthai);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String x = rs.getString("tong");
                tong = Integer.parseInt(x);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return tong;
    }

// load bảng sách theo trạng thái
    public ArrayList<SachViewModels> getAllSach() {
        String sql = "SELECT SP.Ma AS 'MA', SP.TEN AS 'TEN',\n"
                + "CTSP.SoLuongTon AS 'SoLuongTon',\n"
                + "CTSP.GiaNhap AS 'GiaNhap', CTSP.TrangThai AS 'TrangThai'\n"
                + "FROM ChiTietSP CTSP INNER JOIN SanPham SP ON CTSP.IdSP=SP.Id";
        ArrayList<SachViewModels> ds = new ArrayList<>();
        try (Connection con = DBConnection.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                String ma = rs.getString("ma");
                String ten = rs.getString("ten");
                int soLuong = rs.getInt("SOLUONGTON");
                int trangThai = rs.getInt("TRANGTHAI");
                double giaNhap = rs.getDouble("GiaNhap");
                SachViewModels s = new SachViewModels();
                s.setMa(ma);
                s.setTen(ten);
                s.setSoLuong(soLuong);
                s.setTrangThai(trangThai);
                s.setGiaNhap(giaNhap);
                ds.add(s);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ds;
    }

    public ArrayList<SachViewModels> getAllSachSapHet() {
        String sql = "SELECT SP.Ma AS 'MA', SP.TEN AS 'TEN',\n"
                + "CTSP.SoLuongTon AS 'SoLuongTon',\n"
                + "CTSP.GiaNhap AS 'GiaNhap', CTSP.TrangThai AS 'TrangThai'\n"
                + "FROM ChiTietSP CTSP INNER JOIN SanPham SP ON CTSP.IdSP=SP.Id\n"
                + "WHERE TRANGTHAI= 1 AND SOLUONGTON < 10 and SOLUONGTON > 0 ";

        ArrayList<SachViewModels> ds = new ArrayList<>();
        try (Connection con = DBConnection.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String ma = rs.getString("ma");
                String ten = rs.getString("ten");
                int soLuong = rs.getInt("SOLUONGTON");
                int trangThai = rs.getInt("TRANGTHAI");
                double giaNhap = rs.getDouble("gianhap");
                SachViewModels s = new SachViewModels();
                s.setMa(ma);
                s.setTen(ten);
                s.setSoLuong(soLuong);
                s.setTrangThai(trangThai);
                s.setGiaNhap(giaNhap);
                ds.add(s);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ds;
    }

    public ArrayList<SachViewModels> getAllSachHetHang() {
        String sql = "SELECT SP.Ma AS 'MA', SP.TEN AS 'TEN',\n"
                + "CTSP.SoLuongTon AS 'SoLuongTon',\n"
                + "CTSP.GiaNhap AS 'GiaNhap', CTSP.TrangThai AS 'TrangThai'\n"
                + "FROM ChiTietSP CTSP INNER JOIN SanPham SP ON CTSP.IdSP=SP.Id\n"
                + " WHERE TRANGTHAI= 1 AND SOLUONGTON = 0 ";

        ArrayList<SachViewModels> ds = new ArrayList<>();
        try (Connection con = DBConnection.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String ma = rs.getString("ma");
                String ten = rs.getString("ten");
                int soLuong = rs.getInt("SOLUONGTON");
                int trangThai = rs.getInt("TRANGTHAI");
                double giaNhap = rs.getDouble("gianhap");
                SachViewModels s = new SachViewModels();
                s.setMa(ma);
                s.setTen(ten);
                s.setSoLuong(soLuong);
                s.setTrangThai(trangThai);
                s.setGiaNhap(giaNhap);
                ds.add(s);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ds;
    }

    public ArrayList<SachViewModels> getAllSachByTrangThai(int sl) {
        String sql = "SELECT SP.Ma AS 'MA', SP.TEN AS 'TEN',\n"
                + "CTSP.SoLuongTon AS 'SoLuongTon',\n"
                + "CTSP.GiaNhap AS 'GiaNhap', CTSP.TrangThai AS 'TrangThai'\n"
                + "FROM ChiTietSP CTSP INNER JOIN SanPham SP ON CTSP.IdSP=SP.Id \n"
                + " WHERE TRANGTHAI= ? ";

        ArrayList<SachViewModels> ds = new ArrayList<>();
        try (Connection con = DBConnection.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setObject(1, sl);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String ma = rs.getString("ma");
                String ten = rs.getString("ten");
                int soLuong = rs.getInt("SOLUONGTON");
                int trangThai = rs.getInt("TRANGTHAI");
                double giaNhap = rs.getDouble("gianhap");
                SachViewModels s = new SachViewModels();
                s.setMa(ma);
                s.setTen(ten);
                s.setSoLuong(soLuong);
                s.setTrangThai(trangThai);
                s.setGiaNhap(giaNhap);
                ds.add(s);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ds;
    }

// lấy list sách bán chạy nhiều ít
    public ArrayList<ThongKeSPBanChayViewModels> getSPBanChay(String sapXep) {
        String sql = "SELECT top 10  sp.MA, sp.ten\n"
                + "                , SUM(hdct.SOLUONG) AS 'SL BÁN' \n"
                + "                ,SUM(hdct.SOLUONG * hdct.DONGIA) AS 'TỔNG TIỀN HÀNG'\n"
                + "                from SanPham sp inner join ChiTietSP ctsp on sp.Id=ctsp.IdSP\n"
                + "				left join HoaDonChiTiet hdct on ctsp.Id=hdct.IdChiTietSP\n"
                + "				inner join HoaDon hd on hd.id=hdct.IdHoaDon \n"
                + "                 where hd.TrangThai = 1\n"
                + "                GROUP BY sp.MA, sp.ten, ctsp.giaban\n"
                + "                order by SUM(hdct.SOLUONG )   " + sapXep;

        ArrayList<ThongKeSPBanChayViewModels> ds = new ArrayList<>();
        try (Connection con = DBConnection.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String ma = rs.getString("ma");
                String ten = rs.getString("ten");
                int soLuong = rs.getInt("SL BÁN");
                double tongTien = rs.getDouble("TỔNG TIỀN HÀNG");
                ThongKeSPBanChayViewModels d = new ThongKeSPBanChayViewModels();
                d.setMa(ma);
                d.setSoLuong(soLuong);
                d.setTen(ten);
                d.setTongTien(tongTien);
                ds.add(d);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ds;
    }

// lấy list sách bán thành tiền nhiều ít
    public ArrayList<ThongKeSPBanChayViewModels> getSPBanNhieuTien(String sapXep) {
        String sql = "SELECT top 10  sp.MA, sp.ten\n"
                + "                , SUM(hdct.SOLUONG) AS 'SL BÁN' \n"
                + "                ,SUM(hdct.SOLUONG * hdct.DONGIA) AS 'TỔNG TIỀN HÀNG'\n"
                + "                from SanPham sp inner join ChiTietSP ctsp on sp.Id=ctsp.IdSP\n"
                + "				left join HoaDonChiTiet hdct on ctsp.Id=hdct.IdChiTietSP\n"
                + "				inner join HoaDon hd on hd.id=hdct.IdHoaDon \n"
                + "                 where hd.TrangThai = 1\n"
                + "                GROUP BY sp.MA, sp.ten, ctsp.giaban\n"
                + "                order by SUM(hdct.SOLUONG * hdct.DONGIA)  " + sapXep;

        ArrayList<ThongKeSPBanChayViewModels> ds = new ArrayList<>();
        try (Connection con = DBConnection.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String ma = rs.getString("ma");
                String ten = rs.getString("ten");
                int soLuong = rs.getInt("SL BÁN");
                double tongTien = rs.getDouble("TỔNG TIỀN HÀNG");
                ThongKeSPBanChayViewModels d = new ThongKeSPBanChayViewModels();
                d.setMa(ma);
                d.setSoLuong(soLuong);
                d.setTen(ten);
                d.setTongTien(tongTien);
                ds.add(d);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ds;
    }

}
