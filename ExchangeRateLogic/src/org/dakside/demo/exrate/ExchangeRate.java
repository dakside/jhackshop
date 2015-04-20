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
public class ExchangeRate {
    private String fromCurrency;
    private String toCurrency;
    private double rate;

    public ExchangeRate() {
    }

    public ExchangeRate(String fromCurrency, String toCurrency, double rate) {
        this.fromCurrency = fromCurrency;
        this.toCurrency = toCurrency;
        this.rate = rate;
    }

    /**
     * @return the fromCurrency
     */
    public String getFromCurrency() {
        return fromCurrency;
    }

    /**
     * @param fromCurrency the fromCurrency to set
     */
    public void setFromCurrency(String fromCurrency) {
        this.fromCurrency = fromCurrency;
    }

    /**
     * @return the toCurrency
     */
    public String getToCurrency() {
        return toCurrency;
    }

    /**
     * @param toCurrency the toCurrency to set
     */
    public void setToCurrency(String toCurrency) {
        this.toCurrency = toCurrency;
    }

    /**
     * @return the rate
     */
    public double getRate() {
        return rate;
    }

    /**
     * @param rate the rate to set
     */
    public void setRate(double rate) {
        this.rate = rate;
    }

    boolean isValid() {
        return this.rate > 0 && this.fromCurrency != null && this.toCurrency != null;
    }
    
    
}
