/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Services.impl;

import DomainModels.HoaDonChiTiet;
import Repositories.HoaDonChiTietRepository;
import Services.HoaDonChiTietServices;
import ViewModels.HoaDonChiTietViewModels;
import java.util.ArrayList;

/**
 *
 * @author TBC
 */
public class HoaDonChiTietServicseImpl implements HoaDonChiTietServices{

    private HoaDonChiTietRepository hoaDonChiTietRepository = new HoaDonChiTietRepository();
   
    @Override
    public boolean insertHoaDonCT(HoaDonChiTiet c) {
         HoaDonChiTiet g = hoaDonChiTietRepository.getHDCTByID(c.getIdHoaDon().getId(), c.getIdCHiTietSP().getId());
        if (g.getIdHoaDon()!= null) {
            c.setSoLuong(c.getSoLuong() + g.getSoLuong());
            return hoaDonChiTietRepository.updateSLHoaDonCT(c);
        }

        return hoaDonChiTietRepository.inserHoaDonCT(c);
    }

    @Override
    public boolean updateHoaDonCT(HoaDonChiTiet c) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean deleteHoaDonCT(String idHD, String idChiTietSP) {
        return hoaDonChiTietRepository.deleteGHCT(idHD, idChiTietSP);
    }

    @Override
    public ArrayList<HoaDonChiTietViewModels> getHDCTByMa(String ma) {
        return hoaDonChiTietRepository.getHDCTByMaHD(ma);
    }
    
}
