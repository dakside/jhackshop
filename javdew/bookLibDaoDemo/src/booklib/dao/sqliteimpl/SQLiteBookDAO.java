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

import booklib.dao.BookDAO;
import booklib.dto.Book;
import booklib.dao.utils.SQLiteSchema;
import booklib.mockup.DummySQLite;
import com.almworks.sqlite4java.SQLiteConnection;
import com.almworks.sqlite4java.SQLiteException;
import com.almworks.sqlite4java.SQLiteStatement;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * SQLiteDAO implementation of BookDAO
 * 
 * @author HoangDucChinh <dc.hoang.vn@gmail.com>
 */
public class SQLiteBookDAO implements BookDAO {
    
    @Override
    public List<Book> searchBookByTitle(String title) {
        List<Book> bookList = new ArrayList();        
        // Dummy method
        if ((title == null) || (title.trim().isEmpty())) {            
            return null;
        }
        
        SQLiteConnection db = ConnectionFactory.getConnection();
        String sqliteQuery = "SELECT * FROM " + SQLiteSchema.getBookTableName() + " WHERE title='"+title+"'";
        try {
            SQLiteStatement st = null;
            //st = db.prepare("SELECT * FROM Books WHERE title="+title);
            
            st = db.prepare(sqliteQuery);
            while (st.step()) {
                Book bookSearchResult = new Book();
                // System.out.println(st.columnString(1));
                bookSearchResult.setId(st.columnInt(0));
                bookSearchResult.setTitle(st.columnString(1));                
                bookList.add(bookSearchResult);
            }
        } catch (SQLiteException ex) {
            //Logger.getLogger(TestSqliteHelloWorld.class.getName()).log(Level.SEVERE, null, ex);
        } finally{
            db.dispose();
        } //*/
        
        /*
        bookSearchResult = DummySQLite.searchBook(title);
        if (bookSearchResult!=null)
            bookList.add(bookSearchResult);
        //*/
        return bookList;
    }

    @Override
    public void insertBook(Book book) {
        if ((book.getTitle() == null) || (book.getTitle().trim().isEmpty())) {            
            return;
        }
        
        SQLiteConnection db = ConnectionFactory.getConnection();
        String sqliteQuery = "INSERT INTO " + SQLiteSchema.getBookTableName() + " (ID,Title) VALUES (?,?)";        
        try {
            SQLiteStatement st = null;
            
            st = db.prepare(sqliteQuery);
            st.bind(1,book.getId());            
            st.bind(2,book.getTitle());
            //System.out.println(sqliteQuery);
            st.stepThrough();
        } catch (SQLiteException ex) {
            //Logger.getLogger(TestSqliteHelloWorld.class.getName()).log(Level.SEVERE, null, ex);
        } finally{
            db.dispose();
        } //*/        
    }

    @Override
    public void deleteBook(Book book) {
        if ((book.getTitle() == null) || (book.getTitle().trim().isEmpty())) {            
            return;
        }
        
        SQLiteConnection db = ConnectionFactory.getConnection();
        String sqliteQuery = "DELETE FROM "+ SQLiteSchema.getBookTableName() + " WHERE ID='"+ book.getId() + "' AND Title='" + book.getTitle() + "'";
        try {
            SQLiteStatement st = null;
            
            st = db.prepare(sqliteQuery);
            st.step();
        } catch (SQLiteException ex) {
            //Logger.getLogger(TestSqliteHelloWorld.class.getName()).log(Level.SEVERE, null, ex);
        } finally{
            db.dispose();
        }
    }

    @Override
    public List<Book> getAll() {
        List<Book> bookList = new ArrayList();
        
        
        SQLiteConnection db = ConnectionFactory.getConnection();
        String sqliteQuery = "SELECT * FROM " + SQLiteSchema.getBookTableName();
        try {
            SQLiteStatement st = null;
            
            st = db.prepare(sqliteQuery);
            while (st.step()) {
                Book bookSearchResult = new Book();
                // System.out.println(st.columnString(1));
                bookSearchResult.setId(st.columnInt(0));
                bookSearchResult.setTitle(st.columnString(1));
                bookList.add(bookSearchResult);
            }
        } catch (SQLiteException ex) {
            //Logger.getLogger(TestSqliteHelloWorld.class.getName()).log(Level.SEVERE, null, ex);
        } finally{
            db.dispose();
        } //*/
        
        return bookList;
    }

    @Override
    public int getNumberOfBook() {
        SQLiteConnection db = ConnectionFactory.getConnection();
        String sqliteQuery = "SELECT COUNT(*) FROM " + SQLiteSchema.getBookTableName();
        try {
            SQLiteStatement st = null;
            
            st = db.prepare(sqliteQuery);
            while (st.step()) {
                //System.out.println("Number of books: "+st.columnString(0));
                return st.columnInt(0);
            }
        } catch (SQLiteException ex) {
            //Logger.getLogger(TestSqliteHelloWorld.class.getName()).log(Level.SEVERE, null, ex);
        } finally{
            db.dispose();
        } //*/
        
        return 0;
    }
    
}

