/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package booklib.mockup;

import booklib.Book;
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
        return books;
    }
}
