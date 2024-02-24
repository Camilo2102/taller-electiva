package com.example.tallerelectiva.repositories;

import com.example.tallerelectiva.models.DeveloperModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DeveloperRepository extends AuditRepository<DeveloperModel> {
}
