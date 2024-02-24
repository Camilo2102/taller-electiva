package com.example.tallerelectiva.models;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.util.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "developers")
public class DeveloperModel extends AuditModel{
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String country;
    private int yearFounded;
    private String website;
}
