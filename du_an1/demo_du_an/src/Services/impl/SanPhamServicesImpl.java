
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Services.impl;

import DomainModels.SanPham;
import Repositories.SanPhamRepository;
import Services.SanPhamServices;
import java.util.ArrayList;

/**
 *
 * @author TBC
 */
public class SanPhamServicesImpl implements SanPhamServices{
    private SanPhamRepository danhMucRepository = new SanPhamRepository();

    @Override
    public ArrayList<SanPham> getAll() {
        return danhMucRepository.getAll();
    }

    @Override
    public SanPham getSanPhamByMa(String ma) {
        return danhMucRepository.getSanPhamByMa(ma);
    }

    @Override
    public boolean insertSanPham(SanPham danhMuc) {
        return danhMucRepository.insertSanPham(danhMuc);
    }

    @Override
    public boolean updateSanPham(SanPham danhMuc) {
        return danhMucRepository.updateSanPham(danhMuc);
    }

    @Override
    public boolean deleteSanPham(String danhMuc) {
        return danhMucRepository.deleteSanPham(danhMuc);
    }
    
    
    
}
