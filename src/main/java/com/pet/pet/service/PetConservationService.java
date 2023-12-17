package com.pet.pet.service;

import com.pet.pet.model.PetConservation;

import java.util.List;

public interface PetConservationService {

    List<PetConservation> getAllPetConservations();

    PetConservation getPetConservationById(Long id);

    void createPetConservation(PetConservation petConservation);

    void updatePetConservation(Long id, PetConservation updatedPetConservation);

    void deletePetConservation(Long id);
}
