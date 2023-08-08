package com.example.ass_java5.entities;

import jakarta.persistence.*;
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
public class HoaDonChiTiet  {


    @Id
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "IdHoaDon", referencedColumnName = "id")
    private HoaDon hoaDon;

    @Id
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "IdChiTietSP", referencedColumnName = "id")
    private ChiTietSP chiTietSP;

    @Column(name = "SoLuong")
    private Integer soLuong;

    @Column(name = "DonGia")
    private Double donGia;
}
