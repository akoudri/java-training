package org.example.design;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
public class Voiture {

    MoteurIFace moteur;
    Roue[] roues;
    Roue avg, avd, arg, ard;

}
