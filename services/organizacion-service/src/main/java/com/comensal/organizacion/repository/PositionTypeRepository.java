package com.comensal.organizacion.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.comensal.organizacion.models.PositionType;

public interface PositionTypeRepository extends JpaRepository<PositionType, Long> {
    
}
