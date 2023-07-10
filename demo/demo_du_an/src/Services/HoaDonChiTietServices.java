/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Services;

import DomainModels.HoaDonChiTiet;
import ViewModels.HoaDonChiTietViewModels;
import java.util.ArrayList;

/**
 *
 * @author TBC
 */
public interface HoaDonChiTietServices {
    ArrayList<HoaDonChiTietViewModels> getHDCTByMa(String ma);
    
     boolean insertHoaDonCT(HoaDonChiTiet c);
    boolean updateHoaDonCT(HoaDonChiTiet c);
    
    boolean deleteHoaDonCT(String idHD, String idChiTietSP);
}
