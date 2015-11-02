/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package booklib;

/**
 *
 * @author HoangDucChinh <dc.hoang.vn@gmail.com>
 */
public class SQLiteDAOFactory implements DAOFactory {
    
    @Override
    public BookDAO createBookDAO() {
        return new SQLiteBookDAO();
    }

}
