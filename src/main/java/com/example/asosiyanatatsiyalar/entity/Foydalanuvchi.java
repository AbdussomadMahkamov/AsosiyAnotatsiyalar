package com.example.asosiyanatatsiyalar.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Period;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Foydalanuvchi {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    @Column(nullable = false)
    private String ism;
    @Column(nullable = false)
    private String familiya;
    @Column(nullable = false)
    private String manzili;
    @Column(nullable = false, unique = true)
    private String passportRaqam;
    @Column(nullable = false)
    private LocalDate tugulganSana;
    @Transient
    private int ismUzunligi;

    public int getIsmUzunligi() {
        return ism.length()!=0?ism.length():null;
    }
    @Transient
    private String boshHarflar;

    public String getBoshHarflar() {
        return ism!=null||familiya!=null?ism.substring(0,1)+familiya.substring(0,1):null;
    }
    @Transient
    private int yosh;

    public int getYosh() {
//        "yosh": "2023-02-09"
        return Period.between(tugulganSana,LocalDate.now()).getYears();
    }

    @JsonIgnore
    @OneToMany(mappedBy = "foydalanuvchi", cascade = CascadeType.ALL)
    List<HisobRaqam> hisobRaqamList;
}
