package com.example.ass_java5.request;

import com.example.ass_java5.entities.CuaHang;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
public class CuaHangVM {

    @NotBlank
    private String ma;

    @NotBlank
    private String ten;

    @NotBlank
    private String diaChi;

    @NotBlank
    private String thanhPho;

    @NotBlank
    private String quocGia;

    public void loadFromDomainModel(CuaHang domain)
    {
        this.setTen( domain.getTen() );
        this.setMa( domain.getMa() );
        this.setDiaChi( domain.getDiaChi() );
        this.setThanhPho( domain.getThanhPho() );
        this.setQuocGia( domain.getQuocGia() );
    }
}
