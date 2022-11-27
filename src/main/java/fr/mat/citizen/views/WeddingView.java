package fr.mat.citizen.views;

import fr.mat.citizen.controllers.WeddingController;
import fr.mat.citizen.models.City;

import javax.swing.*;
import java.awt.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Observable;
import java.util.Observer;

public class WeddingView extends JPanel implements Observer {

    final SpinnerNumberModel spinnerNumberModel1;
    final SpinnerNumberModel spinnerNumberModel2;

    final City city;

    public WeddingView(City city) {
        this.city = city;

        city.addObserver(this);

        Dimension maxSize = new Dimension(2000, 50);

        spinnerNumberModel1 = new SpinnerNumberModel(0, 0, city.citizens.size() - 1, 1);
        spinnerNumberModel2 = new SpinnerNumberModel(1, 0, city.citizens.size() - 1, 1);

        JLabel husbandLabel = new JLabel("Husband's identification number:");
        JSpinner husbandId = new JSpinner(spinnerNumberModel1);
        husbandId.setMaximumSize(maxSize);

        JLabel wifeLabel = new JLabel("Wife's identification number:");
        JSpinner wifeId = new JSpinner(spinnerNumberModel2);
        wifeId.setMaximumSize(maxSize);

        JLabel dateLabel = new JLabel("Date:");
        DateFormat dateFormat = new SimpleDateFormat("dd MMMM yyyy");
        JFormattedTextField weddingDate = new JFormattedTextField(dateFormat);
        weddingDate.setValue(new Date());
        weddingDate.setMaximumSize(maxSize);

        JLabel errorLabel = new JLabel(" ");

        WeddingController weddingController = new WeddingController(city, errorLabel, husbandId, wifeId, weddingDate);

        JButton confirmButton = new JButton("Save");
        confirmButton.setActionCommand("Confirm");
        confirmButton.setForeground(Color.GREEN);
        confirmButton.addActionListener(weddingController);

        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        add(husbandLabel);
        add(husbandId);

        add(wifeLabel);
        add(wifeId);

        add(dateLabel);
        add(weddingDate);

        add(confirmButton);

        add(errorLabel);
    }

    @Override
    public void update(Observable o, Object arg) {
        spinnerNumberModel1.setMaximum(city.citizens.size() - 1);
        spinnerNumberModel2.setMaximum(city.citizens.size() - 1);
    }

}
