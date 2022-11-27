package fr.mat.citizen.models;

import java.io.Serializable;
import java.util.*;

public class Female extends Citizen implements Serializable {

    public Female(String lastName, String firstName, Date birthDate) {
        super(lastName, firstName, birthDate);
    }

}