package com.example.ass_java5.entities;

import com.example.ass_java5.request.ChucVuVM;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Entity
@Table(name = "ChucVu")
@Getter@Setter
@AllArgsConstructor@NoArgsConstructor
public class ChucVu {

    @Id
    @Column(name = "Id")
    @GeneratedValue(strategy = GenerationType.UUID)
    public UUID id;

    @Column(name = "Ma")
    private String  ma;

    @Column(name = "Ten")
    private String ten;

    public void loadChucVuVM(ChucVuVM chucVuVM){
        this.setMa(chucVuVM.getMa());
        this.setTen(chucVuVM.getTen());
    }
}
