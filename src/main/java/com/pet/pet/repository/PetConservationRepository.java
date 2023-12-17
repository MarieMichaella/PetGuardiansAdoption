package com.pet.pet.repository;

import com.pet.pet.model.PetConservation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PetConservationRepository extends JpaRepository<PetConservation, Long> {
}
