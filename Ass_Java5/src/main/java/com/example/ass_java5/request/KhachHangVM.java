package com.example.ass_java5.request;

import com.example.ass_java5.entities.KhachHang;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.sql.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class KhachHangVM {

    @NotBlank(message = "mã khong dc de trống")
    private String ma;

    @NotBlank(message = "ten khong dc de trống")
    private String ten;

    @NotBlank(message = "tenDem khong dc de trống")
    private String tenDem;

    @NotBlank(message = "ho khong dc de trống")
    private String ho;

    private Date ngaySinh;

    @NotBlank(message = "sdt khong dc de trống")
    private String sdt;

    @NotBlank(message = "diaChi khong dc de trống")
    private String diaChi;

    @NotBlank(message = "diaChi khong dc de trống")
    private String thanhPho;

    @NotBlank(message = "diaChi khong dc de trống")
    private String quocGia;

    @NotBlank(message = "mk khong dc de trống")
    private String matKhau;

    public void loadFormDomainModel(KhachHang khachHang){
        this.setMa(khachHang.getMa());
        this.setTen(khachHang.getTen());
        this.setHo(khachHang.getHo());
        this.setDiaChi(khachHang.getDiaChi());
        this.setTenDem(khachHang.getTenDem());
        this.setNgaySinh(khachHang.getNgaySinh());
        this.setSdt(khachHang.getSdt());
        this.setThanhPho(khachHang.getThanhPho());
        this.setQuocGia(khachHang.getQuocGia());
        this.setMatKhau(khachHang.getMatKhau());
    }
}
