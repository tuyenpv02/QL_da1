package com.example.ass_java5.entities;

import com.example.ass_java5.request.ChiTietSPVM;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "ChiTietSP")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ChiTietSP {

    @Id
    @Column(name = "Id")
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "IdSP", referencedColumnName = "id")
    private SanPham sanPham;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "IdNsx", referencedColumnName = "id")
    private NSX nsx;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "IdMauSac", referencedColumnName = "id")
    private MauSac mauSac;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "IdDongSP", referencedColumnName = "id")
    private DongSP dongSP;

    @Column(name = "NamBH")
    private Integer namBH;

    @Column(name = "MoTa")
    private String moTa;

    @Column(name = "SoLuongTon")
    private Integer soLuongTon;

    @Column(name = "GiaNhap")
    private Double giaNhap;

    @Column(name = "GiaBan")
    private Double giaBan;

    @OneToMany(mappedBy = "chiTietSP")
    List<HoaDonChiTiet> hoaDonChiTiets;

    public void loadChiTietSPViewModel(ChiTietSPVM chiTietSPVM){
        this.setMauSac(chiTietSPVM.getMauSac());
        this.setSanPham(chiTietSPVM.getSanPham());
        this.setDongSP(chiTietSPVM.getDongSP());
        this.setNsx(chiTietSPVM.getNsx());

        this.setNamBH(chiTietSPVM.getNamBH());
        this.setMoTa(chiTietSPVM.getMoTa());
        this.setSoLuongTon(chiTietSPVM.getSoLuongTon());
        this.setGiaNhap(chiTietSPVM.getGiaNhap());
        this.setGiaBan(chiTietSPVM.getGiaBan());
    }

}
