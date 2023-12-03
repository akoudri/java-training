package org.example.structure;

import java.time.LocalDate;

public class Singer extends Artist {

    private Album[] albums;
    private int nbAlbums;

    public Singer(String name, String firstname, String lastname, LocalDate birthdate) {
        super(name, firstname, lastname, birthdate);
        albums = new Album[50];
        nbAlbums = 0;
    }

    @Override
    public void perform() {
        System.out.println("la la la");
    }

    public void addAlbum(Album a) {
        albums[nbAlbums++] = a;
    }

    public void listAlbums() {
        for (int i = 0; i < nbAlbums; i++) {
            System.out.printf("%s -> %d\n", albums[i].getTitle(), albums[i].getReleased().getYear());
        }
    }

}
