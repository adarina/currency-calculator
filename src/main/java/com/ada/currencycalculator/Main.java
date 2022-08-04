package com.ada.currencycalculator;

import com.ada.currencycalculator.calculator.Calculator;
import com.ada.currencycalculator.parser.ParserXML;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws ParserConfigurationException, IOException, SAXException {
        ParserXML parserXML = new ParserXML();
        Calculator calculator = new Calculator(parserXML);
        parserXML.parseCurrencies("eurofxref-daily.xml");
        calculator.init();
    }
}
