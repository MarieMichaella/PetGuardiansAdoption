package com.pet.pet.service;

import com.pet.pet.model.Pet;
import com.pet.pet.repository.PetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface PetService {

    Page<Pet> getAllPets(Pageable pageable);

    Pet getPetById(Long id);

    void createPet(Pet pet);

    void updatePet(Long id, Pet updatedPet);

    void deletePet(Long id);

    Page<Pet> getDogs(Pageable pageable);

    Page<Pet> getCats(Pageable pageable);

    Page<Pet> getRabbits(Pageable pageable);



    public Pet findPetById(Long id);

    Page<Pet> searchPetsByName(String name, Pageable pageable);

    List<Pet> findPetsByName(String name);



}
