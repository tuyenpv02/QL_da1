package com.example.ass_java5.entities;

import com.example.ass_java5.request.MauSacVM;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Entity
@Table(name = "MauSac")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MauSac {
    @Id
    @Column(name = "Id")
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "ma")
    private String ma;

    @Column(name = "ten")
    private String ten;

    public void loadMauSacViewModel(MauSacVM mauSacVM){
        this.setMa(mauSacVM.getMa());
        this.setTen(mauSacVM.getTen());
    }
}
