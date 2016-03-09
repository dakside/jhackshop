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
package org.dakside.booklib.dao.sqliteimpl;

import org.dakside.booklib.dao.BookDAO;
import org.dakside.booklib.dto.Book;
import org.dakside.booklib.dao.utils.SQLiteBookTable;
import org.dakside.booklib.mockup.DummySQLite;
import com.almworks.sqlite4java.SQLiteConnection;
import com.almworks.sqlite4java.SQLiteException;
import com.almworks.sqlite4java.SQLiteStatement;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * SQLiteDAO implementation of BookDAO
 * 
 * @author Hoang Duc Chinh {@literal <dc.hoang.vn@gmail.com>}
 */
public class SQLiteBookDAO implements BookDAO {
    
    @Override
    public List<Book> searchBookByTitle(String title) {
        List<Book> bookList = new ArrayList();        

        if ((title == null) || (title.trim().isEmpty())) {            
            return null;
        }
        
        SQLiteConnection db = ConnectionFactory.getConnection();
        String sqliteQuery = "SELECT * FROM " + SQLiteBookTable.getBookTableName() + " WHERE title='"+title+"'";
        try {
            SQLiteStatement st = null;
            //st = db.prepare("SELECT * FROM Books WHERE title="+title);
            
            st = db.prepare(sqliteQuery);
            while (st.step()) {
                Book bookSearchResult = new Book();
                // System.out.println(st.columnString(1));
                bookSearchResult.setId(st.columnInt(0));
                bookSearchResult.setTitle(st.columnString(1));
                bookSearchResult.setAuthor(st.columnString(2));
                bookSearchResult.setYear(st.columnInt(3));
                bookSearchResult.setPublisher(st.columnString(4));
                bookSearchResult.setIsbn(st.columnString(5));
                bookSearchResult.setBarcode(st.columnString(6));
                bookSearchResult.setLanguage(st.columnString(7));
                bookSearchResult.setPrice(st.columnInt(8));
                bookSearchResult.setQuantity(st.columnInt(9));
                
                bookList.add(bookSearchResult);
            }
        } catch (SQLiteException ex) {
            
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
        
        int newId = this.getMaxID()+1;
        book.setId(newId);
        
        SQLiteConnection db = ConnectionFactory.getConnection();
        String sqliteQuery = "INSERT INTO " + SQLiteBookTable.getBookTableName() + " (ID,Title,Author,Year,Publisher,Isbn,BarCode,Language,Price,Quantity) "
                + "VALUES (?,?,?,?,?,?,?,?,?,?)";
        try {
            SQLiteStatement st = null;
            
            st = db.prepare(sqliteQuery);
            st.bind(1,book.getId());            
            st.bind(2,book.getTitle());
            st.bind(3,book.getAuthor());
            st.bind(4,book.getYear());
            st.bind(5,book.getPublisher());
            st.bind(6,book.getIsbn());
            st.bind(7,book.getBarcode());
            st.bind(8,book.getLanguage());              
            st.bind(9,book.getPrice());
            st.bind(10,book.getQuantity());
            
            //System.out.println(st.toString());
            st.stepThrough();
        } catch (SQLiteException ex) {

        } finally{
            db.dispose();
        } 
    }

    @Override
    public void deleteBook(Book book) {
        if ((book.getTitle() == null) || (book.getTitle().trim().isEmpty())) {            
            return;
        }
        
        if ((book.getId()<=0) && (book.getId()>this.getMaxID())){
            return;
        }
        
        SQLiteConnection db = ConnectionFactory.getConnection();
        String sqliteQuery = "DELETE FROM "+ SQLiteBookTable.getBookTableName() + " WHERE ID='"+ book.getId() + "' AND Title='" + book.getTitle() + "'";
        try {
            SQLiteStatement st = null;
            
            st = db.prepare(sqliteQuery);
            st.step();
        } catch (SQLiteException ex) {

        } finally{
            db.dispose();
        }
    }

    @Override
    public List<Book> getAll() {
        List<Book> bookList = new ArrayList();        
        
        SQLiteConnection db = ConnectionFactory.getConnection();
        String sqliteQuery = "SELECT * FROM " + SQLiteBookTable.getBookTableName();
        try {
            SQLiteStatement st = null;
            
            st = db.prepare(sqliteQuery);
            while (st.step()) {
                Book bookSearchResult = new Book();
                // System.out.println(st.columnString(1));
                bookSearchResult.setId(st.columnInt(0));
                bookSearchResult.setTitle(st.columnString(1));
                bookSearchResult.setAuthor(st.columnString(2));
                bookSearchResult.setYear(st.columnInt(3));
                bookSearchResult.setPublisher(st.columnString(4));
                bookSearchResult.setIsbn(st.columnString(5));
                bookSearchResult.setBarcode(st.columnString(6));
                bookSearchResult.setLanguage(st.columnString(7));
                bookSearchResult.setPrice(st.columnInt(8));
                bookSearchResult.setQuantity(st.columnInt(9));
                
                bookList.add(bookSearchResult);
            }
        } catch (SQLiteException ex) {

        } finally{
            db.dispose();
        }
        
        return bookList;
    }

    @Override
    public int getNumberOfBook() {
        SQLiteConnection db = ConnectionFactory.getConnection();
        String sqliteQuery = "SELECT COUNT(*) FROM " + SQLiteBookTable.getBookTableName();
        try {
            SQLiteStatement st = null;
            
            st = db.prepare(sqliteQuery);
            while (st.step()) {
                return st.columnInt(0);
            }
        } catch (SQLiteException ex) {

        } finally{
            db.dispose();
        }
        
        return 0;
    }    

    @Override
    public List<Book> searchBookByISBN(String isbn) {
        List<Book> bookList = new ArrayList();        
        // Dummy method
        if ((isbn == null) || (isbn.trim().isEmpty())) {            
            return null;
        }
        
        SQLiteConnection db = ConnectionFactory.getConnection();
        String sqliteQuery = "SELECT * FROM " + SQLiteBookTable.getBookTableName() + " WHERE isbn='"+isbn+"'";
        try {
            SQLiteStatement st = null;
            
            st = db.prepare(sqliteQuery);
            while (st.step()) {
                Book bookSearchResult = new Book();

                bookSearchResult.setId(st.columnInt(0));
                bookSearchResult.setTitle(st.columnString(1));
                bookSearchResult.setAuthor(st.columnString(2));
                bookSearchResult.setYear(st.columnInt(3));
                bookSearchResult.setPublisher(st.columnString(4));
                bookSearchResult.setIsbn(st.columnString(5));
                bookSearchResult.setBarcode(st.columnString(6));
                bookSearchResult.setLanguage(st.columnString(7));
                bookSearchResult.setPrice(st.columnInt(8));
                bookSearchResult.setQuantity(st.columnInt(9));
                
                bookList.add(bookSearchResult);
            }
        } catch (SQLiteException ex) {

        } finally{
            db.dispose();
        }
        
        return bookList;    
    }

    @Override
    public Book searchBookByID(int id) {
        Book bookSearchResult = new Book();        
        
        if ((id <= 0) || (id > this.getMaxID())){
            return null;
        }
        
        SQLiteConnection db = ConnectionFactory.getConnection();
        String sqliteQuery = "SELECT * FROM " + SQLiteBookTable.getBookTableName() + " WHERE id='"+id+"'";
        try {
            SQLiteStatement st = null;
            
            st = db.prepare(sqliteQuery);
            while (st.step()) {                
                bookSearchResult.setId(st.columnInt(0));
                bookSearchResult.setTitle(st.columnString(1));
                bookSearchResult.setAuthor(st.columnString(2));
                bookSearchResult.setYear(st.columnInt(3));
                bookSearchResult.setPublisher(st.columnString(4));
                bookSearchResult.setIsbn(st.columnString(5));
                bookSearchResult.setBarcode(st.columnString(6));
                bookSearchResult.setLanguage(st.columnString(7));
                bookSearchResult.setPrice(st.columnInt(8));
                bookSearchResult.setQuantity(st.columnInt(9));
                
                return bookSearchResult;
            }
        } catch (SQLiteException ex) {

        } finally{
            db.dispose();
        }
        
        return null;    
    }

    @Override
    public int getMaxID() {
        int maxID=0;
        
        SQLiteConnection db = ConnectionFactory.getConnection();
        String sqliteQuery = "SELECT max(id) FROM " + SQLiteBookTable.getBookTableName() + ";";
        try {
            SQLiteStatement st = null;
            
            st = db.prepare(sqliteQuery);
            while (st.step()) {                
                maxID = st.columnInt(0);                
            }
        } catch (SQLiteException ex) {

        } finally{
            db.dispose();
        }
        
        return maxID;        
    }

    @Override
    public void updateBook(Book book) {
        if ((book.getTitle() == null) || (book.getTitle().trim().isEmpty())) {            
            return;
        }
        
        if ((book.getId() <= 0) || (book.getId() > this.getMaxID())){
            return;
        }
        
        SQLiteConnection db = ConnectionFactory.getConnection();
        String sqliteQuery = "UPDATE " + SQLiteBookTable.getBookTableName()
                + " SET Title=?,Author=?,Year=?,Publisher=?,Isbn=?,BarCode=?,Language=?,Price=?,Quantity=?"
                + " WHERE ID=" + book.getId();
        
        try {
            SQLiteStatement st = null;
            
            st = db.prepare(sqliteQuery);
            st.bind(1,book.getTitle());
            st.bind(2,book.getAuthor());
            st.bind(3,book.getYear());
            st.bind(4,book.getPublisher());
            st.bind(5,book.getIsbn());
            st.bind(6,book.getBarcode());
            st.bind(7,book.getLanguage());              
            st.bind(8,book.getPrice());
            st.bind(9,book.getQuantity());
            
            st.stepThrough();
        } catch (SQLiteException ex) {
            // ex.printStackTrace();
        } finally{
            db.dispose();
        }
    }

    @Override
    public List<Book> searchBookByIncompleteTitle(String title) {
        List<Book> bookList = new ArrayList();        
        if ((title == null) || (title.trim().isEmpty())) {            
            return null;
        }
        
        SQLiteConnection db = ConnectionFactory.getConnection();
        String sqliteQuery = "SELECT * FROM " + SQLiteBookTable.getBookTableName() + " WHERE title LIKE '%"+title+"%'";
        try {
            SQLiteStatement st = null;
            
            st = db.prepare(sqliteQuery);
            while (st.step()) {
                Book bookSearchResult = new Book();
                // System.out.println(st.columnString(1));
                bookSearchResult.setId(st.columnInt(0));
                bookSearchResult.setTitle(st.columnString(1));
                bookSearchResult.setAuthor(st.columnString(2));
                bookSearchResult.setYear(st.columnInt(3));
                bookSearchResult.setPublisher(st.columnString(4));
                bookSearchResult.setIsbn(st.columnString(5));
                bookSearchResult.setBarcode(st.columnString(6));
                bookSearchResult.setLanguage(st.columnString(7));
                bookSearchResult.setPrice(st.columnInt(8));
                bookSearchResult.setQuantity(st.columnInt(9));
                
                bookList.add(bookSearchResult);
            }
        } catch (SQLiteException ex) {

        } finally{
            db.dispose();
        }
        
        return bookList;
        
    }
}

