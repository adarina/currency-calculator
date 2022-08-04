package com.ada.currencycalculator.parser;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.LinkedHashMap;
import java.util.Map;

public class ParserXML implements ParserXMLInterface{

    private final Map<String, BigDecimal> currencies = new LinkedHashMap<>();

    @Override
    public void parseCurrencies(String file) throws ParserConfigurationException, IOException, SAXException {

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.parse(new File(file));
        document.getDocumentElement().normalize();
        NodeList nodeList = document.getElementsByTagName("Cube");

        for (int i = 0; i < nodeList.getLength(); i++) {
            Node node = nodeList.item(i);
            if (node.getNodeType() == Node.ELEMENT_NODE) {
                Element element = (Element) node;
                if (element.hasAttribute("currency")) {
                    currencies.put(element.getAttribute("currency"),
                            BigDecimal.valueOf(Double.parseDouble(element.getAttribute("rate"))));
                }
            }
        }
    }

    public Map<String, BigDecimal> getAllCurrencies() {
        return currencies;
    }

    @Override
    public void printAllCurrenciesNames() {
        for (String key : currencies.keySet()) {
            System.out.print(key + " ");
        }
        System.out.println();
    }
}