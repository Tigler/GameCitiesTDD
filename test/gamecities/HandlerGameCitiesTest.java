/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gamecities;

import java.io.IOException;
import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author tigler
 */
public class HandlerGameCitiesTest {

    public HandlerGameCitiesTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    @Test
    public void testLoadCities() throws IOException {
        HandlerGameCities instance = new HandlerGameCities();
        ArrayList<String> result = null;
        boolean flagEx=false;
        try{
           instance.loadCities("cities.txt");
        }catch(IOException e){
            flagEx=true;
        }
        assertFalse(flagEx);
        ArrayList<String> cities = instance.getCities();
        String city = cities.get(4);
        assertEquals(city, "Адлер");
    }

}
