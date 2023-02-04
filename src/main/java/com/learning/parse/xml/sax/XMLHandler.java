package com.learning.parse.xml.sax;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class XMLHandler extends DefaultHandler {

    private StringBuilder currentValue = new StringBuilder();

    @Override
    public void startDocument() {
        System.out.println("S");
    }

    @Override
    public void endDocument() {
        System.out.println("E");
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) {
        currentValue.setLength(0);
        if (qName.equalsIgnoreCase("emp")) {
//          String id = attributes.getValue("id");
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) {
        if (qName.equalsIgnoreCase("name")) {
            System.out.printf("Name : %s%n", currentValue.toString());
        }
        if (qName.equalsIgnoreCase("pay")) {
            System.out.printf("Pay : %s%n", currentValue.toString());
        }
        if (qName.equalsIgnoreCase("bio")) {
            System.out.printf("Bio : %s%n", currentValue.toString());
        }
    }

    @Override
    public void characters(char ch[], int start, int length) throws SAXException {
        currentValue.append(ch, start, length);
//      String trim = new String(ch, start, length).trim();
    }
}
