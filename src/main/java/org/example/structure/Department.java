package org.example.structure;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

public class Department {

    private String name;

    @Getter
    @Setter
    private Collaborator manager;

    private List<Collaborator> collaborators;

    public Department(String name) {
        this.name = name;
        this.collaborators = new ArrayList<>();
    }

    public void addCollaborator(Collaborator collaborator) {
        this.collaborators.add(collaborator);
    }

}
