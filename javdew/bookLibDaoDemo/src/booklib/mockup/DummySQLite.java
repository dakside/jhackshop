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
package booklib.mockup;

import booklib.dto.Book;
import java.util.HashMap;

/**
 *
 * @author HoangDucChinh <dc.hoang.vn@gmail.com>
 */
public class DummySQLite {

    public static HashMap<String, Book> BOOK_LIST = buildBookList();

    public static Book searchBook(String title) {
        if (title == null || title.trim().isEmpty()) {
            throw new RuntimeException("Invalid book information");
        } else {
            return BOOK_LIST.get(title);            
        }
    }

    private static HashMap<String, Book> buildBookList() {
        HashMap<String, Book> books = new HashMap<>();
        books.put("Lord of the rings", new Book("Lord of the rings"));
        books.put("Harry Potter", new Book("Harry Potter"));
        books.put("Harry Potter", new Book("Harry Potter"));
        return books;
    }
}
