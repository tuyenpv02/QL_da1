/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Services.impl;

import DomainModels.DanhMuc;
import Repositories.DanhMucRepository;
import Services.DanhMucServices;
import java.util.ArrayList;

/**
 *
 * @author TBC
 */
public class DanhMucServicesImpl implements DanhMucServices{
    private DanhMucRepository danhMucRepository = new DanhMucRepository();

    @Override
    public ArrayList<DanhMuc> getAll() {
        return danhMucRepository.getAll();
    }

    @Override
    public DanhMuc getDanhMucByMa(String ma) {
        return danhMucRepository.getDanhMucByMa(ma);
    }

    @Override
    public boolean insertDanhMuc(DanhMuc danhMuc) {
        return danhMucRepository.insertDanhMuc(danhMuc);
    }

    @Override
    public boolean updateDanhMuc(DanhMuc danhMuc) {
        return danhMucRepository.updateDanhMuc(danhMuc);
    }

    @Override
    public boolean deleteDanhMuc(String danhMuc) {
        return danhMucRepository.deleteDanhMuc(danhMuc);
    }
    
    
    
}
