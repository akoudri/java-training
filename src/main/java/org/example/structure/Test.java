package org.example.structure;

import java.time.LocalDate;
import java.util.Random;

public class Test {

    public static void main(String[] args) {
        /*Singer a = new Singer("Stromae", "Paul", "Van Haver", LocalDate.of(1985, 03, 12));
        Artist b = new Actor(null, "John", "Wayne", LocalDate.of(1911, 03, 12));
        a.addAlbum(new Album("Racine Carré", LocalDate.of(2013, 1, 1), "fusion"));
        a.addAlbum(new Album("Multitude", LocalDate.of(2022, 1, 1), "fusion"));
        Artist[] artists = {a, b};
        for (Artist e : artists) {
            System.out.println(e);
            e.perform();
        }
        a.listAlbums();*/
//        Stack<Integer> stack = new Stack<>();
//        Random r = new Random();
//        for (int i = 0; i < 5; i++) {
//            stack.push(r.nextInt(20));
//        }
//        stack.display();
//        System.out.println("-----------");
//        System.out.println(stack.pop());
//        System.out.println("-----------");
//        stack.display();
        Enterprise xyz = new Enterprise("XYZ");
//        Department dir = new Department("Direction");
//        Department rd = new Department("R&D");
//        Department qualite = new Department("Qualité");
//        Collaborator ali = new Collaborator("Ali", "Koudri");
//        xyz.setCeo(ali);
//        Collaborator david = new Collaborator("David", "Gillard");
//        Collaborator amine = new Collaborator("Amine", "Koudri");
//        amine.setFirstname("Toto");
//        rd.addCollaborator(david);
//        rd.addCollaborator(amine);
//        rd.setManager(david);
//        rd.setManager(amine);
//        qualite.setManager(amine);
        xyz.addCollaborator(new Collaborator(1, "Ali", "Koudri"));
        xyz.addCollaborator(new Collaborator(1, "David", "Gillard"));
        xyz.viewCollaborators();
    }

}
