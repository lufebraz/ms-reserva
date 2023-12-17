package com.microserviceone.repository;

import com.microserviceone.model.Reserva;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservaRepository extends JpaRepository<Reserva, Long> {
}
