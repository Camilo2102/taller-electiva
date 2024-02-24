package com.example.tallerelectiva.DTO;

import com.example.tallerelectiva.models.GameModel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class PlatformGameDTO {
    private String platformId;
    private GameModel game;
}
