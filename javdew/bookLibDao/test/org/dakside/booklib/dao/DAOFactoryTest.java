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
package org.dakside.booklib.dao;

import java.util.List;
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
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }    
    
    @Test
    public void testBookExist() {
        System.out.println("BookExit");
        DAOFactory instance = new SQLiteDAOFactory();
        BookDAO bookDAO = instance.createBookDAO();
        List<Book> b = bookDAO.searchBookByTitle("Harry Potter");
        if (b.size()>0)
            assertEquals("Harry Potter", b.get(0).getTitle());
    }    
}