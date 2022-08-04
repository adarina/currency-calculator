package com.ada.currencycalculator.parser;

import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.Map;

public interface ParserXMLInterface {

    void parseCurrencies(String file) throws ParserConfigurationException, IOException, SAXException;

    Map<String, BigDecimal> getAllCurrencies();

    void printAllCurrenciesNames();
}
