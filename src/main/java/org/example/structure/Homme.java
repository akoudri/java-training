package org.example.structure;

public class Homme extends Person {

    static int nb = 0;

    Voiture voiture;

    public Homme(int age, int weight, Voiture v) throws Exception {
        if (v == null || age < 0 || weight < 0) {
            throw new Exception("Paramètres incorrects");
        }
        this.voiture = v;
        nb ++;
    }

    void manger() {
        weight ++;
    }

    void courir() {
        weight --;
    }

    public double getPoids() {
        return this.weight;
    }

    public static void incr() {
        nb ++;
    }
}
