package org.example.structure;

import lombok.*;

import java.util.Objects;

//@Data
@Data
@AllArgsConstructor
public class Collaborator {
    private int id;
    private String firstname, lastname;
}
