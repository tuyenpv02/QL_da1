/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utilities;

import DomainModels.HoaDon;
import DomainModels.NhanVien;
import ViewModels.HoaDonBanViewModels;
import java.sql.ResultSet;
import java.sql.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;

/**
 *
 * @author tuyenPham
 */
public class JDBC_helper {
    
    public static NhanVien nhanVienDN ;
    
     public static int getMaxHD(ArrayList<HoaDonBanViewModels> ds) {
        String maHD = "";
        ArrayList<Integer> lstMax = new ArrayList<>();
        for (HoaDonBanViewModels d : ds) {
            maHD = d.getMa().substring(2); // tra ve String con bat dau tu 2 ~'d'
            lstMax.add(Integer.parseInt(maHD));
//            System.out.println("num "+Integer.parseInt(maHD));
        }

        // sort
        Collections.sort(lstMax, (o1, o2) -> o2.compareTo(o1));
        return lstMax.get(0) + 1;
    }

    public static String IDKH = " ";

//    public static ArrayList<HoaDonReponse> sortLstHoaDon(ArrayList<HoaDonReponse> ds) {
//        ArrayList<HoaDonReponse> lst = ds;
//
//        Comparator<HoaDonReponse> c = new Comparator<HoaDonReponse>() {
//            @Override
//            public int compare(HoaDonReponse o1, HoaDonReponse o2) {
//                String d1 = o1.getMa();
//                String d2 = o2.getMa();
//                return d1.compareTo(d2);
//            }
//        };
//        Collections.sort(lst, c);
//        return lst;
//    }
//
//    public static int getMaxHD(ArrayList<HoaDonReponse> ds) {
//
//        // tach chu hoa don
//        // hd + "number ":
//        // convert(int,number) -> sort lay max
//        String maHD = "";
//        ArrayList<Integer> lstMax = new ArrayList<>();
//        for (HoaDonReponse d : ds) {
//            maHD = d.getMa().substring(2); // tra ve String con bat dau tu 2 ~'d'
//            lstMax.add(Integer.parseInt(maHD));
////            System.out.println("num "+Integer.parseInt(maHD));
//        }
//        
//        // sort 
//        Collections.sort(lstMax, (o1, o2) -> o2.compareTo(o1));
//        return lstMax.get(0);
//    }

    public static ResultSet selectTong(String sql, Object... bien) {
        PreparedStatement ps = null;
        Connection con = null;
        try {
            con = DBConnection.getConnection();
            ps = con.prepareStatement(sql);
            for (int i = 0; i < bien.length; i++) {
                ps.setObject(i + 1, bien[i]);
            }
            return ps.executeQuery();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static int updateTong(String sql, Object... bien) {
        PreparedStatement ps = null;
        Connection con = null;

        try {
            con = DBConnection.getConnection();
            ps = con.prepareStatement(sql);
            for (int i = 0; i < bien.length; i++) {
                ps.setObject(i + 1, bien[i]);
            }
            return ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }
}
