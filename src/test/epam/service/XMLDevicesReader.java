package test.epam.service;

import java.beans.XMLDecoder;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;

import test.epam.devices.DesktopComputer;
import test.epam.devices.Device;
import test.epam.devices.Smartphone;
import test.epam.devices.TabletComputer;

public abstract class XMLDevicesReader {
	private static ArrayList<Device> result = new ArrayList<Device>();
	private static final Class<Smartphone> SMARTPHONE_CLASS = Smartphone.class;
	private static final Class<DesktopComputer> DESKTOP_CLASS = DesktopComputer.class;
	private static final Class<TabletComputer> TABLET_CLASS = TabletComputer.class;
	
	public static ArrayList<Device> getDevicesList(String in){
		try{
			FileInputStream input = new FileInputStream(in);
			XMLDecoder decoder = new XMLDecoder(input);
			while(result.size() < 3){
				Object obj = decoder.readObject();
				int option = getDeviceCode(obj);
				switch (option) {
				case 1:
					if (containsClass(SMARTPHONE_CLASS)){
						result.add((Smartphone) obj);
					}
					break;
				case 2:
					if (containsClass(DESKTOP_CLASS)){
						result.add((DesktopComputer) obj);
					}
					break;
				case 3:
					if (containsClass(TABLET_CLASS)){
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
		if (obj.getClass() == SMARTPHONE_CLASS){
			return 1;
		}
		if (obj.getClass() == DESKTOP_CLASS){
			return 2;
		}
		if (obj.getClass() == TABLET_CLASS){
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
