/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repositories;

import DomainModels.ChucVu;
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
public class ChucVuRepository {
    
    public ArrayList<ChucVu> getAll(){
        String sql ="select id,ma,ten,vaiTro from ChucVu";
        ArrayList<ChucVu> ds = new ArrayList<>();
        
        try (Connection con = DBConnection.getConnection();
                PreparedStatement ps = con.prepareCall(sql)
                ){
            ResultSet rs = ps.executeQuery();
             while (rs.next()) {
                ChucVu m = new ChucVu();
                m.setId(rs.getString("id"));
                m.setMa(rs.getString("ma"));
                m.setTen(rs.getString("ten"));
                m.setVaiTro(rs.getInt("vaiTro"));
                ds.add(m);
            }
            
        } catch (Exception e) {
        }
        
        return ds;
    }
    
    public ChucVu getChucVuByMa(String ma){
         String sql = "select id,ma,ten,vaiTro from ChucVu where ma=?";
        ChucVu m = new ChucVu();

        try (Connection con = DBConnection.getConnection();
                PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setObject(1, ma);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                m.setId(rs.getString("id"));
                m.setMa(rs.getString("ma"));
                m.setTen(rs.getString("ten"));
                m.setVaiTro(rs.getInt("vaiTro"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return m;
    }
    
     public boolean insertChucVu(ChucVu m){
        String sql="insert into ChucVu(ma,ten,vaiTro) values(?,?,?)";
        return JDBC_helper.updateTong(sql, m.getMa(),m.getTen(),m.getVaiTro())>0;
    }
    public boolean updateChucVu(ChucVu m){
        String sql="update ChucVu set ten=?, vaiTro=? where ma=?";
        return JDBC_helper.updateTong(sql,m.getTen(), m.getVaiTro(), m.getMa())>0;
    }
    public boolean deleteChucVu(String m){
        String sql="delete ChucVu where ma=?";
        return JDBC_helper.updateTong(sql,m)>0;
    }
    
}
