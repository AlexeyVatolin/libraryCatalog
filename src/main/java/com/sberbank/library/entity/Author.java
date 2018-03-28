package com.sberbank.library.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
@NoArgsConstructor
public class Author {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    private String firstName;
    private String lastName;
    private String patronymic;

    public Author(String firstName, String patronymic, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.patronymic = patronymic;
    }

    public String getDisplayName()
    {
        String name = lastName + " " + firstName.charAt(0) + ". ";
        if(patronymic != null && !patronymic.isEmpty()) name += patronymic.charAt(0) + ". ";
        return name;
    }
}