package fr.mat.citizen.models;

import java.io.Serializable;
import java.util.*;

public class Wedding implements Serializable {

    public Wedding(Date date) {
        this.date = date;
    }

    public final Date date;

    public City city;

    public Citizen husband;

    public Citizen wife;

    public Divorce divorce;

}