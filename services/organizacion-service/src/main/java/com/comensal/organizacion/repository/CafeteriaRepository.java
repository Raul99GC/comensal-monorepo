package com.comensal.organizacion.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.comensal.organizacion.models.Cafeteria;

public interface CafeteriaRepository extends JpaRepository<Cafeteria, Long> {
    
}
