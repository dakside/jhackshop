/*
 * Copyright (C) 2016 Hoang Duc Chinh {@literal <dc.hoang.vn@gmail.com>}
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package org.dakside.booklib.dao.sqliteimpl;

import java.util.List;
import org.dakside.booklib.dto.Book;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Hoang Duc Chinh {@literal <dc.hoang.vn@gmail.com>}
 */
public class SQLiteBookDAOTest {
    
    public SQLiteBookDAOTest() {
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
     * Test of searchBookByTitle method, of class SQLiteBookDAO.
     */
    @Test
    public void testSearchBookByTitle() {
        System.out.println("---------------------------------");
        System.out.println("Search book: Existed Title");
        String title = "Harry Potter";
        SQLiteBookDAO instance = new SQLiteBookDAO();        
        List<Book> b = instance.searchBookByTitle(title);
        System.out.println(b.size());
        assertEquals(title, b.get(0).getTitle());
        System.out.println(b.get(0).getTitle());
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of searchBookByTitle method, of class SQLiteBookDAO.
     */
    @Test
    public void testSearchBookByIncompleteTitle() {
        System.out.println("---------------------------------");
        System.out.println("Search book: Incomplete Title");
        String title = "harry";
        String expectedTitle = "Harry Potter";
        SQLiteBookDAO instance = new SQLiteBookDAO();        
        List<Book> b = instance.searchBookByIncompleteTitle(title);
        System.out.println(b.size());
        assertEquals(expectedTitle, b.get(0).getTitle());
        System.out.println(b.get(0).getTitle());
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }    
    
    /**
     * Test of searchBookByISBN method, of class SQLiteBookDAO.
     */
    @Test
    public void testSearchBookByISBN() {
        System.out.println("---------------------------------");
        System.out.println("searchBookByISBN");
        String isbn = "543265464";
        SQLiteBookDAO instance = new SQLiteBookDAO();        
        List<Book> b = instance.searchBookByISBN(isbn);
        System.out.println(b.size());
        assertEquals(isbn, b.get(0).getIsbn());
        System.out.println(b.get(0).getIsbn());
    }

    /**
     * Test of searchBookByID method, of class SQLiteBookDAO.
     */
    @Test
    public void testSearchBookByID() {
        // TODO review the generated test code and remove the default call to fail.
        System.out.println("---------------------------------");
        System.out.println("searchBookByID");
        String title = "Harry Potter";
        int id = 2;
        SQLiteBookDAO instance = new SQLiteBookDAO();        
        Book book = instance.searchBookByID(id);
        assertEquals(title, book.getTitle());
        System.out.println(book.getTitle());
    }

    /**
     * Test of getMaxID method, of class SQLiteBookDAO.
     */
    @Test
    public void testGetMaxID() {
        System.out.println("---------------------------------");        
        System.out.println("getMaxID");
        SQLiteBookDAO instance = new SQLiteBookDAO();
        int expResult = 3;
        int result = instance.getMaxID();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of insertBook method, of class SQLiteBookDAO.
     */  
    /*
    @Test
    public void testInsertBook() {
        System.out.println("---------------------------------");        
        System.out.println("insertBook");
        Book book = new Book();
        String title = "The world as I see it";
        book.setTitle(title);
        book.setIsbn("005-2550011951");
        book.setBarcode("005-2550011951");
        SQLiteBookDAO instance = new SQLiteBookDAO();
        instance.insertBook(book);
        int expResult = 4;
        int result = instance.getNumberOfBook();
        assertEquals(expResult, result);        

        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    //*/

    /**
     * Test of deleteBook method, of class SQLiteBookDAO.
     */
    /*
    @Test
    public void testDeleteBook() {
        System.out.println("---------------------------------"); 
        System.out.println("deleteBook");
        Book book = new Book();
        book.setId(4);
        book.setTitle("The world as I see it");
        SQLiteBookDAO instance = new SQLiteBookDAO();
        instance.deleteBook(book);
        
        int expResult = 3;
        int result = instance.getNumberOfBook();
        assertEquals(expResult, result);        
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    //*/

    /**
     * Test of getAll method, of class SQLiteBookDAO.
     */
    ///*
    @Test
    public void testGetAll() {
        System.out.println("---------------------------------");
        System.out.println("getAll");
        SQLiteBookDAO instance = new SQLiteBookDAO();
        int expResult = 5;
        List<Book> result = instance.getAll();
        assertEquals(expResult, result.size());
        for (int i=0;i<result.size();i++){
            System.out.println("ID: "+ result.get(i).getId() + " | Title: "+ result.get(i).getTitle() + " | ISBN: " + result.get(i).getIsbn());
        }
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    //*/
    
    /**
     * Test of getNumberOfBook method, of class SQLiteBookDAO.
     */
    ///*
    @Test
    public void testGetNumberOfBook() {
        System.out.println("---------------------------------");
        System.out.println("getNumberOfBook");
        SQLiteBookDAO instance = new SQLiteBookDAO();
        int expResult = 3;
        int result = instance.getNumberOfBook();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    //*/

    /**
     * Test of updateBook method, of class SQLiteBookDAO.
     */
    ///*
    @Test
    public void testUpdateBook() {
        System.out.println("---------------------------------");
        System.out.println("updateBook");
        Book book = new Book();
        book.setId(1);
        book.setTitle("How to program Java");
        book.setAuthor("Deitel");
        book.setYear(2007);
        book.setIsbn("12354353");
        book.setBarcode("12425345");
        book.setLanguage("English");
        book.setQuantity(1);
        SQLiteBookDAO instance = new SQLiteBookDAO();
        instance.updateBook(book);
        int expResult = 1;
        int result=instance.searchBookByID(1).getQuantity();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    //*/
}
