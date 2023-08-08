package com.example.ass_java5.request;

import com.example.ass_java5.entities.SanPham;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SanPhamVM {

    private String ma;

    private String ten;

    public void loadSanPhamDomainModel(SanPham sanPham){
        this.setMa(sanPham.getMa());
        this.setTen(sanPham.getTen());
    }
}
