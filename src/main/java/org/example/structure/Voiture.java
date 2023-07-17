package org.example.structure;

public class Voiture extends Routier {

    public String immatriculation;

    public Voiture(String immatriculation, int poids, int kilometrage) {
        this.immatriculation = immatriculation;
        this.poids = poids;
        this.kilometrage = kilometrage;
        this.avd = new Roue();
        this.avg = new Roue();
    }

    public Voiture() {
        this("AJ753QD", 1500, 65000);
    }

    boolean revisionRequired() {
        return (this.kilometrage > 50000);
    }

}
