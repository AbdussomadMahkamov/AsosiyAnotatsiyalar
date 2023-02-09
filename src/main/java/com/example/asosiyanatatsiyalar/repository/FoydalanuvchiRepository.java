package com.example.asosiyanatatsiyalar.repository;

import com.example.asosiyanatatsiyalar.entity.Foydalanuvchi;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface FoydalanuvchiRepository extends JpaRepository<Foydalanuvchi,Integer> {
    boolean existsByPassportRaqam(String passportRaqam);
    Optional<Foydalanuvchi> findByPassportRaqam(String passportRaqam);
}
