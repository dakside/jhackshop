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

import com.almworks.sqlite4java.SQLiteConnection;
import com.almworks.sqlite4java.SQLiteException;
import com.almworks.sqlite4java.SQLiteStatement;
import java.io.File;

/**
 * ConnectionFactory return a singleton for database connection
 * 
 * @author Hoang Duc Chinh <dc.hoang.vn@gmail.com>
 */
public class ConnectionFactory {
    //static reference to itself
    private static ConnectionFactory instance = new ConnectionFactory();
    private static File dbFile;
    public static final String SQLITE_DB_FILE = ".\\resources\\booklist.sqlite"; 
    //public static final String SQLITE_DB_FILE = "C:\\Temp\\booklist.sqlite"; 
    
    //private constructor
    private ConnectionFactory() {
        // check the driver
        this.dbFile = new File(SQLITE_DB_FILE);
        
        // need to upgrade later to read from configuration file
    }    
         
    private SQLiteConnection createConnection() {
        SQLiteConnection connection = new SQLiteConnection(this.dbFile);
        try {
            // open the connection
            connection.open(false);
        } catch (SQLiteException ex) {
            System.out.println("ERROR: Unable to Connect to Database.");
            return null;
        }
        
        return connection;
    }   
     
    public static SQLiteConnection getConnection() {
        return instance.createConnection();
    }    
    
}
