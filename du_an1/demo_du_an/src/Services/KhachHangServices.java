/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Services;

import DomainModels.KhachHang;
import ViewModels.NhanVienViewModels;
import java.util.ArrayList;

/**
 *
 * @author TBC
 */
public interface KhachHangServices {
     ArrayList<KhachHang> getALL();
    ArrayList<KhachHang> timKiem(String txt);
     
    KhachHang getKhachHangMa(String ma);
    KhachHang getKhachHangId(String id);
    
    boolean insertKhachHang(KhachHang c);
    boolean updatetKhachHang(KhachHang c);
    boolean deleteKhachHang(String ma);
}
