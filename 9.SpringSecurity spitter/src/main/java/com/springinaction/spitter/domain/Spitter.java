package com.springinaction.spitter.domain;

import org.hibernate.validator.constraints.Email;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Spitter {
    private Long id;

    @NotNull(message = "Username should not be null")
    @Size(min = 5, max = 16, message = "Username should consist from 5 to 16 characters")
    private String username;

    @NotNull(message = "Password should not be null")
    @Size(min = 5, max = 25, message = "Password should consist from 5 to 25 characters")
    private String password;

    @NotNull(message = "First name should not be null")
    @Size(min = 2, max = 30, message = "First name should consist from 2 to 30 characters")
    private String firstName;

    @NotNull(message = "Last name should not be null")
    @Size(min = 2, max = 30, message = "Last name should consist from 2 to 30 characters")
    private String lastName;

    @NotNull
    @Email(message = "{email.valid}")
    private String email;

    public Spitter() {
    }

    public Spitter(String username, String password) {
        this(username, password, null, null);
    }

    public Spitter(String username, String password, String firstName, String lastName) {
        this(null, username, password, firstName, lastName);
    }

    public Spitter(Long id, String username, String password, String firstName, String lastName) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
