package fr.mat.citizen.views;

import fr.mat.citizen.controllers.StatusController;
import fr.mat.citizen.models.City;

import javax.swing.*;
import java.awt.*;
import java.util.Observable;
import java.util.Observer;

public class StatusView extends JPanel implements Observer {

    final SpinnerNumberModel spinnerNumberModel;

    final City city;

    public StatusView(City city) {
        this.city = city;

        city.addObserver(this);

        Dimension maxSize = new Dimension(2000, 50);

        spinnerNumberModel = new SpinnerNumberModel(0, 0, city.citizens.size() - 1, 1);

        JLabel label = new JLabel("Citizen identification number:");
        JSpinner citizenId = new JSpinner(spinnerNumberModel);
        citizenId.setMaximumSize(maxSize);

        TextArea textArea = new TextArea();
        textArea.setEditable(false);

        StatusController statusController = new StatusController(city, citizenId, textArea);

        JButton confirmButton = new JButton("Continue");
        confirmButton.setActionCommand("Confirm");
        confirmButton.setForeground(Color.GREEN);
        confirmButton.addActionListener(statusController);

        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        add(label);
        add(citizenId);
        add(confirmButton);

        add(textArea);
    }

    @Override
    public void update(Observable o, Object arg) {
        spinnerNumberModel.setMaximum(city.citizens.size() - 1);
    }

}
