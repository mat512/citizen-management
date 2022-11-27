package fr.mat.citizen.models;

import fr.mat.citizen.utils.DateUtils;

import java.io.Serializable;
import java.util.*;

public class City extends Observable implements Serializable {

    public City() {
    }

    public final Vector<Citizen> citizens = new Vector<>();

    public final Vector<Wedding> weddings = new Vector<>();

    public final Vector<Birth> births = new Vector<>();

    public final Vector<Death> deaths = new Vector<>();

    public String addWedding(Citizen husband, Citizen wife, Date date) {
        if (husband.death != null || wife.death != null) return "Error: one of the citizen is dead.";

        DateUtils dateUtils = new DateUtils();
        if (dateUtils.getAge(husband.birthDate) < 18 && dateUtils.getAge(wife.birthDate) < 18)
            return "Error: one of the citizens is not of age.";

        if (husband == wife) return "Error: it is the same citizen.";

        if (isMarried(wife) || isMarried(wife)) return "Error: one of the citizens is already married";

        Wedding wedding = new Wedding(date);
        wedding.husband = husband;
        wedding.wife = wife;
        wedding.city = this;

        weddings.add(wedding);

        this.setChanged();
        this.notifyObservers();

        return "Saved.";
    }

    public boolean isMarried(Citizen citizen) {
        for (Wedding wedding : weddings) {
            if (wedding.husband == citizen || wedding.wife == citizen) {
                if (wedding.divorce == null) return true;
            }
        }

        return false;
    }

    public String addDivorce(Citizen citizen, Date date) {
        for (Wedding wedding : weddings) {
            if (wedding.husband == citizen || wedding.wife == citizen) {
                if (wedding.divorce == null) {
                    Divorce divorce = new Divorce(date);
                    divorce.wedding = wedding;

                    wedding.divorce = divorce;

                    this.setChanged();
                    this.notifyObservers();

                    return "Saved.";
                }
            }
        }

        return "Error: the citizen is not married,";
    }

    public String addBirth(Citizen father, Citizen mother, String lastName, String firstName, Date birthDate, boolean isMale) {
        if (father == mother) return "Error: it is the same citizen.";

        Citizen citizen;

        if (isMale) citizen = new Male(lastName, firstName, birthDate);
        else citizen = new Female(lastName, firstName, birthDate);

        Birth birth = new Birth(birthDate);
        birth.father = father;
        birth.mother = mother;
        birth.newBorn = citizen;
        birth.city = this;

        citizen.city = this;
        citizen.birth = birth;
        addCitizen(citizen);

        births.add(birth);

        this.setChanged();
        this.notifyObservers();

        return "Saved.";
    }

    public void addDeath(Citizen citizen, Date date) {
        if (citizen.death == null) {
            Death death = new Death(date);
            death.citizen = citizen;
            death.city = this;

            citizen.death = death;

            deaths.add(death);

            if (isMarried(citizen)) addDivorce(citizen, date);
        }

        this.setChanged();
        this.notifyObservers();
    }

    public String getCitizenStatus(Citizen citizen) {
        StringBuilder txt = new StringBuilder();
        DateUtils dateUtils = new DateUtils();

        if (citizens.contains(citizen)) {
            txt.append("First name: ").append(citizen.firstName);
            txt.append("\nLast name: ").append(citizen.lastName);
            txt.append("\nGender: ").append(citizen.getClass().getSimpleName());
            txt.append("\nBirth date: ").append(dateUtils.dateFormat(citizen.birthDate));
            if (citizen.birth != null) {
                txt.append("\n    Father: ").append(citizen.birth.father.lastName).append(" ").append(citizen.birth.father.firstName);
                txt.append("\n    Mother: ").append(citizen.birth.mother.lastName).append(" ").append(citizen.birth.mother.firstName);
            }
            if (citizen.death != null) txt.append("\nDeath date: ").append(dateUtils.dateFormat(citizen.death.date));

            if (isMarried(citizen)) txt.append("\nStatus: Married");
            else txt.append("\nStatus: Single");

            for (Wedding wedding : weddings) {
                if (wedding.husband == citizen || wedding.wife == citizen) {
                    txt.append("\nWedding: ");
                    txt.append("\n    Date: ").append(dateUtils.dateFormat(wedding.date));

                    if (wedding.divorce != null)
                        txt.append("\n    Divorce : ").append(dateUtils.dateFormat(wedding.divorce.date));

                    if (wedding.wife == citizen) {
                        if (wedding.husband.death != null) txt.append("\n    Status: Widow");

                        txt.append("\n    First name: ").append(wedding.husband.firstName);
                        txt.append("\n    Last name: ").append(wedding.husband.lastName);
                    } else {
                        if (wedding.wife.death != null) txt.append("\n    Status: Widow");

                        txt.append("\n    First name: ").append(wedding.wife.firstName);
                        txt.append("\n    Last name: ").append(wedding.wife.lastName);
                    }
                }
            }
        } else txt.append("\nError: does not exist in the list of citizens.");

        return txt.toString();
    }

    public String getAllCitizenStatus() {
        StringBuilder txt = new StringBuilder();

        for (Citizen citizen : citizens) {
            txt.append("ID: ").append(citizens.indexOf(citizen)).append("\n");
            txt.append(getCitizenStatus(citizen)).append("\n\n");
        }

        return txt.toString();
    }

    public void addCitizen(Citizen citizen) {
        citizens.add(citizen);

        this.setChanged();
        this.notifyObservers();
    }

}