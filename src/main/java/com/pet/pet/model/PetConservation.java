package com.pet.pet.model;

import jakarta.validation.constraints.NotNull;

import javax.persistence.*;
import java.sql.Blob;

@Entity
public class PetConservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @NotNull(message = "blog Name cannot be empty")
    private String blogName;

    @Lob
    @NotNull(message = "Picture cannot be empty")
    private Blob blogPicture;

    @Lob
    @NotNull(message = "Blog Description cannot be empty")
    private String blogDescription;

    public PetConservation() {
    }

    public PetConservation(Long id, String blogName, Blob blogPicture, String blogDescription) {
        this.id = id;
        this.blogName = blogName;
        this.blogPicture = blogPicture;
        this.blogDescription = blogDescription;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBlogName() {
        return blogName;
    }

    public void setBlogName(String blogName) {
        this.blogName = blogName;
    }

    public Blob getBlogPicture() {
        return blogPicture;
    }

    public void setBlogPicture(Blob blogPicture) {
        this.blogPicture = blogPicture;
    }

    public String getBlogDescription() {
        return blogDescription;
    }

    public void setBlogDescription(String blogDescription) {
        this.blogDescription = blogDescription;
    }
}
