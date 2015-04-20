/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.dakside.demo.exrate;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Le Tuan Anh <tuananh.ke@gmail.com>
 */
public class ExchangeRateTest {
    
    public ExchangeRateTest() {
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

    /**
     * Test of getFromCurrency method, of class ExchangeRate.
     */
    @Test
    public void testGetFromCurrency() {
        System.out.println("getFromCurrency");
        ExchangeRate instance = new ExchangeRate();
        String expResult = "";
        String result = instance.getFromCurrency();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setFromCurrency method, of class ExchangeRate.
     */
    @Test
    public void testSetFromCurrency() {
        System.out.println("setFromCurrency");
        String fromCurrency = "";
        ExchangeRate instance = new ExchangeRate();
        instance.setFromCurrency(fromCurrency);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getToCurrency method, of class ExchangeRate.
     */
    @Test
    public void testGetToCurrency() {
        System.out.println("getToCurrency");
        ExchangeRate instance = new ExchangeRate();
        String expResult = "";
        String result = instance.getToCurrency();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setToCurrency method, of class ExchangeRate.
     */
    @Test
    public void testSetToCurrency() {
        System.out.println("setToCurrency");
        String toCurrency = "";
        ExchangeRate instance = new ExchangeRate();
        instance.setToCurrency(toCurrency);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getRate method, of class ExchangeRate.
     */
    @Test
    public void testGetRate() {
        System.out.println("getRate");
        ExchangeRate instance = new ExchangeRate();
        double expResult = 0.0;
        double result = instance.getRate();
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setRate method, of class ExchangeRate.
     */
    @Test
    public void testSetRate() {
        System.out.println("setRate");
        double rate = 0.0;
        ExchangeRate instance = new ExchangeRate();
        instance.setRate(rate);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of isValid method, of class ExchangeRate.
     */
    @Test
    public void testIsValid() {
        System.out.println("isValid");
        ExchangeRate instance = new ExchangeRate();
        boolean expResult = false;
        boolean result = instance.isValid();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
