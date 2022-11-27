package fr.mat.citizen.views;

import fr.mat.citizen.controllers.BirthController;
import fr.mat.citizen.models.City;

import javax.swing.*;
import java.awt.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Observable;
import java.util.Observer;

public class BirthView extends JPanel implements Observer {

    final SpinnerNumberModel spinnerNumberModel1;
    final SpinnerNumberModel spinnerNumberModel2;

    final City city;

    public BirthView(City city) {
        this.city = city;

        city.addObserver(this);

        Dimension maxSize = new Dimension(2000, 50);

        spinnerNumberModel1 = new SpinnerNumberModel(0, 0, city.citizens.size() - 1, 1);
        spinnerNumberModel2 = new SpinnerNumberModel(1, 0, city.citizens.size() - 1, 1);

        JLabel fatherLabel = new JLabel("Father's identification number:");
        JSpinner fatherId = new JSpinner(spinnerNumberModel1);
        fatherId.setMaximumSize(maxSize);
        JLabel motherLabel = new JLabel("Mother's identification number:");
        JSpinner motherId = new JSpinner(spinnerNumberModel2);
        motherId.setMaximumSize(maxSize);

        JLabel childLabel = new JLabel("Child's information:");
        JTextField lastName = new JTextField("Last name");
        lastName.setMaximumSize(maxSize);
        JTextField firstName = new JTextField("First name");
        firstName.setMaximumSize(maxSize);

        JLabel dateLabel = new JLabel("Birth date:");
        DateFormat dateFormat = new SimpleDateFormat("dd MMMM yyyy");
        JFormattedTextField birthDate = new JFormattedTextField(dateFormat);
        birthDate.setValue(new Date());
        birthDate.setMaximumSize(maxSize);

        JRadioButton male = new JRadioButton("Male");
        male.setSelected(true);
        JRadioButton female = new JRadioButton("Female");
        ButtonGroup genderButtonGroup = new ButtonGroup();
        genderButtonGroup.add(male);
        genderButtonGroup.add(female);

        JLabel outputInfoLabel = new JLabel(" ");

        BirthController birthController = new BirthController(city, outputInfoLabel, fatherId, motherId, lastName, firstName, birthDate, male);

        JButton confirmButton = new JButton("Save");
        confirmButton.setActionCommand("Confirm");
        confirmButton.setForeground(Color.GREEN);
        confirmButton.addActionListener(birthController);

        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        add(fatherLabel);
        add(fatherId);
        add(motherLabel);
        add(motherId);

        add(childLabel);
        add(lastName);
        add(firstName);

        add(dateLabel);
        add(birthDate);

        add(male);
        add(female);

        add(confirmButton);

        add(outputInfoLabel);
    }

    @Override
    public void update(Observable o, Object arg) {
        spinnerNumberModel1.setMaximum(city.citizens.size() - 1);
        spinnerNumberModel2.setMaximum(city.citizens.size() - 1);
    }

}
