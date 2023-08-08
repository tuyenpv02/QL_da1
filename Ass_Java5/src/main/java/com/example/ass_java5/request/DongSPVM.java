package com.example.ass_java5.request;

import com.example.ass_java5.entities.DongSP;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DongSPVM {

    private String ma;

    private String ten;

    public void loadDongSPDomainModel(DongSP dongSP){
        this.setMa(dongSP.getMa());
        this.setTen(dongSP.getTen());
    }
}
