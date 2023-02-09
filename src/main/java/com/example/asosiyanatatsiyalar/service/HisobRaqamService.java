package com.example.asosiyanatatsiyalar.service;

import com.example.asosiyanatatsiyalar.dto.ApiResponse;
import com.example.asosiyanatatsiyalar.dto.HisobRaqamDto;
import com.example.asosiyanatatsiyalar.entity.Foydalanuvchi;
import com.example.asosiyanatatsiyalar.entity.HisobRaqam;
import com.example.asosiyanatatsiyalar.repository.FoydalanuvchiRepository;
import com.example.asosiyanatatsiyalar.repository.HisobRaqamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class HisobRaqamService {
    @Autowired
    HisobRaqamRepository hisobRaqamRepository;
    @Autowired
    FoydalanuvchiRepository foydalanuvchiRepository;

    public ApiResponse addHisobRaqam(HisobRaqamDto hisobRaqamDto) {
        Optional<Foydalanuvchi> byPassportRaqam = foydalanuvchiRepository.findByPassportRaqam(hisobRaqamDto.getPassportRaqam());
        Optional<HisobRaqam> byFoydalanuvchi_id = hisobRaqamRepository.findByFoydalanuvchi_Id(byPassportRaqam.get().getId());
        if (!byFoydalanuvchi_id.isPresent()){
            return new ApiResponse("Bunday foydalanuvchi mavjud emas", false);
        }
        if (byFoydalanuvchi_id.get().getBankNomi().equals(hisobRaqamDto.getBankNomi()) && byFoydalanuvchi_id.get().getKartaNomi().equals(hisobRaqamDto.getKartaNomi())){
            return new ApiResponse("Bu foydalanuvchida "+hisobRaqamDto.getBankNomi()+"dan "+hisobRaqamDto.getKartaNomi()+" kartasi mavjud!", false);
        }
        HisobRaqam hisobRaqam=new HisobRaqam();
        hisobRaqam.setBankNomi(hisobRaqamDto.getBankNomi());
        hisobRaqam.setKartaNomi(hisobRaqamDto.getKartaNomi());
        hisobRaqam.setKartaRaqami(hisobRaqamDto.getKartaRaqami());
        hisobRaqam.setAmalQilishMuddati(hisobRaqamDto.getAmalQilishMuddati());
        hisobRaqam.setFoydalanuvchi(byFoydalanuvchi_id.get().getFoydalanuvchi());
        hisobRaqamRepository.save(hisobRaqam);
        return new ApiResponse("Ma'lumotlar saqlandi", true);
    }
}
