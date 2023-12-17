package com.pet.pet.service;

import com.pet.pet.model.Pet;
import com.pet.pet.model.PetCategory;
import com.pet.pet.repository.PetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PetServiceImpl implements PetService {

    private final PetRepository petRepository;



    @Autowired
    public PetServiceImpl(PetRepository petRepository) {
        this.petRepository = petRepository;
    }

    @Override
    public Page<Pet> getAllPets(Pageable pageable) {
        return petRepository.findAll(pageable);
    }


    @Override
    public Pet getPetById(Long id) {
        Optional<Pet> optionalPet = petRepository.findById(id);
        return optionalPet.orElse(null);
    }

    @Override
    public void createPet(Pet pet) {
        petRepository.save(pet);
    }

    @Override
    public void updatePet(Long id, Pet updatedPet) {
        Optional<Pet> optionalExistingPet = petRepository.findById(id);
        if (optionalExistingPet.isPresent()) {
            Pet existingPet = optionalExistingPet.get();
            existingPet.setName(updatedPet.getName());
            existingPet.setDescription(updatedPet.getDescription());
            existingPet.setBreed(updatedPet.getBreed());
            existingPet.setPictureUrl(updatedPet.getPictureUrl());
            existingPet.setCategory(updatedPet.getCategory());
            petRepository.save(existingPet);
        }
    }


    @Override
    public void deletePet(Long id) {
        petRepository.deleteById(id);
    }

    @Override
    public Page<Pet> getDogs(Pageable pageable) {
        return petRepository.findByCategory(PetCategory.DOGS, pageable);
    }

    @Override
    public Page<Pet> getCats(Pageable pageable) {
        return petRepository.findByCategory(PetCategory.CATS, pageable);
    }

    @Override
    public Page<Pet> getRabbits(Pageable pageable) {
        return petRepository.findByCategory(PetCategory.RABBITS, pageable);
    }


}
