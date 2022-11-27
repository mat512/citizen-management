package fr.mat.citizen.views;

import fr.mat.citizen.models.City;

import javax.swing.*;
import java.awt.*;

public class MainView extends JFrame {

    public MainView(City city) {
        JTabbedPane tabs = new JTabbedPane(JTabbedPane.TOP, JTabbedPane.WRAP_TAB_LAYOUT);

        WeddingView weddingView = new WeddingView(city);
        DivorceView divorceView = new DivorceView(city);
        BirthView birthView = new BirthView(city);
        DeathView deathView = new DeathView(city);
        StatusView statusView = new StatusView(city);
        EntryView entryView = new EntryView(city);

        tabs.addTab("Wedding", weddingView);
        tabs.addTab("Divorce", divorceView);
        tabs.addTab("Birth", birthView);
        tabs.addTab("Death", deathView);
        tabs.addTab("Status", statusView);
        tabs.addTab("Entry", entryView);

        setJMenuBar(new MenuBarView(city));
        add(tabs);

        setSize(500, 500);
        setMinimumSize(new Dimension(500,400));

        setTitle("Citizen management");

        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

}
