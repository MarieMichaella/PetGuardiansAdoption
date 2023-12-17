package com.pet.pet.controller;

import com.pet.pet.model.Pet;
import com.pet.pet.model.PetConservation;
import com.pet.pet.service.PetService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.sql.rowset.serial.SerialBlob;
import java.io.IOException;
import java.sql.Blob;
import java.sql.SQLException;
import java.util.List;

@Controller
public class PetController {

    private final PetService petService;

    @Autowired
    public PetController(PetService petService) {
        this.petService = petService;
    }

    @GetMapping("/alldogs")
    public String getAllDogs(Model model, @RequestParam(defaultValue = "0") int page,
                             @RequestParam(defaultValue = "10") int size) {
        PageRequest pageable = PageRequest.of(page, size);
        Page<Pet> dogsPage = petService.getDogs(pageable);

        model.addAttribute("dogs", dogsPage.getContent());
        model.addAttribute("currentPage", page);
        model.addAttribute("totalPages", dogsPage.getTotalPages());

        return "DogsList";
    }

    @GetMapping("/allcats")
    public String getAllCats(Model model, @RequestParam(defaultValue = "0") int page,
                             @RequestParam(defaultValue = "10") int size) {
        PageRequest pageable = PageRequest.of(page, size);
        Page<Pet> catsPage = petService.getCats(pageable);

        model.addAttribute("cats", catsPage.getContent());
        model.addAttribute("currentPage", page);
        model.addAttribute("totalPages", catsPage.getTotalPages());

        return "CatsList";
    }

    @GetMapping("/allrabbits")
    public String getAllRabbits(Model model, @RequestParam(defaultValue = "0") int page,
                                @RequestParam(defaultValue = "10") int size) {
        PageRequest pageable = PageRequest.of(page, size);
        Page<Pet> rabbitsPage = petService.getRabbits(pageable);

        model.addAttribute("rabbits", rabbitsPage.getContent());
        model.addAttribute("currentPage", page);
        model.addAttribute("totalPages", rabbitsPage.getTotalPages());

        return "RabbitsList";
    }



    @GetMapping("/ping")
    @ResponseBody
    public String helloWorld() {
        return "Hello World!";
    }

    @GetMapping("/display/{id}")
    public ResponseEntity<byte[]> displayPetImage(@PathVariable Long id) throws IOException, SQLException {
        Pet pet = petService.getPetById(id);
        byte[] imageBytes = null;
        if (pet != null && pet.getPictureUrl() != null) {
            imageBytes = pet.getPictureUrl().getBytes(1, (int) pet.getPictureUrl().length());
        }
        return ResponseEntity.ok().contentType(org.springframework.http.MediaType.IMAGE_JPEG).body(imageBytes);
    }

    @GetMapping("/all")
    public String viewAllPets(@RequestParam(name = "page", defaultValue = "0") int currentPage,
                              @RequestParam(name = "size", defaultValue = "2") int size, Model model) {
        Page<Pet> petPage = petService.getAllPets(PageRequest.of(currentPage, size));

        model.addAttribute("pets", petPage.getContent());
        model.addAttribute("currentPagePets", currentPage);
        model.addAttribute("totalPagePets", petPage.getTotalPages());
        model.addAttribute("totalItemPets", petPage.getTotalElements());

        return "allPets";
    }




    @GetMapping("/add")
    public ModelAndView showAddPetForm() {
        return new ModelAndView("addPetForm");
    }

    @PostMapping("/add")
    public String addPetPost(@Valid @RequestParam("image") MultipartFile file, @ModelAttribute Pet pet) throws IOException, SQLException {
        byte[] bytes = file.getBytes();
        Blob blob = new SerialBlob(bytes);

        pet.setPictureUrl(blob);
        petService.createPet(pet);
        return "redirect:/all";
    }

    @GetMapping("/edit/{id}")
    public ModelAndView showEditPetForm(@PathVariable Long id) {
        ModelAndView mv = new ModelAndView("editPetForm");
        Pet pet = petService.getPetById(id);
        mv.addObject("pet", pet);
        return mv;
    }

    @PostMapping("/edit/{id}")
    public String editPetPost(@Valid @PathVariable Long id, @RequestParam("image") MultipartFile file, @ModelAttribute Pet updatedPet) throws IOException, SQLException {
        Pet existingPet = petService.getPetById(id);
        if (existingPet != null) {
            byte[] bytes = file.getBytes();
            Blob blob = new SerialBlob(bytes);

            existingPet.setPictureUrl(blob);
            existingPet.setName(updatedPet.getName());
            existingPet.setDescription(updatedPet.getDescription());
            existingPet.setBreed(updatedPet.getBreed());
            existingPet.setCategory(updatedPet.getCategory());
            petService.updatePet(id, existingPet);
        }
        return "redirect:/all";
    }

    // delete pet
    @GetMapping("/delete/{id}")
    public String deletePet(@PathVariable Long id) {
        petService.deletePet(id);
        return "redirect:/all";
    }
    @GetMapping("/details/{id}")
    public ModelAndView showPetdetails(@PathVariable Long id) {
        ModelAndView mv = new ModelAndView("petDetails");
        Pet pet = petService.getPetById(id);
        mv.addObject("pet", pet);
        return mv;
    }


}
