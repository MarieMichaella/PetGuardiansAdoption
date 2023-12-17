package com.pet.pet.service;


import com.pet.pet.model.PetConservation;
import com.pet.pet.repository.PetConservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PetConservationServiceImpl implements PetConservationService {

    private final PetConservationRepository petConservationRepository;

    @Autowired
    public PetConservationServiceImpl(PetConservationRepository petConservationRepository) {
        this.petConservationRepository = petConservationRepository;
    }

    @Override
    public List<PetConservation> getAllPetConservations() {
        return petConservationRepository.findAll();
    }

    @Override
    public PetConservation getPetConservationById(Long id) {
        Optional<PetConservation> optionalPetConservation = petConservationRepository.findById(id);
        return optionalPetConservation.orElse(null);
    }

    @Override
    public void createPetConservation(PetConservation petConservation) {
        petConservationRepository.save(petConservation);
    }

    @Override
    public void updatePetConservation(Long id, PetConservation updatedPetConservation) {
        Optional<PetConservation> optionalExistingPetConservation = petConservationRepository.findById(id);
        if (optionalExistingPetConservation.isPresent()) {
            PetConservation existingPetConservation = optionalExistingPetConservation.get();
            existingPetConservation.setBlogName(updatedPetConservation.getBlogName());
            existingPetConservation.setBlogPicture(updatedPetConservation.getBlogPicture());
            existingPetConservation.setBlogDescription(updatedPetConservation.getBlogDescription());
            petConservationRepository.save(existingPetConservation);
        }
    }

    @Override
    public void deletePetConservation(Long id) {
        petConservationRepository.deleteById(id);
    }
}
