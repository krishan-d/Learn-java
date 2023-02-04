package com.learning.parse.xml;

import javax.xml.namespace.QName;
import javax.xml.stream.*;
import javax.xml.stream.events.*;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.StringWriter;
import java.util.Iterator;

public class StAXParserDemo {
    private static boolean bFirstName, bLastName, bAge, bMarks;

    public static void main(String[] args) {
        String xmlFileName = "data_directory/xmlExample.xml";
        //staxParser(xmlFileName);

        createStaxXmlFile();
    }

    static void staxParser(String xmlFilePath) {

        try {
            //Variable to make sure whether an element in XML is being accessed or not.
            //True : accessed or False : Element has not been used currently.
            bFirstName = bLastName = bAge = bMarks = false;
            //
            XMLInputFactory xmlInputFactory = XMLInputFactory.newInstance();
            //Initializing Handler to access Tags in XML file
            XMLEventReader xmlEventReader = xmlInputFactory.createXMLEventReader(new FileReader(xmlFilePath));

            //Checking availability of the next Tag
            while (xmlEventReader.hasNext()) {
                //Event is actually the Tag. It's of 3 Types:
                //<name> : StartEvent
                //</name>: EndEvent
                //Characters Event : Data between StartEvent and EndEvent
                XMLEvent xmlEvent = xmlEventReader.nextEvent();

                //
                switch (xmlEvent.getEventType()) {
                    //This will trigger when Tag is of Type <...> [StartEvent]
                    case XMLStreamConstants.START_ELEMENT -> {
                        StartElement startElement = (StartElement) xmlEvent;
                        //OR
                        //startElement = xmlEvent.asStartElement();

                        //Iterator for accessing the metadata related the Tag started.
                        Iterator<Attribute> iterator = startElement.getAttributes();
                        while (iterator.hasNext()) {
                            Attribute attribute = iterator.next();
                            QName name = attribute.getName();
                            String value = attribute.getValue();
                            System.out.println(name + " = " + value);
                        }

                        //Checking which Tag needs to be opened for reading.
                        //If Tag matches then the boolean of that Tag is set to be true.
                        String name = startElement.getName().getLocalPart();
                        if (name.equalsIgnoreCase("firstname")) bFirstName = true;
                        else if (name.equalsIgnoreCase("lastname")) bLastName = true;
                    }

                    //Triggers when there is data after the tag which is currently opened.
                    case XMLStreamConstants.CHARACTERS -> {
                        //Depending upon the Tag opened, data is retrieved.
                        Characters element = xmlEvent.asCharacters();
                        if (bFirstName) System.out.println(element.getData());
                        else if (bLastName) System.out.println(element.getData());
                    }

                    //Triggers when Tag is type of </...> [EndEvent]
                    case XMLStreamConstants.END_ELEMENT -> {
                        EndElement endElement = xmlEvent.asEndElement();

                        //Checking which Tag needs to be closed after reading.
                        //If Tag matches then, boolean of that Tag is set to be false.
                        String name = endElement.getName().getLocalPart();
                        if (name.equalsIgnoreCase("firstname")) bFirstName = false;
                        else if (name.equalsIgnoreCase("lastname")) bLastName = false;
                        else if (name.equalsIgnoreCase("student")) System.out.println();
                    }
                }
            }
        } catch (XMLStreamException | FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    static void createStaxXmlFile() {
        try {
            StringWriter stringWriter = new StringWriter();

            XMLOutputFactory xmlOutputFactory = XMLOutputFactory.newInstance();
            //XMLStreamWriter interface specifies methods for creating an event.
            XMLStreamWriter xmlStreamWriter = xmlOutputFactory.createXMLStreamWriter(stringWriter);

            xmlStreamWriter.writeStartDocument();
            xmlStreamWriter.writeStartElement("cars");

            xmlStreamWriter.writeStartElement("supercars");
            xmlStreamWriter.writeAttribute("company", "Ferrari");

            xmlStreamWriter.writeStartElement("carname");
            xmlStreamWriter.writeAttribute("type", "Formula one");
            xmlStreamWriter.writeCharacters("Ferrari 101");
            xmlStreamWriter.writeEndElement();

            xmlStreamWriter.writeEndElement();
            xmlStreamWriter.writeEndDocument();

            xmlStreamWriter.flush();
            xmlStreamWriter.close();

            String xmlString = stringWriter.getBuffer().toString();
            stringWriter.close();
            System.out.println("xmlString = " + xmlString);

        } catch (XMLStreamException | IOException e) {
            e.printStackTrace();
        }
    }
}
