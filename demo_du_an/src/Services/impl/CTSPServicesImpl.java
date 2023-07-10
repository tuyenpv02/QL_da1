/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Services.impl;

import DomainModels.ChiTietSP;
import Repositories.CTSPRepository;
import Services.CTSPServices;
import ViewModels.CTSPViewModels;
import java.util.ArrayList;

/**
 *
 * @author TBC
 */
public class CTSPServicesImpl implements CTSPServices{
    
    CTSPRepository cTSPRepository = new CTSPRepository();

    @Override
    public ArrayList<CTSPViewModels> getALL() {
       return cTSPRepository.getALL();
    }

    @Override
    public CTSPViewModels getCTSPByMa(String ma) {
        return cTSPRepository.getCTSPByMa(ma);
    }

    @Override
    public ChiTietSP getIdCTSP(String ma) {
        return cTSPRepository.getIdCTSPByMa(ma);
    }

    @Override
    public boolean insertCTSP(ChiTietSP c) {
        return cTSPRepository.insertCTSanPham(c);
    }

    @Override
    public boolean updatetCTSP(ChiTietSP c) {
        return cTSPRepository.updateCTSanPham(c);
    }

    @Override
    public boolean deleteCTSP(String ma) {
        return cTSPRepository.deleteCTSP(ma);
    }

    @Override
    public boolean updateSoLuong(ChiTietSP c) {
        return cTSPRepository.updateSoLuong(c);
    }

    @Override
    public ArrayList<CTSPViewModels> timKiem(String txt) {
        return cTSPRepository.timKiem(txt);
    }

    @Override
    public ArrayList<CTSPViewModels> locDanhMuc(String txt) {
        return cTSPRepository.locDanhMuc(txt);
    }

    @Override
    public ArrayList<CTSPViewModels> locTacGia(String txt) {
        return cTSPRepository.locTacGia(txt);
    }

    @Override
    public ArrayList<CTSPViewModels> locTrangThai(int txt) {
        return cTSPRepository.locTrangThai(txt);
    }
    
}
