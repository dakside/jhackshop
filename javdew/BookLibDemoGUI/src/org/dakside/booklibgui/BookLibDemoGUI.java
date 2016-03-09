/*
 * Copyright (C) 2016 Hoang Duc Chinh {@literal <dc.hoang.vn@gmail.com>}
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

package org.dakside.booklibgui;

import java.awt.Dimension;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.*;
import org.dakside.booklib.dao.BookDAO;
import org.dakside.booklib.dao.DAOFactory;
import org.dakside.booklib.dao.sqliteimpl.SQLiteDAOFactory;
import org.dakside.booklib.dto.Book;
import org.dakside.booklib.search.WebSearch;
import org.dakside.booklib.search.GoogleBookWebApiSearch;
import org.dakside.booklib.search.MinhKhaiWebApiSearch;

/**
 *
 * @author Hoang Duc Chinh {@literal <dc.hoang.vn@gmail.com>}
 */
public class BookLibDemoGUI extends javax.swing.JFrame {

    private BookDAO bookDao;
    private WebSearch webSearch;
    private Book book;
    private HashMap<String, String> hashmapBookInfo; // HashMap is used to keep the information of the book, i.e. {"Title":"The world as I see it"}

    /**
     * Creates new form BookLibDemoGUI
     */
    public BookLibDemoGUI() {
        initComponents();
        initUtilities();
        //this.jTableBookInfo.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        int firstColumnWidth = (int) (this.jTableBookInfo.getWidth() * 0.35);
        this.jTableBookInfo.getColumnModel().getColumn(0).setPreferredWidth(firstColumnWidth);
        //this.jTableBookInfo.getColumnModel().getColumn(1).setPreferredWidth(this.jTableBookInfo.getWidth()*2);
        this.jTableBookInfo.getColumnModel().getColumn(1).setPreferredWidth(this.jTableBookInfo.getWidth() - firstColumnWidth);
    }

    private void initUtilities() {
        DAOFactory instance = new SQLiteDAOFactory();
        this.book = new Book();
        bookDao = instance.createBookDAO();
        webSearch = new GoogleBookWebApiSearch();
        hashmapBookInfo = new LinkedHashMap<String, String>(); // used LinkedHashMap to keep the order of item by insertion
        this.updateHashMap();
    }

    /**
     * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jButtonScan = new javax.swing.JButton();
        jButtonWebSearch = new javax.swing.JButton();
        jButtonDBSearch = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jButtonAdd = new javax.swing.JButton();
        jButtonDelete = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jTextDBTotal = new javax.swing.JTextField();
        jButtonUpdate = new javax.swing.JButton();
        jButtonEdit = new javax.swing.JButton();
        jButtonViewAll = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTableBookInfo = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        jTextTitle = new javax.swing.JTextField();
        jTextISBN = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Book library management");
        setResizable(false);

        jLabel1.setText("ISBN:");

        jButtonScan.setText("Scan");
        jButtonScan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonScanActionPerformed(evt);
            }
        });

        jButtonWebSearch.setText("Web Search");
        jButtonWebSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonWebSearchActionPerformed(evt);
            }
        });

        jButtonDBSearch.setText("DB Search");
        jButtonDBSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonDBSearchActionPerformed(evt);
            }
        });

        jLabel2.setText("Book information:");

        jButtonAdd.setText("Add");
        jButtonAdd.setMaximumSize(new java.awt.Dimension(65, 25));
        jButtonAdd.setMinimumSize(new java.awt.Dimension(65, 23));
        jButtonAdd.setPreferredSize(new java.awt.Dimension(65, 25));
        jButtonAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAddActionPerformed(evt);
            }
        });

        jButtonDelete.setText("Delete");
        jButtonDelete.setMaximumSize(new java.awt.Dimension(65, 23));
        jButtonDelete.setMinimumSize(new java.awt.Dimension(65, 23));
        jButtonDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonDeleteActionPerformed(evt);
            }
        });

        jLabel3.setText("Total:");

        jTextDBTotal.setEditable(false);
        jTextDBTotal.setFocusable(false);
        jTextDBTotal.setHighlighter(null);

        jButtonUpdate.setText("Update");
        jButtonUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonUpdateActionPerformed(evt);
            }
        });

        jButtonEdit.setText("Edit");
        jButtonEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEditActionPerformed(evt);
            }
        });

        jButtonViewAll.setText("View all");
        jButtonViewAll.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonViewAllActionPerformed(evt);
            }
        });

        jTableBookInfo.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null}
            },
            new String [] {
                "Item", "Details"
            }
        ));
        jTableBookInfo.getTableHeader().setReorderingAllowed(false);
        jTableBookInfo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableBookInfoMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTableBookInfo);
        if (jTableBookInfo.getColumnModel().getColumnCount() > 0) {
            jTableBookInfo.getColumnModel().getColumn(0).setResizable(false);
            jTableBookInfo.getColumnModel().getColumn(1).setResizable(false);
        }

        jLabel4.setText("Title:");

        jLabel5.setText("Developed by Hoang Duc Chinh");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButtonWebSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonDBSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButtonEdit))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextISBN)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonScan, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel2)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 329, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jButtonViewAll)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButtonAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButtonDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButtonUpdate)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel3)
                                .addGap(1, 1, 1)
                                .addComponent(jTextDBTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jTextTitle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(8, 8, 8)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jButtonScan)
                    .addComponent(jTextISBN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(7, 7, 7)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonWebSearch)
                    .addComponent(jButtonDBSearch)
                    .addComponent(jButtonEdit))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(8, 8, 8)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel3)
                        .addComponent(jTextDBTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButtonUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButtonViewAll, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButtonDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jButtonAdd, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 11, Short.MAX_VALUE)
                .addComponent(jLabel5)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    /* Call the QRScanner to get the ISBN number */
    private void jButtonScanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonScanActionPerformed
        // TODO add your handling code here:
        QRScanner qrScanner = new QRScanner(this.jTextISBN);
        qrScanner.setVisible(true);
    }//GEN-LAST:event_jButtonScanActionPerformed

    /**
     * create or update the hashmapBookInfo
     */
    private void updateHashMap() {
        this.hashmapBookInfo.put("ID", String.valueOf(this.book.getId()));
        this.hashmapBookInfo.put("Title", this.book.getTitle());
        this.hashmapBookInfo.put("Authors", this.book.getAuthor());
        this.hashmapBookInfo.put("Year", String.valueOf(this.book.getYear()));
        this.hashmapBookInfo.put("Publisher", this.book.getPublisher());
        this.hashmapBookInfo.put("ISBN", this.book.getIsbn());
        this.hashmapBookInfo.put("Bar code", this.book.getBarcode());
        this.hashmapBookInfo.put("Language", this.book.getLanguage());
        this.hashmapBookInfo.put("Price", String.valueOf(this.book.getPrice()));
        this.hashmapBookInfo.put("Quantity", String.valueOf(this.book.getQuantity()));
    }
    
    /* Search the book from different web sources */
    private void jButtonWebSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonWebSearchActionPerformed
        // TODO add your handling code here:
        WebSearch[] webSearchList = {new GoogleBookWebApiSearch(), new MinhKhaiWebApiSearch()};
        String isbn = this.jTextISBN.getText();
        if ((isbn != null) && (!isbn.trim().isEmpty())) {
            Book book = new Book();
            for (WebSearch webSearch : webSearchList) {
                book = webSearch.searchByISBN(isbn);
                if (book != null) {
                    if (book.getTitle() != null && !book.getTitle().trim().isEmpty()) {
                        this.book = book;
                        this.getBookInfo();
                        break;
                    }
                }
            }
            if (book == null) {
                JOptionPane.showMessageDialog(null, "Cannot find this book from web!");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Please provide a valid ISBN!!");
        }
    }//GEN-LAST:event_jButtonWebSearchActionPerformed
    
    /* 
        Search book in the database
        If isbn is not empty -> search by ISBN
            If not found the book by ISB -> search by title
                If not found -> inform user
        If both isbn and title is invalid/empty -> inform user
    */
    private void jButtonDBSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonDBSearchActionPerformed
        // TODO add your handling code here:
        String isbn = this.jTextISBN.getText();
        String title = this.jTextTitle.getText();
        boolean notFound = true;
        boolean invalidText = false;
        if ((isbn != null) && (!isbn.trim().isEmpty())) {
            List<Book> bookList = this.bookDao.searchBookByISBN(isbn.trim());
            if ((bookList != null) && (bookList.size() > 0)) {
                Book book = bookList.get(0);
                this.book = book;
                this.getBookInfo();
                notFound = false;
            } else {
                notFound = true;
            }
        } else if ((title != null) && (!title.trim().isEmpty())) {
            List<Book> bookList = this.bookDao.searchBookByTitle(title.trim());
            if ((bookList != null) && (bookList.size() > 0)) {
                Book book = bookList.get(0);
                this.book = book;
                this.getBookInfo();
                notFound = false;
            } else {
                bookList.clear();
                bookList = this.bookDao.searchBookByIncompleteTitle(title.trim());

                if ((bookList != null) && (bookList.size() > 0)) {
                    this.listAll(bookList);
                    notFound = false;
                } else {
                    notFound = true;
                }
            }
        } else {
            invalidText = true;
        }
        if (invalidText) {
            JOptionPane.showMessageDialog(null, "Invalid ISBN or Book title!");
        } else if (notFound) {
            JOptionPane.showMessageDialog(null, "Cannot find this book in library!");
        }
    }//GEN-LAST:event_jButtonDBSearchActionPerformed

    /*
        get the book information and show them in jTableBookInfo with 2 columns
        -> Item, e.g.: Title, ISBN, Authors, etc. and Details: respected values of the items
    */
    private void getBookInfo() {
        this.updateHashMap();

        // Get an iterator
        Iterator iterator = this.hashmapBookInfo.entrySet().iterator();
        // Display elements
        TableColumn tableColumn = this.jTableBookInfo.getColumnModel().getColumn(0);
        tableColumn.setHeaderValue("Item");
        tableColumn = this.jTableBookInfo.getColumnModel().getColumn(1);
        tableColumn.setHeaderValue("Details");

        this.jTableBookInfo.setRowSorter(null); // step 1 to disable sorter
        this.jTableBookInfo.setAutoCreateRowSorter(false); // step 2 to disable sorter

        DefaultTableModel tableModel = (DefaultTableModel) this.jTableBookInfo.getModel();
        tableModel.setRowCount(0);
        while (iterator.hasNext()) {
            Map.Entry entry = (Map.Entry) iterator.next();
            Object[] rowData = new Object[2];
            rowData[0] = entry.getKey().toString();
            rowData[1] = entry.getValue().toString();
            tableModel.addRow(rowData);
        }
    }
    /*
        Add the current book to the database
    */
    private void jButtonAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAddActionPerformed
        // TODO add your handling code here:
        String isbn = this.jTextISBN.getText();
        if ((isbn != null) && (!isbn.trim().isEmpty())) {
            if (this.book != null) {
                // First check if the book is already in the database
                List<Book> bookList = this.bookDao.searchBookByISBN(isbn);
                if ((bookList != null) && (bookList.size() > 0)) {
                    JOptionPane.showMessageDialog(null, "This book is already existed in library!");
                } else { // If the book is NOT in the database, insert it
                    this.bookDao.insertBook(this.book);
                    this.jTextDBTotal.setText(String.valueOf(this.bookDao.getNumberOfBook()));
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "Please provide a valid ISBN!");
        }
    }//GEN-LAST:event_jButtonAddActionPerformed
    
    /* delete the current book -> to be updated */
    private void jButtonDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonDeleteActionPerformed
        // TODO add your handling code here:
        //this.jTextDBTotal.setText(String.valueOf(this.bookDao.getNumberOfBook()))
    }//GEN-LAST:event_jButtonDeleteActionPerformed
    
    /* edit information of the current book */
    private void jButtonEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEditActionPerformed
        // TODO add your handling code here:
        String isbn = this.jTextISBN.getText();
        if ((isbn != null) && (!isbn.trim().isEmpty())) {
            if (this.book != null) {
                BookInfoEdit bookInfoEdit = new BookInfoEdit(this.book);
                bookInfoEdit.setVisible(true);
            } else {
                JOptionPane.showMessageDialog(null, "Invalid book! Search book by ISBN first");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Nothing to edit!");
        }
    }//GEN-LAST:event_jButtonEditActionPerformed
    
    /* Update information of the current book */
    private void jButtonUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonUpdateActionPerformed
        // TODO add your handling code here:
        if (this.book != null) {
            if ((this.book.getTitle() != null) && (!this.book.getTitle().trim().isEmpty())) {
                List<Book> bookList = this.bookDao.searchBookByISBN(this.book.getIsbn());
                if ((bookList != null) && (bookList.size() > 0)) {
                    this.bookDao.updateBook(this.book);
                    return;
                } else {
                    JOptionPane.showMessageDialog(null, "This book is NOT in library, please add it first!");
                    return;
                }
            }
        } //else {
        JOptionPane.showMessageDialog(null, "Invalid book!");
        //}
    }//GEN-LAST:event_jButtonUpdateActionPerformed
    
    /* list all the books in the database */
    private void jButtonViewAllActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonViewAllActionPerformed
        // TODO add your handling code here:
        this.listAll(this.bookDao.getAll());
    }//GEN-LAST:event_jButtonViewAllActionPerformed
    
    /* get the title and isbn of the book selected in JTable */
    private void jTableBookInfoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableBookInfoMouseClicked
        // TODO add your handling code here:
        //if (evt.getClickCount() == 2) {
        DefaultTableModel tableModel = (DefaultTableModel) this.jTableBookInfo.getModel();        
        int viewRow = this.jTableBookInfo.getSelectedRow();
        int row = this.jTableBookInfo.convertRowIndexToModel(viewRow);        
        //JOptionPane.showMessageDialog(null, "Selected row: "+String.valueOf(row));
        TableColumn tableColumn = this.jTableBookInfo.getColumnModel().getColumn(0);
        if (tableColumn.getHeaderValue().toString().equalsIgnoreCase("ISBN")) {
            this.jTextISBN.setText(tableModel.getValueAt(row, 0).toString());
            this.jTextTitle.setText(tableModel.getValueAt(row, 1).toString());
            this.jTextTitle.setCaretPosition(0);
        }
    }//GEN-LAST:event_jTableBookInfoMouseClicked
    
    /* List all the book in the JTable with 2 columns ISBN and Title */
    private void listAll(List<Book> inputBookList) {
        List<Book> bookList = inputBookList;
        //JTableHeader th = table.getTableHeader();
        //TableColumnModel tcm = th.getColumnModel();
        TableColumn tableColumn = this.jTableBookInfo.getColumnModel().getColumn(0);
        tableColumn.setHeaderValue("ISBN");
        tableColumn = this.jTableBookInfo.getColumnModel().getColumn(1);
        tableColumn.setHeaderValue("Title");
        this.jTableBookInfo.setAutoCreateRowSorter(true);
        DefaultTableModel tableModel = (DefaultTableModel) this.jTableBookInfo.getModel();
        tableModel.setRowCount(0);

        for (Book book : bookList) {
            Object[] rowData = new Object[2];
            rowData[0] = book.getIsbn();
            rowData[1] = book.getTitle();
            tableModel.addRow(rowData);
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(BookLibDemoGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(BookLibDemoGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(BookLibDemoGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BookLibDemoGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                BookLibDemoGUI bookLibGUI = new BookLibDemoGUI();
                bookLibGUI.setVisible(true);
                bookLibGUI.jTextDBTotal.setText(String.valueOf(bookLibGUI.bookDao.getNumberOfBook()));
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAdd;
    private javax.swing.JButton jButtonDBSearch;
    private javax.swing.JButton jButtonDelete;
    private javax.swing.JButton jButtonEdit;
    private javax.swing.JButton jButtonScan;
    private javax.swing.JButton jButtonUpdate;
    private javax.swing.JButton jButtonViewAll;
    private javax.swing.JButton jButtonWebSearch;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTableBookInfo;
    private javax.swing.JTextField jTextDBTotal;
    private javax.swing.JTextField jTextISBN;
    private javax.swing.JTextField jTextTitle;
    // End of variables declaration//GEN-END:variables
}
