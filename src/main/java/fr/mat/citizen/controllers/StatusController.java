package fr.mat.citizen.controllers;

import fr.mat.citizen.models.City;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StatusController implements ActionListener {

    final City city;

    final JSpinner citizenInput;
    final TextArea textArea;

    public StatusController(City city, JSpinner citizenInput, TextArea textArea) {
        this.city = city;

        this.citizenInput = citizenInput;
        this.textArea = textArea;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if ("Confirm".equals(e.getActionCommand())) {
            int citizenIndex = (int) citizenInput.getValue();

            textArea.setText(city.getCitizenStatus(city.citizens.get(citizenIndex)));
        }
    }

}