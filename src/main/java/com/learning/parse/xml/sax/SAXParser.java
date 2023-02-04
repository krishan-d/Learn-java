package com.learning.parse.xml.sax;

import org.xml.sax.InputSource;

import javax.xml.parsers.SAXParserFactory;
import java.io.StringReader;

public class SAXParser {
    public static void main(String[] args) {
        String outputXML = "<?xml version=\"1.0\"?>\n" +
                "<Company>\n" +
                "<emp id=\"10024\">\n" +
                "<name>Edwina Eve</name>\n" +
                "<pay>1000000</pay>\n" +
                "<bio>None None</bio>\n" +
                "</emp>\n" +
                "<emp id=\"27980\">\n" +
                "<name>Nidhi</name>\n" +
                "<pay>3400000</pay>\n" +
                "<bio>LOOK & BUY </bio>\n" +
                "</emp>\n" +
                "</Company>";
        outputXML = outputXML.replace("&", "&amp;");
        System.out.println(outputXML);

        new SAXParser().parseXml(outputXML);
    }

    public void parseXml(String xml) {
        try {
            SAXParserFactory factory = SAXParserFactory.newInstance();
//          factory.setNamespaceAware(true);
            javax.xml.parsers.SAXParser saxParser = factory.newSAXParser();
            XMLHandler handler = new XMLHandler();
            saxParser.parse(new InputSource(new StringReader(xml)), handler);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

