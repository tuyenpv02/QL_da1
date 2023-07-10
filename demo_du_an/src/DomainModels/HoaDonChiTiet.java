/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DomainModels;

/**
 *
 * @author tuyenPham
 */
public class HoaDonChiTiet {
    private ChiTietSP idCHiTietSP;
    private HoaDon idHoaDon;
    private int soLuong;
    private double donGia;

    public HoaDonChiTiet() {
    }

    public HoaDonChiTiet(ChiTietSP idCHiTietSP, HoaDon idHoaDon, int soLuong, double donGia) {
        this.idCHiTietSP = idCHiTietSP;
        this.idHoaDon = idHoaDon;
        this.soLuong = soLuong;
        this.donGia = donGia;
    }

    @Override
    public String toString() {
        return "HoaDonChiTiet{" + "idCHiTietSP=" + idCHiTietSP + ", idHoaDon=" + idHoaDon + ", soLuong=" + soLuong + ", donGia=" + donGia + '}';
    }

    public ChiTietSP getIdCHiTietSP() {
        return idCHiTietSP;
    }

    public void setIdCHiTietSP(ChiTietSP idCHiTietSP) {
        this.idCHiTietSP = idCHiTietSP;
    }

    public HoaDon getIdHoaDon() {
        return idHoaDon;
    }

    public void setIdHoaDon(HoaDon idHoaDon) {
        this.idHoaDon = idHoaDon;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public double getDonGia() {
        return donGia;
    }

    public void setDonGia(double donGia) {
        this.donGia = donGia;
    }
    
}
