package org.example;

public class Vehicule {

    static int nbVehicules = 0;

    protected int kilometrage;
    protected int poids;

    public int getKilometrage() {
        return kilometrage;
    }

    public void setKilometrage(int kilometrage) {
        if (kilometrage < 0)
            this.kilometrage = Math.abs(kilometrage);
        else this.kilometrage = kilometrage;
    }

    public int getPoids() {
        return poids;
    }

    public void setPoids(int poids) {
        if (poids < 0)
            this.poids = Math.abs(poids);
        else this.poids = poids;
    }
}
