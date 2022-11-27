package fr.mat.citizen.views;

import fr.mat.citizen.controllers.EntryController;
import fr.mat.citizen.models.City;

import javax.swing.*;
import java.awt.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class EntryView extends JPanel {

    public EntryView(City city) {
        Dimension maxSize = new Dimension(2000, 50);

        JLabel infoLabel = new JLabel("Person's information:");
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

        EntryController entryController = new EntryController(city, outputInfoLabel, lastName, firstName, birthDate, male);

        JButton confirmButton = new JButton("Save");
        confirmButton.setActionCommand("Confirm");
        confirmButton.setForeground(Color.GREEN);
        confirmButton.addActionListener(entryController);

        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        add(infoLabel);
        add(lastName);
        add(firstName);

        add(dateLabel);
        add(birthDate);

        add(male);
        add(female);

        add(confirmButton);

        add(outputInfoLabel);
    }

}
