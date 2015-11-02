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
public class DAOFactoryTest {

    public DAOFactoryTest() {
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
     * Test of createBookDAO method, of class DAOFactory.
     */
    @Test
    public void testCreateBookDAO() {
        System.out.println("createBookDAO");
        DAOFactory instance = new SQLiteDAOFactory();
        BookDAO result = instance.createBookDAO();
        assertNotNull(result);
    }

    @Test
    public void testBookExist() {
        System.out.println("createBookDAO");
        DAOFactory instance = new SQLiteDAOFactory();
        BookDAO bookDAO = instance.createBookDAO();
        Book b = bookDAO.searchBookByTitle("Harry Potter");
        assertEquals("Harry Potter", b.getTitle());
    }

    @Test
    public void testBookNotExist() {
        System.out.println("createBookDAO");
        DAOFactory instance = new SQLiteDAOFactory();
        BookDAO bookDAO = instance.createBookDAO();
        Book b = bookDAO.searchBookByTitle(null);
        assertNull(b);
        
        b = bookDAO.searchBookByTitle(" ");
        assertNull(b);
    }
}
