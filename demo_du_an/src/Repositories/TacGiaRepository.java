/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repositories;

import DomainModels.TacGia;
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
public class TacGiaRepository {

    public ArrayList<TacGia> getAll() {
        String sql = "select id,ma,ten from TacGia";
        ArrayList<TacGia> ds = new ArrayList<>();

        try (Connection con = DBConnection.getConnection(); PreparedStatement ps = con.prepareCall(sql)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                TacGia m = new TacGia();
                m.setId(rs.getString("id"));
                m.setMa(rs.getString("ma"));
                m.setTen(rs.getString("ten"));
                ds.add(m);
            }

        } catch (Exception e) {
        }

        return ds;
    }

    public TacGia getTacGiaByMa(String ma) {
        String sql = "select id,ma,ten from TacGia where ma=?";
        TacGia m = new TacGia();

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

    public boolean insertTacGia(TacGia m) {
        String sql = "insert into TacGia(ma,ten) values(?,?)";
        return JDBC_helper.updateTong(sql, m.getMa(), m.getTen()) > 0;
    }

    public boolean updateTacGia(TacGia m) {
        String sql = "update  TacGia set ten=? where ma=?";
        return JDBC_helper.updateTong(sql, m.getTen(), m.getMa()) > 0;
    }

    public boolean deleteTacGia(String m) {
        String sql = "delete TacGia where ma=?";
        return JDBC_helper.updateTong(sql, m) > 0;
    }

}
