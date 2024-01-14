package org.example.structure;

import lombok.Getter;
import lombok.Setter;

public class Collaborator {

    @Getter
    @Setter
    private String firstname, lastname;

    public Collaborator(String firstname, String lastname) {
        this.firstname = firstname;
        this.lastname = lastname;
    }
}
