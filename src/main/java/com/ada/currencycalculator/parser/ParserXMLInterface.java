package com.ada.currencycalculator.parser;

import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.Map;

/**
 * This is an interface for ParserXML.
 */
public interface ParserXMLInterface {

    /**
     * Method parse given xml file and add elements to {@code Map<String, BigDecimal>}
     */
    void parseCurrencies(String file) throws ParserConfigurationException, IOException, SAXException;

    /**
     * Method get {@code Map<>} currencies
     * @return HashMap of currencies
     */
    Map<String, BigDecimal> getAllCurrencies();

    /**
     * Method prints all {@code String} names from {@code Map<String, BigDecimal>}
     */
    void printAllCurrenciesNames();
}
