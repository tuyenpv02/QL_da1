package com.example.ass_java5.entities;


import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "HoaDonChiTiet")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class HDCT  {

    @EmbeddedId
    private HoaDonChiTietID id;
//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "IdHoaDon", referencedColumnName = "id")
//    private HoaDon hoaDon;
//
//    @Id
//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "IdChiTietSP", referencedColumnName = "id")
//    private ChiTietSP chiTietSP;

    @Column(name = "SoLuong")
    private Integer soLuong;

    @Column(name = "DonGia")
    private Double donGia;
}