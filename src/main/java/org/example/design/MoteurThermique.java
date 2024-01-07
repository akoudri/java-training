package org.example.design;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MoteurThermique implements MoteurIFace {

    String nom;
    int puissance;
    int poids;
}
