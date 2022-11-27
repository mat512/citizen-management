package fr.mat.citizen.controllers;

import fr.mat.citizen.models.Citizen;
import fr.mat.citizen.models.City;
import fr.mat.citizen.utils.DateUtils;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

public class WeddingController implements ActionListener {

    final City city;

    final JSpinner husbandInput;
    final JSpinner wifeInput;
    final JFormattedTextField dateInput;

    final JLabel outputInfoLabel;

    public WeddingController(City city, JLabel outputInfoLabel, JSpinner husbandInput, JSpinner wifeInput, JFormattedTextField dateInput) {
        this.city = city;

        this.husbandInput = husbandInput;
        this.wifeInput = wifeInput;
        this.dateInput = dateInput;

        this.outputInfoLabel = outputInfoLabel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if ("Confirm".equals(e.getActionCommand())) {
            int husbandIndex = (int) husbandInput.getValue();
            int wifeIndex = (int) wifeInput.getValue();

            Citizen husband = city.citizens.get(husbandIndex);
            Citizen wife = city.citizens.get(wifeIndex);

            Date date = (Date) dateInput.getValue();

            DateUtils dateUtils = new DateUtils();

            if (dateUtils.isValidDate(date)) {
                String returnMessage = city.addWedding(husband, wife, date);
                outputInfoLabel.setText(returnMessage);
            } else {
                outputInfoLabel.setText(dateUtils.invalidDateErrorMessage);
            }
        }
    }

}
