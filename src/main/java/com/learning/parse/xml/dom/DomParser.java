package com.learning.parse.xml.dom;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.XMLConstants;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;

public class DomParser {

    //DOM Parser
    /*
    STEPS TO USE DOM:
    1.Import XML related packages
        org.w3c.dom.*
        javax.xml.parsers.*
        java.io.*
    2.Create DocumentBuilder
    3.Create Document from a File or stream
    4.Extract root element
    5.Examine attributes
    6.Examine sub-elements
    */

    public static void main(String[] args) {
        //domParserDemo();
        new DomParser().queryXmlFileDemo();
    }

    private Document createDocument(String xmlFileName) {
        Document doc = null;
        try {
            File inputFile = new File(xmlFileName);
            //Creating DocumentBuilder
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newNSInstance();
            dbFactory.setFeature(XMLConstants.FEATURE_SECURE_PROCESSING, true);
            DocumentBuilder documentBuilder = dbFactory.newDocumentBuilder();

            //Creating Document From a File or Stream
            doc = documentBuilder.parse(inputFile);

            //Using Stream
            /*
            StringBuilder xmlStringBuilder = new StringBuilder();
            xmlStringBuilder.append("<?xml version=\"1.0\"?> <class> </class>");
            ByteArrayInputStream inputStream = new ByteArrayInputStream(xmlStringBuilder.toString().getBytes(StandardCharsets.UTF_8));
            Document document = documentBuilder.parse(inputStream);
            */
        } catch (ParserConfigurationException | IOException | SAXException e) {
            e.printStackTrace();
        }
        return doc;
    }

    static void domParserDemo() {
        try {
            File inputFile = new File("data_directory/xmlExample.xml");
            //Creating DocumentBuilder
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newNSInstance();
            dbFactory.setFeature(XMLConstants.FEATURE_SECURE_PROCESSING, true);
            DocumentBuilder documentBuilder = dbFactory.newDocumentBuilder();
            Document doc = documentBuilder.parse(inputFile);
            doc.getDocumentElement().normalize();

            Element root = doc.getDocumentElement();
            System.out.println("Root: " + root.getNodeName());

            NodeList nodeList = doc.getElementsByTagName("student");

            for (int i = 0; i < nodeList.getLength(); i++) {
                Node node = nodeList.item(i);
                System.out.println("Current Element: " + node.getNodeName());

                if  (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element element = (Element) node;
                    //Examine Attributes:
                    System.out.println("Id: " + element.getAttribute("id"));
                    System.out.println("getAttributes: " + element.getAttributes());
                    //Examine sub-elements:
                    System.out.println("First Name: " + element.getElementsByTagName("firstname").item(0).getTextContent());
                    System.out.println("getChildNodes: " + element.getChildNodes());
                }
            }
        } catch (ParserConfigurationException | IOException | SAXException e) {
            e.printStackTrace();
        }
    }

    public void queryXmlFileDemo() {
        String xmlFileName = "data_directory/queryXmlFileExample.xml";
        Document doc = createDocument(xmlFileName);
        if (doc == null) return;
        doc.getDocumentElement().normalize();
        System.out.println("Root: " + doc.getDocumentElement().getNodeName());

        NodeList nodeList = doc.getElementsByTagName("supercars");

        for (int i = 0; i < nodeList.getLength(); i++) {
            Node node = nodeList.item(i);
            System.out.println("Current Element: " + node.getNodeName());

            if  (node.getNodeType() == Node.ELEMENT_NODE) {
                Element element = (Element) node;
                System.out.println("company: " + element.getAttribute("company"));

                NodeList carNameList = element.getElementsByTagName("carname");

                for (int k = 0; k < carNameList.getLength(); k++) {
                    Node node1 = carNameList.item(k);
                    if (node1.getNodeType() == Node.ELEMENT_NODE) {
                        Element car = ((Element) node1);
                        System.out.println("Car Name: " + car.getTextContent());
                        System.out.println("Car Type: " + car.getAttribute("type"));
                    }
                }
            }
        }
    }
}
