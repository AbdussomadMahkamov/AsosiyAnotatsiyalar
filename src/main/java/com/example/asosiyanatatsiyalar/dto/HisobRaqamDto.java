package com.example.asosiyanatatsiyalar.dto;

import lombok.Data;

@Data
public class HisobRaqamDto {
    private String kartaNomi,kartaRaqami,amalQilishMuddati,bankNomi;
    private String passportRaqam;
    private Double balans;

    public Double getBalans() {
        return Double.valueOf(0);
    }
}
