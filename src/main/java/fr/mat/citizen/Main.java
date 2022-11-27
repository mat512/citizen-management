package fr.mat.citizen;

import fr.mat.citizen.models.Citizen;
import fr.mat.citizen.models.City;
import fr.mat.citizen.models.Female;
import fr.mat.citizen.models.Male;
import fr.mat.citizen.utils.SaveUtils;
import fr.mat.citizen.views.MainView;

import java.util.Calendar;
import java.util.Date;

public class Main {

    public static void main(String[] args) {
        City city = new SaveUtils().load();

        // Add some sample citizens
        if(city == null) {
            city = new City();

            Citizen citizen0 = new Male("Darrell", "Wilkins", new Date(1998 - 1900, Calendar.MAY, 10));
            Citizen citizen1 = new Female("Brittney", "Mcclure", new Date(1995 - 1900, Calendar.JULY, 21));
            Citizen citizen2 = new Male("Vicente", "Cook", new Date(1997 - 1900, Calendar.FEBRUARY, 14));

            city.addCitizen(citizen0);
            city.addCitizen(citizen1);
            city.addCitizen(citizen2);
        }

        new MainView(city);
    }

}
