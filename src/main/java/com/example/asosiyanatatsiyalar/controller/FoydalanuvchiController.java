package com.example.asosiyanatatsiyalar.controller;

import com.example.asosiyanatatsiyalar.dto.ApiResponse;
import com.example.asosiyanatatsiyalar.dto.FoydalanuvchiDto;
import com.example.asosiyanatatsiyalar.service.FoydalanuvchiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
