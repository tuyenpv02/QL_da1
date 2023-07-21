/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Services;

import DomainModels.ChiTietSP;
import ViewModels.CTSPViewModels;
import java.util.ArrayList;

/**
 *
 * @author TBC
 */
public interface CTSPServices {

    ArrayList<CTSPViewModels> getALL();

    ArrayList<CTSPViewModels> timKiem(String txt);

    ArrayList<CTSPViewModels> locDanhMuc(String txt);

    ArrayList<CTSPViewModels> locTacGia(String txt);

    ArrayList<CTSPViewModels> locTrangThai(int txt);

    CTSPViewModels getCTSPByMa(String ma);

    ChiTietSP getIdCTSP(String ma);

    boolean insertCTSP(ChiTietSP c);

    boolean updatetCTSP(ChiTietSP c);

    boolean deleteCTSP(String ma);

    boolean updateSoLuong(ChiTietSP c);
}
