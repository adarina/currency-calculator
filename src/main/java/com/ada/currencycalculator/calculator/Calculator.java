package com.ada.currencycalculator.calculator;

import com.ada.currencycalculator.parser.ParserXML;

import java.math.BigDecimal;
import java.util.Map;
import java.util.Objects;
import java.util.Scanner;

public class Calculator implements CalculatorInterface{

    private final ParserXML parser;

    private final Scanner scanner = new Scanner(System.in);

    public Calculator(ParserXML parser) {
        this.parser = parser;
    }

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

    public BigDecimal getCurrencyRate(String name, Map<String, BigDecimal> currencies) {
        BigDecimal rate = null;
        for (String key : currencies.keySet()) {
            if (key.equals(name)) {
                rate = currencies.get(key);
            }
        }
        return rate;
    }

    public String calculate(String amount, String name, BigDecimal rate) {
        BigDecimal currency = BigDecimal.valueOf(Double.parseDouble(amount));
        return String.format("Result: %.2f " + name, currency.multiply(rate));
    }

    public boolean isValidCurrency(String name) {
        if (name.matches("[\\d.,]*")) {
            return true;
        }
        System.out.println("Wrong number format!");
        return false;
    }

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
