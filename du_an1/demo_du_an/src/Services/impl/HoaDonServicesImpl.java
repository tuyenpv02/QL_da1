/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Services.impl;

import DomainModels.HoaDon;
import Repositories.HoaDonRepository;
import Services.HoaDonServices;
import ViewModels.HoaDonBanViewModels;
import ViewModels.HoaDonHDCTViewModels;
import ViewModels.HoaDonViewModels;
import java.util.ArrayList;

/**
 *
 * @author TBC
 */
public class HoaDonServicesImpl implements HoaDonServices{

    private HoaDonRepository hoaDonRepository = new HoaDonRepository();


    @Override
    public HoaDon getHDByMa(String ma) {
        return hoaDonRepository.getHDByMa(ma);
    }

    @Override
    public boolean insertHoaDonNull(HoaDonBanViewModels d) {
        return hoaDonRepository.insertHD(d);
    }


    @Override
    public ArrayList<HoaDonBanViewModels> getALLBanHang() {
        return hoaDonRepository.getALLHoaDonBan();
    }

    @Override
    public boolean updateHoaDonTinhTrang(HoaDon d) {
        return hoaDonRepository.updateHoaDon(d);
    }

    @Override
    public ArrayList<HoaDonBanViewModels> getALLByTrangThai(int trangThai) {
        return hoaDonRepository.getHoaDonBanByTrangThai(trangThai);
    }

    @Override
    public boolean updateHDKhach(HoaDon d) {
        return hoaDonRepository.updateHDKhach(d);
    }

    @Override
    public ArrayList<HoaDonViewModels> getAllHoaDon() {
        return hoaDonRepository.getALLHoaDon();
    }

    @Override
    public ArrayList<HoaDonHDCTViewModels> getHDCTByMaHD(String ma) {
        return hoaDonRepository.getHoaDonCTByMaHD(ma);
    }

    @Override
    public ArrayList<HoaDonViewModels> timKiemHoaDon(String txt) {
                return hoaDonRepository.timKiemHoaDon(txt);
    }

    @Override
    public ArrayList<HoaDonViewModels> locTrangThai(int txt) {
        return  hoaDonRepository.locTrangThai(txt);
    }
    
    
    
}
