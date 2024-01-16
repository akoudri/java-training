package org.example.structure;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Enterprise {

    private String name;

    @Getter
    @Setter
    private Collaborator ceo, cto, coo, cfo;

    private Set<Collaborator> collaborators;

    private List<Department> departments;

    public Enterprise(String name) {
        this.name = name;
        this.departments = new ArrayList<>();
        this.collaborators = new HashSet<>();
    }

    public void addDepartment(Department department) {
        this.departments.add(department);
    }

    public void addCollaborator(Collaborator c) {
        this.collaborators.add(c);
    }

    public void viewCollaborators() {
        this.collaborators.forEach(System.out::println);
    }
}
