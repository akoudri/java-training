package org.example.structure;

import java.time.LocalDate;

public class Test {

    public static void main(String[] args) {
        Singer a = new Singer("Stromae", "Paul", "Van Haver", LocalDate.of(1985, 03, 12));
        Artist b = new Actor(null, "John", "Wayne", LocalDate.of(1911, 03, 12));
        a.addAlbum(new Album("Racine Carré", LocalDate.of(2013, 1, 1), "fusion"));
        a.addAlbum(new Album("Multitude", LocalDate.of(2022, 1, 1), "fusion"));
        Artist[] artists = {a, b};
        for (Artist e : artists) {
            System.out.println(e);
            e.perform();
        }
        a.listAlbums();
    }

}
