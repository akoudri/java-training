package org.example.design;

import lombok.*;
import lombok.experimental.FieldDefaults;

//@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@ToString(of = {"poids", "puissance"})
@EqualsAndHashCode
public class MoteurElectrique implements MoteurIFace {

    String nom;
    int puissance;
    int poids;

}
