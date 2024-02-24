package com.example.tallerelectiva.DTO;

import com.example.tallerelectiva.models.GameModel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class MultiplePlatformGame {
    private String platformId;
    private List<GameModel> games;
}
