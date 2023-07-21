/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repositories;

import DomainModels.ChiTietSP;
import Utilities.DBConnection;
import Utilities.JDBC_helper;
import ViewModels.CTSPViewModels;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author TBC
 */
public class CTSPRepository {

    public ArrayList<CTSPViewModels> getALL() {
        ArrayList<CTSPViewModels> ds = new ArrayList<>();
        String sql = "SELECT SanPham.Ma,SanPham.Ten\n"
                + "      ,TacGia.Ten as [tacgia]\n"
                + "      ,DanhMuc.Ten as [danhmuc]\n"
                + "      ,NXB.Ten as [nxb]\n"
                + "      ,[MoTa]\n"
                + "      ,[SoLuongTon]\n"
                + "      ,[GiaNhap]\n"
                + "      ,[GiaBan]\n"
                + "      ,[AnhDaiDien]\n"
                + "      ,[TrangThai]\n"
                + "  FROM [dbo].[ChiTietSP]\n"
                + "  INNER JOIN\n"
                + "           dbo.DanhMuc ON dbo.ChiTietSP.IdDanhMuc = dbo.DanhMuc.Id INNER JOIN\n"
                + "           dbo.NXB ON dbo.ChiTietSP.IdNxb = dbo.NXB.Id INNER JOIN\n"
                + "           dbo.SanPham ON dbo.ChiTietSP.IdSP = dbo.SanPham.Id INNER JOIN\n"
                + "           dbo.TacGia ON dbo.ChiTietSP.IdTacGia = dbo.TacGia.Id";
        try (Connection con = DBConnection.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                CTSPViewModels ct = new CTSPViewModels();
                ct.setMa(rs.getString("ma"));
                ct.setTenSP(rs.getString("ten"));
                ct.setTacGia(rs.getString("tacgia"));
                ct.setTheLoai(rs.getString("danhmuc"));
                ct.setNxb(rs.getString("nxb"));
                ct.setGiaNhap(rs.getDouble("giaNhap"));
                ct.setGiaBan(rs.getDouble("giaBan"));
                ct.setSoLuong(rs.getInt("SoLuongTon"));
                ct.setMoTa(rs.getString("moTa"));
                ct.setAnh(rs.getString("AnhDaiDien"));
                ct.setTrangThai(rs.getInt("TrangThai"));

                ds.add(ct);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ds;
    }

    public ArrayList<CTSPViewModels> timKiem(String txt) {
        ArrayList<CTSPViewModels> ds = new ArrayList<>();
        String sql = "SELECT SanPham.Ma,SanPham.Ten\n"
                + "      ,TacGia.Ten as [tacgia]\n"
                + "      ,DanhMuc.Ten as [danhmuc]\n"
                + "      ,NXB.Ten as [nxb]\n"
                + "      ,[MoTa]\n"
                + "      ,[SoLuongTon]\n"
                + "      ,[GiaNhap]\n"
                + "      ,[GiaBan]\n"
                + "      ,[AnhDaiDien]\n"
                + "      ,[TrangThai]\n"
                + "  FROM [dbo].[ChiTietSP]\n"
                + "  INNER JOIN\n"
                + "           dbo.DanhMuc ON dbo.ChiTietSP.IdDanhMuc = dbo.DanhMuc.Id INNER JOIN\n"
                + "           dbo.NXB ON dbo.ChiTietSP.IdNxb = dbo.NXB.Id INNER JOIN\n"
                + "           dbo.SanPham ON dbo.ChiTietSP.IdSP = dbo.SanPham.Id INNER JOIN\n"
                + "           dbo.TacGia ON dbo.ChiTietSP.IdTacGia = dbo.TacGia.Id "
                + "where CONCAT(SanPham.Ma, SanPham.Ten, TacGia.Ten, DanhMuc.Ten"
                + ", MoTa) like ?";
        try (Connection con = DBConnection.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setObject(1, "%" + txt + "%");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                CTSPViewModels ct = new CTSPViewModels();
                ct.setMa(rs.getString("ma"));
                ct.setTenSP(rs.getString("ten"));
                ct.setTacGia(rs.getString("tacgia"));
                ct.setTheLoai(rs.getString("danhmuc"));
                ct.setNxb(rs.getString("nxb"));
                ct.setGiaNhap(rs.getDouble("giaNhap"));
                ct.setGiaBan(rs.getDouble("giaBan"));
                ct.setSoLuong(rs.getInt("SoLuongTon"));
                ct.setMoTa(rs.getString("moTa"));
                ct.setAnh(rs.getString("AnhDaiDien"));
                ct.setTrangThai(rs.getInt("TrangThai"));

                ds.add(ct);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ds;
    }

    public ArrayList<CTSPViewModels> locDanhMuc(String txt) {
        ArrayList<CTSPViewModels> ds = new ArrayList<>();
        String sql = "SELECT SanPham.Ma,SanPham.Ten\n"
                + "      ,TacGia.Ten as [tacgia]\n"
                + "      ,DanhMuc.Ten as [danhmuc]\n"
                + "      ,NXB.Ten as [nxb]\n"
                + "      ,[MoTa]\n"
                + "      ,[SoLuongTon]\n"
                + "      ,[GiaNhap]\n"
                + "      ,[GiaBan]\n"
                + "      ,[AnhDaiDien]\n"
                + "      ,[TrangThai]\n"
                + "  FROM [dbo].[ChiTietSP]\n"
                + "  INNER JOIN\n"
                + "           dbo.DanhMuc ON dbo.ChiTietSP.IdDanhMuc = dbo.DanhMuc.Id INNER JOIN\n"
                + "           dbo.NXB ON dbo.ChiTietSP.IdNxb = dbo.NXB.Id INNER JOIN\n"
                + "           dbo.SanPham ON dbo.ChiTietSP.IdSP = dbo.SanPham.Id INNER JOIN\n"
                + "           dbo.TacGia ON dbo.ChiTietSP.IdTacGia = dbo.TacGia.Id "
                + "where DanhMuc.Ma=?";
        try (Connection con = DBConnection.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setObject(1, txt);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                CTSPViewModels ct = new CTSPViewModels();
                ct.setMa(rs.getString("ma"));
                ct.setTenSP(rs.getString("ten"));
                ct.setTacGia(rs.getString("tacgia"));
                ct.setTheLoai(rs.getString("danhmuc"));
                ct.setNxb(rs.getString("nxb"));
                ct.setGiaNhap(rs.getDouble("giaNhap"));
                ct.setGiaBan(rs.getDouble("giaBan"));
                ct.setSoLuong(rs.getInt("SoLuongTon"));
                ct.setMoTa(rs.getString("moTa"));
                ct.setAnh(rs.getString("AnhDaiDien"));
                ct.setTrangThai(rs.getInt("TrangThai"));
                ds.add(ct);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ds;
    }

    public ArrayList<CTSPViewModels> locTacGia(String txt) {
        ArrayList<CTSPViewModels> ds = new ArrayList<>();
        String sql = "SELECT SanPham.Ma,SanPham.Ten\n"
                + "      ,TacGia.Ten as [tacgia]\n"
                + "      ,DanhMuc.Ten as [danhmuc]\n"
                + "      ,NXB.Ten as [nxb]\n"
                + "      ,[MoTa]\n"
                + "      ,[SoLuongTon]\n"
                + "      ,[GiaNhap]\n"
                + "      ,[GiaBan]\n"
                + "      ,[AnhDaiDien]\n"
                + "      ,[TrangThai]\n"
                + "  FROM [dbo].[ChiTietSP]\n"
                + "  INNER JOIN\n"
                + "           dbo.DanhMuc ON dbo.ChiTietSP.IdDanhMuc = dbo.DanhMuc.Id INNER JOIN\n"
                + "           dbo.NXB ON dbo.ChiTietSP.IdNxb = dbo.NXB.Id INNER JOIN\n"
                + "           dbo.SanPham ON dbo.ChiTietSP.IdSP = dbo.SanPham.Id INNER JOIN\n"
                + "           dbo.TacGia ON dbo.ChiTietSP.IdTacGia = dbo.TacGia.Id "
                + "where TacGia.Ma=?";
        try (Connection con = DBConnection.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setObject(1, txt);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                CTSPViewModels ct = new CTSPViewModels();
                ct.setMa(rs.getString("ma"));
                ct.setTenSP(rs.getString("ten"));
                ct.setTacGia(rs.getString("tacgia"));
                ct.setTheLoai(rs.getString("danhmuc"));
                ct.setNxb(rs.getString("nxb"));
                ct.setGiaNhap(rs.getDouble("giaNhap"));
                ct.setGiaBan(rs.getDouble("giaBan"));
                ct.setSoLuong(rs.getInt("SoLuongTon"));
                ct.setMoTa(rs.getString("moTa"));
                ct.setAnh(rs.getString("AnhDaiDien"));
                ct.setTrangThai(rs.getInt("TrangThai"));
                ds.add(ct);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ds;
    }

    public ArrayList<CTSPViewModels> locTrangThai(int txt) {
        ArrayList<CTSPViewModels> ds = new ArrayList<>();
        String sql = "SELECT SanPham.Ma,SanPham.Ten\n"
                + "      ,TacGia.Ten as [tacgia]\n"
                + "      ,DanhMuc.Ten as [danhmuc]\n"
                + "      ,NXB.Ten as [nxb]\n"
                + "      ,[MoTa]\n"
                + "      ,[SoLuongTon]\n"
                + "      ,[GiaNhap]\n"
                + "      ,[GiaBan]\n"
                + "      ,[AnhDaiDien]\n"
                + "      ,[TrangThai]\n"
                + "  FROM [dbo].[ChiTietSP]\n"
                + "  INNER JOIN\n"
                + "           dbo.DanhMuc ON dbo.ChiTietSP.IdDanhMuc = dbo.DanhMuc.Id INNER JOIN\n"
                + "           dbo.NXB ON dbo.ChiTietSP.IdNxb = dbo.NXB.Id INNER JOIN\n"
                + "           dbo.SanPham ON dbo.ChiTietSP.IdSP = dbo.SanPham.Id INNER JOIN\n"
                + "           dbo.TacGia ON dbo.ChiTietSP.IdTacGia = dbo.TacGia.Id "
                + "where TrangThai=?";
        try (Connection con = DBConnection.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setObject(1, txt);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                CTSPViewModels ct = new CTSPViewModels();
                ct.setMa(rs.getString("ma"));
                ct.setTenSP(rs.getString("ten"));
                ct.setTacGia(rs.getString("tacgia"));
                ct.setTheLoai(rs.getString("danhmuc"));
                ct.setNxb(rs.getString("nxb"));
                ct.setGiaNhap(rs.getDouble("giaNhap"));
                ct.setGiaBan(rs.getDouble("giaBan"));
                ct.setSoLuong(rs.getInt("SoLuongTon"));
                ct.setMoTa(rs.getString("moTa"));
                ct.setAnh(rs.getString("AnhDaiDien"));
                ct.setTrangThai(rs.getInt("TrangThai"));
                ds.add(ct);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ds;
    }

    public CTSPViewModels getCTSPByMa(String maSP) {
        String sql = "SELECT SanPham.Ma,SanPham.Ten\n"
                + "      ,TacGia.Ten as [tacgia]\n"
                + "      ,DanhMuc.Ten as [danhmuc]\n"
                + "      ,NXB.Ten as [nxb]\n"
                + "      ,[MoTa]\n"
                + "      ,[SoLuongTon]\n"
                + "      ,[GiaNhap]\n"
                + "      ,[GiaBan]\n"
                + "      ,[AnhDaiDien]\n"
                + "      ,[TrangThai]\n"
                + "  FROM [dbo].[ChiTietSP]\n"
                + "  INNER JOIN\n"
                + "           dbo.DanhMuc ON dbo.ChiTietSP.IdDanhMuc = dbo.DanhMuc.Id INNER JOIN\n"
                + "           dbo.NXB ON dbo.ChiTietSP.IdNxb = dbo.NXB.Id INNER JOIN\n"
                + "           dbo.SanPham ON dbo.ChiTietSP.IdSP = dbo.SanPham.Id INNER JOIN\n"
                + "           dbo.TacGia ON dbo.ChiTietSP.IdTacGia = dbo.TacGia.Id"
                + " where dbo.SanPham.ma=?";
        CTSPViewModels ct = new CTSPViewModels();
        try (Connection con = DBConnection.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setObject(1, maSP);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                ct.setMa(rs.getString("ma"));
                ct.setTenSP(rs.getString("ten"));
                ct.setTacGia(rs.getString("tacgia"));
                ct.setTheLoai(rs.getString("danhmuc"));
                ct.setNxb(rs.getString("nxb"));
                ct.setGiaNhap(rs.getDouble("giaNhap"));
                ct.setGiaBan(rs.getDouble("giaBan"));
                ct.setSoLuong(rs.getInt("SoLuongTon"));
                ct.setMoTa(rs.getString("moTa"));
                ct.setAnh(rs.getString("AnhDaiDien"));
                ct.setTrangThai(rs.getInt("TrangThai"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ct;
    }

    public ChiTietSP getIdCTSPByMa(String masp) {
        ChiTietSP c = new ChiTietSP();
        String sql = "SELECT  dbo.ChiTietSP.Id, dbo.SanPham.Ma, dbo.SanPham.Ten"
                + ", dbo.ChiTietSP.soLuongTon \n"
                + "FROM   dbo.ChiTietSP INNER JOIN\n"
                + "       dbo.SanPham ON dbo.ChiTietSP.IdSP = dbo.SanPham.Id\n"
                + "	   where dbo.SanPham.Ma=?";
        try (Connection con = DBConnection.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setObject(1, masp);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                c.setId(rs.getString("id"));
                c.setSoLuongTon(rs.getInt("soLuongTon"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return c;
    }

    public boolean insertCTSanPham(ChiTietSP ct) {
        String sql = "INSERT INTO [dbo].[SanPham]\n"
                + "           ([Ma]\n"
                + "           ,[Ten])\n"
                + "     VALUES(?,?)\n"
                + "	 declare @idSP varchar(max) \n"
                + "	 select @idSP = id from SanPham where ma=?\n"
                + "INSERT INTO [dbo].[ChiTietSP]\n"
                + "           ([IdSP]\n"
                + "           ,[IdTacGia]\n"
                + "           ,[IdDanhMuc]\n"
                + "           ,[IdNxb]\n"
                + "           ,[MoTa]\n"
                + "           ,[SoLuongTon]\n"
                + "           ,[GiaNhap]\n"
                + "           ,[GiaBan]\n"
                + "           ,[AnhDaiDien]\n"
                + "           ,[TrangThai])\n"
                + "     VALUES(@idsp,?,?,?,?,?,?,?,?,?)";
        CTSPViewModels c = getCTSPByMa(ct.getSanPham().getMa());
        if (c.getMa() != null) {
            JOptionPane.showMessageDialog(null, "ma sp ton tai");
            return false;
        }
        return JDBC_helper.updateTong(sql,
                ct.getSanPham().getMa(), ct.getSanPham().getTen(),
                ct.getSanPham().getMa(),
                ct.getTacGia().getId(),
                ct.getDanhMuc().getId(),
                ct.getNxb().getId(),
                ct.getMoTa(),
                ct.getSoLuongTon(),
                ct.getGiaNhap(),
                ct.getGiaBan(),
                ct.getAnhDaiDien(),
                ct.getTrangThai()) > 0;
    }

    public boolean updateCTSanPham(ChiTietSP ct) {
        String sql = "update SanPham set ten=? where ma=?\n"
                + " UPDATE [dbo].[ChiTietSP]\n"
                + "   SET \n"
                + "      [IdTacGia] = ?\n"
                + "      ,[IdDanhMuc] = ?\n"
                + "      ,[IdNxb] = ?\n"
                + "      ,[MoTa] = ?\n"
                + "      ,[SoLuongTon] = ?\n"
                + "      ,[GiaNhap] = ?\n"
                + "      ,[GiaBan] = ?\n"
                + "      ,[AnhDaiDien] = ?\n"
                + "      ,[TrangThai] = ?\n"
                + " WHERE IdSP = ?";
        return JDBC_helper.updateTong(sql,
                ct.getSanPham().getTen(), ct.getSanPham().getMa(),
                ct.getTacGia().getId(),
                ct.getDanhMuc().getId(),
                ct.getNxb().getId(),
                ct.getMoTa(),
                ct.getSoLuongTon(),
                ct.getGiaNhap(),
                ct.getGiaBan(),
                ct.getAnhDaiDien(),
                ct.getTrangThai(),
                ct.getSanPham().getId()) > 0;
    }

    public boolean updateSoLuong(ChiTietSP c) {
        String sql = "update ChiTietSP set SoLuongTon = ?\n"
                + " where id=?";
        return JDBC_helper.updateTong(sql, c.getSoLuongTon(),
                c.getId()) > 0;
    }

    public boolean deleteCTSP(String idSP) {
        String sql = "delete ChiTietSP where IdSP=?";
        return JDBC_helper.updateTong(sql, idSP) > 0;
    }
}
