package com.codegym.model;

import javax.persistence.*;
import javax.validation.constraints.*;

@Entity
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Size(min = 5, max = 45)
    private String fistName;

    @NotBlank
    @Size(min = 5, max = 45)
    private String lastName;

    @Pattern(regexp = "^[0-9]{10}")
    private String phoneNumber;

    @Min(18)
    private Integer age;

    @Email
    private String email;

    public User() {}

    public User(Long id, String fistName, String lastName, String phoneNumber, Integer age, String email) {
        this.id = id;
        this.fistName = fistName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.age = age;
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public @NotBlank @Size(min = 5, max = 45) String getFistName() {
        return fistName;
    }

    public void setFistName(@NotBlank @Size(min = 5, max = 45) String fistName) {
        this.fistName = fistName;
    }

    public @NotBlank @Size(min = 5, max = 45) String getLastName() {
        return lastName;
    }

    public void setLastName(@NotBlank @Size(min = 5, max = 45) String lastName) {
        this.lastName = lastName;
    }

    public @Pattern(regexp = "^[0-9]{10}") String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(@Pattern(regexp = "^[0-9]{10}") String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public @Min(18) Integer getAge() {
        return age;
    }

    public void setAge(@Min(18) Integer age) {
        this.age = age;
    }

    public @Email String getEmail() {
        return email;
    }

    public void setEmail(@Email String email) {
        this.email = email;
    }
}
