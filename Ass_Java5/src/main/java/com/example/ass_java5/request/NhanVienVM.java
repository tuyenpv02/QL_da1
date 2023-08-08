package com.example.ass_java5.request;

import com.example.ass_java5.entities.ChucVu;
import com.example.ass_java5.entities.CuaHang;
import com.example.ass_java5.entities.NhanVien;
import com.example.ass_java5.entities.ChucVu;
import com.example.ass_java5.entities.CuaHang;
import com.example.ass_java5.entities.NhanVien;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.sql.Date;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class NhanVienVM {

    @NotBlank(message = "mã khong dc de trống")
    private String ma;

    @NotBlank(message = "ten khong dc de trống")
    private String ten;

    @NotBlank(message = "tenDem khong dc de trống")
    private String tenDem;

    @NotBlank(message = "ho khong dc de trống")
    private String ho;

    @NotBlank(message = "gioiTinh khong dc de trống")
    private String gioiTinh;

    private Date ngaySinh;

    @NotBlank(message = "diaChi khong dc de trống")
    private String diaChi;

    @NotBlank(message = "sdt khong dc de trống")
    private String sdt;

    @NotBlank(message = "mk khong dc de trống")
    private String matKhau;

    private CuaHang cuaHang;

    private ChucVu chucVu;

    private UUID idGuiBC;

    @NonNull
    private Integer trangThai;

    public void loadFormDomainModel(NhanVien nhanVien){
        this.setMa(nhanVien.getMa());
        this.setTen(nhanVien.getTen());
        this.setHo(nhanVien.getHo());
        this.setGioiTinh(nhanVien.getGioiTinh());
        this.setDiaChi(nhanVien.getDiaChi());
        this.setTenDem(nhanVien.getTenDem());
        this.setNgaySinh(nhanVien.getNgaySinh());
        this.setSdt(nhanVien.getSdt());
        this.setMatKhau(nhanVien.getMatKhau());
        this.setChucVu(nhanVien.getChucVu());
        this.setIdGuiBC(nhanVien.getIdGuiBC());
        this.setCuaHang(nhanVien.getCuaHang());
        this.setTrangThai(nhanVien.getTrangThai());
    }

}
