package test.epam.devices.service.xml;

import java.beans.XMLDecoder;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;

import test.epam.devices.model.DesktopComputer;
import test.epam.devices.model.Device;
import test.epam.devices.model.Smartphone;
import test.epam.devices.model.TabletComputer;


public abstract class XMLDevicesReader {
	private static ArrayList<Device> result = new ArrayList<Device>();
	
	public static ArrayList<Device> getDevicesList(String in){
		try{
			FileInputStream input = new FileInputStream(in);
			XMLDecoder decoder = new XMLDecoder(input);
			while(result.size() < 3){
				Object obj = decoder.readObject();
				int option = getDeviceCode(obj);
				switch (option) {
				case 1:
					if (containsClass(Smartphone.class)){
						result.add((Smartphone) obj);
					}
					break;
				case 2:
					if (containsClass(DesktopComputer.class)){
						result.add((DesktopComputer) obj);
					}
					break;
				case 3:
					if (containsClass(TabletComputer.class)){
						result.add((TabletComputer) obj);
					}
				default:
					break;
				}
			}
			return result;
		} catch(ArrayIndexOutOfBoundsException e){
			System.out.println("XML doesnt consist nessesary classes");
			System.exit(1);
		} catch (FileNotFoundException e){
			System.out.println("File not found");
			System.exit(1);
		}
		return null;
	}
	private static int getDeviceCode(Object obj){
		if (obj.getClass() == Smartphone.class){
			return 1;
		}
		if (obj.getClass() == DesktopComputer.class){
			return 2;
		}
		if (obj.getClass() == TabletComputer.class){
			return 3;
		}
		return 0;
	}
	@SuppressWarnings("rawtypes")
	private static boolean containsClass(Class c){
		for (Device dev : result) {
			if (dev.getClass() == c){
				return false;
			}
		}
		return true;
	}
}
