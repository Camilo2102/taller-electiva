package com.example.tallerelectiva.models;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "main_characters")
public class MainCharacterModel extends AuditModel {
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String description;

    private String history;

    @OneToOne(mappedBy = "character", cascade = CascadeType.ALL)
    @JsonIgnore
    private GameModel game;

    public MainCharacterModel(String name, String description, String history) {
        this.name = name;
        this.description = description;
        this.history = history;
    }
}
