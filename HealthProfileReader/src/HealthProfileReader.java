//This program has the following methods:
//	.getPeople()-used to print all of the person in the database
//	.getPersonHealthprofile()-used to display the health profile of a person by using the person's id
//  .getWeight()-is used to display the weight of a person based on the given first and last name of the person
//  .getWeight()-is used to display the height of a person based on the given first and last name of the person
//	.getPeopleWeightCategory()-accepts weight and a condition to test and  helps to list out individuals who fulfills the condition

import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class HealthProfileReader {
	
	Document doc;
    XPath xpath;

    public void loadXML() throws ParserConfigurationException, SAXException, IOException {

        DocumentBuilderFactory domFactory = DocumentBuilderFactory.newInstance();
        domFactory.setNamespaceAware(true);
        DocumentBuilder builder = domFactory.newDocumentBuilder();
        doc = builder.parse("MyPeople.xml");
        //creating xpath object
        getXPathObj();
    }
    public XPath getXPathObj() {

        XPathFactory factory = XPathFactory.newInstance();
        xpath = factory.newXPath();
        return xpath;
    }
    //getPeople() method is used to display each persons profile in the MyPeople.xml 
    public Node getPeople() throws XPathExpressionException {

        XPathExpression expr = xpath.compile("/people");
        Node node = (Node) expr.evaluate(doc, XPathConstants.NODE);
        return node;
    }	
  //getPersonHealthprofile(String id) method accepts Id number as a input 
  //and displays persons profile that matches with the give Id from the MyPeople.xml
    public Node getPersonHealthprofile(String id) throws XPathExpressionException {

        XPathExpression expr = xpath.compile("//person[attribute::id='" + id + "']/healthprofile");
        Node node = (Node) expr.evaluate(doc, XPathConstants.NODE);
        return node;
    }
    //getWeight(String firstname, String lastname) method accepts first and last name and displays the weight 
    public Node getWeight(String firstname, String lastname) throws XPathExpressionException {

        XPathExpression expr = xpath.compile("//person[firstname ='" + firstname + "'] | //person[lastname ='" + lastname + "']|//weight");
        Node node = (Node) expr.evaluate(doc, XPathConstants.NODE);
        return node;
    }
    
  //getHeight(String firstname, String lastname) method accepts first and last name and displays the height
    public Node getHeight(String firstname, String lastname) throws XPathExpressionException {

    	XPathExpression expr = xpath.compile("//person[firstname ='" + firstname + "'] | //person[lastname ='" + lastname + "']|//height");
        Node node = (Node) expr.evaluate(doc, XPathConstants.NODE);
        return node;

    }
    //getPeopleWeightCategory(double weight, String condition) method accepts weight and condition
    //and displays the health profile of individuals who fulfill the given condition
    public NodeList getPeopleWeightCategory(double weight, String condition) throws XPathExpressionException {

        XPathExpression expr = xpath.compile("//healthprofile[weight " + condition + "'" + weight + "']");
        NodeList nodes = (NodeList) expr.evaluate(doc, XPathConstants.NODESET);
        return nodes
        		;
    }

    @SuppressWarnings("resource")
	public static void main(String[] args) throws ParserConfigurationException, SAXException,
            IOException, XPathExpressionException {
    	HealthProfileReader test = new HealthProfileReader();
    	test.loadXML();
    	//getting all the people that are in the Database
    	test.getPeople();
    	 	Node node = test.getPeople();
	        System.out.println("Node name: " + node.getNodeName());
	        System.out.println(node+" Childrens text contents :" + node.getTextContent());
    	System.out.println(" ");
    	//getting People Health profile having Id Number 5
    	test.getPersonHealthprofile("5");
	    	System.out.println("Health Profile of a Person with Id: " + "5");
	        node = test.getPersonHealthprofile("5");
	        System.out.println(node.getTextContent());
    	System.out.println(" ");
    	//getting list of people whose weight is greater than 90 Kg 
    	test.getPeopleWeightCategory(90, ">");
	    	NodeList nodes = test.getPeopleWeightCategory(90, ">");
	        System.out.println("List of Person(s) having weight " + ">" + " "+ 90 + " Kg");
	        for (int i=0; i< nodes.getLength();i++)
	        {
		        System.out.println("Person-"+i);
		        System.out.println(nodes.item(i).getTextContent());
	        }
    }

}