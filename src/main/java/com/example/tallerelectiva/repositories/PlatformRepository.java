package com.example.tallerelectiva.repositories;

import com.example.tallerelectiva.models.PlatformModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlatformRepository extends AuditRepository<PlatformModel> {
}
