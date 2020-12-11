package xpathDemo;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class Main {

	public static void main(String[] args) {
		try {
			// Get file as a stream
			FileInputStream fileIS = new FileInputStream("file.xml");
			
			// Instantiate the factory that supplies the DOM parser
			DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
			// Instantiate the DOM parser
			DocumentBuilder domParser = builderFactory.newDocumentBuilder();
			// Load the DOM Document from the XML data using the parser
			Document xmlDocument = domParser.parse(fileIS);
			
			// Instantiate an XPath object which compiles
            // and evaluates XPath expressions.
			XPath xPath = XPathFactory.newInstance().newXPath();
			
			// Load and test an expression
			String expression = "/Tutorials/Tutorial";
			NodeList nodes = (NodeList) xPath.compile(expression).evaluate(xmlDocument, XPathConstants.NODESET);
			// treat results
			for (int i = 0; i < nodes.getLength(); i++) {
			   Node nNode = nodes.item(i);
			   //...
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (XPathExpressionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
