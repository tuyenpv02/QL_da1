package com.example.ass_java5.entities;

import com.example.ass_java5.request.SanPhamVM;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Entity
@Table(name = "SanPham")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SanPham {

    @Id
    @Column(name = "Id")
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "ma")
    private String ma;

    @Column(name = "ten")
    private String ten;

    public void loadSanPhamViewModel(SanPhamVM sanPhamVM){
        this.setMa(sanPhamVM.getMa());
        this.setTen(sanPhamVM.getTen());
    }
}
