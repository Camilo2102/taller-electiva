package com.example.tallerelectiva.repositories;

import com.example.tallerelectiva.models.GameModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GameRepository extends AuditRepository<GameModel> {
}
