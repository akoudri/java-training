package org.example.structure;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

public class Enterprise {

    private String name;

    @Getter
    @Setter
    private Collaborator ceo, cto, coo, cfo;

    private List<Department> departments;

    public Enterprise(String name) {
        this.name = name;
        this.departments = new ArrayList<>();
    }

    public void addDepartment(Department department) {
        this.departments.add(department);
    }
}
