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
package org.dakside.booklib.dao.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 *
 * @author Hoang Duc Chinh {@literal <dc.hoang.vn@gmail.com>}
 */
public class SQLiteBookTable {
    private static SQLiteBookTable instance = new SQLiteBookTable();
    private static String bookTableName;
    private static final String BOOK_TABLE = "Books";
    //private String userTable;
    
    public SQLiteBookTable() {
        // need to upgrade later to read from configuration file
        Properties prop = new Properties();
        InputStream input = null;

        //String sqliteDBFile;

        try {
            input = new FileInputStream("configuration.properties");

            // load a properties file
            prop.load(input);

            // get the property value and print it out
            this.bookTableName = prop.getProperty("BOOK_TABLE_NAME");
            //this.dbFile = new File(this.sqliteDBFile);
        } 
        catch (IOException ex) {
            ex.printStackTrace();
        } 
        finally {
            if (input != null) {
                try {
                    input.close();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        }
    }
    
    /*
    private SQLiteBookTable(){
        this.bookTableName = this.BOOK_TABLE;
    }*/    
    
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
    
    /**
     * 
     * @return the instance of this object
     */
    public static SQLiteBookTable getTableInstance() {
        return instance;
    }
}
