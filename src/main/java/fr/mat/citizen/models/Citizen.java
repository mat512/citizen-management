package fr.mat.citizen.models;

import java.io.Serializable;
import java.util.*;

public class Citizen implements Serializable  {

    public Citizen(String lastName, String firstName, Date birthDate) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.birthDate = birthDate;
    }

    public final String lastName;

    public final String firstName;

    public final Date birthDate;

    public City city;

    public Birth birth;

    public Death death;

}