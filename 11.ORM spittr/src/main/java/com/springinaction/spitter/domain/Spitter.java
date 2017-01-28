package com.springinaction.spitter.domain;

import org.hibernate.validator.constraints.Email;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "spitter")
public class Spitter {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "Username should not be null")
    @Size(min = 5, max = 16, message = "{username.size}")
    @Column(name = "username")
    private String username;

    @NotNull(message = "Password should not be null")
    @Size(min = 5, max = 25, message = "{password.size}")
    @Column(name = "password")
    private String password;

    @NotNull(message = "First name should not be null")
    @Size(min = 2, max = 30, message = "{firstName.size}")
    @Column(name = "firstname")
    private String firstName;

    @NotNull(message = "Last name should not be null")
    @Size(min = 2, max = 30, message = "{lastName.size}")
    @Column(name = "lastname")
    private String lastName;

    @NotNull
    @Email(message = "{email.valid}")
    @Column(name = "email")
    private String email;

    public Spitter() {
    }

    public Spitter(String username, String password) {
        this(username, password, null, null);
    }

    public Spitter(String username, String password, String firstName, String lastName) {
        this(null, username, password, firstName, lastName, "");
    }

    public Spitter(Long id, String username, String password, String firstName, String lastName, String email) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
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
