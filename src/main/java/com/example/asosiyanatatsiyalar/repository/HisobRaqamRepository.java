package com.example.asosiyanatatsiyalar.repository;

import com.example.asosiyanatatsiyalar.entity.Foydalanuvchi;
import com.example.asosiyanatatsiyalar.entity.HisobRaqam;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface HisobRaqamRepository extends JpaRepository<HisobRaqam,Integer> {
    Optional<HisobRaqam> findByFoydalanuvchi_Id(Integer foydalanuvchi_id);
}
