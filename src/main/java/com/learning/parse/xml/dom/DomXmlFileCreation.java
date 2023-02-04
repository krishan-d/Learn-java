package com.learning.parse.xml.dom;

import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;

public class DomXmlFileCreation {
    public static void main(String[] args) throws ParserConfigurationException, TransformerException {
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
        Document doc = dBuilder.newDocument();

        Element rootElement = doc.createElement("cars");
        doc.appendChild(rootElement);

        // supercars element
        Element supercar = doc.createElement("supercars");
        rootElement.appendChild(supercar);

        // setting attribute to element
        Attr attr = doc.createAttribute("company");
        attr.setValue("Ferrari");
        supercar.setAttributeNode(attr);

        // carName element
        Element carName = doc.createElement("carName");
        Attr attrType = doc.createAttribute("type");
        attrType.setValue("formula one");
        carName.setAttributeNode(attrType);
        carName.appendChild(doc.createTextNode("Ferrari 101"));
        supercar.appendChild(carName);

        Element carName1 = doc.createElement("carname");
        Attr attrType1 = doc.createAttribute("type");
        attrType1.setValue("sports");
        carName1.setAttributeNode(attrType1);
        carName1.appendChild(doc.createTextNode("Ferrari 202"));
        supercar.appendChild(carName1);


        // write the content into xml file
        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        DOMSource source = new DOMSource(doc);
        StreamResult result = new StreamResult(new File("data_directory/cars.xml"));
        transformer.transform(source, result);

        // Output to console for testing
        StreamResult consoleResult = new StreamResult(System.out);
        transformer.transform(source, consoleResult);
    }
}
