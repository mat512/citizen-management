package fr.mat.citizen.models;

import java.io.Serializable;
import java.util.*;

public class Male extends Citizen implements Serializable {

    public Male(String lastName, String firstName, Date birthDate) {
        super(lastName, firstName, birthDate);
    }

}