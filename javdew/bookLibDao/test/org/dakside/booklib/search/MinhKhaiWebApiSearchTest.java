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
package org.dakside.booklib.search;

import java.util.List;
import org.dakside.booklib.dao.BookDAO;
import org.dakside.booklib.dao.DAOFactory;
import org.dakside.booklib.dao.sqliteimpl.SQLiteDAOFactory;
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
public class MinhKhaiWebApiSearchTest {

    public MinhKhaiWebApiSearchTest() {
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
     * Test of searchByISBN method, of class MinhKhaiWebApiSearch.
     */
    /*
    @Test
    public void testSearchByISBN() {
        System.out.println("searchByISBN");
        String isbn = "8936071670328";
        //String isbn = "8936071672537";
        //String isbn = "8935235200296";
        MinhKhaiWebApiSearch instance = new MinhKhaiWebApiSearch();
        Book expResult = null;
        Book result = instance.searchByISBN(isbn);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }//*/

    @Test
    public void testSearchByIsbnHtml() {
        System.out.println("searchByISBN");
        /* book on Minh Khai store */
        //String isbn = "8935230005483";
        //String isbn = "8936071672537";
        String isbn = "8935235200296";
        //String isbn = "8934974133827";
        /* other source */
        //String isbn = "9780747589358";
        MinhKhaiWebApiSearch instance = new MinhKhaiWebApiSearch();
        Book expResult = null;
        Book result = instance.searchByISBN(isbn);
        if (result!=null){
            System.out.println("Result is: \n"+result.toString());
        }        
        DAOFactory sqliteDao = new SQLiteDAOFactory();
        BookDAO bookDAO = sqliteDao.createBookDAO();
        bookDAO.deleteBook(result);
        bookDAO.insertBook(result);
        List<Book> bookList = bookDAO.searchBookByISBN(isbn);
        if (bookList!=null && !bookList.isEmpty())
            System.out.println("In library: "+bookList.get(0).getTitle());
        assertEquals(expResult, result);
    }
}
