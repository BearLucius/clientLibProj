package com.example.serverclient.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class GenreEntity {
    private Long id;
    private String title;
    private List<BookEntity> books;
}
