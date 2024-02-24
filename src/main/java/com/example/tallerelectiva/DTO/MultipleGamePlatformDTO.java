package com.example.tallerelectiva.DTO;

import com.example.tallerelectiva.models.PlatformModel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class MultipleGamePlatformDTO {
    private String gameId;
    private List<PlatformModel> platforms;
}
