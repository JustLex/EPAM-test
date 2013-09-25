package test.epam.devices.service.xml;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import test.epam.devices.model.Device;
import test.epam.devices.service.Department;

public class XMLBillWriter {
	private Department dept;
	
	public XMLBillWriter(Department dept){
		this.dept = dept;
	}
	
	public void toXML(){
		try {
			DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
			Document out = docBuilder.newDocument();
			
			Element rootElem = out.createElement("bill");
			out.appendChild(rootElem);
			
			for (Device dev : dept.getEquip()) {
				rootElem.appendChild(createNode(dev, dev.getName(), out));
			}
			
			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			Transformer transformer = transformerFactory.newTransformer();
			DOMSource dom = new DOMSource(out);
			
			StreamResult result = new StreamResult(new File("out.xml"));
			transformer.transform(dom, result);
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (TransformerConfigurationException e){
			e.printStackTrace();
		} catch (TransformerException e){
			e.printStackTrace();
		}
	}
	private Element createNode(Device device, String name, Document doc){
		Element out = doc.createElement(name);
		
		Attr cost = doc.createAttribute("cost");
		cost.setValue(device.getCost()*dept.getStaff() + "");
		out.setAttributeNode(cost);
		Attr weight = doc.createAttribute("weight");
		weight.setValue(device.getWeight()*dept.getStaff() + "");
		out.setAttributeNode(weight);
		
		return out;
	}
}
