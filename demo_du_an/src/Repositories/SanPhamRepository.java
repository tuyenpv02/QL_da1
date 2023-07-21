/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repositories;

import DomainModels.SanPham;
import DomainModels.SanPham;
import Utilities.DBConnection;
import Utilities.JDBC_helper;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author TBC
 */
public class SanPhamRepository {

    public ArrayList<SanPham> getAll() {
        String sql = "select id,ma,ten from SanPham";
        ArrayList<SanPham> ds = new ArrayList<>();

        try (Connection con = DBConnection.getConnection(); PreparedStatement ps = con.prepareCall(sql)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                SanPham m = new SanPham();
                m.setId(rs.getString("id"));
                m.setMa(rs.getString("ma"));
                m.setTen(rs.getString("ten"));
                ds.add(m);
            }

        } catch (Exception e) {
        }

        return ds;
    }

    public SanPham getSanPhamByMa(String ma) {
        String sql = "select id,ma,ten from SanPham where ma=?";
        SanPham m = new SanPham();

        try (Connection con = DBConnection.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setObject(1, ma);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                m.setId(rs.getString("id"));
                m.setMa(rs.getString("ma"));
                m.setTen(rs.getString("ten"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return m;
    }

    public boolean insertSanPham(SanPham m) {
        String sql = "insert into SanPham(ma,ten) values(?,?)";
        return JDBC_helper.updateTong(sql, m.getMa(), m.getTen()) > 0;
    }

    public boolean updateSanPham(SanPham m) {
        String sql = "update  SanPham set ten=? where ma=?";
        return JDBC_helper.updateTong(sql, m.getTen(), m.getMa()) > 0;
    }

    public boolean deleteSanPham(String m) {
        String sql = "delete SanPham where ma=?";
        return JDBC_helper.updateTong(sql, m) > 0;
    }

}
