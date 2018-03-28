package com.sberbank.library.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

@Data
@NoArgsConstructor
public class AuthorForm {
    @Size(min = 1)
    private String firstName;
    @Size(min = 1)
    private String lastName;
    private String patronymic;
}
