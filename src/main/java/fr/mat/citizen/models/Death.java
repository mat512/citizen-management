package fr.mat.citizen.models;

import java.io.Serializable;
import java.util.*;

public class Death implements Serializable {

    public Death(Date date) {
        this.date = date;
    }

    public final Date date;

    public City city;

    public Citizen citizen;

}