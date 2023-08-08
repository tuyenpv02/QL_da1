package com.example.ass_java5.entities;

import com.example.ass_java5.request.CuaHangVM;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Entity
@Table(name = "CuaHang")
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
public class CuaHang {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "Ma")
    private String ma;

    @Column(name = "Ten")
    private String ten;

    @Column(name = "DiaChi")
    private String diaChi;

    @Column(name = "ThanhPho")
    private String thanhPho;

    @Column(name = "QuocGia")
    private String quocGia;

    public void loadCuaHangVM(CuaHangVM vm){
        this.setTen( vm.getTen() );
        this.setMa( vm.getMa() );
        this.setDiaChi( vm.getDiaChi() );
        this.setThanhPho( vm.getThanhPho() );
        this.setQuocGia( vm.getQuocGia() );
    }
}
