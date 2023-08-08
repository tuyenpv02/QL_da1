package com.example.ass_java5.request;

import com.example.ass_java5.entities.*;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ChiTietSPVM {

    private SanPham sanPham;

    private NSX nsx;

    private MauSac mauSac;

    private DongSP dongSP;

    @NotNull
    private int namBH;

    @NotNull
    private String moTa;

    @NotNull
    private int soLuongTon;

    @NotNull
    private double giaNhap;

    @DecimalMin("10.0")
    private double giaBan;


    public void loadChiTietSPDomainModel(ChiTietSP chiTietSP){
        this.setMauSac(chiTietSP.getMauSac());
        this.setSanPham(chiTietSP.getSanPham());
        this.setDongSP(chiTietSP.getDongSP());
        this.setNsx(chiTietSP.getNsx());

        this.setNamBH(chiTietSP.getNamBH());
        this.setMoTa(chiTietSP.getMoTa());
        this.setSoLuongTon(chiTietSP.getSoLuongTon());
        this.setGiaNhap(chiTietSP.getGiaNhap());
        this.setGiaBan(chiTietSP.getGiaBan());
    }

}
