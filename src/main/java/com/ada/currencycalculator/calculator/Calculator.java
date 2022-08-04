package com.ada.currencycalculator.calculator;

import com.ada.currencycalculator.parser.ParserXML;

import java.math.BigDecimal;
import java.util.Map;
import java.util.Objects;
import java.util.Scanner;

/**
 * This is a class for Calculator
 */
public class Calculator implements CalculatorInterface{

    private ParserXML parser;

    private final Scanner scanner = new Scanner(System.in);

    /**
     * Class constructor with {@code ParserXML} to create.
     * @param parser class with currencies
     */
    public Calculator(ParserXML parser) {
        this.parser = parser;
    }

    /**
     * Class constructor
     */
    public Calculator() {

    }

    /**
     * This method initialize calculator and contain all the steps to calculate currency
     * or close program
     */
    public void init() {

        String answer;
        do {
            System.out.println("Please enter the amount[EUR]: ");
            String inputEuroCurrency = scanner.nextLine();

            if (isValidCurrency(inputEuroCurrency)) {
                System.out.println("Choose available currency from this list:");
                parser.printAllCurrenciesNames();
                String inputCurrencyName = scanner.nextLine();

                if (isValidCurrencyName(inputCurrencyName, parser.getAllCurrencies())) {
                    BigDecimal inputCurrencyRate = getCurrencyRate(inputCurrencyName, parser.getAllCurrencies());
                    System.out.println(calculate(inputEuroCurrency, inputCurrencyName, inputCurrencyRate));
                }
            }
            System.out.println("If you want continue press Enter, else type 'NO'");
            answer = scanner.nextLine();

        } while (!answer.equals("NO"));
    }

    /**This method takes a {@code String}
     * and searches in the given map {@code Map<String, BigDecimal>}
     * @param name
     *          name of currency
     * @param currencies
     *          map of currencies names and rates
     * @return BigDecimal value associated with searched key in map, null otherwise
     */
    public BigDecimal getCurrencyRate(String name, Map<String, BigDecimal> currencies) {
        BigDecimal rate = null;
        for (String key : currencies.keySet()) {
            if (key.equals(name)) {
                rate = currencies.get(key);
            }
        }
        return rate;
    }

    /**This method takes a {@code String} and format it to {@code BigDecimal} then
     * multiply it by given {@code BigDecimal}
     * @param amount amount in euro
     * @param name name of wanted currency
     * @param rate rate of currency
     * @return String with formatted result
     */
    public String calculate(String amount, String name, BigDecimal rate) {
        BigDecimal currency = BigDecimal.valueOf(Double.parseDouble(amount));
        return String.format("Result: %.2f " + name, currency.multiply(rate));
    }

    /**This method takes a {@code String}
     * and match with regex
     * @param name
     *          name of currency
     * @return true if matches, false otherwise
     */
    public boolean isValidCurrency(String name) {
        if (name.matches("[\\d.,]*")) {
            return true;
        }
        System.out.println("Wrong number format!");
        return false;
    }

    /**
     * This method takes a {@code String}
     * and searches in the given map {@code Map<String, BigDecimal>}
     * @param name
     *          name of currency
     * @param currencies
     *          map of currencies names and rates
     * @return true if found, false otherwise
     */
    public boolean isValidCurrencyName(String name, Map<String, BigDecimal> currencies) {
        for (String key : currencies.keySet()) {
            if (Objects.equals(key, name)) {
                return true;
            }
        }
        System.out.println("Wrong currency name!");
        return false;
    }
}
