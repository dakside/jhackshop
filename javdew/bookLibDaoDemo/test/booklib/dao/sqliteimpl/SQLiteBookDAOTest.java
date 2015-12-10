/*
 * Copyright (C) 2015 Hoang Duc Chinh <dc.hoang.vn@gmail.com>
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
package booklib.dao.sqliteimpl;

import booklib.dto.Book;
import java.util.ArrayList;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Hoang Duc Chinh <dc.hoang.vn@gmail.com>
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
    public void testSearchBookByEmptyTitle() {
        System.out.println("---------------------------------");
        System.out.println("Search book: Empty Title");
        String title = "";
        SQLiteBookDAO instance = new SQLiteBookDAO();
        List<Book> expectResult = null;        
        List<Book> b = instance.searchBookByTitle(title);
        assertEquals(expectResult, b);        
        // TODO review the generated test code and remove the default call to fail.
        // fail("The test case is a prototype.");
    }
    
    /**
     * Test of searchBookByTitle method, of class SQLiteBookDAO.
     */
    @Test
    public void testSearchBookByNonExistTitle() {
        System.out.println("---------------------------------");
        System.out.println("Search book: Non-existing Title");
        String title = "Python";
        SQLiteBookDAO instance = new SQLiteBookDAO();
        boolean expectResultEmptyList = true;
        List<Book> b = instance.searchBookByTitle(title);
        assertEquals(expectResultEmptyList, b.isEmpty());        
        // TODO review the generated test code and remove the default call to fail.
        // fail("The test case is a prototype.");
    }

    /**
     * Test of searchBookByTitle method, of class SQLiteBookDAO.
     */
    @Test
    public void testSearchBookByExistTitle() {
        System.out.println("---------------------------------");
        System.out.println("Search book: Existed Title");
        String title = "The world as I see it";
        SQLiteBookDAO instance = new SQLiteBookDAO();        
        List<Book> b = instance.searchBookByTitle(title);
        System.out.println(b.size());
        assertEquals(title, b.get(0).getTitle());
        System.out.println(b.get(0).getTitle());

        // TODO review the generated test code and remove the default call to fail.
        // fail("The test case is a prototype.");
    }
    
    /**
     * Test of searchBookByTitle method, of class SQLiteBookDAO.
     */
    @Test
    public void testSearchBookByMoreExistTitles() {
        System.out.println("---------------------------------");
        System.out.println("Search book: Multiple books with same title");
        String title = "Harry Potter";
        SQLiteBookDAO instance = new SQLiteBookDAO();
        int expectResult = 2;
        List<Book> b = new ArrayList();
        b = instance.searchBookByTitle(title);
        System.out.println("Number: "+b.size());
        assertEquals(expectResult,b.size());
        for (int i=0; i<b.size(); i++){
            System.out.println("ID: " + b.get(i).getId());
        }
        // TODO review the generated test code and remove the default call to fail.
        // fail("The test case is a prototype.");
    }
    
    /**
     * Test of insertBook
     */    
    @Test
    public void testInsertBook() {
        System.out.println("---------------------------------");
        System.out.println("Insert book");
        Book newBook = new Book();
        String title = "The pleasure of finding things out";
        SQLiteBookDAO instance = new SQLiteBookDAO();
        newBook.setId(8);
        newBook.setTitle(title);
        instance.insertBook(newBook);
        List<Book> b = instance.searchBookByTitle(title);
        assertTrue(b.size()>0);
        if (b.size()>0) {
            System.out.println(b.get(0).getTitle());
            assertEquals(title, b.get(0).getTitle());
        }
    }    

    /**
     * Test of deleteBook
     */
    @Test
    public void testDeleteBook() {
        System.out.println("---------------------------------");
        System.out.println("Delete book");
        Book book = new Book();        
        String title = "The pleasure of finding things out";
        SQLiteBookDAO instance = new SQLiteBookDAO();
        book.setId(8);
        book.setTitle(title);
        instance.deleteBook(book);
        boolean expectResultEmptyList = true;
        List<Book> b = instance.searchBookByTitle(title);
        assertEquals(expectResultEmptyList, b.isEmpty());
    }
    
    /**
     * Get all the books
     */
    @Test
    public void testGetAll(){
        System.out.println("---------------------------------");
        System.out.println("Get all books");
        SQLiteBookDAO instance = new SQLiteBookDAO();
        int expectSize = 7;
        List<Book> b = instance.getAll();
        if (b.size()>0){
            for (int i=0; i < b.size(); i++) {
                System.out.println("ID: " + String.valueOf(b.get(i).getId()) + " - Title: " + String.valueOf(b.get(i).getTitle()));
            }
        }
        assertEquals(expectSize, b.size());        
    }
    
    /**
     * get number of books
     */
    @Test
    public void testGetNumberOfBook(){
        System.out.println("---------------------------------");
        System.out.println("Number of books");
        SQLiteBookDAO instance = new SQLiteBookDAO();
        int expectSize = 7;
        int bookTableSize = instance.getNumberOfBook();
        System.out.println(bookTableSize);
        assertEquals(expectSize, bookTableSize);
    }
}
