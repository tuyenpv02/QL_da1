/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repositories;

import DomainModels.ChiTietSP;
import DomainModels.HoaDon;
import DomainModels.HoaDonChiTiet;
import Utilities.DBConnection;
import Utilities.JDBC_helper;
import ViewModels.HoaDonChiTietViewModels;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author TBC
 */
public class HoaDonChiTietRepository {

    public ArrayList<HoaDonChiTietViewModels> getHDCTByMaHD(String maHD) {
        String sql = "SELECT dbo.SanPham.Ma, dbo.SanPham.Ten, dbo.HoaDonChiTiet.SoLuong\n"
                + ", dbo.HoaDonChiTiet.DonGia\n"
                + "FROM   dbo.ChiTietSP INNER JOIN\n"
                + "             dbo.HoaDonChiTiet ON dbo.ChiTietSP.Id = dbo.HoaDonChiTiet.IdChiTietSP INNER JOIN\n"
                + "             dbo.HoaDon ON dbo.HoaDonChiTiet.IdHoaDon = dbo.HoaDon.Id INNER JOIN\n"
                + "             dbo.SanPham ON dbo.ChiTietSP.IdSP = dbo.SanPham.Id\n"
                + "			 where HoaDon.ma= ?";
        ArrayList<HoaDonChiTietViewModels> ds = new ArrayList<>();
        try (Connection con = DBConnection.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setObject(1, maHD);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                HoaDonChiTietViewModels h = new HoaDonChiTietViewModels();
                h.setMaSanPham(rs.getString("ma"));
                h.setTenSanPham(rs.getString("ten"));
                h.setSoLuong(rs.getInt("soluong"));
                h.setDonGia(rs.getDouble("dongia"));
                ds.add(h);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ds;
    }

    public boolean inserHoaDonCT(HoaDonChiTiet c) {
        String sql = "INSERT INTO [dbo].[HoaDonChiTiet]\n"
                + "           ([IdHoaDon]\n"
                + "           ,[IdChiTietSP]\n"
                + "           ,[SoLuong]\n"
                + "           ,[DonGia])\n"
                + "     VALUES(?,?,?,?)";
        return JDBC_helper.updateTong(sql, c.getIdHoaDon().getId(), c.getIdCHiTietSP().getId(), c.getSoLuong(), c.getDonGia()) > 0;
    }

    public boolean updateSLHoaDonCT(HoaDonChiTiet g) {
        String sql = "UPDATE [dbo].[HoaDonChiTiet]\n"
                + "   SET [SoLuong] = ?\n"
                + " WHERE [IdHoaDon] =  ? \n"
                + " and  [IdChiTietSP] = ? ";
        System.out.println(" --- " + g.toString());
        int check = JDBC_helper.updateTong(sql, g.getSoLuong(),
                g.getIdHoaDon().getId(), g.getIdCHiTietSP().getId());
        return check > 0;
    }

    public boolean deleteGHCT(String idGh, String idChiTietSP) {
        String sql = "delete from [dbo].[HoaDonChiTiet]\n"
                + " where [IdHoaDon] =  ? \n"
                + " and [IdChiTietSP] = ? ";
        return JDBC_helper.updateTong(sql, idGh, idChiTietSP) > 0;
    }

    public HoaDonChiTiet getHDCTByID(String idHD, String idCTSp) {
        String sql = "SELECT [IdHoaDon]\n"
                + "      ,[IdChiTietSP]\n"
                + "      ,[SoLuong]\n"
                + "      ,[DonGia]\n"
                + "  FROM [dbo].[HoaDonChiTiet]\n"
                + "   WHERE [IdHoaDon] =  ?\n"
                + " and  [IdChiTietSP] = ? ";
        ResultSet rs = JDBC_helper.selectTong(sql, idHD, idCTSp);
        HoaDonChiTiet g = new HoaDonChiTiet();
        try {
            while (rs.next()) {
                HoaDon gh = new HoaDon();
                gh.setId(rs.getString("IdHoaDon"));

                ChiTietSP ct = new ChiTietSP();
                ct.setId(rs.getString("IdChiTietSP"));

                g.setIdHoaDon(gh);
                g.setIdCHiTietSP(ct);
                g.setSoLuong(rs.getInt("soLuong"));
                g.setDonGia(rs.getDouble("donGia"));
            }
            return g;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
