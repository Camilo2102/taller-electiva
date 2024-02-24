package com.example.tallerelectiva.DTO;

import com.example.tallerelectiva.models.MainCharacterModel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class AssignCharacterDTO {
    private String gameId;
    private MainCharacterModel character;
}
