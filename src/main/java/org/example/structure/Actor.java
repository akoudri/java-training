package org.example.structure;

import java.time.LocalDate;

public class Actor extends Artist {
    public Actor(String name, String firstname, String lastname, LocalDate birthdate) {
        super(name, firstname, lastname, birthdate);
    }

    @Override
    public void perform() {
        System.out.println("Hue pan pan");
    }

    public void display() {
        System.out.println(this.getName());
    }



}
