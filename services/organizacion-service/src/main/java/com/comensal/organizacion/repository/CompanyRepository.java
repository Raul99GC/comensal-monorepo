package com.comensal.organizacion.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.comensal.organizacion.models.Company;

public interface CompanyRepository extends JpaRepository<Company, Long> {
    
}
