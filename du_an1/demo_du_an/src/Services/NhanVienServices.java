/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Services;

import DomainModels.NhanVien;
import ViewModels.NhanVienViewModels;
import java.util.ArrayList;

/**
 *
 * @author TBC
 */
public interface NhanVienServices {

    ArrayList<NhanVienViewModels> getALL();

    ArrayList<NhanVienViewModels> timKiem(String txt);

    NhanVien getNhanVienByMa(String ma);

    boolean insertNhanVien(NhanVien c);

    boolean updatetNhanVien(NhanVien c);

    boolean deleteNhanVien(String ma);

    boolean dangKy(NhanVien c);

}
