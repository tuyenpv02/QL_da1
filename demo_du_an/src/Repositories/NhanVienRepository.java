/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repositories;

import DomainModels.ChucVu;
import DomainModels.NhanVien;
import Utilities.DBConnection;
import Utilities.JDBC_helper;
import ViewModels.NhanVienViewModels;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author TBC
 */
public class NhanVienRepository {

    public static void main(String[] args) {

    }

    public ArrayList<NhanVienViewModels> getAll() {
        ArrayList<NhanVienViewModels> ds = new ArrayList<>();
        String sql = "SELECT NhanVien.[Ma]\n"
                + "      ,NhanVien.[Ten]\n"
                + "	  ,ChucVu.Ten as 'tencv' \n"
                + "      ,[GioiTinh]\n"
                + "      ,[NgaySinh]\n"
                + "      ,[DiaChi]\n"
                + "      ,[Sdt]\n"
                + "      ,[AnhDaiDien]\n"
                + "      ,[Email]\n"
                + "      ,[MatKhau]\n"
                + "      ,[TrangThai]\n"
                + "  FROM [dbo].[NhanVien] left JOIN ChucVu ON NhanVien.IdCV=ChucVu.ID";
        try (Connection con = DBConnection.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                NhanVienViewModels ct = new NhanVienViewModels();
                ct.setMa(rs.getString("ma"));
                ct.setTen(rs.getString("ten"));
                ct.setChucVu(rs.getString("tencv"));
                ct.setGioiTinh(rs.getInt("GioiTinh"));
                ct.setNgaySinh(rs.getDate("NgaySinh"));
                ct.setDiaChi(rs.getString("DiaChi"));
                ct.setAnhDaiDien(rs.getString("AnhDaiDien"));
                ct.setSdt(rs.getString("Sdt"));
                ct.setEmail(rs.getString("Email"));
                ct.setAnhDaiDien(rs.getString("AnhDaiDien"));
                ct.setMatKhau(rs.getString("MatKhau"));
                ct.setTrangThai(rs.getInt("TrangThai"));
                ds.add(ct);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ds;
    }

    public ArrayList<NhanVienViewModels> timKiem(String txt) {
        ArrayList<NhanVienViewModels> ds = new ArrayList<>();
        String sql = "SELECT NhanVien.[Ma]\n"
                + "      ,NhanVien.[Ten]\n"
                + "	  ,ChucVu.Ten as 'tencv'\n"
                + "      ,[GioiTinh]\n"
                + "      ,[NgaySinh]\n"
                + "      ,[DiaChi]\n"
                + "      ,[Sdt]\n"
                + "      ,[AnhDaiDien]\n"
                + "      ,[Email]\n"
                + "      ,[MatKhau]\n"
                + "      ,[IdCV]\n"
                + "      ,[TrangThai]\n"
                + "  FROM [dbo].[NhanVien] left JOIN ChucVu ON NhanVien.IdCV=ChucVu.ID\n"
                + "  where  CONCAT(NhanVien.Ten, NhanVien.DiaChi, NhanVien.Ma) like ?";
        try (Connection con = DBConnection.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setObject(1, "%" + txt + "%");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                NhanVienViewModels ct = new NhanVienViewModels();
                ct.setMa(rs.getString("ma"));
                ct.setTen(rs.getString("ten"));
                ct.setChucVu(rs.getString("tencv"));
                ct.setGioiTinh(rs.getInt("GioiTinh"));
                ct.setNgaySinh(rs.getDate("NgaySinh"));
                ct.setDiaChi(rs.getString("DiaChi"));
                ct.setAnhDaiDien(rs.getString("AnhDaiDien"));
                ct.setSdt(rs.getString("Sdt"));
                ct.setAnhDaiDien(rs.getString("AnhDaiDien"));
                ct.setEmail(rs.getString("Email"));
                ct.setMatKhau(rs.getString("MatKhau"));
                ct.setTrangThai(rs.getInt("TrangThai"));
                ds.add(ct);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ds;
    }

    public NhanVien getNhanVienByMa(String ma) {
        NhanVien ct = new NhanVien();

        String sql = "SELECT NhanVien.[id] "
                + "       ,NhanVien.[Ma]\n"
                + "      ,NhanVien.[Ten]\n"
                + "	  ,ChucVu.Ma as 'macv' \n"
                + "	  ,ChucVu.Ten as 'tencv' \n"
                + "	  ,ChucVu.VaiTro as 'vaitro' \n"
                + "      ,[GioiTinh]\n"
                + "      ,[NgaySinh]\n"
                + "      ,[DiaChi]\n"
                + "      ,[Sdt]\n"
                + "      ,[AnhDaiDien]\n"
                + "      ,[Email]\n"
                + "      ,[MatKhau]\n"
                + "      ,[TrangThai]\n"
                + "  FROM [dbo].[NhanVien] left JOIN ChucVu ON NhanVien.IdCV=ChucVu.ID"
                + " where NhanVien.[Ma] = ?";
        try (Connection con = DBConnection.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setObject(1, ma);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                ct.setId(rs.getString("id"));
                ct.setMa(rs.getString("ma"));
                ct.setTen(rs.getString("ten"));

                ChucVu chucVu = new ChucVu();
                chucVu.setMa(rs.getString("macv"));
                chucVu.setTen(rs.getString("tencv"));
                chucVu.setVaiTro(rs.getInt("vaitro"));

                ct.setIdChucVu(chucVu);
                ct.setGioiTinh(rs.getInt("GioiTinh"));
                ct.setNgaySinh(rs.getDate("NgaySinh"));
                ct.setDiaChi(rs.getString("DiaChi"));
                ct.setAnhDaiDien(rs.getString("AnhDaiDien"));
                ct.setSdt(rs.getString("Sdt"));
                ct.setAnhDaiDien(rs.getString("AnhDaiDien"));
                ct.setEmail(rs.getString("Email"));
                ct.setMatKhau(rs.getString("MatKhau"));
                ct.setTrangThai(rs.getInt("TrangThai"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ct;
    }

    public boolean insertNhanVien(NhanVien nv) {
        String sql = "INSERT INTO [dbo].[NhanVien]\n"
                + "           ([Ma]\n"
                + "           ,[Ten]\n"
                + "           ,[GioiTinh]\n"
                + "           ,[NgaySinh]\n"
                + "           ,[DiaChi]\n"
                + "           ,[Sdt]\n"
                + "           ,[Email]\n"
                + "           ,[AnhDaiDien]\n"
                + "           ,[MatKhau]\n"
                + "           ,[IdCV]\n"
                + "           ,[TrangThai])\n"
                + "     VALUES(?,?,?,?,?,?,?,?,?,?,?)";
        NhanVien c = getNhanVienByMa(nv.getMa());
        if (c.getMa() != null) {
            JOptionPane.showMessageDialog(null, "ma sp ton tai");
            return false;
        }
        return JDBC_helper.updateTong(sql,
                nv.getMa(), nv.getTen(), nv.getGioiTinh(), nv.getNgaySinh(),
                nv.getDiaChi(), nv.getSdt(), nv.getEmail(), nv.getAnhDaiDien(),
                 nv.getMatKhau(), nv.getIdChucVu().getId(), nv.getTrangThai()
        ) > 0;
    }

    public boolean updateNhanVien(NhanVien n) {
        String sql = "UPDATE [dbo].[NhanVien]\n"
                + "   SET [Ten] = ?\n"
                + "      ,[GioiTinh] = ?\n"
                + "      ,[NgaySinh] = ?\n"
                + "      ,[DiaChi] = ?\n"
                + "      ,[Sdt] = ?\n"
                + "      ,[AnhDaiDien] = ?\n"
                + "      ,[Email] = ?\n"
                + "      ,[MatKhau] = ?\n"
                + "      ,[IdCV] = ?\n"
                + "      ,[TrangThai] = ?\n"
                + " WHERE Ma = ?";
        return JDBC_helper.updateTong(sql, n.getTen(), n.getGioiTinh(),
                 n.getNgaySinh(), n.getDiaChi(), n.getSdt(),
                 n.getAnhDaiDien(), n.getEmail(), n.getMatKhau(),
                 n.getIdChucVu().getId(), n.getTrangThai(),
                 n.getMa()) > 0;
    }

    public boolean deleteNhanVien(String m) {
        String sql = "DELETE FROM [dbo].[NhanVien]\n"
                + "      WHERE ma=?";
        return JDBC_helper.updateTong(sql, m) > 0;
    }

    public NhanVien dangNhap(String ma, String matKhau) {
        NhanVien ct = new NhanVien();

        String sql = "SELECT NhanVien.[id] "
                + "       ,NhanVien.[Ma]\n"
                + "      ,NhanVien.[Ten]\n"
                + "	  ,ChucVu.Ma as 'macv' \n"
                + "	  ,ChucVu.Ten as 'tencv' \n"
                + "	  ,ChucVu.VaiTro as 'vaitro' \n"
                + "      ,[GioiTinh]\n"
                + "      ,[NgaySinh]\n"
                + "      ,[DiaChi]\n"
                + "      ,[Sdt]\n"
                + "      ,[AnhDaiDien]\n"
                + "      ,[Email]\n"
                + "      ,[MatKhau]\n"
                + "      ,[TrangThai]\n"
                + "  FROM [dbo].[NhanVien] left JOIN ChucVu ON NhanVien.IdCV=ChucVu.ID"
                + " where NhanVien.[Ma] = ? and NhanVien.[matKhau] = ?";
        try (Connection con = DBConnection.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setObject(1, ma);
            ps.setObject(2, matKhau);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                ct.setId(rs.getString("id"));
                ct.setMa(rs.getString("ma"));
                ct.setTen(rs.getString("ten"));

                ChucVu chucVu = new ChucVu();
                chucVu.setMa(rs.getString("macv"));
                chucVu.setTen(rs.getString("tencv"));
                chucVu.setVaiTro(rs.getInt("vaitro"));

                ct.setIdChucVu(chucVu);
                ct.setGioiTinh(rs.getInt("GioiTinh"));
                ct.setNgaySinh(rs.getDate("NgaySinh"));
                ct.setDiaChi(rs.getString("DiaChi"));
                ct.setAnhDaiDien(rs.getString("AnhDaiDien"));
                ct.setSdt(rs.getString("Sdt"));
                ct.setAnhDaiDien(rs.getString("AnhDaiDien"));
                ct.setEmail(rs.getString("Email"));
                ct.setMatKhau(rs.getString("MatKhau"));
                ct.setTrangThai(rs.getInt("TrangThai"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ct;
    }

    public boolean dangKy(NhanVien nv) {
        String sql = "INSERT INTO [dbo].[NhanVien]\n"
                + "           ([Ma]\n"
                + "           ,[Ten]\n"
                + "           ,[GioiTinh]\n"
                + "           ,[MatKhau]\n"
                + "           ,[TrangThai])\n"
                + "     VALUES(?,?,?,?,?) ";
        NhanVien c = getNhanVienByMa(nv.getMa());
        if (c.getMa() != null) {
            JOptionPane.showMessageDialog(null, "ma sp ton tai");
            return false;
        }
        return JDBC_helper.updateTong(sql,
                nv.getMa(), nv.getTen(),
                nv.getGioiTinh(), nv.getMatKhau(),
                 nv.getTrangThai()
        ) > 0;
    }
}
