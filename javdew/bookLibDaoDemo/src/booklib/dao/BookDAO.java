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
package booklib.dao;

import booklib.dto.Book;
import java.util.List;

/**
 *
 * @author HoangDucChinh <dc.hoang.vn@gmail.com>
 */
public interface BookDAO {
    
    /**
     * Get all the book
     * @return all the books
     */
    List<Book> getAll();

    /**
     *
     * @param title title of the book to be search
     * @return a list of books found
     */
    List<Book> searchBookByTitle(String title);
    
    /**
     * 
     * @param newBook book to be inserted
     */
    void insertBook(Book newBook);
    
    /**
     * 
     * @param book book to be deleted
     */
    void deleteBook(Book book);
    
    /**
     * 
     * @return total number of books in the database
     */
    int getNumberOfBook();
}
