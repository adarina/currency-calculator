package com.ada.currencycalculator.calculator;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.LinkedHashMap;
import java.util.Map;

public class CalculatorTest {

    private final Map<String, BigDecimal> currencies = new LinkedHashMap<>();

    @Before
    public void setupLinkedHashMap(){
        currencies.put("QWE", BigDecimal.valueOf(12.00));
        currencies.put("RTY", BigDecimal.valueOf(900.32));
        currencies.put("UIO", BigDecimal.valueOf(45.123));
        currencies.put("PAS", BigDecimal.valueOf(9.0));
    }

    @Test
    public void getCurrencyRate_ThenTrue() {
        Calculator calculator = new Calculator();
        BigDecimal result = calculator.getCurrencyRate("UIO", currencies);
        Assert.assertEquals(BigDecimal.valueOf(45.123), result);
    }

    @Test
    public void getCurrencyRate_ThenFalse() {
        Calculator calculator = new Calculator();
        BigDecimal result = calculator.getCurrencyRate("UIO", currencies);
        Assert.assertEquals(BigDecimal.valueOf(45.123), result);
    }

    @Test
    public void checkCurrencyName_ValidCurrencyName_ThenTrue() {
        Calculator calculator = new Calculator();
        Boolean result = calculator.isValidCurrencyName("RTY", currencies);
        Assert.assertEquals(true, result);
    }

    @Test
    public void checkCurrencyName_ValidCurrencyName_ThenFalse() {
        Calculator calculator = new Calculator();
        Boolean result = calculator.isValidCurrencyName("BNM", currencies);
        Assert.assertEquals(false, result);
    }

    @Test
    public void checkCurrency_ValidCurrency_ThenTrue() {
        Calculator calculator = new Calculator();
        Boolean result = calculator.isValidCurrency("45.23");
        Assert.assertEquals(true, result);
    }

    @Test
    public void checkCurrency_NegativeCurrency_ThenFalse() {
        Calculator calculator = new Calculator();
        Boolean result = calculator.isValidCurrency("-45.23");
        Assert.assertEquals(false, result);
    }

    @Test
    public void checkCurrency_InvalidCurrency_ThenFalse() {
        Calculator calculator = new Calculator();
        Boolean result = calculator.isValidCurrency("45.23asf");
        Assert.assertEquals(false, result);
    }

    @Test
    public void calculate_ValidInput_ThenTrue(){
        Calculator calculator = new Calculator();
        Map.Entry<String,BigDecimal> entry = currencies.entrySet().iterator().next();
        String result = calculator.calculate("30", entry.getKey(), entry.getValue());
        Assert.assertEquals("Result: 360,00 QWE", result);
    }

    @Test
    public void calculate_InvalidInput_ThenFalse(){
        Calculator calculator = new Calculator();
        Map.Entry<String,BigDecimal> entry = currencies.entrySet().iterator().next();
        String result = calculator.calculate("30", entry.getKey(), entry.getValue());
        Assert.assertEquals("Result: 360,00 QWE", result);
    }
}
