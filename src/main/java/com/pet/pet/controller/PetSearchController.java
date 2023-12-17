package com.pet.pet.controller;

import com.pet.pet.model.Pet;
import com.pet.pet.service.PetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class PetSearchController {

    private final PetService petService;

    @Autowired
    public PetSearchController(PetService petService) {
        this.petService = petService;
    }

    @GetMapping("/search-form")
    public String showSearchForm() {
        return "searchForm";
    }

    @GetMapping("/petsearch")
    public String getPetById(@RequestParam Long petId, Model model) {
        Pet pet = petService.findPetById(petId);

        if (pet != null) {
            model.addAttribute("pet", pet);
            return "search"; // Assuming you have a Thymeleaf/HTML template named search.html
        } else {
            return "petNotFound"; // Assuming you have a Thymeleaf/HTML template named petNotFound.html
        }
    }
}
