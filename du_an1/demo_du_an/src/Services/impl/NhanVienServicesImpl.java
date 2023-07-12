/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Services.impl;

import DomainModels.NhanVien;
import Repositories.NhanVienRepository;
import Services.NhanVienServices;
import ViewModels.NhanVienViewModels;
import java.util.ArrayList;

/**
 *
 * @author TBC
 */
public class NhanVienServicesImpl implements NhanVienServices{

    NhanVienRepository nhanVienRepository = new NhanVienRepository();
    
    @Override
    public ArrayList<NhanVienViewModels> getALL() {
        return nhanVienRepository.getAll();
    }

    @Override
    public boolean insertNhanVien(NhanVien c) {
        return nhanVienRepository.insertNhanVien(c);
    }

    @Override
    public boolean updatetNhanVien(NhanVien c) {
        return nhanVienRepository.updateNhanVien(c);
    }

    @Override
    public boolean deleteNhanVien(String ma) {
        return nhanVienRepository.deleteNhanVien(ma);
    }

    @Override
    public ArrayList<NhanVienViewModels> timKiem(String txt) {
        return nhanVienRepository.timKiem(txt);
    }

    @Override
    public NhanVien getNhanVienByMa(String ma) {
                return  nhanVienRepository.getNhanVienByMa(ma);

    }

    @Override
    public boolean dangKy(NhanVien c) {
        return nhanVienRepository.dangKy(c);
    }
    
}
