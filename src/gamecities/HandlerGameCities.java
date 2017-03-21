/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gamecities;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author tigler
 */
public class HandlerGameCities {

    private ArrayList<String> cities;

    public HandlerGameCities() {
        cities = new ArrayList<>();
    }

    public ArrayList<String> getCities() {
        return cities;
    }

    public void loadCities(String path) throws IOException {
        try {
            final BufferedReader in = new BufferedReader(new FileReader(path));
            for (String city; (city = in.readLine()) != null;) {
                cities.add(city); // и сложим все имена в этот массив
            }
            in.close();
        } catch (IOException e) {
            throw new IOException("Не удалось получить список городов");
        }
    }

    public char getFirstChar(String city) throws Exception {
        char firstChar;
        try {
            firstChar = city.toUpperCase().charAt(0);
        } catch (Exception e) {
            throw new Exception("Не удалось извлечь первую букву слова");
        }
        return firstChar;
    }

}
