/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Services;

import ViewModels.SachViewModels;
import ViewModels.ThongKeNamViewModels;
import ViewModels.ThongKeSPBanChayViewModels;
import ViewModels.ThongKeThangViewModels;
import java.util.ArrayList;

/**
 *
 * @author TBC
 */
public interface ThongKeServices {

    // MÀN BÁO CÁO : 3 Ô DOANH THU ; BẢNG DOANH THU CÁC NĂM
    // doanh thu ô ngày tháng nam
    ThongKeThangViewModels getHDTheoNgay(int nam, int thang, int ngay);

    ThongKeThangViewModels getHDTheoThang(int nam, int thang, int ngay);

    ThongKeThangViewModels getHDTheoNam(int nam, int thang, int ngay);

    //LOAD BẢNG DOANH THU CÁC NĂM
    ArrayList<ThongKeNamViewModels> getDoanhThuCacNam();

    // MÀN SẢN PHẨM
    // lấy ra số lượng trạng thái sách vào ô sản phẩm: đag, ngưng, sắp hết, hết
    int getTongSachSapHet();

    int getTongSachDaHet();

    int getTongSachTheoTinhTrang(int tinhTrang);

    // lấy ra danh sách sách để load lên table
    ArrayList<SachViewModels> getAllSach();

    ArrayList<SachViewModels> getAllSachSapHet();

    ArrayList<SachViewModels> getAllSachHetHang();

    ArrayList<SachViewModels> getAllSachByTrangThai(int tinhTrang);

    //load sách bán theo : bán chay, thành tiền nhiều ít
    ArrayList<ThongKeSPBanChayViewModels> getSPBanChay(String sapXep);

    ArrayList<ThongKeSPBanChayViewModels> getSPBanNhieuTien(String sapXep);

//    ArrayList<ThongKeTheoNamViewModels> getDoanhThuCacNam();
}
