package fr.mat.citizen.views;

import fr.mat.citizen.controllers.MenuBarController;
import fr.mat.citizen.models.City;

import javax.swing.*;

public class MenuBarView extends JMenuBar {

    public MenuBarView(City city) {
        JMenu fileMenu = new JMenu("File");
        JMenu showMenu = new JMenu("View");

        JMenuItem saveMenuItem = new JMenuItem("Save");
        saveMenuItem.setActionCommand("Save");

        JMenuItem exitMenuItem = new JMenuItem("Quit");
        exitMenuItem.setActionCommand("Exit");

        JMenuItem listMenuItem = new JMenuItem("Citizens list");
        listMenuItem.setActionCommand("List");

        MenuBarController menuItemListener = new MenuBarController(city);

        saveMenuItem.addActionListener(menuItemListener);
        exitMenuItem.addActionListener(menuItemListener);
        listMenuItem.addActionListener(menuItemListener);

        fileMenu.add(saveMenuItem);
        fileMenu.addSeparator();
        fileMenu.add(exitMenuItem);

        showMenu.add(listMenuItem);

        add(fileMenu);
        add(showMenu);
    }

}
