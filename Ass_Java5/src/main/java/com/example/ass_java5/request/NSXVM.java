package com.example.ass_java5.request;

import com.example.ass_java5.entities.NSX;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class NSXVM {

    @NotBlank
    private String ma;

    @NotBlank
    private String ten;

    public void loadNSXDomainModel(NSX nsx){
        this.setMa(nsx.getMa());
        this.setTen(nsx.getTen());
    }
}
