package com.example.tallerelectiva.DTO;

import com.example.tallerelectiva.models.PlatformModel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class GamePlatformDTO {
    private String gameId;
    private PlatformModel platformModel;
}
