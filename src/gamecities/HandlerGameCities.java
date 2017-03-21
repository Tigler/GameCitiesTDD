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
import java.util.Random;

/**
 *
 * @author tigler
 */
public class HandlerGameCities {

    private ArrayList<String> cities;
    private ArrayList<String> activeCities;
    private String prevCity;

    public HandlerGameCities() {
        cities = new ArrayList<>();
        activeCities = new ArrayList<>();
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

    public char getLastChar(String city) throws Exception {
        char last;
        try {
            int pos = city.length() - 1;
            char lastChar = city.toUpperCase().charAt(pos);
            if (city.toUpperCase().charAt(pos) == 'Й') {
                return 'И';
            } else if (lastChar == 'Ь' || lastChar == 'Ы' || lastChar == 'Ъ') {
                pos--;
            }
            last = city.toUpperCase().charAt(pos);
        } catch (Exception у) {
            throw new Exception("Не удалось извлечь последнюю букву слова");
        }
        return last;
    }

    public String getRandomCity() {
        Random r = new Random(System.currentTimeMillis());
        int idx = r.nextInt(cities.size());
        activeCities.add(cities.get(idx));
        prevCity = cities.get(idx);
        return cities.get(idx);

    }

}
