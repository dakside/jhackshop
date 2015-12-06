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
package booklib;

import booklib.mockup.DummySQLite;
import com.almworks.sqlite4java.SQLiteConnection;
import com.almworks.sqlite4java.SQLiteException;
import com.almworks.sqlite4java.SQLiteStatement;
import java.io.File;

/**
 *
 * @author HoangDucChinh <dc.hoang.vn@gmail.com>
 */
public class SQLiteBookDAO implements BookDAO {

    @Override
    public Book searchBookByTitle(String title) {
        // Dummy method
        if ((title == null) || (title.trim().isEmpty())) {
            return null;
        }
        
        SQLiteConnection db = new SQLiteConnection(new File("C:\\Temp\\booklist.sqlite"));
        try {
            db.open(true);
            SQLiteStatement st = null;
            st = db.prepare("SELECT * FROM Books WHERE 'Title'="+title);
            while (st.step()) {
                System.out.println(st.columnString(1));
            }
        } catch (SQLiteException ex) {
            //Logger.getLogger(TestSqliteHelloWorld.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        db.dispose();
        
        return DummySQLite.searchBook(title);
    }

}
