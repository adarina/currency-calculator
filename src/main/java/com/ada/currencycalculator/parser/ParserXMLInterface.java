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
     *
     * @param file route to file
     * @throws ParserConfigurationException indicates a serious configuration error
     * @throws IOException                  signals that an I/O exception has occurred
     * @throws SAXException                 encapsulate a general SAX error or warning
     */
    void parseCurrencies(String file) throws ParserConfigurationException, IOException, SAXException;

    /**
     * Method get {@code Map<>} currencies
     *
     * @return HashMap of currencies
     */
    Map<String, BigDecimal> getAllCurrencies();

    /**
     * Method prints all {@code String} names from {@code Map<String, BigDecimal>}
     */
    void printAllCurrenciesNames();
}
