package com.betulsahin.currencyconversionapi.service;

import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;

@Service
public class CurrencyConversionService {
    private static final double DOLLAR_EXCHANGE_RATE = 8.35;

    public String convertCurrency(int quantity) {
        BigDecimal tl = new BigDecimal(quantity);
        BigDecimal dollar = tl.divide(new BigDecimal(DOLLAR_EXCHANGE_RATE), 2, RoundingMode.HALF_EVEN);

        return String.format("%.2f $", dollar);
    }
}
