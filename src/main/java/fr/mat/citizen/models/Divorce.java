package fr.mat.citizen.models;

import java.io.Serializable;
import java.util.*;

public class Divorce implements Serializable {

    public Divorce(Date date) {
        this.date = date;
    }

    public final Date date;

    public Wedding wedding;

}