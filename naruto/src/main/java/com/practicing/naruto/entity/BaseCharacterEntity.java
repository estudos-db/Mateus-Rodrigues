package com.practicing.naruto.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;


import java.util.List;


@Entity
@Table
@NoArgsConstructor
public class BaseCharacterEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id")
    @NotBlank
    private Long id;

    @NotBlank(message = "Campo obrigatório")
    @Length(min = 5, max = 250, message = "Máx de caractéries(250)")
    private String name;

    @NotBlank(message = "Campo obrigatório")
    @Length(min = 2, max = 7, message = "Máx de caractéries(7)")
    private int age;
    private String village;
    private List<String> jutsus;
    private int chakra;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
