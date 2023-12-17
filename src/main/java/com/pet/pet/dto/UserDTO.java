package com.pet.pet.dto;

import lombok.Data;

import java.util.Set;

@Data
public class UserDTO {

    private Long id;
    private String name;
    private String email;
    private String password;
    private String phone;
    private Set<String> roles;
}
