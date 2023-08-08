package com.example.ass_java5.request;

import com.example.ass_java5.entities.MauSac;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MauSacVM {

    @NotBlank
    private String ma;

    @NotBlank
    private String ten;

    public void loadMauSacDomainModel(MauSac mauSac){
        this.setMa(mauSac.getMa());
        this.setTen(mauSac.getTen());
    }
}
