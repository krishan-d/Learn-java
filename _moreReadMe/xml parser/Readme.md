### XML:
- XML is a markup language.
- XML is a tag based language like HTML.
- XML tags are not predefined like HTML.
- You can define your own tags which is why it is called extensible language.
- XML tags are designed to be self-descriptive.
- XML is W3C Recommendation for data storage and data transfer.

### Advantages:
- **Technology-agnostic** − Being plain text, XML is technology independent. It can be used by any technology for data
  storage and data transfer purpose.
- **Human-readable** − XML uses simple text format. It is human-readable and understandable.
- **Extensible** − In XML, custom tags can be created and used very easily.
- **Allow Validation** − Using XSD, DTD and XML structures can be validated easily.

### XML Parsers:
XML Parser provides a way to access or modify data in an XML document.
Types of parsers which are commonly used to parse XML documents.

- **Dom Parser −** Parses an XML document by loading the complete contents of the document and creating its complete
hierarchical tree in memory.

- **SAX Parser −** Parses an XML document on event-based triggers. Does not load the complete document into the memory.

- **JDOM Parser −** Parses an XML document in a similar fashion to DOM parser but in an easier way.

- **StAX Parser −** Parses an XML document in a similar fashion to SAX parser but in a more efficient way.

- **XPath Parser −** Parses an XML document based on expression and is used extensively in conjunction with XSLT.

- **DOM4J Parser −** A java library to parse XML, XPath, and XSLT using Java Collections Framework. It provides support
  for DOM, SAX, and JAXP.


### JDOM Parser
JDOM is an open source, Java-based library to parse XML documents. It is typically a Java developer friendly API.
It is Java optimized, and it uses Java collections like List and Arrays.

JDOM works with DOM and SAX APIs and combines the best of the two. It is of low memory footprint and is nearly as fast as SAX.

### When To Use?
- You need to know a lot about the structure of an XML document.

- You need to move parts of an XMl document around (you might want to sort certain elements, for example).

- You need to use the information in an XML document more than once.

- You are a Java developer and want to leverage Java optimized parsing of XML.


### StAX Parser
StAX is a Java-based API to parse XML document in a similar way as SAX parser does. But with differences:

- StAX is a PULL API, whereas SAX is a PUSH API. It means in case of StAX parser, a client application needs to ask the
  StAX parser to get information from XML whenever it needs. But in case of SAX parser, a client application is required
  to get information when SAX parser notifies the client application that information is available.
- StAX API can read as well as write XML documents. Using SAX API, an XML file can only be read.

### Advantages/ When To Use?
- Process XML document in a linear fashion from top to down.
- The document is not deeply nested.
- You are processing a very large XML document whose DOM tree would consume too much memory. Typical DOM implementations
  use ten bytes of memory to represent one byte of XML.
- The problem to be solved involves only a part of the XML document.
- Data is available as soon as it is seen by the parser, so StAX works well for an XML document that arrives over a 
  stream.

### Disadvantages:
- We have no random access to an XML document, since it is processed in a forward-only manner.
- If you need to keep track of data that the parser has seen or where the parser has changed the order of items, then you 
  must write the code and store the data on your own.

### StAX vs SAX
**SAX**: 
The SAX is a push model API which means that it is the API which calls your handler, not your handler that calls the 
API . The SAX parser thus “pushes” events into your handler. With this push model of API you have no control over how 
and when the parser iterates over the file. Once you start the parser, it iterates all the way until the end, calling 
your handler for each and every XML event in the input XML document.

SAX Parser --> Handler

**StAX**:
The StAX pull model means that it is your “handler” class that calls the parser API , not the other way around.
Thus, your handler class controls when the parser is to move on to the next event in the input. In other words, your
handler “pulls” the XML events out of the parser. Additionally, you can stop the parsing at any point. The StAX parser
is generally used instead of a file reader , when the input or database is given in the form of offline or online xml
file. The pull model of is summarized like this:

Handler --> StAX Parser

### XPath Parser

- **Structure Definitions** − XPath defines the parts of an XML document like element, attribute, text, namespace, 
  processing-instruction, comment, and document nodes.

- **Path Expressions** − XPath provides powerful path expressions such as select nodes or list of nodes in XML documents.

- **Standard Functions** − XPath provides a rich library of standard functions for manipulation of string values, 
  numeric values, date and time comparison, node and QName manipulation, sequence manipulation, Boolean values, etc.

- **Major part of XSLT** − XPath is one of the major elements in XSLT standard and one must have sufficient knowledge 
  of XPath in order to work with XSLT documents.

- **W3C recommendation** − XPath is official recommendation of World Wide Web Consortium (W3C).

