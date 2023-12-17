package com.pet.pet.model;

import jakarta.validation.constraints.*;

import javax.persistence.*;
import java.sql.Blob;

@Entity
public class Pet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Name cannot be empty")
    @Size(max = 255, message = "Name cannot exceed 255 characters")
    private String name;

    @NotBlank(message = "Description cannot be empty")
    @Size(max = 1000, message = "Description cannot exceed 1000 characters")
    private String description;

    @NotBlank(message = "Breed cannot be empty")
    @Size(max = 255, message = "Breed cannot exceed 255 characters")
    private String breed;

    @Lob
    @NotNull(message = "Picture cannot be empty")
    private Blob pictureUrl;

    @Enumerated(EnumType.STRING)
    private PetCategory category;


    public Pet() {
    }

    public Pet(Long id, String name, String description, String breed, Blob pictureUrl, PetCategory category) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.breed = breed;
        this.pictureUrl = pictureUrl;
        this.category = category;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public Blob getPictureUrl() {
        return pictureUrl;
    }

    public void setPictureUrl(Blob pictureUrl) {
        this.pictureUrl = pictureUrl;
    }

    public PetCategory getCategory() {
        return category;
    }

    public void setCategory(PetCategory category) {
        this.category = category;
    }

}

