package main;

import java.beans.XMLDecoder;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

import devices.DesktopComputer;
import devices.Smartphone;
import devices.TabletComputer;

public class Equip {
	private static Smartphone restoredS;
	private static DesktopComputer restoredD;
	private static TabletComputer restoredT;
	private static final Class<Smartphone> SMARTPHONE_CLASS = Smartphone.class;
	private static final Class<DesktopComputer> DESKTOP_CLASS = DesktopComputer.class;
	private static final Class<TabletComputer> TABLET_CLASS = TabletComputer.class;
	/**
	 * @param args first argument is a path to input xml
	 */
	public static void main(String[] args) {
		try {
			FileInputStream input = new FileInputStream(args[0]);
			XMLDecoder decoder = new XMLDecoder(input);
			decodeDevices(decoder);
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			System.out.println("Input staff count");
			int staff = Integer.parseInt(reader.readLine());
			Department dept = new Department(staff, restoredD,
					restoredT, restoredS);
			
			dept.toXML();
		} catch (FileNotFoundException e) {
			System.out.println("File not found");
		} catch (IOException e){
			System.out.println("Bad input");
		} catch (NumberFormatException e){
			System.out.println("Bad input");
		}
	}
	private static void decodeDevices(XMLDecoder decoder){
		try{
			while(restoredD == null || restoredS == null || restoredT == null){
				Object obj = decoder.readObject();
				int option = getDeviceCode(obj);
				switch (option) {
				case 1:
					if (restoredS == null){
						restoredS = (Smartphone) obj;
					}
					break;
				case 2:
					if (restoredD == null){
						restoredD = (DesktopComputer) obj;
					}
					break;
				case 3:
					if (restoredT == null){
						restoredT = (TabletComputer) obj;
					}
				default:
					break;
				}
			}
		} catch(ArrayIndexOutOfBoundsException e){
			System.out.println("XML doesnt consist nessesary classes");
			System.exit(1);
		}
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
}
