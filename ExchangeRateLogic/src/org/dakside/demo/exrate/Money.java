/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.dakside.demo.exrate;

/**
 *
 * @author Le Tuan Anh <tuananh.ke@gmail.com>
 */
public class Money {
    private double value;
    private String currency;

    public Money(double value, String currency) {
        this.value = value;
        this.currency = currency;
    }

    public Money() {
    }

    /**
     * @return the value
     */
    public double getValue() {
        return value;
    }

    /**
     * @param value the value to set
     */
    public void setValue(double value) {
        this.value = value;
    }

    /**
     * @return the currency
     */
    public String getCurrency() {
        return currency;
    }

    /**
     * @param currency the currency to set
     */
    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public boolean isValid() {
        // check value
        return this.currency != null;
    }
    
    public boolean equals(Money another){
        return another != null 
                && (
                    (this.currency == null && another.getCurrency() == null)
                    || this.currency.equals(another.getCurrency())
                    )
                && this.value == another.getValue();
                
    }
}
