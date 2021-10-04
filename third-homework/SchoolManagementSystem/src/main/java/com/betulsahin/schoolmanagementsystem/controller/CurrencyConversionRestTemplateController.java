package com.betulsahin.schoolmanagementsystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/api/currency-converter")
public class CurrencyConversionRestTemplateController {
    private final static String CURRENCY_CONVERTER_ENDPOINT =
            "http://localhost:8081/currencyConverterFromTLtoUSD/%d";

    private final static String CREDIT_SCORE_ENDPOINT = "8081/getScore/½s";

    @Autowired
    RestTemplate restTemplate;

    @GetMapping("{quantity}")
    public ResponseEntity<String> showCurrencyFromTLToUSD(@PathVariable int quantity){
        ResponseEntity<String> responseEntity = restTemplate.getForEntity(
                String.format(CURRENCY_CONVERTER_ENDPOINT, quantity), String.class);

        return responseEntity;
    }
}
