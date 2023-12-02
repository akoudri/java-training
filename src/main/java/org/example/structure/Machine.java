package org.example.structure;

public class Machine {
    private String marque;
    private String modele;
    private String couleur;
    private int nbPorte;
    private boolean estElectrique;

    public Machine(String marque, String modele, String couleur, int nbPorte, boolean estElectrique) {
        this.marque = marque;
        this.modele = modele;
        this.couleur = couleur;
        this.nbPorte = nbPorte;
        this.estElectrique = estElectrique;
    }

    public String getMarque() {
        return marque;
    }

    public String getModele() {
        return modele;
    }

    public String getCouleur() {
        return couleur;
    }

    public int getNbPorte() {
        return nbPorte;
    }

    public boolean isEstElectrique() {
        return estElectrique;
    }

    public static void main(String[] args) {
        Machine[] machines = new Machine[4];
        machines[0] = new Machine("Peugeot", "205 - junior", "blanche", 5, false);
        machines[1] = new Machine("Bmw", "318 - compact", "noir", 3, false);
        machines[2] = new Machine("Citroen", "2CV", "mauve", 5, false);
        machines[3] = new Machine("Toyota", "Auris", "bleu nuit", 5, true);
        for (Machine m : machines) {
            System.out.printf("Voiture de marque %s et de modèle %s avec %d portes\n", m.getMarque(), m.getModele(), m.getNbPorte());
        }
    }
}
