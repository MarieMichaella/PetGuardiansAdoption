package com.pet.pet.repository;

import com.pet.pet.model.Pet;
import com.pet.pet.model.PetCategory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface PetRepository extends JpaRepository<Pet, Long> {
    Page<Pet> findByCategory(PetCategory category, Pageable pageable);
}
