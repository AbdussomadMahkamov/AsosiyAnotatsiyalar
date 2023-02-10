package com.example.asosiyanatatsiyalar.dto;

import lombok.Data;

import java.util.List;

@Data
public class FoydalanuvchiDto {
    private String ism,familiya,manzili,passportRaqam;
    private List<HisobRaqamDto> hisobRaqamDtoList;
    private String tugulganSana;

}
