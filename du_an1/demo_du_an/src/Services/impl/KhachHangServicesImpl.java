/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Services.impl;

import DomainModels.KhachHang;
import Repositories.KhachHangRepository;
import Services.KhachHangServices;
import ViewModels.NhanVienViewModels;
import java.util.ArrayList;

/**
 *
 * @author TBC
 */
public class KhachHangServicesImpl implements KhachHangServices{

    KhachHangRepository kh = new KhachHangRepository();
    @Override
    public ArrayList<KhachHang> getALL() {
        return  kh.getAll();
    }

    @Override
    public ArrayList<KhachHang> timKiem(String txt) {
        return  kh.timKiem(txt);
    }

    @Override
    public KhachHang getKhachHangMa(String ma) {
        return kh.getKhachHangByMa(ma);
    }

    @Override
    public boolean insertKhachHang(KhachHang c) {
        return kh.insertKhachHang(c);
    }

    @Override
    public boolean updatetKhachHang(KhachHang c) {
        return kh.updateKhachHang(c);
    }

    @Override
    public boolean deleteKhachHang(String ma) {
    return kh.deleteKhachHang(ma);
    }

    @Override
    public KhachHang getKhachHangId(String id) {
        return kh.getKhachHangById(id);
    }

  
    
}
