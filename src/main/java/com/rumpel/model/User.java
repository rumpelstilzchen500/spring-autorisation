package com.rumpel.model;


import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class User {

    @NotBlank(message = "Имя должно быть заполненым")
    private String name;

    @Size(min = 1, max = 10, message = "Фамилия должна содержать от 1 до 10 символов")
    private String surname;

    @Email
    private String email;

    public User() {
    }

    public User(String name, String surname, String email) {
        this.name = name;
        this.surname = surname;
        this.email = email;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getEmail() {
        return email;
    }
}
