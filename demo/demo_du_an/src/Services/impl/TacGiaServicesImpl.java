/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Services.impl;

import DomainModels.TacGia;
import Repositories.TacGiaRepository;
import Services.TacGiaServices;
import java.util.ArrayList;

/**
 *
 * @author TBC
 */
public class TacGiaServicesImpl implements TacGiaServices{
    private TacGiaRepository danhMucRepository = new TacGiaRepository();

    @Override
    public ArrayList<TacGia> getAll() {
        return danhMucRepository.getAll();
    }

    @Override
    public TacGia getTacGiaByMa(String ma) {
        return danhMucRepository.getTacGiaByMa(ma);
    }

    @Override
    public boolean insertTacGia(TacGia danhMuc) {
        return danhMucRepository.insertTacGia(danhMuc);
    }

    @Override
    public boolean updateTacGia(TacGia danhMuc) {
        return danhMucRepository.updateTacGia(danhMuc);
    }

    @Override
    public boolean deleteTacGia(String danhMuc) {
        return danhMucRepository.deleteTacGia(danhMuc);
    }
    
    
    
}
