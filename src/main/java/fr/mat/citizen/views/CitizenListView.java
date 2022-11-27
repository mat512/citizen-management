package fr.mat.citizen.views;

import fr.mat.citizen.models.City;

import javax.swing.*;
import java.awt.*;
import java.util.Observable;
import java.util.Observer;

public class CitizenListView extends JFrame implements Observer {

    final TextArea textArea;

    final City city;

    public CitizenListView(City city) {
        this.city = city;

        city.addObserver(this);

        textArea = new TextArea(city.getAllCitizenStatus());
        textArea.setEditable(false);

        JPanel panel = new JPanel();

        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        panel.add(textArea);

        add(panel);

        setSize(400, 600);
        setMinimumSize(new Dimension(400, 600));

        setTitle("Citizens list");

        setVisible(true);
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
    }

    @Override
    public void update(Observable o, Object arg) {
        textArea.setText(city.getAllCitizenStatus());
    }

}
