package test.epam.devices;

import test.epam.devices.service.EquipService;

public class Run {
	/**
	 * @param args first argument is a path to input xml
	 */
	public static void main(String[] args) {
		if (args.length > 0){
			EquipService equip = new EquipService(args[0]);
			equip.equip();
		}
	}
}
