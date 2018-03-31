package com.sberbank.library.domain;

import com.sberbank.library.entity.Author;
import com.sberbank.library.entity.Publishing;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@NoArgsConstructor
public class BookForm {
    @NotNull
    @Size(min = 1)
    private String title;
    private Author author;
    private Publishing publishing;
    @Min(0)
    private int pubYear;
    @Min(0)
    private int numberOfPage;
    @Min(0)
    private int numberOfBooks;
    @Size(min = 1)
    private String bookLocation;
}
