package org.example.structure;

import java.time.LocalDate;

public class Album {

    private String title;
    private LocalDate released;
    private String genre;

    public Album(String title, LocalDate released, String genre) {
        this.title = title;
        this.released = released;
        this.genre = genre;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public LocalDate getReleased() {
        return released;
    }

    public void setReleased(LocalDate released) {
        this.released = released;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }
}
