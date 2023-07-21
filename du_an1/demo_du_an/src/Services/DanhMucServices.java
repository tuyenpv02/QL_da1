/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Services;

import DomainModels.DanhMuc;
import java.util.ArrayList;

/**
 *
 * @author TBC
 */
public interface DanhMucServices {

    ArrayList<DanhMuc> getAll();

    DanhMuc getDanhMucByMa(String ma);

    boolean insertDanhMuc(DanhMuc danhMuc);

    boolean updateDanhMuc(DanhMuc danhMuc);

    boolean deleteDanhMuc(String danhMuc);
}
