package org.example;

public class Homme {

    private int age;
    private int poids;
    static int nb = 0;

    Voiture voiture;

    public Homme(int age, int poids, Voiture v) throws Exception {
        if (v == null || age < 0 || poids < 0) {
            throw new Exception("Paramètres incorrects");
        }
        this.voiture = v;
        nb ++;
    }

    void manger() {
        poids ++;
    }

    void courir() {
        poids --;
    }

    public int getPoids() {
        return this.poids;
    }

    public static void incr() {
        nb ++;
    }
}
