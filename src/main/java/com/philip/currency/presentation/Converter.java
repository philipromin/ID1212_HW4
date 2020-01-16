package com.philip.currency.presentation;

import com.philip.currency.domain.Currency;

public class Converter {
    public static double ConvertCurrency(double amount, Currency from, Currency to){
        return amount/from.getRate() * to.getRate();
    }
}
