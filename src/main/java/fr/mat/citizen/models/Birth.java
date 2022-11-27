package fr.mat.citizen.models;

import java.io.Serializable;
import java.util.*;

public class Birth implements Serializable {

    public Birth(Date date) {
        this.date = date;
    }

    public final Date date;

    public Citizen father;

    public Citizen mother;

    public Citizen newBorn;

    public City city;

}