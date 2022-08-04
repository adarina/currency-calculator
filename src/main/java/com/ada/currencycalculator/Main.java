package com.ada.currencycalculator;

import com.ada.currencycalculator.calculator.Calculator;
import com.ada.currencycalculator.parser.ParserXML;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

/**
 * This is currency calculator application
 *
 * @author Ada
 * @date 04/08/2022
 */
public class Main {
    /**
     * Main method. Creates {@code ParserXML} parser and then {@code Calculator} calculator with it
     * and call their respective methods
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) throws ParserConfigurationException, IOException, SAXException {
        ParserXML parserXML = new ParserXML();
        Calculator calculator = new Calculator(parserXML);
        parserXML.parseCurrencies("eurofxref-daily.xml");
        calculator.init();
    }
}
