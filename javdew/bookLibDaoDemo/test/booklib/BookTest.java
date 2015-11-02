/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package booklib;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author HoangDucChinh <dc.hoang.vn@gmail.com>
 */
public class BookTest {

    public BookTest() {
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
     * Test of getTitle method, of class Book.
     */
    @Test
    public void testGetSetBookData() {
        System.out.println("getTitle");
        Book instance = new Book();
        instance.setTitle("Harry Potter");
        String expResult = "Harry Potter";
        String result = instance.getTitle();
        assertEquals(expResult, result);
    }

}
