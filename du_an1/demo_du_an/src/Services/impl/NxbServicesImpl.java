/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Services.impl;

import DomainModels.NXB;
import Repositories.NxbRepository;
import Services.NxbServices;
import java.util.ArrayList;

/**
 *
 * @author TBC
 */
public class NxbServicesImpl implements NxbServices{
    private NxbRepository danhMucRepository = new NxbRepository();

    @Override
    public ArrayList<NXB> getAll() {
        return danhMucRepository.getAll();
    }

    @Override
    public NXB getNXBByMa(String ma) {
        return danhMucRepository.getNXBByMa(ma);
    }

    @Override
    public boolean insertNXB(NXB danhMuc) {
        return danhMucRepository.insertNXB(danhMuc);
    }

    @Override
    public boolean updateNXB(NXB danhMuc) {
        return danhMucRepository.updateNXB(danhMuc);
    }

    @Override
    public boolean deleteNXB(String danhMuc) {
        return danhMucRepository.deleteNXB(danhMuc);
    }
    
    
    
}
