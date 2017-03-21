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
        
    }

}
