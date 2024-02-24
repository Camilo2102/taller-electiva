package com.example.tallerelectiva.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.*;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "platforms")
public class PlatformModel extends AuditModel {
    @Column(nullable = false)
    private String name;
    private String manufacturer;
    private String releaseYear;

    @ManyToMany(mappedBy = "platforms")
    @JsonIgnore
    private List<GameModel> games;
}
