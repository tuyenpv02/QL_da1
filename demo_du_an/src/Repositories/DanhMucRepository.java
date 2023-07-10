/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repositories;

import DomainModels.DanhMuc;
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
public class DanhMucRepository {
    
    public ArrayList<DanhMuc> getAll(){
        String sql ="select id,ma,ten from DanhMuc";
        ArrayList<DanhMuc> ds = new ArrayList<>();
        
        try (Connection con = DBConnection.getConnection();
                PreparedStatement ps = con.prepareCall(sql)
                ){
            ResultSet rs = ps.executeQuery();
             while (rs.next()) {
                DanhMuc m = new DanhMuc();
                m.setId(rs.getString("id"));
                m.setMa(rs.getString("ma"));
                m.setTen(rs.getString("ten"));
                ds.add(m);
            }
            
        } catch (Exception e) {
        }
        
        return ds;
    }
    
    public DanhMuc getDanhMucByMa(String ma){
         String sql = "select id,ma,ten from DanhMuc where ma=?";
        DanhMuc m = new DanhMuc();

        try (Connection con = DBConnection.getConnection();
                PreparedStatement ps = con.prepareStatement(sql)) {
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
    
     public boolean insertDanhMuc(DanhMuc m){
        String sql="insert into DanhMuc(ma,ten) values(?,?)";
        return JDBC_helper.updateTong(sql, m.getMa(),m.getTen())>0;
    }
    public boolean updateDanhMuc(DanhMuc m){
        String sql="update  DanhMuc set ten=? where ma=?";
        return JDBC_helper.updateTong(sql,m.getTen(), m.getMa())>0;
    }
    public boolean deleteDanhMuc(String m){
        String sql="delete DanhMuc where ma=?";
        return JDBC_helper.updateTong(sql,m)>0;
    }
    
}
