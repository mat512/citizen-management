package fr.mat.citizen.controllers;

import fr.mat.citizen.models.City;
import fr.mat.citizen.utils.SaveUtils;
import fr.mat.citizen.views.CitizenListView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuBarController implements ActionListener {

    final City city;

    public MenuBarController(City city) {
        this.city = city;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case "List":
                new CitizenListView(city);
                break;

            case "Save":
                new SaveUtils().save(city);
                break;

            case "Exit":
                System.exit(0);
                break;
        }
    }

}
