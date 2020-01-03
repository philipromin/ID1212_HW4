package com.philip.currency.presentation;

import com.philip.currency.domain.Currency;

public class Converter {
    public static double ConvertCurrency(double amount, Currency from, Currency to){
        double toBase = amount * from.getRate();
        return toBase * to.getRate();
    }
}
