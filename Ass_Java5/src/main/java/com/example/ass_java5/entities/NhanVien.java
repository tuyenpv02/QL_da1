package com.example.ass_java5.entities;

import com.example.ass_java5.request.NhanVienVM;
import jakarta.persistence.*;
import lombok.*;

import java.sql.Date;
import java.util.UUID;

@Entity
@Table(name = "NhanVien")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class NhanVien {

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

    @Column(name = "GioiTinh")
    private String gioiTinh;

    @Column(name = "NgaySinh")
    private Date ngaySinh;

    @Column(name = "DiaChi")
    private String diaChi;

    @Column(name = "Sdt")
    private String sdt;

    @Column(name = "MatKhau")
    private String matKhau;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "IdCH", referencedColumnName = "id")
    private CuaHang cuaHang;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "IdCV", referencedColumnName = "id")
    private ChucVu chucVu;

    @Column(name = "IdGuiBC")
    private UUID idGuiBC;

    @Column(name = "TrangThai")
    private Integer trangThai;

    public void loadFormViewModel(NhanVienVM nhanVienVM){
        this.setMa(nhanVienVM.getMa());
        this.setTen(nhanVienVM.getTen());
        this.setHo(nhanVienVM.getHo());
        this.setGioiTinh(nhanVienVM.getGioiTinh());
        this.setDiaChi(nhanVienVM.getDiaChi());
        this.setTenDem(nhanVienVM.getTenDem());
        this.setNgaySinh(nhanVienVM.getNgaySinh());
        this.setSdt(nhanVienVM.getSdt());
        this.setMatKhau(nhanVienVM.getMatKhau());
        this.setChucVu(nhanVienVM.getChucVu());
        this.setIdGuiBC(nhanVienVM.getIdGuiBC());
        this.setCuaHang(nhanVienVM.getCuaHang());
        this.setTrangThai(nhanVienVM.getTrangThai());
    }
}
