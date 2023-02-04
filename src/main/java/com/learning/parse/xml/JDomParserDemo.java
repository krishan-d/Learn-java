package com.learning.parse.xml;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.jdom2.Attribute;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;
import org.jdom2.Document;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;

public class JDomParserDemo {
    public static void main(String[] args) {

        String xmlFileName = "data_directory/xmlExample.xml";
        //jdomParser(xmlFileName);

        createJdomXml();
    }

    static void jdomParser(String xmlFileName) {
        try {
            File inputFile = new File(xmlFileName);

            //Creating a Document Builder
            SAXBuilder saxBuilder = new SAXBuilder();
            //Creating a Document from a file or stream
            Document document = saxBuilder.build(inputFile);

            //Extracting root element
            System.out.println("Root Element: " + document.getRootElement().getName());
            Element classElement = document.getRootElement();

            List<Element> elementList = classElement.getChildren();
            for (Element element : elementList) {
                System.out.println("\nCurrent Element: " + element.getName());

                //Examining attributes
                List<Attribute> attributeList = element.getAttributes();
                for (Attribute a : attributeList) {
                    if (a != null)System.out.println(a.getName() + " " + a.getValue());
                }

                //Examining sub-elements
                System.out.println("First Name: " + element.getChild("firstname").getText());

                List<Element> elementList1 = element.getChildren();
                for (Element e : elementList1) {
                    if (!e.getText().isEmpty()) System.out.println(e.getName() + " " + e.getText());
                }
            }

        } catch (IOException | JDOMException e) {
            e.printStackTrace();
        }
    }

    static void createJdomXml() {
        try {
            //root element
            Element rootElement = new Element("cars");
            Document document = new Document(rootElement);

            //supercars element
            Element subElement = new Element("supercars");
            subElement.setAttribute("company", "Ferrari");

            Element carElement1 = new Element("carname");
            carElement1.setAttribute("Type", "Formula one");
            carElement1.setText("Ferrari 101");

            subElement.addContent(carElement1);
            subElement.addContent(new Element("carname").setAttribute("Type", "Racing car")
                    .setText("Ferrari 202"));

            document.getRootElement().addContent(subElement);

            XMLOutputter xmlOutputter = new XMLOutputter(Format.getPrettyFormat());
            xmlOutputter.output(document, System.out);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
