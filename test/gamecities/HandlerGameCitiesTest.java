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
        boolean flagEx = false;
        try {
            instance.loadCities("cities.txt");
        } catch (IOException e) {
            flagEx = true;
        }
        assertFalse(flagEx);
        ArrayList<String> cities = instance.getCities();
        String city = cities.get(4);
        assertEquals(city, "Адлер");
    }

    @Test
    public void testLoadCitiesException() throws IOException {
        HandlerGameCities instance = new HandlerGameCities();
        ArrayList<String> result = null;
        boolean flagEx = false;
        try {
            instance.loadCities("cities1.txt");
        } catch (IOException e) {
            flagEx = true;
        }
        assertTrue(flagEx);
    }

    @Test
    public void testGetFirstCharTrueCheck() throws Exception {
        HandlerGameCities instance = new HandlerGameCities();
        Character expResult = 'К';
        Character result = instance.getFirstChar("Краснодар");
        assertEquals(expResult, result);
    }

    @Test
    public void testGetFirstCharFalseCheck() throws Exception {
        HandlerGameCities instance = new HandlerGameCities();
        Character expResult = 'Ц';
        Character result = instance.getFirstChar("Краснодар");
        assertNotEquals(expResult, result);
    }

    @Test
    public void testGetFirstCharExceptionEmptyCity() throws Exception {
        HandlerGameCities instance = new HandlerGameCities();
        boolean fladEx = false;
        try {
            Character result = instance.getFirstChar("");
        } catch (Exception e) {
            assertEquals(e.getMessage(), "Не удалось извлечь первую букву слова");
            fladEx = true;
        }
        assertTrue(fladEx);
    }

    @Test
    public void testGetFirstCharExceptionNullCity() throws Exception {
        HandlerGameCities instance = new HandlerGameCities();
        boolean fladEx = false;
        try {
            Character result = instance.getFirstChar(null);
        } catch (Exception e) {
            assertEquals(e.getMessage(), "Не удалось извлечь первую букву слова");
            fladEx = true;
        }
        assertTrue(fladEx);
    }

    @Test
    public void testGetLastCharTrueCheck() throws Exception {
        HandlerGameCities instance = new HandlerGameCities();
        Character expResult = 'А'; //если маленькая буква вернут все равно большую, чтобы сравнивать 
        Character result = instance.getLastChar("Москва");
        assertEquals(expResult, result);
    }

    @Test
    public void testGetLastCharFalseCheck() throws Exception {
        HandlerGameCities instance = new HandlerGameCities();
        Character expResult = 'Е';
        Character result = instance.getLastChar("Москва");
        assertNotEquals(expResult, result);
    }

    @Test
    public void testGetLastCharCheckOtherChars() throws Exception {
        HandlerGameCities instance = new HandlerGameCities();
        Character expResult = 'Н';
        Character result = instance.getLastChar("Рязань");
        assertEquals(expResult, result);

        expResult = 'Н';
        result = instance.getLastChar("Рязаны");
        assertEquals(expResult, result);

        expResult = 'Н';
        result = instance.getLastChar("Рязанъ");
        assertEquals(expResult, result);

        expResult = 'И';
        result = instance.getLastChar("Каменск-Уральский");
        assertEquals(expResult, result);
    }

    @Test
    public void testGetLastCharExceptionEmptyCity() throws Exception {
        HandlerGameCities instance = new HandlerGameCities();
        boolean fladEx = false;
        try {
            Character result = instance.getLastChar("");
        } catch (Exception e) {
            assertEquals(e.getMessage(), "Не удалось извлечь последнюю букву слова");
            fladEx = true;
        }
        assertTrue(fladEx);
    }

    @Test
    public void testGetLastCharExceptionNullCity() throws Exception {
        HandlerGameCities instance = new HandlerGameCities();
        boolean fladEx = false;
        try {
            Character result = instance.getLastChar(null);
        } catch (Exception e) {
            assertEquals(e.getMessage(), "Не удалось извлечь последнюю букву слова");
            fladEx = true;
        }
        assertTrue(fladEx);
    }

    @Test
    public void testGetRandomCity() throws Exception {
        System.out.println("getRandomCity");
        HandlerGameCities instance = new HandlerGameCities();
        instance.loadCities("cities.txt");
        String result = instance.getRandomCity();
        ArrayList<String> cities = instance.getCities();
        boolean flagEq = false;
        for (String city : cities) {
            if (city.equals(result)) {
                flagEq = true;
            }
        }
        assertTrue(flagEq);
    }

}
