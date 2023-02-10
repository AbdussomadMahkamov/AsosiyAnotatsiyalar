package com.example.asosiyanatatsiyalar.controller;

import com.example.asosiyanatatsiyalar.dto.ApiResponse;
import com.example.asosiyanatatsiyalar.dto.HisobRaqamDto;
import com.example.asosiyanatatsiyalar.dto.PulOtkazish;
import com.example.asosiyanatatsiyalar.service.HisobRaqamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/hisobRaqam")
public class HisobRaqamController {
    @Autowired
    HisobRaqamService hisobRaqamService;
    @PostMapping("/add")
    public HttpEntity<?> addHisobRaqam(@RequestBody HisobRaqamDto hisobRaqamDto){
        ApiResponse apiResponse=hisobRaqamService.addHisobRaqam(hisobRaqamDto);
        return ResponseEntity.status(apiResponse.isHolat()?500:208).body(apiResponse.getXabar());
    }
    @PutMapping("/pulQuyish/{kartaRaqam}")
    public HttpEntity<?> PulQuyish(@PathVariable String kartaRaqam, @RequestBody PulOtkazish pulOtkazish){
        ApiResponse apiResponse=hisobRaqamService.pulQuyish(kartaRaqam, pulOtkazish);
        return ResponseEntity.status(apiResponse.isHolat()?500:208).body(apiResponse.getXabar());
    }
    @PutMapping("/pulOtkazish/{jonatuvchi}")
    public HttpEntity<?> PULotkazish(@PathVariable String jonatuvchi, @RequestBody PulOtkazish pulOtkazish){
        ApiResponse apiResponse=hisobRaqamService.pulotkazish(jonatuvchi, pulOtkazish);
        return ResponseEntity.status(apiResponse.isHolat()?500:208).body(apiResponse.getXabar());
    }
}
