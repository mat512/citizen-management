package fr.mat.citizen.controllers;

import fr.mat.citizen.models.City;
import fr.mat.citizen.utils.DateUtils;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

public class DivorceController implements ActionListener {

    final City city;

    final JSpinner citizenId;
    final JLabel outputInfoLabel;
    final JFormattedTextField dateInput;

    public DivorceController(City city, JLabel outputInfoLabel, JSpinner citizenId, JFormattedTextField dateInput) {
        this.city = city;

        this.citizenId = citizenId;
        this.outputInfoLabel = outputInfoLabel;
        this.dateInput = dateInput;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if ("Confirm".equals(e.getActionCommand())) {
            int citizenIndex = (int) citizenId.getValue();

            Date date = (Date) dateInput.getValue();

            DateUtils dateUtils = new DateUtils();

            if (dateUtils.isValidDate(date)) {
                String returnMessage = city.addDivorce(city.citizens.get(citizenIndex), date);
                outputInfoLabel.setText(returnMessage);
            } else {
                outputInfoLabel.setText(dateUtils.invalidDateErrorMessage);
            }
        }
    }

}