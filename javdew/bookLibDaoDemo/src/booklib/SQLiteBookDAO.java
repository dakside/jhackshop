/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
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
