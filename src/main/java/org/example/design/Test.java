package org.example.design;

public class Test {
    public static void main(String[] args) {
        MoteurElectrique m = new MoteurElectrique("V8", 10, 1000);
        MoteurIFace l = new MoteurElectrique("V6", 10, 1000);
        //m.setPuissance(1500);
        MoteurIFace n = MoteurThermique.builder()
                .poids(1000)
                .puissance(50)
                .nom("V12")
                .build();
        Roue[] roues = { new Roue(), new Roue(), new Roue(), new Roue() };
        Voiture v = new Voiture();
        v.setAvg(roues[0]);
        v.setAvd(roues[1]);
        v.setArd(roues[2]);
        v.setArg(roues[3]);
        v.setRoues(roues);
        v.setMoteur(n);
        System.out.println("Hello");
    }
}
