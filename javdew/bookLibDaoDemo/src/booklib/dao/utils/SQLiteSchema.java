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
package booklib.dao.utils;

/**
 *
 * @author Hoang Duc Chinh <dc.hoang.vn@gmail.com>
 */
public class SQLiteSchema {
    private static SQLiteSchema instance = new SQLiteSchema();
    public static String bookTableName;
    private static final String BOOK_TABLE = "Books";
    //private String userTable;

    /**
     * @return the bookTableName
     */
    public static String getBookTableName() {
        return bookTableName;
    }

    /**
     * @param aBookTableName the bookTableName to set
     */
    public static void setBookTableName(String aBookTableName) {
        bookTableName = aBookTableName;
    }
    
    private SQLiteSchema(){
        this.bookTableName = this.BOOK_TABLE;
    }
    
    public static SQLiteSchema getSchema() {
        return instance;
    }   
    
}
