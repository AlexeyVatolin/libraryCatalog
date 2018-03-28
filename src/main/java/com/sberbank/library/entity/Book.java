package com.sberbank.library.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
public class Book {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    private String title;
    @ManyToOne
    private Author author;
    @ManyToOne
    private Publishing publishing;
    private int pubYear;
    private int numberOfPage;

    public Book(String title, Author author, Publishing publishing, int pubYear, int numberOfPage) {
        this.title = title;
        this.author = author;
        this.publishing = publishing;
        this.pubYear = pubYear;
        this.numberOfPage = numberOfPage;
    }
}
