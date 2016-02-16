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
package org.dakside.booklib.dto;

import java.util.Calendar;

/**
 * Book is data transport object consisting of essential information about the book
 *
 * @author Hoang Duc Chinh {@literal <dc.hoang.vn@gmail.com>}
 */
public class Book {

    private int id;             // 1) unique, chronological order, started from 1 to the max number of books
    private String title;       // 2)
    private String author;      // 3)
    private int year;           // 4)
    private String publisher;   // 5)
    private String isbn;        // 6)
    private String barcode;     // 7)
    private String language;    // 8) optional
    private int price;          // 9) in USD
    private int quantity;         //10)

    public Book() {
        title = "";
        author = "";
        year = 0;
        publisher = "";
        isbn = "";
        barcode = "";
        language = "";
        price = 0;
        quantity = 1;
    }

    public Book(String title) {
        this.title = title;
    }

    /**
     * @return the title
     */
    public String getTitle() {
        return title;
    }

    /**
     * @param title the title to set
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the author
     */
    public String getAuthor() {
        return author;
    }

    /**
     * @param author the author to set
     */
    public void setAuthor(String author) {
        this.author = author;
    }

    /**
     * @return the year
     */
    public int getYear() {
        return year;
    }

    /**
     * @param year the year to set
     */
    public void setYear(int year) {
        this.year = year;
    }

    /**
     * @return the publisher
     */
    public String getPublisher() {
        return publisher;
    }

    /**
     * @param publisher the publisher to set
     */
    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    /**
     * @return the isbn
     */
    public String getIsbn() {
        return isbn;
    }

    /**
     * @param isbn the isbn to set
     */
    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    /**
     * @return the barcode
     */
    public String getBarcode() {
        return barcode;
    }

    /**
     * @param barcode the barcode to set
     */
    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }

    /**
     * @return the language
     */
    public String getLanguage() {
        return language;
    }

    /**
     * @param language the language to set
     */
    public void setLanguage(String language) {
        this.language = language;
    }

    /**
     * @return the price
     */
    public int getPrice() {
        return price;
    }

    /**
     * @param price the price to set
     */
    public void setPrice(int price) {
        this.price = price;
    }

    /**
     * @return the quantity
     */
    public int getQuantity() {
        return quantity;
    }

    /**
     * @param quantity the quantity to set
     */
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    private boolean isValidString(String testString) {
        return ((testString != null) && (!testString.trim().isEmpty()));
    }

    @Override
    public String toString() {
        String str = "";
        if (this.id>0){
            str = "ID: " + String.valueOf(this.id) + "\n";
        }
        
        if (this.isValidString(this.title)) {
            str += "Title: " + this.title + "\n";
        }
        if (this.isValidString(this.author)) {
            str += "Authors: " + this.author + "\n";
        }

        if ((this.year > 0) && (this.year <= Calendar.getInstance().get(Calendar.YEAR))) {
            str += "Year: " + String.valueOf(this.year) + "\n";
        }

        if (this.isValidString(this.publisher)) {
            str += "Publisher: " + this.publisher + "\n";
        }

        if (this.isValidString(this.isbn)) {
            str += "ISBN: " + this.isbn + "\n";
        }
        
        if (this.isValidString(this.barcode)) {
            str += "Bar code: " + this.barcode + "\n";
        }
        
        if (this.isValidString(this.language)) {
            str += "Language: " + this.language + "\n";
        }
        
        if (this.price>0) {
            str += "Price: " + String.valueOf(this.price) + "\n";
        }
        
        if (this.quantity>0) {
            str += "Quantity: " + String.valueOf(this.quantity);
        }
        
        return str;
    }

    public String basicInfo() {
        String str = "";
        if (this.id>0){
            str = "ID: " + String.valueOf(this.id) + "\n";
        }
        
        if (this.isValidString(this.title)) {
            str += "Title: " + this.title + "\n";
        }
        if (this.isValidString(this.author)) {
            str += "Authors: " + this.author + "\n";
        }

        if ((this.year > 0) && (this.year <= Calendar.getInstance().get(Calendar.YEAR))) {
            str += "Year: " + String.valueOf(this.year) + "\n";
        }

        if (this.isValidString(this.isbn)) {
            str += "ISBN: " + this.isbn + "\n";
        }
        
        if (this.isValidString(this.language)) {
            str += "Language: " + this.language + "\n";
        }
        
        return str;
    }    
}
