package main;

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

import devices.DesktopComputer;
import devices.Device;
import devices.Smartphone;
import devices.TabletComputer;

public class Department {
	private int staff;
	private DesktopComputer desktop;
	private TabletComputer tablet;
	private Smartphone smartphone;
	
	public Department(int staff, DesktopComputer desktop,
			TabletComputer tablet, Smartphone smartphone) {
		super();
		this.staff = staff;
		this.desktop = desktop;
		this.tablet = tablet;
		this.smartphone = smartphone;
	}

	public int getStaff() {
		return staff;
	}

	public DesktopComputer getDesktop() {
		return desktop;
	}

	public TabletComputer getTablet() {
		return tablet;
	}

	public Smartphone getSmartphone() {
		return smartphone;
	}
	
	public void toXML(){
		try {
			DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
			Document out = docBuilder.newDocument();
			
			Element rootElem = out.createElement("bill");
			out.appendChild(rootElem);
			
			rootElem.appendChild(createNode(smartphone, "smartphones", out));
			rootElem.appendChild(createNode(tablet, "tablets", out));
			rootElem.appendChild(createNode(desktop, "desktops", out));
			
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
		cost.setValue(device.getCost()*staff + "");
		out.setAttributeNode(cost);
		Attr weight = doc.createAttribute("weight");
		weight.setValue(device.getWeight()*staff + "");
		out.setAttributeNode(weight);
		
		return out;
	}
}
