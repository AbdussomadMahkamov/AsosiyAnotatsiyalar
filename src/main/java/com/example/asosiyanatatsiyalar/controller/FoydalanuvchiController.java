package com.example.asosiyanatatsiyalar.controller;

import com.example.asosiyanatatsiyalar.dto.ApiResponse;
import com.example.asosiyanatatsiyalar.dto.FoydalanuvchiDto;
import com.example.asosiyanatatsiyalar.repository.FoydalanuvchiRepository;
import com.example.asosiyanatatsiyalar.service.FoydalanuvchiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/foydalanuvchilar")
public class FoydalanuvchiController {
    @Autowired
    FoydalanuvchiService foydalanuvchiService;
    @PostMapping("/add")
    public HttpEntity<?> AddUser(@RequestBody FoydalanuvchiDto foydalanuvchiDto){
        ApiResponse apiResponse= foydalanuvchiService.addUser(foydalanuvchiDto);
        return ResponseEntity.status(apiResponse.isHolat()? 500: 208).body(apiResponse.getXabar());
    }
    @DeleteMapping("/deleteUser/{passoprtRaqam}")
    public HttpEntity<?> DeleteUser(@PathVariable String passoprtRaqam){
        ApiResponse apiResponse= foydalanuvchiService.deleteUser(passoprtRaqam);
        return ResponseEntity.status(apiResponse.isHolat()? 500: 208).body(apiResponse.getXabar());
    }

    @Autowired
    FoydalanuvchiRepository foydalanuvchiRepository;
    @GetMapping("/readUser")
    public HttpEntity<?> readUser(){
        return ResponseEntity.ok(foydalanuvchiRepository.findAll());
    }
}
