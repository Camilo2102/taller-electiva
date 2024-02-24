package com.example.tallerelectiva.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.stereotype.Repository;

@NoRepositoryBean
public interface AuditRepository<T> extends JpaRepository<T, String> {
}
