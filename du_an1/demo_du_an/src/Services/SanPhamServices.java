/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Services;

import DomainModels.SanPham;
import DomainModels.SanPham;
import java.util.ArrayList;

/**
 *
 * @author TBC
 */
public interface SanPhamServices {

    ArrayList<SanPham> getAll();

    SanPham getSanPhamByMa(String ma);

    boolean insertSanPham(SanPham danhMuc);

    boolean updateSanPham(SanPham danhMuc);

    boolean deleteSanPham(String danhMuc);
}
