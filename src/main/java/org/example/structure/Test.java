package org.example.structure;

public class Test {

    public static void main(String[] args) {
        Voiture bmw = new Voiture();
        try {
            Homme kevin = new Homme(40, 80, bmw);
            Homme david = new Homme(40, 80, bmw);
            kevin.manger();
            kevin.voiture = bmw;
            System.out.println(kevin.getPoids());
            System.out.println(kevin.voiture.poids);
            Homme.incr();
            Homme.incr();
            System.out.println(Homme.nb);
            System.out.println(Math.sqrt(2));
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
        }
    }

}
