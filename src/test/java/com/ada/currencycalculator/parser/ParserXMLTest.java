package com.ada.currencycalculator.parser;

import org.junit.Test;
import java.io.FileNotFoundException;

import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

public class ParserXMLTest {

    @Test
    public void wrongFile_invalidFile_thenException(){
        ParserXML parserXML = new ParserXML();
        assertThrows(FileNotFoundException.class, () -> parserXML.parseCurrencies("nothing.xml"));
    }

    @Test
    public void checkFile_validFile_thenOk(){
        ParserXML parserXML = new ParserXML();
        assertDoesNotThrow(() -> parserXML.parseCurrencies("eurofxref-daily.xml"));
    }
}
