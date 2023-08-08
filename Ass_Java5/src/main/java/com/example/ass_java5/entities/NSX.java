package com.example.ass_java5.entities;

import com.example.ass_java5.request.NSXVM;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Entity
@Table(name = "NSX")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class NSX {

    @Id
    @Column(name = "Id")
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "ma")
    private String ma;

    @Column(name = "ten")
    private String ten;

    public void loadSNSXViewModel(NSXVM nsxvm){
        this.setMa(nsxvm.getMa());
        this.setTen(nsxvm.getTen());
    }
}
