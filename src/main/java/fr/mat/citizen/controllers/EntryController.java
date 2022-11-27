package fr.mat.citizen.controllers;

import fr.mat.citizen.models.Citizen;
import fr.mat.citizen.models.City;
import fr.mat.citizen.models.Female;
import fr.mat.citizen.models.Male;
import fr.mat.citizen.utils.DateUtils;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

public class EntryController implements ActionListener {

    final City city;

    final JTextField lastNameInput;
    final JTextField firstNameInput;
    final JRadioButton maleButton;
    final JFormattedTextField date;
    final JLabel outputInfoLabel;

    public EntryController(City city, JLabel outputInfoLabel, JTextField lastNameInput, JTextField firstNameInput, JFormattedTextField date, JRadioButton maleButton) {
        this.city = city;

        this.lastNameInput = lastNameInput;
        this.firstNameInput = firstNameInput;
        this.maleButton = maleButton;
        this.date = date;
        this.outputInfoLabel = outputInfoLabel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if ("Confirm".equals(e.getActionCommand())) {
            Citizen citizen;

            String lastName = lastNameInput.getText();
            String firstName = firstNameInput.getText();

            Date birthDate = (Date) date.getValue();

            DateUtils dateUtils = new DateUtils();

            if (dateUtils.isValidDate(birthDate)) {
                if (maleButton.isSelected()) {
                    citizen = new Male(lastName, firstName, birthDate);
                    city.addCitizen(citizen);
                } else {
                    citizen = new Female(lastName, firstName, birthDate);
                    city.addCitizen(citizen);
                }

                outputInfoLabel.setText("Saved.");
            } else {
                outputInfoLabel.setText(dateUtils.invalidDateErrorMessage);
            }
        }
    }

}