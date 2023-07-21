/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repositories;

import DomainModels.KhachHang;
import Utilities.DBConnection;
import Utilities.JDBC_helper;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author TBC
 */
public class KhachHangRepository {

    public static void main(String[] args) {
        KhachHang kh = new KhachHangRepository().getKhachHangById("F9AFD41C-7B78-47F4-997D-92F82B49A281");
        System.out.println(kh.getMa());
        System.out.println(kh.getTen());
    }

    public ArrayList<KhachHang> getAll() {
        String sql = "SELECT [Id]\n"
                + "      ,[Ma]\n"
                + "      ,[Ten]\n"
                + "      ,[NgaySinh]\n"
                + "      ,[GioiTinh]\n"
                + "      ,[Email]\n"
                + "      ,[Sdt]\n"
                + "      ,[DiaChi]\n"
                + "      ,[DiemTichLuy]\n"
                + "      ,[MatKhau]\n"
                + "      ,[TrangThai]\n"
                + "  FROM [dbo].[KhachHang]";
        ArrayList<KhachHang> ds = new ArrayList<>();

        try (Connection con = DBConnection.getConnection(); PreparedStatement ps = con.prepareCall(sql)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                KhachHang kh = new KhachHang();
                kh.setId(rs.getString("id"));
                kh.setMa(rs.getString("ma"));
                kh.setTen(rs.getString("ten"));
                kh.setNgaySinh(rs.getDate("NgaySinh"));
                kh.setGioiTinh(rs.getInt("GioiTinh"));
                kh.setEmail(rs.getString("Email"));
                kh.setSdt(rs.getString("Sdt"));
                kh.setDiaChi(rs.getString("DiaChi"));
                kh.setDiemTichLuy(rs.getInt("DiemTichLuy"));
                kh.setMatKhau(rs.getString("MatKhau"));
                kh.setTrangThai(rs.getInt("TrangThai"));
                ds.add(kh);
            }

        } catch (Exception e) {
        }
        return ds;
    }

    public ArrayList<KhachHang> timKiem(String txt) {
        String sql = "SELECT [Id]\n"
                + "      ,[Ma]\n"
                + "      ,[Ten]\n"
                + "      ,[NgaySinh]\n"
                + "      ,[GioiTinh]\n"
                + "      ,[Email]\n"
                + "      ,[Sdt]\n"
                + "      ,[DiaChi]\n"
                + "      ,[DiemTichLuy]\n"
                + "      ,[MatKhau]\n"
                + "      ,[TrangThai]\n"
                + "  FROM [dbo].[KhachHang] "
                + "where ma like ? or ten like ? ";
        ArrayList<KhachHang> ds = new ArrayList<>();

        try (Connection con = DBConnection.getConnection(); PreparedStatement ps = con.prepareCall(sql)) {
            ps.setObject(1, "%" + txt + "%");
            ps.setObject(2, "%" + txt + "%");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                KhachHang kh = new KhachHang();
                kh.setId(rs.getString("id"));
                kh.setMa(rs.getString("ma"));
                kh.setTen(rs.getString("ten"));
                kh.setNgaySinh(rs.getDate("NgaySinh"));
                kh.setGioiTinh(rs.getInt("GioiTinh"));
                kh.setEmail(rs.getString("Email"));
                kh.setSdt(rs.getString("Sdt"));
                kh.setDiaChi(rs.getString("DiaChi"));
                kh.setDiemTichLuy(rs.getInt("DiemTichLuy"));
                kh.setMatKhau(rs.getString("MatKhau"));
                kh.setTrangThai(rs.getInt("TrangThai"));
                ds.add(kh);
            }

        } catch (Exception e) {
        }
        return ds;
    }

    public KhachHang getKhachHangByMa(String ma) {
        String sql = "SELECT [Id]\n"
                + "      ,[Ma]\n"
                + "      ,[Ten]\n"
                + "      ,[NgaySinh]\n"
                + "      ,[GioiTinh]\n"
                + "      ,[Email]\n"
                + "      ,[Sdt]\n"
                + "      ,[DiaChi]\n"
                + "      ,[DiemTichLuy]\n"
                + "      ,[MatKhau]\n"
                + "      ,[TrangThai]\n"
                + "  FROM [dbo].[KhachHang] where ma=?";
        KhachHang kh = new KhachHang();

        try (Connection con = DBConnection.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setObject(1, ma);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                kh.setId(rs.getString("Id"));
                kh.setMa(rs.getString("Ma"));
                kh.setTen(rs.getString("Ten"));
                kh.setNgaySinh(rs.getDate("NgaySinh"));
                kh.setGioiTinh(rs.getInt("GioiTinh"));
                kh.setEmail(rs.getString("Email"));
                kh.setSdt(rs.getString("Sdt"));
                kh.setDiaChi(rs.getString("DiaChi"));
                kh.setDiemTichLuy(rs.getInt("DiemTichLuy"));
                kh.setMatKhau(rs.getString("MatKhau"));
                kh.setTrangThai(rs.getInt("TrangThai"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return kh;
    }

    public KhachHang getKhachHangById(String id) {
        String sql = "SELECT [Id]\n"
                + "      ,[Ma]\n"
                + "      ,[Ten]\n"
                + "      ,[NgaySinh]\n"
                + "      ,[GioiTinh]\n"
                + "      ,[Email]\n"
                + "      ,[Sdt]\n"
                + "      ,[DiaChi]\n"
                + "      ,[DiemTichLuy]\n"
                + "      ,[MatKhau]\n"
                + "      ,[TrangThai]\n"
                + "  FROM [dbo].[KhachHang] where id=?";
        KhachHang kh = new KhachHang();

        try (Connection con = DBConnection.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setObject(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                kh.setId(rs.getString("Id"));
                kh.setMa(rs.getString("Ma"));
                kh.setTen(rs.getString("Ten"));
                kh.setNgaySinh(rs.getDate("NgaySinh"));
                kh.setGioiTinh(rs.getInt("GioiTinh"));
                kh.setEmail(rs.getString("Email"));
                kh.setSdt(rs.getString("Sdt"));
                kh.setDiaChi(rs.getString("DiaChi"));
                kh.setDiemTichLuy(rs.getInt("DiemTichLuy"));
                kh.setMatKhau(rs.getString("MatKhau"));
                kh.setTrangThai(rs.getInt("TrangThai"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return kh;
    }

    public boolean insertKhachHang(KhachHang m) {
        String sql = "INSERT INTO [dbo].[KhachHang]\n"
                + "           ([Ma]\n"
                + "           ,[Ten]\n"
                + "           ,[NgaySinh]\n"
                + "           ,[GioiTinh]\n"
                + "           ,[Email]\n"
                + "           ,[Sdt]\n"
                + "           ,[DiaChi]\n"
                + "           ,[DiemTichLuy]\n"
                + "           ,[MatKhau]\n"
                + "           ,[TrangThai])\n"
                + "     VALUES(?,?,?,?,?,?,?,?,?,?)";

        KhachHang c = getKhachHangByMa(m.getMa());
        if (c.getMa() != null) {
            JOptionPane.showMessageDialog(null, "ma sp ton tai");
            return false;
        }

        return JDBC_helper.updateTong(sql, m.getMa(), m.getTen(),
                 m.getNgaySinh(), m.getGioiTinh(), m.getEmail(), m.getSdt(), m.getDiaChi(),
                 m.getDiemTichLuy(), m.getMatKhau(), m.getTrangThai()) > 0;
    }

    public boolean updateKhachHang(KhachHang m) {
        String sql = "UPDATE [dbo].[KhachHang]\n"
                + "   SET [Ten] = ?\n"
                + "      ,[NgaySinh] = ?\n"
                + "      ,[GioiTinh] =?\n"
                + "      ,[Email] = ?\n"
                + "      ,[Sdt] = ?\n"
                + "      ,[DiaChi] = ?\n"
                + "      ,[DiemTichLuy] = ?\n"
                + "      ,[MatKhau] = ?\n"
                + "      ,[TrangThai] = ?\n"
                + " WHERE ma=?";
        return JDBC_helper.updateTong(sql, m.getTen(), m.getNgaySinh(),
                m.getGioiTinh(), m.getEmail(), m.getSdt(), m.getDiaChi(),
                m.getDiemTichLuy(), m.getMatKhau(), m.getTrangThai(),
                 m.getMa()) > 0;
    }

    public boolean deleteKhachHang(String m) {
        String sql = "delete KhachHang where ma=?";
        return JDBC_helper.updateTong(sql, m) > 0;
    }
}
