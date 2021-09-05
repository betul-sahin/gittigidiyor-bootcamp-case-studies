package com.betulsahin.schoolmanagementsystemdemov3.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class CurrencyConversion {
    private String from;
    private String to;
    private BigDecimal quantity;
}
