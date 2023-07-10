/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Services.impl;

import Repositories.ThongKeRepository;
import Services.ThongKeServices;
import ViewModels.SachViewModels;
import ViewModels.ThongKeNamViewModels;
import ViewModels.ThongKeSPBanChayViewModels;
import ViewModels.ThongKeThangViewModels;
import java.util.ArrayList;

/**
 *
 * @author TBC
 */
public class ThongKeServicesImpl implements ThongKeServices {
    
    private ThongKeRepository thongKeRepository = new ThongKeRepository();
    
    @Override
    public ThongKeThangViewModels getHDTheoNgay(int nam, int thang, int ngay) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    @Override
    public ThongKeThangViewModels getHDTheoThang(int nam, int thang, int ngay) {
        return thongKeRepository.getHDTheoThang(nam, thang, ngay);
    }
    
    @Override
    public ThongKeThangViewModels getHDTheoNam(int nam, int thang, int ngay) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    @Override
    public ArrayList<ThongKeNamViewModels> getDoanhThuCacNam() {
        return thongKeRepository.getDoanhThuCacNam();
    }
    
    @Override
    public int getTongSachSapHet() {
        return thongKeRepository.getTongSachSapHet();
    }
    
    @Override
    public int getTongSachDaHet() {
        return thongKeRepository.getTongSachHetHang();
    }
    
    @Override
    public int getTongSachTheoTinhTrang(int tinhTrang) {
        return thongKeRepository.getTongSachTheoTinhTrang(tinhTrang);
    }
    
    @Override
    public ArrayList<SachViewModels> getAllSach() {
        return thongKeRepository.getAllSach();
    }
    
    @Override
    public ArrayList<SachViewModels> getAllSachSapHet() {
        return thongKeRepository.getAllSachSapHet();
    }
    
    @Override
    public ArrayList<SachViewModels> getAllSachHetHang() {
        return thongKeRepository.getAllSachHetHang();
    }
    
    @Override
    public ArrayList<SachViewModels> getAllSachByTrangThai(int tinhTrang) {
        return thongKeRepository.getAllSachByTrangThai(tinhTrang);
    }
    
    @Override
    public ArrayList<ThongKeSPBanChayViewModels> getSPBanChay(String sapXep) {
                return thongKeRepository.getSPBanChay(sapXep);

    }
    
    @Override
    public ArrayList<ThongKeSPBanChayViewModels> getSPBanNhieuTien(String sapXep) {
         return thongKeRepository.getSPBanNhieuTien(sapXep);
    }
    
}
