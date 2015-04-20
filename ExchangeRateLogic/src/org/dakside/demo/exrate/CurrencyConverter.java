package org.dakside.demo.exrate;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Le Tuan Anh <tuananh.ke@gmail.com>
 */
public class CurrencyConverter {
    
    public Money convert(Money input, ExchangeRate rate) throws CurrencyException{
        // 1. Validate input
        if(input == null || !input.isValid() || rate == null || !rate.isValid()){
            throw new CurrencyException();
        }
        // 2. Convert
        double outputValue = input.getValue() * rate.getRate();
        // 3. Return value
        return new Money(outputValue, rate.getToCurrency());
    } 
    
}
