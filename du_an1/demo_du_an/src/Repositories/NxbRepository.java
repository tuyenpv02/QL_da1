/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repositories;

import DomainModels.NXB;
import DomainModels.NXB;
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
public class NxbRepository {
    
    public ArrayList<NXB> getAll(){
        String sql ="select id,ma,ten from NXB";
        ArrayList<NXB> ds = new ArrayList<>();
        
        try (Connection con = DBConnection.getConnection();
                PreparedStatement ps = con.prepareCall(sql)
                ){
            ResultSet rs = ps.executeQuery();
             while (rs.next()) {
                NXB m = new NXB();
                m.setId(rs.getString("id"));
                m.setMa(rs.getString("ma"));
                m.setTen(rs.getString("ten"));
                ds.add(m);
            }
            
        } catch (Exception e) {
        }
        
        return ds;
    }
    
    public NXB getNXBByMa(String ma){
         String sql = "select id,ma,ten from NXB where ma=?";
        NXB m = new NXB();

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
    
     public boolean insertNXB(NXB m){
        String sql="insert into NXB(ma,ten) values(?,?)";
        return JDBC_helper.updateTong(sql, m.getMa(),m.getTen())>0;
    }
    public boolean updateNXB(NXB m){
        String sql="update  NXB set ten=? where ma=?";
        return JDBC_helper.updateTong(sql,m.getTen(), m.getMa())>0;
    }
    public boolean deleteNXB(String m){
        String sql="delete NXB where ma=?";
        return JDBC_helper.updateTong(sql,m)>0;
    }
    
}
