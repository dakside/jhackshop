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
public class CurrencyConverterTest {

    public CurrencyConverterTest() {
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
     * Test of convert method, of class CurrencyConverter.
     */
    @Test(expected = CurrencyException.class)
    public void testConvertWithNullRate() throws Exception {
        System.out.println("Convert with null exchange rate");
        Money input = new Money(100, "SGD");
        ExchangeRate rate = null;
        CurrencyConverter instance = new CurrencyConverter();
        Money expResult = null;
        Money result = instance.convert(input, rate);
        assertEquals(expResult, result);
    }

    @Test(expected = CurrencyException.class)
    public void testConvertWithNullMoney() throws Exception {
        System.out.println("Convert with null money");
        Money input = null;
        ExchangeRate rate = new ExchangeRate("USD", "SGD", 1.4d);
        CurrencyConverter instance = new CurrencyConverter();
        Money expResult = null;
        Money result = instance.convert(input, rate);
        assertEquals(expResult, result);
    }

    @Test
    public void testConvert() throws Exception {
        System.out.println("Convert 100 USD to SGD");
        Money input = new Money(100, "USD");
        ExchangeRate rate = new ExchangeRate("USD", "SGD", 1.4d);
        CurrencyConverter instance = new CurrencyConverter();
        Money expResult = new Money(140d, "SGD");
        Money result = instance.convert(input, rate);
        assertNotNull(result);
        assertTrue(expResult.equals(result));
    }
}
