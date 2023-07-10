/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Services.impl;

import DomainModels.ChucVu;
import Repositories.ChucVuRepository;
import Services.ChucVuServices;
import java.util.ArrayList;

/**
 *
 * @author TBC
 */
public class ChucVuServicesImpl implements ChucVuServices {

    ChucVuRepository chucVuRepository = new ChucVuRepository();

    @Override
    public ArrayList<ChucVu> getALl() {
        return chucVuRepository.getAll();
    }

    @Override
    public ChucVu getChucVuByMa(String ma) {
        return chucVuRepository.getChucVuByMa(ma);
    }

    @Override
    public boolean insertChucVu(ChucVu chucVu) {
        return chucVuRepository.insertChucVu(chucVu);
    }

    @Override
    public boolean updateChucVu(ChucVu chucVu) {
        return chucVuRepository.updateChucVu(chucVu);
    }

    @Override
    public boolean deleteChucVu(String chucVu) {
        return chucVuRepository.deleteChucVu(chucVu);
    }

}
