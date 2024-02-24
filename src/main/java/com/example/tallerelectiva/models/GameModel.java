package com.example.tallerelectiva.models;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "games")
public class GameModel extends AuditModel {
    @Column(nullable = false)
    private String title;
    @Column(nullable = false)
    private String description;
    @Column(nullable = false)
    private BigDecimal price;
    private int releaseYear;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "main_character_id")
    private MainCharacterModel character;

    @ManyToMany
    @JoinTable(
            name = "game_platform",
            joinColumns = @JoinColumn(name = "game_id"),
            inverseJoinColumns = @JoinColumn(name = "platform_id")
    )
    private List<PlatformModel> platforms;

    @ManyToOne
    @JoinColumn(name = "developer_id") // Esta es la clave foránea en la tabla games
    private DeveloperModel developer;
}
