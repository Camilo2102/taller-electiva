package com.example.tallerelectiva.DTO;

import com.example.tallerelectiva.models.DeveloperModel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class AssignDeveloperDTO {
    private String gameId;
    private DeveloperModel developer;
}
