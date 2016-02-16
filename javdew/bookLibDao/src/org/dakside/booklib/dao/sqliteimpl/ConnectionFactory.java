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

import com.almworks.sqlite4java.SQLiteConnection;
import com.almworks.sqlite4java.SQLiteException;
import com.almworks.sqlite4java.SQLiteStatement;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Properties;

/**
 * ConnectionFactory return a singleton for database connection
 *
 * @author Hoang Duc Chinh {@literal <dc.hoang.vn@gmail.com>}
 */
public class ConnectionFactory {

    //static reference to itself

    private static ConnectionFactory instance = new ConnectionFactory();
    private static File dbFile;
    private static String sqliteDBFile;

    //public static final String SQLITE_DB_FILE = ".\\rsc\\booklist.sqlite"; 

    //private constructor
    private ConnectionFactory() {
        // check the driver
        //this.dbFile = new File(SQLITE_DB_FILE);

        // need to upgrade later to read from configuration file
        Properties prop = new Properties();
        InputStream input = null;

        //String sqliteDBFile;
        try {
            input = new FileInputStream("./configuration.properties");

            // load a properties file
            prop.load(input);

            // get the property value and print it out
            this.sqliteDBFile = prop.getProperty("SQLITE_DB_FILE");
            this.dbFile = new File(this.sqliteDBFile);
            
            // System.out.println(this.dbFile.getAbsolutePath());            
            //System.out.println(this.sqliteDBFile);
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            if (input != null) {
                try {
                    input.close();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        }

        // check the driver
        //this.dbFile = new File(SQLITE_DB_FILE);        
    }

    private ConnectionFactory(String sqliteDBFile) {
        this.dbFile = new File(sqliteDBFile);
    }

    private SQLiteConnection createConnection() {
        SQLiteConnection connection = new SQLiteConnection(this.dbFile);
        try {
            // open the connection
            connection.open(false);
        } catch (SQLiteException ex) {
            //System.out.println("ERROR: Unable to Connect to Database.");
            return null;
        }

        return connection;
    }

    public static SQLiteConnection getConnection() {
        return instance.createConnection();
    }
}
