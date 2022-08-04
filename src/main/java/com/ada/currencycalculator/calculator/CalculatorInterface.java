package com.ada.currencycalculator.calculator;

import java.math.BigDecimal;
import java.util.Map;

public interface CalculatorInterface {

    void init();

    BigDecimal getCurrencyRate(String name, Map<String, BigDecimal> currencies);

    String calculate(String amount, String name, BigDecimal rate);

    boolean isValidCurrency(String name);

    boolean isValidCurrencyName(String name, Map<String, BigDecimal> currencies);
}