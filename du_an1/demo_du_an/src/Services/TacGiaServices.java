/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Services;

import DomainModels.TacGia;
import java.util.ArrayList;

/**
 *
 * @author TBC
 */
public interface TacGiaServices {
    ArrayList<TacGia> getAll();
    
    TacGia getTacGiaByMa(String ma);
    
    boolean insertTacGia(TacGia danhMuc); 
    boolean updateTacGia(TacGia danhMuc); 
    boolean deleteTacGia(String danhMuc); 
}
