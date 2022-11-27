package fr.mat.citizen.utils;

import fr.mat.citizen.models.City;

import java.io.*;

public class SaveUtils {

    public final String fileName = "save.dat";

    public void save(City city) {
        FileOutputStream fileOutputStream;
        ObjectOutputStream objectInputStream;

        try {
            fileOutputStream = new FileOutputStream(fileName);
            objectInputStream = new ObjectOutputStream(fileOutputStream);

            objectInputStream.writeObject(city);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public City load() {
        FileInputStream fileOutputStream;
        ObjectInputStream objectInputStream;

        try {
            fileOutputStream = new FileInputStream(fileName);
            objectInputStream = new ObjectInputStream(fileOutputStream);

            return (City) objectInputStream.readObject();
        } catch (IOException | ClassNotFoundException e) {
            return null;
        }
    }

}
