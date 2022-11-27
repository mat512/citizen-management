package fr.mat.citizen.views;

import fr.mat.citizen.controllers.DeathController;
import fr.mat.citizen.models.City;

import javax.swing.*;
import java.awt.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Observable;
import java.util.Observer;

public class DeathView extends JPanel implements Observer {

    final SpinnerNumberModel spinnerNumberModel;

    final City city;

    public DeathView(City city) {
        this.city = city;

        city.addObserver(this);

        Dimension maxSize = new Dimension(2000, 50);

        spinnerNumberModel = new SpinnerNumberModel(0, 0, city.citizens.size() - 1, 1);

        JLabel label = new JLabel("Citizen identification number:");
        JSpinner citizenId = new JSpinner(spinnerNumberModel);
        citizenId.setMaximumSize(maxSize);

        JLabel dateLabel = new JLabel("Date:");
        DateFormat dateFormat = new SimpleDateFormat("dd MMMM yyyy");
        JFormattedTextField deathDate = new JFormattedTextField(dateFormat);
        deathDate.setValue(new Date());
        deathDate.setMaximumSize(maxSize);

        JLabel errorLabel = new JLabel(" ");

        DeathController deathController = new DeathController(city, errorLabel, citizenId, deathDate);

        JButton confirmButton = new JButton("Save");
        confirmButton.setActionCommand("Confirm");
        confirmButton.setForeground(Color.GREEN);
        confirmButton.addActionListener(deathController);

        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        add(label);
        add(citizenId);

        add(dateLabel);
        add(deathDate);

        add(confirmButton);

        add(errorLabel);
    }

    @Override
    public void update(Observable o, Object arg) {
        spinnerNumberModel.setMaximum(city.citizens.size() - 1);
    }

}
