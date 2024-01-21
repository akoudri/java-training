package org.example.algos;

import org.example.annotations.Author;

@Author(firstName = "Albert", lastName = "Camus")
public record Book(String title) {
}
