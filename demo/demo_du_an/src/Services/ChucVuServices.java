/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Services;

import DomainModels.ChucVu;
import java.util.ArrayList;

/**
 *
 * @author TBC
 */
public interface ChucVuServices {
    
    ArrayList<ChucVu> getALl();
    
    ChucVu getChucVuByMa(String ma);
    
    boolean insertChucVu(ChucVu chucVu);
    boolean updateChucVu(ChucVu chucVu);
    boolean deleteChucVu(String chucVu);
    
}
