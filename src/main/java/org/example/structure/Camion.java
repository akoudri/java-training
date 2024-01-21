package org.example.structure;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Camion extends Routier {

    int patc;
    int ptr;
    List<String> passengers = new ArrayList<>();

    public void addPassenger(String name) {
        passengers.add(name);
    }

    public void addPassengers(int ptr, String... names) {
        for (String name : names) {
            passengers.add(name);
        }
    }


    public static void main(String[] args) {
        Camion c = new Camion();
        c.addPassengers(23, "toto", "tata", "titi", "tutu", "tete");
        c.getPassengers().forEach(System.out::println);
    }

}
