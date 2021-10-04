package com.betulsahin.currencyconversionapi.controller;

import com.betulsahin.currencyconversionapi.dto.StringResponse;
import com.betulsahin.currencyconversionapi.service.CurrencyConversionService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@AllArgsConstructor
@RestController
@RequestMapping
public class CurrencyConversionController {
    private final CurrencyConversionService currencyConversionService;

    @GetMapping("/currencyConverterFromTLtoUSD/{quantity}")
    public ResponseEntity<String> convertCurrency(@PathVariable int quantity) {

        String convertedCurrencyToUSD = currencyConversionService.convertCurrency(quantity);

        return new ResponseEntity<>(
                convertedCurrencyToUSD,
                HttpStatus.OK);
    }
}
