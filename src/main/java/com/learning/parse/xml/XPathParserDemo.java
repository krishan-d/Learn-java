package com.learning.parse.xml;

import org.w3c.dom.Element;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;
import java.io.File;
import java.io.IOException;

public class XPathParserDemo {
    public static void main(String[] args) {

        String xmlFileName = "data_directory/xmlExample.xml";
        xPathParser(xmlFileName);
    }

    static void xPathParser(String xmlFileName) {
        try {
            File inputFile = new File(xmlFileName);
            //Creating DocumentBuilder
            DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();

            //Creating a Document from a file or stream
            Document document = documentBuilder.parse(inputFile);
            document.getDocumentElement().normalize();

            //Building XPath
            XPath xPath = XPathFactory.newInstance().newXPath();

            //Preparing Path expression and evaluate
            String expression = "/class/student";
            NodeList nodeList = (NodeList) xPath.compile(expression).evaluate(document, XPathConstants.NODESET);

            //Iterating over NodeList
            for (int i = 0; i < nodeList.getLength(); i++) {
                Node node = nodeList.item(i);
                System.out.println("\nCurrent Element: " + node.getNodeName());

                if (node.getNodeType() != Node.ELEMENT_NODE) continue;

                Element element = (Element) node;
                //Examining Attributes
                System.out.println(element.getAttribute("id"));

                //Examining sub-elements
                System.out.println("First Name: " + element.getElementsByTagName("firstname").item(0).
                        getTextContent());
                //OR using getChildNodes()
                NodeList nodeList1 = element.getChildNodes();
                for (int k = 0; k < nodeList1.getLength(); k++) {
                    Node node1 = nodeList1.item(k);
                    if (node1.getNodeType() != Node.ELEMENT_NODE) continue;
                    System.out.println(node1.getNodeName() + " : " + node1.getTextContent());
                }
            }
        } catch (ParserConfigurationException | IOException | SAXException | XPathExpressionException e) {
            e.printStackTrace();
        }
    }
}
