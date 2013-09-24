package test.epam.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import test.epam.devices.Device;

public class Equip {
	/**
	 * @param args first argument is a path to input xml
	 */
	public static void main(String[] args) {
		try {
			ArrayList<Device> equip = XMLDevicesReader.getDevicesList(args[0]);
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
