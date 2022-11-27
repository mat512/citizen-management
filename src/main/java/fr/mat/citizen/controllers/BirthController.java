package fr.mat.citizen.controllers;

import fr.mat.citizen.models.City;
import fr.mat.citizen.utils.DateUtils;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

public class BirthController implements ActionListener {

    final City city;

    final JSpinner fatherId;
    final JSpinner motherId;

    final JTextField lastNameInput;
    final JTextField firstNameInput;
    final JRadioButton maleButton;
    final JFormattedTextField date;

    final JLabel outputInfoLabel;

    public BirthController(City city, JLabel outputInfoLabel, JSpinner fatherId, JSpinner mereId, JTextField lastNameInput, JTextField firstNameInput, JFormattedTextField date, JRadioButton maleButton) {
        this.city = city;

        this.fatherId = fatherId;
        this.motherId = mereId;

        this.lastNameInput = lastNameInput;
        this.firstNameInput = firstNameInput;
        this.maleButton = maleButton;
        this.date = date;

        this.outputInfoLabel = outputInfoLabel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if ("Confirm".equals(e.getActionCommand())) {
            int fatherIndex = (int) fatherId.getValue();
            int motherIndex = (int) motherId.getValue();

            String lastName = lastNameInput.getText();
            String firstName = firstNameInput.getText();

            Date birthDate = (Date) date.getValue();

            DateUtils dateUtils = new DateUtils();

            if (dateUtils.isValidDate(birthDate)) {
                String returnMessage = city.addBirth(city.citizens.get(fatherIndex), city.citizens.get(motherIndex), lastName, firstName, birthDate, maleButton.isSelected());
                outputInfoLabel.setText(returnMessage);
            } else {
                outputInfoLabel.setText(dateUtils.invalidDateErrorMessage);
            }
        }
    }

}