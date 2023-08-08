package com.example.ass_java5.entities;

import com.example.ass_java5.request.KhachHangVM;
import jakarta.persistence.*;
import lombok.*;

import java.sql.Date;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "KhachHang")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class KhachHang {

    @Id
    @Column(name = "Id")
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "Ma")
    private String ma;

    @Column(name = "Ten")
    private String ten;

    @Column(name = "TenDem")
    private String tenDem;

    @Column(name = "Ho")
    private String ho;

    @Column(name = "NgaySinh")
    private Date ngaySinh;

    @Column(name = "Sdt")
    private String sdt;

    @Column(name = "DiaChi")
    private String diaChi;

    @Column(name = "ThanhPho")
    private String thanhPho;

    @Column(name = "QuocGia")
    private String quocGia;

    @Column(name = "MatKhau")
    private String matKhau;

    @OneToMany(mappedBy = "khachHang")
    List<GioHang> gioHangList;

    public void loadFormViewModel(KhachHangVM khachHangVM){
        this.setMa(khachHangVM.getMa());
        this.setTen(khachHangVM.getTen());
        this.setHo(khachHangVM.getHo());
        this.setTenDem(khachHangVM.getTenDem());
        this.setNgaySinh(khachHangVM.getNgaySinh());
        this.setSdt(khachHangVM.getSdt());
        this.setDiaChi(khachHangVM.getDiaChi());
        this.setThanhPho(khachHangVM.getThanhPho());
        this.setQuocGia(khachHangVM.getQuocGia());
        this.setMatKhau(khachHangVM.getMatKhau());

    }
}
