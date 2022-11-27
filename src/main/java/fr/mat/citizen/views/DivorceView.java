package fr.mat.citizen.views;

import fr.mat.citizen.controllers.DivorceController;
import fr.mat.citizen.models.City;

import javax.swing.*;
import java.awt.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Observable;
import java.util.Observer;

public class DivorceView extends JPanel implements Observer {

    final SpinnerNumberModel spinnerNumberModel;

    final City city;

    public DivorceView(City city) {
        this.city = city;

        city.addObserver(this);

        Dimension maxSize = new Dimension(2000, 50);

        spinnerNumberModel = new SpinnerNumberModel(0, 0, city.citizens.size() - 1, 1);

        JLabel idLabel = new JLabel("Citizen identification number:");
        JSpinner citizenId = new JSpinner(spinnerNumberModel);
        citizenId.setMaximumSize(maxSize);

        JLabel dateLabel = new JLabel("Date:");
        DateFormat dateFormat = new SimpleDateFormat("dd MMMM yyyy");
        JFormattedTextField divorceDate = new JFormattedTextField(dateFormat);
        divorceDate.setValue(new Date());
        divorceDate.setMaximumSize(maxSize);

        JLabel errorLabel = new JLabel(" ");

        DivorceController divorceController = new DivorceController(city, errorLabel, citizenId, divorceDate);

        JButton confirmButton = new JButton("Save");
        confirmButton.setActionCommand("Confirm");
        confirmButton.setForeground(Color.GREEN);
        confirmButton.addActionListener(divorceController);

        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        add(idLabel);
        add(citizenId);

        add(dateLabel);
        add(divorceDate);

        add(confirmButton);

        add(errorLabel);
    }

    @Override
    public void update(Observable o, Object arg) {
        spinnerNumberModel.setMaximum(city.citizens.size() - 1);
    }

}
