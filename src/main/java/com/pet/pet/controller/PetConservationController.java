package com.pet.pet.controller;

import com.pet.pet.model.PetConservation;
import com.pet.pet.service.PetConservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.sql.Blob;
import java.sql.SQLException;
import java.util.List;

@Controller
@RequestMapping("/petConservations")
public class PetConservationController {

    private final PetConservationService petConservationService;

    @Autowired
    public PetConservationController(PetConservationService petConservationService) {
        this.petConservationService = petConservationService;
    }

    @GetMapping("/allpetconservations")
    public ModelAndView viewAllPetConservations() {
        ModelAndView mv = new ModelAndView("allPetConservations");
        List<PetConservation> petConservations = petConservationService.getAllPetConservations();
        mv.addObject("petConservations", petConservations);
        return mv;
    }

    @RequestMapping("/article")
    public ModelAndView viewclientPetConservations() {
        ModelAndView mv = new ModelAndView("ArticleList");
        List<PetConservation> petConservations = petConservationService.getAllPetConservations();
        mv.addObject("petConservations", petConservations);
        return mv;
    }

    // add pet conservation - get
    @GetMapping("/addpetconservation")
    public ModelAndView showAddPetConservationForm(Model model) {
        model.addAttribute("petConservation", new PetConservation());
        return new ModelAndView("addPetConservationForm");
    }


    @GetMapping("/displaypetconservation/{id}")
    public ResponseEntity<byte[]> displayPetConservationImage(@PathVariable Long id) throws IOException, SQLException {
        PetConservation petConservation = petConservationService.getPetConservationById(id);
        byte[] imageBytes = null;

        if (petConservation != null && petConservation.getBlogPicture() != null) {
            imageBytes = petConservation.getBlogPicture().getBytes(1, (int) petConservation.getBlogPicture().length());
        }

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.IMAGE_JPEG);
        return ResponseEntity.ok().headers(headers).body(imageBytes);
    }


    // add pet conservation - post
    @PostMapping("/addpetconservation")
    public String addPetConservationPost(@RequestParam("image") MultipartFile file, @ModelAttribute PetConservation petConservation) throws IOException, SQLException {
        byte[] bytes = file.getBytes();
        Blob blob = new javax.sql.rowset.serial.SerialBlob(bytes);

        petConservation.setBlogPicture(blob);
        petConservationService.createPetConservation(petConservation);
        return "redirect:/allpetconservations";
    }

    // edit pet conservation - get
    @GetMapping("/editpetconservation/{id}")
    public ModelAndView showEditPetConservationForm(@PathVariable Long id) {
        ModelAndView mv = new ModelAndView("editPetConservationForm");
        PetConservation petConservation = petConservationService.getPetConservationById(id);
        mv.addObject("petConservation", petConservation);
        return mv;
    }

    // edit pet conservation - post
    @PostMapping("/editpetconservation/{id}")
    public String editPetConservationPost(@PathVariable Long id, @RequestParam("image") MultipartFile file, @ModelAttribute PetConservation updatedPetConservation) throws IOException, SQLException {
        PetConservation existingPetConservation = petConservationService.getPetConservationById(id);
        if (existingPetConservation != null) {
            byte[] bytes = file.getBytes();
            Blob blob = new javax.sql.rowset.serial.SerialBlob(bytes);

            existingPetConservation.setBlogPicture(blob);
            existingPetConservation.setBlogName(updatedPetConservation.getBlogName());
            existingPetConservation.setBlogDescription(updatedPetConservation.getBlogDescription());
            petConservationService.updatePetConservation(id, existingPetConservation);
        }
        return "redirect:/allpetconservations";
    }

    // delete pet conservation
    @GetMapping("/deletepetconservation/{id}")
    public String deletePetConservation(@PathVariable Long id) {
        petConservationService.deletePetConservation(id);
        return "redirect:/allpetconservations";
    }

    // Details page - get
    @GetMapping("/details/{id}")
    public ModelAndView showPetConservationDetails(@PathVariable Long id) {
        ModelAndView mv = new ModelAndView("petConservationDetails");
        PetConservation petConservation = petConservationService.getPetConservationById(id);
        mv.addObject("petConservation", petConservation);
        return mv;
    }

}
