package com.example.asosiyanatatsiyalar.service;

import com.example.asosiyanatatsiyalar.dto.ApiResponse;
import com.example.asosiyanatatsiyalar.dto.FoydalanuvchiDto;
import com.example.asosiyanatatsiyalar.dto.HisobRaqamDto;
import com.example.asosiyanatatsiyalar.entity.Foydalanuvchi;
import com.example.asosiyanatatsiyalar.entity.HisobRaqam;
import com.example.asosiyanatatsiyalar.repository.FoydalanuvchiRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FoydalanuvchiService {
    @Autowired
    FoydalanuvchiRepository foydalanuvchiRepository;
    public ApiResponse addUser(FoydalanuvchiDto foydalanuvchiDto) {
        boolean b = foydalanuvchiRepository.existsByPassportRaqam(foydalanuvchiDto.getPassportRaqam());
        if (b){
            return new ApiResponse("Bunday foydalanuvchi oldin ro'yxatdan o'tgan", false);
        }
            Foydalanuvchi foydalanuvchi= new Foydalanuvchi();
            foydalanuvchi.setIsm(foydalanuvchiDto.getIsm());
            foydalanuvchi.setFamiliya(foydalanuvchiDto.getFamiliya());
            foydalanuvchi.setPassportRaqam(foydalanuvchiDto.getPassportRaqam());
            foydalanuvchi.setManzili(foydalanuvchiDto.getManzili());
            List<HisobRaqam> hisobRaqamList=new ArrayList<>();
            for (HisobRaqamDto hisobRaqamDto : foydalanuvchiDto.getHisobRaqamDtoList()) {
                HisobRaqam hisobRaqam=new HisobRaqam();
                hisobRaqam.setFoydalanuvchi(foydalanuvchi);
                hisobRaqam.setBankNomi(hisobRaqamDto.getBankNomi());
                hisobRaqam.setKartaNomi(hisobRaqamDto.getKartaNomi());
                hisobRaqam.setKartaRaqami(hisobRaqamDto.getKartaRaqami());
                hisobRaqam.setAmalQilishMuddati(hisobRaqamDto.getAmalQilishMuddati());
                hisobRaqamList.add(hisobRaqam);
            }
            foydalanuvchi.setHisobRaqamList(hisobRaqamList);
            foydalanuvchiRepository.save(foydalanuvchi);
            return new ApiResponse("Ma'lumotlar saqlandi",true);
    }
}
