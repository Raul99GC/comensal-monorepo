package com.comensal.organizacion.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.comensal.organizacion.models.AlertRecipient;

public interface AlertRecipientRepository extends JpaRepository<AlertRecipient, Long> {

}
