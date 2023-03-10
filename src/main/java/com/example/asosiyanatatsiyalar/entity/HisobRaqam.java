package com.example.asosiyanatatsiyalar.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class HisobRaqam {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(nullable = false)
    private String kartaNomi;
    @Column(nullable = false)
    private String kartaRaqami;
    @Column(nullable = false)
    private String amalQilishMuddati;
    @Column(nullable = false)
    private String bankNomi;
    @Column(nullable = false)
    private Double balans;
    @OnDelete(action = OnDeleteAction.CASCADE)
    @ManyToOne(optional = false,fetch = FetchType.LAZY)
    Foydalanuvchi foydalanuvchi;
}
