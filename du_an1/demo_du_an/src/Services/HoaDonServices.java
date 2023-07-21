/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Services;

import DomainModels.HoaDon;
import ViewModels.HoaDonBanViewModels;
import ViewModels.HoaDonHDCTViewModels;
import ViewModels.HoaDonViewModels;
import java.util.ArrayList;

/**
 *
 * @author TBC
 */
public interface HoaDonServices {

    // view ban hang
    ArrayList<HoaDonBanViewModels> getALLBanHang();

    ArrayList<HoaDonBanViewModels> getALLByTrangThai(int tinhTrang);

    HoaDon getHDByMa(String ma);

    boolean insertHoaDonNull(HoaDonBanViewModels d);

    boolean updateHoaDonTinhTrang(HoaDon d);

    boolean updateHDKhach(HoaDon d);

    // view hoa don
    ArrayList<HoaDonViewModels> getAllHoaDon();

    ArrayList<HoaDonViewModels> timKiemHoaDon(String txt);

    ArrayList<HoaDonViewModels> locTrangThai(int txt);

    ArrayList<HoaDonHDCTViewModels> getHDCTByMaHD(String ma);

}
