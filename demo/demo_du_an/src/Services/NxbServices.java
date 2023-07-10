/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Services;

import DomainModels.NXB;
import DomainModels.NXB;
import java.util.ArrayList;

/**
 *
 * @author TBC
 */
public interface NxbServices {
    ArrayList<NXB> getAll();
    
    NXB getNXBByMa(String ma);
    
    boolean insertNXB(NXB danhMuc); 
    boolean updateNXB(NXB danhMuc); 
    boolean deleteNXB(String danhMuc); 
}
