package vasiuk;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;

public class XMLparser extends Thread implements Runnable {
    protected static void parserXML(String name) throws ParserConfigurationException, IOException, SAXException {
        Check check = new Check();
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();

        Document document = builder.parse(new File(name));
        Element element = document.getDocumentElement();
        NodeList nodeList = element.getElementsByTagName("request");

        for (int i = 0; i < nodeList.getLength(); i++) {
            Node nNode = nodeList.item(i);
            if (nodeList.item(i) instanceof Element) {
                Element eElement = (Element) nNode;
                if (eElement.getElementsByTagName("clientId").item(0).getTextContent() != null){
                    check.AddId(eElement.getElementsByTagName("clientId").item(0).getTextContent());
                }
                else System.out.println("Nie poprawny format clientID");
                if(eElement.getElementsByTagName("requestId").item(0).getTextContent() != null) {
                    check.AddRequest(Long.parseLong(eElement.getElementsByTagName("requestId").item(0).getTextContent()));
                }
                else System.out.println("Nie poprawny format requestID");
                if(eElement.getElementsByTagName("name").item(0).getTextContent() != null) {
                    check.AddName(eElement.getElementsByTagName("name").item(0).getTextContent());
                }
                else System.out.println("Nie poprawny format name");
                if(eElement.getElementsByTagName("quantity").item(0).getTextContent() != null) {
                    check.AddQuantity(Integer.parseInt(eElement.getElementsByTagName("quantity").item(0).getTextContent()));
                }
                else System.out.println("Nie poprawny format Quantity");
                if(eElement.getElementsByTagName("price").item(0).getTextContent() != null) {
                    check.AddPrice(Double.parseDouble(eElement.getElementsByTagName("price").item(0).getTextContent()));
                }
                else System.out.println("Nie poprawny format Price");
            }
        }
    }
}


