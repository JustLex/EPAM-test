package test.epam.devices.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import test.epam.devices.model.Device;
import test.epam.devices.service.xml.XMLBillWriter;
import test.epam.devices.service.xml.XMLDevicesReader;

public class Equip {
	private String path;
	
	public Equip(String path){
		this.path = path;
	}
	
	public void equip(){
		try {
			ArrayList<Device> equip = XMLDevicesReader.getDevicesList(path);
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			System.out.println("Input staff count");
			int staff = Integer.parseInt(reader.readLine());
			Department dept = new Department(staff, equip);		
			new XMLBillWriter(dept).toXML();
		} catch (IOException e){
			System.out.println("Bad input");
		} catch (NumberFormatException e){
			System.out.println("Bad input");
		}
	}
}
