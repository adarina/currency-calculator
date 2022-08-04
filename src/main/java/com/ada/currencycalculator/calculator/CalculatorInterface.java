package com.ada.currencycalculator.calculator;

import java.math.BigDecimal;
import java.util.Map;

/**
 * This is an interface for Calculator.
 */
public interface CalculatorInterface {

    /**
     * This method initialize calculator and contain all the steps to calculate currency
     * or close program
     */
    void init();

    /**This method takes a {@code String}
     * and searches in the given map {@code Map<String, BigDecimal>}
     * @param name
     *          name of currency
     * @param currencies
     *          map of currencies names and rates
     * @return BigDecimal value associated with searched key in map, null otherwise
     */
    BigDecimal getCurrencyRate(String name, Map<String, BigDecimal> currencies);

    /**This method takes a {@code String} and format it to {@code BigDecimal} then
     * multiply it by given {@code BigDecimal}
     * @param amount amount in euro
     * @param name name of wanted currency
     * @param rate rate of currency
     * @return String with formatted result
     */
    String calculate(String amount, String name, BigDecimal rate);

    /**This method takes a {@code String}
     * and match with regex
     * @param name
     *          name of currency
     * @return true if matches, false otherwise
     */
    boolean isValidCurrency(String name);

    /**
     * This method takes a {@code String}
     * and searches in the given map {@code Map<String, BigDecimal>}
     * @param name
     *          name of currency
     * @param currencies
     *          map of currencies names and rates
     * @return true if found, false otherwise
     */
    boolean isValidCurrencyName(String name, Map<String, BigDecimal> currencies);
}